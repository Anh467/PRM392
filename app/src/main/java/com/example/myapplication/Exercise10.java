package com.example.myapplication;
import android.widget.Toast;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import
        androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercise10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise10);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // Check if the permission is already granted
        if (ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_CONTACTS) ==
                PackageManager.PERMISSION_GRANTED) {
            // Permission is already granted, you can perform the related task
            Toast.makeText(this, "Permission already granted",
                    Toast.LENGTH_SHORT).show();
        } else {
            // Request the permission
            requestPermissionLauncher.launch(android.Manifest.permission.READ_CONTACTS);
        }
    }
    // Request the permission
    private final ActivityResultLauncher<String>
            requestPermissionLauncher =
            registerForActivityResult(new
                    ActivityResultContracts.RequestPermission(), isGranted -> {
                if (isGranted) {
                    // Permission is granted. You can perform the related task
                    Toast.makeText(Exercise10.this, "Permission granted", Toast.LENGTH_SHORT).show();
                } else {
                    // Permission is denied. Show a message to the user
                    Toast.makeText(Exercise10.this, "Permissiondenied", Toast.LENGTH_SHORT).show();
                }
            });
}
