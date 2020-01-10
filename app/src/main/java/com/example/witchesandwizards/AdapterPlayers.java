package com.example.witchesandwizards;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class AdapterPlayers extends RecyclerView.Adapter<AdapterPlayers.ViewHolder>{

     ArrayList<String> names = new ArrayList<>();


    public AdapterPlayers(ArrayList<String> playerNamesd){
        names = playerNamesd;

    }


    @NonNull
    @Override
    public AdapterPlayers.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(R.layout.player_item,parent,false);
        AdapterPlayers.ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPlayers.ViewHolder holder, final int position) {
            holder.nameView.setText(names.get(position));

    }

    @Override
    public int getItemCount() {
        return names.size();
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {

























        public TextView nameView;


        public ViewHolder(View itemView) {
            super(itemView);

                nameView = itemView.findViewById(R.id.playerName);

        }
    }












}
