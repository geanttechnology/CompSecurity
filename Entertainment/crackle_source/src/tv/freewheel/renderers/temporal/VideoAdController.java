// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.temporal;

import android.media.MediaPlayer;
import android.os.SystemClock;
import tv.freewheel.utils.Logger;

// Referenced classes of package tv.freewheel.renderers.temporal:
//            VideoAdView, VideoRenderer

public class VideoAdController
    implements android.widget.MediaController.MediaPlayerControl
{

    private static long REWIND_INTERVAL = 1000L;
    private long lastRewindTime;
    private Logger logger;
    private MediaPlayer mediaPlayer;
    private boolean pausedByController;
    private VideoAdView videoAdView;
    private VideoRenderer videoRenderer;

    public VideoAdController(VideoRenderer videorenderer, VideoAdView videoadview, MediaPlayer mediaplayer)
    {
        pausedByController = false;
        lastRewindTime = 0L;
        logger = Logger.getLogger(this);
        videoRenderer = videorenderer;
        videoAdView = videoadview;
        mediaPlayer = mediaplayer;
    }

    public boolean canPause()
    {
        return true;
    }

    public boolean canSeekBackward()
    {
        return true;
    }

    public boolean canSeekForward()
    {
        return false;
    }

    public int getAudioSessionId()
    {
        return mediaPlayer.getAudioSessionId();
    }

    public int getBufferPercentage()
    {
        return 0;
    }

    public int getCurrentPosition()
    {
        return (int)videoAdView.getPlayheadTime();
    }

    public int getDuration()
    {
        return (int)videoAdView.getDuration();
    }

    public boolean isPlaying()
    {
        return videoAdView.isInPlaybackState() && mediaPlayer.isPlaying();
    }

    protected void onImprTimer()
    {
        logger.debug("onImprTimer");
    }

    public void pause()
    {
        logger.debug("pause");
        videoAdView.pause();
        pausedByController = true;
        videoRenderer.onAdPaused();
    }

    public void seekTo(int i)
    {
        logger.debug((new StringBuilder()).append("seekTo ").append(i).append(", currentPosition ").append(mediaPlayer.getCurrentPosition()).toString());
        if (i >= mediaPlayer.getCurrentPosition())
        {
            logger.debug("disallow seek forward");
            return;
        }
        videoAdView.seekTo(i);
        long l = SystemClock.elapsedRealtime();
        logger.debug((new StringBuilder()).append("current time ").append(l).append(", last rewind time ").append(lastRewindTime).toString());
        if (l > lastRewindTime + REWIND_INTERVAL)
        {
            videoRenderer.onAdRewind();
        }
        lastRewindTime = l;
    }

    public void start()
    {
        logger.debug("start");
        videoAdView.start();
        if (pausedByController)
        {
            pausedByController = false;
            videoRenderer.onAdResumed();
        }
    }

}
