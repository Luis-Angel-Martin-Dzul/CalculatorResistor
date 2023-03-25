package com.makech.calculator.resistor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.makech.calculator.resistor.R;
import com.makech.calculator.resistor.models.NBand;

import java.util.List;

public class NBandAdapter extends ArrayAdapter<NBand> {

    LayoutInflater inflater;

    public NBandAdapter(@NonNull Context context, int resource, @NonNull List<NBand> list) {
        super(context, resource, list);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        NBand numband = getItem(position);

        View rowView = inflater.inflate(R.layout.item_nband, null, true);
        TextView name = rowView.findViewById(R.id.item_nband_text);
        name.setText(numband.getName());

        return rowView;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        NBand numband = getItem(position);

        if(convertView == null)
            convertView = inflater.inflate(R.layout.item_nband, parent, false);

        TextView name = convertView.findViewById(R.id.item_nband_text);
        name.setText(numband.getName());

        return convertView;
    }
}
