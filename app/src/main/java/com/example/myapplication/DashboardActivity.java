
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    TextView workoutCard, waterCard, stepsCard, goalsCard;
    Button profileButton, logoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        workoutCard = findViewById(R.id.workoutCard);
        waterCard = findViewById(R.id.waterCard);
        stepsCard = findViewById(R.id.stepsCard);
        goalsCard = findViewById(R.id.goalsCard);

        profileButton = findViewById(R.id.profileButton);
        logoutButton = findViewById(R.id.logoutButton);


        workoutCard.setOnClickListener(v -> {
            Intent intent = new Intent(
                    DashboardActivity.this,
                    WorkoutActivity.class
            );
            startActivity(intent);
        });


        waterCard.setOnClickListener(v ->
                Toast.makeText(this,
                        "Daily water goal: 8 glasses",
                        Toast.LENGTH_SHORT).show()
        );

        stepsCard.setOnClickListener(v ->
                Toast.makeText(this,
                        "Daily steps: 5,000",
                        Toast.LENGTH_SHORT).show()
        );

        goalsCard.setOnClickListener(v ->
                Toast.makeText(this,
                        "Stay active and healthy!",
                        Toast.LENGTH_SHORT).show()
        );

        profileButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    DashboardActivity.this,
                    ProfileActivity.class
            );
            startActivity(intent);
        });

        logoutButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    DashboardActivity.this,
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
}
