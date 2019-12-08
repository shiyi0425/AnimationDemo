package com.example.animationdemo;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameAnimationActivity extends AppCompatActivity {

    private ImageView ivFrame;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        ivFrame=findViewById(R.id.iv_progress);
        drawable=(AnimationDrawable)ivFrame.getBackground();

        drawable.start();

        Button btnStart=findViewById(R.id.btn_start);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.start();

            }
        });

        Button btnStop=findViewById(R.id.btn_stop);
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawable.stop();
            }
        });


        //第二种方式：动态设置帧动画
//        ivFrame.setImageResource(R.drawable.frame_anim);
//        drawable=(AnimationDrawable)ivFrame.getDrawable();
//        drawable.start();
    }

    //动态创建帧动画

    private AnimationDrawable creatAnimation(){
        AnimationDrawable animationDrawable=new AnimationDrawable();
        for(int i=0;i<8;i++){
            int id=getResources().getIdentifier("wait"+i,"drawable",getPackageName());
            Drawable drawable=getResources().getDrawable(id);
            animationDrawable.addFrame(drawable,100);
        }
        return animationDrawable;
    }
}
