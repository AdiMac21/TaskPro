package com.example.java2.taskapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.java2.taskapp.model.SubTask;
import com.example.java2.taskapp.model.Task;

import java.util.ArrayList;

public class AddTask extends AppCompatActivity {
    static int tvCount = 1;
    TextView tv_taskName;
    Button add;
    private LinearLayout layout;
    private TextView temp2;
    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        linkUi();

        buttonListener();
    }

    private void buttonListener() {
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                TextView temp = new EditText(AddTask.this);
                temp.setHint(R.string.subt);
                temp.setTextSize(16);
                temp2 = temp;
                temp.setId(layout.getChildCount());
                temp.setTextColor(ContextCompat.getColor(AddTask.this, R.color.white));
                temp.setBackgroundColor(ContextCompat.getColor(AddTask.this, R.color.subtask));
                temp.setLayoutParams(params);
                layout.addView(temp);
                layout.invalidate();
                layout.refreshDrawableState();
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            ArrayList<SubTask> subtask = new ArrayList<>();
                                            if (layout.getChildCount() > 0) {
                                                for (int i = 0; i < layout.getChildCount(); i++) {
                                                    TextView temp = (TextView) layout.getChildAt(i);
                                                    SubTask tempSubtask = new SubTask(temp.getText().toString(), false);
                                                    subtask.add(tempSubtask);

                                                }
                                                Task task = new Task(tv_taskName.getText().toString(), false, subtask);
                                                Intent intent = new Intent();
                                                if (!tv_taskName.getText().toString().trim().equals("") && !temp2.getText().toString().trim().equals("")) {
                                                    intent.putExtra("result", task);
                                                    setResult(Activity.RESULT_OK, intent);
                                                    onBackPressed();
                                                } else {
                                                    Toast toast = Toast.makeText(AddTask.this, "Task or subtask not valid", Toast.LENGTH_LONG);
                                                    toast.show();
                                                }


                                            } else {
                                                Toast toast = Toast.makeText(AddTask.this, "Please create some subtasks", Toast.LENGTH_LONG);
                                                toast.show();
                                            }

                                        }
                                    }


        );
    }

    private void linkUi() {
        tv_taskName = (TextView) findViewById(R.id.tv_taskname);
        add = (Button) findViewById(R.id.buttonadd);
        btn_save = (Button) findViewById(R.id.btn_save);
        layout = (LinearLayout) findViewById(R.id.linlay);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
