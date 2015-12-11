// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionMap
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
        set(collectionmap);
    }

    public CollectionMap(Map map1)
    {
        this(map1.size());
        set(map1);
    }

    private int getInitialListCapacity()
    {
        return initialListCapacity;
    }

    private List insert(Object obj)
    {
        List list = (List)map.get(obj);
        Object obj1 = list;
        if (list == null)
        {
            obj1 = new ArrayList(initialListCapacity);
            map.put(obj, obj1);
        }
        return ((List) (obj1));
    }

    public static CollectionMap merge(CollectionMap collectionmap, CollectionMap collectionmap1)
    {
        return merge(collectionmap, collectionmap1, null);
    }

    public static CollectionMap merge(CollectionMap collectionmap, CollectionMap collectionmap1, CollectionMap collectionmap2)
    {
        CollectionMap collectionmap3 = new CollectionMap();
        if (collectionmap != null)
        {
            collectionmap3.merge(collectionmap);
        }
        if (collectionmap1 != null)
        {
            collectionmap3.merge(collectionmap1);
        }
        if (collectionmap2 != null)
        {
            collectionmap3.merge(collectionmap2);
        }
        return collectionmap3;
    }

    public void add(CollectionMap collectionmap)
    {
        java.util.Map.Entry entry;
        for (collectionmap = collectionmap.entrySet().iterator(); collectionmap.hasNext(); add(entry.getKey(), (List)entry.getValue()))
        {
            entry = (java.util.Map.Entry)collectionmap.next();
        }

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

    public void clear()
    {
        map.clear();
    }

    public void clear(Object obj)
    {
        obj = (List)map.get(obj);
        if (obj != null)
        {
            ((List) (obj)).clear();
        }
    }

    public boolean contains(Object obj, Object obj1)
    {
        obj = (List)map.get(obj);
        return obj != null && ((List) (obj)).contains(obj1);
    }

    public boolean containsKey(Object obj)
    {
        return map.containsKey(obj);
    }

    public Set entrySet()
    {
        return map.entrySet();
    }

    public Object get(Object obj)
    {
        obj = (List)map.get(obj);
        if (obj == null || ((List) (obj)).isEmpty())
        {
            return null;
        } else
        {
            return ((List) (obj)).get(0);
        }
    }

    public List getAll(Object obj)
    {
        return (List)map.get(obj);
    }

    public Map getMap()
    {
        return map;
    }

    public boolean isEmpty()
    {
        return size() == 0;
    }

    public boolean isEmpty(Object obj)
    {
        return size(obj) == 0;
    }

    public void merge(CollectionMap collectionmap)
    {
        java.util.Map.Entry entry;
        for (collectionmap = collectionmap.entrySet().iterator(); collectionmap.hasNext(); set(entry.getKey(), (List)entry.getValue()))
        {
            entry = (java.util.Map.Entry)collectionmap.next();
        }

    }

    public void merge(Map map1)
    {
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); set(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

    }

    public void remove(Object obj)
    {
        map.remove(obj);
    }

    public void remove(Object obj, Object obj1)
    {
        obj = (List)map.get(obj);
        if (obj != null)
        {
            ((List) (obj)).remove(obj1);
        }
    }

    public void set(CollectionMap collectionmap)
    {
        map.clear();
        java.util.Map.Entry entry;
        for (collectionmap = collectionmap.entrySet().iterator(); collectionmap.hasNext(); set(entry.getKey(), (List)entry.getValue()))
        {
            entry = (java.util.Map.Entry)collectionmap.next();
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
        obj = insert(obj);
        ((List) (obj)).clear();
        ((List) (obj)).addAll(list);
    }

    public void set(Map map1)
    {
        map.clear();
        java.util.Map.Entry entry;
        for (map1 = map1.entrySet().iterator(); map1.hasNext(); set(entry.getKey(), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map1.next();
        }

    }

    public void setDefault(CollectionMap collectionmap)
    {
        collectionmap = collectionmap.entrySet().iterator();
        do
        {
            if (!collectionmap.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)collectionmap.next();
            if (!containsKey(entry.getKey()))
            {
                set(entry.getKey(), (List)entry.getValue());
            }
        } while (true);
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

    public int size()
    {
        return map.size();
    }

    public int size(Object obj)
    {
        obj = (List)map.get(obj);
        if (obj != null)
        {
            return ((List) (obj)).size();
        } else
        {
            return 0;
        }
    }
}
