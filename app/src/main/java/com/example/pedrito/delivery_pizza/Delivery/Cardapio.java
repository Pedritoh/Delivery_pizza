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
        cardapio.add("Pizza Mineira - 40,00");
        cardapio.add("Pizza Provolone - 35,00");
        cardapio.add("Pizza Paulista - 36,00");
        cardapio.add("Pizza Portuguesa - 37,00");
        cardapio.add("Pizza Calabresa - 38,00");
        cardapio.add("Pizza 4 Queijos - 35,00");
        cardapio.add("Pizza 6 Queijos - 39,00");
        cardapio.add("Pizza Especial - 40,00");
        return cardapio;

    }


}
