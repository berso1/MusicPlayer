package com.example.android.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {

    Button playButton;
    Button stopButton;
    MediaPlayer mediaPlayer;
    float volume = 0.1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.go_your_own_way);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(getApplicationContext(), "chilo", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



        stopButton = (Button) findViewById(R.id.stop_button);
        stopButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
            }
        });

        Button plusButton = (Button) findViewById(R.id.plus);
        plusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = volume + 0.05f;
                mediaPlayer.setVolume(volume,volume);
            }
        });

        Button minusButton = (Button) findViewById(R.id.minus);
        minusButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                volume = volume - 0.05f;

                mediaPlayer.setVolume(volume,volume);
            }
        });

    }
}
