package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActivityExercise5Lab1Firstway extends AppCompatActivity {
    final String CREDENTIAL_USERNAME = "admin";
    final String CREDENTIAL_PASSWORD = "12345";
    Button btnLogin;
    EditText edtUserName;
    EditText edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise5_lab1_firstway);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.btnLogin = findViewById(R.id.btnOk);
        this.edtUserName = findViewById(R.id.editUser);
        this.edtPassword = findViewById(R.id.editPassword);
    }
    public void onLogin(View view){
        String msg = "";
        String userName = this.edtUserName.getText().toString();
        String passWord = this.edtPassword.getText().toString();
        Boolean check = (CREDENTIAL_USERNAME.equals(userName)
                && CREDENTIAL_PASSWORD.equals(passWord));
        if(check)
            msg = "Login successfull";
        else msg = "Login fail";
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}