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

    void checkLogin(final Context ctx, final Class classe, String u, String p, RequestParams params) {

        final String username = new String(u);
        final String password = new String(p);

        client.get(MYURL, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
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

    void dayInfo(final Context ctx, final Class classe, String u, RequestParams params) {
        final String username = new String(u);
        final String[] obj = new String[1];
        final ArrayList<MostraCatalogo>[] cat = new ArrayList[]{new ArrayList<>()};

        client.get(MYURL, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Intent i1 = new Intent(ctx, classe);

                try {
                    obj[0] = response.getString("CATALOGO_Android");
                    Type listType = new TypeToken<ArrayList<MostraCatalogo>>(){}.getType();
                    cat[0] = new Gson().fromJson(obj[0], listType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i1.putExtra("catalogo", cat[0]);
                i1.putExtra("username", username);

                ctx.startActivity(i1);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                //super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(ctx, "ERROR: Tentativo di connessione al server fallita", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void prenota(final Context ctx, final Class classe, String username, RequestParams params) {
        final Boolean[] check = new Boolean[1];
        check[0] = false;
        final String u = username;
        client.get(MYURL, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    check[0] = Boolean.valueOf(response.getString("result"));
                    System.out.println("RESPONSE:\n" + check[0]);
                    if(check[0]){
                        System.out.println("PRENOTAZIONE EFFETTUATA CON SUCCESSO");
                    } else {
                        System.out.println("ERRORE DURANTE LA PRENOTAZIONE");
                    }

                    //START TimesActivity (again)
                    Intent i1 = new Intent(ctx, classe);

                    i1.putExtra("check", check[0]);
                    i1.putExtra("username", u);
                    ctx.startActivity(i1);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                System.out.println("OnFalliure ERRORE NELLA PRENOTAIZONE DI UNA RIPETIZIONE");
            }
        });

    }

    public void getPrenotazioni(final Context ctx, final Class classe, String u, RequestParams params) {
        final String username = new String(u);
        final String[] obj = new String[1];
        final ArrayList<MostraEffettuate>[] cat = new ArrayList[]{new ArrayList<>()};

        client.get(MYURL, params, new JsonHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                Intent i1 = new Intent(ctx, classe);

                try {
                    obj[0] = response.getString("prenotazioni");
                    Type listType = new TypeToken<ArrayList<MostraEffettuate>>(){}.getType();
                    cat[0] = new Gson().fromJson(obj[0], listType);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                i1.putExtra("catalogo", cat[0]);
                i1.putExtra("username", username);

                ctx.startActivity(i1);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Toast.makeText(ctx, "ERROR: Tentativo di connessione al server fallita", Toast.LENGTH_SHORT).show();
            }
        });
    }
}