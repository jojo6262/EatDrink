package com.softwareengineer.eatdrink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cook_adapter extends RecyclerView.Adapter<cook_adapter.cookHolder> {
    @NonNull
    @Override
    public  cook_adapter.cookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_cocktail,parent,false);
        cook_adapter.cookHolder holder = new cook_adapter.cookHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull cookHolder holder, int position) {
        holder.setItem(position);
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    class cookHolder extends  RecyclerView.ViewHolder{

        TextView table;
        TextView menu;

        public cookHolder(@NonNull View itemView) {
            super(itemView);
            table=itemView.findViewById(R.id.text_title);
            menu=itemView.findViewById(R.id.text_description);
        }
        public void setItem(int position)
        {

        }

    }
}
