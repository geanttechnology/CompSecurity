// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.ah;
import android.support.v4.view.u;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class android.support.v4.widget.a
    implements android.view.View.OnTouchListener
{
    private static class a
    {

        private int a;
        private int b;
        private float c;
        private float d;
        private long e;
        private long f;
        private int g;
        private int h;
        private long i;
        private float j;
        private int k;

        private float a(float f1)
        {
            return -4F * f1 * f1 + 4F * f1;
        }

        private float a(long l1)
        {
            if (l1 < e)
            {
                return 0.0F;
            }
            if (i < 0L || l1 < i)
            {
                return android.support.v4.widget.a.a((float)(l1 - e) / (float)a, 0.0F, 1.0F) * 0.5F;
            } else
            {
                long l2 = i;
                float f1 = j;
                float f2 = j;
                return android.support.v4.widget.a.a((float)(l1 - l2) / (float)k, 0.0F, 1.0F) * f2 + (1.0F - f1);
            }
        }

        public void a()
        {
            e = AnimationUtils.currentAnimationTimeMillis();
            i = -1L;
            f = e;
            j = 0.5F;
            g = 0;
            h = 0;
        }

        public void a(float f1, float f2)
        {
            c = f1;
            d = f2;
        }

        public void a(int i1)
        {
            a = i1;
        }

        public void b()
        {
            long l1 = AnimationUtils.currentAnimationTimeMillis();
            k = android.support.v4.widget.a.a((int)(l1 - e), 0, b);
            j = a(l1);
            i = l1;
        }

        public void b(int i1)
        {
            b = i1;
        }

        public boolean c()
        {
            return i > 0L && AnimationUtils.currentAnimationTimeMillis() > i + (long)k;
        }

        public void d()
        {
            if (f == 0L)
            {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            } else
            {
                long l1 = AnimationUtils.currentAnimationTimeMillis();
                float f1 = a(a(l1));
                long l2 = l1 - f;
                f = l1;
                g = (int)((float)l2 * f1 * c);
                h = (int)((float)l2 * f1 * d);
                return;
            }
        }

        public int e()
        {
            return (int)(c / Math.abs(c));
        }

        public int f()
        {
            return (int)(d / Math.abs(d));
        }

        public int g()
        {
            return g;
        }

        public int h()
        {
            return h;
        }

        public a()
        {
            e = 0x8000000000000000L;
            i = -1L;
            f = 0L;
            g = 0;
            h = 0;
        }
    }

    private class b
        implements Runnable
    {

        final android.support.v4.widget.a a;

        public void run()
        {
            if (!android.support.v4.widget.a.a(a))
            {
                return;
            }
            if (android.support.v4.widget.a.b(a))
            {
                android.support.v4.widget.a.a(a, false);
                android.support.v4.widget.a.c(a).a();
            }
            a a1 = android.support.v4.widget.a.c(a);
            if (a1.c() || !android.support.v4.widget.a.d(a))
            {
                android.support.v4.widget.a.b(a, false);
                return;
            }
            if (android.support.v4.widget.a.e(a))
            {
                android.support.v4.widget.a.c(a, false);
                android.support.v4.widget.a.f(a);
            }
            a1.d();
            int i1 = a1.g();
            int j1 = a1.h();
            a.a(i1, j1);
            ah.a(android.support.v4.widget.a.g(a), this);
        }

        private b()
        {
            a = android.support.v4.widget.a.this;
            super();
        }

    }


    private static final int r = ViewConfiguration.getTapTimeout();
    private final a a = new a();
    private final Interpolator b = new AccelerateInterpolator();
    private final View c;
    private Runnable d;
    private float e[] = {
        0.0F, 0.0F
    };
    private float f[] = {
        3.402823E+38F, 3.402823E+38F
    };
    private int g;
    private int h;
    private float i[] = {
        0.0F, 0.0F
    };
    private float j[] = {
        0.0F, 0.0F
    };
    private float k[] = {
        3.402823E+38F, 3.402823E+38F
    };
    private boolean l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;

    public android.support.v4.widget.a(View view)
    {
        c = view;
        view = Resources.getSystem().getDisplayMetrics();
        int i1 = (int)(1575F * ((DisplayMetrics) (view)).density + 0.5F);
        int j1 = (int)(((DisplayMetrics) (view)).density * 315F + 0.5F);
        a(i1, i1);
        b(j1, j1);
        a(1);
        e(3.402823E+38F, 3.402823E+38F);
        d(0.2F, 0.2F);
        c(1.0F, 1.0F);
        b(r);
        c(500);
        d(500);
    }

    static float a(float f1, float f2, float f3)
    {
        return b(f1, f2, f3);
    }

    private float a(float f1, float f2, float f3, float f4)
    {
        float f5;
        f5 = 0.0F;
        f1 = b(f1 * f2, 0.0F, f3);
        f3 = f(f4, f1);
        f2 = f(f2 - f4, f1) - f3;
        if (f2 >= 0.0F) goto _L2; else goto _L1
_L1:
        f1 = -b.getInterpolation(-f2);
_L6:
        f1 = b(f1, -1F, 1.0F);
_L4:
        return f1;
_L2:
        f1 = f5;
        if (f2 <= 0.0F) goto _L4; else goto _L3
_L3:
        f1 = b.getInterpolation(f2);
        if (true) goto _L6; else goto _L5
_L5:
    }

    private float a(int i1, float f1, float f2, float f3)
    {
        f1 = a(e[i1], f2, f[i1], f1);
        if (f1 == 0.0F)
        {
            return 0.0F;
        }
        float f5 = i[i1];
        f2 = j[i1];
        float f4 = k[i1];
        f3 = f5 * f3;
        if (f1 > 0.0F)
        {
            return b(f1 * f3, f2, f4);
        } else
        {
            return -b(-f1 * f3, f2, f4);
        }
    }

    static int a(int i1, int j1, int k1)
    {
        return b(i1, j1, k1);
    }

    private boolean a()
    {
        a a1 = a;
        int i1 = a1.f();
        int j1 = a1.e();
        return i1 != 0 && f(i1) || j1 != 0 && e(j1);
    }

    static boolean a(android.support.v4.widget.a a1)
    {
        return a1.o;
    }

    static boolean a(android.support.v4.widget.a a1, boolean flag)
    {
        a1.m = flag;
        return flag;
    }

    private static float b(float f1, float f2, float f3)
    {
        if (f1 > f3)
        {
            return f3;
        }
        if (f1 < f2)
        {
            return f2;
        } else
        {
            return f1;
        }
    }

    private static int b(int i1, int j1, int k1)
    {
        if (i1 > k1)
        {
            return k1;
        }
        if (i1 < j1)
        {
            return j1;
        } else
        {
            return i1;
        }
    }

    private void b()
    {
        if (d == null)
        {
            d = new b();
        }
        o = true;
        m = true;
        if (!l && h > 0)
        {
            ah.a(c, d, h);
        } else
        {
            d.run();
        }
        l = true;
    }

    static boolean b(android.support.v4.widget.a a1)
    {
        return a1.m;
    }

    static boolean b(android.support.v4.widget.a a1, boolean flag)
    {
        a1.o = flag;
        return flag;
    }

    static a c(android.support.v4.widget.a a1)
    {
        return a1.a;
    }

    private void c()
    {
        if (m)
        {
            o = false;
            return;
        } else
        {
            a.b();
            return;
        }
    }

    static boolean c(android.support.v4.widget.a a1, boolean flag)
    {
        a1.n = flag;
        return flag;
    }

    private void d()
    {
        long l1 = SystemClock.uptimeMillis();
        MotionEvent motionevent = MotionEvent.obtain(l1, l1, 3, 0.0F, 0.0F, 0);
        c.onTouchEvent(motionevent);
        motionevent.recycle();
    }

    static boolean d(android.support.v4.widget.a a1)
    {
        return a1.a();
    }

    static boolean e(android.support.v4.widget.a a1)
    {
        return a1.n;
    }

    private float f(float f1, float f2)
    {
        if (f2 != 0.0F) goto _L2; else goto _L1
_L1:
        return 0.0F;
_L2:
        g;
        JVM INSTR tableswitch 0 2: default 40
    //                   0 42
    //                   1 42
    //                   2 77;
           goto _L3 _L4 _L4 _L5
_L5:
        continue; /* Loop/switch isn't completed */
_L3:
        return 0.0F;
_L4:
        if (f1 >= f2) goto _L1; else goto _L6
_L6:
        if (f1 >= 0.0F)
        {
            return 1.0F - f1 / f2;
        }
        if (!o || g != 1) goto _L1; else goto _L7
_L7:
        return 1.0F;
        if (f1 >= 0.0F) goto _L1; else goto _L8
_L8:
        return f1 / -f2;
    }

    static void f(android.support.v4.widget.a a1)
    {
        a1.d();
    }

    static View g(android.support.v4.widget.a a1)
    {
        return a1.c;
    }

    public android.support.v4.widget.a a(float f1, float f2)
    {
        k[0] = f1 / 1000F;
        k[1] = f2 / 1000F;
        return this;
    }

    public android.support.v4.widget.a a(int i1)
    {
        g = i1;
        return this;
    }

    public android.support.v4.widget.a a(boolean flag)
    {
        if (p && !flag)
        {
            c();
        }
        p = flag;
        return this;
    }

    public abstract void a(int i1, int j1);

    public android.support.v4.widget.a b(float f1, float f2)
    {
        j[0] = f1 / 1000F;
        j[1] = f2 / 1000F;
        return this;
    }

    public android.support.v4.widget.a b(int i1)
    {
        h = i1;
        return this;
    }

    public android.support.v4.widget.a c(float f1, float f2)
    {
        i[0] = f1 / 1000F;
        i[1] = f2 / 1000F;
        return this;
    }

    public android.support.v4.widget.a c(int i1)
    {
        a.a(i1);
        return this;
    }

    public android.support.v4.widget.a d(float f1, float f2)
    {
        e[0] = f1;
        e[1] = f2;
        return this;
    }

    public android.support.v4.widget.a d(int i1)
    {
        a.b(i1);
        return this;
    }

    public android.support.v4.widget.a e(float f1, float f2)
    {
        f[0] = f1;
        f[1] = f2;
        return this;
    }

    public abstract boolean e(int i1);

    public abstract boolean f(int i1);

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        boolean flag;
        flag = true;
        if (!p)
        {
            return false;
        }
        u.a(motionevent);
        JVM INSTR tableswitch 0 3: default 48
    //                   0 65
    //                   1 153
    //                   2 75
    //                   3 153;
           goto _L1 _L2 _L3 _L4 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_153;
_L5:
        float f1;
        float f2;
        if (!q || !o)
        {
            flag = false;
        }
        return flag;
_L2:
        n = true;
        l = false;
_L4:
        f1 = a(0, motionevent.getX(), view.getWidth(), c.getWidth());
        f2 = a(1, motionevent.getY(), view.getHeight(), c.getHeight());
        a.a(f1, f2);
        if (!o && a())
        {
            b();
        }
          goto _L5
        c();
          goto _L5
    }

}
