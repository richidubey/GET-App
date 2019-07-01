package com.example.newapp;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.sprylab.android.widget.TextureVideoView;

import org.w3c.dom.Text;

import bg.devlabs.fullscreenvideoview.FullscreenVideoView;

public class videoplayer extends Activity implements View.OnTouchListener{

   private TextureVideoView mVV;

    MediaController control;
    int i=0;


    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.videoplayer);

        mVV = (TextureVideoView) findViewById(R.id.myvideoview);

        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.coalmill;
        Uri ur = Uri.parse(videopath);
        mVV.setVideoURI(ur);
        mVV.setMediaController(control);
        mVV.setOnTouchListener(this);
        control = new MediaController(this);
        control.setAnchorView(mVV);

        mVV.start();
    }
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        i++;

        int lastloc=1;

        if(i%2==1)
        {
            lastloc=mVV.getCurrentPosition();
           mVV.pause();

        }
        else {

 //           mVV.seekTo(lastloc);
            mVV.start();
        }


        return true;
    }

}

