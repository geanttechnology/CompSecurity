// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class LruCache
{

    private final LinkedHashMap cache = new LinkedHashMap(100, 0.75F, true);
    private int currentSize;
    private final int initialMaxSize;
    private int maxSize;

    public LruCache(int i)
    {
        currentSize = 0;
        initialMaxSize = i;
        maxSize = i;
    }

    private void evict()
    {
        trimToSize(maxSize);
    }

    public void clearMemory()
    {
        trimToSize(0);
    }

    public Object get(Object obj)
    {
        return cache.get(obj);
    }

    public int getCurrentSize()
    {
        return currentSize;
    }

    protected int getSize(Object obj)
    {
        return 1;
    }

    protected void onItemEvicted(Object obj, Object obj1)
    {
    }

    public Object put(Object obj, Object obj1)
    {
        if (getSize(obj1) >= maxSize)
        {
            onItemEvicted(obj, obj1);
            return null;
        }
        obj = cache.put(obj, obj1);
        if (obj1 != null)
        {
            currentSize = currentSize + getSize(obj1);
        }
        if (obj != null)
        {
            currentSize = currentSize - getSize(obj);
        }
        evict();
        return obj;
    }

    public Object remove(Object obj)
    {
        obj = cache.remove(obj);
        if (obj != null)
        {
            currentSize = currentSize - getSize(obj);
        }
        return obj;
    }

    protected void trimToSize(int i)
    {
        while (currentSize > i) 
        {
            Object obj1 = (java.util.Map.Entry)cache.entrySet().iterator().next();
            Object obj = ((java.util.Map.Entry) (obj1)).getValue();
            currentSize = currentSize - getSize(obj);
            obj1 = ((java.util.Map.Entry) (obj1)).getKey();
            cache.remove(obj1);
            onItemEvicted(obj1, obj);
        }
    }
}
