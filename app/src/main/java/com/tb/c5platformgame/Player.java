package com.tb.c5platformgame;

import android.content.Context;

public class Player extends GameObject {

    Player(Context context, float worldStartX, float worldStartY, int pixelsPerMetre){

        final float HEIGHT = 2;
        final float WIDTH = 1;

        setHeight(HEIGHT);
        setWidth(WIDTH);

        settype('p');

        setBitmapName("player");

        setWorldLocation(worldStartX, worldStartY, 0);
    }

    public void update(long fps, float gravity){
    }
}
