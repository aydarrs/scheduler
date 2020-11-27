package com.tat.development.skills.service;

import com.tat.development.skills.entity.Task;
import com.tat.development.skills.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TaskService.
 * This service using for operations with tasks repository.
 * @author Aydar_Safiullin
 */
@Service
public class TaskService {
    private final TaskRepository taskRepository; //todo Разобраться, почему SonarLint просит модификатор final

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public boolean writeTask(Task task) {
        Task result = taskRepository.save(task);
        return true;
    }
}
