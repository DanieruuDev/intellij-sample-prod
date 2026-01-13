package org.example.todolist.repository;

import org.example.todolist.model.Status;
import org.example.todolist.model.Todo;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface TodoRepository extends ListCrudRepository<Todo, Integer>{
    boolean existsById(Integer id);


}
