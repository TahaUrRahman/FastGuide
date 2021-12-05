package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ReviewText extends AppCompatActivity {
    ImageButton Backbtn;
    AppCompatButton ReturnToHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_text);

        Backbtn = findViewById(R.id.ReviewTextScreenBackBtn);
        Backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ReturnToHomepage = findViewById(R.id.ReturnToHomepage);
        ReturnToHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReviewText.this,HomeScreen.class);
                startActivity(intent);
                finish();
            }
        });
    }
}