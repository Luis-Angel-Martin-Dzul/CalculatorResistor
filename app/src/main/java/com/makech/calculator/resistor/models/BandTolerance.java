package com.makech.calculator.resistor.models;

import java.util.ArrayList;

public class BandTolerance {

    public int Id;
    public int FkColor;
    public double Value;

    public BandTolerance( ){ }
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

    public ArrayList<BandTolerance> getArrayBandTolerance(){
        ArrayList<BandTolerance> bandToleranceList = new ArrayList<BandTolerance>();
        bandToleranceList.add(new BandTolerance(0, 1, 1));
        bandToleranceList.add(new BandTolerance(1, 2, 2));
        bandToleranceList.add(new BandTolerance(2, 5, 0.5));
        bandToleranceList.add(new BandTolerance(3, 6, 0.25));
        bandToleranceList.add(new BandTolerance(4, 7, 0.1));
        bandToleranceList.add(new BandTolerance(5, 8, 0.05));
        bandToleranceList.add(new BandTolerance(6, 10, 5));
        bandToleranceList.add(new BandTolerance(7, 11, 10));

        return  bandToleranceList;
    }
}
