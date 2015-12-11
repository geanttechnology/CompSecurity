// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;


public final class m extends Enum
{

    public static final m a;
    public static final m b;
    public static final m c;
    public static final m d;
    public static final m e;
    public static final m f;
    private static final m g[];

    private m(String s, int i)
    {
        super(s, i);
    }

    public static m valueOf(String s)
    {
        return (m)Enum.valueOf(com/smule/android/console/m, s);
    }

    public static m[] values()
    {
        return (m[])g.clone();
    }

    static 
    {
        a = new m("STRING", 0);
        b = new m("CLEAR", 1);
        c = new m("SHOWSRES", 2);
        d = new m("SETFONTSIZE", 3);
        e = new m("SHOWFONTSIZE", 4);
        f = new m("EXIT", 5);
        g = (new m[] {
            a, b, c, d, e, f
        });
    }
}
