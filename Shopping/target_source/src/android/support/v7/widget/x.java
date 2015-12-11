// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

public abstract class x
{

    protected final RecyclerView.h a;
    private int b;

    private x(RecyclerView.h h)
    {
        b = 0x80000000;
        a = h;
    }


    public static x a(RecyclerView.h h)
    {
        return new x(h) {

            public int a(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                return a.g(view) - i.leftMargin;
            }

            public void a(int i)
            {
                a.h(i);
            }

            public int b(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                int j = a.i(view);
                return i.rightMargin + j;
            }

            public int c()
            {
                return a.r();
            }

            public int c(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                int j = a.e(view);
                int k = i.leftMargin;
                return i.rightMargin + (j + k);
            }

            public int d()
            {
                return a.p() - a.t();
            }

            public int d(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                int j = a.f(view);
                int k = i.topMargin;
                return i.bottomMargin + (j + k);
            }

            public int e()
            {
                return a.p();
            }

            public int f()
            {
                return a.p() - a.r() - a.t();
            }

            public int g()
            {
                return a.t();
            }

        };
    }

    public static x a(RecyclerView.h h, int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("invalid orientation");

        case 0: // '\0'
            return a(h);

        case 1: // '\001'
            return b(h);
        }
    }

    public static x b(RecyclerView.h h)
    {
        return new x(h) {

            public int a(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                return a.h(view) - i.topMargin;
            }

            public void a(int i)
            {
                a.i(i);
            }

            public int b(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                int j = a.j(view);
                return i.bottomMargin + j;
            }

            public int c()
            {
                return a.s();
            }

            public int c(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                int j = a.f(view);
                int k = i.topMargin;
                return i.bottomMargin + (j + k);
            }

            public int d()
            {
                return a.q() - a.u();
            }

            public int d(View view)
            {
                RecyclerView.i i = (RecyclerView.i)view.getLayoutParams();
                int j = a.e(view);
                int k = i.leftMargin;
                return i.rightMargin + (j + k);
            }

            public int e()
            {
                return a.q();
            }

            public int f()
            {
                return a.q() - a.s() - a.u();
            }

            public int g()
            {
                return a.u();
            }

        };
    }

    public abstract int a(View view);

    public void a()
    {
        b = f();
    }

    public abstract void a(int i);

    public int b()
    {
        if (0x80000000 == b)
        {
            return 0;
        } else
        {
            return f() - b;
        }
    }

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();

    public abstract int g();
}
