package com.example.newapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;

public class ListActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView coalclick;
    private TextView superclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listactivity);
        coalclick = (TextView) findViewById(R.id.coalclick);
        superclick=(TextView) findViewById(R.id.supercritically);

        coalclick.setOnClickListener(this);
        superclick.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == coalclick) {
          //  startActivity(new Intent(this, CoalMill.class));
            //Animatoo.animateFade(this);


                Intent videoPlaybackActivity = new Intent(this, CoalMill.class);
                //videoPlaybackActivity.putExtra("videoPath", videoPath);
                startActivity(videoPlaybackActivity);


        }

        else if(view==superclick)
        {
            startActivity(new Intent(this,SuperCriticalBoilers.class));
            Animatoo.animateDiagonal(this);

        }
    }
}