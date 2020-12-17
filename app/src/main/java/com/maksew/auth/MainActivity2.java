package com.maksew.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private TextView logCheck, logRes, passCheck;
    private String logAdm, passAdm;
    private Resources.Theme theme;
    private boolean isRight;
    private Button enter, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        logCheck = findViewById(R.id.loginCheck);
        passCheck = findViewById(R.id.passCheck);
        logRes = findViewById(R.id.loginRes);
        enter = findViewById(R.id.enter);
        exit = findViewById(R.id.exit);
        Bundle args = getIntent().getExtras();
        logAdm = "admin";
        passAdm = "chopper123";
        if(args!=null){
            logCheck.setText("Введенный логин: " + args.get("login").toString());
            passCheck.setText("Введенный пароль: " + args.get("password").toString());
            if(args.get("login").equals(logAdm) && args.get("password").equals(passAdm)){
                logRes.setText("Логин и пароль введены верно");
                logRes.setTextColor(getResources().getColor(R.color.green, theme));
                isRight = true;
            }
            else{
                logRes.setText("Логин и/или пароль введены неверно");
                isRight = false;
                logRes.setTextColor(getResources().getColor(R.color.red, theme));
            }
        }
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isRight){
                    Intent intent1 = new Intent(MainActivity2.this, MainActivity3.class);
                    setResult(RESULT_OK, intent1);
                    startActivity(intent1);
                }
            }
        });
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if(isRight){
                    setResult(RESULT_OK, intent);
                }
                else{
                    setResult(RESULT_CANCELED, intent);
                }
                finish();
            }
        });
    }
}