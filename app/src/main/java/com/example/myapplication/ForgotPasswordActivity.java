
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {

    EditText forgotEmail;
    Button continueButton;
    TextView backToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        forgotEmail = findViewById(R.id.forgotEmail);
        continueButton = findViewById(R.id.continueButton);
        backToLogin = findViewById(R.id.backToLogin);

        continueButton.setOnClickListener(v -> {

            String email = forgotEmail.getText().toString().trim();

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                forgotEmail.setError("Enter a valid email");
                return;
            }

            Intent intent = new Intent(
                    ForgotPasswordActivity.this,
                    ResetPasswordActivity.class
            );

            startActivity(intent);
        });

        backToLogin.setOnClickListener(v -> finish());
    }
}
