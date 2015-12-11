// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;


public final class af extends Enum
{

    public static final af a;
    public static final af b;
    public static final af c;
    public static final af d;
    public static final af e;
    public static final af f;
    public static final af g;
    private static final af h[];

    private af(String s, int i)
    {
        super(s, i);
    }

    public static af valueOf(String s)
    {
        return (af)Enum.valueOf(com/j/a/g/af, s);
    }

    public static af[] values()
    {
        return (af[])h.clone();
    }

    static 
    {
        a = new af("ldpi", 0);
        b = new af("mdpi", 1);
        c = new af("tvdpi", 2);
        d = new af("hdpi", 3);
        e = new af("xhdpi", 4);
        f = new af("xxhdpi", 5);
        g = new af("xxxhdpi", 6);
        h = (new af[] {
            a, b, c, d, e, f, g
        });
    }
}
