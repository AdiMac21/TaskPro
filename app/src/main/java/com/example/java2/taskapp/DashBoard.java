package com.example.java2.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.java2.taskapp.model.User;

import java.util.TreeSet;

public class DashBoard extends AppCompatActivity {
    private TreeSet<User> users = new TreeSet<>();
    private User logged;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Intent intent = getIntent();
        users = (TreeSet<User>) intent.getSerializableExtra("set");
        logged = (User) intent.getSerializableExtra("user");
    }
}
