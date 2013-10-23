package com.robbyrob.agilehourcounter;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by robertr on 10/21/13.
 */
public class AgileHourCounter extends Application {
    private Resource currentResource;
    private ArrayList<String> al;

    public Resource getCurrentResource() {
        return currentResource;
    }

    public void setCurrentResource(Resource currentResource) {
        this.currentResource = currentResource;
    }

    public ArrayList<String> getAl() {
        return al;
    }

    public void setAl(ArrayList<String> al) {
        this.al = al;
    }
}
