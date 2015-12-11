// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.FileInputStream;
import java.io.IOException;

// Referenced classes of package com.flurry.sdk:
//            gd, dz, hk, fy, 
//            hj, fx, av

class dw extends SurfaceView
    implements android.widget.MediaController.MediaPlayerControl
{

    private static final String d = com/flurry/sdk/dw.getSimpleName();
    android.media.MediaPlayer.OnPreparedListener a;
    android.media.MediaPlayer.OnVideoSizeChangedListener b;
    android.view.SurfaceHolder.Callback c;
    private dz e;
    private MediaPlayer f;
    private Uri g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private a p;
    private boolean q;
    private float r;
    private final fy s = new fy() {

        final dw a;

        public void a(hj hj1)
        {
            if (dw.a(a) != null)
            {
                int i1 = a.getDuration();
                int j1 = a.getCurrentPosition();
                if (i1 >= 0 && dw.b(a) != null && ((float)j1 - dw.c(a) > 1000F || dw.c(a) <= 300F))
                {
                    dw.a(a, j1);
                    dw.b(a).a(dw.d(a).toString(), i1, j1);
                    return;
                }
            }
        }

        public void notify(fx fx)
        {
            a((hj)fx);
        }

            
            {
                a = dw.this;
                super();
            }
    };
    private android.media.MediaPlayer.OnCompletionListener t;
    private android.media.MediaPlayer.OnErrorListener u;
    private android.media.MediaPlayer.OnBufferingUpdateListener v;

    public dw(Context context, dz dz1)
    {
        super(context);
        f = null;
        g = null;
        h = 0;
        i = 0;
        j = 0;
        k = 0;
        l = 0;
        m = 0;
        n = 0;
        p = a.a;
        q = false;
        r = 0.0F;
        a = new android.media.MediaPlayer.OnPreparedListener() {

            final dw a;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                dw.a(a, a.d);
                gd.a(5, dw.f(), (new StringBuilder()).append("OnPreparedListener: ").append(dw.d(a)).toString());
                if (dw.e(a) > 3)
                {
                    a.seekTo(dw.e(a));
                } else
                {
                    a.seekTo(3);
                }
                if (dw.b(a) != null && dw.d(a) != null)
                {
                    dw.b(a).a(dw.d(a).toString());
                }
            }

            
            {
                a = dw.this;
                super();
            }
        };
        b = new android.media.MediaPlayer.OnVideoSizeChangedListener() {

            final dw a;

            public void onVideoSizeChanged(MediaPlayer mediaplayer, int i1, int j1)
            {
                dw.a(a, mediaplayer.getVideoWidth());
                dw.b(a, mediaplayer.getVideoHeight());
                if (dw.f(a) != 0 && dw.g(a) != 0 && a.getHolder() != null)
                {
                    a.getHolder().setFixedSize(dw.f(a), dw.g(a));
                }
            }

            
            {
                a = dw.this;
                super();
            }
        };
        t = new android.media.MediaPlayer.OnCompletionListener() {

            final dw a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                dw.a(a, a.g);
                if (dw.b(a) != null)
                {
                    dw.b(a).b(dw.d(a).toString());
                }
            }

            
            {
                a = dw.this;
                super();
            }
        };
        u = new android.media.MediaPlayer.OnErrorListener() {

            final dw a;

            public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
            {
                gd.a(5, dw.f(), (new StringBuilder()).append("Error: ").append(dw.d(a)).append(" framework_err ").append(i1).append(" impl_err ").append(j1).toString());
                dw.a(a, a.i);
                if (dw.b(a) != null)
                {
                    dw.b(a).a(dw.d(a).toString(), av.r.a(), i1, j1);
                }
                return true;
            }

            
            {
                a = dw.this;
                super();
            }
        };
        v = new android.media.MediaPlayer.OnBufferingUpdateListener() {

            final dw a;

            public void onBufferingUpdate(MediaPlayer mediaplayer, int i1)
            {
                dw.c(a, i1);
            }

            
            {
                a = dw.this;
                super();
            }
        };
        c = new android.view.SurfaceHolder.Callback() {

            final dw a;

            public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
            {
            }

            public void surfaceCreated(SurfaceHolder surfaceholder)
            {
                dw.a(a, true);
                dw.h(a);
            }

            public void surfaceDestroyed(SurfaceHolder surfaceholder)
            {
                dw.a(a, false);
                a.c();
            }

            
            {
                a = dw.this;
                super();
            }
        };
        a(dz1);
    }

    static float a(dw dw1, float f1)
    {
        dw1.r = f1;
        return f1;
    }

    static int a(dw dw1, int i1)
    {
        dw1.h = i1;
        return i1;
    }

    static MediaPlayer a(dw dw1)
    {
        return dw1.f;
    }

    static a a(dw dw1, a a1)
    {
        dw1.p = a1;
        return a1;
    }

    private void a(int i1, int j1)
    {
        if (e != null)
        {
            gd.a(4, d, "Firing updateView ");
            e.a(i1, j1);
        }
    }

    private void a(dz dz1)
    {
        e = dz1;
        g = null;
        p = a.b;
        l = 3;
        if (getHolder() != null)
        {
            getHolder().addCallback(c);
            getHolder().setType(3);
        }
        setFocusable(true);
        setFocusableInTouchMode(true);
        requestFocus();
        requestLayout();
        hk.a().a(s);
    }

    static boolean a(dw dw1, boolean flag)
    {
        dw1.q = flag;
        return flag;
    }

    static int b(dw dw1, int i1)
    {
        dw1.i = i1;
        return i1;
    }

    static dz b(dw dw1)
    {
        return dw1.e;
    }

    static float c(dw dw1)
    {
        return dw1.r;
    }

    static int c(dw dw1, int i1)
    {
        dw1.n = i1;
        return i1;
    }

    static Uri d(dw dw1)
    {
        return dw1.g;
    }

    static int e(dw dw1)
    {
        return dw1.o;
    }

    static int f(dw dw1)
    {
        return dw1.h;
    }

    static String f()
    {
        return d;
    }

    static int g(dw dw1)
    {
        return dw1.i;
    }

    private void g()
    {
        if (f != null)
        {
            setFocusable(false);
            setFocusableInTouchMode(false);
            j();
            f.reset();
            f.release();
            hk.a().b(s);
            f = null;
        }
    }

    private void h()
    {
        if (!l()) goto _L2; else goto _L1
_L1:
        g();
        i();
        return;
        Object obj;
        obj;
_L4:
        gd.a(5, d, (new StringBuilder()).append("Unable to open content: ").append(g).toString(), ((Throwable) (obj)));
        u.onError(f, 1, 0);
        return;
_L2:
        gd.a(5, d, (new StringBuilder()).append("Cannot open video: ").append(g).toString());
        u.onError(f, 1, 0);
        return;
        obj;
        if (true) goto _L4; else goto _L3
_L3:
    }

    static void h(dw dw1)
    {
        dw1.h();
    }

    private void i()
    {
        if (f != null || g == null)
        {
            return;
        }
        f = new MediaPlayer();
        f.setOnPreparedListener(a);
        f.setOnVideoSizeChangedListener(b);
        m = -1;
        f.setOnCompletionListener(t);
        f.setOnErrorListener(u);
        f.setOnBufferingUpdateListener(v);
        f.setDisplay(getHolder());
        if (k())
        {
            f.setDataSource(getContext(), g);
        } else
        {
            FileInputStream fileinputstream = new FileInputStream(g.getPath());
            f.setDataSource(fileinputstream.getFD());
            fileinputstream.close();
        }
        f.setScreenOnWhilePlaying(true);
        f.prepareAsync();
        p = a.c;
    }

    private void j()
    {
        if (getContext() != null)
        {
            Intent intent = new Intent("com.android.music.musicservicecommand");
            intent.putExtra("command", "pause");
            getContext().sendBroadcast(intent);
        }
    }

    private boolean k()
    {
        return g != null && g.getScheme() != null && !g.getScheme().equalsIgnoreCase("file");
    }

    private boolean l()
    {
        boolean flag2 = false;
        Context context = getContext();
        boolean flag;
        boolean flag1;
        if (context != null)
        {
            flag = ((Activity)context).isFinishing();
        } else
        {
            flag = false;
        }
        gd.a(4, d, (new StringBuilder()).append("IsFinishing ").append(flag).toString());
        flag1 = flag2;
        if (q)
        {
            flag1 = flag2;
            if (!isPlaying())
            {
                flag1 = flag2;
                if (!flag)
                {
                    flag1 = flag2;
                    if (!p.equals(a.h))
                    {
                        flag1 = true;
                    }
                }
            }
        }
        return flag1;
    }

    private boolean m()
    {
        return f != null && (p.equals(a.d) || p.equals(a.e) || p.equals(a.f));
    }

    public void a(int i1)
    {
        if (p == a.f || p == a.d)
        {
            if (i1 < 0)
            {
                if (l > 3)
                {
                    i1 = l;
                } else
                {
                    i1 = 0;
                }
            }
            seekTo(i1);
            start();
        }
    }

    public void a(Uri uri, int i1)
    {
        if (uri == null)
        {
            return;
        } else
        {
            l = i1;
            g = uri;
            return;
        }
    }

    public boolean a()
    {
        return p == a.f || p == a.d;
    }

    public void b()
    {
        l = getCurrentPosition();
        pause();
    }

    public void c()
    {
        l = getCurrentPosition();
        p = a.h;
        pause();
        g();
    }

    public boolean canPause()
    {
        return false;
    }

    public boolean canSeekBackward()
    {
        return false;
    }

    public boolean canSeekForward()
    {
        return false;
    }

    public int d()
    {
        return 3;
    }

    public void e()
    {
        g();
    }

    public int getAudioSessionId()
    {
        return 0;
    }

    public int getBufferPercentage()
    {
        if (m())
        {
            return n;
        } else
        {
            return 0;
        }
    }

    public int getCurrentPosition()
    {
        if (f != null && (p.equals(a.d) || p.equals(a.e)))
        {
            return f.getCurrentPosition();
        } else
        {
            return -1;
        }
    }

    public int getDuration()
    {
        int i1;
        if (m())
        {
            i1 = f.getDuration();
        } else
        {
            i1 = -1;
        }
        m = i1;
        return m;
    }

    public boolean isPlaying()
    {
        return f != null && f.isPlaying() && p.equals(a.e);
    }

    protected void onMeasure(int i1, int j1)
    {
        int k1;
        int l1;
        k1 = getDefaultSize(h, i1);
        l1 = getDefaultSize(i, j1);
        i1 = l1;
        j1 = k1;
        if (h <= 0) goto _L2; else goto _L1
_L1:
        i1 = l1;
        j1 = k1;
        if (i <= 0) goto _L2; else goto _L3
_L3:
        if (h * l1 <= i * k1) goto _L5; else goto _L4
_L4:
        i1 = (i * k1) / h;
        j1 = k1;
_L2:
        if ((j != j1 || k != i1) && q)
        {
            gd.a(4, d, (new StringBuilder()).append("setting size: ").append(j1).append('x').append(i1).append(" ").append(System.currentTimeMillis()).toString());
            j = j1;
            k = i1;
            a(j1, i1);
        }
        setMeasuredDimension(j1, i1);
        return;
_L5:
        i1 = l1;
        j1 = k1;
        if (h * l1 < i * k1)
        {
            j1 = (h * l1) / i;
            i1 = l1;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    public void pause()
    {
        if (f != null && m() && f.isPlaying())
        {
            gd.a(4, d, (new StringBuilder()).append("Video pause at ").append(f.getCurrentPosition()).toString());
            p = a.f;
            f.pause();
        }
    }

    public void seekTo(int i1)
    {
        if (m())
        {
            o = i1;
            f.seekTo(i1);
        }
    }

    public void start()
    {
        if (f != null && m() && !f.isPlaying())
        {
            p = a.e;
            f.start();
        }
    }


    private class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        private static final a j[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/flurry/sdk/dw$a, s1);
        }

        public static a[] values()
        {
            return (a[])j.clone();
        }

        static 
        {
            a = new a("STATE_UNKNOWN", 0);
            b = new a("STATE_INIT", 1);
            c = new a("STATE_PREPARING", 2);
            d = new a("STATE_PREPARED", 3);
            e = new a("STATE_PLAYING", 4);
            f = new a("STATE_PAUSED", 5);
            g = new a("STATE_PLAYBACK_COMPLETED", 6);
            h = new a("STATE_SUSPEND", 7);
            i = new a("STATE_ERROR", 8);
            j = (new a[] {
                a, b, c, d, e, f, g, h, i
            });
        }

        private a(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
