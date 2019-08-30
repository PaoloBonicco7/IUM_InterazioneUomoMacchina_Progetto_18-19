package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class DayActivity extends AppCompatActivity {

    ArrayList<MostraCatalogo> cat = new ArrayList<MostraCatalogo>();
    ImageView android;

    //SPEZZARE QUESTA DICHIARAZIONE

    //ImageView programmazione = findViewById(R.id.programmazione);
    //ImageView so = findViewById(R.id.so);

    String catalogo = "CATALOGO:\n";
    String username;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        android = findViewById(R.id.android);

        extras= getIntent().getExtras();

        cat = (ArrayList<MostraCatalogo>)extras.get("catalogo");
        username = (String) extras.get("username");

        if (cat != null) {
            for (MostraCatalogo list: cat) {
                catalogo = catalogo + "\n" + list;
            }
        }

        //System.out.println(catalogo);

        android.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showSubject(cat, "Android");
            }
        });
    }

    void showSubject(ArrayList<MostraCatalogo> cat, String sub) {
        //String catAndroid = "";
        ArrayList<MostraCatalogo> catSubject = new ArrayList<MostraCatalogo>();
        final Context ctx = DayActivity.this;
        Intent i1 = new Intent(ctx, SubjectActivity.class);

        for (MostraCatalogo list: cat) {
            if(list.getTitolo().equals("Android")){
                catSubject.add(list);
            }
        }
        i1.putExtra("catalogoAndroid", catSubject);
        i1.putExtra("subject", sub);
        i1.putExtra("username", username);

        ctx.startActivity(i1);
    }
}
