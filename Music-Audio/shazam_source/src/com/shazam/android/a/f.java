// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.a;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Comparator;

public final class f extends android.support.v7.widget.RecyclerView.a
{
    public static final class a
    {

        public int a;
        public int b;
        CharSequence c;

        public a(int i, CharSequence charsequence)
        {
            a = i;
            c = charsequence;
        }
    }

    public static final class b extends android.support.v7.widget.RecyclerView.u
    {

        public TextView l;

        public b(View view, int i)
        {
            super(view);
            l = (TextView)view.findViewById(i);
        }
    }


    final android.support.v7.widget.RecyclerView.a c;
    public final SparseArray d = new SparseArray();
    boolean e;
    private final Context f;
    private final int g = 0x7f0300b0;
    private final int h = 0x7f110273;

    public f(Context context, android.support.v7.widget.RecyclerView.a a1)
    {
        e = true;
        c = a1;
        f = context;
        c.a(new android.support.v7.widget.RecyclerView.c() {

            final f a;

            public final void a()
            {
                f f1 = a;
                boolean flag;
                if (a.c.a() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f1.e = flag;
                ((android.support.v7.widget.RecyclerView.a) (a)).a.a();
            }

            public final void a(int i, int j)
            {
                f f1 = a;
                boolean flag;
                if (a.c.a() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f1.e = flag;
                ((android.support.v7.widget.RecyclerView.a) (a)).a.a(i, j);
            }

            public final void b(int i, int j)
            {
                f f1 = a;
                boolean flag;
                if (a.c.a() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f1.e = flag;
                a.a(i, j);
            }

            public final void c(int i, int j)
            {
                f f1 = a;
                boolean flag;
                if (a.c.a() > 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                f1.e = flag;
                a.b(i, j);
            }

            
            {
                a = f.this;
                super();
            }
        });
    }

    private int d(int i)
    {
        if (e(i))
        {
            return -1;
        }
        int j = 0;
        int k = 0;
        for (; j < d.size() && ((a)d.valueAt(j)).b <= i; j++)
        {
            k--;
        }

        return i + k;
    }

    private boolean e(int i)
    {
        return d.get(i) != null;
    }

    public final int a()
    {
        if (e)
        {
            return c.a() + d.size();
        } else
        {
            return 0;
        }
    }

    public final int a(int i)
    {
        if (e(i))
        {
            return 0;
        } else
        {
            return c.a(d(i)) + 1;
        }
    }

    public final android.support.v7.widget.RecyclerView.u a(ViewGroup viewgroup, int i)
    {
        if (i == 0)
        {
            return new b(LayoutInflater.from(f).inflate(g, viewgroup, false), h);
        } else
        {
            return c.a(viewgroup, i - 1);
        }
    }

    public final void a(android.support.v7.widget.RecyclerView.u u, int i)
    {
        if (e(i))
        {
            ((b)u).l.setText(((a)d.get(i)).c);
            return;
        } else
        {
            c.a(u, d(i));
            return;
        }
    }

    public final long b(int i)
    {
        if (e(i))
        {
            return (long)(0x7fffffff - d.indexOfKey(i));
        } else
        {
            return c.b(d(i));
        }
    }

    // Unreferenced inner class com/shazam/android/a/f$2

/* anonymous class */
    public final class _cls2
        implements Comparator
    {

        final f a;

        public final volatile int compare(Object obj, Object obj1)
        {
            obj = (a)obj;
            obj1 = (a)obj1;
            if (((a) (obj)).a == ((a) (obj1)).a)
            {
                return 0;
            }
            return ((a) (obj)).a >= ((a) (obj1)).a ? 1 : -1;
        }

            public 
            {
                a = f.this;
                super();
            }
    }

}
