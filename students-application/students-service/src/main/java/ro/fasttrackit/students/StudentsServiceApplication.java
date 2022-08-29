package ro.fasttrackit.students;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.students.model.StudentEntity;
import ro.fasttrackit.students.repository.StudentRepository;

import java.util.List;

@SpringBootApplication
public class StudentsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentsServiceApplication.class, args);
    }

//    @Bean
    CommandLineRunner atStartup(StudentRepository repo) {
        return args -> {
            repo.saveAll(List.of(
                    new StudentEntity(null, "Maria", 30),
                    new StudentEntity(null, "Ion", 35),
                    new StudentEntity(null, "Darius", 23),
                    new StudentEntity(null, "Cornel", 45),
                    new StudentEntity(null, "Ana", 13)
            ));
        };
    }
}
