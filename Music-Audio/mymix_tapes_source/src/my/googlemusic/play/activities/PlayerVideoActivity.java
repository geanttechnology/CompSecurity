// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.activities;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.MediaController;
import android.widget.VideoView;
import java.util.List;
import my.googlemusic.play.model.Video;

public class PlayerVideoActivity extends ActionBarActivity
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnErrorListener, android.media.AudioManager.OnAudioFocusChangeListener
{
    private static class ViewHolder
    {

        View loading;
        VideoView video;

        private ViewHolder()
        {
        }

    }


    public static final String EXTRAS_VIDEO_LIST = "VideoList";
    public static final String EXTRAS_VIDEO_SELECTED = "VideoSelected";
    private AudioManager mAudioManager;
    private ViewHolder mHolder;
    private List mVideoList;
    private int mVideoSelected;

    public PlayerVideoActivity()
    {
    }

    private MediaController initController()
    {
        MediaController mediacontroller = new MediaController(this);
        mediacontroller.setPrevNextListeners(new android.view.View.OnClickListener() {

            final PlayerVideoActivity this$0;

            public void onClick(View view)
            {
                nextVideo();
            }

            
            {
                this$0 = PlayerVideoActivity.this;
                super();
            }
        }, new android.view.View.OnClickListener() {

            final PlayerVideoActivity this$0;

            public void onClick(View view)
            {
                previusVideo();
            }

            
            {
                this$0 = PlayerVideoActivity.this;
                super();
            }
        });
        return mediacontroller;
    }

    private void initData()
    {
        mAudioManager = (AudioManager)getSystemService("audio");
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            mVideoList = bundle.getParcelableArrayList("VideoList");
            mVideoSelected = bundle.getInt("VideoSelected");
        }
        mHolder.video.setOnPreparedListener(this);
        mHolder.video.setOnCompletionListener(this);
        mHolder.video.setOnErrorListener(this);
        mHolder.video.setMediaController(initController());
        playVideo();
    }

    private void initView()
    {
        getSupportActionBar().hide();
        mHolder = new ViewHolder();
        mHolder.loading = findViewById(0x7f0d019b);
        mHolder.video = (VideoView)findViewById(0x7f0d0118);
    }

    private void nextVideo()
    {
        mVideoSelected = mVideoSelected + 1;
        if (mVideoSelected >= mVideoList.size())
        {
            mVideoSelected = 0;
        }
        playVideo();
    }

    private void playVideo()
    {
        requestFocus();
        setLoading(true);
        String s = ((Video)mVideoList.get(mVideoSelected)).getUrl();
        VideoView videoview = mHolder.video;
        if (!s.contains("http://"))
        {
            s = (new StringBuilder()).append("http://").append(s).toString();
        }
        videoview.setVideoURI(Uri.parse(s));
        mHolder.video.requestFocus();
    }

    private void previusVideo()
    {
        mVideoSelected = mVideoSelected - 1;
        if (mVideoSelected < 0)
        {
            mVideoSelected = mVideoList.size() - 1;
        }
        playVideo();
    }

    private void setLoading(boolean flag)
    {
        View view = mHolder.loading;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    public boolean abandonFocus()
    {
        return 1 == mAudioManager.abandonAudioFocus(this);
    }

    public void onAudioFocusChange(int i)
    {
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        nextVideo();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        super.getWindow().setFlags(1024, 1024);
        setContentView(0x7f030030);
        initView();
        initData();
    }

    protected void onDestroy()
    {
        super.onDestroy();
        abandonFocus();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        finish();
        return true;
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 82)
        {
            return true;
        } else
        {
            return super.onKeyDown(i, keyevent);
        }
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mHolder.video.start();
        setLoading(false);
    }

    public boolean requestFocus()
    {
        return 1 == mAudioManager.requestAudioFocus(this, 3, 2);
    }


}
