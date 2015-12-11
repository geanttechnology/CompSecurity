// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics.mts;

import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.common.util.EnvironmentUtils;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.AnalyticsAdapter;
import com.ebay.mobile.analytics.AnalyticsUtil;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.EbayIdentity;
import com.ebay.server_requests.InstallTracking;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.analytics.mts:
//            AnalyticsProviderModule

public class MtsAnalyticsAdapter
    implements AnalyticsAdapter
{

    private static final String ACTOR_ID = "actorId";
    static final String ADVERTISING_ID_TAG = "gadid";
    private static final String ANDROID_ID_TAG = "gdid";
    private static final String CARRIER = "carrier";
    private static final String DCS_THRESHOLD_TAG = "mrollp";
    private static final String DEVICE_NAME_TAG = "dn";
    private static final String DPI = "dpi";
    private static final String INSTALLED_APPS = "iApps";
    private static final String MEMORY_SIZE_TAG = "memsz";
    private static final String MTS_USER_NAME_TAG = "user_name";
    private static final String NETWORK_TYPE_TAG = "mnt";
    private static final String OS_NAME_TAG = "mos";
    private static final String OS_VERSION_TAG = "osv";
    private static final String PREFERRED_LANGUAGE_TAG = "prefl";
    private static final String SCREEN_RESOLUTION_TAG = "res";
    private static final String TABLET_TAG = "ist";
    private static final String TIMEZONE_NAME_TAG = "tzname";
    private String googleAdId;
    private long lastAdIdQuery;
    private Bundle lastQTags;
    private long lastQtagsHash;
    private boolean shouldTryGooglePlayServices;

    public MtsAnalyticsAdapter()
    {
        googleAdId = null;
        lastAdIdQuery = 0L;
        shouldTryGooglePlayServices = true;
        lastQtagsHash = 0L;
        lastQTags = null;
    }

    private String getNetworkType(Context context)
    {
        Object obj = null;
        Object obj1 = (ConnectivityManager)context.getSystemService("connectivity");
        context = obj;
        if (obj1 != null)
        {
            obj1 = ((ConnectivityManager) (obj1)).getActiveNetworkInfo();
            context = obj;
            if (obj1 != null)
            {
                context = ((NetworkInfo) (obj1)).getTypeName();
            }
        }
        return context;
    }

    private void populateGoogleAdvertisingId(Context context)
    {
        int i;
        if (!shouldTryGooglePlayServices)
        {
            break MISSING_BLOCK_LABEL_143;
        }
        i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(context);
        if (i != 0)
        {
            break MISSING_BLOCK_LABEL_126;
        }
        StringBuilder stringbuilder;
        context = AdvertisingIdClient.getAdvertisingIdInfo(context);
        stringbuilder = (new StringBuilder()).append(context.getId());
        if (context.isLimitAdTrackingEnabled())
        {
            context = ",0";
        } else
        {
            context = ",1";
        }
        try
        {
            googleAdId = stringbuilder.append(context).toString();
            lastAdIdQuery = System.currentTimeMillis();
            shouldTryGooglePlayServices = true;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            shouldTryGooglePlayServices = false;
        }
        googleAdId = null;
        if (AnalyticsProviderModule.debugLogger.isLoggable)
        {
            AnalyticsProviderModule.debugLogger.log((new StringBuilder()).append("Error getting google ad id: ").append(context.getMessage()).toString());
            return;
        }
        break MISSING_BLOCK_LABEL_143;
        if (i == 7)
        {
            shouldTryGooglePlayServices = true;
            return;
        }
        shouldTryGooglePlayServices = false;
    }

    private void processTrackingData(Context context, TrackingData trackingdata)
    {
        trackingdata.addSessionData("ai", "2571");
        trackingdata.addSessionData("dn", DeviceInfoUtil.getDeviceModel());
        trackingdata.addSessionData("memsz", DeviceInfoUtil.getMemorySize(context, true));
        trackingdata.addSessionData("mnt", getNetworkType(context));
        trackingdata.addSessionData("prefl", DeviceInfoUtil.getPreferredLanguage());
        trackingdata.addSessionData("res", DeviceInfoUtil.getScreenResolution(context));
        trackingdata.addSessionData("tzname", DeviceInfoUtil.getTimezoneName());
        trackingdata.addSessionData("tz", DeviceInfoUtil.getTimezone());
        trackingdata.addSessionData("carrier", DeviceInfoUtil.getCarrier(context));
        trackingdata.addSessionData("dpi", DeviceInfoUtil.getScreenDpi(context));
        trackingdata.addSessionData("iApps", AnalyticsUtil.getInstalledAppsList(MyApp.getDeviceConfiguration(), context));
        Object obj;
        Object obj1;
        long l;
        long l1;
        if (context.getResources().getBoolean(0x7f0b0006))
        {
            obj = "1";
        } else
        {
            obj = "0";
        }
        trackingdata.addSessionData("ist", ((String) (obj)));
        if (EnvironmentUtils.isBlackberry())
        {
            trackingdata.addSessionData("mos", "Blackberry");
            trackingdata.addSessionData("osv", "10");
        } else
        {
            trackingdata.addSessionData("mos", "Android");
            trackingdata.addSessionData("osv", android.os.Build.VERSION.RELEASE);
        }
        obj = DeviceConfiguration.getAsync();
        trackingdata.addSessionData("mrollp", String.valueOf(((DeviceConfiguration) (obj)).getState().rolloutThreshold));
        obj1 = MyApp.getPrefs();
        if (obj1 != null)
        {
            trackingdata.addSessionData("site", String.valueOf(((Preferences) (obj1)).getCurrentCountry().getSiteId()));
            trackingdata.addSessionData("user_name", ((Preferences) (obj1)).getCurrentUser());
            Authentication authentication = ((Preferences) (obj1)).getAuthentication();
            if (authentication != null)
            {
                trackingdata.addSessionData("iafToken", authentication.iafToken);
            }
            obj1 = ((Preferences) (obj1)).getUserPref("mims_actor_id", null);
            if (obj1 != null)
            {
                trackingdata.addSessionData("actorId", ((String) (obj1)));
            }
        }
        obj1 = InstallTracking.getPreInstallData(context);
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            obj1 = Uri.parse(((String) (obj1)));
            boolean flag = false;
            String s1 = ((Uri) (obj1)).getQueryParameter("mppid");
            if (s1 != null)
            {
                trackingdata.addSessionData("mppid", s1);
                flag = true;
            }
            obj1 = ((Uri) (obj1)).getQueryParameter("rlutype");
            if (obj1 != null)
            {
                trackingdata.addSessionData("rlutype", ((String) (obj1)));
                flag = true;
            }
            if (flag)
            {
                trackingdata.addSessionData("usecase", "prm");
            }
        } else
        {
            trackingdata.addSessionData("mppid", "0");
        }
        obj1 = trackingdata.getName();
        if ("Referral".equals(obj1))
        {
            trackingdata.addKeyValuePair("udid", EbayIdentity.getDeviceIdString(context));
        }
        trackingdata.addSessionData("gdid", android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id"));
        if (((DeviceConfiguration) (obj)).get(DcsBoolean.advertisingId))
        {
            if (googleAdId == null || System.currentTimeMillis() - lastAdIdQuery > 0x36ee80L)
            {
                populateGoogleAdvertisingId(context);
            }
            trackingdata.addSessionData("gadid", googleAdId);
        }
        if ("Background".equals(obj1))
        {
            googleAdId = null;
            shouldTryGooglePlayServices = true;
            lastAdIdQuery = 0L;
        }
        context = trackingdata.getSessionData();
        l = 0L;
        if (context.containsKey("qTags"))
        {
            lastQTags = context.getBundle("qTags");
            trackingdata.removeSessionData("qTags");
        }
        l1 = l;
        if (lastQTags != null)
        {
            context = lastQTags.keySet().iterator();
            do
            {
                l1 = l;
                if (!context.hasNext())
                {
                    break;
                }
                obj = (String)context.next();
                String s = lastQTags.getString(((String) (obj)));
                trackingdata.addSessionData(((String) (obj)), s);
                l = l ^ (long)((String) (obj)).hashCode() ^ (long)s.hashCode();
            } while (true);
        }
        if (lastQtagsHash != l1)
        {
            AnalyticsProviderModule.debugLogger.log("qTags has changed; forcing flush");
            trackingdata.setFlush(true);
            lastQtagsHash = l1;
        }
    }

    public boolean adapt(Context context, TrackingData trackingdata)
    {
        if (trackingdata != null && context != null)
        {
            processTrackingData(context, trackingdata);
            return true;
        }
        if (AnalyticsProviderModule.debugLogger.isLoggable)
        {
            AnalyticsProviderModule.debugLogger.log("Unable to adapt null TrackingData object in MTS adapter.");
        }
        return false;
    }
}
