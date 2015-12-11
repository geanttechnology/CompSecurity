// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import android.content.Intent;
import android.os.Bundle;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.shell.app.BaseIntentService;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.analytics:
//            AnalyticsUtil, AnalyticsAdapter, AnalyticsProvider

public class AnalyticsService extends BaseIntentService
{

    public AnalyticsService()
    {
        super(com/ebay/mobile/analytics/AnalyticsService.getSimpleName());
    }

    protected void onHandleIntent(Intent intent)
    {
        TrackingData trackingdata = (TrackingData)intent.getExtras().getParcelable("com.ebay.common.model.analytics.tracking_data");
        Set set = AnalyticsUtil.getEnabledProviders();
        if (set == null || set.isEmpty())
        {
            if (AnalyticsUtil.debugLogger.isLoggable)
            {
                AnalyticsUtil.debugLogger.logAsWarning("No Analytics Providers found!");
            }
        } else
        {
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) 
            {
                AnalyticsUtil.ProviderWrapper providerwrapper = (AnalyticsUtil.ProviderWrapper)iterator.next();
                boolean flag;
                if (set.size() == 1)
                {
                    intent = trackingdata;
                } else
                {
                    intent = new TrackingData(trackingdata);
                }
                flag = providerwrapper.adapter.adapt(this, intent);
                if (AnalyticsUtil.debugLogger.isLoggable)
                {
                    com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo = AnalyticsUtil.debugLogger;
                    Locale locale = Locale.US;
                    String s1 = providerwrapper.adapter.getClass().getSimpleName();
                    String s;
                    if (flag)
                    {
                        s = "handles";
                    } else
                    {
                        s = "doesn't handle";
                    }
                    loginfo.log(String.format(locale, "%s %s bundle: %s", new Object[] {
                        s1, s, trackingdata.toString()
                    }));
                }
                if (flag)
                {
                    providerwrapper.provider.start(this, intent);
                }
            }
        }
    }
}
