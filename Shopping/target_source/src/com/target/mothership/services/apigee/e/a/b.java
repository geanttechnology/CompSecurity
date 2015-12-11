// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.e.a;

import com.target.mothership.services.f.a.a;
import com.target.mothership.services.f.a.c;

// Referenced classes of package com.target.mothership.services.apigee.e.a:
//            a

public class b extends a
{

    public static c ADD_COUPON;
    public static c ADD_COUPON_DYNAMIC;
    public static c GET_COUPONS;

    public b(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    public com.target.mothership.services.f.a.b a(String s)
    {
        return a(GET_COUPONS, null, null, null, null, s);
    }

    public com.target.mothership.services.f.a.b a(String s, com.target.mothership.services.apigee.e.a.a a1)
    {
        return a(ADD_COUPON, ((com.target.mothership.services.n) (a1)), null, null, null, s);
    }

    static 
    {
        ADD_COUPON_DYNAMIC = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.Apigee, "/coupon_wallets/v1/dynamic_coupons");
        ADD_COUPON = new c(com.target.mothership.services.f.a.d.a.POST, com.target.mothership.services.f.b.a.a.Apigee, "/coupon_wallets/v1/coupons");
        GET_COUPONS = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.a.Apigee, "/coupon_wallets/v1/coupons?responseGroup=ACTIVE,APPLIED");
    }
}
