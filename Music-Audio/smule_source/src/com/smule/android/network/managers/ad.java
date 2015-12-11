// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;


public final class ad extends Enum
{

    public static final ad a;
    public static final ad b;
    private static final ad f[];
    public final int c;
    public final int d;
    public final String e;

    private ad(String s, int i, int j, int k, String s1)
    {
        super(s, i);
        c = j;
        d = k;
        e = s1;
    }

    public static ad valueOf(String s)
    {
        return (ad)Enum.valueOf(com/smule/android/network/managers/ad, s);
    }

    public static ad[] values()
    {
        return (ad[])f.clone();
    }

    static 
    {
        a = new ad("FB_LIKE", 0, 1, 5, "fb_like_enabled");
        b = new ad("FB_LOGIN", 1, 7, 10, "fb_login_enabled");
        f = (new ad[] {
            a, b
        });
    }
}
