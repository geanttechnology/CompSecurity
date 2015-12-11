// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats.multiwebviews.do;

import android.content.Context;
import android.os.Handler;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import io.presage.formats.multiwebviews.do.do.b;
import java.io.IOException;
import shared_presage.com.google.android.exoplayer.DummyTrackRenderer;
import shared_presage.com.google.android.exoplayer.ExoPlaybackException;
import shared_presage.com.google.android.exoplayer.ExoPlayer;
import shared_presage.com.google.android.exoplayer.MediaCodecVideoTrackRenderer;
import shared_presage.com.google.android.exoplayer.TrackRenderer;
import shared_presage.com.google.android.exoplayer.audio.AudioCapabilities;
import shared_presage.com.google.android.exoplayer.audio.AudioCapabilitiesReceiver;
import shared_presage.com.google.android.exoplayer.chunk.Format;
import shared_presage.com.google.android.exoplayer.util.PlayerControl;

public final class io.presage.formats.multiwebviews.do.a
    implements io.presage.formats.multiwebviews.do.do.b, shared_presage.com.google.android.exoplayer.ExoPlayer.Listener, shared_presage.com.google.android.exoplayer.MediaCodecVideoTrackRenderer.EventListener, shared_presage.com.google.android.exoplayer.audio.AudioCapabilitiesReceiver.Listener, shared_presage.com.google.android.exoplayer.hls.HlsSampleSource.EventListener
{
    public static interface a
    {

        public abstract void a(String s);
    }

    public static interface b
    {

        public abstract void b(String s);

        public abstract void c(String s);
    }

    public static interface c
    {

        public abstract void a(int i1, int j1, float f1);
    }


    private ExoPlayer a;
    private PlayerControl b;
    private final Handler c = new Handler();
    private Surface d;
    private String e;
    private AudioCapabilities f;
    private AudioCapabilitiesReceiver g;
    private c h;
    private a i;
    private b j;
    private MediaCodecVideoTrackRenderer k;
    private boolean l;
    private boolean m;
    private int n;

    public io.presage.formats.multiwebviews.do.a(Context context, String s, String s1, String s2, boolean flag, boolean flag1, SurfaceView surfaceview)
    {
        d = surfaceview.getHolder().getSurface();
        l = flag;
        m = flag1;
        e = s;
        a = shared_presage.com.google.android.exoplayer.ExoPlayer.Factory.newInstance(2);
        b = new PlayerControl(a);
        a.addListener(this);
        g = new AudioCapabilitiesReceiver(context.getApplicationContext(), this);
        g.register();
        (new io.presage.formats.multiwebviews.do.do.a(context, s1, s2, f)).a(this, this);
    }

    private void a(String s)
    {
        if (a != null)
        {
            a.release();
            a = null;
        }
        if (i != null)
        {
            i.a(s);
        }
    }

    public final void a()
    {
        if (b != null && !b.isPlaying())
        {
            b.start();
        }
    }

    public final void a(a a1)
    {
        i = a1;
    }

    public final void a(b b1)
    {
        j = b1;
    }

    public final void a(c c1)
    {
        h = c1;
    }

    public final void a(TrackRenderer atrackrenderer[])
    {
        for (int i1 = 0; i1 < 2; i1++)
        {
            if (atrackrenderer[i1] == null)
            {
                atrackrenderer[i1] = new DummyTrackRenderer();
            }
        }

        k = (MediaCodecVideoTrackRenderer)atrackrenderer[0];
        a.sendMessage(k, 1, d);
        a.setPlayWhenReady(l);
        ExoPlayer exoplayer = a;
        boolean flag;
        if (!m)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        exoplayer.setRendererEnabled(1, flag);
        a.prepare(atrackrenderer);
    }

    public final void b()
    {
        if (b != null && b.isPlaying() && b.canPause())
        {
            b.pause();
        }
    }

    public final void c()
    {
        boolean flag;
        if (b != null && b.isPlaying())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b();
            return;
        } else
        {
            a();
            return;
        }
    }

    public final void d()
    {
        boolean flag1 = false;
        ExoPlayer exoplayer;
        boolean flag;
        if (!a.getRendererEnabled(1))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        exoplayer = a;
        if (!flag)
        {
            flag1 = true;
        }
        exoplayer.setRendererEnabled(1, flag1);
    }

    public final void e()
    {
        if (b != null && b.isPlaying() && b.canPause())
        {
            b.pause();
            b.seekTo(0);
        }
    }

    public final Handler f()
    {
        return c;
    }

    public final String g()
    {
        if (a != null)
        {
            n = Math.round(((float)a.getCurrentPosition() / (float)a.getDuration()) * 100F);
        }
        return String.valueOf(n);
    }

    public final void h()
    {
        a("Error on renderer");
    }

    public final void onAudioCapabilitiesChanged(AudioCapabilities audiocapabilities)
    {
        f = audiocapabilities;
    }

    public final void onCryptoError(android.media.MediaCodec.CryptoException cryptoexception)
    {
        a("Error on crypto");
    }

    public final void onDecoderInitializationError(shared_presage.com.google.android.exoplayer.MediaCodecTrackRenderer.DecoderInitializationException decoderinitializationexception)
    {
        a("Error on decoder initialisation");
    }

    public final void onDecoderInitialized(String s, long l1, long l2)
    {
    }

    public final void onDownstreamFormatChanged(int i1, Format format, int j1, int k1)
    {
    }

    public final void onDrawnToSurface(Surface surface)
    {
    }

    public final void onDroppedFrames(int i1, long l1)
    {
    }

    public final void onLoadCanceled(int i1, long l1)
    {
    }

    public final void onLoadCompleted(int i1, long l1, int j1, int k1, Format format, int i2, 
            int j2, long l2, long l3)
    {
    }

    public final void onLoadError(int i1, IOException ioexception)
    {
        a("Error loading video");
    }

    public final void onLoadStarted(int i1, long l1, int j1, int k1, Format format, int i2, 
            int j2)
    {
    }

    public final void onPlayWhenReadyCommitted()
    {
    }

    public final void onPlayerError(ExoPlaybackException exoplaybackexception)
    {
        a("Playback Error");
    }

    public final void onPlayerStateChanged(boolean flag, int i1)
    {
        switch (i1)
        {
        default:
            return;

        case 4: // '\004'
            j.b(e);
            return;

        case 5: // '\005'
            j.c(e);
            break;
        }
    }

    public final void onUpstreamDiscarded(int i1, int j1, int k1)
    {
    }

    public final void onVideoSizeChanged(int i1, int j1, float f1)
    {
        if (h != null)
        {
            h.a(i1, j1, f1);
        }
    }
}
