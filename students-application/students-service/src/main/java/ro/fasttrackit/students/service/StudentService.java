package ro.fasttrackit.students.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ro.fasttrackit.students.client.dto.Student;
import ro.fasttrackit.students.model.StudentEntity;
import ro.fasttrackit.students.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Page<StudentEntity> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
