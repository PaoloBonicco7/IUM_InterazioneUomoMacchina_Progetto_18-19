package com.example.ripetizioni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;

public class LoginActivity extends AppCompatActivity {

    private EditText username, password;
    private String u, p;

    private static Model model;

    private RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        model = new Model();

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Button accedi = findViewById(R.id.accedi_btn);
        Button salta = findViewById(R.id.salta_btn);

        //Listener accedi_btn
        accedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u = username.getText().toString();
                p = password.getText().toString();
                params = new RequestParams();
                params.put("username_log", u);
                params.put("password_log", p);
                params.put("azione", "Login");

                Toast.makeText(LoginActivity.this, "Attempt to Login of user " + u, Toast.LENGTH_SHORT).show();

                model.checkLogin(LoginActivity.this, ChooseActivity.class, u, p, params);
            }
        });

        salta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new RequestParams();
                params.put("azione", "noLogin");

                model.noLogin(LoginActivity.this, NoAutenticatedUser.class, params);
            }
        });
    }
}