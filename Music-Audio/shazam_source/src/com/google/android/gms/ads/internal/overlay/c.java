// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import android.view.TextureView;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.ax;
import com.google.android.gms.d.ay;
import com.google.android.gms.d.be;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.gp;
import com.google.android.gms.d.ii;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.ads.internal.overlay:
//            i, p, h

public final class c extends i
    implements android.media.AudioManager.OnAudioFocusChangeListener, android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnVideoSizeChangedListener, android.view.TextureView.SurfaceTextureListener
{

    private static final Map a;
    private final com.google.android.gms.ads.internal.overlay.p b;
    private int c;
    private int d;
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
    private h p;

    public c(Context context, com.google.android.gms.ads.internal.overlay.p p1)
    {
        super(context);
        c = 0;
        d = 0;
        l = 1.0F;
        setSurfaceTextureListener(this);
        b = p1;
        context = b;
        ((com.google.android.gms.ads.internal.overlay.p) (context)).d.a(((com.google.android.gms.ads.internal.overlay.p) (context)).c, new String[] {
            "vpc"
        });
        context.i = ((com.google.android.gms.ads.internal.overlay.p) (context)).d.a();
        context.n = this;
    }

    static h a(c c1)
    {
        return c1.p;
    }

    private void a(boolean flag)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        if (e != null)
        {
            e.reset();
            e.release();
            e = null;
            b(0);
            if (flag)
            {
                d = 0;
                d = 0;
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
            com.google.android.gms.ads.internal.util.client.b.a(5);
            return;
        }
    }

    private void b(int i1)
    {
        if (i1 != 3) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.overlay.p p1 = b;
        p1.m = true;
        if (p1.j != null && p1.k == null)
        {
            p1.d.a(p1.j, new String[] {
                "vfp"
            });
            p1.k = p1.d.a();
        }
_L4:
        c = i1;
        return;
_L2:
        if (c == 3 && i1 != 3)
        {
            b.m = false;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void g()
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        SurfaceTexture surfacetexture = getSurfaceTexture();
        if (f == null || surfacetexture == null)
        {
            return;
        }
        a(false);
        try
        {
            e = new MediaPlayer();
            e.setOnBufferingUpdateListener(this);
            e.setOnCompletionListener(this);
            e.setOnErrorListener(this);
            e.setOnInfoListener(this);
            e.setOnPreparedListener(this);
            e.setOnVideoSizeChangedListener(this);
            i = 0;
            e.setDataSource(getContext(), f);
            e.setSurface(new Surface(surfacetexture));
            e.setAudioStreamType(3);
            e.setScreenOnWhilePlaying(true);
            e.prepareAsync();
            b(1);
            return;
        }
        catch (IOException ioexception) { }
        catch (IllegalArgumentException illegalargumentexception) { }
        (new StringBuilder("Failed to initialize MediaPlayer at ")).append(f);
        com.google.android.gms.ads.internal.util.client.b.a(5);
        onError(e, 1, 0);
    }

    private void h()
    {
        if (j() && e.getCurrentPosition() > 0 && d != 3)
        {
            com.google.android.gms.ads.internal.util.client.b.a(2);
            b(0.0F);
            e.start();
            int i1 = e.getCurrentPosition();
            for (long l1 = com.google.android.gms.ads.internal.p.i().a(); j() && e.getCurrentPosition() == i1 && com.google.android.gms.ads.internal.p.i().a() - l1 <= 250L;) { }
            e.pause();
            l();
        }
    }

    private void i()
    {
label0:
        {
            com.google.android.gms.ads.internal.util.client.b.a(2);
            AudioManager audiomanager = m();
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
        com.google.android.gms.ads.internal.util.client.b.a(5);
    }

    private boolean j()
    {
        return e != null && c != -1 && c != 0 && c != 1;
    }

    private void k()
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        n = true;
        l();
    }

    private void l()
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

    private AudioManager m()
    {
        return (AudioManager)getContext().getSystemService("audio");
    }

    public final String a()
    {
        return "MediaPlayer";
    }

    public final void a(float f1)
    {
        l = f1;
        l();
    }

    public final void a(int i1)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
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

    public final void a(h h1)
    {
        p = h1;
    }

    public final void b()
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        if (e != null)
        {
            e.stop();
            e.release();
            e = null;
            b(0);
            d = 0;
            i();
        }
        com.google.android.gms.ads.internal.overlay.p p1 = b;
        com.google.android.gms.d.au au = ay.u;
        if (((Boolean)com.google.android.gms.ads.internal.p.n().a(au)).booleanValue() && !p1.o)
        {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", p1.b);
            bundle.putString("player", p1.n.a());
            com.google.android.gms.d.gp.a a1;
            for (Iterator iterator = p1.f.a().iterator(); iterator.hasNext(); bundle.putString((new StringBuilder("fps_p_")).append(a1.a).toString(), Double.toString(a1.d)))
            {
                a1 = (com.google.android.gms.d.gp.a)iterator.next();
                bundle.putString((new StringBuilder("fps_c_")).append(a1.a).toString(), Integer.toString(a1.e));
            }

            for (int i1 = 0; i1 < p1.g.length; i1++)
            {
                String s = p1.h[i1];
                if (s != null)
                {
                    bundle.putString((new StringBuilder("fh_")).append(Long.valueOf(p1.g[i1])).toString(), s);
                }
            }

            com.google.android.gms.ads.internal.p.e();
            gm.a(p1.a, p1.e.b, "gmob-apps", bundle, true);
            p1.o = true;
        }
    }

    public final void c()
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        if (j())
        {
            e.start();
            b(3);
            gm.a.post(new Runnable() {

                final c a;

                public final void run()
                {
                    if (c.a(a) != null)
                    {
                        c.a(a).b();
                    }
                }

            
            {
                a = c.this;
                super();
            }
            });
        }
        d = 3;
    }

    public final void d()
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        if (j() && e.isPlaying())
        {
            e.pause();
            b(4);
            gm.a.post(new Runnable() {

                final c a;

                public final void run()
                {
                    if (c.a(a) != null)
                    {
                        c.a(a).c();
                    }
                }

            
            {
                a = c.this;
                super();
            }
            });
        }
        d = 4;
    }

    public final void e()
    {
        m = true;
        l();
    }

    public final void f()
    {
        m = false;
        l();
    }

    public final int getCurrentPosition()
    {
        if (j())
        {
            return e.getCurrentPosition();
        } else
        {
            return 0;
        }
    }

    public final int getDuration()
    {
        if (j())
        {
            return e.getDuration();
        } else
        {
            return -1;
        }
    }

    public final int getVideoHeight()
    {
        if (e != null)
        {
            return e.getVideoHeight();
        } else
        {
            return 0;
        }
    }

    public final int getVideoWidth()
    {
        if (e != null)
        {
            return e.getVideoWidth();
        } else
        {
            return 0;
        }
    }

    public final void onAudioFocusChange(int i1)
    {
        if (i1 > 0)
        {
            k();
        } else
        if (i1 < 0)
        {
            com.google.android.gms.ads.internal.util.client.b.a(2);
            n = false;
            l();
            return;
        }
    }

    public final void onBufferingUpdate(MediaPlayer mediaplayer, int i1)
    {
        i = i1;
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        b(5);
        d = 5;
        gm.a.post(new Runnable() {

            final c a;

            public final void run()
            {
                if (c.a(a) != null)
                {
                    c.a(a).d();
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
    }

    public final boolean onError(MediaPlayer mediaplayer, int i1, int j1)
    {
        mediaplayer = (String)a.get(Integer.valueOf(i1));
        String s = (String)a.get(Integer.valueOf(j1));
        (new StringBuilder("AdVideoView MediaPlayer error: ")).append(mediaplayer).append(":").append(s);
        com.google.android.gms.ads.internal.util.client.b.a(5);
        b(-1);
        d = -1;
        gm.a.post(new Runnable(mediaplayer, s) {

            final String a;
            final String b;
            final c c;

            public final void run()
            {
                if (c.a(c) != null)
                {
                    c.a(c).a(a, b);
                }
            }

            
            {
                c = c.this;
                a = s;
                b = s1;
                super();
            }
        });
        return true;
    }

    public final boolean onInfo(MediaPlayer mediaplayer, int i1, int j1)
    {
        mediaplayer = (String)a.get(Integer.valueOf(i1));
        String s = (String)a.get(Integer.valueOf(j1));
        (new StringBuilder("AdVideoView MediaPlayer info: ")).append(mediaplayer).append(":").append(s);
        com.google.android.gms.ads.internal.util.client.b.a(2);
        return true;
    }

    protected final void onMeasure(int i1, int j1)
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
        if (android.os.Build.VERSION.SDK_INT == 16)
        {
            if (j > 0 && j != k1 || k > 0 && k != l1)
            {
                h();
            }
            j = k1;
            k = l1;
        }
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

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        b(2);
        com.google.android.gms.ads.internal.overlay.p p1 = b;
        if (p1.i != null && p1.j == null)
        {
            p1.d.a(p1.i, new String[] {
                "vfr"
            });
            p1.j = p1.d.a();
        }
        gm.a.post(new Runnable() {

            final c a;

            public final void run()
            {
                if (c.a(a) != null)
                {
                    c.a(a).a();
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
        g = mediaplayer.getVideoWidth();
        h = mediaplayer.getVideoHeight();
        if (o != 0)
        {
            a(o);
        }
        h();
        (new StringBuilder("AdVideoView stream dimensions: ")).append(g).append(" x ").append(h);
        com.google.android.gms.ads.internal.util.client.b.a(4);
        if (d == 3)
        {
            c();
        }
        mediaplayer = m();
        if (mediaplayer != null && !n)
        {
            if (mediaplayer.requestAudioFocus(this, 3, 2) == 1)
            {
                k();
            } else
            {
                com.google.android.gms.ads.internal.util.client.b.a(5);
            }
        }
        l();
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        g();
        gm.a.post(new Runnable() {

            final c a;

            public final void run()
            {
                if (c.a(a) != null)
                {
                    c.a(a);
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        com.google.android.gms.ads.internal.util.client.b.a(2);
        if (e != null && o == 0)
        {
            o = e.getCurrentPosition();
        }
        gm.a.post(new Runnable() {

            final c a;

            public final void run()
            {
                if (c.a(a) != null)
                {
                    c.a(a).c();
                    c.a(a).e();
                }
            }

            
            {
                a = c.this;
                super();
            }
        });
        a(true);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
    {
        boolean flag1 = true;
        com.google.android.gms.ads.internal.util.client.b.a(2);
        boolean flag;
        if (d == 3)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (g == i1 && h == j1)
        {
            i1 = ((flag1) ? 1 : 0);
        } else
        {
            i1 = 0;
        }
        if (e != null && flag && i1 != 0)
        {
            if (o != 0)
            {
                a(o);
            }
            c();
        }
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
        surfacetexture = b;
        if (((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).k != null && ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).l == null)
        {
            ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).d.a(((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).k, new String[] {
                "vff"
            });
            ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).d.a(((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).c, new String[] {
                "vtt"
            });
            surfacetexture.l = ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).d.a();
        }
        long l2 = com.google.android.gms.ads.internal.p.i().c();
        if (((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).m && ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).p && ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).q != -1L)
        {
            double d1 = (double)TimeUnit.SECONDS.toNanos(1L) / (double)(l2 - ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).q);
            gp gp1 = ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).f;
            gp1.d = gp1.d + 1;
            int i1 = 0;
            do
            {
                if (i1 >= gp1.b.length)
                {
                    break;
                }
                if (gp1.b[i1] <= d1 && d1 < gp1.a[i1])
                {
                    int ai[] = gp1.c;
                    ai[i1] = ai[i1] + 1;
                }
                if (d1 < gp1.b[i1])
                {
                    break;
                }
                i1++;
            } while (true);
        }
        surfacetexture.p = ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).m;
        surfacetexture.q = l2;
        com.google.android.gms.d.au au = ay.w;
        l2 = ((Long)com.google.android.gms.ads.internal.p.n().a(au)).longValue();
        long l3 = getCurrentPosition();
        int j1 = 0;
        do
        {
label0:
            {
                if (j1 < ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).h.length)
                {
                    if (((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).h[j1] != null || l2 <= Math.abs(l3 - ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).g[j1]))
                    {
                        break label0;
                    }
                    surfacetexture = ((com.google.android.gms.ads.internal.overlay.p) (surfacetexture)).h;
                    Bitmap bitmap = getBitmap(8, 8);
                    l3 = 0L;
                    l2 = 63L;
                    for (int k1 = 0; k1 < 8;)
                    {
                        int l1 = 0;
                        long l4 = l2;
                        l2 = l3;
                        l3 = l4;
                        while (l1 < 8) 
                        {
                            int i2 = bitmap.getPixel(l1, k1);
                            int j2 = Color.blue(i2);
                            int k2 = Color.red(i2);
                            if (Color.green(i2) + (j2 + k2) > 128)
                            {
                                l4 = 1L;
                            } else
                            {
                                l4 = 0L;
                            }
                            l2 |= l4 << (int)l3;
                            l3--;
                            l1++;
                        }
                        k1++;
                        l4 = l2;
                        l2 = l3;
                        l3 = l4;
                    }

                    surfacetexture[j1] = String.format("%016X", new Object[] {
                        Long.valueOf(l3)
                    });
                }
                return;
            }
            j1++;
        } while (true);
    }

    public final void onVideoSizeChanged(MediaPlayer mediaplayer, int i1, int j1)
    {
        (new StringBuilder("AdVideoView size changed: ")).append(i1).append(" x ").append(j1);
        com.google.android.gms.ads.internal.util.client.b.a(2);
        g = mediaplayer.getVideoWidth();
        h = mediaplayer.getVideoHeight();
        if (g != 0 && h != 0)
        {
            requestLayout();
        }
    }

    public final void setMimeType(String s)
    {
    }

    public final void setVideoPath(String s)
    {
        setVideoURI(Uri.parse(s));
    }

    public final void setVideoURI(Uri uri)
    {
        f = uri;
        o = 0;
        g();
        requestLayout();
        invalidate();
    }

    public final String toString()
    {
        return (new StringBuilder()).append(getClass().getName()).append("@").append(Integer.toHexString(hashCode())).toString();
    }

    static 
    {
        HashMap hashmap = new HashMap();
        a = hashmap;
        hashmap.put(Integer.valueOf(-1004), "MEDIA_ERROR_IO");
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
}
