package ro.fasttrackit.students.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ro.fasttrackit.students.model.StudentEntity;
import ro.fasttrackit.students.repository.StudentRepository;
import ro.fasttrackit.students.service.notifications.StudentNotifications;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;
    private final StudentNotifications notifications;

    public Page<StudentEntity> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public StudentEntity add(StudentEntity toEntity) {
        StudentEntity savedStudent = repository.save(toEntity.withId(null));
        notifications.emitStudentAdd(savedStudent);
        return savedStudent;
    }
}
