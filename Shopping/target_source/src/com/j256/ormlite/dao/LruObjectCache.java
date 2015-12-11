// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.j256.ormlite.dao:
//            ObjectCache

public class LruObjectCache
    implements ObjectCache
{
    private static class LimitedLinkedHashMap extends LinkedHashMap
    {

        private static final long serialVersionUID = 0xc0a06ee7c72ce80cL;
        private final int capacity;

        protected boolean removeEldestEntry(java.util.Map.Entry entry)
        {
            return size() > capacity;
        }

        public LimitedLinkedHashMap(int i)
        {
            super(i, 0.75F, true);
            capacity = i;
        }
    }


    private final int capacity;
    private final ConcurrentHashMap classMaps = new ConcurrentHashMap();

    public LruObjectCache(int i)
    {
        capacity = i;
    }

    private Map getMapForClass(Class class1)
    {
        Map map = (Map)classMaps.get(class1);
        class1 = map;
        if (map == null)
        {
            class1 = null;
        }
        return class1;
    }

    public void clear(Class class1)
    {
        class1 = getMapForClass(class1);
        if (class1 != null)
        {
            class1.clear();
        }
    }

    public void clearAll()
    {
        for (Iterator iterator = classMaps.values().iterator(); iterator.hasNext(); ((Map)iterator.next()).clear()) { }
    }

    public Object get(Class class1, Object obj)
    {
        class1 = getMapForClass(class1);
        if (class1 == null)
        {
            return null;
        } else
        {
            return class1.get(obj);
        }
    }

    public void put(Class class1, Object obj, Object obj1)
    {
        class1 = getMapForClass(class1);
        if (class1 != null)
        {
            class1.put(obj, obj1);
        }
    }

    public void registerClass(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        if ((Map)classMaps.get(class1) == null)
        {
            Map map = Collections.synchronizedMap(new LimitedLinkedHashMap(capacity));
            classMaps.put(class1, map);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        class1;
        throw class1;
    }

    public void remove(Class class1, Object obj)
    {
        class1 = getMapForClass(class1);
        if (class1 != null)
        {
            class1.remove(obj);
        }
    }

    public int size(Class class1)
    {
        class1 = getMapForClass(class1);
        if (class1 == null)
        {
            return 0;
        } else
        {
            return class1.size();
        }
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
        if (class1 != null)
        {
            if ((obj = class1.remove(obj)) != null)
            {
                class1.put(obj1, obj);
                return obj;
            }
        }
        return null;
    }
}
