// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


public final class y extends Enum
{

    public static final y a;
    public static final y b;
    public static final y c;
    public static final y d;
    public static final y e;
    public static final y f;
    private static final y g[];

    private y(String s, int i)
    {
        super(s, i);
    }

    public static y a(String s)
    {
        if ("BATCH_BY_SESSION".equalsIgnoreCase(s))
        {
            return b;
        }
        if ("BATCH_BY_TIME".equalsIgnoreCase(s))
        {
            return c;
        }
        if ("BATCH_BY_BRUTE_FORCE".equalsIgnoreCase(s))
        {
            return d;
        }
        if ("BATCH_BY_COUNT".equalsIgnoreCase(s))
        {
            return e;
        }
        if ("BATCH_BY_SIZE".equalsIgnoreCase(s))
        {
            return f;
        } else
        {
            return a;
        }
    }

    public static y valueOf(String s)
    {
        return (y)Enum.valueOf(com/google/android/gms/analytics/internal/y, s);
    }

    public static y[] values()
    {
        return (y[])g.clone();
    }

    static 
    {
        a = new y("NONE", 0);
        b = new y("BATCH_BY_SESSION", 1);
        c = new y("BATCH_BY_TIME", 2);
        d = new y("BATCH_BY_BRUTE_FORCE", 3);
        e = new y("BATCH_BY_COUNT", 4);
        f = new y("BATCH_BY_SIZE", 5);
        g = (new y[] {
            a, b, c, d, e, f
        });
    }
}
