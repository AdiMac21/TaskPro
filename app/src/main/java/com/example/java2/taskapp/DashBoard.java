package com.example.java2.taskapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.java2.taskapp.Adapter.ExpAdapter;
import com.example.java2.taskapp.model.Task;
import com.example.java2.taskapp.model.User;

import java.util.ArrayList;
import java.util.TreeSet;

public class DashBoard extends AppCompatActivity {
    private TreeSet<User> users = new TreeSet<>();
    private User logged;
    ExpandableListView list;
    private ArrayList<Task> task;
    private TextView tv_name;
    private TextView tv_jobD;
    private TextView tv_remTask;
    private TextView tv_compTask;
    private ImageView iv_pic;
    private Button button;
    static final int REQ = 1;
    private ExpAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        Intent intent = getIntent();
        users = (TreeSet<User>) intent.getSerializableExtra("set");
        logged = (User) intent.getSerializableExtra("user");
        task = logged.getInfo().getTasks();
        linkUi();
        populateFirst();
        adapter = new ExpAdapter(this, logged.getInfo(), tv_remTask, tv_compTask);
        list = (ExpandableListView) findViewById(R.id.expand);
        list.setAdapter(adapter);
        setListener();


    }

    private void setListener() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DashBoard.this, AddTask.class);
                startActivityForResult(intent, REQ);
            }
        });
    }

    private void populateFirst() {
        tv_name.setText(logged.getInfo().getLastName().concat(" ").concat(logged.getInfo().getFirsName()));
        tv_jobD.setText(logged.getInfo().getJobTitle());
        tv_compTask.setText(Integer.toString(logged.getInfo().getTaskCompleted()));
        tv_remTask.setText(Integer.toString(logged.getInfo().getTaskRemaining()));
    }

    private void linkUi() {
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_jobD = (TextView) findViewById(R.id.tv_jobD);
        tv_remTask = (TextView) findViewById(R.id.tv_remtask);
        tv_compTask = (TextView) findViewById(R.id.tv_comptask);
        iv_pic = (ImageView) findViewById(R.id.iv_pic);
        button = (Button) findViewById(R.id.button);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQ) {

            if (resultCode == RESULT_OK) {
                Task task;
                task = (Task) data.getSerializableExtra("result");
                logged.getInfo().getTasks().add(task);
                adapter.notifyDataSetChanged();
                //todo inrease in tasks remaining
            }
        }
    }

}
