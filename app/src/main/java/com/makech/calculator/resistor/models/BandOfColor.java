package com.makech.calculator.resistor.models;

import java.util.ArrayList;

public class BandOfColor {
    public int Id;
    public String Name;
    public String Color;

    public BandOfColor() {}
    public BandOfColor(int id, String name, String color){
        Id = id;
        Name = name;
        Color = color;
    }
    public int getId() { return Id; }
    public String getName() { return Name; }

    public String getColor(){ return Color; }

    public void setId(int id) { Id = id; }
    public void setName(String name) { Name = name;}

    public void setColor(String color){ Color = color;}

    public ArrayList<BandOfColor> getArrayBasicBandColor(){
        ArrayList<BandOfColor> bandColorList = new ArrayList<BandOfColor>();
        bandColorList.add(new BandOfColor(0, "Black", "#000000"));
        bandColorList.add(new BandOfColor(1, "Brown", "#8B4513"));
        bandColorList.add(new BandOfColor(2, "Red", "#CC0000"));
        bandColorList.add(new BandOfColor(3, "Orange", "#D87347"));
        bandColorList.add(new BandOfColor(4, "Yellow", "#E6C951"));
        bandColorList.add(new BandOfColor(5, "Green", "#528F65"));
        bandColorList.add(new BandOfColor(6, "Blue", "#0F5190"));
        bandColorList.add(new BandOfColor(7, "Violet", "#6967CE"));
        bandColorList.add(new BandOfColor(8, "Grey", "#808080"));
        bandColorList.add(new BandOfColor(9, "White", "#FFFFFF"));

        return bandColorList;
    }

    public ArrayList<BandOfColor> getArrayBandColor(){
        ArrayList<BandOfColor> bandColorList = new ArrayList<BandOfColor>();
        bandColorList.add(new BandOfColor(0, "Black", "#000000"));
        bandColorList.add(new BandOfColor(1, "Brown", "#8B4513"));
        bandColorList.add(new BandOfColor(2, "Red", "#CC0000"));
        bandColorList.add(new BandOfColor(3, "Orange", "#D87347"));
        bandColorList.add(new BandOfColor(4, "Yellow", "#E6C951"));
        bandColorList.add(new BandOfColor(5, "Green", "#528F65"));
        bandColorList.add(new BandOfColor(6, "Blue", "#0F5190"));
        bandColorList.add(new BandOfColor(7, "Violet", "#6967CE"));
        bandColorList.add(new BandOfColor(8, "Grey", "#808080"));
        bandColorList.add(new BandOfColor(9, "White", "#FFFFFF"));
        bandColorList.add(new BandOfColor(10, "Gold", "#C08327"));
        bandColorList.add(new BandOfColor(11, "Silver", "#BFBEBF"));

        return bandColorList;
    }

}
