package com.example.androidgameproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
import android.app.AlertDialog;
>>>>>>> 12ed3584f78d7f34e61b8542ea42906eb705de51
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    boolean sound_bool = true;
    String [] player_name={"Liran"};

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button scores_table = findViewById(R.id.scores_table_btn);
        scores_table.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Best Scores!").setItems(player_name, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, player_name[which].toString(), Toast.LENGTH_SHORT).show();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).show();
            }
        });

        mp = MediaPlayer.create(this,R.raw.opening_sound_liran);
        mp.start();
        mp.setLooping(true);

        ImageView start_anim = findViewById(R.id.start_anim);
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.scale_start_anim);
        start_anim.startAnimation(animation1);

        final Button sound_btn = findViewById(R.id.sound_btn);
        sound_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sound_bool) {
                    sound_btn.setBackground(getDrawable(R.drawable.ic_mute_icon));
                    sound_bool = false;
                    mp.pause();
                } else {
                    sound_btn.setBackground(getDrawable(R.drawable.ic_speaker_icon));
                    sound_bool = true;
                    mp.start();
                }
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mp.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mp.start();
    }

    public void listnerGame(View view) {
        //Intent intent =new Intent(this,GameActivity.class);
        //startActivity(intent);
    }


}
