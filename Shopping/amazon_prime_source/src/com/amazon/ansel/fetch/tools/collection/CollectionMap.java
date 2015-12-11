// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
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

    public CollectionMap(Map map1)
    {
        this(map1.size(), 1);
        putAll(map1);
    }

    private List insert(Object obj)
    {
        List list = (List)map.get(obj);
        obj = list;
        if (list == null)
        {
            obj = new ArrayList(initialListCapacity);
        }
        return ((List) (obj));
    }

    public void add(Object obj, Object obj1)
    {
        insert(obj).add(obj1);
    }

    public void add(Object obj, List list)
    {
        insert(obj).addAll(list);
    }

    public void add(Map map1)
    {
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); add(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

    }

    public void addMulti(Map map1)
    {
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); add(entry.getKey(), (List)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

    }

    public void clear()
    {
        map.clear();
    }

    public boolean containsEntry(Object obj, Object obj1)
    {
        obj = (List)map.get(obj);
        return obj != null && ((List) (obj)).contains(obj1);
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

    public Object getFirst(Object obj)
    {
        obj = (List)map.get(obj);
        if (obj != null && !((List) (obj)).isEmpty())
        {
            return ((List) (obj)).get(0);
        } else
        {
            return null;
        }
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

    public boolean remove(Object obj, Object obj1)
    {
        obj = (List)map.get(obj);
        if (obj != null)
        {
            return ((List) (obj)).remove(obj1);
        } else
        {
            return true;
        }
    }

    public void set(Object obj, Object obj1)
    {
        obj = insert(obj);
        ((List) (obj)).clear();
        ((List) (obj)).add(obj1);
    }

    public void set(Object obj, List list)
    {
        List list1 = (List)map.get(obj);
        if (list1 != null)
        {
            list1.clear();
            list1.addAll(list);
            return;
        } else
        {
            list = new ArrayList(list);
            map.put(obj, list);
            return;
        }
    }

    public void set(Map map1)
    {
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); set(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

    }

    public void setDefault(Map map1)
    {
        map1 = map1.entrySet().iterator();
        do
        {
            if (!map1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map1.next();
            if (!containsKey(entry.getKey()))
            {
                set(entry.getKey(), entry.getValue());
            }
        } while (true);
    }

    public void setDefaultMulti(Map map1)
    {
        map1 = map1.entrySet().iterator();
        do
        {
            if (!map1.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)map1.next();
            if (!containsKey(entry.getKey()))
            {
                set(entry.getKey(), (List)entry.getValue());
            }
        } while (true);
    }

    public void setMulti(Map map1)
    {
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); set(entry.getKey(), (List)entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

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
