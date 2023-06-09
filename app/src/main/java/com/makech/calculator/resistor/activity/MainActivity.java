package com.makech.calculator.resistor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.makech.calculator.resistor.R;
import com.makech.calculator.resistor.adapter.NBandAdapter;
import com.makech.calculator.resistor.fragment.Band4Fragment;
import com.makech.calculator.resistor.fragment.Band5Fragment;
import com.makech.calculator.resistor.fragment.Band6Fragment;
import com.makech.calculator.resistor.models.NBand;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<NBand> nBandList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NBand nBand = new NBand();
        nBandList = nBand.getArrayNBand();

        //Cargar datos
        Spinner spinner = findViewById(R.id.spinner_band);

        NBandAdapter custemAdapter = new NBandAdapter(this, R.layout.item_band, nBandList);

        spinner.setAdapter(custemAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                // Se llama cuando el usuario selecciona un elemento del Spinner
                NBand selectedNBand = (NBand) parent.getItemAtPosition(pos);
                callOtherFragment(selectedNBand.getId());
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Se llama cuando no se ha seleccionado ningún elemento en el Spinner
            }
        });

    }

    private void callOtherFragment(int band){
        Fragment fragment = new Fragment();

        switch (band){
            case 1:
                fragment = Band4Fragment.newInstance();
                break;
            case 2:
                fragment = Band5Fragment.newInstance();
                break;
            case 3:
                fragment = Band6Fragment.newInstance();
                break;
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_bandN, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info ,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                super.onBackPressed();
                break;

            case R.id.info:
                Intent aboutActivity = new Intent(this, AboutActivity.class);
                startActivity(aboutActivity);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
