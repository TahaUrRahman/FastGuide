package com.i170196_i170032_i170263.fastguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.MyViewHolder>{

    List<CourseModel> ls;
    Context c;

    public CourseAdapter(List<CourseModel> ls, Context c) {
        this.ls = ls;
        this.c = c;
    }

    @NonNull
    @Override
    public CourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View CourseRow = LayoutInflater.from(c).inflate(R.layout.course_row,parent,false);
        return new MyViewHolder(CourseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CourseAdapter.MyViewHolder holder, int position) {
        holder.CourseName.setText(ls.get(position).getCourseName());
        holder.DepartmentName.setText(ls.get(position).getDepartmentName());
        holder.CourseRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c,CourseNames.class);
                intent.putExtra("name",ls.get(holder.getAbsoluteAdapterPosition()).getCourseName());
                intent.putExtra("dept",ls.get(holder.getAbsoluteAdapterPosition()).getDepartmentName());
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView CourseName,DepartmentName;
        LinearLayout CourseRow;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            CourseName = itemView.findViewById(R.id.CourseName);
            DepartmentName = itemView.findViewById(R.id.DepartmentName);
            CourseRow = itemView.findViewById(R.id.CourseRow);
        }
    }
}