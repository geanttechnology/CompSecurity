// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.j.a.a;

import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.ui.fragment.checkout.a.c;
import com.target.ui.fragment.checkout.d.b;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.PaymentDetailsModel;

public class a
    implements c
{

    public a()
    {
    }

    public void a(Guest guest, PaymentDetailsModel paymentdetailsmodel, DeliveryDetailsModel deliverydetailsmodel, b b1)
    {
        boolean flag;
        if (paymentdetailsmodel.a() && paymentdetailsmodel.c().b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            b1.c(0x7f090403);
            return;
        } else
        {
            b1.E();
            return;
        }
    }
}
