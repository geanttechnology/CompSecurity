// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.boombox.util;

import android.content.Context;
import android.hardware.SensorManager;

public class DeviceCapabilities
{

    private DeviceCapabilities()
    {
    }

    private static boolean sensorAvailable(Context context, int i)
    {
        return ((SensorManager)context.getSystemService("sensor")).getDefaultSensor(i) != null;
    }

    public static boolean supportsAccelerometorSensor(Context context)
    {
        return sensorAvailable(context, 1);
    }

    public static boolean supportsGyroscopeSensor(Context context)
    {
        return sensorAvailable(context, 4);
    }

    public static boolean supportsHeadTrackingSensor()
    {
        try
        {
            Class.forName("com.amazon.headtracking.HeadTrackingListener", false, com/amazon/boombox/util/DeviceCapabilities.getClassLoader());
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        return true;
    }
}
