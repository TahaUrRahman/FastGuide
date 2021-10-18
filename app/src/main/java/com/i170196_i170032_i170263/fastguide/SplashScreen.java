package com.i170196_i170032_i170263.fastguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import de.hdodenhof.circleimageview.CircleImageView;

public class SplashScreen extends AppCompatActivity {
    Animation topAnim,bottomAnim;
    AppCompatButton GetStarted;
    CircleImageView FastGuideLogo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this,R.anim.splash_animation_top);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.splash_animation_bottom);


        FastGuideLogo = findViewById(R.id.FastGuideLogo);
        GetStarted = findViewById(R.id.GetStarted);

        FastGuideLogo.setAnimation(topAnim);
        GetStarted.setAnimation(bottomAnim);

        GetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(SplashScreen.this,LogIn.class);
                startActivity(intent);
                finish();
            }
        });
    }
}