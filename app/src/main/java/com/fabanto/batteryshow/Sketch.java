package com.fabanto.batteryshow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.util.Log;

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