// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ProxySelector;
import java.net.SocketException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j, k

public class n
    implements i
{

    public n()
    {
    }

    private String a()
    {
        Object obj;
        Object obj1;
        Object obj2;
        Iterator iterator;
        Object obj7;
        try
        {
            obj2 = Collections.list(NetworkInterface.getNetworkInterfaces());
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((SocketException) (obj)).printStackTrace();
            return null;
        }
        obj = "{";
        obj1 = "";
        iterator = ((List) (obj2)).iterator();
_L11:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj7 = (NetworkInterface)iterator.next();
        obj2 = Collections.list(((NetworkInterface) (obj7)).getInetAddresses());
        if (((List) (obj2)).size() <= 0 || !a(((List) (obj2)))) goto _L4; else goto _L3
_L3:
        obj = (new StringBuilder()).append(((String) (obj))).append(((String) (obj1))).append("\"").append(((NetworkInterface) (obj7)).getName()).append("\":{\n\"ips\": [").toString();
        obj1 = "";
        obj7 = ((List) (obj2)).iterator();
_L10:
        if (!((Iterator) (obj7)).hasNext()) goto _L6; else goto _L5
_L5:
        obj2 = (InetAddress)((Iterator) (obj7)).next();
        if (((InetAddress) (obj2)).isLoopbackAddress()) goto _L8; else goto _L7
_L7:
        obj1 = (new StringBuilder()).append(((String) (obj))).append(((String) (obj1))).append("\"").append(((InetAddress) (obj2)).getHostAddress()).append("\"").toString();
        obj = ",";
          goto _L9
_L6:
        obj1 = (new StringBuilder()).append(((String) (obj))).append("]}").toString();
        obj = ", ";
        break MISSING_BLOCK_LABEL_269;
_L2:
        obj = (new StringBuilder()).append(((String) (obj))).append("}").toString();
        return ((String) (obj));
_L8:
        Object obj3 = obj;
        obj = obj1;
        obj1 = obj3;
          goto _L9
_L4:
        Object obj4 = obj;
        obj = obj1;
        obj1 = obj4;
        break MISSING_BLOCK_LABEL_269;
_L9:
        Object obj5 = obj1;
        obj1 = obj;
        obj = obj5;
          goto _L10
        Object obj6 = obj1;
        obj1 = obj;
        obj = obj6;
          goto _L11
    }

    private static String a(Context context)
    {
        context = (WifiManager)context.getSystemService("wifi");
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        if (!context.isWifiEnabled())
        {
            break MISSING_BLOCK_LABEL_38;
        }
        context = context.getConnectionInfo();
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        context = context.getMacAddress();
        return context;
        context;
        return null;
    }

    private String a(String s)
    {
        try
        {
            s = new URI(s);
            s = ProxySelector.getDefault().select(s).toString();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private boolean a(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            if (!((InetAddress)list.next()).isLoopbackAddress())
            {
                return true;
            }
        }

        return false;
    }

    private static String b()
    {
        Object obj = BluetoothAdapter.getDefaultAdapter();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_16;
        }
        obj = ((BluetoothAdapter) (obj)).getAddress();
        return ((String) (obj));
        Throwable throwable;
        throwable;
        return null;
    }

    private String b(Context context)
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            return android.provider.Settings.Global.getString(context.getContentResolver(), "http_proxy");
        }
        if (android.os.Build.VERSION.SDK_INT < 17)
        {
            return android.provider.Settings.Secure.getString(context.getContentResolver(), "http_proxy");
        } else
        {
            return "";
        }
    }

    private String c(Context context)
    {
        context = (new StringBuilder()).append("").append("ftp ").append(a("ftp://www.example.com/")).append(";").toString();
        context = (new StringBuilder()).append(context).append("http ").append(a("http://www.example.com/")).append(";").toString();
        return (new StringBuilder()).append(context).append("https ").append(a("https://www.example.com/")).toString();
    }

    public void a(Context context, j j1)
    {
        j1.a("MACA", a(context));
        j1.a("BMACA", b());
        if (k.a("android.permission.INTERNET", context))
        {
            j1.a("NETS", a());
        }
        if (k.a("android.permission.ACCESS_WIFI_STATE", context))
        {
            WifiManager wifimanager = (WifiManager)context.getSystemService("wifi");
            if (wifimanager != null && wifimanager.isWifiEnabled())
            {
                Object obj = wifimanager.getConnectionInfo();
                if (obj != null)
                {
                    String s = ((WifiInfo) (obj)).getSSID();
                    obj = ((WifiInfo) (obj)).getBSSID();
                    if (s != null && obj != null && s != "" && s.length() != 0 && s != "<unknown ssid>" && s != "0x")
                    {
                        try
                        {
                            j1.a("SSID", k.a(s.getBytes()));
                        }
                        catch (NullPointerException nullpointerexception) { }
                    }
                    j1.a("BSSID", ((String) (obj)));
                }
            }
        }
        j1.a("APROX", b(context));
        j1.a("APROXL", c(context));
    }
}
