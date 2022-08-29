package ro.fasttrackit.students.client.event;

import lombok.Builder;
import ro.fasttrackit.students.client.dto.Student;

@Builder
public record StudentEvent(
        StudentEventType type,
        Student student
) {
}
