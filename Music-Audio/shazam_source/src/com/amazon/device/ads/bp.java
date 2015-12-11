// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.Locale;

final class bp extends Enum
{

    public static final bp a;
    public static final bp b;
    public static final bp c;
    private static final bp d[];

    private bp(String s, int i)
    {
        super(s, i);
    }

    public static bp valueOf(String s)
    {
        return (bp)Enum.valueOf(com/amazon/device/ads/bp, s);
    }

    public static bp[] values()
    {
        return (bp[])d.clone();
    }

    public final String toString()
    {
        return name().toLowerCase(Locale.US);
    }

    static 
    {
        a = new bp("PORTRAIT", 0);
        b = new bp("LANDSCAPE", 1);
        c = new bp("NONE", 2);
        d = (new bp[] {
            a, b, c
        });
    }
}
