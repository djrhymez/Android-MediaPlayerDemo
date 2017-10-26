/**
 * sound files must be added to raw folder before MediaPlayer can access them
 * Supported formats for MediaPlayer class https://developer.android.com/guide/topics/media/media-formats.html
 */

package com.example.dan.mediaplayerdemo;

import android.media.MediaPlayer;
import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // MediaPlayer class controls sounds/music
    private MediaPlayer mediaPlayer;
    private Button btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPlay = (Button) findViewById(R.id.btnPlay);

        //creates Media player
        mediaPlayer = MediaPlayer.create(this, R.raw.sunrise);

        //sets wake mode to allow sounds to play when screen is locked
        mediaPlayer.setWakeMode(this, PowerManager.PARTIAL_WAKE_LOCK);

        //switches button text and pauses/plays sound
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    btnPlay.setText("Play");
                    Toast.makeText(MainActivity.this, "Media Player Paused", Toast.LENGTH_SHORT).show();
                }
                else {
                    mediaPlayer.start();
                    btnPlay.setText("Pause");
                    Toast.makeText(MainActivity.this, "Media Player Started", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
