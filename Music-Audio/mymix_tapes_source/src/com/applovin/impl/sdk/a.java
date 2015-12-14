// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bz, dh

class a
{

    private static final Object a = new Object();
    private static final Map b = new HashMap();

    static Map a(AppLovinSdkImpl applovinsdkimpl)
    {
        synchronized (a)
        {
            applovinsdkimpl.getLogger().d("AdDataCache", "Reading cached device data...");
            applovinsdkimpl = c(applovinsdkimpl);
        }
        return applovinsdkimpl;
        applovinsdkimpl;
        obj;
        JVM INSTR monitorexit ;
        throw applovinsdkimpl;
    }

    private static void a(String s, Map map)
    {
        s = s.split("=");
        if (s.length == 2)
        {
            map.put(s[0], s[1]);
        }
    }

    static void a(Map map, AppLovinSdkImpl applovinsdkimpl)
    {
        b(map, applovinsdkimpl);
    }

    static void b(AppLovinSdkImpl applovinsdkimpl)
    {
        synchronized (a)
        {
            applovinsdkimpl.getLogger().d("AdDataCache", "Clearing old device data cache...");
            a(new HashMap(0), applovinsdkimpl);
        }
        return;
        applovinsdkimpl;
        obj;
        JVM INSTR monitorexit ;
        throw applovinsdkimpl;
    }

    private static void b(Map map, AppLovinSdkImpl applovinsdkimpl)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("No ad aata specified");
        }
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        }
        Map map2 = b;
        map2;
        JVM INSTR monitorenter ;
        Map map1 = (Map)b.get("ad_data_cache");
        Object obj;
        obj = map1;
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        obj = new HashMap();
        ((Map) (obj)).clear();
        ((Map) (obj)).putAll(map);
        b.put("ad_data_cache", obj);
        map2;
        JVM INSTR monitorexit ;
        try
        {
            android.content.SharedPreferences.Editor editor = applovinsdkimpl.getSettingsManager().a().edit();
            editor.putString("ad_data_cache", dh.a(map));
            editor.commit();
            applovinsdkimpl.getLogger().d("AdDataCache", (new StringBuilder()).append(map.size()).append(" ").append("ad_data_cache").append(" entries saved in cache").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            applovinsdkimpl.getLogger().e("AdDataCache", "Unable to save ad data entries", map);
        }
        break MISSING_BLOCK_LABEL_192;
        map;
        map2;
        JVM INSTR monitorexit ;
        throw map;
    }

    private static Map c(AppLovinSdkImpl applovinsdkimpl)
    {
        synchronized (b)
        {
            obj1 = (Map)b.get("ad_data_cache");
        }
        if (obj1 != null) goto _L2; else goto _L1
_L1:
        String s;
        SharedPreferences sharedpreferences;
        sharedpreferences = applovinsdkimpl.getSettingsManager().a();
        s = sharedpreferences.getString("ad_data_cache", "");
        if (s == null || s.length() <= 0) goto _L2; else goto _L3
_L3:
        obj = new HashMap();
        int j;
        obj1 = s.split("&");
        j = obj1.length;
        int i = 0;
_L5:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        a(obj1[i], ((Map) (obj)));
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        break MISSING_BLOCK_LABEL_109;
        applovinsdkimpl;
        obj;
        JVM INSTR monitorexit ;
        throw applovinsdkimpl;
        synchronized (b)
        {
            b.put("ad_data_cache", obj);
        }
        applovinsdkimpl.getLogger().d("AdDataCache", (new StringBuilder()).append(((Map) (obj)).size()).append(" ").append("ad_data_cache").append(" entries loaded from cache").toString());
_L8:
        if (obj != null)
        {
            return new HashMap(((Map) (obj)));
        } else
        {
            return new HashMap();
        }
        exception;
        obj1;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
_L6:
        applovinsdkimpl.getLogger().e("AdDataCache", "Unable to load ad data", ((Throwable) (obj1)));
        applovinsdkimpl = sharedpreferences.edit();
        applovinsdkimpl.putString("ad_data_cache", "");
        applovinsdkimpl.commit();
        continue; /* Loop/switch isn't completed */
        Exception exception1;
        exception1;
        obj = obj1;
        obj1 = exception1;
        if (true) goto _L6; else goto _L2
_L2:
        obj = obj1;
        if (true) goto _L8; else goto _L7
_L7:
    }

}
