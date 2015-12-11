// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.callbacks.DeliveryEstimationSyncCallback;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.manager.DeliveryEstimationSyncManager;

// Referenced classes of package com.groupon.activity:
//            DealDetails

class ionSyncManager extends DeliveryEstimationSyncCallback
{

    final DealDetails this$0;

    public void addDeliveryEstimationWidget(DeliveryEstimation deliveryestimation)
    {
        DealDetails.access$800(DealDetails.this, deliveryestimation);
    }

    ionSyncManager(Context context, DeliveryEstimationSyncManager deliveryestimationsyncmanager)
    {
        this$0 = DealDetails.this;
        super(context, deliveryestimationsyncmanager);
    }
}
