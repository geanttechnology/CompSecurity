// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import u.aly.w;

// Referenced classes of package com.umeng.analytics:
//            ReportPolicy

public static class b extends b
{

    private long a;
    private long b;
    private w c;

    public long a()
    {
        return b;
    }

    public boolean a(boolean flag)
    {
        return System.currentTimeMillis() - c.c >= b;
    }

    public (w w1, long l)
    {
        a = 10000L;
        c = w1;
        long l1 = l;
        if (l < a)
        {
            l1 = a;
        }
        b = l1;
    }
}
