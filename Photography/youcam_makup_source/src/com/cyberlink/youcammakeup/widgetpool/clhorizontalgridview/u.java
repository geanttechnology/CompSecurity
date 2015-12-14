// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview:
//            v

public class u
{

    private static float f = 8F;
    private static float g = 1.0F;
    private int a;
    private final v b;
    private final v c;
    private Interpolator d;
    private final boolean e;

    public u(Context context)
    {
        this(context, null);
    }

    public u(Context context, Interpolator interpolator)
    {
        this(context, interpolator, true);
    }

    public u(Context context, Interpolator interpolator, boolean flag)
    {
        d = interpolator;
        e = flag;
        b = new v(context);
        c = new v(context);
    }

    static float b(float f1)
    {
        f1 = f * f1;
        if (f1 < 1.0F)
        {
            f1 -= 1.0F - (float)Math.exp(-f1);
        } else
        {
            f1 = (1.0F - (float)Math.exp(1.0F - f1)) * (1.0F - 0.3678795F) + 0.3678795F;
        }
        return f1 * g;
    }

    public final void a(float f1)
    {
        b.a(f1);
        c.a(f1);
    }

    public void a(int i, int j, int k)
    {
        b.c(i, j, k);
    }

    public void a(int i, int j, int k, int l, int i1)
    {
        a = 0;
        b.a(i, k, i1);
        c.a(j, l, i1);
    }

    public void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        a(i, j, k, l, i1, j1, k1, l1, 0, 0);
    }

    public void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        if (e && !a())
        {
            float f1 = v.c(b);
            float f2 = v.c(c);
            if (Math.signum(k) == Math.signum(f1) && Math.signum(l) == Math.signum(f2))
            {
                k = (int)(f1 + (float)k);
                l = (int)((float)l + f2);
            }
        }
        a = 1;
        b.a(i, k, i1, j1, i2);
        c.a(j, l, k1, l1, j2);
    }

    void a(Interpolator interpolator)
    {
        d = interpolator;
    }

    public final boolean a()
    {
        return v.a(b) && v.a(c);
    }

    public boolean a(float f1, float f2)
    {
        int i = v.e(b);
        int j = v.d(b);
        int k = v.e(c);
        int l = v.d(c);
        return !a() && Math.signum(f1) == Math.signum(i - j) && Math.signum(f2) == Math.signum(k - l);
    }

    public boolean a(int i, int j, int k, int l, int i1, int j1)
    {
        a = 1;
        boolean flag = b.b(i, k, l);
        boolean flag1 = c.b(j, i1, j1);
        return flag || flag1;
    }

    public final int b()
    {
        return v.b(b);
    }

    public float c()
    {
        return (float)Math.sqrt(v.c(b) * v.c(b) + v.c(c) * v.c(c));
    }

    public boolean d()
    {
        if (a())
        {
            return false;
        }
        a;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 38
    //                   1 123;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        long l = AnimationUtils.currentAnimationTimeMillis() - v.g(b);
        int i = v.f(b);
        if (l < (long)i)
        {
            float f1 = (float)l / (float)i;
            if (d == null)
            {
                f1 = b(f1);
            } else
            {
                f1 = d.getInterpolation(f1);
            }
            b.b(f1);
            c.b(f1);
        } else
        {
            e();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!v.a(b) && !b.c() && !b.b())
        {
            b.a();
        }
        if (!v.a(c) && !c.c() && !c.b())
        {
            c.a();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void e()
    {
        b.a();
        c.a();
    }

    static 
    {
        g = 1.0F / b(1.0F);
    }
}
