// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.c;

import android.view.Menu;
import android.view.MenuInflater;
import com.google.a.a.e;
import com.target.mothership.model.common.PickUpPersonDetails;
import com.target.mothership.model.common.StorePickUpDetails;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.AppliedPaymentCard;
import com.target.mothership.model.guest.interfaces.EmailDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.MobileDeliveryShipmentDetails;
import com.target.mothership.model.guest.interfaces.OrderDetails;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.model.guest.interfaces.OrderSummary;
import com.target.mothership.model.guest.interfaces.ShipHomeShipmentDetails;
import com.target.mothership.model.guest.interfaces.StorePickUpShipmentDetails;
import com.target.mothership.model.guest.interfaces.a.h;
import com.target.mothership.services.o;
import com.target.ui.g.a;
import com.target.ui.service.provider.m;
import com.target.ui.view.BitmapImageView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b
    implements a, com.target.ui.helper.a.a.g
{

    private static final String TAG = com/target/ui/fragment/account/c/b.getSimpleName();
    private com.target.ui.helper.a.a mAccountDataHelper;
    private com.target.ui.service.provider.b mConnectivityProvider;
    private m mGuestProvider;
    private OrderSummary mOrderSummary;
    private com.target.ui.fragment.account.b.b mPresentation;

    public b(OrderSummary ordersummary, com.target.ui.helper.a.a a1, m m1, com.target.ui.service.provider.b b1)
    {
        mOrderSummary = ordersummary;
        mGuestProvider = m1;
        mAccountDataHelper = a1;
        mConnectivityProvider = b1;
    }

    private String a(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            return (new SimpleDateFormat("MMM d, yyyy", Locale.US)).format(date);
        }
    }

    private void b(Guest guest)
    {
        mPresentation.a(true);
        mAccountDataHelper.a(guest, mOrderSummary, this);
    }

    private void b(Guest guest, o o)
    {
        mPresentation.a(false);
        mPresentation.a(guest, o);
    }

    private void b(OrderDetails orderdetails)
    {
        mPresentation.a(false);
        mPresentation.c(orderdetails.i());
        java.util.List list = com.target.ui.util.d.a.a(orderdetails);
        mPresentation.a(list);
        if (orderdetails.b().b())
        {
            com.target.mothership.model.common.GuestAddress guestaddress = ((ShipHomeShipmentDetails)orderdetails.b().c()).b();
            mPresentation.d(com.target.ui.util.d.a.a(guestaddress));
        }
        if (orderdetails.c().b())
        {
            PickUpPersonDetails pickuppersondetails = ((StorePickUpShipmentDetails)orderdetails.c().c()).b().c();
            if (pickuppersondetails != null)
            {
                mPresentation.e(pickuppersondetails.a());
            }
        }
        if (orderdetails.d().b())
        {
            mPresentation.f(((EmailDeliveryShipmentDetails)orderdetails.d().c()).b());
        }
        if (orderdetails.e().b())
        {
            mPresentation.g(((MobileDeliveryShipmentDetails)orderdetails.e().c()).b());
        }
        c(orderdetails);
        mPresentation.h(a(orderdetails.j()));
        mPresentation.a();
    }

    private void c(OrderDetails orderdetails)
    {
        String s = com.target.ui.util.d.a.a(orderdetails.k());
        AppliedPayPalDetails appliedpaypaldetails = (AppliedPayPalDetails)orderdetails.h().d();
        if (appliedpaypaldetails != null)
        {
            mPresentation.a(appliedpaypaldetails, s);
            return;
        } else
        {
            orderdetails = com.target.ui.util.d.a.a((AppliedPaymentCard)orderdetails.f().d(), orderdetails.g());
            mPresentation.a(orderdetails, s);
            return;
        }
    }

    private void h()
    {
        mPresentation.a(false);
        mPresentation.e();
    }

    private void i()
    {
        mAccountDataHelper.a();
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900a1);
        mPresentation.a(menu, menuinflater, 0x7f120005);
    }

    public void a(Guest guest)
    {
        mPresentation.a(true);
        b(guest);
    }

    public void a(Guest guest, o o)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(guest, o);
            return;
        }
    }

    public void a(OrderDetails orderdetails)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            b(orderdetails);
            return;
        }
    }

    public void a(OrderDetailsProduct orderdetailsproduct, BitmapImageView bitmapimageview)
    {
        mPresentation.b(orderdetailsproduct, bitmapimageview);
    }

    public void a(h h1)
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.b(0x7f0900a7);
            return;
        }
    }

    public void a(com.target.ui.fragment.account.b.b b1)
    {
        mPresentation = b1;
        b1 = mGuestProvider.a();
        if (b1 == null)
        {
            mPresentation.i();
            return;
        } else
        {
            b(b1);
            return;
        }
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.account.b.b)obj);
    }

    public void a(String s)
    {
        mPresentation.i();
    }

    public void b(Object obj)
    {
        mPresentation.a(true);
    }

    public void b(String s)
    {
        mPresentation.i();
    }

    public void d()
    {
        h();
    }

    public void e()
    {
        h();
    }

    public void f()
    {
        i();
    }

    public void g()
    {
        if (!mConnectivityProvider.a())
        {
            mPresentation.g();
            return;
        }
        Guest guest = mGuestProvider.a();
        if (guest == null)
        {
            mPresentation.i();
            return;
        } else
        {
            mPresentation.a(true);
            mPresentation.b();
            b(guest);
            return;
        }
    }

    public void o_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.g();
            return;
        }
    }

    public void q_()
    {
        if (mPresentation == null)
        {
            return;
        } else
        {
            mPresentation.a(false);
            mPresentation.b(0x7f09027b);
            return;
        }
    }

    public void v_()
    {
        mGuestProvider = null;
        mAccountDataHelper = null;
        mOrderSummary = null;
    }

    public void z_()
    {
        i();
        mPresentation = null;
    }

}
