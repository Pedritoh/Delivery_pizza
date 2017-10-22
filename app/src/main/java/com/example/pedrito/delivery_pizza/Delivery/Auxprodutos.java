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
import android.widget.CheckBox;
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
    CheckBox nenhum,cheedar,catupiry,goiabada;
    Button buttonOrder;
    int totalamount;
    int valorNenhum ,valorChedar ,valorCatupiry ,valorGoiabada ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auxprodutos);
        addListenerOnButtonClick();






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

        buttonOrder.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {

                StringBuilder result = new StringBuilder();
                result.append("Bordas: ");


                if (nenhum.isChecked()) {
                    result.append("\nSem borda !");
                    valorNenhum =  0;
                    String borda = Integer.toString(valorNenhum);

                    TextView valorPizza = (TextView) findViewById(R.id.textBorda);
                    valorPizza.setText(borda);

                }else{

                }


                if (cheedar.isChecked()) {
                    result.append("\nCheedar Adicionado");
                    valorChedar = 3;

                    //aqui to setando o valor 3 para o chedar
                    TextView valorBorda = (TextView) findViewById(R.id.textBorda);
                    String borda = Integer.toString(totalamount);
                    valorBorda.setText(borda);

                }else{

                    valorChedar = 0;
                    String borda = Integer.toString(totalamount);
                    TextView valorBorda = (TextView) findViewById(R.id.textBorda);
                    valorBorda.setText(borda);
                }




                if (catupiry.isChecked()) {
                    result.append("\nCatupiry Adicionado !");
                    valorCatupiry = 2;
                    //setando valor para o catupiry
                    String borda = Integer.toString(totalamount);
                    TextView valorBorda = (TextView) findViewById(R.id.textBorda);
                    valorBorda.setText(borda);

                }else{
                    valorCatupiry=0;
                    String borda = Integer.toString(totalamount);
                    TextView valorPizza = (TextView) findViewById(R.id.textBorda);
                    valorPizza.setText(borda);
                }


                if(goiabada.isChecked()){
                    result.append("\nGoiabada Adicionado !");
                    valorGoiabada = 3;
                    String borda = Integer.toString(totalamount);
                    TextView valorBorda = (TextView) findViewById(R.id.textBorda);
                    valorBorda.setText(borda);


                }else{

                    valorGoiabada=0;
                    String borda = Integer.toString(totalamount);
                    TextView valorBorda = (TextView) findViewById(R.id.textBorda);
                    valorBorda.setText(borda);

                }

                totalamount = valorNenhum+valorCatupiry+valorChedar+valorGoiabada;
                result.append("\nTotal: R$" + totalamount +"");
                //Displaying the message on the toast


                String borda = Integer.toString(totalamount);
                TextView valorBorda = (TextView) findViewById(R.id.textBorda);
                valorBorda.setText(borda);

                //recupero o dado selecionado na intent
                String dadoPizza3 = getIntent().getExtras().getString("valor");


                //converto o valor de string para INT (valor Inteiro)
                int valor = Integer.parseInt(dadoPizza3);



                //Faço a soma do valor o resultado é em INT
                int Total =  valor + totalamount;
                //Converto de int para STRING para setar no TextView

                final String subtotal = Integer.toString(Total);


                // Mostra valor Total
                final TextView valorTotal = (TextView) findViewById(R.id.TextTotal);
                valorTotal.setText(subtotal+",00");

            }


        });
    }



    private class SolicitaDados extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            return Conexao.postDados(urls[0], parametros);

        }

        @Override
        protected void onPostExecute(String resultado) {


        }
    }



    public void addListenerOnButtonClick(){
        nenhum = (CheckBox) findViewById(R.id.BoxNenhum);
        catupiry = (CheckBox) findViewById(R.id.checkCatupiry);
        cheedar = (CheckBox) findViewById(R.id.checkCheedar);
        buttonOrder = (Button) findViewById(R.id.ordemBox);
        goiabada = (CheckBox) findViewById(R.id.CheckGoiabada);


    }



    //enviar

}
