// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


public final class ab extends Enum
{

    public static final ab a;
    public static final ab b;
    public static final ab c;
    public static final ab d;
    private static final ab e[];

    private ab(String s, int i)
    {
        super(s, i);
    }

    public static ab valueOf(String s)
    {
        return (ab)Enum.valueOf(com/mopub/mobileads/ab, s);
    }

    public static ab[] values()
    {
        return (ab[])e.clone();
    }

    static 
    {
        a = new ab("ERRORCODE", 0);
        b = new ab("CONTENTPLAYHEAD", 1);
        c = new ab("CACHEBUSTING", 2);
        d = new ab("ASSETURI", 3);
        e = (new ab[] {
            a, b, c, d
        });
    }
}
