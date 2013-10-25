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

public class ResourceFragment extends Fragment {
    public static ResourceAdapter aa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        ListView LV = (ListView) rootView.findViewById(R.id.resource_detail_listView);
        LV.setClickable(true);

        aa = new ResourceAdapter(getActivity(), MainActivity.al);
        LV.setAdapter(aa);
        return rootView;
    }


}