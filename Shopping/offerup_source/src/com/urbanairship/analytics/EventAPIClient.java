// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.analytics;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.http.Request;
import com.urbanairship.http.RequestFactory;
import com.urbanairship.location.UALocationManager;
import com.urbanairship.push.PushManager;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushUser;
import com.urbanairship.util.ManifestUtils;
import com.urbanairship.util.Network;
import com.urbanairship.util.UAStringUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.urbanairship.analytics:
//            EventResponse

class EventAPIClient
{

    static final String ALWAYS_ALLOWED = "ALWAYS_ALLOWED";
    static final String NOT_ALLOWED = "NOT_ALLOWED";
    static final String SYSTEM_LOCATION_DISABLED = "SYSTEM_LOCATION_DISABLED";
    private final RequestFactory requestFactory;

    EventAPIClient()
    {
        this(new RequestFactory());
    }

    EventAPIClient(RequestFactory requestfactory)
    {
        requestFactory = requestfactory;
    }

    static String getLocationPermission()
    {
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            if (UAirship.getApplicationContext().checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || UAirship.getApplicationContext().checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0)
            {
                return "ALWAYS_ALLOWED";
            } else
            {
                return "NOT_ALLOWED";
            }
        }
        if (android.os.Build.VERSION.SDK_INT < 19)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        i = 0;
        int j = android.provider.Settings.Secure.getInt(UAirship.getApplicationContext().getContentResolver(), "location_mode");
        i = j;
_L1:
        android.provider.Settings.SettingNotFoundException settingnotfoundexception;
        if (i != 0)
        {
            return getLocationPermissionForApp();
        } else
        {
            return "SYSTEM_LOCATION_DISABLED";
        }
        settingnotfoundexception;
        Logger.debug("EventAPIClient - Settings not found.");
          goto _L1
        if (!UAStringUtil.isEmpty(android.provider.Settings.Secure.getString(UAirship.getApplicationContext().getContentResolver(), "location_providers_allowed")))
        {
            return getLocationPermissionForApp();
        } else
        {
            return "SYSTEM_LOCATION_DISABLED";
        }
    }

    static String getLocationPermissionForApp()
    {
        if (ManifestUtils.isPermissionGranted("android.permission.ACCESS_COARSE_LOCATION") || ManifestUtils.isPermissionGranted("android.permission.ACCESS_FINE_LOCATION"))
        {
            return "ALWAYS_ALLOWED";
        } else
        {
            return "NOT_ALLOWED";
        }
    }

    static boolean isBluetoothEnabled()
    {
        BluetoothAdapter bluetoothadapter;
        if (ManifestUtils.isPermissionGranted("android.permission.BLUETOOTH"))
        {
            if ((bluetoothadapter = BluetoothAdapter.getDefaultAdapter()) != null && bluetoothadapter.isEnabled())
            {
                return true;
            }
        }
        return false;
    }

    EventResponse sendEvents(Collection collection)
    {
        if (collection.size() == 0)
        {
            Logger.verbose("EventAPIClient - No events to send.");
        } else
        {
            if (!Network.isConnected())
            {
                Logger.verbose("EventAPIClient - No network connectivity available. Unable to send events.");
                return null;
            }
            Object obj = new JSONArray();
            for (Iterator iterator = collection.iterator(); iterator.hasNext();)
            {
                String s = (String)iterator.next();
                try
                {
                    ((JSONArray) (obj)).put(new JSONObject(s));
                }
                catch (JSONException jsonexception)
                {
                    Logger.error("EventAPIClient - Invalid eventPayload.", jsonexception);
                }
            }

            String s1 = ((JSONArray) (obj)).toString();
            Object obj1 = (new StringBuilder()).append(UAirship.shared().getAirshipConfigOptions().analyticsServer).append("warp9/").toString();
            double d;
            AirshipConfigOptions airshipconfigoptions;
            boolean flag;
            try
            {
                obj = new URL(((String) (obj1)));
            }
            catch (MalformedURLException malformedurlexception)
            {
                Logger.error((new StringBuilder("EventAPIClient - Invalid analyticsServer: ")).append(((String) (obj1))).toString(), malformedurlexception);
                malformedurlexception = null;
            }
            if (UAirship.shared().getPlatformType() == 1)
            {
                obj1 = "amazon";
            } else
            {
                obj1 = "android";
            }
            d = (double)System.currentTimeMillis() / 1000D;
            airshipconfigoptions = UAirship.shared().getAirshipConfigOptions();
            obj = requestFactory.createRequest("POST", ((URL) (obj))).setRequestBody(s1, "application/json").setCompressRequestBody(true).setHeader("X-UA-Device-Family", ((String) (obj1))).setHeader("X-UA-Sent-At", String.format(Locale.US, "%.3f", new Object[] {
                Double.valueOf(d)
            })).setHeader("X-UA-Package-Name", UAirship.getPackageName()).setHeader("X-UA-Package-Version", UAirship.getPackageInfo().versionName).setHeader("X-UA-App-Key", airshipconfigoptions.getAppKey()).setHeader("X-UA-In-Production", Boolean.toString(airshipconfigoptions.inProduction)).setHeader("X-UA-Device-Model", Build.MODEL).setHeader("X-UA-OS-Version", android.os.Build.VERSION.RELEASE).setHeader("X-UA-Lib-Version", UAirship.getVersion()).setHeader("X-UA-Timezone", TimeZone.getDefault().getID()).setHeader("X-UA-Channel-Opted-In", Boolean.toString(UAirship.shared().getPushManager().isOptIn()));
            if (UAirship.shared().getPushManager().isPushEnabled() && UAirship.shared().getPushManager().isPushAvailable())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            obj = ((Request) (obj)).setHeader("X-UA-Channel-Background-Enabled", Boolean.toString(flag)).setHeader("X-UA-Location-Permission", getLocationPermission()).setHeader("X-UA-Location-Service-Enabled", Boolean.toString(UAirship.shared().getLocationManager().isLocationUpdatesEnabled())).setHeader("X-UA-Bluetooth-Status", Boolean.toString(isBluetoothEnabled())).setHeader("X-UA-User-ID", UAirship.shared().getRichPushManager().getRichPushUser().getId());
            obj1 = Locale.getDefault();
            if (!UAStringUtil.isEmpty(((Locale) (obj1)).getLanguage()))
            {
                ((Request) (obj)).setHeader("X-UA-Locale-Language", ((Locale) (obj1)).getLanguage());
                if (!UAStringUtil.isEmpty(((Locale) (obj1)).getCountry()))
                {
                    ((Request) (obj)).setHeader("X-UA-Locale-Country", ((Locale) (obj1)).getCountry());
                }
                if (!UAStringUtil.isEmpty(((Locale) (obj1)).getVariant()))
                {
                    ((Request) (obj)).setHeader("X-UA-Locale-Variant", ((Locale) (obj1)).getVariant());
                }
            }
            obj1 = UAirship.shared().getPushManager().getChannelId();
            if (!UAStringUtil.isEmpty(((String) (obj1))))
            {
                ((Request) (obj)).setHeader("X-UA-Channel-ID", ((String) (obj1)));
                ((Request) (obj)).setHeader("X-UA-Push-Address", ((String) (obj1)));
            }
            Logger.debug((new StringBuilder("EventAPIClient - Sending analytic events. Request:  ")).append(obj).append(" Events: ").append(collection).toString());
            collection = ((Request) (obj)).execute();
            Logger.debug((new StringBuilder("EventAPIClient - Analytic event send response: ")).append(collection).toString());
            if (collection != null)
            {
                return new EventResponse(collection);
            }
        }
        return null;
    }
}
