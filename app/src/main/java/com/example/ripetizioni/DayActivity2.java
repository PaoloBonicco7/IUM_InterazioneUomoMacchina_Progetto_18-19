package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DayActivity2 extends AppCompatActivity {

    TextView tw, tw1;
    Spinner spinner, spinner2;
    Bundle extras;
    int check = 0;
    String username;
    Button btn;
    String subject, teacher;
    Context ctx = DayActivity2.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2);

        tw = findViewById(R.id.textView);
        tw.setVisibility(View.INVISIBLE);

        spinner2 = findViewById(R.id.spinner2);
        spinner2.setVisibility(View.INVISIBLE);

        btn = findViewById(R.id.button2);
        btn.setVisibility(View.INVISIBLE);

        tw1 = findViewById(R.id.textView2);
        spinner = findViewById(R.id.spinner);

        extras = getIntent().getExtras();

        username = (String) extras.get("username");
        final ArrayList<MostraCatalogo> cat = (ArrayList<MostraCatalogo>) extras.get("catalogo");

        //Adapter for spinner 1
        final ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        //Adapter for spinner 2
        final ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(spinnerAdapter2);

        final ArrayList<String> materie = new ArrayList<>();

        //Seleziono le materie
        spinnerAdapter.clear();
        spinnerAdapter.add("Scegli la materia:");
        spinner.setSelection(1,false);
        spinnerAdapter.notifyDataSetChanged();
        for (MostraCatalogo elem : cat) {
            String sub = elem.getTitolo();
            if(!materie.contains(sub)) {
                materie.add(sub);
                spinnerAdapter.add(sub);
            }
        }

        spinnerAdapter.notifyDataSetChanged();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(++check >1) {
                    //Extract value from spinner
                    Toast.makeText(DayActivity2.this, "Selezionare il docente", Toast.LENGTH_SHORT).show();

                    String s = (String) parent.getItemAtPosition(position);
                    if(!s.equals("Scegli la materia:")) {
                        subject = s;

                        btn.setVisibility(View.INVISIBLE);
                        tw.setVisibility(View.VISIBLE);
                        spinner2.setVisibility(View.VISIBLE);

                        //Gestione spinner2
                        ArrayList<String> docenti = new ArrayList<>();

                        //Seleziono i docenti
                        spinnerAdapter2.clear();
                        spinnerAdapter2.add("Scegli il professore:");

                        spinner2.setSelection(1, false);
                        spinnerAdapter2.notifyDataSetChanged();
                        for (MostraCatalogo elem : cat) {
                            String sub = elem.getTitolo();
                            if (sub.equals(s)) {
                                String doc = elem.getCognome();
                                if (!docenti.contains(doc)) {
                                    docenti.add(doc);
                                    spinnerAdapter2.add(doc);
                                }
                            }
                        }
                        spinnerAdapter2.notifyDataSetChanged();
                    } else {
                        Toast.makeText(DayActivity2.this, "Selezionare un docente", Toast.LENGTH_SHORT).show();
                        btn.setVisibility(View.INVISIBLE);
                        tw.setVisibility(View.INVISIBLE);
                        spinner2.setVisibility(View.INVISIBLE);
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                Toast.makeText(DayActivity2.this, "Seleziona una materia", Toast.LENGTH_SHORT).show();
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(++check >3) {
                    //Extract value from spinner
                    String s = (String) parent.getItemAtPosition(position);
                    if(!s.equals("Scegli il professore:")){
                        teacher = s;

                        btn.setVisibility(View.VISIBLE);
                    } else {
                        Toast.makeText(DayActivity2.this, "Selezionare una materia", Toast.LENGTH_SHORT).show();
                        btn.setVisibility(View.INVISIBLE);
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                Toast.makeText(DayActivity2.this, "Seleziona un docente", Toast.LENGTH_SHORT).show();
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<MostraCatalogo> catalogoDocente = new ArrayList<>();

                for (MostraCatalogo elem: cat) {
                    if(elem.getTitolo().equals(subject) && elem.getCognome().equals(teacher)){
                        catalogoDocente.add(elem);
                    }
                }

                Intent i1 = new Intent(ctx, TimesActivity.class);

                i1.putExtra("username", username);
                i1.putExtra("subject", subject);
                i1.putExtra("doc", teacher);
                i1.putExtra("catalogoDocente", catalogoDocente);

                ctx.startActivity(i1);
            }
        });

    }
}
