package com.example.pedrito.delivery_pizza.Delivery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pedrito.delivery_pizza.R;

import org.json.JSONObject;
import org.w3c.dom.Text;

public class Auxprodutos extends Activity {

    private TextView PizzaNome;
    private TextView Valor;
    String nomeUsuario;
    String url = "";
    String parametros = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxprodutos);

        TextView nomeCliente = (TextView) findViewById(R.id.userName);
        nomeUsuario = getIntent().getExtras().getString("nome_usuario");
        nomeCliente.setText(nomeUsuario);


        PizzaNome = (TextView) findViewById(R.id.PizzaNome);
        String dadoPizza = getIntent().getExtras().getString("Produto");
        PizzaNome.setText(dadoPizza);

        Valor = (TextView) findViewById(R.id.pizValor);
        String dadoPizza2 = getIntent().getExtras().getString("valor");
        Valor.setText(dadoPizza2);


        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            String Produto = PizzaNome.getText().toString();
            String valorProduto = Valor.getText().toString();

            if (Produto == "" || valorProduto == "") {

                Toast.makeText(getApplicationContext(), "nenhum campo pode estar vazio", Toast.LENGTH_LONG).show();
            } else {
                url = "http://pediuchegou.ddns.net/aplicativo/.php";

                parametros = "PizzaNome=" + Produto + "&Valor=" + valorProduto;

                new Auxprodutos.SolicitaDados().execute(url);
            }

        } else {
            Toast.makeText(getApplicationContext(), "Nenhuma conexão detectada", Toast.LENGTH_LONG).show();
        }


    }

    ;

    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);

        }

        @Override
        protected void onPostExecute(String resultado) {


        }
    }
}
