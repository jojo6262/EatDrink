package com.softwareengineer.eatdrink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class menu_adapter extends RecyclerView.Adapter< cocktail_adapter.MenuHolder  >{

    @NonNull
    @Override
    public  cocktail_adapter.MenuHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_menu,parent,false);
        MenuHolder holder = new MenuHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  cocktail_adapter.MenuHolder holder, int position) {
        holder.setItem(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MenuHolder extends RecyclerView.ViewHolder{
        TextView TextView5;
        TextView TextView4;
        TextView TextView6;

        public MenuHolder(View itemView) {
                super(itemView);
            TextView5 = itemView.findViewById(R.id.textView5);
            TextView4 = itemView.findViewById(R.id.textView4);
            TextView6 = itemView.findViewById(R.id.textView6);

        }

        public void setItem(int position) {
//            TextView5.setText();
//
        }
        }
    }




