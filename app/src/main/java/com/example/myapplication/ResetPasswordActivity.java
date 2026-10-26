
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText newPassword, confirmNewPassword;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPassword = findViewById(R.id.newPassword);
        confirmNewPassword = findViewById(R.id.confirmNewPassword);
        resetButton = findViewById(R.id.resetButton);

        resetButton.setOnClickListener(v -> {

            String password = newPassword.getText().toString();
            String confirm = confirmNewPassword.getText().toString();

            if (password.length() < 6) {
                newPassword.setError("Minimum 6 characters");
                return;
            }

            if (!password.equals(confirm)) {
                confirmNewPassword.setError("Passwords do not match");
                return;
            }

            Toast.makeText(this,
                    "Demo reset completed!",
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(
                    ResetPasswordActivity.this,
                    LoginActivity.class
            );

            intent.addFlags(
                    Intent.FLAG_ACTIVITY_CLEAR_TOP |
                            Intent.FLAG_ACTIVITY_SINGLE_TOP
            );

            startActivity(intent);
            finish();
        });
    }
}
