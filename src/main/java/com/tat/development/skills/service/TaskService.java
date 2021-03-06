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

    /**
     * @return all tasks entities from database.
     */
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    /**
     * @param id - needed task id.
     * @return - needed task.
     */
    public Task getTheTask(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    /**
     * Save new entity into database.
     * @param task - saved entity.
     * @return true, if entity had saved.
     */
    public boolean writeTask(Task task) {
        try { //todo Посмотреть как правильно здесь отловить и обработать исключение
            taskRepository.save(task);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    /**
     * Update entity in database.
     * @param task - updated entity with changed parameters.
     * @return true, if entity had updated.
     */
    public boolean updateTask(Task task) { //todo Посмотреть, как грамотно реализовать обновление
        return writeTask(task);
    }

    /**
     * Delete task entity by id from database.
     * @param id - task id.
     * @return true, if entity had deleted.
     */
    public boolean deleteTask(Long id) {
        try {//todo Посмотреть как правильно здесь отловить и обработать исключение
            taskRepository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
