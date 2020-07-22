package com.example.sothearathfinalexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.List;

public class ProductDetails extends AppCompatActivity {
    TextView id,name,code,dec,price,totalRate,averageRate,totalView,cateID,cateName;
    ImageView url;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        initID();
        initValue();

    }

    private void initID() {
        id = findViewById(R.id.pdID);
        name = findViewById(R.id.pdName);
        code = findViewById(R.id.pdCode);
        dec = findViewById(R.id.pdDes);
        price = findViewById(R.id.pdPrice);
        url = findViewById(R.id.pdURL);
        totalRate = findViewById(R.id.pdTRate);
        averageRate = findViewById(R.id.pdARate);
        totalView = findViewById(R.id.pdTView);
        cateName = findViewById(R.id.pdCName);
    }

    private void initValue() {
        Intent intent = getIntent();
        id.setText(intent.getStringExtra("id"));
        name.setText(intent.getStringExtra("name"));
        code.setText(intent.getStringExtra("code"));
        dec.setText(intent.getStringExtra("dec"));
        price.setText(intent.getStringExtra("price"));
        Glide.with(this).load(intent.getStringExtra("url")).into(url);
        totalRate.setText(intent.getStringExtra("totalRate"));
        averageRate.setText(intent.getStringExtra("averageRate"));
        totalView.setText(intent.getStringExtra("totalView"));
        cateID.setText(intent.getStringExtra("cateID"));
        cateName.setText(intent.getStringExtra("cateName"));
    }
}
