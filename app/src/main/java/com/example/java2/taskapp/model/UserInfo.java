package com.example.java2.taskapp.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by java2 on 10/24/2016.
 */

public class UserInfo implements Serializable {
    private String firstName;
    private String lastName;
    private String imageProfile;
    private String jobTitle;
    private int taskCompleted;
    private int taskRemaining;
    private int age;
    private ArrayList<Task> tasks;


    public UserInfo(String firsName, String lastName, String imageProfile, String jobTitle, int taskCompleted, int taskRemaining, int age, ArrayList<Task> tasks) {
        this.firstName = firsName;
        this.lastName = lastName;
        this.imageProfile = imageProfile;
        this.jobTitle = jobTitle;
        this.taskCompleted = taskCompleted;
        this.taskRemaining = taskRemaining;
        this.age = age;
        this.tasks = tasks;
    }

    public String getFirsName() {
        return firstName;
    }

    public void setFirsName(String firsName) {
        this.firstName = firsName;
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

    public int isTaskCompleted() {
        return taskCompleted;
    }

    public void setTaskCompleted(int taskCompleted) {
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
