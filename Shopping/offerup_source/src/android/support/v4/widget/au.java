// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.v4.widget:
//            ay, av, ax, aw

public final class au
{

    private Object a;
    private av b;

    private au(int i, Context context, Interpolator interpolator)
    {
        if (i >= 14)
        {
            b = new ay();
        } else
        if (i >= 9)
        {
            b = new ax();
        } else
        {
            b = new aw();
        }
        a = b.a(context, interpolator);
    }

    private au(Context context, Interpolator interpolator)
    {
        this(android.os.Build.VERSION.SDK_INT, context, interpolator);
    }

    public static au a(Context context)
    {
        return a(context, null);
    }

    public static au a(Context context, Interpolator interpolator)
    {
        return new au(context, interpolator);
    }

    public final void a(int i, int j, int k, int l, int i1)
    {
        b.a(a, i, j, k, l, i1);
    }

    public final void a(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        b.a(a, 0, j, k, l, i1, j1, k1, l1);
    }

    public final boolean a()
    {
        return b.a(a);
    }

    public final int b()
    {
        return b.b(a);
    }

    public final int c()
    {
        return b.c(a);
    }

    public final int d()
    {
        return b.g(a);
    }

    public final int e()
    {
        return b.h(a);
    }

    public final float f()
    {
        return b.d(a);
    }

    public final boolean g()
    {
        return b.e(a);
    }

    public final void h()
    {
        b.f(a);
    }
}
