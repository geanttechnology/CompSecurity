// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


public final class q extends Enum
{

    public static final q a;
    public static final q b;
    private static final q d[];
    final int c;

    private q(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    static boolean a(int i)
    {
        return (a.c & i) == 0;
    }

    static boolean b(int i)
    {
        return (b.c & i) == 0;
    }

    public static q valueOf(String s)
    {
        return (q)Enum.valueOf(com/g/c/q, s);
    }

    public static q[] values()
    {
        return (q[])d.clone();
    }

    static 
    {
        a = new q("NO_CACHE", 0, 1);
        b = new q("NO_STORE", 1, 2);
        d = (new q[] {
            a, b
        });
    }
}
