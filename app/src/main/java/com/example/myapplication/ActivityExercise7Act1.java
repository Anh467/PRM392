package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.net.URI;

public class ActivityExercise7Act1 extends AppCompatActivity {

    EditText edt_YourName;
    EditText edt_YourWebsite;
    Button btn_ClickMe;
    Button btn_Dial;
    Button btn_BrowserUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise7_act1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edt_YourName = findViewById(R.id.edt_YourName);
        edt_YourWebsite = findViewById(R.id.edt_YourWebsite);
        btn_ClickMe = findViewById(R.id.btn_ClickMe);
        btn_Dial = findViewById(R.id.btn_Dial);
        btn_BrowserUrl = findViewById(R.id.btn_BrowserUrl);

        btn_ClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_YourName.getText().toString();
                Intent intent = new Intent(ActivityExercise7Act1.this, ActivityExercise7Act2.class);
                intent.putExtra("msg_Name", name);
                startActivity(intent);
            }
        });

        btn_Dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                startActivity(intent);
            }
        });

        btn_BrowserUrl.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = edt_YourWebsite.getText().toString();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

}