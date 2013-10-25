package com.robbyrob.agilehourcounter;

/**
 * Created by robertr on 10/18/13.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int index) {

        switch (index) {
            case 0:
                return new CounterFragment();
            case 1:
                return new ResourceFragment();
            case 2:
                return new AddResourceFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

}
