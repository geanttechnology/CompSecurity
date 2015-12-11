// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;


public final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e h[];
    public final int f;
    public final int g;

    private e(String s, int i, int j, int k)
    {
        super(s, i);
        f = j;
        g = k;
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/facebook/ads/e, s);
    }

    public static e[] values()
    {
        return (e[])h.clone();
    }

    public final int a()
    {
        return f;
    }

    public final int b()
    {
        return g;
    }

    static 
    {
        a = new e("BANNER_320_50", 0, 320, 50);
        b = new e("INTERSTITIAL", 1, 0, 0);
        c = new e("BANNER_HEIGHT_50", 2, -1, 50);
        d = new e("BANNER_HEIGHT_90", 3, -1, 90);
        e = new e("RECTANGLE_HEIGHT_250", 4, -1, 250);
        h = (new e[] {
            a, b, c, d, e
        });
    }
}
