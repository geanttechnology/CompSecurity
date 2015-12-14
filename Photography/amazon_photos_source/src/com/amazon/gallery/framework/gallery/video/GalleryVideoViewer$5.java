// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.os.SystemClock;
import android.widget.ProgressBar;
import android.widget.VideoView;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.amazon.ScreenModeManager;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer, GalleryVideoView, LockscreenPlaybackManager, VideoMetrics, 
//            GalleryMediaController

class this._cls0
    implements backListener
{

    private long playTime;
    private boolean playing;
    private long resumeTimestamp;
    final GalleryVideoViewer this$0;

    public void pause()
    {
        setPlayButtonVisibility(0);
        if (playing)
        {
            playTime = playTime + (SystemClock.uptimeMillis() - resumeTimestamp);
            playing = false;
        }
        if (GalleryVideoViewer.access$000(GalleryVideoViewer.this).getCurrentPosition() > 0)
        {
            GalleryVideoViewer.access$202(GalleryVideoViewer.this, GalleryVideoViewer.access$000(GalleryVideoViewer.this).getCurrentPosition());
        }
        GLogger.i(GalleryVideoViewer.access$800(), "Video pause", new Object[0]);
    }

    public void resume()
    {
        resumeTimestamp = SystemClock.uptimeMillis();
        playing = true;
        GLogger.i(GalleryVideoViewer.access$800(), "Video resume", new Object[0]);
    }

    public void start()
    {
        GalleryVideoViewer.access$100(GalleryVideoViewer.this).start();
        VideoView videoview = getVideoView();
        if (videoview.getDuration() == -1)
        {
            videoview.seekTo(GalleryVideoViewer.access$200(GalleryVideoViewer.this));
        } else
        if (videoview.getCurrentPosition() >= videoview.getDuration())
        {
            videoview.seekTo(0);
        }
        if (GalleryVideoViewer.access$300(GalleryVideoViewer.this) != null)
        {
            GalleryVideoViewer.access$400(GalleryVideoViewer.this);
        }
        if (!videoview.isPlaying() && mediaItem != null)
        {
            GalleryVideoViewer.access$500(GalleryVideoViewer.this).videoStartPlaying(mediaItem);
        }
        if (videoview.isPlaying())
        {
            GalleryVideoViewer.access$600(GalleryVideoViewer.this).setVisibility(8);
        } else
        {
            GalleryVideoViewer.access$600(GalleryVideoViewer.this).setVisibility(0);
        }
        resumeTimestamp = SystemClock.uptimeMillis();
        playing = true;
        setPlayButtonVisibility(8);
        if (!GalleryVideoViewer.access$700(GalleryVideoViewer.this).isFullScreen())
        {
            getController().show(0, false, true);
        }
        GLogger.i(GalleryVideoViewer.access$800(), "Video start", new Object[0]);
    }

    public void stopPlayback()
    {
        if (playing)
        {
            playTime = playTime + (SystemClock.uptimeMillis() - resumeTimestamp);
            playing = false;
        }
        GalleryVideoViewer.access$500(GalleryVideoViewer.this).videoEndPlaying(mediaItem, playTime);
        GalleryVideoViewer.access$100(GalleryVideoViewer.this).shutdown();
        GLogger.i(GalleryVideoViewer.access$800(), "Video stop playback", new Object[0]);
    }

    public void suspend()
    {
        if (playing)
        {
            playTime = playTime + (SystemClock.uptimeMillis() - resumeTimestamp);
            playing = false;
        }
        GLogger.i(GalleryVideoViewer.access$800(), "Video suspend", new Object[0]);
    }

    r()
    {
        this$0 = GalleryVideoViewer.this;
        super();
    }
}
