// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import java.util.Map;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.ads.conversiontracking:
//            j

public static class 
{

    private String a;
    private boolean b;
    private boolean c;
    private f d;
    private String e;
    private String f;
    private f g;
    private Map h;
    private String i;
    private long j;
    private boolean k;

    static boolean a( )
    {
        return .c;
    }

    static c b(c c1)
    {
        return c1.d;
    }

    static String c(d d1)
    {
        return d1.a;
    }

    static String d(a a1)
    {
        return a1.f;
    }

    static Map e(f f1)
    {
        return f1.h;
    }

    static h f(h h1)
    {
        return h1.g;
    }

    static String g(g g1)
    {
        return g1.e;
    }

    static long h(e e1)
    {
        return e1.j;
    }

    static boolean i(j j1)
    {
        return j1.k;
    }

    static boolean j(k k1)
    {
        return k1.b;
    }

    static String k(b b1)
    {
        return b1.i;
    }

    public i a()
    {
        k = true;
        return this;
    }

    public k a(long l)
    {
        j = TimeUnit.MILLISECONDS.toSeconds(l);
        return this;
    }

    public s a(s s)
    {
        g = s;
        return this;
    }

    public g a(g g1)
    {
        d = g1;
        return this;
    }

    public d a(String s)
    {
        a = s;
        return this;
    }

    public a a(boolean flag)
    {
        b = flag;
        return this;
    }

    public b b(String s)
    {
        e = s;
        return this;
    }

    public e c(String s)
    {
        f = s;
        return this;
    }

    public ()
    {
    }
}
