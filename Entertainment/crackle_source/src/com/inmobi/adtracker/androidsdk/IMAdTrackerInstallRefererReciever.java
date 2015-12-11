// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.adtracker.androidsdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.inmobi.adtracker.androidsdk.impl.IMAdTrackerAnalyticsConstants;
import com.inmobi.adtracker.androidsdk.impl.net.IMAdTrackerNetworkInterface;

// Referenced classes of package com.inmobi.adtracker.androidsdk:
//            IMAdTrackerAnalytics

public class IMAdTrackerInstallRefererReciever extends BroadcastReceiver
{

    public IMAdTrackerInstallRefererReciever()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        if (intent.getAction().equals(IMAdTrackerAnalyticsConstants.REFERRER_INTENT_ACTION))
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Received INSTALL REFERRER");
            }
            intent = intent.getExtras().getString(IMAdTrackerAnalyticsConstants.MARKET_REFERRER);
            IMAdTrackerAnalytics.getInstance().setReferer(context, intent);
        } else
        if (intent.getAction().equals(IMAdTrackerAnalyticsConstants.CONNECTIVITY_INTENT_ACTION))
        {
            if (IMAdTrackerAnalyticsConstants.LOG_LEVEL_DEBUG.getValue() >= IMAdTrackerUtil.LOG_LEVEL.VERBOSE.getValue())
            {
                Log.d(IMAdTrackerAnalyticsConstants.DEBUG_TAG, "Received CONNECTIVITY BROADCAST");
            }
            IMAdTrackerNetworkInterface.init();
            IMAdTrackerNetworkInterface.reportOnConnected();
            return;
        }
    }
}
