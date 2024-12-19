package com.example.wmp_final_exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SummaryEnrollmentActivity extends AppCompatActivity {

    private TextView textViewSummaryDetails, textViewTotalCredits;
    private Button buttonBackToMain;
    private ArrayList<Course> enrolledCourses;
    private int totalCredits = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_enrollment);

        textViewSummaryDetails = findViewById(R.id.textViewSummaryDetails);
        textViewTotalCredits = findViewById(R.id.textViewTotalCredits);
        buttonBackToMain = findViewById(R.id.buttonBackToMain);

        // Get enrolled courses from intent
        enrolledCourses = (ArrayList<Course>) getIntent().getSerializableExtra("enrolledCourses");

        if (enrolledCourses != null && !enrolledCourses.isEmpty()) {
            StringBuilder summaryBuilder = new StringBuilder();
            for (Course course : enrolledCourses) {
                summaryBuilder.append(course.getName()).append(" - ").append(course.getCredits()).append(" SKS\n");
                totalCredits += course.getCredits();
            }
            textViewSummaryDetails.setText(summaryBuilder.toString());
            textViewTotalCredits.setText("Total SKS: " + totalCredits);
        } else {
            textViewSummaryDetails.setText("No courses enrolled.");
        }

        buttonBackToMain.setOnClickListener(v -> {
            Intent intent = new Intent(SummaryEnrollmentActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}