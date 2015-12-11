// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.manager.DealSyncManager;
import java.util.Date;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.loader:
//            DealLoader

public abstract class DealLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{

    private Context context;
    private String dealId;
    private DealSyncManager dealSyncManager;

    public DealLoaderCallbacks(Context context1, String s)
    {
        this(context1, s, null, null, false, false);
    }

    public DealLoaderCallbacks(Context context1, String s, Date date, Date date1, boolean flag, boolean flag1)
    {
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        dealId = s;
        dealSyncManager.setDealId(s);
        dealSyncManager.setCheckInDate(date);
        dealSyncManager.setCheckOutDate(date1);
        dealSyncManager.setIncludeMerchantRecommendationAndTips(flag);
        dealSyncManager.setIncludeMerchantPersona(flag1);
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new DealLoader(com/groupon/db/models/Deal, com/groupon/db/events/DealUpdateEvent, context, dealId);
    }

    public abstract void onDealLoaded(Deal deal);

    public void onLoadFinished(Loader loader, Deal deal)
    {
        if (dealSyncManager.isValid(deal))
        {
            onDealLoaded(deal);
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Deal)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }
}
