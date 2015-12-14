// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sonyericsson.zoom;

import android.os.Handler;
import android.os.SystemClock;
import com.sonyericsson.util.a;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.sonyericsson.zoom:
//            c, a

public final class b
    implements Observer
{

    public final c a = new c();
    public com.sonyericsson.zoom.a b;
    float c;
    float d;
    float e;
    float f;
    private final com.sonyericsson.util.b g = new com.sonyericsson.util.b();
    private final com.sonyericsson.util.b h = new com.sonyericsson.util.b();
    private final Handler i = new Handler();
    private final Runnable j = new _cls1();

    public b()
    {
        g.e = 2.0F;
        h.e = 2.0F;
        g.d();
        h.d();
    }

    private static float a(float f1)
    {
        return Math.max(0.0F, 0.5F * ((f1 - 1.0F) / f1));
    }

    static com.sonyericsson.util.b a(b b1)
    {
        return b1.g;
    }

    static com.sonyericsson.util.b b(b b1)
    {
        return b1.h;
    }

    private void b()
    {
        if (a.a < 1.0F)
        {
            a.e(1.0F);
        } else
        if (a.a > 16F)
        {
            a.e(16F);
            return;
        }
    }

    static c c(b b1)
    {
        return b1.a;
    }

    private void c()
    {
        float f2 = b.a;
        float f1 = a.a(f2);
        f2 = a.b(f2);
        c = 0.5F - a(f1);
        d = a(f1) + 0.5F;
        e = 0.5F - a(f2);
        f = a(f2) + 0.5F;
    }

    static Runnable d(b b1)
    {
        return b1.j;
    }

    static Handler e(b b1)
    {
        return b1.i;
    }

    public final void a()
    {
        i.removeCallbacks(j);
    }

    public final void a(float f1, float f2)
    {
        float f3 = b.a;
        long l = SystemClock.uptimeMillis();
        g.a(a.b, f1 / a.a(f3), l);
        h.a(a.c, f2 / a.b(f3), l);
        g.d = c;
        g.c = d;
        h.d = e;
        h.c = f;
        i.post(j);
    }

    public final void a(float f1, float f2, float f3)
    {
        float f6 = b.a;
        float f5 = a.a(f6);
        float f4 = a.b(f6);
        a.e(a.a * f1);
        b();
        f1 = a.a(f6);
        f6 = a.b(f6);
        c c1 = a;
        float f7 = a.b;
        c1.c((1.0F / f5 - 1.0F / f1) * (f2 - 0.5F) + f7);
        c1 = a;
        f1 = a.c;
        c1.d((1.0F / f4 - 1.0F / f6) * (f3 - 0.5F) + f1);
        c();
        a.notifyObservers();
    }

    public final void update(Observable observable, Object obj)
    {
        b();
        c();
    }

    /* member class not found */
    class _cls1 {}

}
