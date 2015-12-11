// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.callbacks;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.DealClickListener;
import com.groupon.db.models.DealSummary;
import com.groupon.models.country.Country;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.util.BuyUtils;
import com.groupon.util.LoggingUtils;
import java.lang.ref.WeakReference;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class MapViewDealClickCallback
    implements DealClickListener
{

    BuyUtils buyUtil;
    private WeakReference contextRef;
    CurrentCountryManager currentCountryManager;
    IntentFactory intentFactory;
    LoggingUtils loggingUtils;

    public MapViewDealClickCallback(Context context)
    {
        contextRef = new WeakReference(context);
        RoboGuice.getInjector(context).injectMembers(this);
    }

    public void onDealClicked(int i, DealSummary dealsummary)
    {
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = dealsummary.optionDimensionsCount(flag, currentCountryManager.getCurrentCountry().isUSACompatible());
        if (buyUtil.showOptionsWithImages(dealsummary, (Context)contextRef.get()))
        {
            ((Context)contextRef.get()).startActivity(intentFactory.newGoodsMultiOptionIntent(dealsummary.remoteId, Channel.GLOBAL_SEARCH, i));
        } else
        {
            android.content.Intent intent = intentFactory.newDealIntent(dealsummary, Channel.GLOBAL_SEARCH, null);
            ((Context)contextRef.get()).startActivity(intent);
        }
        loggingUtils.logClick("", "search_result_click", "global_search", dealsummary.remoteId);
    }
}
