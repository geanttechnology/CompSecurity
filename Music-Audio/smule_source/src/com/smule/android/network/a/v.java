// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;


public final class v extends Enum
{

    public static final v a;
    public static final v b;
    public static final v c;
    private static final v e[];
    String d;

    private v(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static v valueOf(String s)
    {
        return (v)Enum.valueOf(com/smule/android/network/a/v, s);
    }

    public static v[] values()
    {
        return (v[])e.clone();
    }

    static 
    {
        a = new v("SUBSCRIPTION", 0, "sub");
        b = new v("PAID", 1, "paid");
        c = new v("OWNED", 2, "own");
        e = (new v[] {
            a, b, c
        });
    }
}
