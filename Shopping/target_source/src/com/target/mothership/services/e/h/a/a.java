// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.e.h.a;

import com.target.mothership.services.f.a.c;
import com.target.mothership.services.f.a.e;
import com.target.mothership.util.o;
import java.util.List;
import java.util.Map;

public class a extends e
{

    private static final com.target.mothership.services.f.a.b.a ADJACENCY = new com.target.mothership.services.f.a.b.a("adjacency");
    private static final c ALL_STORES_SUMMARY;
    private static final c DETAILS;
    private static final c REQUEST_TEAM_MEMBER_CODE;
    private static final c REQUEST_TEAM_MEMBER_CODE_LOCATION;
    private static final com.target.mothership.services.f.a.b.a STORE_ID = new com.target.mothership.services.f.a.b.a("storeId");
    private static final com.target.mothership.services.f.a.b.a STORE_IDS = new com.target.mothership.services.f.a.b.a("storeIds");
    private static final com.target.mothership.services.f.a.b.a VERSION = new com.target.mothership.services.f.a.b.a("version");
    private static final com.target.mothership.services.f.a.b.a X = new com.target.mothership.services.f.a.b.a("x");
    private static final com.target.mothership.services.f.a.b.a Y = new com.target.mothership.services.f.a.b.a("y");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private String b(List list)
    {
        return o.a(list, ",");
    }

    public com.target.mothership.services.f.a.b.b a(int i)
    {
        c c1 = ALL_STORES_SUMMARY;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(VERSION.b(), Integer.toString(i));
        return a(c1, null, ((Map) (a1)), null, null);
    }

    public com.target.mothership.services.f.a.b.b a(String s, int i, int j)
    {
        c c1 = REQUEST_TEAM_MEMBER_CODE_LOCATION;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        a2.put(STORE_ID.b(), s);
        a1.put(X.a(), String.valueOf(i));
        a1.put(Y.a(), String.valueOf(j));
        return a(c1, null, ((Map) (a2)), ((Map) (a1)), null);
    }

    public com.target.mothership.services.f.a.b.b a(List list)
    {
        c c1 = DETAILS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        list = b(list);
        a1.put(STORE_IDS.b(), list);
        return a(c1, null, ((Map) (a1)), null, null);
    }

    static 
    {
        ALL_STORES_SUMMARY = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v2/stores/locations/{version}");
        DETAILS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v2/stores/location/{storeIds}");
        REQUEST_TEAM_MEMBER_CODE = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v2/stores/requestTeammemberCode");
        REQUEST_TEAM_MEMBER_CODE_LOCATION = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v2/stores/requestTeammemberCode/{storeId}");
    }
}
