package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityExercise8Lab2_Main2 extends AppCompatActivity {
    private TextView textViewId;
    private TextView textViewName;
    private ImageView imageView;
    private TextView textViewDescription;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise8_lab2_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main
        ), (v, insets) -> {
            Insets systemBars =
                    insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top,
                    systemBars.right, systemBars.bottom);
            return insets;
        });
        textViewId = findViewById(R.id.textViewDetailId2);
        textViewName = findViewById(R.id.textViewDetailName2);
        imageView = findViewById(R.id.imageView);
        textViewDescription = findViewById(R.id.textViewDetailDescription2);

        int id = getIntent().getIntExtra("id", -1);
        String name = getIntent().getStringExtra("name");
        int image = getIntent().getIntExtra("image", 0);
        String description = getIntent().getStringExtra("description");

        textViewId.setText(String.valueOf(id));
        textViewName.setText(name);
        imageView.setBackgroundResource(image);
        textViewDescription.setText(description);
    }
}