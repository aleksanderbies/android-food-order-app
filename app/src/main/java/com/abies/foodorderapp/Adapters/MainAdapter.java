package com.abies.foodorderapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abies.foodorderapp.Models.MainModel;
import com.abies.foodorderapp.R;

import java.util.ArrayList;

public class MainAdapter  extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.mainfood, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MainModel model = list.get(position);
        holder.foodImage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImage;
        TextView mainName, price, description;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImage = itemView.findViewById(R.id.imageView);
            mainName = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.orderPrice);
            description = itemView.findViewById(R.id.description);
        }
    }
}
