package com.Altair.TO_DO.List.service;

import com.Altair.TO_DO.List.model.Task;
import com.Altair.TO_DO.List.repository.TaskRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskService {
    public final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Создание новой задачи
    public Task createTask(String title, String name) {
        Task task = new Task();
        task.setTitle(title);
        task.setName(name);
        return taskRepository.save(task);
    }

    // Смена статуса выполнения задачи. (Разобраться!!!)
    public Task changeStatus(long id){
        Task task = taskRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Task not found with id: " + id));
        task.setCompleted(!task.getCompleted());

        return taskRepository.save(task);
    }

    // Вывод всех задач
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    // Удаление задачи
    public void deleteTask(Long taskId){
        taskRepository.deleteById(taskId);
    }


}
