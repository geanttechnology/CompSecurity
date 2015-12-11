// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            af, av, au

final class ah extends af
{

    ah(au au1)
    {
        super(au1, (byte)0);
    }

    public final int a(View view)
    {
        av av1 = (av)view.getLayoutParams();
        return au.e(view) - av1.topMargin;
    }

    public final void a(int i)
    {
        a.e(i);
    }

    public final int b()
    {
        return a.n();
    }

    public final int b(View view)
    {
        av av1 = (av)view.getLayoutParams();
        int i = au.g(view);
        return av1.bottomMargin + i;
    }

    public final int c()
    {
        return a.l() - a.p();
    }

    public final int c(View view)
    {
        av av1 = (av)view.getLayoutParams();
        int i = au.c(view);
        int j = av1.topMargin;
        return av1.bottomMargin + (i + j);
    }

    public final int d()
    {
        return a.l();
    }

    public final int d(View view)
    {
        av av1 = (av)view.getLayoutParams();
        int i = au.b(view);
        int j = av1.leftMargin;
        return av1.rightMargin + (i + j);
    }

    public final int e()
    {
        return a.l() - a.n() - a.p();
    }

    public final int f()
    {
        return a.p();
    }
}
