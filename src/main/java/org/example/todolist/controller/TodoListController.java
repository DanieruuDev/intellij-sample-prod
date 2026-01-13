package org.example.todolist.controller;

import jakarta.validation.Valid;
import org.example.todolist.model.Todo;
import org.example.todolist.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin
public class TodoListController {
    private final TodoRepository t;

    public TodoListController (TodoRepository t){
        this.t = t;
    }

    @GetMapping("")
    public List<Todo> findAll (){
        return t.findAll();
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable Integer id){
        return t.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo Not Found"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create(@Valid @RequestBody Todo todo) {
        t.save(todo);
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("")
    public void update(@Valid @RequestBody Todo todo){
        if (!t.existsById(todo.id())) {
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        t.save(todo);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!t.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Content not found");
        }
        t.deleteById(id);
    }


}
