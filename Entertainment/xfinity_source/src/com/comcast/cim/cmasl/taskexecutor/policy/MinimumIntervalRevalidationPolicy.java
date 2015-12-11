// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.policy;

import java.util.Date;

// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.policy:
//            RevalidationPolicy

public class MinimumIntervalRevalidationPolicy
    implements RevalidationPolicy
{

    private int currentVersion;
    private final Object lock = new Object();
    private final long minIntervalInMillis;
    private long timeOfLastVersionChange;

    public MinimumIntervalRevalidationPolicy(long l)
    {
        currentVersion = -1;
        minIntervalInMillis = l;
    }

    public Integer getCurrentVersion()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        long l = System.currentTimeMillis();
        if (l - timeOfLastVersionChange > minIntervalInMillis)
        {
            currentVersion = currentVersion + 1;
            timeOfLastVersionChange = l;
        }
        int i = currentVersion;
        return Integer.valueOf(i);
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public volatile Object getCurrentVersion()
    {
        return getCurrentVersion();
    }

    public boolean shouldFallBackToLastCached(Integer integer)
    {
        return true;
    }

    public volatile boolean shouldFallBackToLastCached(Object obj)
    {
        return shouldFallBackToLastCached((Integer)obj);
    }

    public boolean shouldRevalidate(Integer integer)
    {
        return integer == null || getCurrentVersion().intValue() > integer.intValue();
    }

    public volatile boolean shouldRevalidate(Object obj)
    {
        return shouldRevalidate((Integer)obj);
    }

    public String toString()
    {
        return (new StringBuilder()).append("timeOfLastVersionChange: ").append(new Date(timeOfLastVersionChange)).append(", currentVersion: ").append(currentVersion).toString();
    }
}
