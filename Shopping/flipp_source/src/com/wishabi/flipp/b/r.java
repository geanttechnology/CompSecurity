// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


public final class r extends Enum
{

    public static final r a;
    public static final r b;
    private static final r d[];
    final int c;

    private r(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    public static r valueOf(String s)
    {
        return (r)Enum.valueOf(com/wishabi/flipp/b/r, s);
    }

    public static r[] values()
    {
        return (r[])d.clone();
    }

    static 
    {
        a = new r("OPEN", 0, 0);
        b = new r("ENGAGEMENT", 1, 1);
        d = (new r[] {
            a, b
        });
    }
}
