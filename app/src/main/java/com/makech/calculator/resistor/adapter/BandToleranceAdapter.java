package com.makech.calculator.resistor.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.makech.calculator.resistor.R;
import com.makech.calculator.resistor.models.BandMultiplier;
import com.makech.calculator.resistor.models.BandOfColor;
import com.makech.calculator.resistor.models.BandTolerance;

import java.util.List;

public class BandToleranceAdapter extends ArrayAdapter<BandTolerance> {

    LayoutInflater inflater;

    public BandToleranceAdapter(@NonNull Context context, int resource, @NonNull List<BandTolerance> listTolerance){
        super(context, resource, listTolerance);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        BandTolerance bandTolerance = getItem(position);
        BandOfColor bandOfColor = new BandOfColor().getArrayBandColor().get(bandTolerance.FkColor);

        View rowView = inflater.inflate(R.layout.item_band, null, true);

        TextView option = rowView.findViewById(R.id.item_band_text);

        if (bandOfColor.getId() == 0) option.setTextColor(Color.parseColor("#FFFFFF"));
        option.setBackgroundColor(Color.parseColor(bandOfColor.getColor()));
        option.setText(bandOfColor.getName());

        return rowView;

    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        BandTolerance bandTolerance = getItem(position);
        BandOfColor bandOfColor = new BandOfColor().getArrayBandColor().get(bandTolerance.FkColor);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item_band, parent, false);

        TextView option = convertView.findViewById(R.id.item_band_text);

        if (bandOfColor.getId() == 0) option.setTextColor(Color.parseColor("#FFFFFF"));
        option.setBackgroundColor(Color.parseColor(bandOfColor.getColor()));
        option.setText(bandOfColor.getName());

        return convertView;
    }

}
