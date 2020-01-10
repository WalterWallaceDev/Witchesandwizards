package com.example.witchesandwizards;

public class Student {
    private String name;
    private double relationship;

     Student(){
        relationship = 0;
    }
     Student(String name){
        this.name = name;
        relationship = 0;
    }
     Student(String name,int relationship){
        this.name = name;
        this.relationship = relationship;
    }
     Student(String name,double relationship){
        this.name = name;
        this.relationship = relationship;
    }

    public double getRelationship() {
        return relationship;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRelationship(double relationship) {
        this.relationship = relationship;
    }

    @Override
    public String toString() {
        return name+"/"+relationship;
    }
}
