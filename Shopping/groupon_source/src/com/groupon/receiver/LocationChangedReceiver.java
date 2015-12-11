// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.commonsware.cwac.wakeful.WakefulIntentService;
import com.google.inject.Injector;
import com.groupon.abtest.LocalizedMobileAppAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.models.country.Country;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.tracking.mobile.sdk.NoScheduledUploadLogger;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import roboguice.RoboGuice;
import roboguice.util.Ln;
import roboguice.util.Strings;

public class LocationChangedReceiver extends BroadcastReceiver
{

    public LocationChangedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        Ln.d("Received LocationChangedReceiver", new Object[0]);
        if (intent.getExtras().containsKey("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo"))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        Ln.d("LocationChangedReceiver ended, because com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo is missing in the intent", new Object[0]);
_L1:
        return;
        context;
        return;
        intent = (LocationInfo)intent.getSerializableExtra("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo");
        if ((int)((LocationInfo) (intent)).lastLat == -2147)
        {
            Ln.d("LocationChangedReceiver ended, because lastLat == -2147", new Object[0]);
            return;
        }
        Object obj = RoboGuice.getInjector(context);
        NoScheduledUploadLogger noscheduleduploadlogger = (NoScheduledUploadLogger)((Injector) (obj)).getInstance(com/groupon/tracking/mobile/sdk/NoScheduledUploadLogger);
        IntentFactory intentfactory = (IntentFactory)((Injector) (obj)).getInstance(com/groupon/activity/IntentFactory);
        AbTestService abtestservice = (AbTestService)((Injector) (obj)).getInstance(com/groupon/service/core/AbTestService);
        LocalizedMobileAppAbTestHelper localizedmobileappabtesthelper = (LocalizedMobileAppAbTestHelper)((Injector) (obj)).getInstance(com/groupon/abtest/LocalizedMobileAppAbTestHelper);
        CurrentCountryManager currentcountrymanager = (CurrentCountryManager)((Injector) (obj)).getInstance(com/groupon/service/countryanddivision/CurrentCountryManager);
        obj = (SharedPreferences)((Injector) (obj)).getInstance(android/content/SharedPreferences);
        if (currentcountrymanager.getCurrentCountry() != null)
        {
            noscheduleduploadlogger.logLocationTracking("", ((LocationInfo) (intent)).lastLat, ((LocationInfo) (intent)).lastLong, ((LocationInfo) (intent)).lastAccuracy, ((LocationInfo) (intent)).lastLocationUpdateTimestamp, Logger.NULL_NST_FIELD);
            Ln.d("Logging location %s,%s (%sm accuracy)", new Object[] {
                Float.valueOf(((LocationInfo) (intent)).lastLat), Float.valueOf(((LocationInfo) (intent)).lastLong), Long.valueOf(((LocationInfo) (intent)).lastLocationUpdateTimestamp)
            });
            if (localizedmobileappabtesthelper.getLocalizedMobileVariant().isEnabled())
            {
                Ln.d("LocalizedMobileApp: Starting localized mobile app service", new Object[0]);
                context.startService(intentfactory.newLocalizedMobileAppServiceIntent(intent));
            }
            if (Strings.equalsIgnoreCase(abtestservice.getVariant("proximityNotifications1409USCA"), "on") && currentcountrymanager.getCurrentCountry().isUSACompatible())
            {
                Ln.d("Proximity_Notifications: Starting PBN service from little fluffy", new Object[0]);
                WakefulIntentService.sendWakefulWork(context, intentfactory.newProximityBasedNotificationServiceDistanceActivityCheckIntent(intent));
                return;
            }
            if (((SharedPreferences) (obj)).getBoolean("proximityNotificationSeenByUser", false))
            {
                WakefulIntentService.sendWakefulWork(context, intentfactory.newProximityBasedNotificationClearGeofenceOnAbtestChangeIntent());
                Ln.d("Proximity_Notifications: Not starting PBN service from little fluffy", new Object[0]);
                return;
            }
        }
          goto _L1
    }
}
