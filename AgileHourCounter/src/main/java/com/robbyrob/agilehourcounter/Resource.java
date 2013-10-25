package com.robbyrob.agilehourcounter;

import java.util.ArrayList;


/**
 * Created by robertr on 10/21/13.
 */
public class Resource {
    private String resourceName;
    private Integer resourceAvailableHours = 0;
    private Integer resourceCurrentHours = 0;
    private Double resourceHourUtilization = 0d;

    public Resource(String name, int resourceAvailableHours, int resourceCurrentHours, double resourceHourUtilization) {
        this.resourceName = name;
        this.resourceAvailableHours = resourceAvailableHours;
        this.resourceCurrentHours = resourceCurrentHours;
        this.resourceHourUtilization = resourceHourUtilization;
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

    public Double getResourceHourUtilization() {
        return resourceHourUtilization;
    }

    public void setResourceHourUtilization(Double resourceHourUtilization) {
        this.resourceHourUtilization = resourceHourUtilization;
    }

    public static Object getResourceByName(String name, ArrayList<Resource> list) {
        Object ret = new Object();
        for (Resource res : list) {
            if (res.getResourceName() == name) {
                ret = res;
            }
        }
        return ret;
    }

}
