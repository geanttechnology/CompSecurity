// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons;

import com.target.mothership.model.c;
import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.mothership.util.h;

// Referenced classes of package com.target.mothership.model.coupons:
//            a, b

class d extends c
    implements a
{

    private b mCouponsLiveDataSource;

    public d()
    {
        mCouponsLiveDataSource = new b();
    }

    public void a(CompletedSignUp completedsignup, AvailableCouponOffer availablecouponoffer, com.target.mothership.model.d d1)
    {
        a(completedsignup, availablecouponoffer.a(), d1);
    }

    public void a(CompletedSignUp completedsignup, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_step5_get_assigned_offers.xml");
        } else
        {
            a("step5_get_assigned_offers.xml");
        }
        mCouponsLiveDataSource.a(completedsignup, d1);
    }

    public void a(CompletedSignUp completedsignup, com.target.mothership.model.h h1)
    {
        if (a())
        {
            h1.a(h.NETWORK_ERROR);
            return;
        } else
        {
            a("get_available_coupons.xml");
            mCouponsLiveDataSource.a(completedsignup, h1);
            return;
        }
    }

    public void a(CompletedSignUp completedsignup, String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_step6_add_on_demand_coupon.xml");
        } else
        {
            a("add_on_demand_coupon.xml");
        }
        mCouponsLiveDataSource.a(completedsignup, s, d1);
    }

    public void a(RegisteredPhone registeredphone, String s, CouponsSignUpParams couponssignupparams, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_step2_validate_by_pin.xml");
        } else
        {
            a("step4_assign_offers.xml");
        }
        mCouponsLiveDataSource.a(registeredphone, s, couponssignupparams, d1);
    }

    public void a(String s, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_step1_register_by_sms.xml");
        } else
        {
            a("step1_register_by_sms.xml");
        }
        mCouponsLiveDataSource.a(s, d1);
    }

    public void b(CompletedSignUp completedsignup, com.target.mothership.model.d d1)
    {
        if (a())
        {
            a("error_step5_get_assigned_offers.xml");
        } else
        {
            a("step5_get_assigned_offers.xml");
        }
        mCouponsLiveDataSource.b(completedsignup, d1);
    }
}
