package com.example.sothearathfinalexam.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sothearathfinalexam.Model.ProductModel;
import com.example.sothearathfinalexam.R;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class HomeRVAdapter extends RecyclerView.Adapter<HomeRVAdapter.ViewHolder> {

    List<ProductModel> productModels;
    MyOnClickListener myOnClickListener;

    public HomeRVAdapter(List<ProductModel> productModels) {
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
        return new ViewHolder(view,myOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Binding(productModels.get(position));
    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView productName,productPrice,productCode;
        LinearLayout clickHolderItem;
        MyOnClickListener myOnClickListener;
        public ViewHolder(@NonNull View itemView,MyOnClickListener myOnClickListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.itemImageHome);
            productName = itemView.findViewById(R.id.itemNameHome);
            productPrice = itemView.findViewById(R.id.itemPriceHome);
            productCode = itemView.findViewById(R.id.itemCodeHome);
            clickHolderItem = itemView.findViewById(R.id.cardClick);

            this.getAdapterPosition();
            this.myOnClickListener =myOnClickListener;
            clickHolderItem.setOnClickListener(this);
        }
        public void Binding(ProductModel product){
            productName.setText(product.getName());
            productPrice.setText(product.getPrice()+"$");
            productCode.setText(product.getCode());
            //Glide
            Glide.with(itemView.getContext())
                    .load(product.getImageUrl())
                    .centerCrop()
                    .placeholder(R.drawable.ic_launcher_background)
                    .into(imageView);
        }

        @Override
        public void onClick(View v) {
            myOnClickListener.OnClick(getAdapterPosition());
        }
    }


    public interface MyOnClickListener{
        void OnClick(int position);
    }

}
