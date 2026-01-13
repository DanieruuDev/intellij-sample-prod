package org.example.todolist.repository;

import org.example.todolist.model.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodolistCollectionRepository {
    private final List<Todo> todoList;

    public TodolistCollectionRepository(List<Todo> todoList) {
        this.todoList = todoList;
    }

    public List<Todo> findAll(){
        return todoList;
    }

    public Optional<Todo> findById(Integer id) {
        return todoList.stream().filter(t -> t.id().equals(id)).findFirst();
    }

    public void save(Todo todo){
            todoList.removeIf(c->c.id().equals(todo.id()));
            todoList.add(todo);
    }

    public void remove(Integer id) {
        todoList.removeIf(c->c.id().equals(id));
    }

    public Boolean existById(Integer id) {
        return todoList.stream().filter(t -> t.id().equals(id)).count() == 1;
    }
}
