// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import java.util.List;

public class NetworkHelper
{

    public NetworkHelper()
    {
    }

    public static void clearCookies(Context context)
    {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static String generateUA(Context context)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("Android");
        stringbuilder.append("__");
        stringbuilder.append("weibo");
        stringbuilder.append("__");
        stringbuilder.append("sdk");
        stringbuilder.append("__");
        try
        {
            stringbuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 16).versionName.replaceAll("\\s+", "_"));
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            stringbuilder.append("unknown");
        }
        return stringbuilder.toString();
    }

    public static NetworkInfo getActiveNetworkInfo(Context context)
    {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i)
    {
        return ((ConnectivityManager)context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context)
    {
label0:
        {
            if (context != null)
            {
                context = getActiveNetworkInfo(context);
                if (context != null)
                {
                    break label0;
                }
            }
            return -1;
        }
        return context.getType();
    }

    public static android.net.NetworkInfo.DetailedState getWifiConnectivityState(Context context)
    {
        context = getNetworkInfo(context, 1);
        if (context == null)
        {
            return android.net.NetworkInfo.DetailedState.FAILED;
        } else
        {
            return context.getDetailedState();
        }
    }

    public static int getWifiState(Context context)
    {
        context = (WifiManager)context.getSystemService("wifi");
        if (context == null)
        {
            return 4;
        } else
        {
            return context.getWifiState();
        }
    }

    public static boolean hasInternetPermission(Context context)
    {
        return context == null || context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0;
    }

    public static boolean isMobileNetwork(Context context)
    {
        if (context != null)
        {
            context = getActiveNetworkInfo(context);
            break MISSING_BLOCK_LABEL_9;
        }
        do
        {
            return false;
        } while (context == null || context == null || context.getType() != 0 || !context.isConnected());
        return true;
    }

    public static boolean isNetworkAvailable(Context context)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (context != null)
        {
            context = getActiveNetworkInfo(context);
            flag = flag1;
            if (context != null)
            {
                flag = flag1;
                if (context.isConnected())
                {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public static boolean isWifiValid(Context context)
    {
        if (context != null)
        {
            context = getActiveNetworkInfo(context);
            return context != null && 1 == context.getType() && context.isConnected();
        } else
        {
            return false;
        }
    }

    public static boolean wifiConnection(Context context, String s, String s1)
    {
        String s2;
        Object obj;
        context = (WifiManager)context.getSystemService("wifi");
        s2 = (new StringBuilder("\"")).append(s).append("\"").toString();
        obj = context.getConnectionInfo();
        if (obj != null && (s.equals(((WifiInfo) (obj)).getSSID()) || s2.equals(((WifiInfo) (obj)).getSSID())))
        {
            return true;
        }
        obj = context.getScanResults();
        if (obj == null || ((List) (obj)).size() == 0) goto _L2; else goto _L1
_L1:
        int i = ((List) (obj)).size() - 1;
_L5:
        if (i >= 0) goto _L3; else goto _L2
_L2:
        return false;
_L3:
        String s3 = ((ScanResult)((List) (obj)).get(i)).SSID;
        if (s.equals(s3) || s2.equals(s3))
        {
            s = new WifiConfiguration();
            s.SSID = s2;
            s.preSharedKey = (new StringBuilder("\"")).append(s1).append("\"").toString();
            s.status = 2;
            return context.enableNetwork(context.addNetwork(s), false);
        }
        i--;
        if (true) goto _L5; else goto _L4
_L4:
    }
}
