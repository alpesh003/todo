package com.alpesh.todo.service;

import com.alpesh.todo.TodoApplication;
import com.alpesh.todo.entity.ToDo;
import com.alpesh.todo.repo.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public List<ToDo> findAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public void delete(Long todoId) {
        toDoRepository.deleteById(todoId);
    }

    public ToDo markAsCompleted(Long todoId) {
        ToDo toDo = toDoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("ToDo not found with ID: " + todoId));
        toDo.setCompleted(true);
        return toDoRepository.save(toDo);
    }
}
