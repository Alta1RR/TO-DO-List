package com.Altair.TO_DO.List.controller;

import com.Altair.TO_DO.List.model.Task;
import com.Altair.TO_DO.List.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody @Valid Task task) {
        return taskService.createTask(task.getTitle(), task.getName());
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    public ResponseEntity<Task> changeTaskStatus(@PathVariable long id){
        Task updatedTask = taskService.changeStatus(id);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
