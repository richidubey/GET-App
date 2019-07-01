package com.example.newapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.prush.typedtextview.TypedTextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    TextView homebut ;
    TypedTextView typedtext;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homebut=(TextView)findViewById(R.id.homebutton);
        homebut.setOnClickListener(this);
        typedtext=(TypedTextView)findViewById(R.id.typedtext);

        typedtext.setTypedText("Welcome to APTRI Labs,\nan Educational App built at\nAdani Shantigram, Ahmedabad.");
    }

    public void onClick(View view)
    {
        if(view==homebut)
        {
            startActivity(new Intent(this,ListActivity.class));
            Animatoo.animateSplit(this);
            finish();
        }
    }
}