// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.device;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.PowerManager;
import android.telephony.TelephonyManager;
import com.amazon.gallery.foundation.utils.apilevel.Api;
import com.amazon.gallery.foundation.utils.log.GLogger;

public class DeviceUtil
{

    private static final String TAG = com/amazon/gallery/foundation/utils/device/DeviceUtil.getName();

    public DeviceUtil()
    {
    }

    public static int getCurrentBatteryPercentage(Context context)
    {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (context == null)
        {
            GLogger.w(TAG, "Unable to determine battery percentage. Null intent returned.", new Object[0]);
            return -1;
        } else
        {
            int i = context.getIntExtra("level", -1);
            int j = context.getIntExtra("scale", -1);
            return (int)(((float)i / (float)j) * 100F);
        }
    }

    public static int getCurrentPluggedState(Context context)
    {
        context = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (context == null)
        {
            GLogger.w(TAG, "Unable to determine plugged state. Null intent returned.", new Object[0]);
            return 0;
        } else
        {
            return context.getIntExtra("plugged", 0);
        }
    }

    public static boolean isInPowerSaverMode(Context context)
    {
        if (Api.isAtLeastLollipop())
        {
            return ((PowerManager)context.getSystemService("power")).isPowerSaveMode();
        } else
        {
            return false;
        }
    }

    public static boolean isLowBatteryState(Context context)
    {
        int i = getCurrentBatteryPercentage(context);
        return i <= 15 && i >= 0;
    }

    public static boolean isPowerConnected(Context context)
    {
        return getCurrentPluggedState(context) != 0;
    }

    public static boolean isTablet(Context context)
    {
        boolean flag2 = false;
        TelephonyManager telephonymanager = (TelephonyManager)context.getSystemService("phone");
        context = context.getResources().getConfiguration();
        boolean flag;
        boolean flag1;
        if ((((Configuration) (context)).screenLayout & 0xf) >= 3 && ((Configuration) (context)).smallestScreenWidthDp >= 600)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (telephonymanager.getPhoneType() == 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 || flag)
        {
            flag2 = true;
        }
        return flag2;
    }

}
