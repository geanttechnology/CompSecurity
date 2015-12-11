// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.h.a;

import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import java.util.Map;

public class a extends b
{

    private static c GET_GEOCODE;
    private static final com.target.mothership.services.f.a.b.a ZIP_CODE = new com.target.mothership.services.f.a.b.a("zip_code");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(String s)
    {
        c c1 = GET_GEOCODE;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ZIP_CODE.b(), s);
        return a(c1, null, ((Map) (a1)), null, null);
    }

    static 
    {
        GET_GEOCODE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.Apigee, "/v2/location/geocode?place={zip_code}");
    }
}
