package com.makech.calculator.resistor.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.makech.calculator.resistor.R;

public class BackgroundActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);

        Intent mainAct = new Intent(this, MainActivity.class);
        startActivity(mainAct);
        finish();

    }
}
