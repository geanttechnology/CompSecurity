// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinSdkImpl, bz

class cb
{

    private final AppLovinSdkImpl a;
    private final Map b = new HashMap();

    cb(AppLovinSdkImpl applovinsdkimpl)
    {
        if (applovinsdkimpl == null)
        {
            throw new IllegalArgumentException("No sdk specified");
        } else
        {
            a = applovinsdkimpl;
            return;
        }
    }

    void a()
    {
        synchronized (b)
        {
            b.clear();
        }
        d();
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void a(String s)
    {
        a(s, 1L);
    }

    void a(String s, long l)
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Long long2 = (Long)b.get(s);
        Long long1;
        long1 = long2;
        if (long2 != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        long1 = Long.valueOf(0L);
        long l1 = long1.longValue();
        b.put(s, Long.valueOf(l1 + l));
        map;
        JVM INSTR monitorexit ;
        d();
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    long b(String s)
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Long long1 = (Long)b.get(s);
        s = long1;
        if (long1 != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        s = Long.valueOf(0L);
        long l = s.longValue();
        map;
        JVM INSTR monitorexit ;
        return l;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    JSONObject b()
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Object obj;
        obj = new JSONObject();
        java.util.Map.Entry entry;
        for (Iterator iterator = b.entrySet().iterator(); iterator.hasNext(); ((JSONObject) (obj)).put((String)entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break MISSING_BLOCK_LABEL_80;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        map;
        JVM INSTR monitorexit ;
        return ((JSONObject) (obj));
    }

    void b(String s, long l)
    {
        synchronized (b)
        {
            b.put(s, Long.valueOf(l));
        }
        d();
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void c()
    {
        Object obj = a.getSettingsManager().a().getString("stats", "{}");
        JSONObject jsonobject = new JSONObject(((String) (obj)));
        obj = b;
        obj;
        JVM INSTR monitorenter ;
        Iterator iterator = jsonobject.keys();
_L1:
        boolean flag = iterator.hasNext();
        Exception exception;
label0:
        {
            if (!flag)
            {
                break label0;
            }
            try
            {
                String s = (String)iterator.next();
                long l = jsonobject.getLong(s);
                b.put(s, Long.valueOf(l));
            }
            catch (JSONException jsonexception) { }
            finally { }
        }
          goto _L1
        obj;
        JVM INSTR monitorexit ;
        return;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw exception;
        }
        catch (Throwable throwable)
        {
            a.getLogger().e("StatsManager", "Unable to load stats", throwable);
        }
        return;
    }

    void c(String s)
    {
        synchronized (b)
        {
            b.remove(s);
        }
        d();
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    void d()
    {
        try
        {
            android.content.SharedPreferences.Editor editor = a.getSettingsManager().a().edit();
            editor.putString("stats", b().toString());
            editor.commit();
            return;
        }
        catch (JSONException jsonexception)
        {
            a.getLogger().e("StatsManager", "Unable to save stats", jsonexception);
        }
    }
}
