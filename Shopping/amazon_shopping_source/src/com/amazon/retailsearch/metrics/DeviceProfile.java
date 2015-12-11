// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import android.content.ContentResolver;
import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;

public class DeviceProfile
{

    public DeviceProfile()
    {
    }

    public static String getAndroidId(ContentResolver contentresolver)
    {
        return android.provider.Settings.Secure.getString(contentresolver, "android_id");
    }

    public static String getNetworkName(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null)
        {
            return context.getNetworkOperatorName();
        } else
        {
            return null;
        }
    }

    public static String getSerial()
    {
        String s;
        try
        {
            s = (String)android/os/Build.getDeclaredField("SERIAL").get(android/os/Build);
        }
        catch (Throwable throwable)
        {
            return null;
        }
        return s;
    }

    public static String getTelephonyDeviceId(Context context)
    {
        context = (TelephonyManager)context.getSystemService("phone");
        if (context != null)
        {
            return context.getDeviceId();
        } else
        {
            return null;
        }
    }
}
