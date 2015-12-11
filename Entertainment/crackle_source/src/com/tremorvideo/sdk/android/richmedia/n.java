// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.richmedia;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tremorvideo.sdk.android.videoad.ad;
import com.tremorvideo.sdk.android.videoad.aw;
import com.tremorvideo.sdk.android.videoad.h;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

// Referenced classes of package com.tremorvideo.sdk.android.richmedia:
//            a, m, af, l, 
//            o, h, d, k

public class n extends View
    implements SensorEventListener, af.b, m.a
{
    public static interface a
    {

        public abstract void a(m m1, boolean flag);

        public abstract void a(aw aw1, int i1);

        public abstract void a(String s1, int i1);

        public abstract void a(String s1, com.tremorvideo.sdk.android.videoad.aw.b b1, int i1, String s2);

        public abstract com.tremorvideo.sdk.android.videoad.o.a g();
    }

    private class b
        implements Runnable
    {

        o a;
        final n b;

        public void run()
        {
            b.c.a(a);
            b.K = a.e();
            b.H = 0.0F;
        }

        public b(o o1)
        {
            b = n.this;
            super();
            a = o1;
        }
    }

    public class c
        implements Runnable
    {

        int a;
        final n b;

        public void run()
        {
            b.f.a(b.n, a, b.x);
            b.f.l().setVisibility(0);
        }

        public c(int i1)
        {
            b = n.this;
            super();
            a = -1;
            a = i1;
        }
    }


    long A;
    float B;
    float C;
    float D;
    long E;
    long F;
    float G;
    float H;
    int I;
    boolean J;
    o.b K;
    d L;
    String M;
    boolean N;
    boolean O;
    private int P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private Context T;
    private aw U;
    boolean a;
    boolean b;
    m c;
    Timer d;
    long e;
    af f;
    a g;
    boolean h;
    boolean i;
    int j;
    int k;
    int l;
    ArrayList m;
    l n;
    l o[];
    int p[];
    long q;
    boolean r;
    int s;
    int t;
    int u;
    int v;
    o w;
    int x;
    long y;
    boolean z;

    public n(Context context, d d1, com.tremorvideo.sdk.android.richmedia.a a1, int i1, boolean flag, l al[], aw aw1)
    {
        super(context);
        a = false;
        b = false;
        h = false;
        i = false;
        j = 0;
        k = 0;
        P = 0;
        Q = true;
        l = 0;
        m = new ArrayList(5);
        q = 0L;
        r = false;
        s = 0;
        t = 0;
        u = 0;
        v = 0;
        w = null;
        x = -1;
        y = 0L;
        z = false;
        A = 0L;
        E = 0L;
        F = 0L;
        J = true;
        R = false;
        S = false;
        N = false;
        U = null;
        O = false;
        T = context;
        R = false;
        e = SystemClock.elapsedRealtime();
        I = i1;
        J = flag;
        flag = false;
        if (context.getResources().getConfiguration().touchscreen == 1)
        {
            flag = true;
        }
        M = a1.h();
        o = al;
        p = new int[al.length];
        c = new m(this, a1, context, flag);
        f = new af(context, c, a1);
        f.a(this);
        L = d1;
        context = (SensorManager)context.getSystemService("sensor");
        context.registerListener(this, context.getDefaultSensor(1), 2);
        setFocusableInTouchMode(true);
        U = aw1;
        d = new Timer();
        d.scheduleAtFixedRate(new TimerTask() {

            final n a;

            public void run()
            {
                try
                {
                    a.k();
                    return;
                }
                catch (Exception exception)
                {
                    ad.a(exception);
                }
            }

            
            {
                a = n.this;
                super();
            }
        }, 10L, 10L);
    }

    private int a(h.b b1)
    {
        static class _cls3
        {

            static final int a[];

            static 
            {
                a = new int[com.tremorvideo.sdk.android.richmedia.h.b.values().length];
                try
                {
                    a[h.b.d.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[h.b.e.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[h.b.f.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[h.b.g.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls3.a[b1.ordinal()];
        JVM INSTR tableswitch 1 4: default 40
    //                   1 67
    //                   2 72
    //                   3 77
    //                   4 82;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        byte byte0 = -1;
_L7:
        return b((new StringBuilder()).append("video-").append(byte0).toString());
_L2:
        byte0 = 1;
        continue; /* Loop/switch isn't completed */
_L3:
        byte0 = 2;
        continue; /* Loop/switch isn't completed */
_L4:
        byte0 = 3;
        continue; /* Loop/switch isn't completed */
_L5:
        byte0 = 4;
        if (true) goto _L7; else goto _L6
_L6:
    }

    private l a(int i1)
    {
        String s1 = (new StringBuilder()).append("video-").append(i1 + 1).toString();
        l al[] = o;
        int j1 = al.length;
        for (i1 = 0; i1 < j1; i1++)
        {
            l l1 = al[i1];
            if (s1.equals(l1.c()))
            {
                return l1;
            }
        }

        return null;
    }

    private void a(int i1, int j1, int k1)
    {
        w = c.b();
        y = c.i();
        x = j1;
        r = true;
        s = 0;
        t = 0;
        l = 0;
        int ai[] = p;
        ai[i1] = ai[i1] + 1;
        n = a(i1);
        q = -1L;
        m.clear();
        if (i1 > 0)
        {
            Q = false;
        }
        if (R)
        {
            post(new c(k1));
            return;
        } else
        {
            S = true;
            return;
        }
    }

    private void a(MotionEvent motionevent)
    {
        if (motionevent.getAction() != 0) goto _L2; else goto _L1
_L1:
        G = motionevent.getX();
_L4:
        return;
_L2:
        if (motionevent.getAction() != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (K.ordinal() >= o.b.f.ordinal() && H > 0.1F)
        {
            K = o.b.a;
            c.a(o.b.a);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (motionevent.getAction() != 2) goto _L4; else goto _L3
_L3:
        float f1;
        float f2;
        float f3;
        f3 = motionevent.getX();
        f2 = f3 - G;
        if (K != o.b.c && K != o.b.g || f2 <= 0.0F)
        {
            break; /* Loop/switch isn't completed */
        }
        f1 = f2;
_L6:
        G = f3;
        if (f1 != 0.0F)
        {
            f2 = H;
            H = (f1 / (float)getWidth()) * 1.2F + f2;
            H = Math.max(0.0F, Math.min(H, 1.0F));
            long l1 = Math.round((float)c.b().c() * H);
            c.b(l1);
            post(new Runnable() {

                final n a;

                public void run()
                {
                    a.invalidate();
                }

            
            {
                a = n.this;
                super();
            }
            });
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if ((K == o.b.b || K == o.b.f) && f2 < 0.0F)
        {
            f1 = -f2;
        } else
        if (K == o.b.d || K == com.tremorvideo.sdk.android.richmedia.o.b.h)
        {
            f1 = -f2;
        } else
        {
            f1 = f2;
            if (K != o.b.e)
            {
                f1 = f2;
                if (K != o.b.i)
                {
                    f1 = 0.0F;
                }
            }
        }
          goto _L6
        if (true) goto _L4; else goto _L7
_L7:
    }

    private void a(l l1, int i1, int j1)
    {
        w = c.b();
        y = c.i();
        x = i1;
        r = true;
        s = 0;
        t = 0;
        l = 0;
        n = l1;
        q = -1L;
        m.clear();
        if (l1.d() > 0)
        {
            Q = false;
        }
        if (R)
        {
            post(new c(j1));
            return;
        } else
        {
            S = true;
            return;
        }
    }

    static void a(n n1, l l1, int i1, int j1)
    {
        n1.a(l1, i1, j1);
    }

    private boolean a(aw aw1)
    {
        return m.contains(aw1);
    }

    private int b(aw aw1)
    {
        int i1 = 0;
_L3:
        if (i1 >= o.length)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (!o[i1].c().equals(aw1.d())) goto _L2; else goto _L1
_L1:
        if (i1 >= 0)
        {
            return p[i1];
        } else
        {
            return -1;
        }
_L2:
        i1++;
          goto _L3
        i1 = -1;
          goto _L1
    }

    private int b(String s1)
    {
        int i1 = 0;
_L3:
        if (i1 >= o.length)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        if (!o[i1].c().equals(s1)) goto _L2; else goto _L1
_L1:
        if (i1 >= 0)
        {
            return p[i1];
        } else
        {
            return -1;
        }
_L2:
        i1++;
          goto _L3
        i1 = -1;
          goto _L1
    }

    private void b(int i1, int j1)
    {
        a(i1, j1, -1);
    }

    private void b(h.a a1)
    {
        b(a1.c().ordinal() - h.b.d.ordinal(), ((Integer)a1.e()).intValue());
        if (c != null)
        {
            c.a(h.c.b);
        }
    }

    private void t()
    {
        boolean flag;
        flag = false;
        break MISSING_BLOCK_LABEL_3;
        if (!h && !b && (n == null || n.a == null))
        {
            int i1;
            if (f.l().getVisibility() == 0 && f.a())
            {
                i1 = 1;
            } else
            {
                i1 = 0;
            }
            if (i1 != 0 && n != null && g != null && (long)l != q)
            {
                aw aaw[] = n.g();
                int j1 = aaw.length;
                i1 = ((flag) ? 1 : 0);
                while (i1 < j1) 
                {
                    aw aw1 = aaw[i1];
                    if (!a(aw1))
                    {
                        com.tremorvideo.sdk.android.videoad.aw.b b1 = aw1.a();
                        if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.ag)
                        {
                            m.add(aw1);
                            g.a(aw1, b(aw1));
                        } else
                        if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.ah)
                        {
                            m.add(aw1);
                            g.a(aw1, b(aw1));
                        } else
                        if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.ai)
                        {
                            if (f.b(1))
                            {
                                m.add(aw1);
                                g.a(aw1, b(aw1));
                            }
                        } else
                        if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.aj)
                        {
                            if (f.b(2))
                            {
                                m.add(aw1);
                                g.a(aw1, b(aw1));
                            }
                        } else
                        if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.ak)
                        {
                            if (f.b(3))
                            {
                                m.add(aw1);
                                g.a(aw1, b(aw1));
                            }
                        } else
                        if (b1 != com.tremorvideo.sdk.android.videoad.aw.b.al && q <= (long)aw1.e() && l > aw1.e())
                        {
                            m.add(aw1);
                            g.a(aw1, b(aw1));
                        }
                    }
                    i1++;
                }
                q = l;
                return;
            }
        }
        return;
    }

    private void u()
    {
        if (n != null && g != null)
        {
            aw aaw[] = n.g();
            int j1 = aaw.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                aw aw1 = aaw[i1];
                if (!a(aw1) && aw1.e() >= f.j())
                {
                    m.add(aw1);
                    g.a(aw1, b(aw1));
                }
            }

        }
    }

    private void v()
    {
        post(new Runnable() {

            final n a;

            public void run()
            {
                if (a.x != -1 && a.w != null)
                {
                    if (a.x == 255)
                    {
                        a.m();
                    } else
                    if (a.x == 254)
                    {
                        a.o();
                    } else
                    if (a.x == 253)
                    {
                        a.n();
                    } else
                    if (!a.c.n())
                    {
                        a.r = true;
                    } else
                    {
                        Object obj = a.w.a(a.x);
                        obj = a.c.a(((q) (obj)), a.y);
                        a.a(((k) (obj)).a, ((k) (obj)).b, ((k) (obj)).f, ((k) (obj)).g);
                    }
                    a.f.a(0);
                }
            }

            
            {
                a = n.this;
                super();
            }
        });
    }

    public int a()
    {
        return f.h();
    }

    public void a(float f1, float f2, float f3, float f4)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(Math.round(f3), Math.round(f4));
        layoutparams.leftMargin = Math.round(f1);
        layoutparams.topMargin = Math.round(f2);
        f.a(Math.round(f3), Math.round(f4));
        f.l().setLayoutParams(layoutparams);
    }

    public void a(int i1, int j1)
    {
        b(i1, j1);
    }

    public void a(h.a a1)
    {
        if (!b) goto _L2; else goto _L1
_L1:
        return;
_L2:
        c.a(a1);
        if (a1.c() == h.b.u && !c() || a1.c() == h.b.l && !d()) goto _L4; else goto _L3
_L3:
        if (a1.b() == h.c.c)
        {
            u();
        }
        if (a1.c() != h.b.b) goto _L6; else goto _L5
_L5:
        int i1 = ((Integer)a1.e()).intValue();
        a(c.b().f().b(i1));
        int j1 = -1;
_L34:
        if (g != null)
        {
            post(new Runnable(a1, j1) {

                final h.a a;
                final int b;
                final n c;

                public void run()
                {
                    c.g.a(Integer.toString(a.a()), b);
                }

            
            {
                c = n.this;
                a = a1;
                b = i1;
                super();
            }
            });
            return;
        }
          goto _L4
_L6:
        if (a1.c() != h.b.c) goto _L8; else goto _L7
_L7:
        int ai[] = (int[])(int[])a1.e();
        a(c.b().f().b(ai[0]));
        c.b(ai[1]);
        j1 = -1;
          goto _L9
_L8:
        if (!com.tremorvideo.sdk.android.richmedia.h.a(a1.c())) goto _L11; else goto _L10
_L10:
        b(a1);
        j1 = a(a1.c());
          goto _L9
_L11:
        if (a1.c() != h.b.k) goto _L13; else goto _L12
_L12:
        post(new Runnable() {

            final n a;

            public void run()
            {
                a.n = null;
                a.f.d();
            }

            
            {
                a = n.this;
                super();
            }
        });
        j1 = -1;
          goto _L9
_L13:
        if (a1.c() != com.tremorvideo.sdk.android.richmedia.h.b.h) goto _L15; else goto _L14
_L14:
        if (f.n == null) goto _L17; else goto _L16
_L16:
        int k1 = b(f.n.c());
        j1 = k1;
        if (f.n.h() != null) goto _L9; else goto _L18
_L18:
        post(new Runnable() {

            final n a;

            public void run()
            {
                a.f.f();
            }

            
            {
                a = n.this;
                super();
            }
        });
        j1 = k1;
          goto _L9
_L15:
        if (a1.c() != h.b.j) goto _L20; else goto _L19
_L19:
        if (f.n == null) goto _L22; else goto _L21
_L21:
        j1 = b(f.n.c());
        k1 = j1;
        if (f.n.h() != null)
        {
            break MISSING_BLOCK_LABEL_384;
        }
        post(new Runnable() {

            final n a;

            public void run()
            {
                a.f.f();
                a.f.l().setVisibility(4);
            }

            
            {
                a = n.this;
                super();
            }
        });
        k1 = j1;
_L32:
        j1 = k1;
        if (f.n != null)
        {
            j1 = k1;
        }
          goto _L9
_L20:
        if (a1.c() != h.b.i) goto _L24; else goto _L23
_L23:
        post(new Runnable(a1) {

            final h.a a;
            final n b;

            public void run()
            {
                if (b.f.o == null || b.f.o.h() != null)
                {
                    return;
                }
                int l1;
                if (a.e() == null)
                {
                    l1 = 255;
                } else
                {
                    l1 = ((Integer)a.e()).intValue();
                }
                if (b.n != null && b.n == b.f.o && l1 == b.f.q && l1 == b.f.p)
                {
                    b.f.k();
                    b.f.l().setVisibility(0);
                    return;
                } else
                {
                    n.a(b, b.f.o, l1, b.f.r);
                    return;
                }
            }

            
            {
                b = n.this;
                a = a1;
                super();
            }
        });
        if (f.o == null) goto _L17; else goto _L25
_L25:
        j1 = b(f.o.c());
          goto _L9
_L24:
        if (a1.c() == h.b.Q)
        {
            String s1 = (String)a1.e();
            if (g != null)
            {
                g.a(Integer.toString(a1.a()), com.tremorvideo.sdk.android.videoad.aw.b.as, -1, s1);
                return;
            }
            break MISSING_BLOCK_LABEL_635;
        }
        if (a1.c() != h.b.l) goto _L27; else goto _L26
_L26:
        b = true;
        if (g == null) goto _L17; else goto _L28
_L28:
        g.a(c, false);
        j1 = -1;
          goto _L9
_L27:
        if (a1.c() != h.b.S) goto _L30; else goto _L29
_L29:
        c.b = false;
        j1 = ((Integer)a1.e()).intValue();
        c.b(j1);
        j1 = -1;
          goto _L9
_L30:
        try
        {
            if (a1.c() == h.b.R)
            {
                c.b = true;
                j1 = ((Integer)a1.e()).intValue();
                c.b(j1);
            }
        }
        // Misplaced declaration of an exception variable
        catch (h.a a1)
        {
            ad.a(a1);
            return;
        }
_L17:
        j1 = -1;
          goto _L9
_L22:
        k1 = -1;
        if (true) goto _L32; else goto _L31
_L31:
        j1 = -1;
_L9:
        if (true) goto _L34; else goto _L33
_L33:
_L4:
        if (true) goto _L1; else goto _L35
_L35:
    }

    public void a(a a1)
    {
        g = a1;
    }

    public void a(o o1)
    {
        o1 = new b(o1);
        ((Activity)T).runOnUiThread(o1);
    }

    public void a(com.tremorvideo.sdk.android.videoad.aw.b b1)
    {
        aw aaw[] = n.g();
        int j1 = aaw.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            aw aw1 = aaw[i1];
            if (!a(aw1) && aw1.a() == b1)
            {
                m.add(aw1);
                g.a(aw1, b(aw1));
            }
        }

        if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.al && c != null)
        {
            c.a(h.c.c);
        }
    }

    public void a(h h1)
    {
        c.a(h1);
    }

    public void a(String s1)
    {
        post(new Runnable(s1) {

            final String a;
            final n b;

            public void run()
            {
                b.g.a(a, -1);
            }

            
            {
                b = n.this;
                a = s1;
                super();
            }
        });
    }

    public void a(boolean flag)
    {
        if (!flag)
        {
            r = true;
            s = u;
            t = v;
        }
        c.j();
        ad.d("rotate");
        f.a(0);
    }

    public boolean a(af af1)
    {
        return !i;
    }

    public int b()
    {
        return f.j();
    }

    public void b(boolean flag)
    {
        if (j > 0)
        {
            if (flag)
            {
                j = 1;
            } else
            {
                j = 0;
                h = false;
                if (i)
                {
                    i = false;
                    f.k();
                    return;
                }
            }
        }
    }

    public boolean c()
    {
        while (!J || k < I * 1000) 
        {
            return false;
        }
        return true;
    }

    public boolean d()
    {
        if (U != null)
        {
            return N;
        } else
        {
            return true;
        }
    }

    public com.tremorvideo.sdk.android.videoad.o.a e()
    {
        if (g != null)
        {
            return g.g();
        } else
        {
            return com.tremorvideo.sdk.android.videoad.o.a.f;
        }
    }

    public m f()
    {
        return c;
    }

    public void g()
    {
        i();
    }

    protected int getSuggestedMinimumHeight()
    {
        return 0;
    }

    protected int getSuggestedMinimumWidth()
    {
        return 0;
    }

    public void h()
    {
        ((SensorManager)getContext().getSystemService("sensor")).unregisterListener(this);
        b = true;
        d.cancel();
        f.o();
        c.a();
    }

    public void i()
    {
        if (j == 0)
        {
            h = true;
            if (f.a())
            {
                i = true;
                f.e();
            }
        }
        j = j + 1;
    }

    public void j()
    {
        if (j > 0)
        {
            j = j - 1;
            if (j == 0)
            {
                h = false;
                if (i)
                {
                    i = false;
                    f.k();
                }
            }
        }
    }

    protected void k()
    {
        long l1;
        boolean flag = true;
        l1 = SystemClock.elapsedRealtime();
        long l2 = l1 - e;
        if (h || f.c())
        {
            flag = false;
        }
        e = l1;
        k = (int)((long)k + l2);
        if (flag)
        {
            c.a(l2);
        }
        if (Q && flag)
        {
            P = (int)((long)P + l2);
        }
        if (f.a())
        {
            l = (int)((long)l + l2);
        }
        f.a(l2);
        try
        {
            t();
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        if (U == null || N) goto _L2; else goto _L1
_L1:
        if (n == null || n.d() <= 0 || !f.d) goto _L4; else goto _L3
_L3:
        l1 = P + f.h();
_L5:
        if (l1 > (long)U.e())
        {
            m.add(U);
            g.a(U, -1);
            N = true;
        }
_L2:
        if (r && (s != u || t != v))
        {
            r = false;
            v();
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_281;
        }
        post(new Runnable() {

            final n a;

            public void run()
            {
                a.f.g();
                a.L.invalidate();
                a.invalidate();
            }

            
            {
                a = n.this;
                super();
            }
        });
        return;
_L4:
        int i1 = P;
        l1 = i1;
          goto _L5
        Exception exception1;
        exception1;
        ad.a(exception1);
          goto _L2
        exception1;
        ad.a(exception1);
        return;
          goto _L5
    }

    public View l()
    {
        return f.l();
    }

    public void m()
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(10);
        layoutparams.addRule(12);
        layoutparams.addRule(11);
        layoutparams.addRule(9);
        f.a(getWidth(), getHeight());
        f.l().setLayoutParams(layoutparams);
    }

    public void n()
    {
        int i1 = n.a();
        int j1 = n.b();
        View view = f.l();
        f.b();
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(i1, j1);
        layoutparams.addRule(13);
        f.a(i1, j1);
        view.setLayoutParams(layoutparams);
    }

    public void o()
    {
        int k1 = getWidth();
        int l1 = getHeight();
        int i2 = n.a();
        int j2 = n.b();
        View view = f.l();
        float f1 = (float)i2 / (float)j2;
        android.widget.RelativeLayout.LayoutParams layoutparams;
        int i1;
        int j1;
        if (f1 > (float)k1 / (float)l1)
        {
            i1 = (int)((float)k1 / f1);
            j1 = k1;
        } else
        {
            j1 = (int)(f1 * (float)l1);
            i1 = l1;
        }
        ad.d((new StringBuilder()).append("VideoFit: DeviceScreen_WxH:").append(k1).append("x").append(l1).append(" VideoSource_WxH:").append(i2).append("x").append(j2).append(" VideoDisplay_WxH:").append(j1).append("x").append(i1).toString());
        layoutparams = new android.widget.RelativeLayout.LayoutParams(j1, i1);
        layoutparams.addRule(13);
        f.a(j1, i1);
        view.setLayoutParams(layoutparams);
        view.forceLayout();
    }

    public void onAccuracyChanged(Sensor sensor, int i1)
    {
    }

    protected void onAttachedToWindow()
    {
        R = true;
        if (S)
        {
            S = false;
            post(new c(-1));
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        u = canvas.getWidth();
        v = canvas.getHeight();
        canvas.save();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        try
        {
            c.b(canvas);
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
        canvas.restore();
    }

    public boolean onKeyDown(int i1, KeyEvent keyevent)
    {
        if (i1 != 21) goto _L2; else goto _L1
_L1:
        try
        {
            c.e();
        }
        catch (Exception exception)
        {
            ad.a(exception);
        }
_L3:
        return super.onKeyDown(i1, keyevent);
_L2:
        if (i1 != 22)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        c.f();
        break MISSING_BLOCK_LABEL_13;
        if (i1 != 19)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        c.g();
          goto _L3
        if (i1 != 20) goto _L5; else goto _L4
_L4:
        c.h();
          goto _L3
_L8:
        c.d();
          goto _L3
_L9:
        if (i1 != 4) goto _L3; else goto _L6
_L6:
        if (!c()) goto _L3; else goto _L7
_L7:
        c.c();
          goto _L3
_L5:
        if (i1 != 66 && i1 != 23) goto _L9; else goto _L8
    }

    public void onSensorChanged(SensorEvent sensorevent)
    {
        if (sensorevent.sensor.getType() != 1) goto _L2; else goto _L1
_L1:
        long l1 = System.currentTimeMillis();
        if (A != 0L) goto _L4; else goto _L3
_L3:
        A = l1;
        B = sensorevent.values[0];
        C = sensorevent.values[1];
        D = sensorevent.values[2];
_L2:
        return;
_L4:
        if (l1 - A <= 100L) goto _L2; else goto _L5
_L5:
        float f1;
        float f2;
        float f3;
        long l2;
        l2 = l1 - A;
        A = l1;
        f1 = sensorevent.values[0];
        f2 = sensorevent.values[1];
        f3 = sensorevent.values[2];
        if ((Math.abs((f1 + f2 + f3) - B - C - D) / (float)l2) * 10000F <= 800F) goto _L7; else goto _L6
_L6:
        E = l2 + E;
        F = 0L;
        if (E > 300L)
        {
            if (!f.c())
            {
                c.k();
            }
            E = 0L;
        }
_L9:
        B = f1;
        C = f2;
        D = f3;
        return;
_L7:
        F = l2 + F;
        if (F > 150L)
        {
            E = 0L;
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i1;
        int j1;
        int k1;
        int l1;
        boolean flag;
        if (K != o.b.a)
        {
            a(motionevent);
        }
        if (f != null)
        {
            f.a(motionevent);
        }
        flag = f.c();
        if (motionevent.getAction() != 0)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        i1 = Math.round(motionevent.getX());
        j1 = getWidth() / 2;
        k1 = Math.round(motionevent.getY());
        l1 = getHeight() / 2;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        c.c(i1 - j1, k1 - l1);
        return true;
        if (motionevent.getAction() != 2) goto _L2; else goto _L1
_L1:
        i1 = Math.round(motionevent.getX());
        j1 = getWidth() / 2;
        k1 = Math.round(motionevent.getY());
        l1 = getHeight() / 2;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        c.d(i1 - j1, k1 - l1);
        return true;
        Exception exception;
        exception;
        ad.a(exception);
_L4:
        return super.onTouchEvent(motionevent);
_L2:
        if (motionevent.getAction() != 3 && motionevent.getAction() != 1) goto _L4; else goto _L3
_L3:
        i1 = Math.round(motionevent.getX());
        j1 = getWidth() / 2;
        k1 = Math.round(motionevent.getY());
        l1 = getHeight() / 2;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_247;
        }
        c.e(i1 - j1, k1 - l1);
        return true;
    }

    public void p()
    {
        if (!O)
        {
            try
            {
                h();
            }
            catch (Exception exception)
            {
                ad.a(exception);
            }
            O = true;
            b = true;
            if (g != null)
            {
                g.a(c, true);
            }
        }
    }

    public void q()
    {
        aw aaw[] = n.g();
        int j1 = aaw.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            aw aw1 = aaw[i1];
            if (a(aw1))
            {
                continue;
            }
            com.tremorvideo.sdk.android.videoad.aw.b b1 = aw1.a();
            if (b1 == com.tremorvideo.sdk.android.videoad.aw.b.ag || b1 == com.tremorvideo.sdk.android.videoad.aw.b.ah || b1 == com.tremorvideo.sdk.android.videoad.aw.b.ai || b1 == com.tremorvideo.sdk.android.videoad.aw.b.aj || b1 == com.tremorvideo.sdk.android.videoad.aw.b.ak || b1 == com.tremorvideo.sdk.android.videoad.aw.b.al)
            {
                ad.d((new StringBuilder()).append("Current Video Time: ").append(l).toString());
                m.add(aw1);
                g.a(aw1, b(aw1));
            }
        }

    }

    public boolean r()
    {
        return c.l();
    }

    public int s()
    {
        if (f != null)
        {
            return f.i();
        } else
        {
            return -1;
        }
    }
}
