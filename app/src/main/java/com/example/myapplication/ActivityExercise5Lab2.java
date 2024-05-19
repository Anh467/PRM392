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

import java.math.BigDecimal;

public class ActivityExercise5Lab2 extends AppCompatActivity {

    Button btnAdd;
    Button btnSub;
    Button btnDiv;
    Button btnMul;
    EditText edtNum1;
    EditText edtNum2;
    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exercise5_lab2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnDiv = findViewById(R.id.btnDiv);
        btnMul = findViewById(R.id.btnMul);
        edtNum1 = findViewById(R.id.editNumber1);
        edtNum2 = findViewById(R.id.editNumber2);
        result = findViewById(R.id.editResult);

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValidInput()){
                    Toast.makeText(getApplicationContext(), "Input can't be blank", Toast.LENGTH_SHORT).show();
                    return;
                }
                Double num1 = Double.parseDouble(edtNum1.getText().toString());
                Double num2 = Double.parseDouble(edtNum2.getText().toString());
                Double resultTemp = num1 * num2;
                result.setText(resultTemp.toString());
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkValidInput()){
                    Toast.makeText(getApplicationContext(), "Input can't be blank", Toast.LENGTH_SHORT).show();
                    return;
                }
                Double num1 = Double.parseDouble(edtNum1.getText().toString());
                Double num2 = Double.parseDouble(edtNum2.getText().toString());

                if(num2 == 0){
                    Toast.makeText(getApplicationContext(), "Input number 2 can't be zero", Toast.LENGTH_SHORT).show();
                    return;
                }

                Double resultTemp = num1 / num2;
                result.setText(resultTemp.toString());
            }
        });
    }
    public boolean checkValidInput(){
        String num1Str = edtNum1.getText().toString();
        String num2Str = edtNum2.getText().toString();
        if( num2Str.isEmpty() || num1Str.isEmpty()){
            return false;
        }
        return true;
    }
    public void onAdd(View view){
        if(!checkValidInput()){
            Toast.makeText(this, "Input can't be blank", Toast.LENGTH_SHORT).show();
            return;
        }
        Double num1 = Double.parseDouble(edtNum1.getText().toString());
        Double num2 = Double.parseDouble(edtNum2.getText().toString());
        Double result = num1 + num2;
        this.result.setText(result.toString());
    }
    public void onSub(View view){
        if(!checkValidInput()){
            Toast.makeText(this, "Input can't be blank", Toast.LENGTH_SHORT).show();
            return;
        }
        Double num1 = Double.parseDouble(edtNum1.getText().toString());
        Double num2 = Double.parseDouble(edtNum2.getText().toString());
        Double result = num1 - num2;
        this.result.setText(result.toString());
    }
}