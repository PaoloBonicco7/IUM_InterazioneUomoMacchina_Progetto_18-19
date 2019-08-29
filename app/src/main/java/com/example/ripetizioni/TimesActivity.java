package com.example.ripetizioni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TimesActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<String> orari = new ArrayList<>();
    ArrayList<MostraCatalogo> cat = new ArrayList<>();
    String username, subject, doc, catalogo;
    Bundle extras;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);

        if(extras != null) {
            username = (String) extras.get("username");
            subject = (String) extras.get("subject");
            doc = (String) extras.get("doc");
            cat = (ArrayList<MostraCatalogo>) extras.get("catalogoDocente");
        }

        textView = findViewById(R.id.textView5);
        textView.setText("");

        if (cat != null) {
            for (MostraCatalogo list: cat) {
                catalogo = catalogo + "\n" + list;
            }
        }

        for (MostraCatalogo list : cat) {
            String start = String.valueOf(list.getOraInizio());
            String end = String.valueOf(list.getOraFine());
            orari.add(start + "  " + end);
        }

        Spinner spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.orari, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String s = (String) parent.getItemAtPosition(position);

        textView = findViewById(R.id.textView5);
        textView.setText(s);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(TimesActivity.this, "DEVI SELEZIONARE UN ORARIO", Toast.LENGTH_SHORT).show();
    }
}
