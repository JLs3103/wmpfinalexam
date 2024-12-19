package com.example.wmp_final_exam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind button dari layout
        Button buttonEnroll = findViewById(R.id.buttonEnroll);

        // Set onClickListener untuk pindah ke EnrollmentActivity
        buttonEnroll.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, EnrollmentActivity.class);
            startActivity(intent);
        });
    }
}