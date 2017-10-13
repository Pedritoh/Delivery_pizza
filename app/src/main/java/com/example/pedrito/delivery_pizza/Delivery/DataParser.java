package com.example.pedrito.delivery_pizza.Delivery;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pedrito on 12/10/2017.
 */
public class DataParser extends AsyncTask<Void,Void,Boolean> {
    Context c;
    String jsonData;
    ListView lv;
    ProgressDialog pd;
    ArrayList<String> spacecrafts=new ArrayList<>();
    public DataParser(Context c, String jsonData, ListView lv) {
        this.c = c;
        this.jsonData = jsonData;
        this.lv = lv;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Parse");
        pd.setMessage("Pasring..Please wait");
        pd.show();
    }
    @Override
    protected Boolean doInBackground(Void... params) {
        return this.parseData();
    }
    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        pd.dismiss();
        if(result)
        {
            ArrayAdapter adapter=new ArrayAdapter(c,android.R.layout.simple_list_item_1,spacecrafts);
            lv.setAdapter(adapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(c, spacecrafts.get(position), Toast.LENGTH_SHORT).show();

                }
            });
        }
    }
    private Boolean parseData()
    {
        try
        {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;
            spacecrafts.clear();
            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);
                String id = jo.getString ("id");
                String traco = ("-\r");
                String name = jo.getString("nomeProduto");
                String espaco = ("\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.\r.");
                String valor = jo.getString("valorProduto");
                String pula = ("\n");
                String descricao = jo.getString("descricao");
                spacecrafts.add(id+traco+name+espaco+valor+pula+descricao);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}