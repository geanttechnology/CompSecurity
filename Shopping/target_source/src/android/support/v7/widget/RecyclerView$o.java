// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.support.v4.view.ai;

// Referenced classes of package android.support.v7.widget:
//            RecyclerView, a

private class <init> extends <init>
{

    final RecyclerView a;

    public void a()
    {
        a.a(null);
        if (RecyclerView.f(a).b())
        {
            a(a.mState, true);
            RecyclerView.j(a);
        } else
        {
            a(a.mState, true);
            RecyclerView.j(a);
        }
        if (!a.mAdapterHelper.d())
        {
            a.requestLayout();
        }
    }

    public void a(int i, int j)
    {
        a.a(null);
        if (a.mAdapterHelper.b(i, j))
        {
            b();
        }
    }

    public void a(int i, int j, int k)
    {
        a.a(null);
        if (a.mAdapterHelper.a(i, j, k))
        {
            b();
        }
    }

    void b()
    {
        if (RecyclerView.k(a) && RecyclerView.l(a) && RecyclerView.m(a))
        {
            ai.a(a, RecyclerView.n(a));
            return;
        } else
        {
            RecyclerView.c(a, true);
            a.requestLayout();
            return;
        }
    }

    public void b(int i, int j)
    {
        a.a(null);
        if (a.mAdapterHelper.c(i, j))
        {
            b();
        }
    }

    public void c(int i, int j)
    {
        a.a(null);
        if (a.mAdapterHelper.d(i, j))
        {
            b();
        }
    }

    private (RecyclerView recyclerview)
    {
        a = recyclerview;
        super();
    }

    <init>(RecyclerView recyclerview, <init> <init>1)
    {
        this(recyclerview);
    }
}
