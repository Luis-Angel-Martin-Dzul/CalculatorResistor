package com.makech.calculator.resistor.models;

public class BandTolerance {

    public int Id;
    public int FkColor;
    public double Value;

    public BandTolerance(int id, int fkcolor, double value){
        Id = id;
        FkColor = fkcolor;
        Value = value;
    }

    public int getId() { return Id; }
    public int getFkColor() { return FkColor; }
    public double getValue() { return Value; }

    public void setId(int id) { Id = id; }
    public void setFkColor(int fkColor) { FkColor = fkColor; }
    public void setValue(int value) { Value = value; }

}
