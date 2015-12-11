// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout.d;

import com.target.mothership.model.cart.interfaces.AppliedTenders;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.coupon_wallets.interfaces.WalletItem;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.PaymentDetailsModel;
import java.util.List;

public interface a
{

    public abstract OrderReview J();

    public abstract DeliveryDetailsModel K();

    public abstract PaymentDetailsModel L();

    public abstract List M();

    public abstract boolean N();

    public abstract boolean O();

    public abstract void a(AppliedTenders appliedtenders);

    public abstract void b(WalletItem walletitem);

    public abstract void b(DeliveryDetailsModel deliverydetailsmodel);

    public abstract void b(PaymentDetailsModel paymentdetailsmodel);

    public abstract void d(OrderReview orderreview);

    public abstract void g(List list);

    public abstract void h(List list);

    public abstract void k(boolean flag);

    public abstract void l(boolean flag);
}
