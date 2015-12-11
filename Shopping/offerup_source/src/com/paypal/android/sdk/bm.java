// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class bm extends Enum
{

    public static final bm a;
    public static final bm b;
    public static final bm c;
    private static bm d;
    private static bm e;
    private static final bm f[];

    private bm(String s, int i)
    {
        super(s, i);
    }

    public static bm valueOf(String s)
    {
        return (bm)Enum.valueOf(com/paypal/android/sdk/bm, s);
    }

    public static bm[] values()
    {
        return (bm[])f.clone();
    }

    static 
    {
        a = new bm("GET", 0);
        b = new bm("POST", 1);
        d = new bm("PUT", 2);
        c = new bm("DELETE", 3);
        e = new bm("HEAD", 4);
        f = (new bm[] {
            a, b, d, c, e
        });
    }
}
