// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.view.animation.Interpolator;

// Referenced classes of package android.support.design.widget:
//            bo, bl, bm

final class bk
{

    private final bo a;

    bk(bo bo1)
    {
        a = bo1;
    }

    public final void a()
    {
        a.a();
    }

    public final void a(int i)
    {
        a.a(600);
    }

    public final void a(int i, int j)
    {
        a.a(i, j);
    }

    public final void a(bm bm)
    {
        a.a(new bl(this, bm));
    }

    public final void a(Interpolator interpolator)
    {
        a.a(interpolator);
    }

    public final boolean b()
    {
        return a.b();
    }

    public final int c()
    {
        return a.c();
    }

    public final void d()
    {
        a.d();
    }
}
