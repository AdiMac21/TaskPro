package com.example.java2.taskapp.model;

import java.util.ArrayList;

/**
 * Created by java2 on 10/24/2016.
 */

public class Task {
    private String name;
    private boolean completed;
    private ArrayList<SubTask> subtasks;

    public Task(String name,boolean completed,ArrayList<SubTask> subTasks){
        this.name=name;
        this.completed=completed;
        this.subtasks=subTasks;
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
        return subtasks;
    }

    public void setSubtasks(ArrayList<SubTask> subtasks) {
        this.subtasks = subtasks;
    }
}
