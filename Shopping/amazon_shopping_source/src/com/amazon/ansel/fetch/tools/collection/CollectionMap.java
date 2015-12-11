// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.collection;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionMap
    implements Map
{

    private final int initialListCapacity;
    private final Map map;

    public CollectionMap()
    {
        this(0);
    }

    public CollectionMap(int i)
    {
        this(i, 1);
    }

    public CollectionMap(int i, int j)
    {
        map = new LinkedHashMap(i);
        initialListCapacity = j;
    }

    public CollectionMap(CollectionMap collectionmap)
    {
        this(collectionmap.size(), collectionmap.getInitialListCapacity());
        putAll(collectionmap);
    }

    public void clear()
    {
        map.clear();
    }

    public boolean containsKey(Object obj)
    {
        return map.containsKey(obj);
    }

    public boolean containsValue(Object obj)
    {
        return map.containsValue(obj);
    }

    public Set entrySet()
    {
        return map.entrySet();
    }

    public boolean equals(Object obj)
    {
        if (this != obj) goto _L2; else goto _L1
_L1:
        return true;
_L2:
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        obj = (CollectionMap)obj;
        if (map != null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (((CollectionMap) (obj)).map == null) goto _L1; else goto _L3
_L3:
        return false;
        if (map.equals(((CollectionMap) (obj)).map)) goto _L1; else goto _L4
_L4:
        return false;
    }

    public volatile Object get(Object obj)
    {
        return get(obj);
    }

    public List get(Object obj)
    {
        return (List)map.get(obj);
    }

    public int getInitialListCapacity()
    {
        return initialListCapacity;
    }

    public int hashCode()
    {
        int i;
        if (map == null)
        {
            i = 0;
        } else
        {
            i = map.hashCode();
        }
        return i + 31;
    }

    public boolean isEmpty()
    {
        return map.isEmpty();
    }

    public Set keySet()
    {
        return map.keySet();
    }

    public volatile Object put(Object obj, Object obj1)
    {
        return put(obj, (List)obj1);
    }

    public List put(Object obj, List list)
    {
        return (List)map.put(obj, list);
    }

    public void putAll(Map map1)
    {
        map.putAll(map1);
    }

    public volatile Object remove(Object obj)
    {
        return remove(obj);
    }

    public List remove(Object obj)
    {
        return (List)map.remove(obj);
    }

    public int size()
    {
        return map.size();
    }

    public Collection values()
    {
        return map.values();
    }
}
