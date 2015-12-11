// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class af extends Enum
{

    public static final af a;
    public static final af b;
    private static af c;
    private static af d;
    private static final af f[];
    private int e;

    private af(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static af valueOf(String s)
    {
        return (af)Enum.valueOf(com/paypal/android/sdk/af, s);
    }

    public static af[] values()
    {
        return (af[])f.clone();
    }

    public final int a()
    {
        return e;
    }

    static 
    {
        a = new af("UNKNOWN", 0, 0);
        c = new af("PAYPAL", 1, 10);
        d = new af("EBAY", 2, 11);
        b = new af("MSDK", 3, 12);
        f = (new af[] {
            a, c, d, b
        });
    }
}
