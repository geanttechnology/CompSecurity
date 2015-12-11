// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import com.shazam.android.analytics.event.EventAnalytics;
import com.shazam.android.analytics.event.factory.ErrorEventFactory;
import com.shazam.android.analytics.event.factory.VideoPlayedEventFactory;
import com.shazam.android.base.activities.AutoToolbarBaseAppCompatActivity;
import com.shazam.android.util.s;
import com.shazam.android.view.media.MediaPlayerView;
import com.shazam.android.view.media.a;
import com.shazam.i.b.au.d;

public class VideoPlayerActivity extends AutoToolbarBaseAppCompatActivity
    implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnSeekCompleteListener, a
{

    private final EventAnalytics b;
    private final s c;
    private int d;
    private double e;
    private long f;
    private String g;
    private Uri h;
    private MediaPlayerView i;
    private String j;
    private String k;

    public VideoPlayerActivity()
    {
        this(com.shazam.i.b.g.b.a.a(), com.shazam.i.b.au.d.a());
    }

    public VideoPlayerActivity(EventAnalytics eventanalytics, s s1)
    {
        b = eventanalytics;
        c = s1;
    }

    public static Intent a(Context context, Uri uri, String s1, String s2, String s3)
    {
        context = new Intent(context, com/shazam/android/activities/VideoPlayerActivity);
        context.addFlags(0x10000000);
        context.setData(uri);
        context.putExtra("VideoPlayerActivity:startOffset", 0);
        context.putExtra("VideoPlayerActivity:tagTime", 0L);
        context.putExtra("VideoPlayerActivity:trackid", s1);
        context.putExtra("VideoPlayerActivity:beaconKey", s2);
        context.putExtra("VideoPlayerActivity:campaign", s3);
        context.putExtra("VideoPlayerActivity:timeSkew", 0.0D);
        return context;
    }

    private void a(int l, boolean flag)
    {
        com.shazam.android.analytics.event.Event event = VideoPlayedEventFactory.createVideoPlayedEvent(g, j, k, d, l, flag);
        b.logEvent(event);
    }

    static void a(VideoPlayerActivity videoplayeractivity)
    {
        videoplayeractivity.d();
    }

    static MediaPlayerView b(VideoPlayerActivity videoplayeractivity)
    {
        return videoplayeractivity.i;
    }

    private int c()
    {
        long l = d;
        if (f > 0L)
        {
            l = (System.currentTimeMillis() - f) + (long)d;
        }
        double d1 = e;
        return (int)((double)l * (1.0D + d1));
    }

    private void d()
    {
        (new StringBuilder("Media player is off by ")).append(i.getCurrentPosition() - c());
    }

    public final void a()
    {
        b.logEvent(VideoPlayedEventFactory.createInteractionEvent(com.shazam.android.analytics.event.factory.VideoPlayedEventFactory.VideoPlayedEventAction.PLAY, g, j, k));
    }

    public final void b()
    {
        b.logEvent(VideoPlayedEventFactory.createInteractionEvent(com.shazam.android.analytics.event.factory.VideoPlayedEventFactory.VideoPlayedEventAction.PAUSE, g, j, k));
    }

    public void onBackPressed()
    {
        super.onBackPressed();
        a(i.getCurrentPosition(), false);
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        a(mediaplayer.getCurrentPosition(), true);
        finish();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030022);
        i = (MediaPlayerView)findViewById(0x7f1100d5);
        i.setMediaController(new MediaController(this));
        i.requestFocus();
        i.setOnCompletionListener(this);
        i.setOnErrorListener(this);
        i.setPlayPauseListener(this);
        bundle = getIntent();
        h = bundle.getData();
        g = bundle.getStringExtra("VideoPlayerActivity:trackid");
        j = bundle.getStringExtra("VideoPlayerActivity:beaconKey");
        k = bundle.getStringExtra("VideoPlayerActivity:campaign");
        d = bundle.getIntExtra("VideoPlayerActivity:startOffset", 0);
        e = bundle.getDoubleExtra("VideoPlayerActivity:timeSkew", 0.0D);
        f = bundle.getLongExtra("VideoPlayerActivity:tagTime", 0x8000000000000000L);
        int l;
        if (d != 0)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (l != 0)
        {
            i.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

                final VideoPlayerActivity a;

                public final void onPrepared(MediaPlayer mediaplayer)
                {
                    mediaplayer.setOnSeekCompleteListener(a);
                }

            
            {
                a = VideoPlayerActivity.this;
                super();
            }
            });
        }
        if (l != 0)
        {
            l = c() + 5000;
        } else
        {
            l = 0;
        }
        i.setVideoPath(h.getPath());
        i.seekTo(l);
        i.start();
    }

    public boolean onError(MediaPlayer mediaplayer, int l, int i1)
    {
        mediaplayer = ErrorEventFactory.videoSyncLoadFailureErrorEvent(g, j, k, h.toString());
        b.logEvent(mediaplayer);
        mediaplayer = c;
        com.shazam.android.util.q.a a1 = new com.shazam.android.util.q.a();
        a1.a = 0x7f0900ba;
        a1.c = 0;
        mediaplayer.a(a1.a());
        finish();
        return false;
    }

    public void onSeekComplete(MediaPlayer mediaplayer)
    {
        mediaplayer.setOnSeekCompleteListener(null);
        int l = mediaplayer.getCurrentPosition();
        d();
        l -= c();
        if (l < 0)
        {
            i.seekTo(l + i.getCurrentPosition());
            return;
        } else
        {
            mediaplayer.pause();
            i.postDelayed(new Runnable() {

                final VideoPlayerActivity a;

                public final void run()
                {
                    com.shazam.android.activities.VideoPlayerActivity.a(a);
                    VideoPlayerActivity.b(a).start();
                }

            
            {
                a = VideoPlayerActivity.this;
                super();
            }
            }, l);
            return;
        }
    }
}
