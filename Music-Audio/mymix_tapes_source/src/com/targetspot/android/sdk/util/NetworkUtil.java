// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetworkUtil
{

    public static final int NETSTAT_MOBILE = 1;
    public static final int NETSTAT_NONE = 0;
    public static final int NETSTAT_WIFI = 2;

    public NetworkUtil()
    {
    }

    public static int networkStatus(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        int j = 0;
        NetworkInfo networkinfo = context.getNetworkInfo(1);
        Log.d("NetworkUtil", (new StringBuilder()).append("Wifi: ").append(networkinfo).toString());
        int i = j;
        if (networkinfo != null)
        {
            i = j;
            if (networkinfo.isConnected())
            {
                i = 0 | 2;
            }
        }
        context = context.getNetworkInfo(0);
        Log.d("NetworkUtil", (new StringBuilder()).append("Mobile: ").append(context).toString());
        j = i;
        if (context != null)
        {
            j = i;
            if (context.isAvailable())
            {
                j = i | 1;
            }
        }
        return j;
    }
}
