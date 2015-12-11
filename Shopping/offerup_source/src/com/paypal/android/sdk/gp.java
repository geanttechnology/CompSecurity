// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;

public final class gp extends Enum
{

    public static final gp a;
    public static final gp b;
    public static final gp c;
    public static final gp d;
    private static final gp f[];
    private final String e;

    private gp(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static gp a(String s)
    {
        if (s.equals(a.e))
        {
            return a;
        }
        if (s.equals(b.e))
        {
            return b;
        }
        if (s.equals(d.e))
        {
            return d;
        }
        if (s.equals(c.e))
        {
            return c;
        } else
        {
            throw new IOException((new StringBuilder("Unexpected protocol: ")).append(s).toString());
        }
    }

    public static gp valueOf(String s)
    {
        return (gp)Enum.valueOf(com/paypal/android/sdk/gp, s);
    }

    public static gp[] values()
    {
        return (gp[])f.clone();
    }

    public final String toString()
    {
        return e;
    }

    static 
    {
        a = new gp("HTTP_1_0", 0, "http/1.0");
        b = new gp("HTTP_1_1", 1, "http/1.1");
        c = new gp("SPDY_3", 2, "spdy/3.1");
        d = new gp("HTTP_2", 3, "h2");
        f = (new gp[] {
            a, b, c, d
        });
    }
}
