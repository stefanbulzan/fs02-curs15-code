package ro.fasttrackit.students.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.commons.page.CollectionResponse;
import ro.fasttrackit.commons.page.PageInfo;
import ro.fasttrackit.students.client.dto.Student;
import ro.fasttrackit.students.model.StudentEntity;
import ro.fasttrackit.students.model.mappers.StudentMapper;
import ro.fasttrackit.students.service.StudentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("students")
public class StudentController {
    private final StudentService service;
    private final StudentMapper mapper;

    @GetMapping
    CollectionResponse<Student> getAll(Pageable pageable) {
        Page<StudentEntity> page = service.getAll(pageable);
        return CollectionResponse.<Student>builder()
                .items(mapper.toApi(page.getContent()))
                .pageInfo(PageInfo.builder()
                        .page(page.getNumber())
                        .size(page.getSize())
                        .totalPages(page.getTotalPages())
                        .totalSize((int) page.getTotalElements())
                        .build())
                .build();
    }

    @PostMapping
    Student addStudent(@RequestBody Student student) {
        return mapper.toApi(
                service.add(
                        mapper.toEntity(student)));
    }
}
