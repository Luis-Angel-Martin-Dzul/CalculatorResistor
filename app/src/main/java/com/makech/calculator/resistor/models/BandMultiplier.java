package com.makech.calculator.resistor.models;

public class BandMultiplier {

    public int Id;
    public int FkColor;
    public double OMS;

    public BandMultiplier(int id, int fkcolor, double oms){
        Id = id;
        FkColor = fkcolor;
        OMS = oms;
    }

    public int getId() { return Id; }
    public int getFkColor() { return FkColor; }
    public double getOMS() { return OMS; }

    public void setId(int id) { Id = id; }
    public void setFkColor(int fkColor) { FkColor = fkColor; }
    public void setOMS(int oms) { OMS = oms; }


}
