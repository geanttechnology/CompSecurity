// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.text.MessageFormat;

public final class Connectivity
{

    private static final String ANDROID = "Android";
    private static AgentLog log = AgentLogManager.getAgentLog();

    public Connectivity()
    {
    }

    public static String carrierNameFromContext(Context context)
    {
        NetworkInfo networkinfo;
        try
        {
            networkinfo = getNetworkInfo(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "unknown";
        }
        if (!isConnected(networkinfo))
        {
            return "none";
        }
        if (isWan(networkinfo))
        {
            return carrierNameFromTelephonyManager(context);
        }
        if (isWifi(networkinfo))
        {
            return "wifi";
        } else
        {
            log.warning(MessageFormat.format("Unknown network type: {0} [{1}]", new Object[] {
                networkinfo.getTypeName(), Integer.valueOf(networkinfo.getType())
            }));
            return "unknown";
        }
    }

    private static String carrierNameFromTelephonyManager(Context context)
    {
        String s = ((TelephonyManager)context.getSystemService("phone")).getNetworkOperatorName();
        boolean flag;
        if (Build.PRODUCT.equals("google_sdk") || Build.PRODUCT.equals("sdk") || Build.PRODUCT.equals("sdk_x86") || Build.FINGERPRINT.startsWith("generic"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        context = s;
        if (s.equals("Android"))
        {
            context = s;
            if (flag)
            {
                context = "wifi";
            }
        }
        return context;
    }

    private static String connectionNameFromNetworkSubtype(int i)
    {
        switch (i)
        {
        default:
            return "unknown";

        case 7: // '\007'
            return "1xRTT";

        case 4: // '\004'
            return "CDMA";

        case 2: // '\002'
            return "EDGE";

        case 5: // '\005'
            return "EVDO rev 0";

        case 6: // '\006'
            return "EVDO rev A";

        case 1: // '\001'
            return "GPRS";

        case 8: // '\b'
            return "HSDPA";

        case 10: // '\n'
            return "HSPA";

        case 9: // '\t'
            return "HSUPA";

        case 3: // '\003'
            return "UMTS";

        case 11: // '\013'
            return "IDEN";

        case 12: // '\f'
            return "EVDO rev B";

        case 15: // '\017'
            return "HSPAP";

        case 14: // '\016'
            return "HRPD";

        case 13: // '\r'
            return "LTE";
        }
    }

    private static NetworkInfo getNetworkInfo(Context context)
        throws SecurityException
    {
        context = (ConnectivityManager)context.getSystemService("connectivity");
        try
        {
            context = context.getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.warning("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
            throw context;
        }
        return context;
    }

    private static boolean isConnected(NetworkInfo networkinfo)
    {
        return networkinfo != null && networkinfo.isConnected();
    }

    private static boolean isWan(NetworkInfo networkinfo)
    {
        switch (networkinfo.getType())
        {
        case 1: // '\001'
        default:
            return false;

        case 0: // '\0'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return true;
        }
    }

    private static boolean isWifi(NetworkInfo networkinfo)
    {
        switch (networkinfo.getType())
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        default:
            return false;

        case 1: // '\001'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
            return true;
        }
    }

    public static String wanType(Context context)
    {
        try
        {
            context = getNetworkInfo(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return "unknown";
        }
        if (!isConnected(context))
        {
            return "none";
        }
        if (isWifi(context))
        {
            return "wifi";
        }
        if (isWan(context))
        {
            return connectionNameFromNetworkSubtype(context.getSubtype());
        } else
        {
            return "unknown";
        }
    }

}
