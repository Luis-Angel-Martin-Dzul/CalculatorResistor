package com.makech.calculator.resistor.models;

import java.util.ArrayList;

public class BandPPM {

    public int Id;
    public int FkColor;
    public double Value;

    public BandPPM() {}
    public BandPPM(int id, int fkcolor, double value){
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

    public ArrayList<BandPPM> getArrayBandPPM(){
        ArrayList<BandPPM> bandPPMList = new ArrayList<BandPPM>();
        bandPPMList.add(new BandPPM(0, 1, 100));
        bandPPMList.add(new BandPPM(1, 2, 50));
        bandPPMList.add(new BandPPM(2, 3, 15));
        bandPPMList.add(new BandPPM(3, 4, 25));
        bandPPMList.add(new BandPPM(4, 6, 10));
        bandPPMList.add(new BandPPM(5, 7, 5));


        return  bandPPMList;
    }
}
