package com.i170196_i170032_i170263.fastguide;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity {
    AppCompatButton SignUp;
    EditText userNameEntered, email, password, cpassword;
    TextView LogInNow;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        userNameEntered = findViewById(R.id.userNameEntered);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        email = findViewById(R.id.email);

        SignUp = findViewById(R.id.SignUp);
        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userNameEntered.getText().toString().equals("")){
                    userNameEntered.setError("You forgot to enter your Username.");
                    userNameEntered.requestFocus();
                    return;
                }
                if (email.getText().toString().equals("")){
                    email.setError("You forgot to enter Phone Number.");
                    email.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
                    email.setError("Oops! Email is not valid!");
                    email.requestFocus();
                    return;
                }
                if (password.getText().toString().equals("")){
                    password.setError("You forgot to enter password.");
                    password.requestFocus();
                    return;
                }
                if (cpassword.getText().toString().equals("")){
                    cpassword.setError("You forgot to confirm your password.");
                    cpassword.requestFocus();
                    return;
                }
                if (!password.getText().toString().equals(cpassword.getText().toString())){
                    cpassword.setError("Passwords do not match!");
                    cpassword.requestFocus();
                    return;
                }
                if (password.getText().toString().length()<6){
                    password.setError("Password should be longer than 6 characters!");
                    password.requestFocus();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString()).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "createUserWithEmail:success");
//                                    FirebaseUser user = mAuth.getCurrentUser();
//                                    updateUI(user);
                                    Intent intent = new Intent(SignUp.this,HomeScreen.class);
                                    startActivity(intent);
                                    finish();

                                } else {
                                    // If sign in fails, display a message to the user.
//                                    Log.w("TAG", "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
//                                    updateUI(null);
                                }
                            }
                        });


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