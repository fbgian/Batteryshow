package com.fabanto.batteryshow;

import processing.core.PApplet;

class Sketch extends PApplet {

    private int level;



    @Override
    public void settings() {
        super.settings();
        fullScreen();
    }

    @Override
    public void setup() {
        background(51);
    }

    public void draw() {
    }

    public void setBatteryLevel(int level){
        this.level=level;
    }
}