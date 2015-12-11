// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Build;

class AndroidBuildInfo
{

    private String make;
    private String model;
    private String osVersion;
    private int sdkInt;

    AndroidBuildInfo()
    {
        make = Build.MANUFACTURER;
        model = Build.MODEL;
        osVersion = android.os.Build.VERSION.RELEASE;
        sdkInt = android.os.Build.VERSION.SDK_INT;
    }

    public String getMake()
    {
        return make;
    }

    public String getModel()
    {
        return model;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public int getSDKInt()
    {
        return sdkInt;
    }
}
