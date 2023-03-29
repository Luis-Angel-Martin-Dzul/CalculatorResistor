package com.makech.calculator.resistor.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
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
import com.makech.calculator.resistor.util.Constants;
import com.makech.calculator.resistor.util.Util;

import java.util.List;

public class Band5Fragment extends Fragment {

    private int valueColor1, valueColor2, valueColor3;
    private double valueMultiplier, valueTolerances;
    private TextView resistance_value;
    private Util util;
    private List<BandOfColor> bandOfColorList;
    private List<BandMultiplier> bandMultiplierList;
    private List<BandTolerance> bandToleranceList;
    public Band5Fragment(){}

    public static Band5Fragment newInstance(){
        Band5Fragment band5 = new Band5Fragment();
        return band5;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_band_5, container, false);
        
        //Vars
        util = new Util();
        BandOfColor bandOfColor = new BandOfColor();
        BandMultiplier bandMultiplier = new BandMultiplier();
        BandTolerance bandTolerance = new BandTolerance();
        bandOfColorList = bandOfColor.getArrayBandColor();
        bandMultiplierList = bandMultiplier.getArrayBandMultiplier();
        bandToleranceList = bandTolerance.getArrayBandTolerance();

        //Call Result
        resistance_value = view.findViewById(R.id.resistance_value);

        //Call Bands Color
        ImageView band1 = view.findViewById(R.id.ban_res_1);
        ImageView band2 = view.findViewById(R.id.ban_res_2);
        ImageView band3 = view.findViewById(R.id.ban_res_3);
        ImageView band4 = view.findViewById(R.id.ban_res_4);
        ImageView band5 = view.findViewById(R.id.ban_res_5);
        ImageView band6 = view.findViewById(R.id.ban_res_6);

        //Call Spinners Color
        Spinner spinnerValueColor1 = view.findViewById(R.id.spinner_band_color_name_1);
        Spinner spinnerValueColor2 = view.findViewById(R.id.spinner_band_color_name_2);
        Spinner spinnerValueColor3 = view.findViewById(R.id.spinner_band_color_name_3);
        Spinner spinnerValueMultiplier = view.findViewById(R.id.spinner_band_multiplier);
        Spinner spinnerValueTolerances = view.findViewById(R.id.spinner_band_tolerance);
        
        
        //Load Valors
        band6.setBackgroundColor(Color.parseColor(Constants.COLOR_BASE));


        //Spinner Adapter
        BandOfColorAdapter colorOfColorAdapter = new BandOfColorAdapter(getContext(), R.layout.item_band, bandOfColorList);
        BandMultiplierAdapter multiplierAdapter = new BandMultiplierAdapter(getContext(), R.layout.item_band, bandMultiplierList);
        BandToleranceAdapter toleranceAdapter = new BandToleranceAdapter(getContext(), R.layout.item_band, bandToleranceList);
        
        spinnerValueColor1.setAdapter(colorOfColorAdapter);
        spinnerValueColor2.setAdapter(colorOfColorAdapter);
        spinnerValueColor3.setAdapter(colorOfColorAdapter);
        spinnerValueMultiplier.setAdapter(multiplierAdapter);
        spinnerValueTolerances.setAdapter(toleranceAdapter);


        //Spinner selecction
        spinnerValueColor1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandOfColor selectedNband = (BandOfColor) adapterView.getItemAtPosition(position);
                valueColor1 = selectedNband.getId() * 100;
                band1.setBackgroundColor(Color.parseColor(selectedNband.getColor()));
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerValueColor2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandOfColor selectedNband = (BandOfColor) adapterView.getItemAtPosition(position);
                valueColor2 = selectedNband.getId() * 10;
                band2.setBackgroundColor(Color.parseColor(selectedNband.getColor()));
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerValueColor3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandOfColor selectedNband = (BandOfColor) adapterView.getItemAtPosition(position);
                valueColor3 = selectedNband.getId() * 1;
                band3.setBackgroundColor(Color.parseColor(selectedNband.getColor()));
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerValueMultiplier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandMultiplier selMultiplier = (BandMultiplier) adapterView.getItemAtPosition(position);
                band4.setBackgroundColor(Color.parseColor(bandOfColorList.get(position).getColor()));
                valueMultiplier = selMultiplier.getOMS();
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
        spinnerValueTolerances.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                BandTolerance selTolerance = (BandTolerance) adapterView.getItemAtPosition(position);
                band5.setBackgroundColor(Color.parseColor(bandOfColorList.get(selTolerance.getFkColor()).getColor()));
                valueTolerances = selTolerance.getValue();
                calculator();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    private void calculator(){
        double ohms = (valueColor1 + valueColor2 + valueColor3) * valueMultiplier;
        String value = util.simpliflyOHM(ohms);

        resistance_value.setText(value + " Ohms " +valueTolerances+" %");

    }


}
