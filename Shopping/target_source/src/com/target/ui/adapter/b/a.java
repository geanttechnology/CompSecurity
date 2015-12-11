// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.b;

import android.view.View;
import android.view.ViewGroup;
import com.k.a.b;
import com.target.ui.util.q;

public abstract class com.target.ui.adapter.b.a extends android.support.v7.widget.RecyclerView.a
    implements b
{
    public static class a extends android.support.v7.widget.RecyclerView.t
    {

        public a(View view)
        {
            super(view);
        }
    }


    public static final int FOOTER = 0x3b9aca01;
    private static final int FOOTER_COUNT = 1;
    public static final int HEADER = 0x3b9aca00;
    private static final int HEADER_COUNT = 1;
    private static final int HEADER_POSITION_INDEX = 0;
    private static final int NO_ITEM_COUNT = 0;
    public static final int NO_STICKY_HEADER = -1;
    private static final String TAG = com/target/ui/adapter/b/a.getSimpleName();

    public com.target.ui.adapter.b.a()
    {
    }

    private final int i()
    {
        return !e() ? 0 : 1;
    }

    private int i(int i1)
    {
        return i1 - m();
    }

    private final int j()
    {
        return !f() ? 0 : 1;
    }

    private final int k()
    {
        return 0;
    }

    private final int l()
    {
        return a() - 1;
    }

    private int m()
    {
        return !e() ? 0 : 1;
    }

    public final int a()
    {
        return i() + g() + j();
    }

    public final int a(int i1)
    {
        if (i1 == k() && e())
        {
            return 0x3b9aca00;
        }
        if (i1 == l() && f())
        {
            return 0x3b9aca01;
        } else
        {
            return g(i(i1));
        }
    }

    public android.support.v7.widget.RecyclerView.t a(ViewGroup viewgroup, int i1)
    {
        return d(viewgroup, i1);
    }

    protected abstract View a(ViewGroup viewgroup);

    public volatile void a(android.support.v7.widget.RecyclerView.t t, int i1)
    {
        a((a)t, i1);
    }

    public final void a(a a1, int i1)
    {
        switch (a(i1))
        {
        default:
            f(a1, i(i1));
            return;

        case 1000000000: 
            d(a1, i1);
            return;

        case 1000000001: 
            e(a1, i1);
            break;
        }
    }

    protected abstract View b(ViewGroup viewgroup);

    protected abstract View c(ViewGroup viewgroup);

    protected abstract View c(ViewGroup viewgroup, int i1);

    protected abstract void c(android.support.v7.widget.RecyclerView.t t, int i1);

    public final android.support.v7.widget.RecyclerView.t d(ViewGroup viewgroup)
    {
        return new a(a(viewgroup));
    }

    public final a d(ViewGroup viewgroup, int i1)
    {
        i1;
        JVM INSTR tableswitch 1000000000 1000000001: default 24
    //                   1000000000 40
    //                   1000000001 49;
           goto _L1 _L2 _L3
_L1:
        viewgroup = c(viewgroup, i1);
_L5:
        return new a(viewgroup);
_L2:
        viewgroup = b(viewgroup);
        continue; /* Loop/switch isn't completed */
_L3:
        viewgroup = c(viewgroup);
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected abstract void d(android.support.v7.widget.RecyclerView.t t, int i1);

    protected abstract void e(android.support.v7.widget.RecyclerView.t t, int i1);

    protected abstract boolean e();

    protected abstract long f(int i1);

    protected abstract void f(android.support.v7.widget.RecyclerView.t t, int i1);

    protected abstract boolean f();

    protected abstract int g();

    protected abstract int g(int i1);

    public final void g(android.support.v7.widget.RecyclerView.t t, int i1)
    {
        c(t, i(i1));
    }

    public final long h(int i1)
    {
        while (e() && i1 == 0 || f() && i1 == a() - 1) 
        {
            return -1L;
        }
        if (i(i1) >= g())
        {
            q.a(TAG, "Index out of bound. Make sure to update sticky header decoration after data set change");
            return -1L;
        } else
        {
            return f(i(i1));
        }
    }

    protected void h()
    {
        c(0);
    }

}
