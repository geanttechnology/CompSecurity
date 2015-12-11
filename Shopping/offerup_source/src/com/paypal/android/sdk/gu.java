// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Collections;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            gv, gh, gg, jz, 
//            fo, gq, gp, ge, 
//            gw

public final class gu
{

    private final gq a;
    private final gp b;
    private final int c;
    private final String d;
    private final ge e;
    private final gg f;
    private final gw g;
    private gu h;
    private gu i;
    private final gu j;
    private volatile fo k;

    private gu(gv gv1)
    {
        a = gv.a(gv1);
        b = gv.b(gv1);
        c = gv.c(gv1);
        d = gv.d(gv1);
        e = gv.e(gv1);
        f = gv.f(gv1).a();
        g = gv.g(gv1);
        h = gv.h(gv1);
        i = gv.i(gv1);
        j = gv.j(gv1);
    }

    gu(gv gv1, byte byte0)
    {
        this(gv1);
    }

    static gq a(gu gu1)
    {
        return gu1.a;
    }

    static gp b(gu gu1)
    {
        return gu1.b;
    }

    static int c(gu gu1)
    {
        return gu1.c;
    }

    static String d(gu gu1)
    {
        return gu1.d;
    }

    static ge e(gu gu1)
    {
        return gu1.e;
    }

    static gg f(gu gu1)
    {
        return gu1.f;
    }

    static gw g(gu gu1)
    {
        return gu1.g;
    }

    static gu h(gu gu1)
    {
        return gu1.h;
    }

    static gu i(gu gu1)
    {
        return gu1.i;
    }

    static gu j(gu gu1)
    {
        return gu1.j;
    }

    public final gq a()
    {
        return a;
    }

    public final String a(String s)
    {
        s = f.a(s);
        if (s != null)
        {
            return s;
        } else
        {
            return null;
        }
    }

    public final gp b()
    {
        return b;
    }

    public final int c()
    {
        return c;
    }

    public final boolean d()
    {
        return c >= 200 && c < 300;
    }

    public final String e()
    {
        return d;
    }

    public final ge f()
    {
        return e;
    }

    public final gg g()
    {
        return f;
    }

    public final gw h()
    {
        return g;
    }

    public final gv i()
    {
        return new gv(this, (byte)0);
    }

    public final List j()
    {
        String s;
        if (c == 401)
        {
            s = "WWW-Authenticate";
        } else
        if (c == 407)
        {
            s = "Proxy-Authenticate";
        } else
        {
            return Collections.emptyList();
        }
        return jz.a(f, s);
    }

    public final fo k()
    {
        fo fo1 = k;
        if (fo1 != null)
        {
            return fo1;
        } else
        {
            fo fo2 = fo.a(f);
            k = fo2;
            return fo2;
        }
    }

    public final String toString()
    {
        return (new StringBuilder("Response{protocol=")).append(b).append(", code=").append(c).append(", message=").append(d).append(", url=").append(a.c()).append('}').toString();
    }
}
