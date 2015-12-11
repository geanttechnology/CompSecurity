// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.b;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import com.facebook.ads.a.f.g;
import com.facebook.ads.a.f.u;
import java.lang.ref.WeakReference;

public final class j
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

    private static final class b extends u
    {

        public final void run()
        {
            j j1;
            j1 = (j)super.a.get();
            break MISSING_BLOCK_LABEL_11;
            if (j1 != null && (j1.i || !j1.j))
            {
                View view = j1.d;
                a a1 = j1.f;
                if (view != null && a1 != null)
                {
                    if (com.facebook.ads.a.f.g.a(j1.c, view, j1.e))
                    {
                        a1.a();
                        j1.j = true;
                        return;
                    } else
                    {
                        a1.b();
                        j1.g.postDelayed(j1.h, j1.b);
                        return;
                    }
                }
            }
            return;
        }

        public b(j j1)
        {
            super(j1);
        }
    }


    public int a;
    public int b;
    final Context c;
    final View d;
    final int e;
    final a f;
    final Handler g;
    final Runnable h;
    final boolean i;
    volatile boolean j;

    public j(Context context, View view, int k, a a1)
    {
        this(context, view, k, false, a1);
    }

    public j(Context context, View view, int k, boolean flag, a a1)
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

    public final void a()
    {
        if (!i && !j)
        {
            g.postDelayed(h, a);
        }
    }

    public final void b()
    {
        g.removeCallbacks(h);
    }
}
