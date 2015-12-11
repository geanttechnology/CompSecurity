// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons;

import com.google.a.a.e;
import com.target.mothership.b;
import com.target.mothership.model.a;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.mothership.model.d;
import com.target.mothership.model.h;
import com.target.mothership.util.o;

// Referenced classes of package com.target.mothership.model.coupons:
//            a, d, b, CouponCompletedSignUp

public class c extends a
    implements com.target.mothership.model.coupons.a
{

    private final com.target.mothership.model.coupons.a mCouponsDataSource;

    public c()
    {
        if (com.target.mothership.b.a().m())
        {
            mCouponsDataSource = new com.target.mothership.model.coupons.d();
            return;
        } else
        {
            mCouponsDataSource = new com.target.mothership.model.coupons.b();
            return;
        }
    }

    public e a()
    {
        if (o.g(com.target.mothership.cache.b.getInstance().getValidCouponAccessKey()))
        {
            return e.b(new CouponCompletedSignUp());
        } else
        {
            return e.e();
        }
    }

    public void a(CompletedSignUp completedsignup, AvailableCouponOffer availablecouponoffer, d d1)
    {
        mCouponsDataSource.a(completedsignup, availablecouponoffer, d1);
    }

    public void a(CompletedSignUp completedsignup, d d1)
    {
        mCouponsDataSource.a(completedsignup, d1);
    }

    public void a(CompletedSignUp completedsignup, h h)
    {
        mCouponsDataSource.a(completedsignup, h);
    }

    public void a(CompletedSignUp completedsignup, String s, d d1)
    {
        mCouponsDataSource.a(completedsignup, s, d1);
    }

    public void a(RegisteredPhone registeredphone, String s, CouponsSignUpParams couponssignupparams, d d1)
    {
        mCouponsDataSource.a(registeredphone, s, couponssignupparams, d1);
    }

    public void a(String s, d d1)
    {
        mCouponsDataSource.a(s, d1);
    }

    public void b()
    {
        com.target.mothership.cache.b.getInstance().purgeCouponAccessKey();
    }

    public void b(CompletedSignUp completedsignup, d d1)
    {
        mCouponsDataSource.b(completedsignup, d1);
    }

    public void b(String s)
    {
        com.target.mothership.cache.b.getInstance().updateAppAccessKey(s);
    }
}
