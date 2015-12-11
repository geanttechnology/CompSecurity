// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


public final class bz extends Enum
{

    public static final bz a;
    public static final bz b;
    public static final bz c;
    public static final bz d;
    public static final bz e;
    public static final bz f;
    public static final bz g;
    public static final bz h;
    public static final bz i;
    public static final bz j;
    private static final bz k[];

    private bz(String s, int l)
    {
        super(s, l);
    }

    public static bz valueOf(String s)
    {
        return (bz)Enum.valueOf(com/tapjoy/internal/bz, s);
    }

    public static bz[] values()
    {
        return (bz[])k.clone();
    }

    static 
    {
        a = new bz("BEGIN_ARRAY", 0);
        b = new bz("END_ARRAY", 1);
        c = new bz("BEGIN_OBJECT", 2);
        d = new bz("END_OBJECT", 3);
        e = new bz("NAME", 4);
        f = new bz("STRING", 5);
        g = new bz("NUMBER", 6);
        h = new bz("BOOLEAN", 7);
        i = new bz("NULL", 8);
        j = new bz("END_DOCUMENT", 9);
        k = (new bz[] {
            a, b, c, d, e, f, g, h, i, j
        });
    }
}
