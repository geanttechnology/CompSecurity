// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;

import android.app.Application;
import android.net.DhcpInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.smule.android.h;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

// Referenced classes of package com.smule.android.console:
//            a, p

public class q
{

    public static void a(p p1)
    {
        Object obj = (WifiManager)com.smule.android.console.a.a().getSystemService("wifi");
        if (obj == null || !((WifiManager) (obj)).isWifiEnabled() || ((WifiManager) (obj)).getWifiState() != 3) goto _L2; else goto _L1
_L1:
        WifiInfo wifiinfo = ((WifiManager) (obj)).getConnectionInfo();
        obj = ((WifiManager) (obj)).getDhcpInfo();
        p1.b(com.smule.android.console.a.a(h.netinfo_wifiinfo));
        p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_ssid)).append(": ").toString());
        p1.b(wifiinfo.getSSID());
        p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_ipaddr)).append(": ").toString());
        p1.b(com.smule.android.console.a.b(((DhcpInfo) (obj)).ipAddress));
        p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_netmask)).append(": ").toString());
        p1.b(com.smule.android.console.a.b(((DhcpInfo) (obj)).netmask));
        p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_gateway)).append(": ").toString());
        p1.b(com.smule.android.console.a.b(((DhcpInfo) (obj)).gateway));
        p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_dns1)).append(": ").toString());
        p1.b(com.smule.android.console.a.b(((DhcpInfo) (obj)).dns1));
        p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_dns2)).append(": ").toString());
        p1.b(com.smule.android.console.a.b(((DhcpInfo) (obj)).dns2));
_L4:
        return;
_L2:
        try
        {
            Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
            while (enumeration.hasMoreElements()) 
            {
                Object obj1 = (NetworkInterface)enumeration.nextElement();
                p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_netintf_name)).append(": ").toString());
                p1.b(((NetworkInterface) (obj1)).getDisplayName());
                obj1 = ((NetworkInterface) (obj1)).getInetAddresses();
                while (((Enumeration) (obj1)).hasMoreElements()) 
                {
                    InetAddress inetaddress = (InetAddress)((Enumeration) (obj1)).nextElement();
                    p1.a((new StringBuilder()).append(com.smule.android.console.a.a(h.netinfo_ipaddr)).append(": ").toString());
                    p1.b(com.smule.android.console.a.a(inetaddress.getAddress()));
                }
            }
        }
        catch (Exception exception)
        {
            p1.b((new StringBuilder()).append(exception.getClass().getName()).append(": ").append(exception.getMessage()).toString());
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
