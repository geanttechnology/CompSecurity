// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;


public final class ap extends Enum
{

    public static final ap a;
    public static final ap b;
    public static final ap c;
    public static final ap d;
    private static final ap e[];

    private ap(String s, int i)
    {
        super(s, i);
    }

    public static ap valueOf(String s)
    {
        return (ap)Enum.valueOf(com/google/analytics/tracking/android/ap, s);
    }

    public static ap[] values()
    {
        return (ap[])e.clone();
    }

    static 
    {
        a = new ap("VERBOSE", 0);
        b = new ap("INFO", 1);
        c = new ap("WARNING", 2);
        d = new ap("ERROR", 3);
        e = (new ap[] {
            a, b, c, d
        });
    }
}
