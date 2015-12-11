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
//            bo, br, bp, a

final class bq extends bo
{

    private static final Handler a = new Handler(Looper.getMainLooper());
    private long b;
    private boolean c;
    private final int d[] = new int[2];
    private int e;
    private Interpolator f;
    private bp g;
    private float h;
    private final Runnable i = new br(this);

    bq()
    {
        e = 200;
    }

    static void a(bq bq1)
    {
        if (bq1.c)
        {
            float f2 = (float)(SystemClock.uptimeMillis() - bq1.b) / (float)bq1.e;
            float f1 = f2;
            if (bq1.f != null)
            {
                f1 = bq1.f.getInterpolation(f2);
            }
            bq1.h = f1;
            if (bq1.g != null)
            {
                bq1.g.a();
            }
            if (SystemClock.uptimeMillis() >= bq1.b + (long)bq1.e)
            {
                bq1.c = false;
            }
        }
        if (bq1.c)
        {
            a.postDelayed(bq1.i, 10L);
        }
    }

    public final void a()
    {
        if (c)
        {
            return;
        }
        if (f == null)
        {
            f = new AccelerateDecelerateInterpolator();
        }
        b = SystemClock.uptimeMillis();
        c = true;
        a.postDelayed(i, 10L);
    }

    public final void a(int j)
    {
        e = j;
    }

    public final void a(int j, int k)
    {
        d[0] = j;
        d[1] = k;
    }

    public final void a(bp bp1)
    {
        g = bp1;
    }

    public final void a(Interpolator interpolator)
    {
        f = interpolator;
    }

    public final boolean b()
    {
        return c;
    }

    public final int c()
    {
        return android.support.design.widget.a.a(d[0], d[1], h);
    }

    public final void d()
    {
        c = false;
        a.removeCallbacks(i);
    }

}
