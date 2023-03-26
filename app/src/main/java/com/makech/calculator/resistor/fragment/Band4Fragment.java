package com.makech.calculator.resistor.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.makech.calculator.resistor.R;
import com.makech.calculator.resistor.adapter.BandMultiplierAdapter;
import com.makech.calculator.resistor.adapter.BandOfColorAdapter;
import com.makech.calculator.resistor.adapter.BandToleranceAdapter;
import com.makech.calculator.resistor.models.BandMultiplier;
import com.makech.calculator.resistor.models.BandOfColor;
import com.makech.calculator.resistor.models.BandTolerance;

public class Band4Fragment extends Fragment {

    private int color1, color2;
    private double mult, toler;
    TextView resistance_value;

    public Band4Fragment(){}
    public static Band4Fragment newInstance(){
        Band4Fragment band4 = new Band4Fragment();
        return band4;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_band_4, container, false);

        //Spinner Color
        BandOfColor bandOfColor = new BandOfColor();
        BandOfColorAdapter colorOfColorAdapter = new BandOfColorAdapter(getContext(), R.layout.item_band, bandOfColor.getArrayBasicBandColor());

        Spinner spinnerColor1 = view.findViewById(R.id.spinner_band_color_name_1);
        spinnerColor1.setAdapter(colorOfColorAdapter);

        Spinner spinnerColor2 = view.findViewById(R.id.spinner_band_color_name_2);
        spinnerColor2.setAdapter(colorOfColorAdapter);

        RelativeLayout spinnerColor3 = view.findViewById(R.id.spinner_three_optional);
        spinnerColor3.setVisibility(View.GONE );


        //Spinner Multiplier
        BandMultiplier bandMultiplier = new BandMultiplier();
        BandMultiplierAdapter multiplierAdapter = new BandMultiplierAdapter(getContext(), R.layout.item_band, bandMultiplier.getArrayBandMultiplier());

        Spinner spinnerMult = view.findViewById(R.id.spinner_band_multiplier);
        spinnerMult.setAdapter(multiplierAdapter);


        //Spinner Tolerance
        BandTolerance bandTolerance = new BandTolerance();
        BandToleranceAdapter toleranceAdapter = new BandToleranceAdapter(getContext(), R.layout.item_band, bandTolerance.getArrayBandTolerance());

        Spinner spinnerToler = view.findViewById(R.id.spinner_band_tolerance);
        spinnerToler.setAdapter(toleranceAdapter);


        // SELECCION
        spinnerColor1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandOfColor selectedNband = (BandOfColor) adapterView.getItemAtPosition(position);
                color1 = selectedNband.getId() * 10;
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerColor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandOfColor selectedNband = (BandOfColor) adapterView.getItemAtPosition(position);
                color2 = selectedNband.getId();
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerMult.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandMultiplier selMultiplier = (BandMultiplier) adapterView.getItemAtPosition(position);
                mult = selMultiplier.getOMS();
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerToler.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandTolerance selTolerance = (BandTolerance) adapterView.getItemAtPosition(position);
                toler = selTolerance.getValue();
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });


        //TextView
        resistance_value = view.findViewById(R.id.resistance_value);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void calculator(){
        double ohms;
        String unit = "";
        ohms = (color1 + color2) * mult;


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

        resistance_value.setText(ohms + unit + " Ohms " +toler+" %");

    }

}