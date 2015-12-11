// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


public final class z extends Enum
{

    public static final z a;
    public static final z b;
    public static final z c;
    public static final z d;
    private static final z e[];

    private z(String s, int i)
    {
        super(s, i);
    }

    public static z valueOf(String s)
    {
        return (z)Enum.valueOf(com/jirbo/adcolony/z, s);
    }

    public static z[] values()
    {
        return (z[])e.clone();
    }

    static 
    {
        a = new z("NONE", 0);
        b = new z("AUTOMATIC", 1);
        c = new z("OVERLAY", 2);
        d = new z("END_CARD", 3);
        e = (new z[] {
            a, b, c, d
        });
    }
}
