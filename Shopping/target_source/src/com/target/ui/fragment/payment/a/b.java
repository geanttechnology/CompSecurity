// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.payment.a;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.c.c.a;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.services.o;
import com.target.ui.model.checkout.BillingCardDetailsModel;
import com.target.ui.model.checkout.CardDataModel;

public interface b
{

    public abstract void a(int l);

    public abstract void a(Menu menu, MenuInflater menuinflater, int l);

    public abstract void a(a a1);

    public abstract void a(Guest guest, o o1);

    public abstract void a(com.target.ui.fragment.account.a.a a1);

    public abstract void a(BillingCardDetailsModel billingcarddetailsmodel);

    public abstract void a(CardDataModel carddatamodel);

    public abstract void a(boolean flag);

    public abstract com.target.ui.view.checkout.BillingView.c b();

    public abstract void b(int l);

    public abstract void c(int l);

    public abstract void c(boolean flag);

    public abstract void d(int l);

    public abstract void d(String s);

    public abstract void d(boolean flag);

    public abstract com.target.ui.view.checkout.BillingView.b e();

    public abstract void e(boolean flag);

    public abstract void f(boolean flag);

    public abstract void g();

    public abstract void h()
        throws IllegalStateException;

    public abstract void i()
        throws IllegalStateException;

    public abstract void j();

    public abstract void k();

    public abstract void o();

    public abstract boolean p();

    public abstract void r();
}
