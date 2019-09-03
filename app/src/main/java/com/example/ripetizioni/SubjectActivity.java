package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SubjectActivity extends AppCompatActivity {

    Button doc1;
    Button doc2;

    ArrayList<MostraCatalogo> cat = new ArrayList<>();
    ArrayList<String> teacher = new ArrayList<>();

    String catalogo = "CATALOGO:\n";
    String username, subject, doc;
    Bundle extras;

    final Context ctx = SubjectActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject);

        extras = getIntent().getExtras();

        cat = (ArrayList<MostraCatalogo>)extras.get("catalogoAndroid");
        username = (String) extras.get("username");
        subject = (String) extras.get("subject");

        //System.out.println("SUBJECT ACTIVITY USERNAME\n" + username);

        if (cat != null) {
            for (MostraCatalogo list: cat) {
                catalogo = catalogo + "\n" + list;
                doc = list.getCognome();
                if(!teacher.contains(doc)) {
                    teacher.add(doc);
                }
            }
            compose(teacher);

        } else {
            Toast.makeText(ctx, "Non ci sono ripetizioni disponibili di " + subject +
                    " per il giorno selezionato", Toast.LENGTH_SHORT).show();
        }

        doc1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
               showTimes(cat, teacher.get(0));
            }
        });

        doc2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                showTimes(cat, teacher.get(1));
            }
        });
    }

    private void compose(ArrayList<String> teacher) {
        doc1 = findViewById(R.id.doc1);
        doc2 = findViewById(R.id.doc2);

        int i = 0;
        doc1.setText(teacher.get(i));
        i++;
        doc2.setText(teacher.get(i));
    }

    public void showTimes(ArrayList<MostraCatalogo> cat, String s) {
        ArrayList<MostraCatalogo> catDoc = new ArrayList<>();

        /*  STAMPA DI TESTING
        if (cat != null) {
            for (MostraCatalogo list: catDoc) {
                catalogo = catalogo + "\n" + list;
            }
        }

        System.out.println("SUBJECT ACTIVITY \n" + catalogo);
        */

        for (MostraCatalogo list: cat) {
            if(list.getCognome().equals(s)){
                catDoc.add(list);
            }
        }
        Intent i1 = new Intent(ctx, TimesActivity.class);

        i1.putExtra("catalogoDocente", catDoc);
        i1.putExtra("subject", subject);
        i1.putExtra("username", username);
        i1.putExtra("docente", doc);

        ctx.startActivity(i1);
    }
}
