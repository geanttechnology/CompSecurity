// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


public final class k extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    private static final k e[];

    private k(String s, int i)
    {
        super(s, i);
    }

    public static k valueOf(String s)
    {
        return (k)Enum.valueOf(com/jirbo/adcolony/k, s);
    }

    public static k[] values()
    {
        return (k[])e.clone();
    }

    static 
    {
        a = new k("NONE", 0);
        b = new k("AUTOMATIC", 1);
        c = new k("OVERLAY", 2);
        d = new k("END_CARD", 3);
        e = (new k[] {
            a, b, c, d
        });
    }
}
