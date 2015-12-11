// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import com.facebook.ads.a.f.s;

public final class b
{

    public static final b a = new b(1000, "Network Error");
    public static final b b = new b(1001, "No Fill");
    public static final b c = new b(1002, "Ad was re-loaded too frequently");
    public static final b d = new b(2000, "Server Error");
    public static final b e = new b(2001, "Internal Error");
    public static final b f = new b(2002, "Native ad failed to load due to missing properties");
    public final int g;
    private final String h;

    public b(int i, String s1)
    {
        String s2 = s1;
        if (s.a(s1))
        {
            s2 = "unknown error";
        }
        g = i;
        h = s2;
    }

    public final int a()
    {
        return g;
    }

    public final String b()
    {
        return h;
    }

}
