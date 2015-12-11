// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.billingrecord.OrderBillingRecord;
import com.groupon.models.order.Order;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            ECommercePurchase

public class OneClickPaymentPurchase extends ECommercePurchase
{

    public static final int REQUEST_CODE = 10135;

    public OneClickPaymentPurchase()
    {
    }

    protected String getResUrl()
    {
        String s = order.billingRecord.termUrl;
        if (Strings.notEmpty(s))
        {
            return s;
        } else
        {
            return super.getResUrl();
        }
    }
}
