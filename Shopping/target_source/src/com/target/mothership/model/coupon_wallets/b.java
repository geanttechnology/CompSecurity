// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets;

import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.d;
import com.target.mothership.model.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.apigee.e.c.a;

// Referenced classes of package com.target.mothership.model.coupon_wallets:
//            a

public class b extends com.target.mothership.model.coupon_wallets.a
{

    private final a mServices = new a();

    public b()
    {
    }

    void a(Guest guest, CouponPromotionId couponpromotionid, d d)
    {
        a(guest, couponpromotionid.a(), d);
    }

    public void a(Guest guest, d d)
    {
        d = new e(new com.target.mothership.model.coupon_wallets.handler.b(d));
        mServices.a(guest.getAccessToken(), d);
    }

    public void a(Guest guest, String s, d d)
    {
        d = new e(new com.target.mothership.model.coupon_wallets.handler.a(d));
        mServices.a(guest.getAccessToken(), new com.target.mothership.services.apigee.e.a.a(s), d);
    }
}
