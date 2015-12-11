// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.mothership.model.coupon_wallets.c;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.analytics.a.j;

public class d
{

    private static d sInstance;
    private c mCouponWalletsManager;

    private d()
    {
        mCouponWalletsManager = new c();
    }

    public static d a()
    {
        if (sInstance == null)
        {
            sInstance = new d();
        }
        return sInstance;
    }

    public void a(Guest guest, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mCouponWalletsManager.a(guest, d1);
    }

    public void a(String s)
    {
        mCouponWalletsManager.a(s);
    }
}
