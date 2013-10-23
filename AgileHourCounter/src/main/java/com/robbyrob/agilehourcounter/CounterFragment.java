package com.robbyrob.agilehourcounter;

/**
 * Created by robertr on 10/18/13.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class CounterFragment extends Fragment {
    public static CounterAdapter aa2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_counter, container, false);
        ListView LV = (ListView) rootView.findViewById(R.id.resource_counter_listView);

        aa2 = new CounterAdapter(getActivity(), MainActivity.al);
        LV.setAdapter(aa2);

        return rootView;
    }

}
