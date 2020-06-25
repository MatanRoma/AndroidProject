package com.example.androidgameproject;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Shield extends Position implements ObjectsInterface {
    private Bitmap bitmap;
    public Shield(Bitmap bitmap, int x, int y){
        super(x,y,bitmap.getWidth(),bitmap.getHeight());
        this.bitmap=bitmap;
    }
    @Override
    public void draw(Canvas canvas) {
        canvas.drawBitmap(bitmap,x,y,null);
    }

    @Override
    public void update() {
        final int speed=12;
        x-=speed;
    }
}
