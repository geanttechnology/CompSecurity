// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.DeliveryEstimationUpdateEvent;
import com.groupon.db.models.DeliveryEstimation;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.loader:
//            DeliveryEstimationLoader

public abstract class DeliveryEstimationLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{

    private Context context;
    private String dealUuid;
    private String optionUuid;

    public DeliveryEstimationLoaderCallbacks(Context context1, String s, String s1)
    {
        RoboGuice.getInjector(context1).injectMembers(this);
        dealUuid = s;
        optionUuid = s1;
        context = context1;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new DeliveryEstimationLoader(com/groupon/db/models/DeliveryEstimation, com/groupon/db/events/DeliveryEstimationUpdateEvent, context, dealUuid, optionUuid);
    }

    public abstract void onEstimationLoaded(DeliveryEstimation deliveryestimation);

    public void onLoadFinished(Loader loader, DeliveryEstimation deliveryestimation)
    {
        onEstimationLoaded(deliveryestimation);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (DeliveryEstimation)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }
}
