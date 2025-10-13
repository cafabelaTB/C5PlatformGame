package com.tb.c5platformgame;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;


public class PlatformActivity extends Activity {

    // our object to handle the view
    private PlatformView platformView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Display display = getWindowManager().getDefaultDisplay();

        Point resolution = new Point();
        display.getSize(resolution);

        platformView = new PlatformView(this, resolution.x, resolution.y);

        setContentView(platformView);
    }

    @Override
    protected void onPause(){
        super.onPause();
        platformView.onPause();
    }

    @Override
    protected  void onResume(){
        super.onResume();
        platformView.onResume();
    }
}