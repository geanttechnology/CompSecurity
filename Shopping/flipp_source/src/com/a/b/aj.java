// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.b;


public final class aj extends Enum
{

    public static final aj a;
    public static final aj b;
    public static final aj c;
    private static final aj e[];
    final int d;

    private aj(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static aj valueOf(String s)
    {
        return (aj)Enum.valueOf(com/a/b/aj, s);
    }

    public static aj[] values()
    {
        return (aj[])e.clone();
    }

    static 
    {
        a = new aj("MEMORY", 0, 0xff00ff00);
        b = new aj("DISK", 1, -256);
        c = new aj("NETWORK", 2, 0xffff0000);
        e = (new aj[] {
            a, b, c
        });
    }
}
