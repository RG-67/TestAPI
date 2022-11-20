package com.example.testapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<DataModal> dataModalArrayList = new ArrayList<>();
    String url = "https://jsonplaceholder.typicode.com/posts";
    RecyclerView recyclerView;
    DataAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        progressBar = findViewById(R.id.progressBar);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        GetData();
    }

    private void GetData() {
        progressBar.setVisibility(View.VISIBLE);
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i=0; i<response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        dataModalArrayList.add(new DataModal(jsonObject.getInt("id"),
                                                            jsonObject.getString("title"),
                                                            jsonObject.getString("body")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                adapter = new DataAdapter(dataModalArrayList, getApplicationContext());
                recyclerView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}