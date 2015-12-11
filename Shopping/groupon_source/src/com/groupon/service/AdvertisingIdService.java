// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.Application;
import android.content.SharedPreferences;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.service:
//            AdvertisingIdTask

public class AdvertisingIdService
{

    private static final String LIMITED_TRACKING_ADVERTISING_ID = "00000000-0000-0000-0000-000000000000";
    private static final String UNAVAILABLE_ADVERTISING_ID = null;
    private static final int UPDATE_INTERVAL_IN_MS = 0x5265c00;
    Application application;
    Logger logger;
    SharedPreferences prefs;

    public AdvertisingIdService()
    {
    }

    private void checkAdvertisingId()
    {
        long l = prefs.getLong("advertisingIdLastUpdate", 0L);
        l = System.currentTimeMillis() - l;
        if (l < 0L || l > 0x5265c00L)
        {
            refreshAdvertisingId();
        }
    }

    public String getAdvertisingId()
    {
        checkAdvertisingId();
        if (prefs.contains("limitAdTracking"))
        {
            if (prefs.getBoolean("limitAdTracking", true))
            {
                return "00000000-0000-0000-0000-000000000000";
            } else
            {
                return prefs.getString("advertisingId", UNAVAILABLE_ADVERTISING_ID);
            }
        } else
        {
            return UNAVAILABLE_ADVERTISING_ID;
        }
    }

    public void refreshAdvertisingId()
    {
        ((AdvertisingIdTask)RoboGuice.getInjector(application).getInstance(com/groupon/service/AdvertisingIdTask)).execute(new Void[0]);
    }

}
