package com.example.pedrito.delivery_pizza.Delivery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Pedrito on 15/10/2017.
 */

public class DataParser2 extends AsyncTask<Void,Void,Boolean> {

    Context c;
    String jsonData;
    Spinner sp;
    ProgressDialog pd;
    ArrayList<String> spacecrafts=new ArrayList<>();

    public DataParser2(Context c, String jsonData, Spinner sp) {
        this.c = c;
        this.jsonData = jsonData;
        this.sp = sp;
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
        return this.parseData2();
    }
    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        pd.dismiss();
        if(result)
        {
            ArrayAdapter adapter=new ArrayAdapter(c,android.R.layout.simple_list_item_1,spacecrafts);
            sp.setAdapter(adapter);

            sp.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Toast.makeText(c, spacecrafts.get(position), Toast.LENGTH_SHORT).show();









                }
            });
        }
    }
    private Boolean parseData2()
    {
        try
        {
            JSONArray ja = new JSONArray(jsonData);
            JSONObject jo;
            spacecrafts.clear();
            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);

                String name = jo.getString("nomeProduto");

                String valor = jo.getString("valorProduto");

                spacecrafts.add(name+valor);
            }
            return true;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return false;
    }
}
