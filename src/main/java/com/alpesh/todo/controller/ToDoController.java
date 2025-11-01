package com.alpesh.todo.controller;

import com.alpesh.todo.entity.ToDo;
import com.alpesh.todo.service.ToDoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/todos")
public class ToDoController {
    private final ToDoService toDoService;

    @GetMapping
    public List<ToDo> getAllTodos() {
        return toDoService.findAll();
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo newTodo) {
        log.info("Creating new ToDo: {}", newTodo);
        return toDoService.save(newTodo);
    }

    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        log.info("Deleting ToDo with ID: {}", todoId);
        toDoService.delete(todoId);
    }

    @PutMapping("/{todoId}/complete")
    public ToDo markAsCompleted(@PathVariable Long todoId) {
        log.info("Marking ToDo with ID: {} as completed", todoId);
        return toDoService.markAsCompleted(todoId);
    }
}
