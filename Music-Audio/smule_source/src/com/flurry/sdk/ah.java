// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ah extends Enum
{

    public static final ah a;
    public static final ah b;
    public static final ah c;
    public static final ah d;
    public static final ah e;
    public static final ah f;
    public static final ah g;
    private static final ah i[];
    private final int h;

    private ah(String s, int j, int k)
    {
        super(s, j);
        h = k;
    }

    public static ah a(int j)
    {
        switch (j)
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

        case 4: // '\004'
            return e;

        case 5: // '\005'
            return f;

        case 6: // '\006'
            return g;
        }
    }

    public static ah valueOf(String s)
    {
        return (ah)Enum.valueOf(com/flurry/sdk/ah, s);
    }

    public static ah[] values()
    {
        return (ah[])i.clone();
    }

    public int a()
    {
        return h;
    }

    static 
    {
        a = new ah("NONE", 0, 0);
        b = new ah("QUEUED", 1, 1);
        c = new ah("IN_PROGRESS", 2, 2);
        d = new ah("COMPLETE", 3, 3);
        e = new ah("CANCELLED", 4, 4);
        f = new ah("EVICTED", 5, 5);
        g = new ah("ERROR", 6, 6);
        i = (new ah[] {
            a, b, c, d, e, f, g
        });
    }
}
