package com.fabanto.batteryshow;

import android.app.usage.UsageStatsManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;

import processing.core.PApplet;


class Sketch extends PApplet {

    private int level;
    private float dist;
    private float rad;
    private int r, g;
    private String color;
    SoundPool sp = new SoundPool.Builder().build();
    int soundID;
    boolean flag = false;

    @Override
    public void settings() {
        super.settings();
        fullScreen();
    }

    @Override
    public void setup() {
        soundID = sp.load(getContext(), R.raw.fanfara, 1);
        flag = false;
        dist = width / 3f;
        rad = dist / 6;
    }

    private void cerchio(){
        pushStyle();
        pushMatrix();
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
        popMatrix();
    }

    public void draw() {
        background(0);
        cerchio();
        printLevel();
    }


    public void printLevel() {
        //stroke(255);
        textSize(192);
        textAlign(CENTER, CENTER);
        text(level + "%", displayWidth / 2.0f, displayHeight / 2.0f);
    }

    public void setBatteryLevel(int level) {
        this.level = level;
        r = (100 - level) * 255 * 2;
        g = level * 255 * 2;
        r = r > 255 ? 255 : r;
        g = g > 255 ? 255 : g;

        if (level == 100 && !flag) {
            sp.play(soundID, 1, 1, 1, 0, 1);
            flag = true;
        } else if (level != 100) flag = false;
    }
}