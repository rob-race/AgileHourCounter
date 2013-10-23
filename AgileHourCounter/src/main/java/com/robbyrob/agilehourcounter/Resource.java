package com.robbyrob.agilehourcounter;

import java.util.ArrayList;


/**
 * Created by robertr on 10/21/13.
 */
public class Resource {
    private String resourceName;
    private Integer resourceAvailableHours = 0;
    private Integer resourceCurrentHours = 0;
    private ArrayList<String[]> resourceList = new ArrayList<String[]>();
    //private HashMap<String, HashMap<String, Integer[]>>resourceItem  = new HashMap<HashMap<String, String>, HashMap<String, String>,HashMap<String, String>>();

    public Resource(String name, int resourceAvailableHours, int resourceCurrentHours) {
        this.resourceName = name;
        this.resourceAvailableHours = resourceAvailableHours;
        this.resourceCurrentHours = resourceCurrentHours;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public Integer getResourceAvailableHours() {
        return resourceAvailableHours;
    }

    public void setResourceAvailableHours(Integer resourceAvailableHours) {
        this.resourceAvailableHours = resourceAvailableHours;
    }

    public Integer getResourceCurrentHours() {
        return resourceCurrentHours;
    }

    public void setResourceCurrentHours(Integer resourceCurrentHours) {
        this.resourceCurrentHours = resourceCurrentHours;
    }


    public ArrayList<String[]> getResourceList() {
        return resourceList;
    }

    public void setResourceList(ArrayList<String[]> resourceList) {
        this.resourceList = resourceList;
    }

//    public HashMap<String, HashMap<String, Integer[]>> getResourceItem() {
//        return resourceItem;
//    }
//
//    public void setResourceItem(HashMap<String, HashMap<String, Integer[]>> resourceItem) {
//        this.resourceItem = resourceItem;
//    }
}
