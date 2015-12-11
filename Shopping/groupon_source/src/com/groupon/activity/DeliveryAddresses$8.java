// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.service.ShippingService;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class kdownAddress
    implements android.view.
{

    final DeliveryAddresses this$0;
    final DealBreakdownAddress val$location;

    public void onClick(View view)
    {
        DeliveryAddresses.access$500(DeliveryAddresses.this).storeMultipleShipping(val$location);
        if (DeliveryAddresses.access$600(DeliveryAddresses.this))
        {
            DeliveryAddresses.access$700(DeliveryAddresses.this, view);
            return;
        } else
        {
            setResultAndFinish();
            return;
        }
    }

    kdownAddress()
    {
        this$0 = final_deliveryaddresses;
        val$location = DealBreakdownAddress.this;
        super();
    }
}
