// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ib extends Enum
{

    public static final ib a;
    public static final ib b;
    public static final ib c;
    public static final ib d;
    public static final ib e;
    public static final ib f;
    public static final ib g;
    public static final ib h;
    private static final ib i[];

    private ib(String s, int j)
    {
        super(s, j);
    }

    public static ib valueOf(String s)
    {
        return (ib)Enum.valueOf(com/flurry/sdk/ib, s);
    }

    public static ib[] values()
    {
        return (ib[])i.clone();
    }

    static 
    {
        a = new ib("ALL", 0);
        b = new ib("DEBUG", 1);
        c = new ib("ERROR", 2);
        d = new ib("FATAL", 3);
        e = new ib("INFO", 4);
        f = new ib("OFF", 5);
        g = new ib("TRACE", 6);
        h = new ib("WARN", 7);
        i = (new ib[] {
            a, b, c, d, e, f, g, h
        });
    }
}
