// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.android.util.system;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;

public class InternetConnection
{

    private ConnectivityManager connectivityManager;
    private TelephonyManager telephonyManager;

    public InternetConnection(ConnectivityManager connectivitymanager, TelephonyManager telephonymanager)
    {
        connectivityManager = connectivitymanager;
        telephonyManager = telephonymanager;
    }

    private boolean mobileNetworkIsHighspeed()
    {
        int i = telephonyManager.getNetworkType();
        return i == 13 || i == 15;
    }

    public boolean isConnected()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting();
    }

    public boolean isConnectedNotOnWiFi()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting() && networkinfo.getType() != 1;
    }

    public boolean isConnectedOnHighspeedMobile()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.getType() == 0)
        {
            return mobileNetworkIsHighspeed();
        } else
        {
            return false;
        }
    }

    public boolean isConnectedOnWiFi()
    {
        NetworkInfo networkinfo = connectivityManager.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnectedOrConnecting() && networkinfo.getType() == 1;
    }
}
