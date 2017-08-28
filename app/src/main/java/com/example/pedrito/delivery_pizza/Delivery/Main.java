package com.example.pedrito.delivery_pizza.Delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pedrito.delivery_pizza.R;

public class Main extends AppCompatActivity {


    private Button irLogin;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        irLogin = (Button) findViewById(R.id.id_Comecar);

        irLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main.this,TelaLogin.class));
            }
        });
    }
}
