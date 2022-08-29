package ro.fasttrackit.students.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ro.fasttrackit.commons.page.CollectionResponse;
import ro.fasttrackit.commons.page.PageInfo;
import ro.fasttrackit.students.client.dto.Student;
import ro.fasttrackit.students.model.StudentEntity;
import ro.fasttrackit.students.model.mappers.StudentMapper;
import ro.fasttrackit.students.service.StudentService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping
    public CollectionResponse<Student> getAll(Pageable pageable){
        Page<StudentEntity> page = service.getAll(pageable);
        return CollectionResponse.<Student>builder()
                .items(mapper.toApi(page.getContent()))
                .pageInfo(PageInfo.builder().build())
                .build();
    }
}
