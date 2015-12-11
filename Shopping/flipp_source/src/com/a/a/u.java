// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


public final class u extends Enum
{

    public static final u a;
    public static final u b;
    public static final u c;
    private static final u d[];

    private u(String s, int i)
    {
        super(s, i);
    }

    public static u valueOf(String s)
    {
        return (u)Enum.valueOf(com/a/a/u, s);
    }

    public static u[] values()
    {
        return (u[])d.clone();
    }

    public final boolean a()
    {
        return this == b || this == c;
    }

    static 
    {
        a = new u("CACHE", 0);
        b = new u("CONDITIONAL_CACHE", 1);
        c = new u("NETWORK", 2);
        d = (new u[] {
            a, b, c
        });
    }
}
