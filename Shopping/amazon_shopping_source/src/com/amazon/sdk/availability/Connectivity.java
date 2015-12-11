// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;

// Referenced classes of package com.amazon.sdk.availability:
//            Logger

class Connectivity
{
    public static final class Network extends Enum
    {

        private static final Network $VALUES[];
        public static final Network ETHERNET;
        public static final Network MOBILE;
        public static final Network WIFI;

        public static Network valueOf(String s)
        {
            return (Network)Enum.valueOf(com/amazon/sdk/availability/Connectivity$Network, s);
        }

        public static Network[] values()
        {
            return (Network[])$VALUES.clone();
        }

        static 
        {
            MOBILE = new Network("MOBILE", 0);
            WIFI = new Network("WIFI", 1);
            ETHERNET = new Network("ETHERNET", 2);
            $VALUES = (new Network[] {
                MOBILE, WIFI, ETHERNET
            });
        }

        private Network(String s, int i)
        {
            super(s, i);
        }
    }


    private boolean hasEthernet;
    private boolean hasMobile;
    private boolean hasWifi;

    public Connectivity(ConnectivityManager connectivitymanager)
    {
        NetworkInfo networkinfo;
        boolean flag;
        if (connectivitymanager != null)
        {
            networkinfo = connectivitymanager.getActiveNetworkInfo();
        } else
        {
            networkinfo = null;
        }
        hasWifi = false;
        hasEthernet = false;
        if (connectivitymanager != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        hasMobile = flag;
        if (networkinfo != null)
        {
            if (networkinfo.isConnectedOrConnecting())
            {
                int i = networkinfo.getType();
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
                if (i == 9)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                hasEthernet = flag;
            } else
            {
                hasMobile = false;
            }
        }
        if (hasWifi)
        {
            connectivitymanager = "On Wifi";
        } else
        if (hasMobile)
        {
            connectivitymanager = "On mobile";
        } else
        if (hasEthernet)
        {
            connectivitymanager = "On Ethernet";
        } else
        {
            connectivitymanager = "No network connectivity.";
        }
        Logger.v(String.format("Device Connectivity (%s)", new Object[] {
            connectivitymanager
        }));
    }

    public boolean hasEthernet()
    {
        return hasEthernet;
    }

    public boolean hasMobile()
    {
        return hasMobile;
    }

    public boolean hasWifi()
    {
        return hasWifi;
    }
}
