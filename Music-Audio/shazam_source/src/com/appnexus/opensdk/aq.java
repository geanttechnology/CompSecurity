// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;


public final class aq extends Enum
{

    public static final aq a;
    public static final aq b;
    public static final aq c;
    public static final aq d;
    public static final aq e;
    public static final aq f;
    private static final aq g[];

    private aq(String s, int i)
    {
        super(s, i);
    }

    public static aq valueOf(String s)
    {
        return (aq)Enum.valueOf(com/appnexus/opensdk/aq, s);
    }

    public static aq[] values()
    {
        return (aq[])g.clone();
    }

    static 
    {
        a = new aq("SUCCESS", 0);
        b = new aq("INVALID_REQUEST", 1);
        c = new aq("UNABLE_TO_FILL", 2);
        d = new aq("MEDIATED_SDK_UNAVAILABLE", 3);
        e = new aq("NETWORK_ERROR", 4);
        f = new aq("INTERNAL_ERROR", 5);
        g = (new aq[] {
            a, b, c, d, e, f
        });
    }
}
