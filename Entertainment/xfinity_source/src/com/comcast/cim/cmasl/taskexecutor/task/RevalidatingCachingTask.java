// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.task;

import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.task:
//            Task

public abstract class RevalidatingCachingTask
    implements Task
{

    private Object cacheVersion;
    private Object cachedResource;
    private final Object fetchLock = new Object();
    private final Object resourceLock = new Object();
    private RevalidationPolicy revalidationPolicy;
    private Object staleResource;

    public RevalidatingCachingTask(RevalidationPolicy revalidationpolicy)
    {
        revalidationPolicy = revalidationpolicy;
    }

    public void clearCachedResult()
    {
        synchronized (resourceLock)
        {
            cachedResource = null;
            staleResource = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object execute()
    {
        Object obj = fetchLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1 = getCachedResultIfAvailable();
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_20;
        }
        obj;
        JVM INSTR monitorexit ;
        return obj1;
        Object obj3 = fetchResourceWithNoCache();
        synchronized (resourceLock)
        {
            cachedResource = obj3;
            staleResource = obj3;
            cacheVersion = revalidationPolicy.getCurrentVersion();
            obj3 = cachedResource;
        }
        obj;
        JVM INSTR monitorexit ;
        return obj3;
        obj2;
        obj;
        JVM INSTR monitorexit ;
        throw obj2;
        Object obj4;
        obj4;
        synchronized (resourceLock)
        {
            if (!revalidationPolicy.shouldFallBackToLastCached(cacheVersion) || staleResource == null)
            {
                break MISSING_BLOCK_LABEL_113;
            }
            obj4 = staleResource;
        }
        obj;
        JVM INSTR monitorexit ;
        return obj4;
        obj2;
        JVM INSTR monitorexit ;
        throw obj4;
        exception;
        obj2;
        JVM INSTR monitorexit ;
        throw exception;
        exception1;
        obj2;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    protected abstract Object fetchResourceWithNoCache();

    public Object getCachedResultIfAvailable()
    {
        Object obj = resourceLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        if (cachedResource == null || revalidationPolicy.shouldRevalidate(cacheVersion))
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj1 = cachedResource;
        return obj1;
        obj;
        JVM INSTR monitorexit ;
        return null;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Object getSecondLevelStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public Object getStaleResultIfAvailable()
    {
        Object obj1;
        synchronized (resourceLock)
        {
            obj1 = staleResource;
        }
        return obj1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
