package com.makech.calculator.resistor.util;

public class Util {

    public static String simpliflyOHM(double ohms){
        String unit = Constants.STRING_EMPTY;

        if(ohms < Constants.THOUSAND_NUMBER) {
            unit = Constants.STRING_EMPTY;
        }
        if(ohms >= Constants.THOUSAND_NUMBER && ohms < Constants.MILLION_NUMBER) {
            unit = Constants.THOUSAND_SYMBOL;
            ohms = (ohms / Constants.THOUSAND_NUMBER);
        }
        if(ohms >= Constants.MILLION_NUMBER && ohms < Constants.BILLION_NUMBER) {
            unit = Constants.MILLION_SYMBOL;
            ohms = (ohms / Constants.MILLION_NUMBER);
        }
        if(ohms >= Constants.BILLION_NUMBER) {
            unit = Constants.BILLION_SYMBOL;
            ohms = (ohms / Constants.BILLION_NUMBER);
        }

        return ohms + unit;
    }

    public static String simplifyMultiplier(double mult){
        return simpliflyOHM(mult) + Constants.OHMS_SYMBOL;
    }

}
