// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            v

public static final class f extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e h[];
    final String f;
    private final String g;

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/amazon/device/ads/v$a, s);
    }

    public static f[] values()
    {
        return (f[])h.clone();
    }

    public final String toString()
    {
        return g;
    }

    static 
    {
        a = new <init>("IMAGE_BANNER", 0, "Image Banner");
        b = new <init>("MRAID_1", 1, "MRAID 1.0");
        c = new <init>("MRAID_2", 2, "MRAID 2.0");
        d = new <init>("INTERSTITIAL", 3, "Interstitial", "i");
        e = new <init>("MODELESS_INTERSTITIAL", 4, "Modeless Interstitial", "mi");
        h = (new h[] {
            a, b, c, d, e
        });
    }

    private (String s, int i, String s1)
    {
        this(s, i, s1, null);
    }

    private <init>(String s, int i, String s1, String s2)
    {
        super(s, i);
        g = s1;
        f = s2;
    }
}
