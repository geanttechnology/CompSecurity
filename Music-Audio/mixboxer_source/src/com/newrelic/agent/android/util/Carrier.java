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

public final class Carrier
{

    private static final String ANDROID = "Android";
    private static AgentLog log = AgentLogManager.getAgentLog();

    public Carrier()
    {
    }

    public static String nameFromContext(Context context)
    {
        Object obj = (ConnectivityManager)context.getSystemService("connectivity");
        try
        {
            obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.warning("Cannot determine network state. Enable android.permission.ACCESS_NETWORK_STATE in your manifest.");
            return "Other";
        }
        if (obj == null || !((NetworkInfo) (obj)).isConnected())
        {
            return "none";
        }
        switch (((NetworkInfo) (obj)).getType())
        {
        case 8: // '\b'
        default:
            log.warning(MessageFormat.format("Unknown network type: {0} [{1}]", new Object[] {
                ((NetworkInfo) (obj)).getTypeName(), Integer.valueOf(((NetworkInfo) (obj)).getType())
            }));
            return "Other";

        case 0: // '\0'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
            return nameFromTelephonyManager(context);

        case 1: // '\001'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
            return "wifi";
        }
    }

    private static String nameFromTelephonyManager(Context context)
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

}
