package com.example.pedrito.delivery_pizza.Delivery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedrito.delivery_pizza.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class Cardapio extends AppCompatActivity {

    Button Refresh;

    //http://localhost/html/login/cardapio.php
    final static String urlAddress="http://10.0.2.2/html/login/cardapio.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        final ListView lv= (ListView) findViewById(R.id.lv);
        Refresh = (Button) findViewById(R.id.Refresh);
        new Downloader(Cardapio.this,urlAddress,lv).execute();
    }
}


/*
public class MainActivity extends AppCompatActivity {
    final static String urlAddress="http://10.0.2.2/android/spacecraft_select_images.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ListView lv= (ListView) findViewById(R.id.lv);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Downloader(MainActivity.this,urlAddress,lv).execute();
            }
        });
    }
}
 */

/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        ListView Cardapio = (ListView) findViewById(R.id.listCardapio);
        ArrayList<String> cardapios = todosOsCardapios();



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, cardapios);
        Cardapio.setAdapter(arrayAdapter);



    }

    private ArrayList<String> todosOsCardapios() {

        ArrayList<String> cardapio = new ArrayList<String>();
        cardapio.add("Tradizionale - 36,50");
        cardapio.add("Margherita - 35,00");
        cardapio.add("La Vera Napoletana - 36,00");
        cardapio.add("Quatro Formaggi - 37,00");
        cardapio.add("Calabresa - 38,00");
        cardapio.add("Calábria - 35,00");
        cardapio.add("Pepperoni - 39,00");
        cardapio.add("Camarão - 40,00");
        cardapio.add("Della Nonna - 37,00");
        cardapio.add("Sapore - 40,00");
        cardapio.add("Portuguesa - 39,50");
        cardapio.add("Funghi Rossa - 40,00");
        cardapio.add("Pescara - 37,50");
        cardapio.add("Palmito - 38,50");
        return cardapio;

    }


}
*/