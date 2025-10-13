package com.tb.c5platformgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class PlatformView  extends SurfaceView implements Runnable{

    private boolean debugging = true;
    private volatile boolean running;
    private Thread gameThread = null;

    private Paint paint;

    private Canvas canvas;
    private SurfaceHolder ourHolder;

    Context context;
    long startFrameTime;
    long timeThisFrame;
    long fps;

    private LevelManager lm;
    private Viewport vp;
    InputController ic;

    PlatformView(Context context, int screenWidth, int screenHeight){
        super(context);
        this.context = context;

        ourHolder = getHolder();
        paint = new Paint();
    }

    @Override
    public void run(){
        while(running){
            startFrameTime = System.currentTimeMillis();

            update();
            draw();

            //Calculate the fps this frame we can then use the result to
            // time animations and movement
            timeThisFrame = System.currentTimeMillis() - startFrameTime;
            if(timeThisFrame >= 1){
                fps = 1000 / timeThisFrame;
            }
        }
    }

    private void update(){

    }

    private  void draw(){
        if(ourHolder.getSurface().isValid()){
            canvas = ourHolder.lockCanvas();

            paint.setColor(Color.argb(255,0,0,255));
            canvas.drawColor(Color.argb(255,0,0,255));

            // New drawing code will go here

            // Unlock and draw the scene
            ourHolder.unlockCanvasAndPost(canvas);
        }
    }

    public void pause(){
        running = false;
        try{
            gameThread.join();
        }catch (InterruptedException e){
            Log.e("error", "failed to pause thread");
        }
    }


    // Make a new thread and start it
    // Execution moves to our run method
    public void resume(){
        running = true;
        gameThread = new Thread(this);
        gameThread.start();
    }
}
