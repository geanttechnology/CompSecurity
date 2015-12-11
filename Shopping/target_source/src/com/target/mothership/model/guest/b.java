// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest;

import com.google.a.a.e;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.a;
import com.target.mothership.model.common.GuestAddress;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.GuestBase;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.h;

// Referenced classes of package com.target.mothership.model.guest:
//            c, a, GuestDataSource

public class b extends com.target.mothership.model.a
{
    public static interface a
    {

        public abstract void onGuestChanged(e e);
    }


    public static final String TAG = com/target/mothership/model/guest/b.getSimpleName();
    private GuestDataSource mGuestDataSource;

    public b()
    {
        if (com.target.mothership.b.a().m())
        {
            mGuestDataSource = new c();
            return;
        } else
        {
            mGuestDataSource = new com.target.mothership.model.guest.a();
            return;
        }
    }

    public static GuestBase a()
    {
        return GuestDataSource.c();
    }

    public static void a(a a1)
    {
        com.target.mothership.model.guest.GuestDataSource.a(a1);
    }

    public void a(Guest guest, int i, d d)
    {
        mGuestDataSource.a(guest, i, d);
    }

    public void a(Guest guest, AddressParams addressparams, boolean flag, d d)
    {
        mGuestDataSource.a(guest, addressparams, flag, d);
    }

    public void a(Guest guest, com.target.mothership.common.params.b b1, d d)
    {
        mGuestDataSource.a(guest, b1, d);
    }

    public void a(Guest guest, PaymentTender paymenttender, d d)
    {
        mGuestDataSource.a(guest, paymenttender, d);
    }

    public void a(Guest guest, PaymentTender paymenttender, boolean flag, AddressParams addressparams, d d)
    {
        mGuestDataSource.a(guest, paymenttender, flag, addressparams, d);
    }

    public void a(Guest guest, GuestAddress guestaddress, AddressParams addressparams, boolean flag, d d)
    {
        mGuestDataSource.a(guest, guestaddress, addressparams, flag, d);
    }

    public void a(Guest guest, GuestAddress guestaddress, d d)
    {
        mGuestDataSource.a(guest, guestaddress, d);
    }

    public void a(Guest guest, d d)
    {
        mGuestDataSource.a(guest, d);
    }

    public void a(Guest guest, OrderSummary ordersummary, d d)
    {
        mGuestDataSource.a(guest, ordersummary.a(), d);
    }

    public void a(Guest guest, h h)
    {
        mGuestDataSource.a(guest, h);
    }

    public void a(Guest guest, String s, String s1, d d)
    {
        mGuestDataSource.a(guest, s, s1, d);
    }

    public void a(h h)
    {
        mGuestDataSource.a(h);
    }

    public void a(String s, h h)
    {
        mGuestDataSource.a(s, h);
    }

    public void a(String s, String s1, d d)
    {
        mGuestDataSource.a(s, s1, d);
    }

    public void a(String s, String s1, String s2, String s3, String s4, String s5, boolean flag, 
            d d)
    {
        mGuestDataSource.a(s, s1, s2, s3, s4, s5, flag, d);
    }

    public void b(Guest guest, d d)
    {
        mGuestDataSource.b(guest, d);
    }

    public void b(Guest guest, h h)
    {
        mGuestDataSource.b(guest, h);
    }

    public void b(h h)
    {
        mGuestDataSource.b(h);
    }

    public void c(Guest guest, d d)
    {
        mGuestDataSource.c(guest, d);
    }

}
