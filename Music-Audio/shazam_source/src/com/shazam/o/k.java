// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.o;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class k
{

    public static Map a(Object obj, Object obj1)
    {
        HashMap hashmap = new HashMap();
        if (obj1 != null)
        {
            hashmap.put(obj, obj1);
        }
        return hashmap;
    }

    public static void a(Map map, Map map1)
    {
        map1 = new HashMap(map1);
        map1.keySet().removeAll(map.keySet());
        map.putAll(map1);
    }

    public static boolean a(Map map)
    {
        boolean flag;
        if (map == null || map.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return !flag;
    }

    public static Map b(Map map)
    {
        Map map1 = map;
        if (map == null)
        {
            map1 = Collections.emptyMap();
        }
        return map1;
    }

    // Unreferenced inner class com/shazam/o/k$a
    /* block-local class not found */
    class a {}

}
