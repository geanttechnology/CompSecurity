// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            af, av, au

final class ag extends af
{

    ag(au au1)
    {
        super(au1, (byte)0);
    }

    public final int a(View view)
    {
        av av1 = (av)view.getLayoutParams();
        return au.d(view) - av1.leftMargin;
    }

    public final void a(int i)
    {
        a.d(i);
    }

    public final int b()
    {
        return a.m();
    }

    public final int b(View view)
    {
        av av1 = (av)view.getLayoutParams();
        int i = au.f(view);
        return av1.rightMargin + i;
    }

    public final int c()
    {
        return a.k() - a.o();
    }

    public final int c(View view)
    {
        av av1 = (av)view.getLayoutParams();
        int i = au.b(view);
        int j = av1.leftMargin;
        return av1.rightMargin + (i + j);
    }

    public final int d()
    {
        return a.k();
    }

    public final int d(View view)
    {
        av av1 = (av)view.getLayoutParams();
        int i = au.c(view);
        int j = av1.topMargin;
        return av1.bottomMargin + (i + j);
    }

    public final int e()
    {
        return a.k() - a.m() - a.o();
    }

    public final int f()
    {
        return a.o();
    }
}
