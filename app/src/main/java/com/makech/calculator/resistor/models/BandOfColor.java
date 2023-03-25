package com.makech.calculator.resistor.models;

public class BandOfColor {
    public int Id;
    public String Name;

    public BandOfColor(int id, String name){
        Id = id;
        Name = name;
    }

    public int getId() { return Id; }
    public String getName() { return Name; }

    public void setId(int id) { Id = id; }
    public void setName(String name) { Name= name;}

}
