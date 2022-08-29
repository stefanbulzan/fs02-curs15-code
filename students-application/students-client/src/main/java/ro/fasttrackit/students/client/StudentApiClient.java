package ro.fasttrackit.students.client;

import org.springframework.web.client.RestTemplate;
import ro.fasttrackit.students.client.dto.Student;

public class StudentApiClient {
    private final String url;

    public StudentApiClient(String url) {
        this.url = url;
    }

    public Student add(Student student) {
        RestTemplate rest = new RestTemplate();
        return rest.postForObject(
                url + "/students",
                student,
                Student.class);
    }
}
