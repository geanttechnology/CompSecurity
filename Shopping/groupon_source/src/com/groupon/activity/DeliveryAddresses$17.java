// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class downAddress
    implements android.view.sses._cls17
{

    final DeliveryAddresses this$0;
    final DealBreakdownAddress val$location;

    public void onClick(View view)
    {
        DeliveryAddresses.access$400(DeliveryAddresses.this, val$location);
    }

    downAddress()
    {
        this$0 = final_deliveryaddresses;
        val$location = DealBreakdownAddress.this;
        super();
    }
}
