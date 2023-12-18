package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoJpaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController {
    @Autowired
    private TodoJpaService todoJpaService;

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos() {
        return todoJpaService.getTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo getTodoById(@PathVariable("id") int id) {
        return todoJpaService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo) {
        return todoJpaService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable("id") int id, @RequestBody Todo todo) {
        return todoJpaService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        todoJpaService.deleteTodo(id);
    }
}