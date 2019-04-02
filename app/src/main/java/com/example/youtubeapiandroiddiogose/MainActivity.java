package com.example.youtubeapiandroiddiogose;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class MainActivity extends YouTubeBaseActivity
            implements YouTubePlayer.OnInitializedListener {



    private YouTubePlayerView youTubePlayerView;
    private YouTubePlayerView youTubePlayerView2;
    private static final String GOOGLE_API_KEY = "AIzaSyAYnPND3OchM4lSpagggOgQ60ecvzIIEHI";
    private YouTubePlayer.PlaybackEventListener playbackEventListener;
    private YouTubePlayer.PlayerStateChangeListener playerStateChangeListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        youTubePlayerView = findViewById(R.id.viewYoutubePlayer);
        youTubePlayerView2 = findViewById(R.id.viewYoutubePlayer2);

        youTubePlayerView2.initialize(GOOGLE_API_KEY,this);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this);

        playerStateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
            @Override
            public void onLoading() {
                Toast.makeText(MainActivity.this,"Loading",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onLoaded(String s) {
                Toast.makeText(MainActivity.this,"Loaded",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAdStarted() {

            }

            @Override
            public void onVideoStarted() {
                Toast.makeText(MainActivity.this,"Starting",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onVideoEnded() {
                Toast.makeText(MainActivity.this,"Video Ended :( ",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(YouTubePlayer.ErrorReason errorReason) {

            }
        };

        playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
            @Override
            public void onPlaying() {
                Toast.makeText(MainActivity.this,"Playing",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPaused() {
                Toast.makeText(MainActivity.this,"Paused",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStopped() {
                Toast.makeText(MainActivity.this,"Stopped",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onBuffering(boolean b) {

            }

            @Override
            public void onSeekTo(int i) {

            }
        };

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {

        //youTubePlayer.loadVideo("fxgR46gWMd8");
        Log.i("estado_player", "estado: " +wasRestored);
        //youTubePlayer.cueVideo("fxgR46gWMd8");

        youTubePlayer.setPlaybackEventListener(playbackEventListener);

        youTubePlayer.setPlayerStateChangeListener(playerStateChangeListener);




        youTubePlayer.cuePlaylist("RDd5ITypP0dZk");



    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        Toast.makeText(this,"Erro ao iniciar" + youTubeInitializationResult.toString(),Toast.LENGTH_SHORT).show();
    }
}
