package com.example.ripetizioni;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goTo(View view){
        Intent intent = new Intent(this, DatabaseActivity.class);
        startActivity(intent);
    }

    /**
     * Displays a Toast with the message.
     *
     * @param message Message to display.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void selectFisica(View view) {
        mOrderMessage = getString(R.string.fisica_request_message);
        displayToast(mOrderMessage);
    }

    public void selectMatematica(View view) {
        mOrderMessage = getString(R.string.matematica_request_message);
        displayToast(mOrderMessage);
    }

    public void selectChimica(View view) {
        mOrderMessage = getString(R.string.chimica_request_message);
        displayToast(mOrderMessage);
    }

}
