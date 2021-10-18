package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeScreen extends AppCompatActivity {

    AppCompatButton GetProfessors;
    CircleImageView HomeScreenDP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetProfessors = findViewById(R.id.GetProfessors);
        GetProfessors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,ProfessorsList.class);
                startActivity(intent);
            }
        });

        HomeScreenDP = findViewById(R.id.HomeScreenDP);
        HomeScreenDP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this,CoursesList.class);
                startActivity(intent);
            }
        });

    }
}