package com.example.witchesandwizards;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    RecyclerView playersView;
    ArrayList<String>players = new ArrayList<>();
    AdapterPlayers adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PlayerManager playerManager = new PlayerManager(this,this);

        playerManager.getPlayers();

        playersView = findViewById(R.id.playerView);
        adapter = new AdapterPlayers(players);
        playersView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        playersView.setAdapter(adapter);
    }

    void updatedData(){
        adapter.names = players;
        adapter.notifyDataSetChanged();
    }


}
