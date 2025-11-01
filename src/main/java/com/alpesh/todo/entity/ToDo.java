package com.alpesh.todo.entity;

import com.alpesh.todo.config.BooleanToTinyIntConverter;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Convert(converter = BooleanToTinyIntConverter.class)
    private boolean isCompleted;
    private LocalDateTime dateAdded;

    public ToDo() {
        this.dateAdded = LocalDateTime.now();
    }
}
