package com.ladr.myapplvl11.app.figures;

import android.widget.TextView;

import com.ladr.myapplvl11.app.SystemOutView;

/**
 * Created by user on 07.06.2014.
 */
public class Shape extends SystemOutView {
    private static final String name = "Shape";


    public Shape(TextView view) {
        super(view);
    }

    public void draw(){
        System.out.println(name + " drawn.");
    }

    public void erase(){
        System.out.println(name + " erased.");

    }

    public void move(){}

    public void getColor(){}

    public void setColor(){}
}
