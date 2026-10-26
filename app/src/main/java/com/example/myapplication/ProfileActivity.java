
package com.example.myapplication;

import android.content.Intent;

import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    TextView profileName, profileEmail, fitnessGoal;
    Button editProfileButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        fitnessGoal = findViewById(R.id.fitnessGoal);

        editProfileButton = findViewById(R.id.editProfileButton);
        backButton = findViewById(R.id.backButton);

        // Load demo profile information
        android.content.SharedPreferences prefs =
                getSharedPreferences("FitTrackPrefs", MODE_PRIVATE);

        profileName.setText(
                prefs.getString("name", "FitTrack User")
        );

        profileEmail.setText(
                prefs.getString("email", "user@example.com")
        );

        fitnessGoal.setText(
                "Goal: " + prefs.getString("goal", "Stay Active")
        );

        editProfileButton.setOnClickListener(v -> showEditDialog());

        backButton.setOnClickListener(v -> finish());

        Button logoutButton = findViewById(R.id.logoutButton);

        logoutButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    ProfileActivity.this,
                    LoginActivity.class
            );

            intent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_CLEAR_TASK
            );

            startActivity(intent);
            finish();
        });

    }

    private void showEditDialog() {

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(40, 20, 40, 10);

        EditText nameInput = new EditText(this);
        nameInput.setHint("Enter your name");
        nameInput.setText(profileName.getText().toString());
        nameInput.setSingleLine(true);
        layout.addView(nameInput);

        EditText goalInput = new EditText(this);
        goalInput.setHint("Enter fitness goal");
        goalInput.setText(
                fitnessGoal.getText().toString().replace("Goal: ", "")
        );
        goalInput.setSingleLine(true);
        layout.addView(goalInput);

        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Edit Profile")
                .setView(layout)
                .setPositiveButton("Save", null)
                .setNegativeButton("Cancel", (d, which) -> d.dismiss())
                .create();

        dialog.setOnShowListener(d -> {
            dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                    .setOnClickListener(v -> {

                        String name = nameInput.getText().toString().trim();
                        String goal = goalInput.getText().toString().trim();

                        if (name.isEmpty()) {
                            nameInput.setError("Enter your name");
                            return;
                        }

                        if (goal.isEmpty()) {
                            goalInput.setError("Enter a fitness goal");
                            return;
                        }

                        profileName.setText(name);
                        fitnessGoal.setText("Goal: " + goal);

                        getSharedPreferences("FitTrackPrefs", MODE_PRIVATE)
                                .edit()
                                .putString("name", name)
                                .putString("goal", goal)
                                .apply();

                        Toast.makeText(this,
                                "Profile Updated!",
                                Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    });
        });

        dialog.show();
    }
}
