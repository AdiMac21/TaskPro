package com.example.java2.taskapp.model;

import java.util.ArrayList;

/**
 * Created by java2 on 10/24/2016.
 */

public class User {
    private String firsName;
    private String lastName;
    private String imageProfile;
    private String jobTitle;
    private boolean taskCompleted;
    private int taskRemaining;
    private int age;
    private ArrayList<Task> tasks;


    public User(String firsName, String lastName, String imageProfile, String jobTitle, boolean taskCompleted, int taskRemaining, int age, ArrayList<Task> tasks) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.imageProfile = imageProfile;
        this.jobTitle = jobTitle;
        this.taskCompleted = taskCompleted;
        this.taskRemaining = taskRemaining;
        this.age = age;
        this.tasks = tasks;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImageProfile() {
        return imageProfile;
    }

    public void setImageProfile(String imageProfile) {
        this.imageProfile = imageProfile;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(boolean taskCompleted) {
        this.taskCompleted = taskCompleted;
    }

    public int getTaskRemaining() {
        return taskRemaining;
    }

    public void setTaskRemaining(int taskRemaining) {
        this.taskRemaining = taskRemaining;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }
}
