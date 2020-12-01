package com.tat.development.skills.entity;

import com.tat.development.skills.utils.AppDateFormatterUtil;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "completion")
    private Boolean complete;

    @Column(name = "change_date")
    private Date changeDate;


    public Task() {
        setCreateDate(new Date());
    }

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        setCreateDate(new Date());
        setComplete(false);
    }

    /**
     * Completes the task.
     */
    public void complete() {
        changeDate = new Date();
        setComplete(true);
    }

    /**
     * Format create date for user reading.
     * @return - formatted create date.
     */
    public String getFormattedCreateDate() {
        if (createDate != null) {
            return AppDateFormatterUtil.getFormattedDate(createDate);
        }
        return null;
    }

    /**
     * Format change date for user reading.
     * @return - formatted change date.
     */
    public String getFormattedChangeDate() {
        if (changeDate != null) {
            return AppDateFormatterUtil.getFormattedDate(changeDate);
        }
        return null;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
        if (changeDate == null) {
            setChangeDate(createDate);
        }
    }

    public Boolean isComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public Date getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(Date changeDate) {
        this.changeDate = changeDate;
    }
}
