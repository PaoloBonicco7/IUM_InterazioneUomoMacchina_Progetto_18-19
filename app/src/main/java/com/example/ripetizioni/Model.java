package com.example.ripetizioni;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

class Model {
    private static final String myUrl= MyURL.getMYURL();
    private static final String MYURL = myUrl;

    private static AsyncHttpClient client;

    Model() {
        client = new AsyncHttpClient();
    }

    void register(final Context ctx, RequestParams params) {

        client.get(MYURL, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                Toast.makeText(ctx, "Registrazione_success" + response, Toast.LENGTH_SHORT).show();
                //System.out.println("hola");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(ctx, "Gia Esistente", Toast.LENGTH_SHORT).show();
                // System.out.println("puto");

            }
        });
    }


    void checkLogin(final Context ctx, final Class classe, String u, String p, RequestParams params) {

        final String username = new String(u);
        final String password = new String(p);

        client.get(MYURL, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                //super.onSuccess(statusCode, headers, response);
                Toast.makeText(ctx, "Login_success" + username, Toast.LENGTH_SHORT).show();
                Intent i1 = new Intent(ctx, classe);
                Intent i2 = new Intent(ctx, AdministratorActivity.class);

                //Controllo se è amministratore
                Boolean isAdmin = false;

                try {
                    isAdmin = response.getBoolean("ISADMIN");
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                if(!isAdmin) {
                    i1.putExtra("username", username);
                    ctx.startActivity(i1);
                } else {
                    i2.putExtra("username", username);
                    ctx.startActivity(i2);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(ctx, "username o password incorretta", Toast.LENGTH_SHORT).show();
            }
        });
    }

    void dayInfo(final Context ctx, final Class classe, RequestParams params) {
        client.get(MYURL, params, new JsonHttpResponseHandler() {
            String obj;
            ArrayList<MostraCatalogo> cat = new ArrayList<>();

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Intent i1 = new Intent(ctx, classe);

                try {
                    obj = response.getString("CATALOGO_Android");
                    Type listType = new TypeToken<ArrayList<MostraCatalogo>>(){}.getType();
                    cat = new Gson().fromJson(obj, listType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i1.putExtra("catalogo", cat);

                ctx.startActivity(i1);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(ctx, "ERROR: Tentativo di connessione al server fallita", Toast.LENGTH_SHORT).show();
            }
        });
    }

}