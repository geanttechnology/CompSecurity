// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.j256.ormlite.dao:
//            ObjectCache

public class ReferenceObjectCache
    implements ObjectCache
{

    private final ConcurrentHashMap classMaps = new ConcurrentHashMap();
    private final boolean useWeak;

    public ReferenceObjectCache(boolean flag)
    {
        useWeak = flag;
    }

    private void cleanMap(Map map)
    {
        map = map.entrySet().iterator();
        do
        {
            if (!map.hasNext())
            {
                break;
            }
            if (((Reference)((java.util.Map.Entry)map.next()).getValue()).get() == null)
            {
                map.remove();
            }
        } while (true);
    }

    private Map getMapForClass(Class class1)
    {
        Map map = (Map)classMaps.get(class1);
        Object obj = map;
        if (map == null)
        {
            obj = new ConcurrentHashMap();
            classMaps.put(class1, obj);
        }
        return ((Map) (obj));
    }

    public static ReferenceObjectCache makeSoftCache()
    {
        return new ReferenceObjectCache(false);
    }

    public static ReferenceObjectCache makeWeakCache()
    {
        return new ReferenceObjectCache(true);
    }

    public void cleanNullReferences(Class class1)
    {
        cleanMap(getMapForClass(class1));
    }

    public void cleanNullReferencesAll()
    {
        for (Iterator iterator = classMaps.values().iterator(); iterator.hasNext(); cleanMap((Map)iterator.next())) { }
    }

    public void clear(Class class1)
    {
        getMapForClass(class1).clear();
    }

    public void clearAll()
    {
        for (Iterator iterator = classMaps.values().iterator(); iterator.hasNext(); ((Map)iterator.next()).clear()) { }
    }

    public Object get(Class class1, Object obj)
    {
        Map map = getMapForClass(class1);
        class1 = (Reference)map.get(obj);
        if (class1 == null)
        {
            class1 = null;
        } else
        {
            Object obj1 = class1.get();
            class1 = ((Class) (obj1));
            if (obj1 == null)
            {
                map.remove(obj);
                return null;
            }
        }
        return class1;
    }

    public void put(Class class1, Object obj, Object obj1)
    {
        class1 = getMapForClass(class1);
        if (useWeak)
        {
            class1.put(obj, new WeakReference(obj1));
            return;
        } else
        {
            class1.put(obj, new SoftReference(obj1));
            return;
        }
    }

    public void remove(Class class1, Object obj)
    {
        getMapForClass(class1).remove(obj);
    }

    public int size(Class class1)
    {
        return getMapForClass(class1).size();
    }

    public int sizeAll()
    {
        Iterator iterator = classMaps.values().iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = ((Map)iterator.next()).size() + i) { }
        return i;
    }

    public Object updateId(Class class1, Object obj, Object obj1)
    {
        class1 = getMapForClass(class1);
        obj = (Reference)class1.remove(obj);
        if (obj == null)
        {
            return null;
        } else
        {
            class1.put(obj1, obj);
            return ((Reference) (obj)).get();
        }
    }
}
