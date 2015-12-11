// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.util.HashMap;
import java.util.Map;

public class Maps
{

    public Maps()
    {
    }

    public static Object get(Map map, Object obj, Class class1)
    {
        return get(map, obj, class1, null);
    }

    public static Object get(Map map, Object obj, Class class1, Object obj1)
    {
        if (map == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        map = ((Map) (class1.cast(map.get(obj))));
        if (map != null)
        {
            return map;
        }
        break MISSING_BLOCK_LABEL_23;
        map;
        return obj1;
    }

    public static Map of(Object obj, Object obj1)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(obj, obj1);
        return hashmap;
    }

    public static Map of(Object obj, Object obj1, Object obj2, Object obj3)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(obj, obj1);
        hashmap.put(obj2, obj3);
        return hashmap;
    }

    public static Map of(Object obj, Object obj1, Object obj2, Object obj3, Object obj4, Object obj5)
    {
        HashMap hashmap = new HashMap();
        hashmap.put(obj, obj1);
        hashmap.put(obj2, obj3);
        hashmap.put(obj4, obj5);
        return hashmap;
    }
}
