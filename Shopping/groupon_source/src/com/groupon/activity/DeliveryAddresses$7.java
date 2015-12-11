// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.Loader;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.util.DealUtils;
import com.groupon.view.DealCardCompact;

// Referenced classes of package com.groupon.activity:
//            DeliveryAddresses

class nit> extends DealLoaderCallbacks
{

    final DeliveryAddresses this$0;
    final boolean val$isCartExperience;

    public void onDealLoaded(Deal deal)
    {
        dealCardCompact.setInfo(new DealSummary(deal, channel), DealUtils.getOption(deal, optionId));
    }

    public void onLoadFinished(Loader loader, Deal deal)
    {
        boolean flag = false;
        super.onLoadFinished(loader, deal);
        dealCardCompact.setLoading(false);
        loader = dealCardCompact;
        int i = ((flag) ? 1 : 0);
        if (deal == null)
        {
            if (val$isCartExperience)
            {
                i = ((flag) ? 1 : 0);
            } else
            {
                i = 8;
            }
        }
        loader.setVisibility(i);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Deal)obj);
    }

    (String s, boolean flag)
    {
        this$0 = final_deliveryaddresses;
        val$isCartExperience = flag;
        super(Context.this, s);
    }
}
