package com.example.exp1apirest;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ClassConnectionPost extends AsyncTask <String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
       String data=null;
       try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //conn.setDoInput(true);
           conn.setDoOutput(true);
            conn.setRequestMethod("POST");
           conn.setRequestProperty("Content-Type", "application/json");
           conn.setRequestProperty("Accept", "application/json");
            conn.setConnectTimeout(5000);
            StringBuilder SB = new StringBuilder();
           String obj;
          JSONObject item = new JSONObject();
           item.put("tourist_name", "testNaoual");
           item.put("tourist_email", "testnaoual@test.com");
           item.put("tourist_location", "Rabat");

           obj = item.toString();
           conn.connect();
         int codeRetour = conn.getResponseCode();
            if (codeRetour == HttpURLConnection.HTTP_OK) {
                OutputStream outputS = conn.getOutputStream();
                Log.d("bb", "aaaa2");
                OutputStreamWriter outputSR = new OutputStreamWriter(outputS);
                outputSR.write(obj);
                outputSR.flush();
                outputSR.close();

            }
        }
       catch (JSONException ex) {
           Log.d("bb", ex.getMessage());
       }
 catch (ProtocolException ex) {
        Log.d("bb", ex.getMessage());
    }
        catch (MalformedURLException e) {
            Log.d("bb", e.getMessage());
        } catch (IOException e) {
            Log.d("bb", e.getMessage());
        }
        Log.d("bb","rrr" +  data);
        return  data;
    }

}
