package com.example.java2.taskapp.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by java2 on 10/24/2016.
 */

public class Task implements Serializable {
    private String name;
    private boolean completed;
    private ArrayList<SubTask> subTasks;

    public Task(String name,boolean completed,ArrayList<SubTask> subTasks){
        this.name=name;
        this.completed=completed;
        this.subTasks=subTasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public ArrayList<SubTask> getSubtasks() {
        return subTasks;
    }

    public void setSubtasks(ArrayList<SubTask> subtasks) {
        this.subTasks = subtasks;
    }
}
