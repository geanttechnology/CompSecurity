// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import com.google.common.base.Strings;

public final class DeviceUtils
{

    private static final String TAG = com/amazon/blueshift/bluefront/android/common/DeviceUtils.getCanonicalName();

    private DeviceUtils()
    {
    }

    public static String convertNetworkTypeNumberToName(int i)
    {
        switch (i)
        {
        default:
            return "unknown";

        case 7: // '\007'
            return "Bluetooth";

        case 8: // '\b'
            return "Dummy";

        case 9: // '\t'
            return "Ethernet";

        case 0: // '\0'
            return "Mobile";

        case 4: // '\004'
            return "Mobile - DUN";

        case 5: // '\005'
            return "Mobile - High Priority";

        case 2: // '\002'
            return "Mobile - MMS";

        case 3: // '\003'
            return "Mobile - SUPL";

        case 1: // '\001'
            return "WiFi";

        case 6: // '\006'
            return "WiMAX";
        }
    }

    public static String getAppVersion(Context context)
    {
        try
        {
            context = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.v(TAG, "Unable to determine app version.");
            return "unknown";
        }
        return context;
    }

    public static String getCarrierName(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null && !Strings.isNullOrEmpty(context.getNetworkOperatorName()))
        {
            return context.getNetworkOperatorName();
        } else
        {
            Log.v(TAG, "Unable to get carrier name.");
            return "unknown";
        }
    }

    public static Location getLocation(Context context)
    {
        if (context.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == -1)
        {
            Log.v(TAG, "GPS Permission not present");
        } else
        {
            context = (LocationManager)context.getSystemService("location");
            if (context != null)
            {
                if (context.isProviderEnabled("gps"))
                {
                    Log.v(TAG, "GPS Enabled");
                    return context.getLastKnownLocation("gps");
                }
                if (context.isProviderEnabled("network"))
                {
                    Log.v(TAG, "Network Enabled");
                    if (context != null)
                    {
                        return context.getLastKnownLocation("network");
                    }
                } else
                {
                    Log.w(TAG, "Both GPS and network are not enabled, cannot retrive location.");
                    return null;
                }
            } else
            {
                Log.w(TAG, "Failed to get location manager.");
                return null;
            }
        }
        return null;
    }

}
