package com.example.java2.taskapp.model;

import java.io.Serializable;

/**
 * Created by java2 on 10/24/2016.
 */

public class SubTask implements Serializable {
    private String name;
    private boolean completed;

    public SubTask(String name,boolean completed){
        this.name=name;
        this.completed=completed;
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
}
