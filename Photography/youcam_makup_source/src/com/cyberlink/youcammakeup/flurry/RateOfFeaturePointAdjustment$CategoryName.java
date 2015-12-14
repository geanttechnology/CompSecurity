// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.flurry;


public final class Q extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(com/cyberlink/youcammakeup/flurry/RateOfFeaturePointAdjustment$CategoryName, s);
    }

    public static Q[] values()
    {
        return (Q[])h.clone();
    }

    static 
    {
        a = new <init>("Eye", 0);
        b = new <init>("Nose", 1);
        c = new <init>("Shape", 2);
        d = new <init>("Ear", 3);
        e = new <init>("Chin", 4);
        f = new <init>("Mouth", 5);
        g = new <init>("EyeBrow", 6);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
