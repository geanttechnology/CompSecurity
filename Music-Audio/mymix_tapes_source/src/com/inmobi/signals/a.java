// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals;

import com.inmobi.commons.core.b.c;

public class a
{

    private c a;

    public a()
    {
        a = c.b("carb_store");
    }

    public static String a()
    {
        return c.a("carb_store");
    }

    public void a(long l)
    {
        a.a("carb_last_update_ts", l);
    }

    public long b()
    {
        return a.b("carb_last_update_ts", 0L);
    }
}
