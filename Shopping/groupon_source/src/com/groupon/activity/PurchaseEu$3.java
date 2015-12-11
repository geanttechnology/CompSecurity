// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.order.Order;
import com.groupon.models.payment.AbstractPaymentMethod;
import com.groupon.util.Function1;

// Referenced classes of package com.groupon.activity:
//            PurchaseEu

class val.paymentResUrl
    implements Function1
{

    final PurchaseEu this$0;
    final String val$paymentResUrl;

    public void execute(Order order)
        throws RuntimeException
    {
        if (val$paymentResUrl.contains("authResult=AUTHORISED") || val$paymentResUrl.contains("authResult=PENDING"))
        {
            PurchaseEu.access$400(PurchaseEu.this, order);
            return;
        }
        if (val$paymentResUrl.contains("authResult=CANCELLED"))
        {
            PurchaseEu.access$500(PurchaseEu.this, currentPaymentMethod.getCancelMessage());
            return;
        }
        if (val$paymentResUrl.contains("authResult=REFUSED"))
        {
            PurchaseEu.access$600(PurchaseEu.this, currentPaymentMethod.getErrorMessage());
            return;
        } else
        {
            PurchaseEu.access$600(PurchaseEu.this, 0x7f08019c);
            return;
        }
    }

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((Order)obj);
    }

    tPaymentMethod()
    {
        this$0 = final_purchaseeu;
        val$paymentResUrl = String.this;
        super();
    }
}
