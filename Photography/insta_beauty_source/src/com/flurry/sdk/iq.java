// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class iq extends Enum
{

    public static final iq a;
    public static final iq b;
    public static final iq c;
    private static final iq f[];
    String d;
    int e;

    private iq(String s, int i, String s1, int j)
    {
        super(s, i);
        d = s1;
        e = j;
    }

    public static iq a(int i)
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

    public static iq valueOf(String s)
    {
        return (iq)Enum.valueOf(com/flurry/sdk/iq, s);
    }

    public static iq[] values()
    {
        return (iq[])f.clone();
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new iq("GET", 0, "GET", 0);
        b = new iq("PUT", 1, "PUT", 1);
        c = new iq("POST", 2, "POST", 2);
        f = (new iq[] {
            a, b, c
        });
    }
}
