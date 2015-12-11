// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.w;
import java.util.ArrayList;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, b

private final class <init> extends <init>
{

    final RecyclerView a;

    private void b()
    {
        if (RecyclerView.n(a) && RecyclerView.o(a) && RecyclerView.p(a))
        {
            w.a(a, RecyclerView.q(a));
            return;
        } else
        {
            RecyclerView.r(a);
            a.requestLayout();
            return;
        }
    }

    public final void a()
    {
        a.a(null);
        RecyclerView.g(a);
        a.o.i = true;
        RecyclerView.m(a);
        if (!a.b.d())
        {
            a.requestLayout();
        }
    }

    public final void a(int i, int j)
    {
        boolean flag = true;
        a.a(null);
        b b1 = a.b;
        b1.a.add(b1.a(2, i, j));
        if (b1.a.size() == 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            b();
        }
    }

    public final void b(int i, int j)
    {
        boolean flag = true;
        a.a(null);
        b b1 = a.b;
        b1.a.add(b1.a(0, i, j));
        if (b1.a.size() == 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            b();
        }
    }

    public final void c(int i, int j)
    {
        boolean flag = true;
        a.a(null);
        b b1 = a.b;
        b1.a.add(b1.a(1, i, j));
        if (b1.a.size() == 1)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i != 0)
        {
            b();
        }
    }

    private (RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }

    <init>(RecyclerView recyclerview, byte byte0)
    {
        this(recyclerview);
    }
}
