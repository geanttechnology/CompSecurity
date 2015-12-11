// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import java.util.Map;
import java.util.TreeMap;

public class DeviceProperties
{

    private static DeviceProperties mInstance = null;
    private String mDeviceCarrier;
    private Map mDeviceIds;
    private String mDeviceModel;
    private String mDeviceOem;
    private String mDeviceOsType;
    private int mDeviceOsVersion;
    private final String mSupersonicSdkVersion = "5.14";

    private DeviceProperties(Context context)
    {
        init(context);
    }

    public static DeviceProperties getInstance(Context context)
    {
        if (mInstance == null)
        {
            mInstance = new DeviceProperties(context);
        }
        return mInstance;
    }

    private void init(Context context)
    {
        mDeviceOem = Build.MANUFACTURER;
        mDeviceModel = Build.MODEL;
        mDeviceOsType = "android";
        mDeviceOsVersion = android.os.Build.VERSION.SDK_INT;
        mDeviceIds = new TreeMap();
        mDeviceCarrier = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
    }

    public static void release()
    {
        mInstance = null;
    }

    public String getDeviceCarrier()
    {
        return mDeviceCarrier;
    }

    public Map getDeviceIds()
    {
        return mDeviceIds;
    }

    public String getDeviceModel()
    {
        return mDeviceModel;
    }

    public String getDeviceOem()
    {
        return mDeviceOem;
    }

    public String getDeviceOsType()
    {
        return mDeviceOsType;
    }

    public int getDeviceOsVersion()
    {
        return mDeviceOsVersion;
    }

    public String getSupersonicSdkVersion()
    {
        return "5.14";
    }

}
