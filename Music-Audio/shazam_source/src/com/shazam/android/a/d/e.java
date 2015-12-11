// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a.d;

import android.os.Handler;
import android.view.ViewGroup;

public abstract class e extends android.support.v7.widget.RecyclerView.a
{

    private int c;
    private final Handler d;
    public int i;
    int j;

    protected e(Handler handler)
    {
        d = handler;
    }

    private static int e(int k)
    {
        if (k < 0 || k >= 1000)
        {
            throw new IllegalStateException("viewType must be between 0 and 1000");
        } else
        {
            return k;
        }
    }

    public final int a()
    {
        i = b();
        j = c();
        c = 0;
        return i + j + c;
    }

    public final int a(int k)
    {
        if (i > 0 && k < i)
        {
            return e(0) + 0;
        }
        if (j > 0 && k - i < j)
        {
            return e(d(k - i)) + 2000;
        } else
        {
            return e(0) + 1000;
        }
    }

    protected abstract android.support.v7.widget.RecyclerView.u a(ViewGroup viewgroup);

    public final android.support.v7.widget.RecyclerView.u a(ViewGroup viewgroup, int k)
    {
        if (k >= 0 && k < 1000)
        {
            return a(viewgroup);
        }
        if (k >= 1000 && k < 2000)
        {
            return null;
        }
        if (k >= 2000 && k < 3000)
        {
            return b(viewgroup, k - 2000);
        } else
        {
            throw new IllegalStateException();
        }
    }

    protected abstract void a(android.support.v7.widget.RecyclerView.u u);

    public final void a(android.support.v7.widget.RecyclerView.u u, int k)
    {
        if (i > 0 && k < i)
        {
            a(u);
        } else
        if (j > 0 && k - i < j)
        {
            c(u, k - i);
            return;
        }
    }

    protected abstract int b();

    protected abstract android.support.v7.widget.RecyclerView.u b(ViewGroup viewgroup, int k);

    protected abstract int c();

    protected abstract void c(android.support.v7.widget.RecyclerView.u u, int k);

    protected int d(int k)
    {
        return 0;
    }

    public final void f(int k)
    {
        int l = b();
        int i1 = c();
        if (k < 0 || k >= i1)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("The given position ")).append(k).append(" is not within the position bounds for content items [0 - ").append(i1 - 1).append("].").toString());
        } else
        {
            super.a.b(l + k, 1);
            return;
        }
    }

    public final void g(int k)
    {
        if (k < 0 || k >= j)
        {
            throw new IndexOutOfBoundsException((new StringBuilder("The given position ")).append(k).append(" is not within the position bounds for content items [0 - ").append(j - 1).append("].").toString());
        } else
        {
            c(i + k);
            return;
        }
    }

    public final void h(int k)
    {
        d.post(new Runnable(k) {

            final int a;
            final e b;

            public final void run()
            {
                if (a >= 0 && a < b.j)
                {
                    b.g(a);
                    b.f(a);
                }
            }

            
            {
                b = e.this;
                a = k;
                super();
            }
        });
    }
}
