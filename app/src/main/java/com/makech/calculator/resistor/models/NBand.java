package com.makech.calculator.resistor.models;

import java.util.ArrayList;

public class NBand {

    public int Id;
    public String Name;

    public NBand(){ }
    public NBand(int id, String name){
        Id = id;
        Name = name;
    }
    public int getId() { return Id; }
    public String getName() { return Name; }

    public void setId(int id) { Id = id; }
    public void setName(String name) { Name= name;}

    public ArrayList<NBand> getArrayNBand(){
        ArrayList<NBand> bandList = new ArrayList<NBand>();
        bandList.add(new NBand(1, "4 Band"));
        bandList.add(new NBand(2, "5 Band"));
        bandList.add(new NBand(3, "6 Band"));

        return bandList;
    }

}
