package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CheckActivity extends AppCompatActivity {

    Bundle extras;
    TextView tv;
    Boolean ok;
    Button b;
    final Context ctx = CheckActivity.this;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        tv = findViewById(R.id.textView);
        b = findViewById(R.id.btn1);

        extras = getIntent().getExtras();
        ok = (Boolean) extras.get("check");
        username = (String) extras.get("username");

        if(ok){
            tv.setText(username + ", L'OPERAZIONE è ANDATA A BUON FINE.");
            Toast.makeText(CheckActivity.this, "LA PRENOTAZIONE è ANDATA A BUON FINE", Toast.LENGTH_SHORT).show();
        } else {
            tv.setText("ERRORE!! \n Operazione non riuscita.");
            Toast.makeText(CheckActivity.this, "ERRORE DURANTE LA REGISTRAZIONE DELLA RIPETIZIONE", Toast.LENGTH_SHORT).show();
        }

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ctx, ChooseActivity.class);
                i1.putExtra("username", username);
                ctx.startActivity(i1);
            }
        });
    }
}
