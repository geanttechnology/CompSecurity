// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

// Referenced classes of package com.amazon.device.ads:
//            Log

final class AdVideoPlayer
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{
    public static interface AdVideoPlayerListener
    {

        public abstract void onComplete();

        public abstract void onError();
    }


    private static String LOG_TAG = "AdVideoPlayer";
    private AudioManager audioManager_;
    private String contentUrl_;
    private Context context_;
    private android.view.ViewGroup.LayoutParams layoutParams_;
    private AdVideoPlayerListener listener_;
    private Controller.PlayerProperties playerProperties_;
    private boolean released_;
    private VideoView videoView_;
    private ViewGroup viewGroup_;
    private int volumeBeforeMuting_;

    public AdVideoPlayer(Context context)
    {
        released_ = false;
        videoView_ = null;
        layoutParams_ = null;
        viewGroup_ = null;
        context_ = context;
        playerProperties_ = new Controller.PlayerProperties();
        audioManager_ = (AudioManager)context_.getSystemService("audio");
    }

    private void displayPlayerControls()
    {
        Log.d(LOG_TAG, "in displayPlayerControls");
        if (playerProperties_.showControl())
        {
            MediaController mediacontroller = new MediaController(context_);
            videoView_.setMediaController(mediacontroller);
            mediacontroller.setAnchorView(videoView_);
            mediacontroller.requestFocus();
        }
    }

    private void initializeVideoView()
    {
        VideoView videoview = new VideoView(context_);
        videoview.setOnCompletionListener(this);
        videoview.setOnErrorListener(this);
        videoview.setLayoutParams(layoutParams_);
        videoView_ = videoview;
        viewGroup_.addView(videoView_);
    }

    private void loadPlayerContent()
    {
        Uri uri = Uri.parse(contentUrl_);
        videoView_.setVideoURI(uri);
    }

    private void removePlayerFromParent()
    {
        Log.d(LOG_TAG, "in removePlayerFromParent");
        viewGroup_.removeView(videoView_);
    }

    public void mutePlayer()
    {
        Log.d(LOG_TAG, "in mutePlayer");
        volumeBeforeMuting_ = audioManager_.getStreamVolume(3);
        audioManager_.setStreamVolume(3, 0, 4);
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        if (playerProperties_.doLoop())
        {
            videoView_.start();
        } else
        if (playerProperties_.exitOnComplete() || playerProperties_.inline)
        {
            releasePlayer();
            if (listener_ != null)
            {
                listener_.onComplete();
                return;
            }
        }
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        removePlayerFromParent();
        if (listener_ != null)
        {
            listener_.onError();
        }
        return false;
    }

    public void playAudio()
    {
        Log.d(LOG_TAG, "in playAudio");
        loadPlayerContent();
    }

    public void playVideo()
    {
        Log.d(LOG_TAG, "in playVideo");
        if (playerProperties_.doMute())
        {
            mutePlayer();
        }
        initializeVideoView();
        loadPlayerContent();
        startPlaying();
    }

    public void releasePlayer()
    {
        Log.d(LOG_TAG, "in releasePlayer");
        if (!released_)
        {
            released_ = true;
            videoView_.stopPlayback();
            removePlayerFromParent();
            if (playerProperties_.doMute())
            {
                unmutePlayer();
                return;
            }
        }
    }

    public void setLayoutParams(android.view.ViewGroup.LayoutParams layoutparams)
    {
        layoutParams_ = layoutparams;
    }

    public void setListener(AdVideoPlayerListener advideoplayerlistener)
    {
        listener_ = advideoplayerlistener;
    }

    public void setPlayData(Controller.PlayerProperties playerproperties, String s)
    {
        released_ = false;
        if (playerproperties != null)
        {
            playerProperties_ = playerproperties;
        }
        contentUrl_ = s;
    }

    public void setViewGroup(ViewGroup viewgroup)
    {
        viewGroup_ = viewgroup;
    }

    public void startPlaying()
    {
        Log.d(LOG_TAG, "in startPlaying");
        displayPlayerControls();
        if (playerProperties_.isAutoPlay())
        {
            videoView_.start();
        }
    }

    public void unmutePlayer()
    {
        Log.d(LOG_TAG, "in unmutePlayer");
        audioManager_.setStreamVolume(3, volumeBeforeMuting_, 4);
    }

}
