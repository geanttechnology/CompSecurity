// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;


public final class k extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    private static final k g[];

    private k(String s, int i)
    {
        super(s, i);
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/smule/pianoandroid/magicpiano/a/k, s);
    }

    public static k[] values()
    {
        return (k[])g.clone();
    }

    static 
    {
        a = new k("AUTO", 0);
        b = new k("EASY", 1);
        c = new k("MEDIUM", 2);
        d = new k("HARD", 3);
        e = new k("RECITAL", 4);
        f = new k("UNSPECIFIED", 5);
        g = (new k[] {
            a, b, c, d, e, f
        });
    }
}
