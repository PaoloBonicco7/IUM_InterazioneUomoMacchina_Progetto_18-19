package com.example.ripetizioni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class DayActivity extends AppCompatActivity {

    TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        String catalogo = "CATALOGO:\n";
        Bundle extras = getIntent().getExtras();

        ArrayList<MostraCatalogo> cat = (ArrayList<MostraCatalogo>)extras.get("catalogo");

        if (cat != null) {
            for (MostraCatalogo list: cat) {
                catalogo = catalogo + "\n" + list;
            }
        }

        System.out.println(catalogo);

        if (catalogo != null) {
            textView4.setText(catalogo);
        } else {
            textView4.setText("Qualcosa non va");
        }

    }
}
