package com.example.java2.taskapp.data;

import android.content.Context;
import android.util.Log;

import com.example.java2.taskapp.model.SubTask;
import com.example.java2.taskapp.model.Task;
import com.example.java2.taskapp.model.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by java2 on 10/24/2016.
 */

public class JsonParse {
    private ArrayList<User> users;
    private Context context;
    private String reader;


    public ArrayList<User> getUsers() {
        return users;
    }

    public JsonParse(Context context) {
        this.context = context;
        reader=this.read();
        users=this.getUsers(reader);

    }

    private String read() {
        StringBuilder buf = new StringBuilder();
        InputStream json = null;
        String TAG = "12";

        try {
            json = context.getAssets().open("json.txt");
            BufferedReader in = new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "buf= " + buf.toString());
        return buf.toString();

    }
    private ArrayList<User> getUsers(String a) {
        String TAG = "bla";
        Gson gson = new Gson();
        try {
            JSONArray jsonArray = new JSONArray(a);
            Log.d(TAG, "jsonArray= " + jsonArray.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList<User> contacts = gson.fromJson(a, new TypeToken<ArrayList<User>>() {

        }.getType());
        Log.d(TAG, "contacts " + contacts.toString());
        return contacts;
    }
}
