package com.example.exp1apirest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.sql.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    ArrayList<String> cList=new ArrayList<String>();
    JSONObject obj=null;
    InputStream stream=null;
    String data=null;
    Spinner spinner;
    ArrayList<String> lst = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner  = (Spinner) findViewById(R.id.sp);
       ClassConnectionGet CC = new ClassConnectionGet();
       try {
           data = CC.execute("http://restapi.adequateshop.com/api/Tourist").get();
           obj = new JSONObject(data);
           if (obj != null) {
               JSONArray lstTouristes = obj.getJSONArray("data");
               for (int i = 0; i < lstTouristes.length(); i++) {
                   lst.add(lstTouristes.getJSONObject(i).getString("tourist_name"));
               }
               ArrayAdapter AA = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1,lst);
               spinner.setAdapter(AA);
           }
       }
           catch (JSONException e) {
            Log.d("bb",e.getMessage());
        }
           catch (ExecutionException e) {
            Log.d("bb",e.getMessage());
           }
             catch (Exception e) {
                Log.d("bb",e.getMessage());
            }


/*
        spinner=(Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter=new ArrayAdapter(this, android.R.layout.simple_list_item_1,cList);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                try {
                    Toast.makeText(getApplicationContext(),T.getJSONObject(position).getString("prix"),Toast.LENGTH_LONG).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
*/
    }
}