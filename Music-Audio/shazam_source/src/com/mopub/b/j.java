// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.b;


public final class j extends Enum
{

    public static final j a;
    public static final j b;
    private static final j c[];

    private j(String s, int i)
    {
        super(s, i);
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/mopub/b/j, s);
    }

    public static j[] values()
    {
        return (j[])c.clone();
    }

    static 
    {
        a = new j("INLINE", 0);
        b = new j("INTERSTITIAL", 1);
        c = (new j[] {
            a, b
        });
    }
}
