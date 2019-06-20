package com.example.newapp;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;
import android.app.Activity;
import android.content.res.AssetFileDescriptor;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;

import java.io.IOException;

import org.w3c.dom.Text;

import java.io.File;
public class CoalMill extends Activity  implements TextureView.SurfaceTextureListener , MediaController.MediaPlayerControl {


/*
    Button click;
    VideoView video;
    TextView changetext;
    MediaController control;
    TextView header;
    int i=0;
    int curpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coalmill);

        click=(Button) findViewById(R.id.buttonplay);
        changetext=(TextView) findViewById(R.id.buttonplay);
        video=(VideoView) findViewById(R.id.videoview);
        control= new MediaController(this);
        header = (TextView) findViewById(R.id.header);

        Typeface custom= Typeface.createFromAsset(getAssets(),"fonts/Marker.ttf");
        header.setTypeface(custom);


    }

    public void videoplay(View v) {
        i++;
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.coalmill;
        Uri ur = Uri.parse(videopath);
        video.setVideoURI(ur);
        video.setMediaController(control);
        control.setAnchorView(video);



        if (i%2==1)
        {
            changetext.setText("STOP");
            video.start();
        }
        else
        {
            changetext.setText("START");
            video.seekTo(1);
            video.pause();

        }

    }

/**/
// Log tag.
private static final String TAG = CoalMill.class.getName();

    // Asset video file name.
    private static final String FILE_NAME = "coalmill.mp4";

    // MediaPlayer instance to control playback of video file.
    private MediaPlayer mMediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coalmill);

        initView();
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    @Override
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        return true;
    }

    @Override
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture)
    {
    }

    private void initView()
    {
        TextureView textureView = (TextureView) findViewById(R.id.videoview);
        textureView.setSurfaceTextureListener(this);
    }
    @Override
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Surface surface = new Surface(surfaceTexture);

        try {
            AssetFileDescriptor afd = getAssets().openFd(FILE_NAME);
            mMediaPlayer = new MediaPlayer();
            mMediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
            mMediaPlayer.setSurface(surface);
            mMediaPlayer.setLooping(true);
            mMediaPlayer.prepareAsync();

            // Play video when the media source is ready for playback.
            mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mediaPlayer) {
                    mediaPlayer.start();
                }
            });

        } catch (IllegalArgumentException e) {
            Log.d(TAG, e.getMessage());
        } catch (SecurityException e) {
            Log.d(TAG, e.getMessage());
        } catch (IllegalStateException e) {
            Log.d(TAG, e.getMessage());
        } catch (IOException e) {
            Log.d(TAG, e.getMessage());
        }
    }

}
