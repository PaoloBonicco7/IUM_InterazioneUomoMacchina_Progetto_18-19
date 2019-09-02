package com.example.ripetizioni;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;

import java.util.ArrayList;

public class VisualizzaRipetizioni extends AppCompatActivity {

    String username;
    private RequestParams params;
    ArrayList<MostraEffettuate> cat = new ArrayList<>();
    TextView tv;
    String txt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_ripetizioni);
        tv = findViewById(R.id.textView2);
        Spinner spinner = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        Bundle extras = getIntent().getExtras();

        if(extras != null) {
            username = extras.getString("username");
            cat = (ArrayList<MostraEffettuate>) extras.get("catalogo");
        }

        for (MostraEffettuate elem : cat) {
            txt = elem.getTitolo() + ": " + elem.getCognome() + " " + elem.getNome()
                    + " ore " + String.valueOf(elem.getOraInizio());
            spinnerAdapter.add(txt);
        }

        spinnerAdapter.notifyDataSetChanged();

        txt = "";
        for (MostraEffettuate eff : cat) {
            txt = txt + eff.getTitolo() + ": " + eff.getCognome() + " " + eff.getNome()
                    + " alle ore " + String.valueOf(eff.getOraInizio()) + "\n";
        }

        tv.setText(txt);

        /*
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected (AdapterView < ? > parent, View view, int position, long id){
                int check = 0;
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
                Toast.makeText(VisualizzaRipetizioni.this, "DEVI SELEZIONARE UN ORARIO", Toast.LENGTH_SHORT).show();
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
        */
    }
}
