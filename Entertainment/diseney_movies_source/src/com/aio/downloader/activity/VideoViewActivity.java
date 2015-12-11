// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.activity;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;
import com.umeng.analytics.MobclickAgent;
import java.io.File;

public class VideoViewActivity extends Activity
{

    private boolean fullscreen;
    private MediaController mController;
    private VideoView videoView;
    private String video_item_url;

    public VideoViewActivity()
    {
        fullscreen = false;
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0300bf);
        videoView = (VideoView)findViewById(0x7f070406);
        mController = new MediaController(this);
        video_item_url = getIntent().getStringExtra("playurl");
        bundle = new File(video_item_url);
        if (!fullscreen)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(12);
            layoutparams.addRule(10);
            layoutparams.addRule(9);
            layoutparams.addRule(11);
            videoView.setLayoutParams(layoutparams);
            fullscreen = true;
        } else
        {
            android.widget.RelativeLayout.LayoutParams layoutparams1 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            layoutparams1.addRule(13);
            videoView.setLayoutParams(layoutparams1);
            fullscreen = false;
        }
        if (bundle.exists())
        {
            videoView.setVideoPath(bundle.getAbsolutePath());
            videoView.setMediaController(mController);
            mController.setMediaPlayer(videoView);
            videoView.requestFocus();
            videoView.start();
        }
        videoView.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final VideoViewActivity this$0;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                finish();
            }

            
            {
                this$0 = VideoViewActivity.this;
                super();
            }
        });
    }

    protected void onPause()
    {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    protected void onResume()
    {
        super.onResume();
        MobclickAgent.onResume(this);
    }
}
