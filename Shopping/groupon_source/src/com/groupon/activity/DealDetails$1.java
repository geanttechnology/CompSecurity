// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.callbacks.DeliveryEstimationLoaderCallback;
import com.groupon.db.models.DeliveryEstimation;

// Referenced classes of package com.groupon.activity:
//            DealDetails

class ationLoaderCallback extends DeliveryEstimationLoaderCallback
{

    final DealDetails this$0;

    public void onDeliveryEstimationLoaded(DeliveryEstimation deliveryestimation)
    {
        DealDetails.access$800(DealDetails.this, deliveryestimation);
    }

    public void onEstimationSyncRequested()
    {
        DealDetails.access$900(DealDetails.this);
    }

    ation(Context context, String s, String s1)
    {
        this$0 = DealDetails.this;
        super(context, s, s1);
    }
}
