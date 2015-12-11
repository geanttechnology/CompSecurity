// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.c;


public final class r extends Enum
{

    public static final r a;
    public static final r b;
    public static final r c;
    private static final r e[];
    final int d;

    private r(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static boolean a(int i)
    {
        return (a.d & i) == 0;
    }

    public static boolean b(int i)
    {
        return (b.d & i) == 0;
    }

    public static boolean c(int i)
    {
        return (c.d & i) != 0;
    }

    public static r valueOf(String s)
    {
        return (r)Enum.valueOf(com/g/c/r, s);
    }

    public static r[] values()
    {
        return (r[])e.clone();
    }

    static 
    {
        a = new r("NO_CACHE", 0, 1);
        b = new r("NO_STORE", 1, 2);
        c = new r("OFFLINE", 2, 4);
        e = (new r[] {
            a, b, c
        });
    }
}
