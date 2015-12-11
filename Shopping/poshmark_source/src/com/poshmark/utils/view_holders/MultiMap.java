// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils.view_holders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MultiMap extends HashMap
{

    List data;

    public MultiMap()
    {
        data = new ArrayList();
    }

    public void clear()
    {
    }

    public boolean containsKey(Object obj)
    {
        for (Iterator iterator = data.iterator(); iterator.hasNext();)
        {
            if (((java.util.Map.Entry)iterator.next()).getKey().equals(obj))
            {
                return true;
            }
        }

        return false;
    }

    public boolean containsValue(Object obj)
    {
        for (Iterator iterator = data.iterator(); iterator.hasNext();)
        {
            if (((java.util.Map.Entry)iterator.next()).getValue().equals(obj))
            {
                return true;
            }
        }

        return false;
    }

    public Set entrySet()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = data.iterator(); iterator.hasNext(); hashset.add((java.util.Map.Entry)iterator.next())) { }
        return hashset;
    }

    public Object get(Object obj)
    {
        return null;
    }

    public boolean isEmpty()
    {
        return data.isEmpty();
    }

    public Object put(Object obj, Object obj1)
    {
        obj = new java.util.AbstractMap.SimpleEntry(obj, obj1);
        data.add(obj);
        return obj1;
    }

    public void putAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); data.add(entry))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public void putNestedFormParams(String s, Object obj)
    {
        if (obj instanceof HashMap)
        {
            String s1;
            Object obj1;
            for (obj = ((HashMap)obj).entrySet().iterator(); ((Iterator) (obj)).hasNext(); putNestedFormParams((new StringBuilder()).append(s).append("[").append(s1).append("]").toString(), obj1))
            {
                obj1 = (java.util.Map.Entry)((Iterator) (obj)).next();
                s1 = (String)((java.util.Map.Entry) (obj1)).getKey();
                obj1 = ((java.util.Map.Entry) (obj1)).getValue();
                ((Iterator) (obj)).remove();
            }

        } else
        {
            HashMap hashmap = new HashMap();
            hashmap.put(s, (String)obj);
            for (s = hashmap.entrySet().iterator(); s.hasNext(); data.add(obj))
            {
                obj = (java.util.Map.Entry)s.next();
            }

        }
    }

    public Object remove(Object obj)
    {
        Iterator iterator = data.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (((java.util.Map.Entry)iterator.next()).getKey().equals(obj))
            {
                iterator.remove();
            }
        } while (true);
        return null;
    }

    public int size()
    {
        return data.size();
    }
}
