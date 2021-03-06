package com.example.java2.taskapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java2.taskapp.data.JsonParse;
import com.example.java2.taskapp.model.User;
import com.example.java2.taskapp.model.UserInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

public class Login extends AppCompatActivity {
    private TreeSet<User> users = new TreeSet<>();
    private TextView tv_username;
    private TextView tv_password;
    private Button bt_login;
    private boolean user = false;
    private boolean password = false;
    private User login = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        JsonParse json = new JsonParse(this);
        ArrayList<User> temp = new ArrayList<>();
        temp = json.getUsers();
        users.addAll(temp);
        linkUi();
        setLisner();


        tv_username.setText("email1@yahoo.com");
        tv_password.setText("passs1");
    }

    private void setLisner() {
        tv_password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {

                    if (tv_password.getText().toString().length() < 6) {
                        tv_password.setError("Password should be greater than 6 characters!");
                    } else {
                        password = true;
                    }
                }
            }
        });
        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_username.requestFocus();
                tv_password.requestFocus();
                if (user == true && password == true) {

                    if (getUser(tv_username.getText().toString()) != null) {
                        if (tv_password.getText().toString().equals(login.getPassword())) {


                            Intent intent = new Intent(Login.this, DashBoard.class);
                            intent.putExtra("set", users);
                            intent.putExtra("user", login);
                            startActivity(intent);
                            user=false;
                            password=false;
                        } else {
                            Toast toast = Toast.makeText(Login.this, "Username or password incorrect", Toast.LENGTH_LONG);
                            toast.show();

                        }

                    } else {
                        Toast toast = Toast.makeText(Login.this, "Username or password incorrect", Toast.LENGTH_LONG);
                        toast.show();
                    }

                } else {

                }
            }
        });
        tv_username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {

                    if (!isValidEmail(tv_username.getText())) {
                        tv_username.setError("Not a valid email address");
                    } else {
                        user = true;
                    }
                }
            }
        });
    }

    private void linkUi() {
        tv_username = (TextView) findViewById(R.id.tv_username);
        tv_password = (TextView) findViewById(R.id.tv_password);
        bt_login = (Button) findViewById(R.id.bt_login);
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }

    private User getUser(String email) {
        for (User a : users) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                login = a;
                return login;
            } else {

            }
        }
        return login;
    }

    @Override
    protected void onResume() {
        login=null;
        JsonParse json = new JsonParse(this);
        ArrayList<User> temp = new ArrayList<>();
        temp = json.getUsers();
        users.addAll(temp);
        super.onResume();
    }
}
