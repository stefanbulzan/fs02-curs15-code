package ro.fasttrackit.students.model.mappers;

import org.mapstruct.Mapper;
import ro.fasttrackit.students.client.dto.Student;
import ro.fasttrackit.students.model.StudentEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    List<Student> toApi(List<StudentEntity> students);
}
