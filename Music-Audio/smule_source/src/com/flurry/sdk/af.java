// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class af extends Enum
{

    public static final af a;
    public static final af b;
    public static final af c;
    public static final af d;
    public static final af e;
    public static final af f;
    private static final af h[];
    private final int g;

    private af(String s, int i, int j)
    {
        super(s, i);
        g = j;
    }

    public static af valueOf(String s)
    {
        return (af)Enum.valueOf(com/flurry/sdk/af, s);
    }

    public static af[] values()
    {
        return (af[])h.clone();
    }

    static 
    {
        a = new af("NOT_STARTED", 0, 0);
        b = new af("IN_PROGRESS", 1, 1);
        c = new af("INCOMPLETE", 2, 2);
        d = new af("COMPLETE", 3, 3);
        e = new af("EVICTED", 4, 4);
        f = new af("ERROR", 5, 5);
        h = (new af[] {
            a, b, c, d, e, f
        });
    }
}
