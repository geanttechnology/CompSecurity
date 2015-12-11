// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.utility;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;

// Referenced classes of package com.penthera.virtuososdk.utility:
//            CommonUtil

public static final class 
{

    public static void dump(NetworkInfo networkinfo)
    {
        if (networkinfo == null)
        {
            ("NetworkHelpers", "NetworkInfo is null: There is no connection");
            return;
        } else
        {
            ("NetworkHelpers", (new StringBuilder("isAvailable: ")).append(networkinfo.isAvailable()).toString());
            ("NetworkHelpers", (new StringBuilder("isConnected: ")).append(networkinfo.isConnected()).toString());
            ("NetworkHelpers", (new StringBuilder("isConnectedOrConnecting: ")).append(networkinfo.isConnectedOrConnecting()).toString());
            ("NetworkHelpers", (new StringBuilder("isRoaming: ")).append(networkinfo.isRoaming()).toString());
            ("NetworkHelpers", (new StringBuilder("getState: ")).append(networkinfo.getState()).toString());
            ("NetworkHelpers", (new StringBuilder("getDetailedState: ")).append(networkinfo.getDetailedState()).toString());
            ("NetworkHelpers", (new StringBuilder("getReason: ")).append(networkinfo.getReason()).toString());
            ("NetworkHelpers", (new StringBuilder("getTypeName: ")).append(networkinfo.getTypeName()).toString());
            ("NetworkHelpers", (new StringBuilder("getSubTypeName: ")).append(networkinfo.getSubtypeName()).toString());
            ("NetworkHelpers", (new StringBuilder("isFailOver: ")).append(networkinfo.isFailover()).toString());
            return;
        }
    }

    public static void dump(WifiManager wifimanager)
    {
        if (wifimanager == null)
        {
            try
            {
                ("NetworkHelpers", "WifiManager is null: There is no WIFI");
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WifiManager wifimanager)
            {
                ("NetworkHelpers", (new StringBuilder("Caught exception taking a dump: ")).append(wifimanager).toString());
            }
            break MISSING_BLOCK_LABEL_110;
        }
        ("NetworkHelpers", (new StringBuilder("isWifiEnabled: ")).append(wifimanager.isWifiEnabled()).toString());
        ("NetworkHelpers", (new StringBuilder("getWifiState: ")).append(wifiStateToString(wifimanager.getWifiState())).toString());
        wifiStateToString("NetworkHelpers", (new StringBuilder("getConnectionInfo: ")).append(wifimanager.getConnectionInfo()).toString());
        return;
    }

    public static boolean isCell(Context context)
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        if (context != null)
        {
            if ((context = context.getActiveNetworkInfo()) != null && context.getType() == 0)
            {
                return true;
            }
        }
        return false;
    }

    public static String wifiStateToString(int i)
    {
        switch (i)
        {
        default:
            return "WHOPPER_JAWED";

        case 1: // '\001'
            return "WIFI_STATE_DISABLED";

        case 0: // '\0'
            return "WIFI_STATE_DISABLING";

        case 3: // '\003'
            return "WIFI_STATE_ENABLED";

        case 2: // '\002'
            return "WIFI_STATE_ENABLING";

        case 4: // '\004'
            return "WIFI_STATE_UNKNOWN";
        }
    }
}
