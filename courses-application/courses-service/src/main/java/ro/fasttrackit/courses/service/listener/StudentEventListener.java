package ro.fasttrackit.courses.service.listener;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import ro.fasttrackit.courses.service.StudentCourseService;
import ro.fasttrackit.students.client.event.StudentEvent;

@Slf4j
@Component
@RabbitListener(queues = "students-events")
@RequiredArgsConstructor
public class StudentEventListener {
    private final StudentCourseService studentCourseService;

    @RabbitHandler
    void handleStudentEvent(StudentEvent event) {
        log.info("Received " + event);
        studentCourseService.firstEnrolment(event.student());
    }

}
