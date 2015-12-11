// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b;

import java.io.IOException;

public final class u extends Enum
{

    public static final u a;
    public static final u b;
    public static final u c;
    public static final u d;
    private static final u f[];
    private final String e;

    private u(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static u a(String s)
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

    public static u valueOf(String s)
    {
        return (u)Enum.valueOf(com/g/b/u, s);
    }

    public static u[] values()
    {
        return (u[])f.clone();
    }

    public final String toString()
    {
        return e;
    }

    static 
    {
        a = new u("HTTP_1_0", 0, "http/1.0");
        b = new u("HTTP_1_1", 1, "http/1.1");
        c = new u("SPDY_3", 2, "spdy/3.1");
        d = new u("HTTP_2", 3, "h2");
        f = (new u[] {
            a, b, c, d
        });
    }
}
