// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rhythmnewmedia.sdk.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.rhythmnewmedia.sdk.A;
import com.rhythmnewmedia.sdk.E;
import com.rhythmnewmedia.sdk.RhythmActivity;
import com.rhythmnewmedia.sdk.util.Util;
import com.rhythmnewmedia.sdk.w;
import com.rhythmnewmedia.sdk.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.rhythmnewmedia.sdk.video:
//            RhythmVideoActivity, VideoDataSource, ClipBrowserDataSource, VideoAdEventListener, 
//            VideoEventListener

public class RhythmVideoView extends FrameLayout
{
    static final class a
        implements VideoDataSource
    {

        final List a;

        public final int getNumberOfChannels(RhythmVideoView rhythmvideoview)
        {
            return 1;
        }

        public final int getNumberOfVideosInChannel(RhythmVideoView rhythmvideoview, int i)
        {
            return a.size();
        }

        public final String getVideoTitle(RhythmVideoView rhythmvideoview, int i, int j)
        {
            return ((String[])a.get(j))[1];
        }

        public final String getVideoUrl(RhythmVideoView rhythmvideoview, int i, int j)
        {
            return ((String[])a.get(j))[0];
        }

        a()
        {
            this((byte)0);
        }

        private a(byte byte0)
        {
            a = new ArrayList();
        }
    }


    final E a;
    boolean b;
    boolean c;
    private Activity d;

    public RhythmVideoView(Context context)
    {
        super(context);
        c = false;
        a = new E(context, this);
        a();
    }

    public RhythmVideoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = false;
        a = new E(context, this);
        a();
    }

    public RhythmVideoView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = false;
        a = new E(context, this);
        a();
    }

    private void a()
    {
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        layoutparams.gravity = 17;
        a.setLayoutParams(layoutparams);
        addView(a);
    }

    private void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (b && !c)
        {
            c = true;
            Intent intent = new Intent(getContext(), com/rhythmnewmedia/sdk/video/RhythmVideoActivity);
            intent.putExtra("rnmdActivityType", 3);
            intent.putExtra("ipckey", w.a(new Object[] {
                this
            }));
            intent.setFlags(0x10010000);
            getContext().startActivity(intent);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void c()
    {
        b();
        a.n();
    }

    public static void resetAdHost(Context context)
    {
        ((A)z.a.a(com/rhythmnewmedia/sdk/A, new Object[] {
            context
        })).a(context);
    }

    public void finishFullscreenActivity()
    {
        this;
        JVM INSTR monitorenter ;
        if (d != null)
        {
            d.finish();
            d = null;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public int getCurrentContentPlaybackTime()
    {
        return a.j();
    }

    public boolean isAdPlaying()
    {
        return a.k();
    }

    public boolean isFullscreen()
    {
        return b;
    }

    public void pause()
    {
        a.p();
    }

    public void playAudio(String s)
    {
        a.f = true;
        a.h = true;
        playVideo(s);
    }

    public void playInteractiveVideoAd(String s, String s1)
    {
        a.d = s;
        a.e = s1;
        c();
    }

    public void playVideo(String s)
    {
        playVideos(new String[] {
            s
        });
    }

    public void playVideo(String s, String s1)
    {
        playVideos(Collections.singletonList(s), Collections.singletonList(s1));
    }

    public void playVideoAd()
    {
        c();
    }

    public void playVideoWithoutAd(String s)
    {
        a.f = true;
        playVideo(s);
    }

    public void playVideos(VideoDataSource videodatasource)
    {
        playVideos(videodatasource, ((ClipBrowserDataSource) (null)));
    }

    public void playVideos(VideoDataSource videodatasource, ClipBrowserDataSource clipbrowserdatasource)
    {
        a.c = videodatasource;
        c();
    }

    public void playVideos(List list)
    {
        playVideos(list, ((List) (null)));
    }

    public void playVideos(List list, List list1)
    {
        a a1 = new a();
        int i = 0;
        while (i < list.size()) 
        {
            String s1 = (String)list.get(i);
            String s;
            if (list1 != null && i < list1.size())
            {
                s = (String)list1.get(i);
            } else
            {
                s = null;
            }
            if (!Util.b(s1))
            {
                s1 = s1.trim();
                s = Util.c(s);
                a1.a.add(new String[] {
                    s1, s
                });
            }
            i++;
        }
        playVideos(((VideoDataSource) (a1)));
    }

    public transient void playVideos(String as[])
    {
        playVideos(Arrays.asList(as));
    }

    public void resume()
    {
        a.o();
    }

    public void setAdEventListener(VideoAdEventListener videoadeventlistener)
    {
        a.b = videoadeventlistener;
    }

    public void setCurrentPlaybackTime(int i)
    {
        a.d(i);
    }

    public void setFullscreen(boolean flag)
    {
        b = flag;
    }

    public void setFullscreenActivity(RhythmActivity rhythmactivity)
    {
        d = rhythmactivity;
        rhythmactivity.setActivityListener(a);
    }

    public void setSkipButtonDelay(int i)
    {
        a.c(i);
    }

    public void setVideoEventListener(VideoEventListener videoeventlistener)
    {
        a.a = videoeventlistener;
    }

    public void setVideoTimeout(int i)
    {
        a.b(i);
    }

    public void stop()
    {
        a.q();
    }
}
