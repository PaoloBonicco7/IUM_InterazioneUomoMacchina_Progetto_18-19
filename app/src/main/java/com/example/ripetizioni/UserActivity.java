package com.example.ripetizioni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.loopj.android.http.RequestParams;

public class UserActivity extends AppCompatActivity {

    String username;
    private RequestParams params;
    private static Model model = new Model();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button lun = findViewById(R.id.lun_btn);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            username = extras.getString("username");
        }

        lun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new RequestParams();
                params.put("azione", "Richiesta_slot");
                params.put("day", "lunedì");
                params.put("username", username);

                model.dayInfo(UserActivity.this, DayActivity.class, params);
            }
        });
    }
}
