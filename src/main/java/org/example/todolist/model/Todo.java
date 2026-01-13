package org.example.todolist.model;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


public record Todo(
        @Id

        Integer id,
        @NotBlank
        String content,
        @NotBlank
        Status status,
        @NotBlank
        LocalDateTime created_at,
        LocalDateTime updated_at
) {

}
