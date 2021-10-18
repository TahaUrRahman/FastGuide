package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LogIn extends AppCompatActivity {

    AppCompatButton LogIn;
    TextView SignUpNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        LogIn = findViewById(R.id.LogIn);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        SignUpNow = findViewById(R.id.SignUpNow);
        SignUpNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogIn.this,SignUp.class);
                startActivity(intent);
                finish();
            }
        });
    }
}