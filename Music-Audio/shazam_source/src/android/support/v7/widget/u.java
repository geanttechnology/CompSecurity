// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

public abstract class u
{

    protected final RecyclerView.i a;
    int b;

    private u(RecyclerView.i i)
    {
        b = 0x80000000;
        a = i;
    }

    u(RecyclerView.i i, byte byte0)
    {
        this(i);
    }

    public static u a(RecyclerView.i i, int j)
    {
        switch (j)
        {
        default:
            throw new IllegalArgumentException("invalid orientation");

        case 0: // '\0'
            return new u(i) {

                public final int a(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    return RecyclerView.i.d(view) - j1.leftMargin;
                }

                public final void a(int k)
                {
                    a.d(k);
                }

                public final int b()
                {
                    return a.m();
                }

                public final int b(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    int k = RecyclerView.i.f(view);
                    return j1.rightMargin + k;
                }

                public final int c()
                {
                    return a.k() - a.o();
                }

                public final int c(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    int k = RecyclerView.i.b(view);
                    int l = j1.leftMargin;
                    return j1.rightMargin + (k + l);
                }

                public final int d()
                {
                    return a.k();
                }

                public final int d(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    int k = RecyclerView.i.c(view);
                    int l = j1.topMargin;
                    return j1.bottomMargin + (k + l);
                }

                public final int e()
                {
                    return a.k() - a.m() - a.o();
                }

                public final int f()
                {
                    return a.o();
                }

            };

        case 1: // '\001'
            return new u(i) {

                public final int a(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    return RecyclerView.i.e(view) - j1.topMargin;
                }

                public final void a(int k)
                {
                    a.e(k);
                }

                public final int b()
                {
                    return a.n();
                }

                public final int b(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    int k = RecyclerView.i.g(view);
                    return j1.bottomMargin + k;
                }

                public final int c()
                {
                    return a.l() - a.p();
                }

                public final int c(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    int k = RecyclerView.i.c(view);
                    int l = j1.topMargin;
                    return j1.bottomMargin + (k + l);
                }

                public final int d()
                {
                    return a.l();
                }

                public final int d(View view)
                {
                    RecyclerView.j j1 = (RecyclerView.j)view.getLayoutParams();
                    int k = RecyclerView.i.b(view);
                    int l = j1.leftMargin;
                    return j1.rightMargin + (k + l);
                }

                public final int e()
                {
                    return a.l() - a.n() - a.p();
                }

                public final int f()
                {
                    return a.p();
                }

            };
        }
    }

    public final int a()
    {
        if (0x80000000 == b)
        {
            return 0;
        } else
        {
            return e() - b;
        }
    }

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();
}
