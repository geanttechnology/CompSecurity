// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.loader.DeliveryEstimationLoaderCallbacks;
import com.groupon.manager.DeliveryEstimationSyncManager;

public abstract class DeliveryEstimationLoaderCallback extends DeliveryEstimationLoaderCallbacks
{

    private DeliveryEstimationSyncManager deliveryEstimationSyncManager;

    public DeliveryEstimationLoaderCallback(Context context, String s, String s1)
    {
        super(context, s, s1);
    }

    protected abstract void onDeliveryEstimationLoaded(DeliveryEstimation deliveryestimation);

    public void onEstimationLoaded(DeliveryEstimation deliveryestimation)
    {
        if (deliveryestimation != null && deliveryEstimationSyncManager.isEstimationValid(deliveryestimation))
        {
            onDeliveryEstimationLoaded(deliveryestimation);
            if (!deliveryEstimationSyncManager.hasAutomaticSyncBeenStarted())
            {
                onEstimationSyncRequested();
            }
            return;
        }
        if (deliveryEstimationSyncManager.isEstimationDownloaded() && deliveryestimation == null)
        {
            onDeliveryEstimationLoaded(null);
            return;
        } else
        {
            onEstimationSyncRequested();
            return;
        }
    }

    protected abstract void onEstimationSyncRequested();
}
