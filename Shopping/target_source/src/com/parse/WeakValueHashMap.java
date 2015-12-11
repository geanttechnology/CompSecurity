// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.lang.ref.WeakReference;
import java.util.HashMap;

class WeakValueHashMap
{

    private HashMap map;

    public WeakValueHashMap()
    {
        map = new HashMap();
    }

    public void clear()
    {
        map.clear();
    }

    public Object get(Object obj)
    {
        Object obj1 = (WeakReference)map.get(obj);
        if (obj1 == null)
        {
            obj1 = null;
        } else
        {
            Object obj2 = ((WeakReference) (obj1)).get();
            obj1 = obj2;
            if (obj2 == null)
            {
                map.remove(obj);
                return obj2;
            }
        }
        return obj1;
    }

    public void put(Object obj, Object obj1)
    {
        map.put(obj, new WeakReference(obj1));
    }

    public void remove(Object obj)
    {
        map.remove(obj);
    }
}
