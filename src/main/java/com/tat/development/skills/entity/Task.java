package com.tat.development.skills.entity;

import javax.persistence.*;

/**
 * Task.
 * This class describes the user's task.
 * @author Aydar_Safiullin
 */
@Entity
@Table(name = "task")
public class Task {
    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskID;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "time")
    private String recordTime;

    @Column(name = "completion")
    private Boolean completion;

    public Task() {}

    public Task(String name, String description, String recordTime) {
        this.name = name;
        this.description = description;
        this.recordTime = recordTime;
        completion = false;
    }

    public void setTaskID(Long taskID) {
        this.taskID = taskID;
    }

    public Long getTaskID() {
        return taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String text) {
        this.description = text;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public Boolean getCompletion() {
        return completion;
    }

    public void setCompletion(Boolean completion) {
        this.completion = completion;
    }
}
