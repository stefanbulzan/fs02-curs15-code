package ro.fasttrackit.students.client.dto;

import lombok.Builder;

@Builder(toBuilder = true)
public record Student (
        String id,
        String name,
        int age
){
}
