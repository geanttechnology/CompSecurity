// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;

import com.newrelic.agent.android.harvest.type.Harvestable;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

public class HarvestableCache
{

    private static final int DEFAULT_CACHE_LIMIT = 1024;
    private final Collection cache = getNewCache();
    private int limit;

    public HarvestableCache()
    {
        limit = 1024;
    }

    public void add(Harvestable harvestable)
    {
        if (harvestable == null || cache.size() >= limit)
        {
            return;
        } else
        {
            cache.add(harvestable);
            return;
        }
    }

    public Collection flush()
    {
        if (cache.size() == 0)
        {
            return Collections.emptyList();
        }
        this;
        JVM INSTR monitorenter ;
        Collection collection;
        collection = getNewCache();
        collection.addAll(cache);
        cache.clear();
        this;
        JVM INSTR monitorexit ;
        return collection;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean get(Object obj)
    {
        return cache.contains(obj);
    }

    protected Collection getNewCache()
    {
        return new CopyOnWriteArrayList();
    }

    public int getSize()
    {
        return cache.size();
    }

    public void setLimit(int i)
    {
        limit = i;
    }
}
