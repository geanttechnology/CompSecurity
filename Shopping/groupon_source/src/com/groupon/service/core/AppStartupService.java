// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core;

import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.provider.KochavaProvider;
import com.groupon.service.AttributionService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.tracking.mobile.sdk.LoggerClientListener;
import com.kochava.android.tracker.Feature;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service.core:
//            CoreService

public class AppStartupService extends CoreService
{

    private static final String FIRST_OPEN = "first_open";
    private AttributionService attributionService;
    private ConsumerDeviceSettings consumerDeviceSettings;
    private KochavaProvider kochavaProvider;
    private Logger logger;
    private LoggerClientListener loggerClientListener;
    private PackageInfo packageInfo;
    private SharedPreferences sharedPreferences;

    public AppStartupService()
    {
    }

    public boolean isDownloadingDataFromNetwork()
    {
        return false;
    }

    protected boolean isUpToDate()
    {
        return false;
    }

    public void refresh()
        throws Exception
    {
        logger.logGeneralEvent("Application", "startup", packageInfo.versionName, 1, Logger.NULL_NST_FIELD);
        boolean flag = sharedPreferences.getBoolean("attributionFirstLaunchRecorded", false);
        Ln.d("FirstLaunchAfterDownload: firstLaunchAlreadyRecorded %s", new Object[] {
            Boolean.valueOf(flag)
        });
        if (!flag)
        {
            kochavaProvider.get().event("first_open", consumerDeviceSettings.getBcookie());
            logger.logFirstLaunchAfterDownload("", attributionService.getAttributionDownloadUrl(), attributionService.getAttributionDownloadId(), attributionService.getAttributionDownloadCid(), "", Logger.NULL_NST_FIELD);
            sharedPreferences.edit().putBoolean("attributionFirstLaunchRecorded", true).apply();
        }
        if (!sharedPreferences.getBoolean("countrySelected", false))
        {
            logger.logGeneralEvent("application", "first_country_selection", loggerClientListener.getCountryCode(), 0, Logger.NULL_NST_FIELD);
            sharedPreferences.edit().putBoolean("countrySelected", true).apply();
        }
    }

    public void resetToNotUpToDate()
    {
    }
}
