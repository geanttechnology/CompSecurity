// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            FutureRequestExecutionMetrics

static class 
{

    private final AtomicLong count = new AtomicLong(0L);
    private final AtomicLong cumulativeDuration = new AtomicLong(0L);

    public long averageDuration()
    {
        long l = 0L;
        long l1 = count.get();
        if (l1 > 0L)
        {
            l = cumulativeDuration.get() / l1;
        }
        return l;
    }

    public long count()
    {
        return count.get();
    }

    public void increment(long l)
    {
        count.incrementAndGet();
        cumulativeDuration.addAndGet(System.currentTimeMillis() - l);
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("[count=").append(count()).append(", averageDuration=").append(averageDuration()).append("]");
        return stringbuilder.toString();
    }

    ()
    {
    }
}
