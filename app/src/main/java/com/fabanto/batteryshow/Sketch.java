package com.fabanto.batteryshow;

import android.app.usage.UsageStatsManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.util.Log;

import processing.core.PApplet;


class Sketch extends PApplet {

    private int level;
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
    }


    public void printLevel() {
        //stroke(255);
        textSize(192);
        textAlign(CENTER);
        text(level + "%", displayWidth / 2.0f, displayHeight / 2.0f);
    }


    public void draw() {
        background(0);
        printLevel();
    }

    public void setBatteryLevel(int level) {
        this.level = level;
        Log.d("flag = ", flag + "");

        if (level == 100 && !flag) {
            sp.play(soundID, 1, 1, 1, 0, 1);
            flag = true;
            Log.d("flag dopo if = ", flag + "");
        } else if (level != 100) flag = false;
    }
}