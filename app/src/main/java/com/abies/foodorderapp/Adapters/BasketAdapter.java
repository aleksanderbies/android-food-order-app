package com.abies.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abies.foodorderapp.BasketActivity;
import com.abies.foodorderapp.DataBaseHelper;
import com.abies.foodorderapp.DetailActivity;
import com.abies.foodorderapp.Models.BasketModel;
import com.abies.foodorderapp.R;

import java.util.ArrayList;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.ViewHolder>{

    ArrayList<BasketModel> basket;
    Context context;

    public BasketAdapter(ArrayList<BasketModel> basket, Context context) {
        this.basket = basket;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.basket_element, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DataBaseHelper helper = new DataBaseHelper(context);
        final BasketModel model = basket.get(position);
        holder.basketFoodImage.setImageResource(model.getBasketFoodImage());
        holder.basketFoodName.setText(model.getBasketFoodName());
        holder.basketFoodPrice.setText(model.getBasketPrice());
        holder.basketFoodQuantity.setText(model.getBasketQuantity());
        holder.deleteFromBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.deleteFromBasket(model.getId());
                //context.startActivity(BasketActivity.class);
            }
        });
    }

    @Override
    public int getItemCount() {
        return basket.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView basketFoodImage, deleteFromBasket;
        TextView basketFoodName, basketFoodPrice, basketFoodQuantity;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            basketFoodImage = itemView.findViewById(R.id.basketFoodImage);
            basketFoodName= itemView.findViewById(R.id.basketFoodName);
            basketFoodPrice= itemView.findViewById(R.id.basketFoodPrice);
            basketFoodQuantity= itemView.findViewById(R.id.basketFoodQuantity);
            deleteFromBasket = itemView.findViewById(R.id.deleteFromBasket);

        }
    }
}
