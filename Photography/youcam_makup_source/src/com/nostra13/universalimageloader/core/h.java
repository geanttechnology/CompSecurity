// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.nostra13.universalimageloader.b.d;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.assist.c;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.e.a;
import java.util.concurrent.Executor;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            i, j, k, d

public final class h
{

    final Resources a;
    final int b;
    final int c;
    final int d;
    final int e;
    final a f;
    final Executor g;
    final Executor h;
    final boolean i;
    final boolean j;
    final int k;
    final int l;
    final QueueProcessingType m;
    final com.nostra13.universalimageloader.a.b.a n;
    final com.nostra13.universalimageloader.a.a.a o;
    final ImageDownloader p;
    final com.nostra13.universalimageloader.core.a.d q;
    final com.nostra13.universalimageloader.core.d r;
    final ImageDownloader s;
    final ImageDownloader t;

    private h(i i1)
    {
        a = com.nostra13.universalimageloader.core.i.a(i1).getResources();
        b = com.nostra13.universalimageloader.core.i.b(i1);
        c = com.nostra13.universalimageloader.core.i.c(i1);
        d = com.nostra13.universalimageloader.core.i.d(i1);
        e = com.nostra13.universalimageloader.core.i.e(i1);
        f = com.nostra13.universalimageloader.core.i.f(i1);
        g = com.nostra13.universalimageloader.core.i.g(i1);
        h = com.nostra13.universalimageloader.core.i.h(i1);
        k = com.nostra13.universalimageloader.core.i.i(i1);
        l = com.nostra13.universalimageloader.core.i.j(i1);
        m = com.nostra13.universalimageloader.core.i.k(i1);
        o = com.nostra13.universalimageloader.core.i.l(i1);
        n = com.nostra13.universalimageloader.core.i.m(i1);
        r = com.nostra13.universalimageloader.core.i.n(i1);
        p = com.nostra13.universalimageloader.core.i.o(i1);
        q = com.nostra13.universalimageloader.core.i.p(i1);
        i = com.nostra13.universalimageloader.core.i.q(i1);
        j = com.nostra13.universalimageloader.core.i.r(i1);
        s = new j(p);
        t = new k(p);
        com.nostra13.universalimageloader.b.d.a(com.nostra13.universalimageloader.core.i.s(i1));
    }


    c a()
    {
        DisplayMetrics displaymetrics = a.getDisplayMetrics();
        int j1 = b;
        int i1 = j1;
        if (j1 <= 0)
        {
            i1 = displaymetrics.widthPixels;
        }
        int k1 = c;
        j1 = k1;
        if (k1 <= 0)
        {
            j1 = displaymetrics.heightPixels;
        }
        return new c(i1, j1);
    }

    // Unreferenced inner class com/nostra13/universalimageloader/core/h$1

/* anonymous class */
    class _cls1
    {

        static final int a[];

        static 
        {
            a = new int[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.values().length];
            try
            {
                a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.a.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                a[com.nostra13.universalimageloader.core.download.ImageDownloader.Scheme.b.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }

}
