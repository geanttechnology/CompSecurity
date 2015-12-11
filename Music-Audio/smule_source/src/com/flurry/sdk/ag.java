// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ag extends Enum
{

    public static final ag a;
    public static final ag b;
    public static final ag c;
    private static final ag e[];
    private final int d;

    private ag(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static ag a(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;
        }
    }

    public static ag valueOf(String s)
    {
        return (ag)Enum.valueOf(com/flurry/sdk/ag, s);
    }

    public static ag[] values()
    {
        return (ag[])e.clone();
    }

    static 
    {
        a = new ag("STREAM_ONLY", 0, 0);
        b = new ag("CACHE_ONLY", 1, 1);
        c = new ag("CACHE_OR_STREAM", 2, 2);
        e = (new ag[] {
            a, b, c
        });
    }
}
