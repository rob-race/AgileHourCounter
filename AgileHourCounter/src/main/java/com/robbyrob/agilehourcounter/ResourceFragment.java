package com.robbyrob.agilehourcounter;

/**
 * Created by robertr on 10/18/13.
 */
import com.robbyrob.agilehourcounter.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ResourceFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);

        return rootView;
    }

}