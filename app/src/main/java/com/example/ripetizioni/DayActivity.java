package com.example.ripetizioni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DayActivity extends AppCompatActivity {

    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        //Bundle extras = getIntent().getExtras();

        //textView4.setText(extras.toString());
    }
}
