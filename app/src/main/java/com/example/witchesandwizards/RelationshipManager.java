package com.example.witchesandwizards;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class RelationshipManager {
    FirebaseFirestore db;
    String playerName;
    String targetKey;
    ArrayList<String> inflow;
    
    public RelationshipManager(String playerName) {
        db = FirebaseFirestore.getInstance();
        this.playerName = playerName;
        this.targetKey = playerName+",Relations";
    }


}
