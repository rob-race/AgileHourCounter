package com.robbyrob.agilehourcounter;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by robertr on 10/25/13.
 */
public class EditResourceFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_edit_resource, container, false);

        return rootView;
    }

    @Override
    public View onStart() {

    }
}
