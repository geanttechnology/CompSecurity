// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


public final class ij extends Enum
{

    public static final ij a;
    public static final ij b;
    public static final ij c;
    public static final ij d;
    private static final ij e[];

    private ij(String s, int i)
    {
        super(s, i);
    }

    public static ij valueOf(String s)
    {
        return (ij)Enum.valueOf(com/paypal/android/sdk/ij, s);
    }

    public static ij[] values()
    {
        return (ij[])e.clone();
    }

    static 
    {
        a = new ij("SPDY_SYN_STREAM", 0);
        b = new ij("SPDY_REPLY", 1);
        c = new ij("SPDY_HEADERS", 2);
        d = new ij("HTTP_20_HEADERS", 3);
        e = (new ij[] {
            a, b, c, d
        });
    }
}
