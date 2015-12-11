// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.account.b;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.guest.interfaces.AppliedPayPalDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.model.guest.interfaces.OrderDetailsProduct;
import com.target.mothership.services.o;
import com.target.ui.view.BitmapImageView;
import java.util.List;

public interface b
{

    public abstract void a();

    public abstract void a(int j);

    public abstract void a(Menu menu, MenuInflater menuinflater, int j);

    public abstract void a(AppliedPayPalDetails appliedpaypaldetails, String s);

    public abstract void a(Guest guest, o o);

    public abstract void a(List list);

    public abstract void a(List list, String s);

    public abstract void a(boolean flag);

    public abstract void b();

    public abstract void b(int j);

    public abstract void b(OrderDetailsProduct orderdetailsproduct, BitmapImageView bitmapimageview);

    public abstract void c(String s);

    public abstract void d(String s);

    public abstract void e();

    public abstract void e(String s);

    public abstract void f(String s);

    public abstract void g();

    public abstract void g(String s);

    public abstract void h(String s);

    public abstract void i();
}
