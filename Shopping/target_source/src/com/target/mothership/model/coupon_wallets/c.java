// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets;

import com.target.mothership.b;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.a;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;

// Referenced classes of package com.target.mothership.model.coupon_wallets:
//            d, b, a

public class c extends a
{

    private static final String TAG = com/target/mothership/model/coupon_wallets/c.getSimpleName();
    private com.target.mothership.model.coupon_wallets.a mCouponWalletsDataSource;

    public c()
    {
        if (b.a().m())
        {
            mCouponWalletsDataSource = new com.target.mothership.model.coupon_wallets.d();
            return;
        } else
        {
            mCouponWalletsDataSource = new com.target.mothership.model.coupon_wallets.b();
            return;
        }
    }

    public void a(Guest guest, CouponPromotionId couponpromotionid, d d1)
    {
        mCouponWalletsDataSource.a(guest, couponpromotionid, d1);
    }

    public void a(Guest guest, d d1)
    {
        mCouponWalletsDataSource.a(guest, d1);
    }

    public void a(Guest guest, String s, d d1)
    {
        mCouponWalletsDataSource.a(guest, s, d1);
    }

}
