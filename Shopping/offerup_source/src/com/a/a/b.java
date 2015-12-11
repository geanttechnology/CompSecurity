// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    private static b e;
    private static final b g[];
    private String f;

    private b(String s, int i, String s1)
    {
        super(s, i);
        f = s1;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/a/a/b, s);
    }

    public static b[] values()
    {
        return (b[])g.clone();
    }

    public final String a()
    {
        return f;
    }

    static 
    {
        a = new b("MAC_ADDRESS", 0, "collector_mac_addrs");
        b = new b("WEB", 1, "collector_web");
        c = new b("DEVICE_COOKIE", 2, "collector_device_cookie");
        e = new b("USER_COOKIE", 3, "collector_user_cookie");
        d = new b("GEO_LOCATION", 4, "collector_geo_loc");
        g = (new b[] {
            a, b, c, e, d
        });
    }
}
