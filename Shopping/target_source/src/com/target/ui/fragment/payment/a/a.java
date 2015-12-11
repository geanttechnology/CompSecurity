// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.a;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.model.checkout.PaymentCardInformationModel;
import java.util.List;

public interface a
{

    public abstract void a(int i);

    public abstract void a(int i, int j);

    public abstract void a(int i, Menu menu, MenuInflater menuinflater);

    public abstract void a(int i, boolean flag);

    public abstract void a(OrderReview orderreview);

    public abstract void a(OrderReview orderreview, PaymentCardInformationModel paymentcardinformationmodel);

    public abstract void a(Guest guest, o o);

    public abstract void a(List list);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(int i);

    public abstract void c(int i);

    public abstract void c(PaymentCardInformationModel paymentcardinformationmodel);

    public abstract void c(boolean flag);

    public abstract void d(int i);

    public abstract void d(PaymentCardInformationModel paymentcardinformationmodel);

    public abstract void d(boolean flag);

    public abstract void e();

    public abstract void e(boolean flag);

    public abstract void f();

    public abstract void g();
}
