// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mdotm.android.vast;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.VideoView;
import com.mdotm.android.listener.InterstitialVideoListener;
import com.mdotm.android.listener.MdotMAdActionListener;
import com.mdotm.android.utils.MdotMLogger;
import java.util.ArrayList;
import java.util.Timer;

// Referenced classes of package com.mdotm.android.vast:
//            LinearAd, AdResource, LinearAdTrackingEvents, VolumnContentObserver

public class VastVideoView extends VideoView
    implements android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
{

    private MdotMAdActionListener adActionListener;
    private int duration;
    private ImpressionItem impression;
    ArrayList impressionString;
    private boolean isRewarded;
    boolean isVideoReady;
    private LinearAd mAdResponse;
    private Context mContext;
    private boolean mDidImpressionRecoded;
    private Handler mHandler;
    boolean mIsGetIntoError;
    private ProgressDialog mProgressDialog;
    private LinearAdTrackingEvents trackingEvents;
    private InterstitialVideoListener videoListener;
    private Timer videoTimer;
    private VolumnContentObserver volumnListener;

    public VastVideoView(Context context)
    {
        super(context);
        mDidImpressionRecoded = false;
        isVideoReady = false;
        mIsGetIntoError = false;
        isRewarded = false;
    }

    public VastVideoView(Context context, LinearAd linearad, MdotMAdActionListener mdotmadactionlistener, InterstitialVideoListener interstitialvideolistener, Handler handler, ArrayList arraylist, boolean flag)
    {
        super(context);
        mDidImpressionRecoded = false;
        isVideoReady = false;
        mIsGetIntoError = false;
        isRewarded = false;
        mContext = context;
        mAdResponse = linearad;
        mHandler = handler;
        trackingEvents = mAdResponse.getTrackingEvents();
        adActionListener = mdotmadactionlistener;
        videoListener = interstitialvideolistener;
        impressionString = arraylist;
        isRewarded = flag;
        prepareVideo();
    }

    private void cancelTimer()
    {
        if (videoTimer != null)
        {
            videoTimer.cancel();
        }
        if (volumnListener != null)
        {
            mContext.getContentResolver().unregisterContentObserver(volumnListener);
        }
    }

    private void prepareVideo()
    {
        isVideoReady = false;
        mIsGetIntoError = false;
        mDidImpressionRecoded = false;
        mProgressDialog = new ProgressDialog(mContext);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setOnDismissListener(new _cls1());
        mProgressDialog.show();
        String s = mAdResponse.getAdResource().getUrl();
        MdotMLogger.i(this, (new StringBuilder("video path :: ")).append(s).toString());
        setZOrderOnTop(true);
        setVideoPath(s);
        requestFocus();
        setOnPreparedListener(this);
        setOnCompletionListener(this);
        setOnErrorListener(this);
    /* block-local class not found */
    class ImpressionItem {}

        impression = new ImpressionItem();
    }

    public void PauseVideo()
    {
        if (isPlaying())
        {
            pause();
            if (trackingEvents != null)
            {
                MdotMLogger.i(this, "Pause impression event");
                ImpressionItem.access._mth0(impression, trackingEvents.pause);
            }
        } else
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
            return;
        }
    }

    public boolean isReadyToPlay()
    {
        return isVideoReady;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        MdotMLogger.i(this, "On completion of video");
        videoListener.showCloseButton();
        impression.isComplete = true;
        if (trackingEvents != null)
        {
            ImpressionItem.access._mth0(impression, trackingEvents.complete);
        }
        adActionListener.onPlayStop();
        cancelTimer();
    }

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        MdotMLogger.i(this, (new StringBuilder("On error playing  video ")).append(i).append(" extra ").append(j).toString());
        mIsGetIntoError = true;
        if (mProgressDialog != null && mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
        ImpressionItem.access._mth0(impression, null);
        adActionListener.onPlayError();
        return true;
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        mediaplayer = mAdResponse.getDuration();
        MdotMLogger.i(this, (new StringBuilder("responseDuration")).append(mediaplayer).toString());
        duration = getDuration() / 1000;
        if (mediaplayer != null && duration < 0)
        {
            if (mediaplayer.matches("[0-9]{2}:[0-9]{2}:[0-9]{2}"))
            {
                mediaplayer = mediaplayer.split(":");
                duration = Integer.parseInt(mediaplayer[0]) * 3600 + Integer.parseInt(mediaplayer[1]) * 60 + Integer.parseInt(mediaplayer[2]);
            } else
            if (mediaplayer.matches("[0-9]+"))
            {
                duration = Integer.parseInt(mediaplayer);
            } else
            {
                duration = getDuration() / 1000;
            }
            MdotMLogger.i(this, (new StringBuilder("responseDuration")).append(duration).toString());
        }
        ImpressionItem.access._mth1(impression, duration);
        isVideoReady = true;
        mProgressDialog.dismiss();
        start();
        videoListener.setPlayStart();
        ImpressionItem.access._mth0(impression, impressionString);
        if (trackingEvents != null)
        {
            MdotMLogger.i(this, "Start playing video");
            ImpressionItem.access._mth0(impression, trackingEvents.start);
            ImpressionItem.access._mth0(impression, trackingEvents.creativeView);
        }
        if (trackingEvents != null)
        {
            volumnListener = new VolumnContentObserver(mContext, mHandler, trackingEvents.mute, trackingEvents.unMute);
            mContext.getContentResolver().registerContentObserver(android.provider.Settings.System.CONTENT_URI, true, volumnListener);
        }
    }

    public void playVideo()
    {
        if (!isPlaying() && !impression.isComplete)
        {
            start();
            if (trackingEvents != null)
            {
                MdotMLogger.i(this, "Resume impression");
                ImpressionItem.access._mth0(impression, trackingEvents.resume);
            }
            return;
        } else
        {
            MdotMLogger.i(this, "Play called after one complete play");
            prepareVideo();
            return;
        }
    }

    public void skipVideo()
    {
        MdotMLogger.i(this, "Skip impression event");
        if (trackingEvents != null && trackingEvents.skip != null)
        {
            ImpressionItem.access._mth0(impression, trackingEvents.skip);
        }
    }

    public void stopVideo()
    {
        MdotMLogger.i(this, "Stop video playback");
        if (isPlaying())
        {
            stopPlayback();
        }
        cancelTimer();
        if (!mIsGetIntoError && !mDidImpressionRecoded)
        {
            MdotMLogger.i(this, "Call report impression video resource");
            mDidImpressionRecoded = true;
        }
    }












    /* member class not found */
    class _cls1 {}

}
