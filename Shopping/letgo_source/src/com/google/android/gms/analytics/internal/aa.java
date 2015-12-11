// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;


public final class aa extends Enum
{

    public static final aa a;
    public static final aa b;
    private static final aa c[];

    private aa(String s, int i)
    {
        super(s, i);
    }

    public static aa a(String s)
    {
        if ("GZIP".equalsIgnoreCase(s))
        {
            return b;
        } else
        {
            return a;
        }
    }

    public static aa valueOf(String s)
    {
        return (aa)Enum.valueOf(com/google/android/gms/analytics/internal/aa, s);
    }

    public static aa[] values()
    {
        return (aa[])c.clone();
    }

    static 
    {
        a = new aa("NONE", 0);
        b = new aa("GZIP", 1);
        c = (new aa[] {
            a, b
        });
    }
}
