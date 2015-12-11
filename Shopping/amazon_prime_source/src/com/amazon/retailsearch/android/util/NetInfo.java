// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetInfo
{

    private NetInfo()
    {
    }

    public static NetworkInfo getNetworkInfo(Context context)
    {
        if (context != null)
        {
            if ((context = (ConnectivityManager)context.getSystemService("connectivity")) != null)
            {
                return context.getActiveNetworkInfo();
            }
        }
        return null;
    }

    public static boolean isConnected(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected();
    }

    public static boolean isConnectedMobile(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected() && context.getType() == 0;
    }

    public static boolean isConnectedSlow(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected() && isConnectionSlow(context.getType(), context.getSubtype());
    }

    public static boolean isConnectedWifi(Context context)
    {
        context = getNetworkInfo(context);
        return context != null && context.isConnected() && context.getType() == 1;
    }

    public static boolean isConnectionSlow(int i, int j)
    {
_L2:
        return false;
        if (i == 1 || i != 0) goto _L2; else goto _L1
_L1:
        switch (j)
        {
        default:
            return false;

        case 1: // '\001'
            return true;

        case 7: // '\007'
            return true;

        case 4: // '\004'
            return true;

        case 2: // '\002'
            return true;

        case 11: // '\013'
            return true;

        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 13: // '\r'
        case 14: // '\016'
        case 15: // '\017'
            break;
        }
        if (true) goto _L2; else goto _L3
_L3:
    }
}
