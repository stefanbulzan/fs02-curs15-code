package ro.fasttrackit.students.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ro.fasttrackit.students.model.StudentEntity;

public interface StudentRepository extends MongoRepository<StudentEntity, String> {
}
