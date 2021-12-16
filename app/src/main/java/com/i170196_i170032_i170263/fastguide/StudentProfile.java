package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class StudentProfile extends AppCompatActivity {
    ImageView BackBtn;
    AppCompatButton Signout;

// ...
// Initialize Firebase Auth

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_profile);

        BackBtn = findViewById(R.id.StudentProfileScreenBackBtn);
        BackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Signout = findViewById(R.id.Signout);
        Signout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(StudentProfile.this,LogIn.class);
                startActivity(intent);
                finish();
            }
        });
    }
}