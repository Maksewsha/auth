package com.maksew.auth;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button logBtn;
    private EditText login, pass;
    private Toast toast;
    public static final int RET_ACT_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logBtn = findViewById(R.id.logBtn);
        login = (EditText) findViewById(R.id.loginET);
        pass = findViewById(R.id.passET);
        logBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!login.getText().toString().equals("") && !pass.getText().toString().equals("")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
                    intent.putExtra("login", login.getText().toString());
                    intent.putExtra("password", pass.getText().toString());
                    startActivityForResult(intent, RET_ACT_CODE);
                }
                else{
                    toast.makeText(getApplicationContext(), "Введите данные", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == RET_ACT_CODE){
            if(resultCode == RESULT_CANCELED){
                toast.makeText(getApplicationContext(), "Попробуйте еще раз!", Toast.LENGTH_SHORT).show();
            }
        }
    }
}