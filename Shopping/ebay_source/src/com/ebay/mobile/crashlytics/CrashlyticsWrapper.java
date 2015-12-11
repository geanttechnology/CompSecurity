// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.crashlytics;

import android.content.Context;
import android.text.TextUtils;
import com.crashlytics.android.Crashlytics;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.shell.app.ActivityShim;
import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Kit;
import java.util.Locale;
import java.util.TimeZone;

public class CrashlyticsWrapper extends ActivityShim
{

    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo debugLogger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CrashlyticsLogger", 3, "Log Crashlytics events");
    private static volatile boolean isInitialized;

    public CrashlyticsWrapper()
    {
    }

    public static void log(String s)
    {
        if (!isInitialized)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("crashlytics wrapper not initialized, log() aborted");
            }
            return;
        } else
        {
            Crashlytics.log(s);
            return;
        }
    }

    public static void updateMetadata(Context context)
    {
        if (!isInitialized)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("crashlytics wrapper not initialized, updateMetadata() aborted");
            }
        } else
        {
            Object obj = MyApp.getPrefs();
            EbayCountry ebaycountry = ((Preferences) (obj)).getCurrentCountry();
            String s = ((Preferences) (obj)).getCurrentUser();
            obj = s;
            if (TextUtils.isEmpty(s))
            {
                obj = "<not-signed-in>";
            }
            Crashlytics.setUserIdentifier(((String) (obj)));
            Crashlytics.setString("site", ebaycountry.site.idString);
            Crashlytics.setString("country", ebaycountry.getCountryCode());
            Crashlytics.setString("locale", Locale.getDefault().toString());
            Crashlytics.setString("tz", TimeZone.getDefault().getDisplayName(false, 0));
            Crashlytics.setInt("carrier_id", 0);
            if (NautilusKernel.isQaMode())
            {
                obj = "QA";
            } else
            {
                obj = "prod";
            }
            Crashlytics.setString("env", ((String) (obj)));
            if (context != null)
            {
                Crashlytics.setString("mobile_carrier", DeviceInfoUtil.getCarrier(context));
                Crashlytics.setString("mobile_network", DeviceInfoUtil.getMobileNetworkType(context));
                Crashlytics.setString("network_type", DeviceInfoUtil.getNetworkType(context));
                return;
            }
        }
    }

    protected void onResume()
    {
        android.app.Activity activity = getActivity();
        super.onResume();
        if (!isInitialized)
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            if (deviceconfiguration.get(DcsBoolean.crashlytics) && !deviceconfiguration.isStale())
            {
                Fabric.with(activity, new Kit[] {
                    new Crashlytics()
                });
                isInitialized = true;
                if (debugLogger.isLoggable)
                {
                    debugLogger.log("crashlytics wrapper initialized");
                }
            }
        }
        if (!isInitialized)
        {
            if (debugLogger.isLoggable)
            {
                debugLogger.log("crashlytics wrapper not initialized, onResume() aborted");
            }
            return;
        } else
        {
            String s = activity.getClass().getSimpleName();
            Crashlytics.setString("activity", s);
            Crashlytics.log((new StringBuilder()).append(s).append(".onResume()").toString());
            updateMetadata(activity);
            return;
        }
    }

}
