package com.example.exp1apirest;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class ClassConnectionGet
        extends AsyncTask <String,String,String> {

    @Override
    protected String doInBackground(String... strings) {
       String data=null;
       try {
            URL url = new URL(strings[0]);
            HttpURLConnection conn = (HttpURLConnection)
                    url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            int codeRetour = conn.getResponseCode();
            if (codeRetour == HttpURLConnection.HTTP_OK) {
                InputStream inputS = conn.getInputStream();
                InputStreamReader inputSR = new InputStreamReader(inputS);
                BufferedReader reader = new BufferedReader(inputSR);
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                inputS.close();
                data = sb.toString();
            }
        }
    catch (ProtocolException ex) {
        Log.d("bb", ex.getMessage());
    }
        catch (MalformedURLException e) {
            Log.d("bb", e.getMessage());
        } catch (IOException e) {
            Log.d("bb", e.getMessage());
        }
       catch(Exception ex)
       {

       }
        Log.d("bb","rrr" +  data);
        return  data;
    }
}
