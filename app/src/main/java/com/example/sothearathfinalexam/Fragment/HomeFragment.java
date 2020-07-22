package com.example.sothearathfinalexam.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sothearathfinalexam.Adapter.HomeRVAdapter;
import com.example.sothearathfinalexam.Model.ProductModel;
import com.example.sothearathfinalexam.ProductDetails;
import com.example.sothearathfinalexam.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeFragment extends Fragment implements HomeRVAdapter.MyOnClickListener {
    int numberOfRequestsCompleted;
    RecyclerView recyclerView;
    List<ProductModel> products = new ArrayList<>();
    HomeRVAdapter homeRVAdapter;
    String BASE_URL = "https://randomuser.me/api";

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.home_fragment, container, false);
        recyclerView =view.findViewById(R.id.homeRecyclerViewList);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        homeRVAdapter = new HomeRVAdapter(products);
        loadProducts();
        recyclerView.setAdapter(homeRVAdapter);
        homeRVAdapter.notifyDataSetChanged();


        return view;
    }
    void getOnlineVolleyItemURL() {
        //Init request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this.getContext());
        //init request
        String url = "https://randomuser.me/api";

//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//
//            }
//        });
    }

    private void loadProducts() {
        //init
        RequestQueue queue = Volley.newRequestQueue(getContext());
        String url = "http://ite-rupp.ap-southeast-1.elasticbeanstalk.com/products.php";

        final StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                products = Arrays.asList(gson.fromJson(response, ProductModel[].class));
                homeRVAdapter.notifyDataSetChanged();
                Log.i("test", "item: "+products.size());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("HomeFragment: ", "onError: " + error);
            }
        });
        queue.add(request);
    }

    @Override
    public void OnClick(int position) {

        Context context = getContext();
        Intent  intent = new Intent(context,ProductDetails.class);

                intent.putExtra("id",products.get(position).getId());
                intent.putExtra("name",products.get(position).getName());
                intent.putExtra("code",products.get(position).getCode());
                intent.putExtra("dec",products.get(position).getDescription());
                intent.putExtra("price",products.get(position).getPrice());
                intent.putExtra("url",products.get(position).getImageUrl());
                intent.putExtra("totalRate",products.get(position).getTotalRate());
                intent.putExtra("averageRate",products.get(position).getAverageRate());
                intent.putExtra("totalView",products.get(position).getTotalView());
                intent.putExtra("cateID",products.get(position).getCategoryId());
                intent.putExtra("cateName",products.get(position).getCategoryName());

        context.startActivity(intent);
//        return product;


    }
}