// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.VideoView;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.ax;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            ag, l, a, m

public class af
{
    public class a extends VideoView
    {

        public boolean a;
        final af b;
        private int c;
        private int d;

        public void a()
        {
            c = 0;
            d = 0;
        }

        public void a(int i1, int j1)
        {
            c = i1;
            d = j1;
        }

        public int getId()
        {
            return 48879;
        }

        protected void onMeasure(int i1, int j1)
        {
            if (c == 0 || d == 0)
            {
                super.onMeasure(i1, j1);
                return;
            } else
            {
                setMeasuredDimension(c, d);
                return;
            }
        }

        a(Context context)
        {
            b = af.this;
            super(context);
            c = 0;
            d = 0;
            a = false;
        }
    }

    public static interface b
    {

        public abstract void a(com.tremorvideo.sdk.android.videoad.aw.b b1);

        public abstract boolean a(af af1);

        public abstract void p();

        public abstract void q();
    }


    a a;
    RelativeLayout b;
    m c;
    boolean d;
    b e;
    int f;
    int g;
    Context h;
    long i;
    long j;
    ProgressBar k;
    volatile boolean l;
    volatile l m;
    public l n;
    public l o;
    public int p;
    public int q;
    public int r;
    private com.tremorvideo.sdk.android.richmedia.a s;
    private boolean t;
    private boolean u;
    private boolean v;
    private ag w;
    private TextView x;
    private android.widget.RelativeLayout.LayoutParams y;
    private int z;

    public af(Context context, m m1, com.tremorvideo.sdk.android.richmedia.a a1)
    {
        f = 0;
        g = 0;
        i = 0L;
        j = 0L;
        t = false;
        u = false;
        v = false;
        l = false;
        m = null;
        n = null;
        o = null;
        p = -1;
        q = -1;
        r = 0;
        z = -1;
        s = a1;
        h = context;
        c = m1;
        d = false;
        b = new RelativeLayout(context);
        p();
    }

    static int a(af af1, int i1)
    {
        af1.z = i1;
        return i1;
    }

    static void a(af af1, l l1)
    {
        af1.b(l1);
    }

    static void a(af af1, boolean flag)
    {
        af1.a(flag);
    }

    private void a(l l1)
    {
        w = new ag(h, this);
        w.a(l1.a.b(), l1.e());
        l = false;
        v = false;
        l1 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        l1.addRule(10);
        l1.addRule(12);
        l1.addRule(11);
        l1.addRule(9);
        b.removeAllViews();
        b.addView(w, l1);
    }

    private void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        d = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    static boolean a(af af1)
    {
        return af1.v;
    }

    static void b(af af1)
    {
        af1.r();
    }

    private void b(l l1)
    {
        l = true;
        j = 0L;
        if (n != null && n.h() != null)
        {
            n();
        }
        if (l1.h() != null)
        {
            a(l1);
        } else
        {
            p();
            r();
            if (l1.f())
            {
                Object obj = Uri.parse(l1.e());
                a.setVideoURI(((Uri) (obj)));
                k = new ProgressBar(a.getContext(), null, 0x101007a);
                obj = new android.widget.RelativeLayout.LayoutParams(100, 100);
                ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
                b.addView(k, ((android.view.ViewGroup.LayoutParams) (obj)));
                t = false;
                u = true;
                v = false;
            } else
            {
                a.setVideoPath(l1.e());
                t = false;
                u = false;
                v = false;
            }
        }
        n = l1;
        f = 0;
        g = a.getDuration();
        a(true);
    }

    static boolean b(af af1, boolean flag)
    {
        af1.t = flag;
        return flag;
    }

    static boolean c(af af1)
    {
        return af1.u;
    }

    static int d(af af1)
    {
        return af1.z;
    }

    static TextView e(af af1)
    {
        return af1.x;
    }

    static android.widget.RelativeLayout.LayoutParams f(af af1)
    {
        return af1.y;
    }

    static ag g(af af1)
    {
        return af1.w;
    }

    private void p()
    {
        a = new a(h);
        a.setBackgroundColor(0);
        a.setId(48879);
        q();
        a.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {

            final af a;

            public void onCompletion(MediaPlayer mediaplayer)
            {
                a.f = a.g;
                if (!a.a.a && !af.a(a))
                {
                    if (a.c != null)
                    {
                        a.c.a(h.c.c);
                    }
                    if (a.e != null)
                    {
                        a.e.q();
                    }
                }
                af.a(a, false);
                af.b(a, false);
            }

            
            {
                a = af.this;
                super();
            }
        });
        a.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() {

            final af a;

            public void onPrepared(MediaPlayer mediaplayer)
            {
                if (a.a != null)
                {
                    if (a.m != null)
                    {
                        a.a.post(new Runnable(this) {

                            final _cls2 a;

                            public void run()
                            {
                                l l1 = a.a.m;
                                a.a.m = null;
                                af.a(a.a, l1);
                            }

            
            {
                a = _pcls2;
                super();
            }
                        });
                        return;
                    }
                    if (!af.a(a))
                    {
                        a.i = 200L;
                        a.l = false;
                        a.g = a.a.getDuration();
                        if (a.d)
                        {
                            boolean flag;
                            if (a.e != null)
                            {
                                flag = a.e.a(a);
                            } else
                            {
                                flag = true;
                            }
                            af.b(a);
                            if (flag)
                            {
                                a.a.start();
                                if (af.c(a))
                                {
                                    af.b(a, true);
                                }
                                if (a.k != null && a.k.isShown())
                                {
                                    a.k.setVisibility(8);
                                }
                                if (af.d(a) != -1)
                                {
                                    a.a.seekTo(af.d(a));
                                    af.a(a, -1);
                                    return;
                                }
                            }
                        }
                    }
                }
            }

            
            {
                a = af.this;
                super();
            }
        });
        a.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() {

            final af a;

            public boolean onError(MediaPlayer mediaplayer, int i1, int j1)
            {
                ad.d((new StringBuilder()).append("Media Player Error: ").append(i1).append(" Extra: ").append(j1).toString());
                if (!a.a.a)
                {
                    if (af.c(a))
                    {
                        a.m();
                    } else
                    {
                        a.a.a = true;
                        if (a.e != null)
                        {
                            a.e.p();
                            return true;
                        }
                    }
                }
                return true;
            }

            
            {
                a = af.this;
                super();
            }
        });
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(10);
        layoutparams.addRule(12);
        layoutparams.addRule(11);
        layoutparams.addRule(9);
        b.removeAllViews();
        b.addView(a, layoutparams);
    }

    private void q()
    {
        a.setVisibility(8);
    }

    private void r()
    {
        a.setVisibility(0);
    }

    public void a(int i1)
    {
        if (d)
        {
            a.postDelayed(new Runnable() {

                final af a;

                public void run()
                {
                    if (!af.c(a))
                    {
                        int j1 = a.f;
                        a.a.pause();
                        a.a.setVisibility(4);
                        a.a.setVisibility(0);
                        a.a.seekTo(j1);
                        a.a.start();
                    }
                }

            
            {
                a = af.this;
                super();
            }
            }, i1);
        }
    }

    public void a(int i1, int j1)
    {
        a.a(i1, j1);
        a.getHolder().setFixedSize(i1, j1);
    }

    public void a(long l1)
    {
        i = Math.max(0L, i - l1);
        if (!l) goto _L2; else goto _L1
_L1:
        long l2;
        l2 = j;
        j = j + l1;
        if (!u) goto _L4; else goto _L3
_L3:
        if (l2 < 10000L && j >= 20000L)
        {
            m();
        }
_L2:
        if (n != null && n.h() != null && w != null)
        {
            w.d();
            f = w.getProgress();
        }
        return;
_L4:
        if (l2 < 10000L && j >= 10000L)
        {
            if (u)
            {
                m();
            } else
            {
                ad.d("Unknown error while loading video...");
                e.p();
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    public void a(MotionEvent motionevent)
    {
        if (w != null && b != null)
        {
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)b.getLayoutParams();
            if (layoutparams != null)
            {
                float f1 = motionevent.getX() - (float)layoutparams.leftMargin;
                float f2 = motionevent.getY() - (float)layoutparams.topMargin;
                if (f1 > 0.0F && f1 < (float)layoutparams.width && f2 > 0.0F && f2 < (float)layoutparams.height)
                {
                    motionevent = MotionEvent.obtain(motionevent);
                    motionevent.setLocation(f1, f2);
                    w.dispatchTouchEvent(motionevent);
                    motionevent.recycle();
                }
            }
        }
    }

    public void a(b b1)
    {
        e = b1;
    }

    public void a(l l1, int i1, int j1)
    {
        z = i1;
        if (l)
        {
            m = l1;
            return;
        } else
        {
            p = j1;
            b(l1);
            return;
        }
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1)
    {
        if (e != null)
        {
            e.a(b1);
        }
    }

    public void a(String s1)
    {
        if (s != null)
        {
            ax ax1 = s.c();
            if (ax1 != null)
            {
                ax1.d(s1);
            }
        }
    }

    public boolean a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public void b()
    {
        a.a();
    }

    public boolean b(int i1)
    {
        if (t) goto _L2; else goto _L1
_L1:
        int k1;
        return false;
_L2:
        if ((k1 = a.getDuration()) < 1) goto _L1; else goto _L3
_L3:
        int j1;
        j1 = a.getCurrentPosition();
        k1 /= 4;
        i1;
        JVM INSTR tableswitch 1 3: default 60
    //                   1 62
    //                   2 69
    //                   3 78;
           goto _L4 _L5 _L6 _L7
_L7:
        continue; /* Loop/switch isn't completed */
_L4:
        return false;
_L5:
        if (j1 <= k1) goto _L1; else goto _L8
_L8:
        return true;
_L6:
        if (j1 <= k1 * 2) goto _L1; else goto _L9
_L9:
        return true;
        if (j1 <= k1 * 3) goto _L1; else goto _L10
_L10:
        return true;
    }

    public boolean c()
    {
        if (i > 0L)
        {
            return true;
        }
        if (u)
        {
            return false;
        } else
        {
            return l;
        }
    }

    public void d()
    {
        q();
        if (n != null && n.h() != null)
        {
            n();
            n = null;
        } else
        {
            a.stopPlayback();
        }
        a(false);
        f = 0;
        g = 0;
    }

    public void e()
    {
        if (n == null || n.h() == null || w == null) goto _L2; else goto _L1
_L1:
        w.b();
_L4:
        a(false);
        return;
_L2:
        if (a != null)
        {
            a.pause();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void f()
    {
        r = a.getCurrentPosition();
        o = n;
        q = p;
        e();
    }

    public void g()
    {
        if (d)
        {
            h();
        }
    }

    public int h()
    {
        int i1;
        boolean flag;
        flag = false;
        i1 = ((flag) ? 1 : 0);
        if (a == null)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        i1 = ((flag) ? 1 : 0);
        if (n != null)
        {
            i1 = ((flag) ? 1 : 0);
            try
            {
                if (n.h() == null)
                {
                    i1 = a.getCurrentPosition();
                }
            }
            catch (Exception exception)
            {
                i1 = ((flag) ? 1 : 0);
            }
        }
        if (i1 > f)
        {
            f = i1;
        }
        return f;
    }

    public int i()
    {
        if (a != null)
        {
            return a.getCurrentPosition();
        } else
        {
            return -1;
        }
    }

    public int j()
    {
        if (g < 1 && a != null)
        {
            g = a.getDuration();
        }
        return g;
    }

    public void k()
    {
        if (v) goto _L2; else goto _L1
_L1:
        if (n == null || n.h() == null) goto _L4; else goto _L3
_L3:
        if (w != null)
        {
            w.c();
            a(true);
        }
_L6:
        if (k != null && k.isShown())
        {
            k.setVisibility(8);
        }
        a(true);
_L2:
        return;
_L4:
        if (a != null && !a.isPlaying())
        {
            int i1 = a.getCurrentPosition();
            int j1 = j();
            if (i1 != f && f < j1)
            {
                a.seekTo(f);
            }
            a.start();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public View l()
    {
        return b;
    }

    public void m()
    {
        if (b != null && !v)
        {
            l = false;
            v = true;
            t = false;
            x = new TextView(a.getContext(), null, 0x1010041);
            x.setText("Playback Error!");
            y = new android.widget.RelativeLayout.LayoutParams(-2, -2);
            y.addRule(13);
            x.setPadding(10, 5, 10, 5);
            ShapeDrawable shapedrawable = new ShapeDrawable(new RoundRectShape(new float[] {
                10F, 10F, 10F, 10F, 10F, 10F, 10F, 10F
            }, null, null));
            shapedrawable.getPaint().setColor(0xff444444);
            x.setBackgroundDrawable(shapedrawable);
            x.setTextColor(-1);
            ((Activity)b.getContext()).runOnUiThread(new Runnable() {

                final af a;

                public void run()
                {
                    if (a.k != null && a.k.isShown())
                    {
                        a.k.setVisibility(8);
                    }
                    a.b.addView(af.e(a), af.f(a));
                    if (a.a != null && a.a.isPlaying())
                    {
                        a.a.stopPlayback();
                    }
                }

            
            {
                a = af.this;
                super();
            }
            });
        }
    }

    public void n()
    {
        w.stopLoading();
        w.a();
        if (w.getParent() == b)
        {
            b.removeView(w);
        }
        w.loadData("", "text/html", "UTF-8");
        w = null;
    }

    public void o()
    {
        ((Activity)b.getContext()).runOnUiThread(new Runnable() {

            final af a;

            public void run()
            {
                if (af.g(a) != null)
                {
                    a.n();
                }
                if (a.a != null)
                {
                    if (a.a.isPlaying())
                    {
                        a.a.stopPlayback();
                    }
                    a.a.destroyDrawingCache();
                    a.a = null;
                }
            }

            
            {
                a = af.this;
                super();
            }
        });
    }
}
