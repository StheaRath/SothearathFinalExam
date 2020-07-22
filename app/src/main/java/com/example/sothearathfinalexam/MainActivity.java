package com.example.sothearathfinalexam;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.sothearathfinalexam.Fragment.AccountFragment;
import com.example.sothearathfinalexam.Fragment.CategoryFragment;
import com.example.sothearathfinalexam.Fragment.HomeFragment;
import com.example.sothearathfinalexam.Fragment.SearchFragment;
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
        configButtonNavigation();
    }

    private void configButtonNavigation() {
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.homeNav:
                        loadFragment(HomeFragment.newInstance());
                        break;
                    case R.id.cateNav:
                        loadFragment(CategoryFragment.getInstance());
                        break;
                    case R.id.searchNav:
                        loadFragment(SearchFragment.getInstance());
                        break;
                    case R.id.accountNav:
                        loadFragment(AccountFragment.getInstance());
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void initID() {
        container = findViewById(R.id.frameContainer);
        navigation = findViewById(R.id.buttonNavigation);
    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameContainer, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }




}