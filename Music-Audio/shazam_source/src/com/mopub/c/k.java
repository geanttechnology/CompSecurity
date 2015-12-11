// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.c.a;
import com.mopub.common.m;
import com.mopub.d.l;
import java.util.Map;

// Referenced classes of package com.mopub.c:
//            i, h, c

public abstract class k
{
    public static interface a
    {
    }


    protected l a;
    protected a b;
    protected c c;
    protected Handler d;

    public k(Looper looper)
    {
        d = new Handler(looper);
    }

    abstract l a();

    public final void a(a a1, c c1)
    {
        m.a(a1);
        m.a(c1);
        h h1 = com.mopub.c.i.a();
        if (h1 != null && a != null)
        {
            h1.a(a);
        }
        d();
        b = a1;
        c = c1;
        c();
    }

    public final boolean b()
    {
        return a != null;
    }

    final void c()
    {
        a = a();
        h h1 = com.mopub.c.i.a();
        if (h1 == null)
        {
            com.mopub.common.c.a.b("MoPubRequest queue is null. Clearing request.");
            d();
            return;
        }
        if (c.b() == 0)
        {
            h1.b(a);
            return;
        }
        l l = a;
        int j = c.a();
        m.a(l);
        h.a a1 = new h.a(h1, l, j);
        m.a(a1);
        if (h1.a.containsKey(l))
        {
            h1.a(l);
        }
        a1.b.postDelayed(a1.c, a1.a);
        h1.a.put(l, a1);
    }

    final void d()
    {
        a = null;
        b = null;
        c = null;
    }
}
