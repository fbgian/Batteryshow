package com.fabanto.batteryshow;

import processing.core.PApplet;

class Sketch extends PApplet {

    private int level;
    private float dist;
    private float rad;
    private int r, g;
    private String color;

    @Override
    public void settings() {
        super.settings();
        fullScreen();
    }

    @Override
    public void setup() {
        dist = width / 3f;
        rad = dist / 6;
    }

    private void cerchio(){
        pushStyle();
        stroke(255);
        fill(255);
        translate(width / 2.0f, height / 2.0f);
        noFill();
        ellipse(0, 0, 2 * dist, 2 * dist);
        fill(r, g, 0);
        noStroke();
        float theta = level * TWO_PI / 100;
        ellipse(dist * sin(theta), -dist * cos(theta), rad, rad);
        popStyle();
    }

    public void draw() {
        background(0);
        cerchio();
    }

    public void setBatteryLevel(int level) {
        this.level = level;
        r = (100 - level) * 255 * 2;
        g = level * 255 * 2;
        r = r > 255 ? 255 : r;
        g = g > 255 ? 255 : g;
    }
}