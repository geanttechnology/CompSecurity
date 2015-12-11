// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.cart.b.d;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.guest.b;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.ui.analytics.a.j;

public class f
{

    private static final int ARBITRARY_ORDER_HISTORY_LIMIT = 25;
    private static final String LOG_TAG = com/target/ui/service/f.getSimpleName();
    private static f sInstance;
    private b mGuestManager;

    private f()
    {
        mGuestManager = new b();
    }

    public static f a()
    {
        if (sInstance == null)
        {
            sInstance = new f();
        }
        return sInstance;
    }

    public void a(Guest guest, AddressParams addressparams, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, addressparams, true, d1);
    }

    public void a(Guest guest, com.target.mothership.common.params.b b1, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, b1, d1);
    }

    public void a(Guest guest, PaymentTender paymenttender, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, paymenttender, d1);
    }

    public void a(Guest guest, PaymentTender paymenttender, boolean flag, AddressParams addressparams, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, paymenttender, flag, addressparams, d1);
    }

    public void a(Guest guest, d d1, com.target.mothership.model.d d2)
    {
        mGuestManager.a(guest, d1.a(), d1.b(), d2);
    }

    public void a(Guest guest, GuestAddress guestaddress, AddressParams addressparams, boolean flag, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, guestaddress, addressparams, flag, d1);
    }

    public void a(Guest guest, GuestAddress guestaddress, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, guestaddress, d1);
    }

    public void a(Guest guest, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, d1);
    }

    public void a(Guest guest, OrderSummary ordersummary, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, ordersummary, d1);
    }

    public void a(String s)
    {
        mGuestManager.a(s);
    }

    public void b(Guest guest, com.target.mothership.model.d d1)
    {
        mGuestManager.b(guest, d1);
    }

    public void c(Guest guest, com.target.mothership.model.d d1)
    {
        mGuestManager.c(guest, d1);
    }

    public void d(Guest guest, com.target.mothership.model.d d1)
    {
        d1 = new j(d1);
        mGuestManager.a(guest, 25, d1);
    }

}
