// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.a;

import com.inmobi.commons.core.b.c;

public class a
{

    private c a;

    public a()
    {
        a = com.inmobi.commons.core.b.c.b("aes_key_store");
    }

    public static String a()
    {
        return com.inmobi.commons.core.b.c.a("aes_key_store");
    }

    public void a(String s)
    {
        a.a("aes_public_key", s);
        a.a("last_generated_ts", System.currentTimeMillis() / 1000L);
    }

    public String b()
    {
        return a.b("aes_public_key", null);
    }

    public long c()
    {
        return a.b("last_generated_ts", 0L);
    }
}
