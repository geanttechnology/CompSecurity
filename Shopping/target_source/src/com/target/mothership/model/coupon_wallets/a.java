// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.coupon_wallets;

import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.c;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;

public abstract class a extends c
{

    public a()
    {
    }

    abstract void a(Guest guest, CouponPromotionId couponpromotionid, d d);

    abstract void a(Guest guest, d d);

    abstract void a(Guest guest, String s, d d);
}
