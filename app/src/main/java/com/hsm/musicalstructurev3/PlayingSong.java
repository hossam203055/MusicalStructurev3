package com.hsm.musicalstructurev3;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayingSong extends AppCompatActivity {

    static MediaPlayer currentSongPlaying;
    Button playPauseButton;
    Button stopButton;
    Button backButton;
    TextView currentSong;
    TextView currentArtist;
    ImageView currentSongImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playing_song);

        Bundle getCurrentSongBundle = getIntent().getExtras();
        currentSongPlaying = MediaPlayer.create(getApplicationContext(),getCurrentSongBundle.getInt("songId"));

        playPauseButton = findViewById(R.id.playPauseButton);
        stopButton = findViewById(R.id.stopButton);
        backButton = findViewById(R.id.backButton);
        currentSong = findViewById(R.id.songTextViewInCurrentPlaying);
        currentArtist = findViewById(R.id.artistTextViewInCurrentPlaying);
        currentSongImage = findViewById(R.id.songImageViewInCurrentPlaying);

        currentSong.setText(getCurrentSongBundle.getString("song"));
        currentArtist.setText(getCurrentSongBundle.getString("artist"));
        currentSongImage.setImageResource(getCurrentSongBundle.getInt("image"));
        final int currentSongId = getCurrentSongBundle.getInt("songId"); //to stop song and restart again

        View.OnClickListener playPauseAction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (currentSongPlaying.isPlaying()){
                    currentSongPlaying.pause();
                    playPauseButton.setText("Play");
                }
                else {
                    currentSongPlaying.start();
                    playPauseButton.setText("Pause");
                }
            }
        };

        View.OnClickListener stopAction = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentSongPlaying.stop();
                currentSongPlaying = MediaPlayer.create(getApplicationContext(),currentSongId);
                playPauseButton.setText("Play");
            }
        };

        View.OnClickListener backAction = (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSongPlaying.stop();
                finish();
            }
        });

        playPauseButton.setOnClickListener(playPauseAction);
        stopButton.setOnClickListener(stopAction);
        backButton.setOnClickListener(backAction);

    }


}
