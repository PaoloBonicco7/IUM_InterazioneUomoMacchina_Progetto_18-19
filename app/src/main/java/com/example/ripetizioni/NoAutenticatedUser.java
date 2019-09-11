package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NoAutenticatedUser extends AppCompatActivity {

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_autenticated_user);

        Button login = findViewById(R.id.button);
        TextView tw = findViewById(R.id.textView3);

        extras = getIntent().getExtras();

        ArrayList<Catalogo> cat = new ArrayList<>();
        cat = (ArrayList<Catalogo>)extras.get("catalogo");
        String catalogo = "";

        /*
        *         this.idCatalogo = idCatalogo;
        this.idDocente = idDocente;
        this.idCorso = idCorso;
        this.giorno = giorno;
        this.oraInizio = oraInizio;
        this.oraFine = oraFine;
        this.stato = stato;*/

        for (Catalogo eff : cat) {
            catalogo = catalogo + eff.toString() + "\n";
        }

        tw.setText(catalogo);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Context ctx = NoAutenticatedUser.this;

                Intent i1 = new Intent(ctx, LoginActivity.class);

               ctx.startActivity(i1);
            }
        });
    }
}
