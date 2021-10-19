package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CoursesList extends AppCompatActivity {

    ImageView BackBtn;
    RecyclerView CourseRV;
    List<CourseModel> ls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);

        BackBtn = findViewById(R.id.CoursesListScreenBackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ls = new ArrayList<>();
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));
        ls.add(new CourseModel("Course 1","Computer Science"));

        CourseRV = findViewById(R.id.CourseRV);
        CourseAdapter adapter = new CourseAdapter(ls,this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        CourseRV.setLayoutManager(lm);
        CourseRV.setAdapter(adapter);

    }
}