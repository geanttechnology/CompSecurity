// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a;


public final class d extends Enum
{

    public static final d a;
    public static final d b;
    private static final d d[];
    public final int c;

    private d(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    public static d valueOf(String s)
    {
        return (d)Enum.valueOf(com/facebook/ads/a/d, s);
    }

    public static d[] values()
    {
        return (d[])d.clone();
    }

    static 
    {
        a = new d("ADS", 0, 0);
        b = new d("APP_OF_THE_DAY", 1, 1);
        d = (new d[] {
            a, b
        });
    }
}
