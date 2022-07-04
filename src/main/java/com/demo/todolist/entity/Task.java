package com.demo.todolist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity class representing model of Task object.
 *
 * @author Stefan Sidlovsky
 */
@Entity
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String category;

    @Column
    private String deadline;

    @Column
    private String place;

    @Column
    private String description;

    public Task() {

    }

    /**
     * Constructor of Task object.
     *
     * @param category    Category of task
     * @param deadline    When the task should be done - just string (Monday, Today, 08.11.2023)
     * @param place       Place where task should be done
     * @param description Brief description of task
     */
    public Task(String category, String deadline, String place, String description) {
        this.category = category;
        this.deadline = deadline;
        this.place = place;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
