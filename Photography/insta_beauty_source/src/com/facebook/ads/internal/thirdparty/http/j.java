// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.thirdparty.http;


public final class j extends Enum
{

    public static final j a;
    public static final j b;
    private static final j e[];
    private boolean c;
    private boolean d;

    private j(String s, int i, boolean flag, boolean flag1)
    {
        super(s, i);
        c = flag;
        d = flag1;
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/facebook/ads/internal/thirdparty/http/j, s);
    }

    public static j[] values()
    {
        return (j[])e.clone();
    }

    public boolean a()
    {
        return c;
    }

    public boolean b()
    {
        return d;
    }

    public String c()
    {
        return toString();
    }

    static 
    {
        a = new j("GET", 0, true, false);
        b = new j("POST", 1, true, true);
        e = (new j[] {
            a, b
        });
    }
}
