package com.example.networking;

import android.widget.ImageView;
import android.widget.TextView;

public class Mountain {
    String ID;
    String name;
    String type;
    String company;
    String location;
    String category;
    int size;
    int cost;
    AuxData auxdata;

    public AuxData getAuxData() {
        return auxdata;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public int getSize() {
        return size;
    }

    public int getCost() {
        return cost;
    }
}
