// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets;

import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.coupon_wallets.interfaces.a.a;
import com.target.mothership.model.coupon_wallets.interfaces.a.b;
import com.target.mothership.model.guest.interfaces.Guest;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.coupon_wallets:
//            a, b

public class d extends com.target.mothership.model.coupon_wallets.a
{

    private com.target.mothership.model.coupon_wallets.b mLiveDataSource;

    public d()
    {
        mLiveDataSource = new com.target.mothership.model.coupon_wallets.b();
    }

    private a c()
    {
        a a1 = new a();
        com.target.mothership.model.coupon_wallets.interfaces.a.a.a a2 = com.target.mothership.model.coupon_wallets.interfaces.a.a.a.ERR_UNKNOWN;
        ArrayList arraylist = new ArrayList();
        arraylist.add(a2);
        a1.a(a2);
        a1.a(arraylist);
        return a1;
    }

    void a(Guest guest, CouponPromotionId couponpromotionid, com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(c());
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }

    public void a(Guest guest, com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(new b());
            return;
        } else
        {
            a("get_coupons_from_wallet.json");
            mLiveDataSource.a(guest, d1);
            return;
        }
    }

    public void a(Guest guest, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            d1.b(c());
            return;
        } else
        {
            d1.a(null);
            return;
        }
    }
}
