// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class NetWorkUtil
{

    public NetWorkUtil()
    {
    }

    public static int getAPNType(Context context)
    {
        byte byte0;
        int i;
        byte0 = -1;
        context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null)
        {
            return -1;
        }
        i = context.getType();
        if (i != 0) goto _L2; else goto _L1
_L1:
        Log.e("networkInfo.getExtraInfo()", (new StringBuilder("networkInfo.getExtraInfo() is ")).append(context.getExtraInfo()).toString());
        if (context.getExtraInfo().toLowerCase().equals("cmnet"))
        {
            byte0 = 3;
        } else
        {
            byte0 = 2;
        }
_L4:
        return byte0;
_L2:
        if (i == 1)
        {
            byte0 = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static boolean isMobileConnected(Context context)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (context != null)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(0);
            flag = flag1;
            if (context != null)
            {
                flag = context.isAvailable();
            }
        }
        return flag;
    }

    public static boolean isNetworkConnected(Context context)
    {
        if (context != null)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context != null)
            {
                return context.isAvailable();
            }
        }
        return false;
    }

    public static boolean isWifiConnected(Context context)
    {
        if (context != null)
        {
            context = ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(1);
            if (context != null)
            {
                return context.isAvailable();
            }
        }
        return false;
    }
}
