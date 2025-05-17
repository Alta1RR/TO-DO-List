package com.Altair.TO_DO.List.repository;

import com.Altair.TO_DO.List.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
