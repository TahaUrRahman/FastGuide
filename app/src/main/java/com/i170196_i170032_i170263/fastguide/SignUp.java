package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {

    AppCompatButton SignUp;
    TextView LogInNow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        SignUp = findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });

        LogInNow = findViewById(R.id.LogInNow);
        LogInNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp.this,LogIn.class);
                startActivity(intent);
                finish();
            }
        });
    }
}