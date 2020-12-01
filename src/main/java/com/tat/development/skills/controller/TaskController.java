package com.tat.development.skills.controller;

import com.tat.development.skills.entity.Task;
import com.tat.development.skills.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * TaskController.
 * This controller using for operations with users tasks.
 * @author Aydar_Safiullin
 */
@Controller
@RequestMapping("/skills/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    /**
     * @param model - the holder for the model attributes.
     * @return the page with all tasks.
     */
    @GetMapping("/all")
    public String getTasksListPage(Model model) {
        model.addAttribute("models", taskService.getAllTasks());
        return "task/TasksList";
    }

    /**
     * @param model - the holder for the model attributes.
     * @param id - task ID.
     * @return - the task page.
     */
    @GetMapping("/{id}")
    public String getTaskPage(Model model,
                              @PathVariable Long id) {
        Task task = taskService.getTheTask(id);
        model.addAttribute("task", task);
        return "task/Task";
    }

    /**
     * @return the task adding page.
     */
    @GetMapping("/add")
    public String getAddingPage() {
        return "task/TaskAdding";
    }

    /**
     * Add the task into database.
     * @param description - task description.
     * @return - redirect to all tasks page.
     */
    @PostMapping("/add")
    public String addTask(@RequestParam String name,
                          @RequestParam String description) {
        Task task = new Task(name, description);
        taskService.writeTask(task);
        return "redirect:/skills/tasks/all";
    }

    /**
     * @param model - the holder for the model attributes.
     * @param id - ID of the task being updated.
     * @return - the task updating page.
     */
    @GetMapping("/{id}/update")
    public String updateTask(Model model,
                             @PathVariable Long id) {
        Task task = taskService.getTheTask(id);
        model.addAttribute("task", task);
        return "task/TaskUpdating";
    }

    /**
     * Update task in database.
     * @param name - task name after update.
     * @param description - task description after update.
     * @param id - ID of the task being updated.
     * @return - redirect to all tasks page.
     */
    @PostMapping("/update")
    public String updateTask(@RequestParam String name,
                             @RequestParam String description,
                             @RequestParam Long id) {
        Task task = taskService.getTheTask(id);
        task.setName(name);
        task.setDescription(description);
        task.setChangeDate(new Date());
        taskService.updateTask(task);
        return "redirect:/skills/tasks/all";
    }

    /**
     * Mark the task as completed.
     * @param id - completed task ID.
     * @return - redirect to all tasks page.
     */
    @PostMapping("/complete")
    public String completeTask(@RequestParam Long id) {
        Task task = taskService.getTheTask(id);
        task.complete();
        taskService.updateTask(task);
        return "redirect:/skills/tasks/all";
    }

    /**
     * Delete the task from tasks list.
     * @param id - ID of the task being deleted.
     * @return - redirect to all tasks page.
     */
    @PostMapping("/delete")
    public String deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
        return "redirect:/skills/tasks/all";
    }
}
