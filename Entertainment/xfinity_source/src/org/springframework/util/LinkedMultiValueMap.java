// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.springframework.util;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package org.springframework.util:
//            MultiValueMap

public class LinkedMultiValueMap
    implements Serializable, MultiValueMap
{

    private final Map targetMap;

    public LinkedMultiValueMap()
    {
        targetMap = new LinkedHashMap();
    }

    public LinkedMultiValueMap(int i)
    {
        targetMap = new LinkedHashMap(i);
    }

    public void add(Object obj, Object obj1)
    {
        List list = (List)targetMap.get(obj);
        Object obj2 = list;
        if (list == null)
        {
            obj2 = new LinkedList();
            targetMap.put(obj, obj2);
        }
        ((List) (obj2)).add(obj1);
    }

    public void clear()
    {
        targetMap.clear();
    }

    public boolean containsKey(Object obj)
    {
        return targetMap.containsKey(obj);
    }

    public boolean containsValue(Object obj)
    {
        return targetMap.containsValue(obj);
    }

    public Set entrySet()
    {
        return targetMap.entrySet();
    }

    public boolean equals(Object obj)
    {
        return targetMap.equals(obj);
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public List get(Object obj)
    {
        return (List)targetMap.get(obj);
    }

    public int hashCode()
    {
        return targetMap.hashCode();
    }

    public boolean isEmpty()
    {
        return targetMap.isEmpty();
    }

    public Set keySet()
    {
        return targetMap.keySet();
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put(obj, (List)obj1);
    }

    public List put(Object obj, List list)
    {
        return (List)targetMap.put(obj, list);
    }

    public void putAll(Map map)
    {
        targetMap.putAll(map);
    }

    public volatile Object remove(Object obj)
    {
        return remove(obj);
    }

    public List remove(Object obj)
    {
        return (List)targetMap.remove(obj);
    }

    public void set(Object obj, Object obj1)
    {
        LinkedList linkedlist = new LinkedList();
        linkedlist.add(obj1);
        targetMap.put(obj, linkedlist);
    }

    public void setAll(Map map)
    {
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); set(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

    }

    public int size()
    {
        return targetMap.size();
    }

    public String toString()
    {
        return targetMap.toString();
    }

    public Collection values()
    {
        return targetMap.values();
    }
}
