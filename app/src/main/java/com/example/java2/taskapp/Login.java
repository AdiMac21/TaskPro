package com.example.java2.taskapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.java2.taskapp.data.JsonParse;
import com.example.java2.taskapp.model.User;
import com.example.java2.taskapp.model.UserInfo;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
private ArrayList<User> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        JsonParse json=new JsonParse(this);
        users=json.getUsers();
    }
}
