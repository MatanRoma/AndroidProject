package com.example.androidgameproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread extends Thread implements Runnable {

    private int fps;
    private double avgFps;
    private SurfaceHolder surfaceHolder;
    private GameSurfaceView gameSurfaceView;
    public static Canvas canvas;
    private Boolean running;

    public MainThread(SurfaceHolder surfaceHolder, GameSurfaceView gameSurfaceView) {
        super();
        this.surfaceHolder = surfaceHolder;
        this.gameSurfaceView = gameSurfaceView;
        fps=30;
    }

    @Override
    public void run() {
        super.run();
        long timeMillis, startTime, waitTime,targetTime;
        targetTime=1000/fps;
        while (running) {
            startTime = System.nanoTime();

            updateGame();

            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;
            try {
                sleep(waitTime);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    private void updateGame(){
        canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            synchronized (surfaceHolder) {
                gameSurfaceView.update();
                gameSurfaceView.draw(canvas);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (canvas != null)
                try {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
        }
    }
    public void setRunning(boolean bool){
        running=bool;
    }

    public Boolean getRunning() {
        return running;
    }
}


