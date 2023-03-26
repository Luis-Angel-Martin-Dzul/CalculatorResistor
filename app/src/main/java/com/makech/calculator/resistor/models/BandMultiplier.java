package com.makech.calculator.resistor.models;

import java.util.ArrayList;

public class BandMultiplier {

    public int Id;
    public int FkColor;
    public double OMS;

    public BandMultiplier() {}
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

    public ArrayList<BandMultiplier> getArrayBandMultiplier(){
        ArrayList<BandMultiplier> bandMultiplierList = new ArrayList<BandMultiplier>();
        bandMultiplierList.add(new BandMultiplier(0, 0, 1));
        bandMultiplierList.add(new BandMultiplier(1, 1, 10));
        bandMultiplierList.add(new BandMultiplier(2, 2, 100));
        bandMultiplierList.add(new BandMultiplier(3, 3, 1000));
        bandMultiplierList.add(new BandMultiplier(4, 4, 10000));
        bandMultiplierList.add(new BandMultiplier(5, 5, 100000));
        bandMultiplierList.add(new BandMultiplier(6, 6, 1000000));
        bandMultiplierList.add(new BandMultiplier(7, 7, 10000000));
        bandMultiplierList.add(new BandMultiplier(8, 8, 100000000));
        bandMultiplierList.add(new BandMultiplier(9, 9, 1000000000));
        bandMultiplierList.add(new BandMultiplier(10, 10, 0.1));
        bandMultiplierList.add(new BandMultiplier(11, 11, 0.01));

        return bandMultiplierList;
    }

}
