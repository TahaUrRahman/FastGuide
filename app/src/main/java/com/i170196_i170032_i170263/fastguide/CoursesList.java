package com.i170196_i170032_i170263.fastguide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class CoursesList extends AppCompatActivity {
    ImageView BackBtn;
    RecyclerView CourseRV;
    DBHelper dbHelper;
    List<CourseModel> coursesList;
    List<CourseModel> viewCoursesList;
    DatabaseReference coursesReference;
    CourseAdapter adapter;
    ImageView searchCoursesButton;
    EditText coursesSearchQuery;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_list);
        dbHelper =new DBHelper(CoursesList.this);
        coursesReference = FirebaseDatabase.getInstance().getReference("Courses");
        BackBtn = findViewById(R.id.CoursesListScreenBackBtn);
        coursesList = new ArrayList<>();
        viewCoursesList = new ArrayList<>();
        adapter = new CourseAdapter(viewCoursesList,this);
        searchCoursesButton = findViewById(R.id.searchCoursesButton);
        coursesSearchQuery = findViewById(R.id.coursesSearchQuery);

        //-------------------------------------------Searching courses---------------------------------------------------//
        searchCoursesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!coursesSearchQuery.getText().toString().equals("")){
                    List<CourseModel>tempList = new ArrayList<>();
                    coursesList.clear();
                    coursesList.addAll(viewCoursesList);
                    for (int i=0;(i<viewCoursesList.size());i++){
                        if (viewCoursesList.get(i).getCourseName().contains(coursesSearchQuery.getText().toString())){
//                            Toast.makeText(getActivity(),viewCoursesList.get(i).getName() + " : "+ chatsSearchQuery.getText().toString() + " : " + viewCoursesList.get(i).getName().contains(chatsSearchQuery.getText().toString()),Toast.LENGTH_LONG).show();
                            tempList.add(viewCoursesList.get(i));
                        }
                    }
                    viewCoursesList.clear();
                    viewCoursesList.addAll(tempList);
//                    Toast.makeText(getActivity(), viewCoursesList.size()+"", Toast.LENGTH_SHORT).show();
//                    chatsSearchQuery.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });
        coursesSearchQuery.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (coursesSearchQuery.getText().toString().equals("")){
                    viewCoursesList.clear();
                    viewCoursesList.addAll(coursesList);
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        //-------------------------------------------------------------------Click Listeners--------------------//
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        //------------------------------------------------Check Internet-------------------------------------//
        boolean internet = false;
        try {
            String command = "ping -c 1 google.com";
            if (Runtime.getRuntime().exec(command).waitFor() == 0){
                internet = true;
            }
        } catch (Exception e) {
            internet = false;
        }
        //------------------------------------------------Database Listeners--------------------------------//
        if (internet){
            dbHelper.deleteCourses();
            coursesReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
//                    Toast.makeText(CoursesList.this, "courseModel.toString()", Toast.LENGTH_SHORT).show();
                    CourseModel courseModel =snapshot.getValue(CourseModel.class);
                    viewCoursesList.add(courseModel);
                    dbHelper.addCourse(courseModel);
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }else{
//            coursesList=dbHelper.getCourses();
            viewCoursesList.addAll(dbHelper.getCourses());
//            adapter.notifyDataSetChanged();
            Toast.makeText(CoursesList.this, "Retreived from local storage", Toast.LENGTH_SHORT).show();
        }

        //---------------------------------------------Setting recycler view-------------------------------------------//

//        viewCoursesList.add(new CourseModel(1,"Course 1","Computer Science"));
//        coursesReference.push().setValue(new CourseModel(1,"Course 1","Computer Science")).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (!task.isSuccessful()){
//                    Toast.makeText(CoursesList.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//        viewCoursesList.add(new CourseModel(2,"Course 2","Computer Science"));
//        viewCoursesList.add(new CourseModel(3,"Course 3","Computer Science"));
//        Toast.makeText(CoursesList.this, "Courses added", Toast.LENGTH_SHORT).show();
        CourseRV = findViewById(R.id.CourseRV);
        RecyclerView.LayoutManager lm = new LinearLayoutManager(this);
        CourseRV.setLayoutManager(lm);
        CourseRV.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}