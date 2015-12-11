// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


final class > extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];

    public static > valueOf(String s)
    {
        return (>)Enum.valueOf(com/flurry/sdk/ch$a, s);
    }

    public static Of[] values()
    {
        return (Of[])h.clone();
    }

    static 
    {
        a = new <init>("NONE", 0);
        b = new <init>("REQUEST", 1);
        c = new <init>("CSRTB_AUCTION_REQUIRED", 2);
        d = new <init>("CSRTB_AWAIT_AUCTION", 3);
        e = new <init>("SELECT", 4);
        f = new <init>("PREPARE", 5);
        g = new <init>("PRERENDER", 6);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
