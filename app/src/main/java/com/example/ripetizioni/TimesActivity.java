package com.example.ripetizioni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

public class TimesActivity extends AppCompatActivity {

    ArrayList<String> orari = new ArrayList<>();
    ArrayList<MostraCatalogo> catDoc = new ArrayList<>();
    String username, subject, doc, catalogo, visualizzaPrenotaz;
    Bundle extras;
    TextView textView;
    Button conferma;
    Spinner spinner;
    private static Model model = new Model();

    MostraCatalogo prenotazione;
    String[] parts;
    int oraInizio;
    int oraFine;
    int check = 0;

    private RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_times);
        textView = findViewById(R.id.textView5);
        conferma = findViewById(R.id.conferma);
        spinner = findViewById(R.id.spinner);
        extras = getIntent().getExtras();

        if(extras != null) {
            username = (String) extras.get("username");
            subject = (String) extras.get("subject");
            doc = (String) extras.get("doc");
            catDoc = (ArrayList<MostraCatalogo>) extras.get("catalogoDocente");
        }

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
                if(++check >1) {
                    textView = findViewById(R.id.textView5);
                    String catalogo = "CATALOGO PROF: \n";

                    if (catDoc.isEmpty()) {
                        System.out.println("CAT DOC VUOTO AAAAA");
                    }

                    for (MostraCatalogo list : catDoc) {
                        catalogo = catalogo + "\n" + list.toString();
                    }

                    textView.setText(catalogo);

                    //Extract value from spinner
                    String s = (String) parent.getItemAtPosition(position);
                    parts = s.split("-");

                    oraInizio = Integer.parseInt(parts[0]);
                    oraFine = Integer.parseInt(parts[1]);

                    textView.setText("Hai selezionato il blocco orario: " + s);

                    for (MostraCatalogo list : catDoc) {
                        System.out.println(list.toString());
                        if (oraInizio == list.getOraInizio()) {
                            prenotazione = list;
                        }
                    }

                    if(prenotazione != null) {
                        visualizzaPrenotaz = "Lezione di " + subject + " tenuta dal Prof. " + prenotazione.getCognome() +
                                " " + prenotazione.getNome() + " dalle ore " + prenotazione.getOraInizio() + " alle " + prenotazione.getOraFine();
                    } else {
                        visualizzaPrenotaz = "L'orario selezionato non è più disponibile";
                    }
                    textView.setText(visualizzaPrenotaz);
                    conferma.setVisibility(View.VISIBLE);
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                Toast.makeText(TimesActivity.this, "DEVI SELEZIONARE UN ORARIO", Toast.LENGTH_SHORT).show();
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.orari, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        conferma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new RequestParams();
                extras = getIntent().getExtras();

                if(extras != null) {
                    username = (String) extras.get("username");
                }

                System.out.println("USERNAME\n" + username);

                params.put("username", username);
                params.put("catalogo", prenotazione.getIdCatalogo());
                params.put("azione", "Prenota");

                model.prenota(TimesActivity.this, CheckActivity.class, username, params);
            }
        });
    }
}
