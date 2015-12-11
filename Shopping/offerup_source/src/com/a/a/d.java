// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.support.v4.e.a;
import android.util.Log;
import com.a.e;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.UUID;

// Referenced classes of package com.a.a:
//            b, g, e

public final class d
{

    private com.a.d a;
    private Context b;

    public d(Activity activity, com.a.d d1)
    {
        a = d1;
        b = activity.getApplicationContext();
    }

    private String d()
    {
        HashMap hashmap = e();
        hashmap.putAll(f());
        Object obj = new TreeSet(hashmap.values());
        if (((SortedSet) (obj)).size() > 0)
        {
            StringBuilder stringbuilder = new StringBuilder("{");
            String s;
            for (obj = ((SortedSet) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((new StringBuilder()).append(s).append(",").toString()))
            {
                s = (String)((Iterator) (obj)).next();
            }

            stringbuilder.append("}");
            return stringbuilder.toString();
        } else
        {
            return null;
        }
    }

    private HashMap e()
    {
        HashMap hashmap = new HashMap();
        WifiInfo wifiinfo;
        try
        {
            wifiinfo = ((WifiManager)b.getSystemService("wifi")).getConnectionInfo();
        }
        catch (SecurityException securityexception)
        {
            Log.d("wifi_mac", "[LocalCollector]WIFI PERMISSION DENIED");
            return hashmap;
        }
        if (wifiinfo == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        if (wifiinfo.getMacAddress() == null)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        hashmap.put("wifi_mac", wifiinfo.getMacAddress().replace(":", ""));
        return hashmap;
        Log.d("wifi_mac", "[LocalCollector]WIFI not enabled, skipping");
        return hashmap;
    }

    private HashMap f()
    {
        HashMap hashmap;
        hashmap = new HashMap();
        if (android.os.Build.VERSION.SDK_INT <= 8)
        {
            break MISSING_BLOCK_LABEL_200;
        }
        Log.d("PROXY_PEIRCE", "[LocalCollector]Newer API...");
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L4:
        NetworkInterface networkinterface;
        byte abyte0[];
        do
        {
            do
            {
                if (!enumeration.hasMoreElements())
                {
                    break MISSING_BLOCK_LABEL_200;
                }
                networkinterface = (NetworkInterface)enumeration.nextElement();
            } while (!networkinterface.isUp());
            Log.d("NETWORK", (new StringBuilder("[LocalCollector]NETWORK:")).append(networkinterface.getName()).append(":").append(networkinterface.isVirtual()).toString());
            abyte0 = networkinterface.getHardwareAddress();
        } while (abyte0 == null);
        StringBuffer stringbuffer;
        int j;
        stringbuffer = new StringBuffer();
        j = abyte0.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        stringbuffer.append(String.format("%02X", new Object[] {
            Byte.valueOf(abyte0[i])
        }));
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        hashmap.put(networkinterface.getName(), stringbuffer.toString());
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        a.a(com.a.a.b.a, g.d);
        Log.d("network_mac", "[LocalCollector]Bad socket connection, skipping");
        return hashmap;
        obj;
        a.a(com.a.a.b.a, g.c);
        Log.d("network_mac", "[LocalCollector]Permission Denied, skipping");
        return hashmap;
    }

    public final void a()
    {
        a.a(e.i, "A");
        a.a(e.h, "2.5");
        a.a(e.j, Build.FINGERPRINT);
    }

    public final void b()
    {
        a.a(e.g, android.os.Build.VERSION.RELEASE);
    }

    public final void c()
    {
        String s = null;
        Object obj = b.getSharedPreferences("k_prefs", 0);
        Object obj1;
        HashMap hashmap;
        if (obj != null)
        {
            obj1 = ((SharedPreferences) (obj)).getString("lic", null);
        } else
        {
            obj1 = null;
        }
        hashmap = new HashMap();
        obj = android.provider.Settings.Secure.getString(b.getContentResolver(), "android_id");
        Log.d("LocalCollector", (new StringBuilder("ANDROID_ID:")).append(((String) (obj))).toString());
        hashmap.put(com.a.a.e.a.name(), android.support.v4.e.a.a((new StringBuilder()).append(com.a.a.e.a.name()).append(((String) (obj))).toString()));
        if (android.os.Build.VERSION.SDK_INT > 8)
        {
            hashmap.put(e.b.name(), android.support.v4.e.a.a((new StringBuilder()).append(e.b.name()).append(Build.SERIAL).toString()));
        }
        obj = d();
        if (obj != null)
        {
            hashmap.put(e.c.name(), android.support.v4.e.a.a((new StringBuilder()).append(e.c.name()).append(((String) (obj))).toString()));
        }
        obj = s;
        if (obj1 != null)
        {
            obj = s;
            if (((String) (obj1)).contains(e.d.name()))
            {
                try
                {
                    int i = ((String) (obj1)).indexOf(e.d.name()) + e.d.name().length() + 3;
                    obj = ((String) (obj1)).substring(i, ((String) (obj1)).indexOf('"', i));
                }
                catch (IndexOutOfBoundsException indexoutofboundsexception)
                {
                    indexoutofboundsexception = s;
                }
            }
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = android.support.v4.e.a.a((new StringBuilder()).append(e.d.name()).append(UUID.randomUUID().toString()).toString());
        }
        hashmap.put(e.d.name(), s);
        if (hashmap.size() == 0)
        {
            a.a(b.c, g.f);
            return;
        }
        obj = android.support.v4.e.a.a(hashmap);
        a.a(e.f, ((String) (obj)));
        if (obj1 != null && ((String) (obj1)).length() > 0)
        {
            a.a(e.e, ((String) (obj1)));
        }
        obj1 = b.getSharedPreferences("k_prefs", 0).edit();
        ((android.content.SharedPreferences.Editor) (obj1)).putString("lic", ((String) (obj)));
        ((android.content.SharedPreferences.Editor) (obj1)).commit();
    }
}
