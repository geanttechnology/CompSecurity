// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.core.system;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.amazon.insights.core.log.Logger;

// Referenced classes of package com.amazon.insights.core.system:
//            Connectivity

public class AndroidConnectivity
    implements Connectivity
{

    private static final Logger logger = Logger.getLogger(com/amazon/insights/core/system/Connectivity);
    private Context context;
    protected boolean hasMobile;
    protected boolean hasWifi;
    protected boolean hasWired;
    protected boolean inAirplaneMode;

    public AndroidConnectivity(Context context1)
    {
        context = context1;
    }

    private void determineAvailability()
    {
        ConnectivityManager connectivitymanager = (ConnectivityManager)context.getSystemService("connectivity");
        Object obj;
        boolean flag;
        if (android.provider.Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        inAirplaneMode = flag;
        logger.v((new StringBuilder()).append("Airplane mode: ").append(inAirplaneMode).toString());
        if (connectivitymanager != null)
        {
            obj = connectivitymanager.getActiveNetworkInfo();
        } else
        {
            obj = null;
        }
        hasWifi = false;
        hasWired = false;
        if (connectivitymanager != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasMobile = flag;
        if (obj != null)
        {
            if (((NetworkInfo) (obj)).isConnectedOrConnecting())
            {
                int i = ((NetworkInfo) (obj)).getType();
                if (android.os.Build.VERSION.SDK_INT >= 13)
                {
                    Logger logger1;
                    if (i == 9)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    hasWired = flag;
                }
                if (i == 1 || i == 6)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hasWifi = flag;
                if (i == 0 || i == 4 || i == 5 || i == 2 || i == 3)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hasMobile = flag;
            } else
            {
                hasMobile = false;
            }
        }
        logger1 = logger;
        if (hasWifi)
        {
            obj = "On Wifi";
        } else
        if (hasMobile)
        {
            obj = "On Mobile";
        } else
        {
            obj = "No network connectivity";
        }
        logger1.v(String.format("Device Connectivity (%s)", new Object[] {
            obj
        }));
    }

    public boolean hasWAN()
    {
        return hasMobile && !inAirplaneMode;
    }

    public boolean hasWifi()
    {
        return hasWifi;
    }

    public boolean hasWired()
    {
        return hasWired;
    }

    public boolean isConnected()
    {
        determineAvailability();
        return hasWifi() || hasWAN() || hasWired();
    }

}
