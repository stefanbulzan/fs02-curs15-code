package ro.fasttrackit.students.model;


import lombok.Builder;
import lombok.With;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@With
@Builder(toBuilder = true)
@Document(collection = "students")
public record StudentEntity(
        @Id
        String id,
        String name,
        int age
) {
}
