// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupons;

import com.target.mothership.model.coupons.interfaces.AvailableCouponOffer;
import com.target.mothership.model.coupons.interfaces.CompletedSignUp;
import com.target.mothership.model.coupons.interfaces.RegisteredPhone;
import com.target.mothership.model.coupons.params.CouponsSignUpParams;
import com.target.mothership.model.d;
import com.target.mothership.model.h;

public interface a
{

    public abstract void a(CompletedSignUp completedsignup, AvailableCouponOffer availablecouponoffer, d d);

    public abstract void a(CompletedSignUp completedsignup, d d);

    public abstract void a(CompletedSignUp completedsignup, h h);

    public abstract void a(CompletedSignUp completedsignup, String s, d d);

    public abstract void a(RegisteredPhone registeredphone, String s, CouponsSignUpParams couponssignupparams, d d);

    public abstract void a(String s, d d);

    public abstract void b(CompletedSignUp completedsignup, d d);
}
