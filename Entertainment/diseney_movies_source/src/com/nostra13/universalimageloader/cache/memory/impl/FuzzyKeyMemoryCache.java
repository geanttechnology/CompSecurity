// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import com.nostra13.universalimageloader.cache.memory.MemoryCacheAware;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache
    implements MemoryCacheAware
{

    private final MemoryCacheAware cache;
    private final Comparator keyComparator;

    public FuzzyKeyMemoryCache(MemoryCacheAware memorycacheaware, Comparator comparator)
    {
        cache = memorycacheaware;
        keyComparator = comparator;
    }

    public void clear()
    {
        cache.clear();
    }

    public Object get(Object obj)
    {
        return cache.get(obj);
    }

    public Collection keys()
    {
        return cache.keys();
    }

    public boolean put(Object obj, Object obj1)
    {
        MemoryCacheAware memorycacheaware = cache;
        memorycacheaware;
        JVM INSTR monitorenter ;
        Object obj2 = null;
        Iterator iterator = cache.keys().iterator();
_L5:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        cache.remove(obj2);
        memorycacheaware;
        JVM INSTR monitorexit ;
        return cache.put(obj, obj1);
_L2:
        Object obj3;
        obj3 = (Object)iterator.next();
        if (keyComparator.compare(obj, obj3) != 0)
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = obj3;
        if (true) goto _L1; else goto _L3
_L3:
        if (true) goto _L5; else goto _L4
_L4:
        obj;
        memorycacheaware;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void remove(Object obj)
    {
        cache.remove(obj);
    }
}
