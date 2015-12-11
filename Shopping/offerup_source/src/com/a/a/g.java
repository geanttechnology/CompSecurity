// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


public final class g extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    private static final g h[];
    private String g;

    private g(String s, int i, String s1)
    {
        super(s, i);
        g = s1;
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/a/a/g, s);
    }

    public static g[] values()
    {
        return (g[])h.clone();
    }

    public final String a()
    {
        return g;
    }

    static 
    {
        a = new g("MERCHANT_CANCELLED", 0, "merchant_cancelled");
        b = new g("MERCHANT_SKIPPED", 1, "skipped");
        c = new g("PERMISSION_DENIED", 2, "permission_denied");
        d = new g("SERVICE_UNAVAILABLE", 3, "not_available");
        e = new g("TIMEOUT", 4, "timeout");
        f = new g("UNEXPECTED", 5, "unexpected");
        h = (new g[] {
            a, b, c, d, e, f
        });
    }
}
