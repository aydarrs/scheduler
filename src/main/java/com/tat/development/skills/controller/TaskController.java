package com.tat.development.skills.controller;

import com.tat.development.skills.entity.Task;
import com.tat.development.skills.service.TaskService;
import com.tat.development.skills.utils.AppLocale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
     * @param model - holder for model attributes.
     * @return page with all tasks.
     */
    @GetMapping("/all")
    public String getTasksListPage(Model model) {
        model.addAttribute("models", taskService.getAllTasks());
        return "task/TasksList";
    }

    /**
     * @return task adding page.
     */
    @GetMapping("/add")
    public String getAddingPage() {
        return "task/TaskAdding";
    }

    /**
     * Add task into database.
     * @param description - task description.
     * @return - redirect to all tasks page.
     */
    @PostMapping("/add")
    public String addTask(@RequestParam String name, @RequestParam String description) {
        Date currentTime = new Date();
        SimpleDateFormat dateFormatter = new SimpleDateFormat("EEE yyyy.MM.dd HH:mm", AppLocale.getRussianLocale());
        String recordTime = dateFormatter.format(currentTime);
        Task task = new Task(name, description, recordTime);
        taskService.writeTask(task);
        return "redirect:/skills/tasks/all";
    }

    @PostMapping("/delete")
    public String deleteTask(@RequestParam Long id) {
        taskService.deleteTask(id);
        return "redirect:/skills/tasks/all";
    }
}
