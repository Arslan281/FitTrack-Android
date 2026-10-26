
package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WorkoutActivity extends AppCompatActivity {

    int completedSets = 0;
    final int totalSets = 5;

    TextView exerciseName, exerciseDetails, progressText;
    ProgressBar workoutProgress;
    RadioGroup exerciseGroup;
    Button completeButton, resetWorkoutButton, backDashboardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        exerciseName = findViewById(R.id.exerciseName);
        exerciseDetails = findViewById(R.id.exerciseDetails);
        progressText = findViewById(R.id.progressText);
        workoutProgress = findViewById(R.id.workoutProgress);
        exerciseGroup = findViewById(R.id.exerciseGroup);

        completeButton = findViewById(R.id.completeButton);
        resetWorkoutButton = findViewById(R.id.resetWorkoutButton);
        backDashboardButton = findViewById(R.id.backDashboardButton);

        exerciseGroup.setOnCheckedChangeListener((group, checkedId) -> {

            if (checkedId == R.id.pushupRadio) {
                exerciseName.setText("Push-ups");
                exerciseDetails.setText("10 repetitions per set");
            } else if (checkedId == R.id.squatRadio) {
                exerciseName.setText("Squats");
                exerciseDetails.setText("15 repetitions per set");
            } else if (checkedId == R.id.plankRadio) {
                exerciseName.setText("Plank");
                exerciseDetails.setText("Hold for 30 seconds per set");
            }

            completedSets = 0;
            updateProgress();
        });

        completeButton.setOnClickListener(v -> {

            if (completedSets < totalSets) {
                completedSets++;
                updateProgress();

                if (completedSets == totalSets) {
                    Toast.makeText(this,
                            "Workout Completed! Great Job!",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        resetWorkoutButton.setOnClickListener(v -> {
            completedSets = 0;
            updateProgress();
            Toast.makeText(this,
                    "Workout Reset",
                    Toast.LENGTH_SHORT).show();
        });

        backDashboardButton.setOnClickListener(v -> finish());

        updateProgress();
    }

    private void updateProgress() {
        progressText.setText(completedSets + " / " + totalSets + " Sets");
        workoutProgress.setProgress(completedSets);
        completeButton.setEnabled(completedSets < totalSets);
    }
}
