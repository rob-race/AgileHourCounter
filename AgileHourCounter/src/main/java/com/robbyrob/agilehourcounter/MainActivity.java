package com.robbyrob.agilehourcounter;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements
        ActionBar.TabListener {

    private ViewPager viewPager;
    private TabsPagerAdapter mAdapter;
    private ActionBar actionBar;
    public static Resource currentResource;
    public static ArrayList<Resource> al;
    public static ArrayList<String> strar;
    // Tab titles
    private String[] tabs = { "Counter", "Resources", "Add Resource" };

    public void moveToAdd(View view){
        viewPager.setCurrentItem(2);
    }

    public void modifyResource(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Soon")
                .setMessage("There will be some edit and delete action up in here...")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .show();
    }

    public void addResource(View view) {

        EditText getName = (EditText) findViewById(R.id.resourceNameeditText);
        String name = getName.getText().toString();
        EditText getHours = (EditText) findViewById(R.id.resourceHoureditText);
        TextView util = (TextView) findViewById(R.id.current_hours_util);
        util.setText("this");
        al.add(new Resource(name, Integer.parseInt(getHours.getText().toString()), 0));
        strar.clear();
        for (Resource item : al) {
            strar.add(item.getResourceName());
        }

        getName.setText("");
        getHours.setText("");
        ResourceFragment.aa.notifyDataSetChanged();
        viewPager.setCurrentItem(1);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //currentResource = new Resource();
        al = new ArrayList<Resource>();
        strar = new ArrayList<String>();

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

}
