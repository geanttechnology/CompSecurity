// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.helper.e;

import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.coupon_wallets.c;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.service.provider.b;
import com.target.ui.service.provider.d;

public class com.target.ui.helper.e.a
{
    public static interface a
    {

        public abstract void b(CouponPromotionId couponpromotionid);

        public abstract void c(CouponPromotionId couponpromotionid);

        public abstract void d(CouponPromotionId couponpromotionid);
    }


    private b mConnectivityProvider;
    private c mCouponWalletsManager;
    private String mRequestTag;

    public com.target.ui.helper.e.a()
    {
        this(new c(), ((b) (new d())));
    }

    public com.target.ui.helper.e.a(c c1, b b1)
    {
        mCouponWalletsManager = c1;
        mConnectivityProvider = b1;
        mRequestTag = String.valueOf(hashCode());
    }

    public void a(Guest guest, final CouponPromotionId couponPromotionId, final a listener)
    {
        if (!mConnectivityProvider.a())
        {
            listener.d(couponPromotionId);
            return;
        } else
        {
            mCouponWalletsManager.a(guest, couponPromotionId, new com.target.mothership.model.d() {

                final com.target.ui.helper.e.a this$0;
                final CouponPromotionId val$couponPromotionId;
                final a val$listener;

                public void a(com.target.mothership.model.coupon_wallets.interfaces.a.a a1)
                {
                    listener.c(couponPromotionId);
                }

                public volatile void a(Object obj)
                {
                    a((Void)obj);
                }

                public void a(Void void1)
                {
                    listener.b(couponPromotionId);
                }

                public void b(Object obj)
                {
                    a((com.target.mothership.model.coupon_wallets.interfaces.a.a)obj);
                }

            
            {
                this$0 = com.target.ui.helper.e.a.this;
                listener = a2;
                couponPromotionId = couponpromotionid;
                super();
            }
            });
            return;
        }
    }
}
