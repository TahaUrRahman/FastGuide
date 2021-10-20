package com.i170196_i170032_i170263.fastguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TeacherCourseAdapter extends RecyclerView.Adapter<TeacherCourseAdapter.MyViewHolder> {
    List<TeacherCourseModel> ls;
    Context c;

    public TeacherCourseAdapter (List<TeacherCourseModel>ls, Context c){
        this.c=c;
        this.ls=ls;
    }

    @NonNull
    @Override
    public TeacherCourseAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View TeacherCourseRow = LayoutInflater.from(c).inflate(R.layout.teacher_course_row,parent,false);
        return new TeacherCourseAdapter.MyViewHolder(TeacherCourseRow);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherCourseAdapter.MyViewHolder holder, int position) {
        holder.TeacherCourseName.setText(ls.get(position).getTeacherCourse());
        holder.GiveReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c,PostReviews.class);
                c.startActivity(intent);
            }
        });
        holder.ReadReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c,ReviewSummary.class);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView TeacherCourseName;
        AppCompatButton GiveReview, ReadReview;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            TeacherCourseName= itemView.findViewById(R.id.TeacherCourseName);
            GiveReview = itemView.findViewById(R.id.GiveReview);
            ReadReview = itemView.findViewById(R.id.ReadReview);
        }
    }
}
