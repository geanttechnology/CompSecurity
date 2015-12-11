// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.a;


public final class i extends Enum
{

    public static final i a;
    public static final i b;
    private static final i c[];

    private i(String s, int j)
    {
        super(s, j);
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/c/a/b/a/i, s);
    }

    public static i[] values()
    {
        return (i[])c.clone();
    }

    static 
    {
        a = new i("FIFO", 0);
        b = new i("LIFO", 1);
        c = (new i[] {
            a, b
        });
    }
}
