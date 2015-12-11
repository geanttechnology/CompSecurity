// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

public class FuzzyKeyMemoryCache
    implements MemoryCache
{

    private final MemoryCache cache;
    private final Comparator keyComparator;

    public FuzzyKeyMemoryCache(MemoryCache memorycache, Comparator comparator)
    {
        cache = memorycache;
        keyComparator = comparator;
    }

    public void clear()
    {
        cache.clear();
    }

    public Bitmap get(String s)
    {
        return (Bitmap)cache.get(s);
    }

    public volatile Object get(Object obj)
    {
        return get((String)obj);
    }

    public Collection keys()
    {
        return cache.keys();
    }

    public volatile boolean put(Object obj, Object obj1)
    {
        return put((String)obj, (Bitmap)obj1);
    }

    public boolean put(String s, Bitmap bitmap)
    {
        MemoryCache memorycache = cache;
        memorycache;
        JVM INSTR monitorenter ;
        Object obj = null;
        Iterator iterator = cache.keys().iterator();
_L2:
        String s1 = obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = (String)iterator.next();
        if (keyComparator.compare(s, s1) != 0) goto _L2; else goto _L1
_L1:
        if (s1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        cache.remove(s1);
        memorycache;
        JVM INSTR monitorexit ;
        return cache.put(s, bitmap);
        s;
        memorycache;
        JVM INSTR monitorexit ;
        throw s;
    }

    public volatile void remove(Object obj)
    {
        remove((String)obj);
    }

    public void remove(String s)
    {
        cache.remove(s);
    }
}
