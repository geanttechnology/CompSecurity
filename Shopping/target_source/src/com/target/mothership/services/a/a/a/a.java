// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.a.a.a;

import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import java.util.Map;

public class a extends b
{

    private static final String API_KEY = "mgf5dy1gwodioi7hx0pneqgo2";
    private static final com.target.mothership.services.f.a.b.a API_VERSION = new com.target.mothership.services.f.a.b.a("ApiVersion");
    private static final String API_VERSION_NUMBER = "5.4";
    private static final com.target.mothership.services.f.a.b.a FILTER = new com.target.mothership.services.f.a.b.a("Filter");
    private static final com.target.mothership.services.f.a.b.a INCLUDE = new com.target.mothership.services.f.a.b.a("Include");
    private static final com.target.mothership.services.f.a.b.a LIMIT = new com.target.mothership.services.f.a.b.a("Limit");
    private static final com.target.mothership.services.f.a.b.a OFFSET = new com.target.mothership.services.f.a.b.a("Offset");
    private static final com.target.mothership.services.f.a.b.a PASS_KEY = new com.target.mothership.services.f.a.b.a("PassKey");
    private static c READ_REVIEW;
    private static final com.target.mothership.services.f.a.b.a STATS = new com.target.mothership.services.f.a.b.a("Stats");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(com.target.mothership.common.params.c c1)
    {
        c c2 = READ_REVIEW;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(API_VERSION.a(), "5.4");
        a1.put(PASS_KEY.a(), "mgf5dy1gwodioi7hx0pneqgo2");
        a1.put(FILTER.a(), c1.a());
        a1.put(INCLUDE.a(), com.target.mothership.common.params.c.c());
        a1.put(STATS.a(), com.target.mothership.common.params.c.b());
        a1.put(LIMIT.a(), c1.e());
        a1.put(OFFSET.a(), c1.d());
        return a(c2, null, null, ((Map) (a1)), null);
    }

    static 
    {
        READ_REVIEW = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.BAZAAR_VOICE, "/data/reviews.json");
    }
}
