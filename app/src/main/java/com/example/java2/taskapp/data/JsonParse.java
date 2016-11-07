package com.example.java2.taskapp.data;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.java2.taskapp.model.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by java2 on 10/24/2016.
 */

public class JsonParse {

    private ArrayList<User> users;
    private Context context;
    private String reader;


    public JsonParse(Context context) {
        this.context = context;


    }

    public ArrayList<User> getUsers() {
        reader = this.read();
        users = this.getUsers(reader);
        return users;
    }

    public void writeJson(ArrayList<User> users) {
        try {
            FileOutputStream writer = context.openFileOutput("json.txt", Context.MODE_PRIVATE);
            Gson gson = new GsonBuilder().create();
            String output = gson.toJson(users);
            writer.write(output.getBytes());
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @NonNull
    private String read() {
        StringBuilder buf = new StringBuilder();
        InputStream json = null;
        InputStream json2 = null;


        try {
            json2 = context.openFileInput("json.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(json2, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();

        } catch (IOException e) {
            try {
                json = context.getAssets().open("json.txt");

                BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
                String str;
                while ((str = in.readLine()) != null) {
                    buf.append(str);
                }
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }



        }
        return buf.toString();
    }

        private ArrayList<User> getUsers (String a){

            Gson gson = new Gson();

            ArrayList<User> contacts = gson.fromJson(a, new TypeToken<ArrayList<User>>() {

            }.getType());

            return contacts;
        }
    }
