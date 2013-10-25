package com.robbyrob.agilehourcounter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import static com.robbyrob.agilehourcounter.CounterFragment.aa2;
import static com.robbyrob.agilehourcounter.ResourceFragment.aa;

public class MainActivity extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    public static ArrayList<Resource> al;
    // Tab titles
    private String[] tabs = { "Counter", "Resources", "Add Resource" };

    public void moveToAdd(View view){
        viewPager.setCurrentItem(2);
    }

    public void modifyResource(View view) {
        actionBar.getTabAt(2).setText("Edit resource");
        actionBar.setSelectedNavigationItem(2);
        //mAdapter.getItem(3);
        //viewPager.setCurrentItem(2);
        // Create new fragment and transaction
        Fragment newFragment = new EditResourceFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
        transaction.replace(R.id.pager, newFragment);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
    }

    public void removeResource(View view) {
        int entryIndex = returnListIndex(view);
        al.remove(entryIndex);
        aa.notifyDataSetChanged();
        aa2.notifyDataSetChanged();
    }

    public void addResource(View view) {

        EditText getName = (EditText) findViewById(R.id.resourceNameeditText);
        String name = getName.getText().toString();
        EditText getHours = (EditText) findViewById(R.id.resourceHoureditText);
        al.add(new Resource(name, Integer.parseInt(getHours.getText().toString()), 0, 0));
        aa.notifyDataSetChanged();
        getName.setText("");
        getHours.setText("");
        InputMethodManager imm = (InputMethodManager) getSystemService(this.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getHours.getWindowToken(), 0);
        viewPager.setCurrentItem(1);

    }

    public void addHourFromCurrentResource(View view){
       ViewGroup row = (ViewGroup) view.getParent();
       TextView tv = (TextView) row.getChildAt(0);
        String name = tv.getText().toString();
        Object res = Resource.getResourceByName(name, al);
       int entryIndex = al.indexOf(res);
       Resource entry = al.get(entryIndex);

       entry.setResourceCurrentHours(entry.getResourceCurrentHours()+1);
       entry.setResourceHourUtilization(entry.getResourceCurrentHours().doubleValue()/entry.getResourceAvailableHours().doubleValue());
        aa2.notifyDataSetChanged();
    }

    public void removeHourFromCurrentResource(View view){
        ViewGroup row = (ViewGroup) view.getParent();
        TextView tv = (TextView) row.getChildAt(0);
        String name = tv.getText().toString();
        Object res = Resource.getResourceByName(name, al);
        int entryIndex = al.indexOf(res);
        Resource entry = al.get(entryIndex);

        if(entry.getResourceCurrentHours() > 0){
            entry.setResourceCurrentHours(entry.getResourceCurrentHours()-1);
            entry.setResourceHourUtilization(entry.getResourceCurrentHours().doubleValue()/entry.getResourceAvailableHours().doubleValue());
            aa2.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        al = new ArrayList<Resource>();

        // Initilization
        viewPager = (ViewPager) findViewById(R.id.pager);
        actionBar = getActionBar();
        mAdapter = new TabsPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(mAdapter);
        actionBar.setHomeButtonEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Adding Tabs
        for (String tab_name : tabs) {
            actionBar.addTab(actionBar.newTab().setText(tab_name)
                    .setTabListener(this));
        }

        /**
         * on swiping the viewpager make respective tab selected
         * */
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // on changing the page
                // make respected tab selected
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });


    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
        // on tab selected
        // show respected fragment view
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    }

    private int returnListIndex(View view) {
        ViewGroup row = (ViewGroup) view.getParent();
        TextView tv = (TextView) row.getChildAt(0);
        String name = tv.getText().toString();
        Object res = Resource.getResourceByName(name, al);
        return al.indexOf(res);
    }

}
