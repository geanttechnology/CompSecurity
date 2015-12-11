// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.d;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.target.mothership.model.cart.interfaces.InitiatedPayPal;
import com.target.mothership.model.cart.interfaces.OrderCompletionDetails;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.a.c;
import com.target.mothership.model.cart.interfaces.a.e;
import com.target.mothership.model.cart.interfaces.a.g;
import com.target.mothership.model.common.AppliedPaymentCardTender;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.fragment.checkout.d.a.a;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.PayPalDisplayDetails;
import com.target.ui.model.checkout.PaymentDetailsModel;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.checkout.d:
//            c

public interface b
{

    public abstract void A();

    public abstract void B();

    public abstract void C();

    public abstract void D();

    public abstract void E();

    public abstract void F();

    public abstract void G();

    public abstract void H();

    public abstract a I();

    public abstract void a(int k);

    public abstract void a(int k, int l);

    public abstract void a(int k, int l, com.target.ui.fragment.checkout.a a1);

    public abstract void a(Menu menu, MenuInflater menuinflater, int k);

    public abstract void a(MenuItem menuitem, boolean flag);

    public abstract void a(InitiatedPayPal initiatedpaypal);

    public abstract void a(OrderCompletionDetails ordercompletiondetails);

    public abstract void a(OrderReview orderreview, DeliveryDetailsModel deliverydetailsmodel);

    public abstract void a(c c1);

    public abstract void a(e e1);

    public abstract void a(g g1);

    public abstract void a(AppliedPaymentCardTender appliedpaymentcardtender);

    public abstract void a(AppliedPaymentCardTender appliedpaymentcardtender, List list, BigDecimal bigdecimal);

    public abstract void a(Guest guest, o o, com.target.ui.fragment.checkout.d.c c1);

    public abstract void a(DeliveryDetailsModel deliverydetailsmodel);

    public abstract void a(DeliveryDetailsModel deliverydetailsmodel, boolean flag);

    public abstract void a(PayPalDisplayDetails paypaldisplaydetails);

    public abstract void a(PaymentDetailsModel paymentdetailsmodel);

    public abstract void a(ArrayList arraylist);

    public abstract void a(List list, boolean flag, boolean flag1);

    public abstract void a(boolean flag);

    public abstract void b(int k);

    public abstract void b(int k, int l);

    public abstract void b(OrderReview orderreview);

    public abstract void b(PromoCode promocode);

    public abstract void b(c c1);

    public abstract void b(EmailRecipientDetailsModel emailrecipientdetailsmodel);

    public abstract void b(PickUpPersonDetailsModel pickuppersondetailsmodel);

    public abstract void b(SmsRecipientDetailsModel smsrecipientdetailsmodel);

    public abstract void c(int k);

    public abstract void c(OrderReview orderreview);

    public abstract void c(List list);

    public abstract void c(boolean flag);

    public abstract void d(int k);

    public abstract void d(List list);

    public abstract void d(boolean flag);

    public abstract void e(int k);

    public abstract void e(List list);

    public abstract void e(boolean flag);

    public abstract void f(int k);

    public abstract void f(String s1);

    public abstract void f(List list);

    public abstract void f(boolean flag);

    public abstract void g(int k);

    public abstract void g(String s1);

    public abstract void g(boolean flag);

    public abstract void h(String s1);

    public abstract void h(boolean flag);

    public abstract void i(String s1);

    public abstract void i(boolean flag);

    public abstract void j(boolean flag);

    public abstract void r();

    public abstract void s();

    public abstract void t();

    public abstract void u();

    public abstract void v();

    public abstract void w();

    public abstract void x();

    public abstract void y();

    public abstract void z();
}
