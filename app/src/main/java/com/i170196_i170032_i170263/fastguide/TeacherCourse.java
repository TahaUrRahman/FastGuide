package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class TeacherCourse extends AppCompatActivity {
    RecyclerView TeacherCourseRV;
    List<TeacherCourseModel> ls;
    ImageView BackBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_course);

        TeacherCourseRV=findViewById(R.id.TeacherCourseRV);
        ls= new ArrayList<>();

        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));
        ls.add(new TeacherCourseModel("OOP"));

        BackBtn = findViewById(R.id.TeacherCourseScreenBackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        TeacherCourseAdapter adapter = new TeacherCourseAdapter(ls,this);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        TeacherCourseRV.setLayoutManager(lm);
        TeacherCourseRV.setAdapter(adapter);
    }
}