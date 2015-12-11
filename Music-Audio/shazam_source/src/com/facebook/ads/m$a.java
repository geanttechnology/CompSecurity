// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;


// Referenced classes of package com.facebook.ads:
//            m

public static final class f extends Enum
{

    public static final d a;
    public static final d b;
    public static final d c;
    public static final d d;
    private static final d g[];
    private final int e = -1;
    private final int f;

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/facebook/ads/m$a, s);
    }

    public static f[] values()
    {
        return (f[])g.clone();
    }

    public final int a()
    {
        switch (f)
        {
        default:
            return -1;

        case 100: // 'd'
            return 1;

        case 120: // 'x'
            return 2;

        case 300: 
            return 3;

        case 400: 
            return 4;
        }
    }

    static 
    {
        a = new <init>("HEIGHT_100", 0, 100);
        b = new <init>("HEIGHT_120", 1, 120);
        c = new <init>("HEIGHT_300", 2, 300);
        d = new <init>("HEIGHT_400", 3, 400);
        g = (new g[] {
            a, b, c, d
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        f = j;
    }
}
