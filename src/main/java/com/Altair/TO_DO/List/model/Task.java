package com.Altair.TO_DO.List.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks")
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    // Поле ID задачи. Генерируется автоматически
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Поля имени пользователя (в будущем переделать в отдельную модель!!!)
    @Size(min = 3, max = 15, message = "Имя должно содержать не менее 3 и не более 15 символов")
    @Column(nullable = false)
    private String name;

    // Поле названия задачи
    @Size(min = 3, max = 100, message = "Название должно содержать не менее 3 и не более 100 символов!")
    @Column(nullable = false)
    private String title;

    // Поле статуса выполнения задачи. Изначально false
    @Column(nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    private boolean isCompleted;

    // Дата создания объекта
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    // Геттеры и сеттеры
    public void setCreatedAt(LocalDateTime newTime){this.createdAt = newTime;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public boolean getCompleted(){return isCompleted;}
    public void setCompleted(boolean status){this.isCompleted = status;}
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }


}
