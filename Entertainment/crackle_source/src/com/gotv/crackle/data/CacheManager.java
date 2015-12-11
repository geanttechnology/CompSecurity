// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class CacheManager
{

    private static final int CACHE_LIMIT = 6;
    private static Map sUrlJSONMap = new LinkedHashMap();

    public CacheManager()
    {
    }

    public static void addJSONToCache(String s, JSONObject jsonobject)
    {
        synchronized (sUrlJSONMap)
        {
            sUrlJSONMap.put(s, jsonobject);
            if (sUrlJSONMap.keySet().size() > 6)
            {
                sUrlJSONMap.remove(sUrlJSONMap.keySet().toArray()[0]);
            }
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void clearJSONCache()
    {
        synchronized (sUrlJSONMap)
        {
            sUrlJSONMap.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static JSONObject getJSONFromCache(String s)
    {
        synchronized (sUrlJSONMap)
        {
            s = (JSONObject)sUrlJSONMap.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public static void removeJSONToCache(String s)
    {
        synchronized (sUrlJSONMap)
        {
            try
            {
                sUrlJSONMap.remove(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s) { }
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

}
