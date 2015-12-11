// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.cache;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.google.common.cache:
//            AbstractCache

public static class 
    implements 
{

    private final AtomicLong evictionCount = new AtomicLong();
    private final AtomicLong hitCount = new AtomicLong();
    private final AtomicLong loadExceptionCount = new AtomicLong();
    private final AtomicLong loadSuccessCount = new AtomicLong();
    private final AtomicLong missCount = new AtomicLong();
    private final AtomicLong totalLoadTime = new AtomicLong();

    public void recordEviction()
    {
        evictionCount.incrementAndGet();
    }

    public void recordHits(int i)
    {
        hitCount.addAndGet(i);
    }

    public void recordLoadException(long l)
    {
        loadExceptionCount.incrementAndGet();
        totalLoadTime.addAndGet(l);
    }

    public void recordLoadSuccess(long l)
    {
        loadSuccessCount.incrementAndGet();
        totalLoadTime.addAndGet(l);
    }

    public void recordMisses(int i)
    {
        missCount.addAndGet(i);
    }

    public ()
    {
    }
}
