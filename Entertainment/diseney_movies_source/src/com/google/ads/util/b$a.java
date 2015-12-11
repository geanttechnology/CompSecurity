// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.util;


// Referenced classes of package com.google.ads.util:
//            b

public static final class f extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e g[];
    public final int f;

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/google/ads/util/b$a, s);
    }

    public static f[] values()
    {
        return (f[])g.clone();
    }

    static 
    {
        a = new <init>("VERBOSE", 0, 2);
        b = new <init>("DEBUG", 1, 3);
        c = new <init>("INFO", 2, 4);
        d = new <init>("WARN", 3, 5);
        e = new <init>("ERROR", 4, 6);
        g = (new g[] {
            a, b, c, d, e
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        f = j;
    }
}
