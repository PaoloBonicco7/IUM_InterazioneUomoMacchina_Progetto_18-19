package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class DayActivity extends AppCompatActivity {

    ArrayList<MostraCatalogo> cat = new ArrayList<>();
    ImageView android, programmazione, so;

    String catalogo = "CATALOGO:\n";
    String username;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        android = findViewById(R.id.android);
        programmazione = findViewById(R.id.programmazione);
        so = findViewById(R.id.so);

        extras = getIntent().getExtras();

        cat = (ArrayList<MostraCatalogo>)extras.get("catalogo");
        username = (String) extras.get("username");

        android.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showSubject(cat, "Android");
            }
        });

        programmazione.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {showSubject(cat, "Programmazione");
            }
        });

        so.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showSubject(cat, "SistemiOperativi");
            }
        });
    }

    void showSubject(ArrayList<MostraCatalogo> cat, String sub) {
        ArrayList<MostraCatalogo> catSubject = new ArrayList<>();
        final Context ctx = DayActivity.this;
        Intent i1 = new Intent(ctx, SubjectActivity.class);

        for (MostraCatalogo list: cat) {
            if(list.getTitolo().equals(sub)){
                catSubject.add(list);
            }
        }
        i1.putExtra("catalogoAndroid", catSubject);
        i1.putExtra("subject", sub);
        i1.putExtra("username", username);

        ctx.startActivity(i1);
    }
}
