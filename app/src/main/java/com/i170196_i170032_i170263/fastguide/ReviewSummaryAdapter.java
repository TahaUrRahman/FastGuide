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

public class ReviewSummaryAdapter extends RecyclerView.Adapter<ReviewSummaryAdapter.MyViewHolder> {
    List<ReviewSummaryModel> ls;
    Context c;

    public ReviewSummaryAdapter(List<ReviewSummaryModel> ls, Context c) {
        this.ls = ls;
        this.c = c;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View StudentReviewRow = LayoutInflater.from(c).inflate(R.layout.student_review_row,parent,false);
        return new MyViewHolder(StudentReviewRow);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.StudentName.setText(ls.get(position).getStudentName());
        holder.StudentReview.setText(ls.get(position).getStudentReview());
        holder.StudentReviewRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(c,ReviewText.class);
                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView StudentName, StudentReview;
        LinearLayout StudentReviewRow;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            StudentName = itemView.findViewById(R.id.StudentName);
            StudentReview = itemView.findViewById(R.id.StudentReviewText);
            StudentReviewRow = itemView.findViewById(R.id.StudentReviewRow);
        }
    }
}
