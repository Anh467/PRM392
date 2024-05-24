package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityExercise6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise6);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Log.i("Main Activity", "State: Create");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Main Activity", "State: Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Main Activity", "State: Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Main Activity", "State: Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Main Activity", "State: Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Main Activity", "State: Destroy");
    }
}