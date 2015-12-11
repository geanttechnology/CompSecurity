// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class an extends Enum
{

    public static final an a;
    public static final an b;
    public static final an c;
    public static final an d;
    private static final an f[];
    private final int e;

    private an(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static an a(int i)
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

        case 3: // '\003'
            return d;
        }
    }

    public static an valueOf(String s)
    {
        return (an)Enum.valueOf(com/flurry/sdk/an, s);
    }

    public static an[] values()
    {
        return (an[])f.clone();
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new an("UNKNOWN", 0, 0);
        b = new an("VIDEO", 1, 1);
        c = new an("IMAGE", 2, 2);
        d = new an("TEXT", 3, 3);
        f = (new an[] {
            a, b, c, d
        });
    }
}
