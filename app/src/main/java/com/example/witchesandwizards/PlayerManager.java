package com.example.witchesandwizards;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static android.content.ContentValues.TAG;

public class PlayerManager {
    FirebaseFirestore db;
    Context context;
    MainActivity mainActivity;
    public PlayerManager(Context context, MainActivity mainActivity) {
    db = FirebaseFirestore.getInstance();
    this.context = context;
    this.mainActivity = mainActivity;
    }
    void updateList(ArrayList<String> names){
        mainActivity.players = names;
        mainActivity.updatedData();
    }
    void getPlayers(){
          final ArrayList<String> players = new ArrayList<>();
        DocumentReference dr = db.collection("players").document("players");
        dr.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {
                        Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        int f = 0;
                    } else {
                        Log.d(TAG, "No such document");
                    }
                    players.addAll((Collection<? extends String>) document.get("names"));
                    for (int i = 0; i < players.size();i++){
                        createRelationships(players.get(i));
                    }
                    int f = 0;
                    updateList(players);
                } else {
                    Log.d(TAG, "get failed with ", task.getException());
                }

            }
        });
        int s = 0;
    }
    void createRelationships(String name){
        ArrayList<String> students = new ArrayList<>();
        students.add(new Student("StudentA",1).toString());
        students.add(new Student("StudentB",1).toString());
        students.add(new Student("StudentC",1).toString());
        students.add(new Student("StudentD",1).toString());
        students.add(new Student("StudentE",1).toString());
        students.add(new Student("StudentF",1).toString());
        students.add(new Student("StudentG",1).toString());
        students.add(new Student("StudentH",1).toString());
        students.add(new Student("Studenti",1).toString());

        Map relMap = new HashMap();
        relMap.put("relations",students);

        db.collection("players").document(name+",Relations").set(relMap).addOnSuccessListener(new OnSuccessListener() {
            @Override
            public void onSuccess(Object o) {
                Toast.makeText(context,"success",Toast.LENGTH_LONG).show();
            }
        });

    }

    ArrayList<Student> t(){
       ArrayList<Student> myStudents = new ArrayList<>();
       DocumentReference dr = db.collection("players").document("test");
       dr.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
           @Override
           public void onComplete(@NonNull Task<DocumentSnapshot> task) {
               if (task.isSuccessful()) {
                   DocumentSnapshot document = task.getResult();
                   if (document.exists()) {
                       Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        ArrayList<String> d = (ArrayList<String>) document.get("rels");
                       int f = 0;
                   } else {
                       Log.d(TAG, "No such document");
                   }
               } else {
                   Log.d(TAG, "get failed with ", task.getException());
               }
           }
       });


       return myStudents;
    }
}
