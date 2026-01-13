package org.example.todolist.config;

import org.example.todolist.model.Todo;
import org.example.todolist.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.util.List;

@Component

public class DataLoader implements CommandLineRunner {

    private final ObjectMapper objectMapper;
    private final TodoRepository todoRepository;

    public DataLoader (ObjectMapper objectMapper, TodoRepository todoRepository){
        this.objectMapper = objectMapper;
        this.todoRepository = todoRepository;
    }
    @Override
    public  void run(String... args) throws Exception{

    try (InputStream inputStream = TypeReference.class.getResourceAsStream("/data/todo.json")){
        todoRepository.saveAll(objectMapper.readValue(inputStream, new TypeReference<List<Todo>>(){}));

    }
}
}
