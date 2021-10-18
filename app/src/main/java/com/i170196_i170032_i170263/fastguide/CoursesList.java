package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CoursesList extends AppCompatActivity {

    ImageView BackBtn;
    LinearLayout OpenCourse;

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

        OpenCourse = findViewById(R.id.CoursesListScreenCourse);
        OpenCourse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CoursesList.this,CourseNames.class);
                startActivity(intent);
            }
        });
    }
}