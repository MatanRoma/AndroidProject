package com.example.androidgameproject;



import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

// this class get sprite sheet and draw it frame by frame

public class Explosion extends Position implements ObjectsInterface {

    private int frame;
    protected Bitmap[] bitmaps;


    public Explosion(Bitmap spriteSheet, int x, int y,int width,int height) {
        super(x, y, width, height);
        final int rows=3,cols=5;

        bitmaps = new Bitmap[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                bitmaps[i*cols+j]=Bitmap.createBitmap(spriteSheet,j*100,i*100,100,100);
            }
        }
        for (int i = 0; i < bitmaps.length; i++) {
            bitmaps[i]=Bitmap.createScaledBitmap(bitmaps[i],width,height,true);
        }
    }



    @Override
    public void draw(Canvas canvas) {
        if (frame < bitmaps.length) {
            canvas.drawBitmap(bitmaps[frame++],x,y,null);
        }
    }
    @Override
    public void update() {}
    public boolean removeExplosion(){ // if all frames drawn return true
        if(frame>=bitmaps.length)
            return true;
        return false;
    }
}