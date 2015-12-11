// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.core;


public final class p extends Enum
{

    public static final p a;
    public static final p b;
    public static final p c;
    public static final p d;
    public static final p e;
    public static final p f;
    public static final p g;
    private static final p h[];

    private p(String s, int i)
    {
        super(s, i);
    }

    public static p valueOf(String s)
    {
        return (p)Enum.valueOf(com/smule/android/network/core/p, s);
    }

    public static p[] values()
    {
        return (p[])h.clone();
    }

    static 
    {
        a = new p("OK", 0);
        b = new p("CONNECTION_TIMEOUT", 1);
        c = new p("UNKNOWN_HOST", 2);
        d = new p("FAILURE", 3);
        e = new p("UNINITIALIZED", 4);
        f = new p("CALL_CANCELED", 5);
        g = new p("SERVER_MAINTENANCE", 6);
        h = (new p[] {
            a, b, c, d, e, f, g
        });
    }
}
