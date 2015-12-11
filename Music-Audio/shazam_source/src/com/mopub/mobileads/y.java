// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.m;

public final class y extends Enum
{

    public static final y a;
    public static final y b;
    public static final y c;
    public static final y d;
    public static final y e;
    public static final y f;
    private static final y h[];
    public final String g;

    private y(String s, int i, String s1)
    {
        super(s, i);
        m.a(s1, "errorCode cannot be null");
        g = s1;
    }

    public static y valueOf(String s)
    {
        return (y)Enum.valueOf(com/mopub/mobileads/y, s);
    }

    public static y[] values()
    {
        return (y[])h.clone();
    }

    static 
    {
        a = new y("XML_PARSING_ERROR", 0, "100");
        b = new y("WRAPPER_TIMEOUT", 1, "301");
        c = new y("NO_ADS_VAST_RESPONSE", 2, "303");
        d = new y("GENERAL_LINEAR_AD_ERROR", 3, "400");
        e = new y("GENERAL_COMPANION_AD_ERROR", 4, "600");
        f = new y("UNDEFINED_ERROR", 5, "900");
        h = (new y[] {
            a, b, c, d, e, f
        });
    }
}
