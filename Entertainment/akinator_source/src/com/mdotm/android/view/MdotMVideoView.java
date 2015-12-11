// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.VideoView;
import com.mdotm.android.listener.MdotMAdActionListener;
import com.mdotm.android.model.MdotMAdResponse;
import com.mdotm.android.utils.MdotMLogger;

class MdotMVideoView extends VideoView
    implements android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{

    MdotMAdActionListener adActionListener;
    boolean isVideoReady;
    MdotMAdResponse mAdResponse;
    Context mContext;
    private boolean mDidImpressionRecoded;
    boolean mIsGetIntoError;
    ProgressDialog mProgressDialog;

    public MdotMVideoView(Context context, MdotMAdResponse mdotmadresponse, MdotMAdActionListener mdotmadactionlistener)
    {
        super(context);
        mDidImpressionRecoded = false;
        isVideoReady = false;
        mIsGetIntoError = false;
        mContext = context;
        mAdResponse = mdotmadresponse;
        adActionListener = mdotmadactionlistener;
        isVideoReady = false;
        mIsGetIntoError = false;
        mDidImpressionRecoded = false;
        mProgressDialog = new ProgressDialog(context);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.show();
        requestFocus();
        setOnPreparedListener(this);
        setOnCompletionListener(this);
        setOnErrorListener(this);
        setVideoPath(mdotmadresponse.getImageUrl());
        setFocusable(true);
    }

    public void PauseVideo()
    {
        if (isPlaying())
        {
            pause();
        }
    }

    public boolean isReadyToPlay()
    {
        return isVideoReady;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        MdotMLogger.i(this, "On completion of video");
        adActionListener.onPlayStop();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        MdotMLogger.i(this, (new StringBuilder("On error playing  video ")).append(i).append(" extra ").append(j).toString());
        mIsGetIntoError = true;
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
        adActionListener.onPlayError();
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        MdotMLogger.i(this, "onPrepared");
        isVideoReady = true;
        mProgressDialog.dismiss();
        mediaplayer.start();
    }

    public void playVideo()
    {
        if (!isPlaying())
        {
            start();
        }
    }

    public void stopVideo(Handler handler)
    {
        MdotMLogger.i(this, "Stop video playback");
        if (isPlaying())
        {
            stopPlayback();
        }
        if (!mIsGetIntoError && !mDidImpressionRecoded)
        {
            MdotMLogger.i(this, "Call report impression video resource");
            handler.post(new _cls1());
        }
    }


    /* member class not found */
    class _cls1 {}

}
