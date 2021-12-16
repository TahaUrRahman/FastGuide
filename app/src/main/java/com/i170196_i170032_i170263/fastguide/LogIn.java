package com.i170196_i170032_i170263.fastguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogIn extends AppCompatActivity {

    AppCompatButton LogIn;
    EditText email, password;
    TextView SignUpNow;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        password = findViewById(R.id.LoginPassword);
        email = findViewById(R.id.loginUserName);

        LogIn = findViewById(R.id.LogIn);
        LogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("")){
                    email.setError("Please enter Username");
                    email.requestFocus();
                    return;
                }
                if (password.getText().toString().equals("")) {
                    password.setError("Please enter Password");
                    password.requestFocus();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                        .addOnCompleteListener(LogIn.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "signInWithEmail:success");
//                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent intent = new Intent(LogIn.this,HomeScreen.class);
                                    startActivity(intent);
                                    finish();
//                            updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
//                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LogIn.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                                }
                            }
                        });

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