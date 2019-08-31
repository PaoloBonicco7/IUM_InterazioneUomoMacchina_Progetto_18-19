package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseActivity extends AppCompatActivity {

    String username, nome;
    TextView textView;
    Button prenota, visualizza;
    final Context ctx = ChooseActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
        textView = findViewById(R.id.textView2);
        Bundle extras = getIntent().getExtras();
        username = (String) extras.get("username");

        nome = "Ciao benvenuto " + username;

        textView.setText(nome);

        prenota = findViewById(R.id.prenota);
        visualizza = findViewById(R.id.visualizza);

        prenota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ctx, UserActivity.class);
                i1.putExtra("username", username);

                ctx.startActivity(i1);
            }
        });

        visualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                ** FARE METODO NEL MODEL CHE VA A RICHIEDERE LISTA PRENOTAZIONI UTENTE E INIZIARE NUOVA ACTIVITY
                Intent i1 = new Intent(ctx, UserActivity.class);
                i1.putExtra("username", username);

                ctx.startActivity(i1);
                */
                Toast.makeText(ChooseActivity.this, "Con la prossima patch vedrai la tua lista prenotazioni", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
