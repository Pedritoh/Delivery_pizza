package com.example.pedrito.delivery_pizza.Delivery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.pedrito.delivery_pizza.R;


public class pedidos extends AppCompatActivity {

    final static String urlAddress="http://pediuchegou.ddns.net/aplicativo/cardapio.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);


            final Spinner sp = (Spinner) findViewById(R.id.sp);

            new Downloader2(pedidos.this,urlAddress,sp).execute();
        }



}