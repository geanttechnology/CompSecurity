// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            gh, gu, gg, gq, 
//            gp, ge, gw

public final class gv
{

    private gq a;
    private gp b;
    private int c;
    private String d;
    private ge e;
    private gh f;
    private gw g;
    private gu h;
    private gu i;
    private gu j;

    public gv()
    {
        c = -1;
        f = new gh();
    }

    private gv(gu gu1)
    {
        c = -1;
        a = gu.a(gu1);
        b = gu.b(gu1);
        c = gu.c(gu1);
        d = gu.d(gu1);
        e = gu.e(gu1);
        f = gu.f(gu1).b();
        g = gu.g(gu1);
        h = gu.h(gu1);
        i = gu.i(gu1);
        j = gu.j(gu1);
    }

    gv(gu gu1, byte byte0)
    {
        this(gu1);
    }

    static gq a(gv gv1)
    {
        return gv1.a;
    }

    private static void a(String s, gu gu1)
    {
        if (gu.g(gu1) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".body != null").toString());
        }
        if (gu.h(gu1) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".networkResponse != null").toString());
        }
        if (gu.i(gu1) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".cacheResponse != null").toString());
        }
        if (gu.j(gu1) != null)
        {
            throw new IllegalArgumentException((new StringBuilder()).append(s).append(".priorResponse != null").toString());
        } else
        {
            return;
        }
    }

    static gp b(gv gv1)
    {
        return gv1.b;
    }

    static int c(gv gv1)
    {
        return gv1.c;
    }

    static String d(gv gv1)
    {
        return gv1.d;
    }

    static ge e(gv gv1)
    {
        return gv1.e;
    }

    static gh f(gv gv1)
    {
        return gv1.f;
    }

    static gw g(gv gv1)
    {
        return gv1.g;
    }

    static gu h(gv gv1)
    {
        return gv1.h;
    }

    static gu i(gv gv1)
    {
        return gv1.i;
    }

    static gu j(gv gv1)
    {
        return gv1.j;
    }

    public final gu a()
    {
        if (a == null)
        {
            throw new IllegalStateException("request == null");
        }
        if (b == null)
        {
            throw new IllegalStateException("protocol == null");
        }
        if (c < 0)
        {
            throw new IllegalStateException((new StringBuilder("code < 0: ")).append(c).toString());
        } else
        {
            return new gu(this, (byte)0);
        }
    }

    public final gv a(int k)
    {
        c = k;
        return this;
    }

    public final gv a(ge ge)
    {
        e = ge;
        return this;
    }

    public final gv a(gg gg1)
    {
        f = gg1.b();
        return this;
    }

    public final gv a(gp gp)
    {
        b = gp;
        return this;
    }

    public final gv a(gq gq)
    {
        a = gq;
        return this;
    }

    public final gv a(gu gu1)
    {
        if (gu1 != null)
        {
            a("networkResponse", gu1);
        }
        h = gu1;
        return this;
    }

    public final gv a(gw gw)
    {
        g = gw;
        return this;
    }

    public final gv a(String s)
    {
        d = s;
        return this;
    }

    public final gv a(String s, String s1)
    {
        f.b(s, s1);
        return this;
    }

    public final gv b(gu gu1)
    {
        if (gu1 != null)
        {
            a("cacheResponse", gu1);
        }
        i = gu1;
        return this;
    }

    public final gv b(String s, String s1)
    {
        f.a(s, s1);
        return this;
    }

    public final gv c(gu gu1)
    {
        if (gu1 != null && gu.g(gu1) != null)
        {
            throw new IllegalArgumentException("priorResponse.body != null");
        } else
        {
            j = gu1;
            return this;
        }
    }
}
