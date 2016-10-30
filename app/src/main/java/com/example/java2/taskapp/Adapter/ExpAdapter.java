package com.example.java2.taskapp.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.java2.taskapp.DashBoard;
import com.example.java2.taskapp.R;
import com.example.java2.taskapp.model.SubTask;
import com.example.java2.taskapp.model.Task;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

/**
 * Created by java2 on 10/27/2016.
 */

public class ExpAdapter extends BaseExpandableListAdapter {

    private ArrayList<Task> tasks;
    private Context context;

    public ExpAdapter(Context context, ArrayList<Task> tasks) {

        this.tasks = tasks;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return tasks.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return tasks.get(groupPosition).getSubtasks().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return tasks.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return tasks.get(groupPosition).getSubtasks().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return groupPosition + childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        String headerTitle = tasks.get(groupPosition).getName();
        if (convertView == null) {

            LayoutInflater infalInflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);
        if (tasks.get(groupPosition).isCompleted()) {
            Drawable img = context.getResources().getDrawable(R.drawable.comp);
            img.setBounds(0, 0, 35, 35);
            lblListHeader.setCompoundDrawables(img, null, null, null);
        } else {

            Drawable img = context.getResources().getDrawable(R.drawable.not_comp);
            img.setBounds(0, 0, 35, 35);
            lblListHeader.setCompoundDrawables(img, null, null, null);
        }


        return convertView;

    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = tasks.get(groupPosition).getSubtasks().get(childPosition).getName();

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.lblListItem);

        txtListChild.setText(childText);
        txtListChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!tasks.get(groupPosition).getSubtasks().get(childPosition).isCompleted()){
                    tasks.get(groupPosition).getSubtasks().get(childPosition).setCompleted(true);
                    boolean areAll=true;
                    for (int i = 0; i <tasks.get(groupPosition).getSize() ; i++) {
                        SubTask temp=tasks.get(groupPosition).getSubtasks().get(i);
                        if(!temp.isCompleted()){
                            areAll=false;
                        }
                    }
                    if(areAll==true){
                        tasks.get(groupPosition).setCompleted(true);

                    }
                    notifyDataSetChanged();
                }
            }
        });
        if (tasks.get(groupPosition).getSubtasks().get(childPosition).isCompleted()) {
            Drawable img = context.getResources().getDrawable(R.drawable.comp);
            img.setBounds(0, 0, 20, 20);
            txtListChild.setCompoundDrawables(img, null, null, null);
        } else {

            Drawable img = context.getResources().getDrawable(R.drawable.not_comp);
            img.setBounds(0, 0, 20, 20);
            txtListChild.setCompoundDrawables(img, null, null, null);
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
