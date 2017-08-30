package com.example.pedrito.delivery_pizza.Delivery;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import com.example.pedrito.delivery_pizza.R;

import java.util.ArrayList;

public class pedidos extends AppCompatActivity {

}
    /*
    private Spinner spinnerCard;
    String[] listaProdutos;//new String
    int posicao=0;
    String url = "";
    String parametros = "";
    String nome,valor;
    String produtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedidos);

        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            url = "http://10.0.2.2/html/login/produtos.php";

            parametros = "nome=" +nome + "&valor=" + valor;

            //ArrayAdapter<String> produtos = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,listaProdutos);
            spinnerCard = (Spinner) findViewById(R.id.spinnerCardapio);
            ArrayAdapter<String> ;
            produtos  = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,produtos);
            spinnerCard.setAdapter(parametros);

            }

            new pedidos.SolicitaProdutos().execute(url);
        } else {
            Toast.makeText(getApplicationContext(), "Nenhuma conexão detectada", Toast.LENGTH_LONG).show();
        }
    }
    public class SolicitaProdutos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);

        }

        @Override
        protected void onPostExecute(String resultado) {

            if (resultado.contains("login_ok,")) {
                String[] dados = resultado.split(",");

                Resultado1 = (spinnerCard) findViewById(R.id.spinnerCardapio);
                Resultado1.
                Toast.makeText(getApplicationContext(), "Deu certo", Toast.LENGTH_LONG).show();
             Spinner
                //  email1.setText(resultado + dados[0]);
                //Intent Formasdepagamento = new Intent(pedidos.this, FormasPagamento.class);
                //Formasdepagamento.putExtra("nome_usuario",dados[1]);
                // abreInicio.putExtra("id_usario",dados[1]);
               // startActivity(Formasdepagamento);

            } else {

                Toast.makeText(getApplicationContext(), "Não foi encontrado no BD", Toast.LENGTH_LONG).show();
            }


        }
    }


}


 spinnerCard= (Spinner) findViewById(R.id.spinnerCardapio);
         // Create an ArrayAdapter using the string array and a default spinner layout
         ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        try{
        char separador=',';
        int produtos=0;
        for(int i=0.i<resposta.length();i++)
        if(separador == resposta.charAt(i))
        produtos++;
        listaprodutos = new String[produtos];
        char caracter_lido=resposta.charAt(0);
        String nome="";
        for(int i=0;caracter_lido !='^')


        }catch(Exception e){


*/