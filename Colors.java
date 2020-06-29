package com.example.graduationproject;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);

        Button click1=(Button)findViewById(R.id.buttonred);
        Button click2=(Button)findViewById(R.id.buttonblue);
        Button click3=(Button)findViewById(R.id.buttongreen);
        Button click4=(Button)findViewById(R.id.buttonorange);
        Button click5=(Button)findViewById(R.id.buttonpurple);
        Button click6=(Button)findViewById(R.id.buttongray);
        Button click7=(Button)findViewById(R.id.buttonwhite);
        Button click8=(Button)findViewById(R.id.buttonblack);


        final MediaPlayer mp1=MediaPlayer.create(getApplicationContext(), R.raw.red);
        final MediaPlayer mp2=MediaPlayer.create(getApplicationContext(), R.raw.blue);
        final MediaPlayer mp3=MediaPlayer.create(getApplicationContext(), R.raw.green);
        final MediaPlayer mp4=MediaPlayer.create(getApplicationContext(), R.raw.orange);
        final MediaPlayer mp5=MediaPlayer.create(getApplicationContext(), R.raw.purple);
        final MediaPlayer mp6=MediaPlayer.create(getApplicationContext(), R.raw.gray);
        final MediaPlayer mp7=MediaPlayer.create(getApplicationContext(), R.raw.white);
        final MediaPlayer mp8=MediaPlayer.create(getApplicationContext(), R.raw.black);

        View.OnClickListener elem = new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {
                    case R.id.buttonred:
                        mp1.start();
                        break;
                    case R.id.buttonblue:
                        mp2.start();
                        break;
                    case R.id.buttongreen:
                        mp3.start();
                        break;
                    case R.id.buttonorange:
                        mp4.start();
                        break;
                    case R.id.buttonpurple:
                        mp5.start();
                        break;
                    case R.id.buttongray:
                        mp6.start();
                        break;
                    case R.id.buttonwhite:
                        mp7.start();
                        break;
                    case R.id.buttonblack:
                        mp8.start();
                        break;
                }
            }
        };
        click1.setOnClickListener(elem);
        click2.setOnClickListener(elem);
        click3.setOnClickListener(elem);
        click4.setOnClickListener(elem);
        click5.setOnClickListener(elem);
        click6.setOnClickListener(elem);
        click7.setOnClickListener(elem);
        click8.setOnClickListener(elem);
    }
}