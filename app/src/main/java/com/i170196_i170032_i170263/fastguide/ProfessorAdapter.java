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


public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.MyViewHolder>{
    List<ProfessorModel> ls;
    Context c;

    public ProfessorAdapter(List<ProfessorModel> ls, Context c) {
        this.ls = ls;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View ProfessorRow = LayoutInflater.from(c).inflate(R.layout.professor_row,parent,false);
        return new MyViewHolder(ProfessorRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ProfessorName.setText(ls.get(position).getProfessorName());
        holder.ProfessorCourse.setText(ls.get(position).getProfessorCourse());
        holder.ProfessorRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c,TeacherCourse.class);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView ProfessorName,ProfessorCourse;
        LinearLayout ProfessorRow;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ProfessorName = itemView.findViewById(R.id.ProfessorName);
            ProfessorCourse = itemView.findViewById(R.id.ProfessorCourse);
            ProfessorRow = itemView.findViewById(R.id.ProfessorRow);
        }
    }
}