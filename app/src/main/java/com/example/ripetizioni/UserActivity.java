package com.example.ripetizioni;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.loopj.android.http.RequestParams;

public class UserActivity extends AppCompatActivity {

    String username;
    private RequestParams params;
    private static Model model = new Model();
    Button lun, mar, mer, gio, ven;
    Boolean check;

    final Context ctx = UserActivity.this;
    Class c = DayActivity2.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        lun = findViewById(R.id.lun_btn);
        mar = findViewById(R.id.mar_btn);
        mer = findViewById(R.id.mer_btn);
        gio = findViewById(R.id.gio_btn);
        ven = findViewById(R.id.ven_btn);

        Bundle extras = getIntent().getExtras();
        check = false;

        if(extras != null) {
            username = extras.getString("username");
            check = (Boolean) extras.get("check");
        }

        if(check) {
            Toast.makeText(UserActivity.this, "SELEZIONARE UN ALTRO GIORNO, NON PUOI PRENOTARE " +
                    "RIPETIZIONI PER I GIORNI PASSATI", Toast.LENGTH_SHORT).show();

        }

        params = new RequestParams();
        params.put("azione", "Richiesta_slot");
        params.put("catalogo", -1);
        params.put("username", username);

        lun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "lunedì");
                model.dayInfo(ctx, c, username, params);
            }
        });

        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "martedì");
                model.dayInfo(ctx, c, username, params);
            }
        });

        mer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "mercoledì");
                model.dayInfo(ctx, c, username, params);
            }
        });

        gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "giovedì");
                model.dayInfo(ctx, c, username, params);
            }
        });

        ven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "venerdì");
                model.dayInfo(ctx, c, username, params);
            }
        });
        /*
        lun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "lunedì");
                model.dayInfo(ctx, DayActivity.class, username, params);
            }
        });

        mar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "martedì");
                model.dayInfo(ctx, DayActivity.class, username, params);
            }
        });

        mer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "mercoledì");
                model.dayInfo(ctx, DayActivity.class, username, params);
            }
        });

        gio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "giovedì");
                model.dayInfo(ctx, DayActivity.class, username, params);
            }
        });

        ven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { params.put("day", "venerdì");
                model.dayInfo(ctx, DayActivity.class, username, params);
            }
        });
        */
    }
}
