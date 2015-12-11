// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.c.a.a.a.b;
import com.c.a.a.b.c;
import com.c.a.b.a.f;
import com.c.a.b.a.i;
import com.c.a.b.d.d;
import com.c.a.b.d.e;
import com.c.a.b.f.a;
import java.util.concurrent.Executor;

// Referenced classes of package com.c.a.b:
//            h, a, d

public final class g
{

    final Resources a;
    final int b;
    final int c;
    final int d;
    final int e;
    final android.graphics.Bitmap.CompressFormat f;
    final int g;
    final a h;
    final Executor i;
    final Executor j;
    final boolean k;
    final boolean l;
    final int m;
    final int n;
    final i o;
    final c p;
    final b q;
    final com.c.a.b.d.b r;
    final com.c.a.b.b.d s;
    final com.c.a.b.d t;
    final boolean u;
    final b v;
    final com.c.a.b.d.b w;
    final com.c.a.b.d.b x;

    private g(h h1)
    {
        a = com.c.a.b.h.a(h1).getResources();
        b = com.c.a.b.h.b(h1);
        c = com.c.a.b.h.c(h1);
        d = com.c.a.b.h.d(h1);
        e = com.c.a.b.h.e(h1);
        f = com.c.a.b.h.f(h1);
        g = com.c.a.b.h.g(h1);
        h = com.c.a.b.h.h(h1);
        i = com.c.a.b.h.i(h1);
        j = com.c.a.b.h.j(h1);
        m = com.c.a.b.h.k(h1);
        n = com.c.a.b.h.l(h1);
        o = com.c.a.b.h.m(h1);
        q = com.c.a.b.h.n(h1);
        p = com.c.a.b.h.o(h1);
        t = com.c.a.b.h.p(h1);
        u = com.c.a.b.h.q(h1);
        r = com.c.a.b.h.r(h1);
        s = com.c.a.b.h.s(h1);
        k = com.c.a.b.h.t(h1);
        l = com.c.a.b.h.u(h1);
        w = new d(r);
        x = new e(r);
        v = com.c.a.b.a.a(com.c.a.c.d.a(com.c.a.b.h.a(h1), false));
    }


    f a()
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
        return new f(i1, j1);
    }
}
