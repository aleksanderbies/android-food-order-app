package com.abies.foodorderapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.abies.foodorderapp.DataBaseHelper;
import com.abies.foodorderapp.DetailActivity;
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
        final DataBaseHelper helper = new DataBaseHelper(context);

        holder.foodImage.setImageResource(model.getImage());
        holder.mainName.setText(model.getName());
        holder.price.setText(model.getPrice());
        holder.description.setText(model.getDescription());



        holder.itemView.setOnClickListener(v -> {
            int inBase;
            try{
                helper.getFavByName(model.getName());
                inBase = 2;
            }catch (RuntimeException e){
                inBase = 1;
            }
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("image", model.getImage());
            intent.putExtra("price", model.getPrice());
            intent.putExtra("desc", model.getDescription());
            intent.putExtra("name", model.getName());
            intent.putExtra("type", inBase);
            context.startActivity(intent);
        });
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
