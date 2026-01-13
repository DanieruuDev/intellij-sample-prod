package org.example.todolist.controller;

import org.example.todolist.config.TodoProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SampleController {
    private final TodoProperties properties;


    public SampleController(TodoProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/")
    public TodoProperties greeting(){
        return properties;
    }
}
