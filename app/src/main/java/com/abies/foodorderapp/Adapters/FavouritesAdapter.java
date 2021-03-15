package com.abies.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abies.foodorderapp.Models.FavouritesModel;
import com.abies.foodorderapp.R;

import java.util.ArrayList;

public class FavouritesAdapter extends RecyclerView.Adapter<FavouritesAdapter.ViewHolder> {

    ArrayList<FavouritesModel> list;
    Context context;

    public FavouritesAdapter(ArrayList<FavouritesModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favourite, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final FavouritesModel model = list.get(position);
        holder.favImage.setImageResource(model.getFavImage());
        holder.favFoodName.setText(model.getFavFoodName());
        holder.priceFav.setText(model.getPriceFav());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView favImage;
        TextView favFoodName, priceFav;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favImage = itemView.findViewById(R.id.favImage);
            favFoodName = itemView.findViewById(R.id.favFoodName);
            priceFav = itemView.findViewById(R.id.priceFav);
        }
    }

}
