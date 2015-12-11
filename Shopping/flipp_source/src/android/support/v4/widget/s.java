// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.content.Context;
import android.view.animation.Interpolator;

// Referenced classes of package android.support.v4.widget:
//            w, t, v, u

public final class s
{

    public Object a;
    public t b;

    private s(int i, Context context, Interpolator interpolator)
    {
        if (i >= 14)
        {
            b = new w();
        } else
        if (i >= 9)
        {
            b = new v();
        } else
        {
            b = new u();
        }
        a = b.a(context, interpolator);
    }

    private s(Context context, Interpolator interpolator)
    {
        this(android.os.Build.VERSION.SDK_INT, context, interpolator);
    }

    public static s a(Context context, Interpolator interpolator)
    {
        return new s(context, interpolator);
    }

    public final int a()
    {
        return b.b(a);
    }

    public final void a(int i, int j, int k, int l, int i1)
    {
        b.a(a, i, j, k, l, i1);
    }

    public final int b()
    {
        return b.c(a);
    }

    public final int c()
    {
        return b.g(a);
    }

    public final int d()
    {
        return b.h(a);
    }

    public final boolean e()
    {
        return b.e(a);
    }

    public final void f()
    {
        b.f(a);
    }
}
