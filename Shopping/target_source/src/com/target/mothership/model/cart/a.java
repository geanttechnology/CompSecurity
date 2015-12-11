// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.cart;

import com.target.mothership.common.params.AddressParams;
import com.target.mothership.common.params.b;
import com.target.mothership.common.store.StoreIdentifier;
import com.target.mothership.common.tender.PaymentTender;
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

public interface a
{

    public abstract void a(Guest guest, PaymentTender paymenttender, d d1);

    public abstract void a(Guest guest, com.target.mothership.common.tender.a a1, PaymentTender paymenttender, String s, d d1);

    public abstract void a(Guest guest, com.target.mothership.model.cart.b.a a1, d d1);

    public abstract void a(Guest guest, l l, d d1);

    public abstract void a(Guest guest, CartProduct cartproduct, int i, d d1);

    public abstract void a(Guest guest, CartProduct cartproduct, d d1);

    public abstract void a(Guest guest, CartProduct cartproduct, h h, StoreIdentifier storeidentifier, boolean flag, d d1);

    public abstract void a(Guest guest, GiftProduct giftproduct, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, b b1, String s, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s, AddressParams addressparams, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.common.tender.a a1, String s, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.b b1, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, com.target.mothership.model.cart.b.d d1, d d2);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, g g1, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, i i, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, com.target.mothership.common.tender.a a1, String s1, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1);

    public abstract void a(Guest guest, InitiatedCheckout initiatedcheckout, String s, boolean flag, d d1);

    public abstract void a(Guest guest, InitiatedPayPal initiatedpaypal, OrderReview orderreview, d d1);

    public abstract void a(Guest guest, OrderReview orderreview, d d1);

    public abstract void a(Guest guest, PromoCode promocode, d d1);

    public abstract void a(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1);

    public abstract void a(Guest guest, d d1);

    public abstract void a(Guest guest, String s, BigDecimal bigdecimal, List list, d d1);

    public abstract void a(com.target.mothership.model.h h);

    public abstract void b(Guest guest, com.target.mothership.model.cart.b.a a1, d d1);

    public abstract void b(Guest guest, CartProduct cartproduct, d d1);

    public abstract void b(Guest guest, InitiatedCheckout initiatedcheckout, g g1, d d1);

    public abstract void b(Guest guest, InitiatedCheckout initiatedcheckout, d d1);

    public abstract void b(Guest guest, InitiatedCheckout initiatedcheckout, String s, d d1);

    public abstract void b(Guest guest, SaveForLaterProduct saveforlaterproduct, d d1);

    public abstract void b(Guest guest, d d1);

    public abstract void c(Guest guest, CartProduct cartproduct, d d1);

    public abstract void c(Guest guest, InitiatedCheckout initiatedcheckout, d d1);

    public abstract void c(Guest guest, d d1);

    public abstract void d(Guest guest, InitiatedCheckout initiatedcheckout, d d1);

    public abstract void d(Guest guest, d d1);

    public abstract void e(Guest guest, InitiatedCheckout initiatedcheckout, d d1);

    public abstract void f(Guest guest, InitiatedCheckout initiatedcheckout, d d1);

    public abstract void g(Guest guest, InitiatedCheckout initiatedcheckout, d d1);
}
