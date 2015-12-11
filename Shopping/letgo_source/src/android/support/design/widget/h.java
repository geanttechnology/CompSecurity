// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.design.widget:
//            a

class h extends g.e
{

    private static final Handler a = new Handler(Looper.getMainLooper());
    private long b;
    private boolean c;
    private final int d[] = new int[2];
    private final float e[] = new float[2];
    private int f;
    private Interpolator g;
    private g.e.a h;
    private g.e.b i;
    private float j;
    private final Runnable k = new Runnable() {

        final h a;

        public void run()
        {
            h.a(a);
        }

            
            {
                a = h.this;
                super();
            }
    };

    h()
    {
        f = 200;
    }

    static void a(h h1)
    {
        h1.e();
    }

    private void e()
    {
        if (c)
        {
            float f2 = (float)(SystemClock.uptimeMillis() - b) / (float)f;
            float f1 = f2;
            if (g != null)
            {
                f1 = g.getInterpolation(f2);
            }
            j = f1;
            if (i != null)
            {
                i.a();
            }
            if (SystemClock.uptimeMillis() >= b + (long)f)
            {
                c = false;
                if (h != null)
                {
                    h.b();
                }
            }
        }
        if (c)
        {
            a.postDelayed(k, 10L);
        }
    }

    public void a()
    {
        if (c)
        {
            return;
        }
        if (g == null)
        {
            g = new AccelerateDecelerateInterpolator();
        }
        b = SystemClock.uptimeMillis();
        c = true;
        if (h != null)
        {
            h.a();
        }
        a.postDelayed(k, 10L);
    }

    public void a(float f1, float f2)
    {
        e[0] = f1;
        e[1] = f2;
    }

    public void a(int l)
    {
        f = l;
    }

    public void a(int l, int i1)
    {
        d[0] = l;
        d[1] = i1;
    }

    public void a(g.e.a a1)
    {
        h = a1;
    }

    public void a(g.e.b b1)
    {
        i = b1;
    }

    public void a(Interpolator interpolator)
    {
        g = interpolator;
    }

    public int b()
    {
        return android.support.design.widget.a.a(d[0], d[1], d());
    }

    public void c()
    {
        c = false;
        a.removeCallbacks(k);
        if (h != null)
        {
            h.c();
        }
    }

    public float d()
    {
        return j;
    }

}
