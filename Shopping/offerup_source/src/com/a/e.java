// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a;


public final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    public static final e f;
    public static final e g;
    public static final e h;
    public static final e i;
    public static final e j;
    public static final e k;
    public static final e l;
    public static final e m;
    private static e n;
    private static final e p[];
    private String o;

    private e(String s, int i1, String s1)
    {
        super(s, i1);
        o = s1;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/a/e, s);
    }

    public static e[] values()
    {
        return (e[])p.clone();
    }

    public final String a()
    {
        return o;
    }

    static 
    {
        a = new e("LATITUDE", 0, "lat");
        b = new e("LONGITUDE", 1, "lon");
        c = new e("GEO_DATE", 2, "ltm");
        d = new e("GEO_PROVIDER", 3, "lpv");
        e = new e("OLD_DEVICE_COOKIE", 4, "odc");
        f = new e("DEVICE_COOKIE", 5, "dc");
        n = new e("USER_COOKIE", 6, "uc");
        g = new e("OS_VERSION", 7, "os");
        h = new e("SDK_VERSION", 8, "sv");
        i = new e("SDK_TYPE", 9, "st");
        j = new e("MOBILE_MODEL", 10, "mdl");
        k = new e("ERROR_LIST", 11, "err");
        l = new e("MERCHANT_ID", 12, "m");
        m = new e("SESSION_ID", 13, "s");
        p = (new e[] {
            a, b, c, d, e, f, n, g, h, i, 
            j, k, l, m
        });
    }
}
