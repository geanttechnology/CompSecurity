// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.signals.b;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.inmobi.commons.a.a;
import com.inmobi.signals.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.inmobi.signals.b:
//            a, c

public class b
{

    private static long a(byte byte0)
    {
        return (long)byte0 & 255L;
    }

    private static long a(String s)
    {
        s = s.split("\\:");
        byte abyte0[] = new byte[6];
        for (int i = 0; i < 6; i++)
        {
            abyte0[i] = (byte)Integer.parseInt(s[i], 16);
        }

        return a(abyte0);
    }

    private static long a(byte abyte0[])
    {
        long l1 = 0L;
        long l = l1;
        if (abyte0 != null)
        {
            l = l1;
            if (abyte0.length == 6)
            {
                l = a(abyte0[5]) | a(abyte0[4]) << 8 | a(abyte0[3]) << 16 | a(abyte0[2]) << 24 | a(abyte0[1]) << 32 | a(abyte0[0]) << 40;
            }
        }
        return l;
    }

    public static com.inmobi.signals.b.a a()
    {
        if (!e() || !o.a().e().l())
        {
            return null;
        } else
        {
            int i = o.a().e().j();
            return a(a(i), b(i));
        }
    }

    private static com.inmobi.signals.b.a a(ScanResult scanresult, boolean flag)
    {
        Object obj = null;
        Object obj1 = null;
        if (scanresult != null)
        {
            com.inmobi.signals.b.a a1 = new com.inmobi.signals.b.a();
            a1.a(a(scanresult.BSSID));
            if (flag)
            {
                obj = obj1;
            } else
            {
                obj = scanresult.SSID;
            }
            a1.a(((String) (obj)));
            a1.a(scanresult.level);
            obj = a1;
        }
        return ((com.inmobi.signals.b.a) (obj));
    }

    private static com.inmobi.signals.b.a a(boolean flag, boolean flag1)
    {
        Object obj1 = null;
        WifiInfo wifiinfo = ((WifiManager)com.inmobi.commons.a.a.b().getSystemService("wifi")).getConnectionInfo();
        Object obj = obj1;
        if (wifiinfo != null)
        {
            String s1 = wifiinfo.getBSSID();
            String s = wifiinfo.getSSID();
            obj = obj1;
            if (s1 != null)
            {
                obj = obj1;
                if (!a(flag, s))
                {
                    com.inmobi.signals.b.a a1 = new com.inmobi.signals.b.a();
                    a1.a(a(s1));
                    obj = s;
                    if (s != null)
                    {
                        obj = s;
                        if (s.startsWith("\""))
                        {
                            obj = s;
                            if (s.endsWith("\""))
                            {
                                obj = s.substring(1, s.length() - 1);
                            }
                        }
                    }
                    if (flag1)
                    {
                        obj = null;
                    }
                    a1.a(((String) (obj)));
                    a1.a(wifiinfo.getRssi());
                    a1.b(wifiinfo.getIpAddress());
                    obj = a1;
                }
            }
        }
        return ((com.inmobi.signals.b.a) (obj));
    }

    public static List a(List list)
    {
        int i = o.a().e().j();
        boolean flag = a(i);
        boolean flag1 = b(i);
        ArrayList arraylist = new ArrayList();
        if (list != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                ScanResult scanresult = (ScanResult)list.next();
                if (!a(flag, scanresult.SSID))
                {
                    arraylist.add(a(scanresult, flag1));
                }
            } while (true);
        }
        return arraylist;
    }

    private static boolean a(int i)
    {
        return !a(i, 2);
    }

    private static boolean a(int i, int j)
    {
        return (i & j) == j;
    }

    private static boolean a(boolean flag, String s)
    {
        return flag && s != null && s.endsWith("_nomap");
    }

    public static Map b()
    {
        com.inmobi.signals.b.a a1 = a();
        HashMap hashmap = new HashMap();
        if (a1 != null)
        {
            hashmap.put("c-ap-bssid", String.valueOf(a1.a()));
        }
        return hashmap;
    }

    private static boolean b(int i)
    {
        return a(i, 1);
    }

    public static boolean c()
    {
        Context context = com.inmobi.commons.a.a.b();
        String as[] = new String[3];
        as[0] = "android.permission.ACCESS_WIFI_STATE";
        as[1] = "android.permission.CHANGE_WIFI_STATE";
        as[2] = "android.permission.ACCESS_COARSE_LOCATION";
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            if (context.checkCallingOrSelfPermission(as[i]) != 0)
            {
                return false;
            }
        }

        return true;
    }

    public static Map d()
    {
        ArrayList arraylist = (ArrayList)com.inmobi.signals.b.c.a();
        HashMap hashmap = new HashMap();
        if (arraylist != null && arraylist.size() > 0)
        {
            hashmap.put("v-ap-bssid", String.valueOf(((com.inmobi.signals.b.a)arraylist.get(arraylist.size() - 1)).a()));
        }
        return hashmap;
    }

    private static boolean e()
    {
        return com.inmobi.commons.a.a.b().checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0;
    }
}
