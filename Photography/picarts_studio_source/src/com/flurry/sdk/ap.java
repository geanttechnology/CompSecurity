// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ap extends Enum
{

    public static final ap a;
    public static final ap b;
    public static final ap c;
    public static final ap d;
    private static final ap f[];
    private final int e;

    private ap(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static ap a(int i)
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

    public static ap valueOf(String s)
    {
        return (ap)Enum.valueOf(com/flurry/sdk/ap, s);
    }

    public static ap[] values()
    {
        return (ap[])f.clone();
    }

    public final int a()
    {
        return e;
    }

    static 
    {
        a = new ap("UNKNOWN", 0, 0);
        b = new ap("VIDEO", 1, 1);
        c = new ap("IMAGE", 2, 2);
        d = new ap("TEXT", 3, 3);
        f = (new ap[] {
            a, b, c, d
        });
    }
}
