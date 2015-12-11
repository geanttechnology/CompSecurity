// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.google.android.gms.ads.internal.c;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.b.bz;
import com.google.android.gms.b.dc;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            g

public class i extends SurfaceView
    implements android.media.AudioManager.OnAudioFocusChangeListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.view.SurfaceHolder.Callback
{

    private static final Map a;
    private int b;
    private int c;
    private SurfaceHolder d;
    private MediaPlayer e;
    private Uri f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private float l;
    private boolean m;
    private boolean n;
    private int o;
    private g p;

    public i(Context context)
    {
        super(context);
        b = 0;
        c = 0;
        l = 1.0F;
        getHolder().addCallback(this);
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            getHolder().setType(3);
        }
    }

    static g a(i i1)
    {
        return i1.p;
    }

    private void a(boolean flag)
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView release");
        if (e != null)
        {
            e.reset();
            e.release();
            e = null;
            b = 0;
            if (flag)
            {
                c = 0;
            }
            i();
        }
    }

    private void b(float f1)
    {
        if (e != null)
        {
            try
            {
                e.setVolume(f1, f1);
                return;
            }
            catch (IllegalStateException illegalstateexception)
            {
                return;
            }
        } else
        {
            com.google.android.gms.ads.internal.util.client.b.e("AdVideoView setMediaPlayerVolume() called before onPrepared().");
            return;
        }
    }

    private void f()
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView init MediaPlayer");
        if (f == null || d == null)
        {
            return;
        }
        a(false);
        e = new MediaPlayer();
        e.setOnBufferingUpdateListener(this);
        e.setOnCompletionListener(this);
        e.setOnErrorListener(this);
        e.setOnInfoListener(this);
        e.setOnPreparedListener(this);
        e.setOnVideoSizeChangedListener(this);
        k = 0;
        e.setDataSource(getContext(), f);
        e.setDisplay(d);
        e.setAudioStreamType(3);
        e.setScreenOnWhilePlaying(true);
        e.prepareAsync();
        b = 1;
        return;
        Object obj;
        obj;
_L2:
        com.google.android.gms.ads.internal.util.client.b.c((new StringBuilder()).append("Failed to initialize MediaPlayer at ").append(f).toString(), ((Throwable) (obj)));
        onError(e, 1, 0);
        return;
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void g()
    {
        if (j() && c != 3)
        {
            com.google.android.gms.ads.internal.util.client.b.d("AdVideoView nudging MediaPlayer");
            e.start();
            int i1 = e.getCurrentPosition();
            for (long l1 = com.google.android.gms.ads.internal.c.g().a(); j() && e.getCurrentPosition() == i1 && com.google.android.gms.ads.internal.c.g().a() - l1 <= 250L;) { }
            e.pause();
        }
    }

    private void h()
    {
label0:
        {
            AudioManager audiomanager = n();
            if (audiomanager != null && !n)
            {
                if (audiomanager.requestAudioFocus(this, 3, 2) != 1)
                {
                    break label0;
                }
                k();
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.b.e("AdVideoView audio focus request failed");
    }

    private void i()
    {
label0:
        {
            com.google.android.gms.ads.internal.util.client.b.d("AdVideoView abandon audio focus");
            AudioManager audiomanager = n();
            if (audiomanager != null && n)
            {
                if (audiomanager.abandonAudioFocus(this) != 1)
                {
                    break label0;
                }
                n = false;
            }
            return;
        }
        com.google.android.gms.ads.internal.util.client.b.e("AdVideoView abandon audio focus failed");
    }

    private boolean j()
    {
        return e != null && b != -1 && b != 0 && b != 1;
    }

    private void k()
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView audio focus gained");
        n = true;
        m();
    }

    private void l()
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView audio focus lost");
        n = false;
        m();
    }

    private void m()
    {
        if (!m && n)
        {
            b(l);
            return;
        } else
        {
            b(0.0F);
            return;
        }
    }

    private AudioManager n()
    {
        return (AudioManager)getContext().getSystemService("audio");
    }

    public void a()
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView stop");
        if (e != null)
        {
            e.stop();
            e.release();
            e = null;
            b = 0;
            c = 0;
            i();
        }
    }

    public void a(float f1)
    {
        l = f1;
        m();
    }

    public void a(int i1)
    {
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("AdVideoView seek ").append(i1).toString());
        if (j())
        {
            e.seekTo(i1);
            o = 0;
            return;
        } else
        {
            o = i1;
            return;
        }
    }

    public void a(g g1)
    {
        p = g1;
    }

    public void b()
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView play");
        if (j())
        {
            e.start();
            b = 3;
            bz.a.post(new _cls6());
        }
        c = 3;
    }

    public void c()
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView pause");
        if (j() && e.isPlaying())
        {
            e.pause();
            b = 4;
            bz.a.post(new _cls7());
        }
        c = 4;
    }

    public void d()
    {
        m = true;
        m();
    }

    public void e()
    {
        m = false;
        m();
    }

    public int getCurrentPosition()
    {
        if (j())
        {
            return e.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public void onAudioFocusChange(int i1)
    {
        if (i1 > 0)
        {
            k();
        } else
        if (i1 < 0)
        {
            l();
            return;
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i1)
    {
        k = i1;
    }

    public void onCompletion(MediaPlayer mediaplayer)
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView completion");
        b = 5;
        c = 5;
        bz.a.post(new _cls2());
    }

    public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        mediaplayer = (String)a.get(Integer.valueOf(i1));
        String s = (String)a.get(Integer.valueOf(j1));
        com.google.android.gms.ads.internal.util.client.b.e((new StringBuilder()).append("AdVideoView MediaPlayer error: ").append(mediaplayer).append(":").append(s).toString());
        b = -1;
        c = -1;
        bz.a.post(new _cls3(mediaplayer, s));
        return true;
    }

    public boolean onInfo(MediaPlayer mediaplayer, int i1, int j1)
    {
        mediaplayer = (String)a.get(Integer.valueOf(i1));
        String s = (String)a.get(Integer.valueOf(j1));
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("AdVideoView MediaPlayer info: ").append(mediaplayer).append(":").append(s).toString());
        return true;
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        int i2;
        int k2;
        i2 = getDefaultSize(g, i1);
        k2 = getDefaultSize(h, j1);
        l1 = k2;
        k1 = i2;
        if (g <= 0) goto _L2; else goto _L1
_L1:
        l1 = k2;
        k1 = i2;
        if (h <= 0) goto _L2; else goto _L3
_L3:
        int l2;
        k2 = android.view.View.MeasureSpec.getMode(i1);
        i1 = android.view.View.MeasureSpec.getSize(i1);
        l2 = android.view.View.MeasureSpec.getMode(j1);
        j1 = android.view.View.MeasureSpec.getSize(j1);
        if (k2 != 0x40000000 || l2 != 0x40000000) goto _L5; else goto _L4
_L4:
        if (g * j1 < h * i1)
        {
            k1 = (g * j1) / h;
            l1 = j1;
        } else
        if (g * j1 > h * i1)
        {
            l1 = (h * i1) / g;
            k1 = i1;
        } else
        {
            l1 = j1;
            k1 = i1;
        }
_L2:
        setMeasuredDimension(k1, l1);
        return;
_L5:
        if (k2 == 0x40000000)
        {
            l1 = (h * i1) / g;
            int j2;
            if (l2 == 0x80000000 && l1 > j1)
            {
                l1 = j1;
                k1 = i1;
            } else
            {
                k1 = i1;
            }
        } else
        if (l2 == 0x40000000)
        {
            j2 = (g * j1) / h;
            l1 = j1;
            k1 = j2;
            if (k2 == 0x80000000)
            {
                l1 = j1;
                k1 = j2;
                if (j2 > i1)
                {
                    l1 = j1;
                    k1 = i1;
                }
            }
        } else
        {
            j2 = g;
            k1 = h;
            if (l2 == 0x80000000 && k1 > j1)
            {
                j2 = (g * j1) / h;
            } else
            {
                j1 = k1;
            }
            l1 = j1;
            k1 = j2;
            if (k2 == 0x80000000)
            {
                l1 = j1;
                k1 = j2;
                if (j2 > i1)
                {
                    l1 = (h * i1) / g;
                    k1 = i1;
                }
            }
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView prepared");
        b = 2;
        bz.a.post(new _cls1(mediaplayer));
        g = mediaplayer.getVideoWidth();
        h = mediaplayer.getVideoHeight();
        if (o != 0)
        {
            a(o);
        }
        g();
        if (g == 0 || h == 0) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.b.c((new StringBuilder()).append("AdVideoView stream dimensions: ").append(g).append(" x ").append(h).toString());
        getHolder().setFixedSize(g, h);
        if (i == g && j == h && c == 3)
        {
            b();
        }
_L4:
        h();
        m();
        return;
_L2:
        if (c == 3)
        {
            b();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onVideoSizeChanged(MediaPlayer mediaplayer, int i1, int j1)
    {
        com.google.android.gms.ads.internal.util.client.b.d((new StringBuilder()).append("AdVideoView size changed: ").append(i1).append(" x ").append(j1).toString());
        g = mediaplayer.getVideoWidth();
        h = mediaplayer.getVideoHeight();
        if (g != 0 && h != 0)
        {
            getHolder().setFixedSize(g, h);
            requestLayout();
        }
    }

    public void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public void setVideoURI(Uri uri)
    {
        f = uri;
        o = 0;
        f();
        requestLayout();
        invalidate();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        boolean flag = true;
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView surface changed");
        i = j1;
        j = k1;
        if (c == 3)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (g == j1 && h == k1)
        {
            j1 = ((flag) ? 1 : 0);
        } else
        {
            j1 = 0;
        }
        if (e != null && i1 != 0 && j1 != 0)
        {
            if (o != 0)
            {
                a(o);
            }
            b();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView surface created");
        d = surfaceholder;
        f();
        bz.a.post(new _cls4());
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        com.google.android.gms.ads.internal.util.client.b.d("AdVideoView surface destroyed");
        if (e != null && o == 0)
        {
            o = e.getCurrentPosition();
        }
        d = null;
        bz.a.post(new _cls5());
        a(true);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }

    static 
    {
        a = new HashMap();
        a.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
        a.put(Integer.valueOf(-1007), "MEDIA_ERROR_MALFORMED");
        a.put(Integer.valueOf(-1010), "MEDIA_ERROR_UNSUPPORTED");
        a.put(Integer.valueOf(-110), "MEDIA_ERROR_TIMED_OUT");
        a.put(Integer.valueOf(100), "MEDIA_ERROR_SERVER_DIED");
        a.put(Integer.valueOf(1), "MEDIA_ERROR_UNKNOWN");
        a.put(Integer.valueOf(1), "MEDIA_INFO_UNKNOWN");
        a.put(Integer.valueOf(700), "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        a.put(Integer.valueOf(3), "MEDIA_INFO_VIDEO_RENDERING_START");
        a.put(Integer.valueOf(701), "MEDIA_INFO_BUFFERING_START");
        a.put(Integer.valueOf(702), "MEDIA_INFO_BUFFERING_END");
        a.put(Integer.valueOf(800), "MEDIA_INFO_BAD_INTERLEAVING");
        a.put(Integer.valueOf(801), "MEDIA_INFO_NOT_SEEKABLE");
        a.put(Integer.valueOf(802), "MEDIA_INFO_METADATA_UPDATE");
        a.put(Integer.valueOf(901), "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
        a.put(Integer.valueOf(902), "MEDIA_INFO_SUBTITLE_TIMED_OUT");
    }

    /* member class not found */
    class _cls6 {}


    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls5 {}

}
