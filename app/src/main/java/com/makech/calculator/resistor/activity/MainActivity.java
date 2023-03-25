package com.makech.calculator.resistor.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.makech.calculator.resistor.R;
import com.makech.calculator.resistor.adapter.NBandAdapter;
import com.makech.calculator.resistor.models.NBand;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Llenar lista
        ArrayList<NBand> bandList = new ArrayList<NBand>();
        bandList.add(new NBand(1, "4 Banda"));
        bandList.add(new NBand(2, "5 Banda"));
        bandList.add(new NBand(3, "6 Banda"));


        Spinner spinner = findViewById(R.id.spinner_band);
        NBandAdapter custemAdapter = new NBandAdapter(this, R.layout.item_nband, bandList);
        spinner.setAdapter(custemAdapter);

    }
}
