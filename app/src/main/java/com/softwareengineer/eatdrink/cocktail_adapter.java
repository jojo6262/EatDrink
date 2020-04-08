package com.softwareengineer.eatdrink;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class cocktail_adapter extends RecyclerView.Adapter< cocktail_adapter.cocktailHolder  >{

    @NonNull
    @Override
    public  cocktail_adapter.cocktailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_cocktail,parent,false);
        cocktailHolder holder = new cocktailHolder(view);
        return holder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull  cocktail_adapter.cocktailHolder holder, int position) {
        holder.setItem(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class cocktailHolder extends RecyclerView.ViewHolder{
        TextView TextView7;
        TextView TextView8;
        TextView TextView9;

        public cocktailHolder(View itemView) {
            super(itemView);
            TextView7 = itemView.findViewById(R.id.textView5);
            TextView8 = itemView.findViewById(R.id.textView4);
            TextView9 = itemView.findViewById(R.id.textView6);

        }

        public void setItem(int position) {
//            TextView5.setText();
//
        }
    }
}




