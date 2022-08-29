package ro.fasttrackit.students.model;


import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder(toBuilder = true)
@Document(collection = "students")
public record StudentEntity(
        @Id
        String id,
        String name,
        int age
) {
}
