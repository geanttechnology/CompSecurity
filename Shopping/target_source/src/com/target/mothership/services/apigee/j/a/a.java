// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.j.a;

import com.target.mothership.services.f.a.c;
import java.util.Map;

public class a extends com.target.mothership.services.f.a.a
{

    private static c GET_ORDER_DETAILS;
    private static final com.target.mothership.services.f.a.b.a ORDER_NUMBER = new com.target.mothership.services.f.a.b.a("order_number");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b.b a(String s, String s1)
    {
        c c1 = GET_ORDER_DETAILS;
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(ORDER_NUMBER.b(), s1);
        return a(c1, null, ((Map) (a1)), null, null, s);
    }

    static 
    {
        GET_ORDER_DETAILS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.ApigeePciSecure, "/orders/v2/{order_number}");
    }
}
