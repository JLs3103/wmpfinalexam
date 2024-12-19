package com.example.wmp_final_exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EnrollmentActivity extends AppCompatActivity {

    private RecyclerView recyclerViewCourses;
    private Button buttonSubmit, buttonBack;
    private TextView textViewTotalCredits;
    private ArrayList<Course> coursesList;
    private CourseAdapter adapter;
    private int totalCredits = 0;
    private static final int MAX_CREDITS = 24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollment);

        recyclerViewCourses = findViewById(R.id.recyclerViewCourses);
        buttonSubmit = findViewById(R.id.buttonSubmitEnrollment);
        buttonBack = findViewById(R.id.buttonBack);
        textViewTotalCredits = findViewById(R.id.textViewTotalCredits);

        // Initialize course list
        coursesList = getCourses();
        adapter = new CourseAdapter(this, coursesList);
        recyclerViewCourses.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCourses.setAdapter(adapter);

        // Update total credits initially
        updateTotalCredits();

        // Handle Submit Enrollment
        buttonSubmit.setOnClickListener(v -> handleEnrollment());

        // Handle Back Button
        buttonBack.setOnClickListener(v -> {
            Intent intent = new Intent(EnrollmentActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    public void updateTotalCredits() {
        totalCredits = 0;
        for (Course course : coursesList) {
            if (course.isSelected()) {
                totalCredits += course.getCredits();
            }
        }
        textViewTotalCredits.setText("Total SKS yang dipilih: " + totalCredits);
    }

    private void handleEnrollment() {
        totalCredits = 0;
        ArrayList<Course> selectedCourses = new ArrayList<>();

        for (Course course : coursesList) {
            if (course.isSelected()) {
                totalCredits += course.getCredits();
                selectedCourses.add(course);
            }
        }

        if (totalCredits > MAX_CREDITS) {
            Toast.makeText(this, "Cannot enroll more than 24 credits. Please adjust your selection.", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(EnrollmentActivity.this, SummaryEnrollmentActivity.class);
            intent.putExtra("enrolledCourses", selectedCourses);
            startActivity(intent);
        }
    }

    private ArrayList<Course> getCourses() {
        ArrayList<Course> courses = new ArrayList<>();
        courses.add(new Course("Survival English", 0));
        courses.add(new Course("Calculus", 3));
        courses.add(new Course("Programming Concepts", 3));
        courses.add(new Course("Discrete Mathematics", 3));
        courses.add(new Course("Economic Survival 1: Business Creation / Internship Experience", 3));
        courses.add(new Course("Web Programming", 3));
        courses.add(new Course("Computer Organization and Architecture", 3));
        courses.add(new Course("Fluency and Speed Development", 0));
        courses.add(new Course("Computer Network", 3));
        courses.add(new Course("Database System", 3));
        courses.add(new Course("Economic Survival 2: Business Launch / Internship Experience", 3));
        courses.add(new Course("Probability and Statistics", 3));
        courses.add(new Course("Server-Side Internet Programming", 3));
        courses.add(new Course("Linear Algebra", 3));
        courses.add(new Course("Object Oriented and Visual Programming", 3));
        courses.add(new Course("Accuracy Development", 0));
        courses.add(new Course("Pancasila", 2));
        courses.add(new Course("Religion", 2));
        courses.add(new Course("Citizenship", 2));
        courses.add(new Course("Indonesian Language", 2));
        courses.add(new Course("Academic Writing", 0));
        courses.add(new Course("Software Engineering", 3));
        courses.add(new Course("Data Structure and Algorithm", 3));
        courses.add(new Course("Network Security", 3));
        courses.add(new Course("Artificial Intelligence", 3));
        courses.add(new Course("Wireless and Mobile Programming", 3));
        courses.add(new Course("3D Computer Graphics and Animation", 3));
        courses.add(new Course("Numerical Methods", 3));
        courses.add(new Course("Biology", 3));
        return courses;
    }
}
