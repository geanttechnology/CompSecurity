// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.rendering.mraid;

import com.inmobi.commons.core.b.c;

public class i
{

    private c a;

    public i()
    {
        a = com.inmobi.commons.core.b.c.b("mraid_js_store");
    }

    public static String a()
    {
        return com.inmobi.commons.core.b.c.a("mraid_js_store");
    }

    public void a(String s)
    {
        a.a("mraid_js_string", s);
        a.a("last_updated_ts", System.currentTimeMillis() / 1000L);
    }

    public String b()
    {
        return a.b("mraid_js_string", null);
    }

    public long c()
    {
        return a.b("last_updated_ts", 0L);
    }
}
