package com.example.newapp;

import android.app.Activity;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.sprylab.android.widget.TextureVideoView;

public class Grinding extends Activity{


    Button click;
    TextureVideoView video;
    TextView changetext;
    MediaController control;
    TextView header;
    Button prev;
    Button next;
    ImageSwitcher sw;

    int i=0;
    int j=2;
    int curpos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grinding);
        changetext=(TextView) findViewById(R.id.buttonplay);

        click=(Button) findViewById(R.id.buttonplay);
        prev=(Button) findViewById(R.id.prev);
        next=(Button)findViewById(R.id.next);

        video=(TextureVideoView) findViewById(R.id.videoview);
        control= new MediaController(this);

        header = (TextView) findViewById(R.id.header);
        Typeface custom= Typeface.createFromAsset(getAssets(),"fonts/Marker.ttf");
        header.setTypeface(custom);

        sw=(ImageSwitcher)findViewById(R.id.imageswitcher);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(getApplicationContext());
                myView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                myView.setAdjustViewBounds(true);

               // myView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                myView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

                return myView;
            }
        });
        sw.setImageResource(R.mipmap.b2);


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(j<3) {
                    Toast.makeText(Grinding.this, "Next Image", Toast.LENGTH_SHORT).show();


                    j++;

                    if (j == 1)
                        sw.setImageResource(R.mipmap.a2);
                    else if (j == 2) sw.setImageResource(R.mipmap.b2);
                    else if (j == 3)
                        sw.setImageResource(R.mipmap.c2);
                }
                else Toast.makeText(Grinding.this, "End of Pics", Toast.LENGTH_SHORT).show();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(j>1)
                {
                    Toast.makeText(Grinding.this, "Previous Image", Toast.LENGTH_SHORT).show();
                    j--;

                    if (j == 1)
                        sw.setImageResource(R.mipmap.a2);
                    else if (j == 2) sw.setImageResource(R.mipmap.b2);
                    else if (j == 3)
                        sw.setImageResource(R.mipmap.c2);
                }
                else Toast.makeText(Grinding.this, "End of Pics", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void videoplay(View v) {
        i++;
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.grind;
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

/*
@Override
public int getAudioSessionId() {
        // TODO 自動生成されたメソッド・スタブ
        return 0;
    }

    TextView header;


// Log tag.
private static final String TAG = CoalMill.class.getName();
private int mDuration=0;

    // Asset video file name.
    private static final String FILE_NAME = "coalmill.mp4";

    // MediaPlayer instance to control playback of video file.
    private MediaPlayer mMediaPlayer;
    private TextureView textureView;

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
        textureView = (TextureView) findViewById(R.id.videoview);
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

            mDuration=mMediaPlayer.getDuration();
            MediaController videoController = new MediaController(CoalMill.this);
            videoController.setMediaPlayer(this);//your activity which implemented MediaPlayerControl
            videoController.setAnchorView(textureView);
            videoController.setEnabled(true);
            videoController.show();

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
    @Override
    public void start() {
        // TODO 自動生成されたメソッド・スタブ

    }

    @Override
    public void pause() {
        // TODO 自動生成されたメソッド・スタブ

    }
    @Override
    public int getDuration() {
        // TODO 自動生成されたメソッド・スタブ
        return mDuration;
    }
    @Override
    public int getCurrentPosition() {
        // TODO 自動生成されたメソッド・スタブ
        return mMediaPlayer.getCurrentPosition();
    }
    @Override
    public void seekTo(int pos) {
        // TODO 自動生成されたメソッド・スタブ

    }
    @Override
    public boolean isPlaying() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }
    @Override
    public int getBufferPercentage() {
        // TODO 自動生成されたメソッド・スタブ
        return 0;
    }
    @Override
    public boolean canPause() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

    @Override
    public boolean canSeekBackward() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }


    @Override
    public boolean canSeekForward() {
        // TODO 自動生成されたメソッド・スタブ
        return false;
    }

*/

}

