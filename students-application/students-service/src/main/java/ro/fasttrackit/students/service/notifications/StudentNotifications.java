package ro.fasttrackit.students.service.notifications;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import ro.fasttrackit.students.client.event.StudentEvent;
import ro.fasttrackit.students.model.StudentEntity;
import ro.fasttrackit.students.model.mappers.StudentMapper;

import static ro.fasttrackit.students.client.event.StudentEventType.ADD;

@Service
@RequiredArgsConstructor
public class StudentNotifications {
    private final RabbitTemplate rabbit;
    private final TopicExchange exchange;
    private final StudentMapper mapper;

    public void emitStudentAdd(StudentEntity student) {
        rabbit.convertAndSend(exchange.getName(), "students.add", StudentEvent.builder()
                .student(mapper.toApi(student))
                .type(ADD)
                .build());
    }
}

