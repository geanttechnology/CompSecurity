// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.e;

import com.facebook.ads.a.f.s;
import java.util.Locale;

public final class a extends Enum
{

    public static final a a;
    public static final a b;
    public static final a c;
    public static final a d;
    private static final a f[];
    private String e;

    private a(String s1, int i, String s2)
    {
        super(s1, i);
        e = s2;
    }

    public static a a(String s1)
    {
        if (s.a(s1))
        {
            return a;
        }
        try
        {
            s1 = valueOf(s1.toUpperCase(Locale.US));
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return a;
        }
        return s1;
    }

    public static a valueOf(String s1)
    {
        return (a)Enum.valueOf(com/facebook/ads/a/e/a, s1);
    }

    public static a[] values()
    {
        return (a[])f.clone();
    }

    public final String toString()
    {
        return e;
    }

    static 
    {
        a = new a("UNKNOWN", 0, "unknown");
        b = new a("BANNER", 1, "banner");
        c = new a("INTERSTITIAL", 2, "interstitial");
        d = new a("NATIVE", 3, "native");
        f = (new a[] {
            a, b, c, d
        });
    }
}
