package com.example.pedrito.delivery_pizza.Delivery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pedrito.delivery_pizza.R;

import org.w3c.dom.Text;

public class TelaInicial extends AppCompatActivity {

    TextView nomeCliente;
    Button Cardapio;
    String nomeUsuario;
    Button pedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        nomeCliente = (TextView) findViewById(R.id.TextNomeCliente);
        nomeUsuario = getIntent().getExtras().getString("nome_usuario");
        nomeCliente.setText(nomeUsuario);


        Cardapio = (Button) findViewById(R.id.btnCardapio);
        Cardapio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicial.this,Cardapio.class));
            }
        });

        pedido = (Button) findViewById(R.id.btnNovoPedido);
        pedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TelaInicial.this,pedidos.class));
            }
        });

    }
}
