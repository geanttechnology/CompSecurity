// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.d.a.a;

import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import java.util.HashMap;
import java.util.Random;

public class a extends b
{

    private static final com.target.mothership.services.f.a.b.a CACHE_BUSTER = new com.target.mothership.services.f.a.b.a("c");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(String s)
    {
        s = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.GoogleAds, s);
        HashMap hashmap = new HashMap();
        Random random = new Random();
        hashmap.put(CACHE_BUSTER.a(), String.valueOf(Math.abs(random.nextInt())));
        return a(((c) (s)), null, null, ((java.util.Map) (hashmap)), null);
    }

    public com.target.mothership.services.f.a.b.b b(String s)
    {
        return a(new c(com.target.mothership.services.f.a.d.a.GET, s), null, null, null, null);
    }

}
