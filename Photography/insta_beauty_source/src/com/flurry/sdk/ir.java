// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class ir extends Enum
{

    public static final ir a;
    public static final ir b;
    public static final ir c;
    public static final ir d;
    private static final ir f[];
    private int e;

    private ir(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static ir a(int i)
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

    public static ir valueOf(String s)
    {
        return (ir)Enum.valueOf(com/flurry/sdk/ir, s);
    }

    public static ir[] values()
    {
        return (ir[])f.clone();
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new ir("INSTALL", 0, 1);
        b = new ir("SESSION_START", 1, 2);
        c = new ir("SESSION_END", 2, 3);
        d = new ir("APPLICATION_EVENT", 3, 4);
        f = (new ir[] {
            a, b, c, d
        });
    }
}
