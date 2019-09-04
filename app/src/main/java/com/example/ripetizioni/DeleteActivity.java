package com.example.ripetizioni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity {

    Bundle extras;
    String username;
    String txt = "";
    ArrayList<MostraCancellate> cat;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        tv2 = findViewById(R.id.tv2);

        extras = getIntent().getExtras();

        if(extras != null) {
            username = extras.getString("username");
            cat = (ArrayList<MostraCancellate>) extras.get("cancellazioni");
        }

        for(MostraCancellate r : cat){
            txt = txt + " - " +r.getTitolo() + ": prof. " + r.getCognome() + " " + r.getNome() + " alle ore "
                + r.getOraInizio() + "\n";
        }

        tv2.setText(txt);
    }
}
