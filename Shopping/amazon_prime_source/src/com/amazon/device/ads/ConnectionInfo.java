// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsInfoStore, MobileAdsLogger

class ConnectionInfo
{

    private static final String LOGTAG = com/amazon/device/ads/ConnectionInfo.getSimpleName();
    private static final String WIFI_NAME = "Wifi";
    private String connectionType;
    private ConnectivityManager connectivityManager;
    private final MobileAdsLogger logger;

    ConnectionInfo(ConnectivityManager connectivitymanager)
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        initialize(connectivitymanager);
    }

    public ConnectionInfo(MobileAdsInfoStore mobileadsinfostore)
    {
        logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);
        initialize((ConnectivityManager)mobileadsinfostore.getApplicationContext().getSystemService("connectivity"));
    }

    private void generateConnectionType()
    {
        Object obj1 = null;
        Object obj = obj1;
        try
        {
            if (connectivityManager != null)
            {
                obj = connectivityManager.getActiveNetworkInfo();
            }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            logger.d("Unable to get active network information: %s", new Object[] {
                obj
            });
            obj = obj1;
        }
        if (obj != null)
        {
            if (((NetworkInfo) (obj)).getType() == 1)
            {
                connectionType = "Wifi";
                return;
            } else
            {
                connectionType = Integer.toString(((NetworkInfo) (obj)).getSubtype());
                return;
            }
        } else
        {
            connectionType = Integer.toString(0);
            return;
        }
    }

    private void initialize(ConnectivityManager connectivitymanager)
    {
        connectivityManager = connectivitymanager;
        refresh();
    }

    public String getConnectionType()
    {
        return connectionType;
    }

    public boolean isWiFi()
    {
        return "Wifi".equals(getConnectionType());
    }

    public void refresh()
    {
        generateConnectionType();
    }

}
