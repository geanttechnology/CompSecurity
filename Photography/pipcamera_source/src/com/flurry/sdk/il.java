// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class il extends Enum
{

    public static final il a;
    public static final il b;
    public static final il c;
    public static final il d;
    private static final il f[];
    private int e;

    private il(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static il a(int i)
    {
        switch (i)
        {
        default:
            return null;

        case 1: // '\001'
            return a;

        case 2: // '\002'
            return b;

        case 3: // '\003'
            return c;

        case 4: // '\004'
            return d;
        }
    }

    public static il valueOf(String s)
    {
        return (il)Enum.valueOf(com/flurry/sdk/il, s);
    }

    public static il[] values()
    {
        return (il[])f.clone();
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new il("COMPLETE", 0, 1);
        b = new il("TIMEOUT", 1, 2);
        c = new il("INVALID_RESPONSE", 2, 3);
        d = new il("PENDING_COMPLETION", 3, 4);
        f = (new il[] {
            a, b, c, d
        });
    }
}
