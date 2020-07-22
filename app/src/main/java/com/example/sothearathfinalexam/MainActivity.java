package com.example.sothearathfinalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView navigation;
    private FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initID();
    }

    private void initID() {
//        container = findViewById(R.id.)
    }

    void getOnlineVolleyItemURL(){
        //Init request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        //init request
        String url = "https://randomuser.me/api";
//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//            }
//        });

    }
}