package com.robbyrob.agilehourcounter;

/**
 * Created by robertr on 10/18/13.
 */
import com.robbyrob.agilehourcounter.CounterFragment;
import com.robbyrob.agilehourcounter.ResourceFragment;
import com.robbyrob.agilehourcounter.AddResourceFragment;
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
                // Top Rated fragment activity
                return new CounterFragment();
            case 1:
                // Games fragment activity
                return new ResourceFragment();
            case 2:
                // Movies fragment activity
                return new AddResourceFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        // get item count - equal to number of tabs
        return 3;
    }

}
