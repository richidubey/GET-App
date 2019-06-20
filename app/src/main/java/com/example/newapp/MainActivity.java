package com.example.newapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private TextView coalclick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coalclick = (TextView) findViewById(R.id.coalclick);

        coalclick.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (view == coalclick) {
            startActivity(new Intent(this, CoalMill.class));
            finish();
        }
    }
}