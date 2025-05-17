package com.Altair.TO_DO.List.service;

import com.Altair.TO_DO.List.model.Task;
import com.Altair.TO_DO.List.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Создание новой задачи
    public Task createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        return taskRepository.save(task);
    }

    // Вывод всех задач
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }


}
