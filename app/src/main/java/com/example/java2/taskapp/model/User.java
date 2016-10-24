package com.example.java2.taskapp.model;

import java.util.ArrayList;

/**
 * Created by java2 on 10/24/2016.
 */

public class User {
    private String email;
    private String password;
    private UserInfo userInfo;

    public User (String email,String password,UserInfo info){
        this.email=email;
        this.password=password;
        this.userInfo=info;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserInfo getInfo() {
        return userInfo;
    }

    public void setInfo(UserInfo info) {
        this.userInfo = info;
    }
}
