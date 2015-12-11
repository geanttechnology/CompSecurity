// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart;

import com.target.mothership.b;
import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.tender.PaymentTender;
import com.target.mothership.model.a;
import com.target.mothership.model.cart.b.g;
import com.target.mothership.model.cart.b.i;
import com.target.mothership.model.cart.b.l;
import com.target.mothership.model.cart.interfaces.CartProduct;
import com.target.mothership.model.cart.interfaces.GiftProduct;
import com.target.mothership.model.cart.interfaces.InitiatedCheckout;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.SaveForLaterProduct;
import com.target.mothership.model.d;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.apigee.c.a.h;
import java.math.BigDecimal;
import java.util.List;

// Referenced classes of package com.target.mothership.model.cart:
//            d, b, a

public class c extends a
{

    private final com.target.mothership.model.cart.a mCartDataSource;

    public c()
    {
        if (com.target.mothership.b.a().m())
        {
            mCartDataSource = new com.target.mothership.model.cart.d();
            return;
        } else
        {
            mCartDataSource = new com.target.mothership.model.cart.b();
            return;
        }
    }

    public void a(Guest guest, com.target.mothership.model.cart.b.a a1, d d1)
    {
        mCartDataSource.a(guest, a1, d1);
    }

    public void a(Guest guest, l l, d d1)
    {
        mCartDataSource.a(guest, l, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, int i, d d1)
    {
        mCartDataSource.a(guest, cartproduct, i, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, d d1)
    {
        mCartDataSource.a(guest, cartproduct, d1);
    }

    public void a(Guest guest, CartProduct cartproduct, h h, StoreIdentifier storeidentifier, boolean flag, d d1)
    {
        mCartDataSource.a(guest, cartproduct, h, storeidentifier, flag, d1);
    }

    public void a(Guest guest, GiftProduct giftproduct, d d1)
    {
        mCartDataSource.a(guest, giftproduct, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.params.b b1, String s, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, b1, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, PaymentTender paymenttender, d d1)
    {
        mCartDataSource.a(guest, paymenttender, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, PaymentTender paymenttender, String s, d d1)
    {
        mCartDataSource.a(guest, a1, paymenttender, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s, AddressParams addressparams, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, a1, s, addressparams, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, a1, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.b b1, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, b1, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.d d1, d d2)
    {
        mCartDataSource.a(guest, initiatedcheckout, d1, d2);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, g g1, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, g1, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, i i, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, i, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, com.target.mothership.common.tender.a a1, String s1, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, s, a1, s1, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, s, d1);
    }

    public void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, boolean flag, d d1)
    {
        mCartDataSource.a(guest, initiatedcheckout, s, flag, d1);
    }

    public void a(Guest guest, InitiatedPayPal initiatedpaypal, OrderReview orderreview, d d1)
    {
        mCartDataSource.a(guest, initiatedpaypal, orderreview, d1);
    }

    public void a(Guest guest, OrderReview orderreview, d d1)
    {
        mCartDataSource.a(guest, orderreview, d1);
    }

    public void a(Guest guest, PromoCode promocode, d d1)
    {
        mCartDataSource.a(guest, promocode, d1);
    }

    public void a(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1)
    {
        mCartDataSource.a(guest, saveforlaterproduct, d1);
    }

    public void a(Guest guest, d d1)
    {
        mCartDataSource.a(guest, d1);
    }

    public void a(Guest guest, String s, BigDecimal bigdecimal, List list, d d1)
    {
        mCartDataSource.a(guest, s, bigdecimal, list, d1);
    }

    public void a(com.target.mothership.model.h h)
    {
        mCartDataSource.a(h);
    }

    public void b(Guest guest, com.target.mothership.model.cart.b.a a1, d d1)
    {
        mCartDataSource.b(guest, a1, d1);
    }

    public void b(Guest guest, CartProduct cartproduct, d d1)
    {
        mCartDataSource.b(guest, cartproduct, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, g g1, d d1)
    {
        mCartDataSource.b(guest, initiatedcheckout, g1, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.b(guest, initiatedcheckout, d1);
    }

    public void b(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1)
    {
        mCartDataSource.b(guest, initiatedcheckout, s, d1);
    }

    public void b(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1)
    {
        mCartDataSource.b(guest, saveforlaterproduct, d1);
    }

    public void b(Guest guest, d d1)
    {
        mCartDataSource.b(guest, d1);
    }

    public void c(Guest guest, CartProduct cartproduct, d d1)
    {
        mCartDataSource.c(guest, cartproduct, d1);
    }

    public void c(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.c(guest, initiatedcheckout, d1);
    }

    public void c(Guest guest, d d1)
    {
        mCartDataSource.c(guest, d1);
    }

    public void d(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.d(guest, initiatedcheckout, d1);
    }

    public void d(Guest guest, d d1)
    {
        mCartDataSource.d(guest, d1);
    }

    public void e(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.e(guest, initiatedcheckout, d1);
    }

    public void f(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.f(guest, initiatedcheckout, d1);
    }

    public void g(Guest guest, InitiatedCheckout initiatedcheckout, d d1)
    {
        mCartDataSource.g(guest, initiatedcheckout, d1);
    }
}
