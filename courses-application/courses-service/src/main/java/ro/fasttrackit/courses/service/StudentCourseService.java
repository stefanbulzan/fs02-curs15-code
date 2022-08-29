package ro.fasttrackit.courses.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.fasttrackit.students.client.dto.Student;

@Slf4j
@Service
@RequiredArgsConstructor
public class StudentCourseService {
    public void firstEnrolment(Student student) {
        log.info("Enrolling in introductory courses : " + student);
    }
}
