// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.pf.common.utility.m;

public class ce
    implements Comparable
{

    public static final ce a = new ce(0, 0, 0);
    public final int b;
    public final int c;
    public final int d;

    public ce(int i, int j, int k)
    {
        b = i;
        c = j;
        d = k;
    }

    public int a(ce ce1)
    {
        if (ce1 == null)
        {
            throw new NullPointerException("parameter cannot be null!!");
        }
        m.c("VersionUtils", (new StringBuilder()).append(this).append(" compare to ").append(ce1).toString());
        if (b != ce1.b)
        {
            return b - ce1.b;
        }
        if (c != ce1.c)
        {
            return c - ce1.c;
        }
        if (d != ce1.d)
        {
            return d - ce1.d;
        } else
        {
            return 0;
        }
    }

    public int compareTo(Object obj)
    {
        return a((ce)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append(b).append(".").append(c).append(".").append(d).toString();
    }

}
