// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.metrics.Profiler;
import com.amazon.gallery.foundation.metrics.Timer;
import com.amazon.gallery.framework.gallery.metrics.VideoEvent;
import com.amazon.gallery.framework.gallery.video.player.ErrorCodeResolver;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.Video;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoMetrics
{

    private Timer initialBufferingTimer;
    private final AtomicBoolean isInitialBuffering = new AtomicBoolean(false);
    private final AtomicBoolean isPreloading = new AtomicBoolean(false);
    private final AtomicBoolean isRebuffering = new AtomicBoolean(false);
    private ComponentProfiler mProfiler;
    private Timer preloadTimer;
    private Timer rebufferingTimer;

    public VideoMetrics(Profiler profiler)
    {
        mProfiler = new ComponentProfiler(profiler, com/amazon/gallery/framework/gallery/metrics/VideoEvent);
        preloadTimer = mProfiler.newTimer(VideoEvent.StartPlayingVideo);
        initialBufferingTimer = mProfiler.newTimer(VideoEvent.PreloadVideo);
        rebufferingTimer = mProfiler.newTimer(VideoEvent.RebufferVideo);
        ErrorCodeResolver.setComponentProfiler(mProfiler);
    }

    public boolean bufferEnded()
    {
        if (isInitialBuffering.compareAndSet(true, false))
        {
            initialBufferingTimer.stop();
            return true;
        } else
        {
            return false;
        }
    }

    public void bufferStarted()
    {
        isInitialBuffering.set(true);
        initialBufferingTimer.start();
    }

    protected void playError(String s)
    {
    }

    public boolean preloadEnded()
    {
        if (isPreloading.compareAndSet(true, false))
        {
            preloadTimer.start();
            return true;
        } else
        {
            return false;
        }
    }

    public void preloadStarted()
    {
        isPreloading.set(true);
        preloadTimer.start();
    }

    public boolean rebufferEnded()
    {
        if (isInitialBuffering.compareAndSet(true, false))
        {
            rebufferingTimer.stop();
            return true;
        } else
        {
            return false;
        }
    }

    public void rebufferStarted()
    {
        rebufferingTimer.start();
        isRebuffering.set(true);
    }

    protected void videoEndPlaying(MediaItem mediaitem, long l)
    {
        long l1 = 0L;
        if (mediaitem != null)
        {
            l1 = ((Video)mediaitem).getDuration();
        }
        if (l1 > 0L && l >= l1)
        {
            mProfiler.trackTimer(VideoEvent.EndVideo, l, CustomerMetricsHelper.getExtraEventTag("full"));
            return;
        } else
        {
            mProfiler.trackTimer(VideoEvent.EndVideo, l, CustomerMetricsHelper.getExtraEventTag(TimeUnit.MILLISECONDS.toSeconds(l)));
            return;
        }
    }

    protected void videoStartPlaying(MediaItem mediaitem)
    {
        long l = ((Video)mediaitem).getDuration();
        mProfiler.trackEvent(VideoEvent.StartVideo, CustomerMetricsHelper.getExtraEventTag(TimeUnit.MILLISECONDS.toSeconds(l)));
    }
}
