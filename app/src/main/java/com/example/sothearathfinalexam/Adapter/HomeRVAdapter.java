package com.example.sothearathfinalexam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sothearathfinalexam.Model.ProductModel;
import com.example.sothearathfinalexam.R;

import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.ViewHolder> {

    List<ProductModel> productModels;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Binding(productModels.get(position));
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView productName,productPrice,productCode;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageHome);
            productName = itemView.findViewById(R.id.itemNameHome);
            productPrice = itemView.findViewById(R.id.itemPriceHome);
            productCode = itemView.findViewById(R.id.itemCodeHome);
        }
        public void Binding(ProductModel product){
            productName.setText(product.getName());
            productPrice.setText(product.getPrice());
            productCode.setText(product.getCode());
            //Glide
            Glide.with(itemView.getContext())
                    .load(product.getImageurl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }
    }
}
