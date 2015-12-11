// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.b;

import com.google.a.a.e;
import com.google.a.a.g;
import java.util.Arrays;

public final class d
{

    private final long a = 0L;
    private final long b = 0L;
    private final long c = 0L;
    private final long d = 0L;
    private final long e = 0L;
    private final long f = 0L;

    public d()
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (0L >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
        if (0L >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
        if (0L >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
        if (0L >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
        if (0L >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        g.a(flag);
        if (0L >= 0L)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        g.a(flag);
    }

    public final boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof d)
        {
            obj = (d)obj;
            flag = flag1;
            if (a == ((d) (obj)).a)
            {
                flag = flag1;
                if (b == ((d) (obj)).b)
                {
                    flag = flag1;
                    if (c == ((d) (obj)).c)
                    {
                        flag = flag1;
                        if (d == ((d) (obj)).d)
                        {
                            flag = flag1;
                            if (e == ((d) (obj)).e)
                            {
                                flag = flag1;
                                if (f == ((d) (obj)).f)
                                {
                                    flag = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return flag;
    }

    public final int hashCode()
    {
        return Arrays.hashCode(new Object[] {
            Long.valueOf(a), Long.valueOf(b), Long.valueOf(c), Long.valueOf(d), Long.valueOf(e), Long.valueOf(f)
        });
    }

    public final String toString()
    {
        return com.google.a.a.e.a(this).a("hitCount", a).a("missCount", b).a("loadSuccessCount", c).a("loadExceptionCount", d).a("totalLoadTime", e).a("evictionCount", f).toString();
    }
}
