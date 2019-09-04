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

public class VisualizzaRipetizioni extends AppCompatActivity {

    String username, p1, p2, txt, txt2 = "";
    ArrayList<MostraEffettuate> cat = new ArrayList<>();
    MostraEffettuate prenotazione;
    TextView tv2, tv6, tv3;
    int check = 0;
    String[] parts;
    Button btn1, btn2;
    Bundle extras;
    private static Model model = new Model();
    RequestParams params;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza_ripetizioni);
        tv2 = findViewById(R.id.textView2);
        tv3 = findViewById(R.id.textView3);
        Spinner spinner = (Spinner)findViewById(R.id.spinner2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, android.R.id.text1);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);

        extras = getIntent().getExtras();

        if(extras != null) {
            username = extras.getString("username");
            cat = (ArrayList<MostraEffettuate>) extras.get("catalogo");
        }

        spinnerAdapter.add("Seleziona Corso");
        spinnerAdapter.notifyDataSetChanged();

        for (MostraEffettuate elem : cat) {
            txt = elem.getIdCatalogo() + ": " + elem.getTitolo() + " - " + elem.getCognome() + " " + elem.getNome()
                    + " ore " + String.valueOf(elem.getOraInizio());
            spinnerAdapter.add(txt);
        }

        spinnerAdapter.notifyDataSetChanged();

        txt = "";
        txt2 = "";
        for (MostraEffettuate eff : cat) {
            if(eff.getStato() == "attiva") {
                txt = txt + " - " + eff.getTitolo() + ": " + eff.getCognome() + " " + eff.getNome()
                        + " alle ore " + String.valueOf(eff.getOraInizio()) + ", stato: " + eff.getStato() + "\n";
            } else {
                txt2 = txt2 + " - " + eff.getTitolo() + ": " + eff.getCognome() + " " + eff.getNome()
                        + " alle ore " + String.valueOf(eff.getOraInizio()) + ", stato: " + eff.getStato() + "\n";
            }
        }

        tv2.setText(txt2);
        tv3.setText(txt);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(++check >1) {
                    tv6 = findViewById(R.id.textView6);
                    String ripetizione = "";

                    //Extract value from spinner
                    String s = (String) parent.getItemAtPosition(position);
                    if(s != "Seleziona Corso") {
                        parts = s.split(":");

                        p1 = parts[0];
                        p2 = parts[1];

                        tv6.setText(parts[1]);

                        btn1.setVisibility(View.VISIBLE);
                    } else {
                        btn1.setVisibility(View.INVISIBLE);
                        Toast.makeText(VisualizzaRipetizioni.this, "Selezionare una ripetizione", Toast.LENGTH_SHORT).show();
                        tv6.setText("SELEZIONA UNA PRENOTAZIONE PER CANCELLARLA");
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                Toast.makeText(VisualizzaRipetizioni.this, "Seleziona una ripetizione da cancellare", Toast.LENGTH_SHORT).show();
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new RequestParams();

                params.put("username", username);
                params.put("catalogo", p1);
                params.put("azione", "Cancella");

                model.cancella(VisualizzaRipetizioni.this, CheckActivity.class, username, params);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                params = new RequestParams();

                params.put("username", username);
                params.put("azione", "VisualizzaCancellate");

                model.getCancellate(VisualizzaRipetizioni.this, DeleteActivity.class, username, params);
            }
        });

    }
}
