package com.example.pedrito.delivery_pizza.Delivery;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pedrito.delivery_pizza.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cardapio extends Activity {

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
