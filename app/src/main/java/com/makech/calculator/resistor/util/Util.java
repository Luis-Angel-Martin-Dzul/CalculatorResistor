package com.makech.calculator.resistor.util;

public class Util {

    public static String simpliflyOHM(double ohms){
        String unit = "";

        if(ohms < 1000) {
            unit = "";
        }
        if(ohms >= 1000 && ohms < 1000000) {
            unit = "K";
            ohms = (ohms / 1000);
        }
        if(ohms >= 1000000 && ohms < 1000000000) {
            unit = "M";
            ohms = (ohms / 1000000);
        }
        if(ohms >= 1000000000) {
            unit = "G";
            ohms = (ohms / 1000000000);
        }

        return ohms + unit;
    }

    public static String simplifyMultiplier(double mult){
        String simbol = "Ω";
        return simpliflyOHM(mult) + simbol;
    }

}
