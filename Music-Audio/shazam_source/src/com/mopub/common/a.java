// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;


public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    private static final a e[];

    private a(String s, int i)
    {
        super(s, i);
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/mopub/common/a, s);
    }

    public static a[] values()
    {
        return (a[])e.clone();
    }

    static 
    {
        a = new a("BANNER", 0);
        b = new a("INTERSTITIAL", 1);
        c = new a("NATIVE", 2);
        d = new a("REWARDED_VIDEO", 3);
        e = (new a[] {
            a, b, c, d
        });
    }
}
