package com.robbyrob.agilehourcounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robertr on 10/22/13.
 */
public class CounterAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<Resource> values;

    public CounterAdapter(Context context, ArrayList<Resource> values) {
        super(context, R.layout.resource_counter_item, (List) values);
        this.context = context;
        this.values = values;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.resource_counter_item, parent, false);
        TextView textViewName = (TextView) rowView.findViewById(R.id.resource_name);
        textViewName.setText(values.get(position).getResourceName());
        TextView textViewAvail = (TextView) rowView.findViewById(R.id.available_hours);
        textViewAvail.setText(values.get(position).getResourceAvailableHours().toString());
        TextView textViewCurrent = (TextView) rowView.findViewById(R.id.current_hours);
        textViewCurrent.setText(values.get(position).getResourceCurrentHours().toString());
        TextView textViewCurrentUtil = (TextView) rowView.findViewById(R.id.current_hours_util);
        NumberFormat percentFormat = NumberFormat.getPercentInstance();
        percentFormat.setMaximumFractionDigits(2);
        textViewCurrentUtil.setText(percentFormat.format(values.get(position).getResourceHourUtilization()));

        // Change the icon for Windows and iPhone


        return rowView;
    }
}
