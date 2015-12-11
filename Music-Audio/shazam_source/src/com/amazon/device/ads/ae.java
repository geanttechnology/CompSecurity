// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


public final class ae extends Enum
{

    public static final ae a;
    public static final ae b;
    public static final ae c;
    public static final ae d;
    public static final ae e;
    public static final ae f;
    public static final ae g;
    public static final ae h;
    public static final ae i;
    public static final ae j;
    public static final ae k;
    private static final ae l[];

    private ae(String s, int i1)
    {
        super(s, i1);
    }

    public static ae valueOf(String s)
    {
        return (ae)Enum.valueOf(com/amazon/device/ads/ae, s);
    }

    public static ae[] values()
    {
        return (ae[])l.clone();
    }

    static 
    {
        a = new ae("READY_TO_LOAD", 0);
        b = new ae("LOADING", 1);
        c = new ae("LOADED", 2);
        d = new ae("RENDERING", 3);
        e = new ae("RENDERED", 4);
        f = new ae("DRAWING", 5);
        g = new ae("SHOWING", 6);
        h = new ae("EXPANDED", 7);
        i = new ae("HIDDEN", 8);
        j = new ae("INVALID", 9);
        k = new ae("DESTROYED", 10);
        l = (new ae[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }
}
