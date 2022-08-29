package ro.fasttrackit.students.client;

import org.junit.jupiter.api.Test;
import ro.fasttrackit.students.client.dto.Student;

//@Disabled
class StudentApiClientIT {
    @Test
    void testAddStudent() {
        StudentApiClient client = new StudentApiClient("http://localhost:8080");
        System.out.println(client.add(new Student(null, "Quintus", 103)));
    }

}