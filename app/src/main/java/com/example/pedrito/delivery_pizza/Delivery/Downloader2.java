package com.example.pedrito.delivery_pizza.Delivery;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;


public class Downloader2 extends AsyncTask<Void,Void,String> {
    Context c;
    String urlAddess;
    Spinner sp;
    ProgressDialog pd;
    public Downloader2(Context c, String urlAddess, Spinner sp) {
        this.c = c;
        this.urlAddess = urlAddess;
        this.sp = sp;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setTitle("Retrieve");
        pd.setMessage("Retrieving..Please wait");
        pd.show();
    }
    @Override
    protected String doInBackground(Void... params) {
        return this.downloadData();
    }
    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        pd.dismiss();
        if(jsonData.startsWith("Error"))
        {
            Toast.makeText(c,"Unsuccessful "+jsonData,Toast.LENGTH_SHORT).show();
        }else
        {
            //PARSE
            new DataParser2(c,jsonData,sp).execute();
        }
    }
    private String downloadData()
    {
        Object connection=Connector.connect(urlAddess);
        if(connection.toString().startsWith("Error"))
        {
            return connection.toString();
        }
        try {
            HttpURLConnection con= (HttpURLConnection) connection;
            InputStream is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer jsonData=new StringBuffer();
            while ((line=br.readLine()) != null)
            {
                jsonData.append(line+"n");
            }
            br.close();
            is.close();
            return jsonData.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error "+e.getMessage();
        }
    }
}
