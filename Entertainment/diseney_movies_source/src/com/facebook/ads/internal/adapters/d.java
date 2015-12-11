// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.internal.util.g;
import com.facebook.ads.internal.util.t;

public class d
{
    public static abstract class a
    {

        public abstract void a();

        public void b()
        {
        }

        public a()
        {
        }
    }

    private static final class b extends t
    {

        public void run()
        {
            d d1;
            d1 = (d)a();
            break MISSING_BLOCK_LABEL_8;
            if (d1 != null && (d.a(d1) || !d.b(d1)))
            {
                View view = d.c(d1);
                a a1 = d.d(d1);
                if (view != null && a1 != null)
                {
                    if (com.facebook.ads.internal.util.g.a(d.e(d1), view, d.f(d1)))
                    {
                        a1.a();
                        d.a(d1, true);
                        return;
                    } else
                    {
                        a1.b();
                        d.i(d1).postDelayed(com.facebook.ads.internal.adapters.d.g(d1), d.h(d1));
                        return;
                    }
                }
            }
            return;
        }

        public b(d d1)
        {
            super(d1);
        }
    }


    private int a;
    private int b;
    private final Context c;
    private final View d;
    private final int e;
    private final a f;
    private final Handler g;
    private final Runnable h;
    private final boolean i;
    private volatile boolean j;

    public d(Context context, View view, int k, a a1)
    {
        this(context, view, k, false, a1);
    }

    public d(Context context, View view, int k, boolean flag, a a1)
    {
        a = 0;
        b = 1000;
        g = new Handler();
        h = new b(this);
        c = context;
        d = view;
        e = k;
        f = a1;
        i = flag;
    }

    static boolean a(d d1)
    {
        return d1.i;
    }

    static boolean a(d d1, boolean flag)
    {
        d1.j = flag;
        return flag;
    }

    static boolean b(d d1)
    {
        return d1.j;
    }

    static View c(d d1)
    {
        return d1.d;
    }

    static a d(d d1)
    {
        return d1.f;
    }

    static Context e(d d1)
    {
        return d1.c;
    }

    static int f(d d1)
    {
        return d1.e;
    }

    static Runnable g(d d1)
    {
        return d1.h;
    }

    static int h(d d1)
    {
        return d1.b;
    }

    static Handler i(d d1)
    {
        return d1.g;
    }

    public void a()
    {
        if (!i && !j)
        {
            g.postDelayed(h, a);
        }
    }

    public void a(int k)
    {
        a = k;
    }

    public void b()
    {
        g.removeCallbacks(h);
    }

    public void b(int k)
    {
        b = k;
    }
}
