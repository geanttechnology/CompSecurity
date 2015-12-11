// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.android.dexload;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package amazon.android.dexload:
//            ThreadUtil

private static class <init>
    implements ThreadFactory
{

    private final AtomicInteger mThreadCount;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable);
        runnable.setName(String.format("DexLoadingPool-%d", new Object[] {
            Integer.valueOf(mThreadCount.getAndIncrement())
        }));
        return runnable;
    }

    private ()
    {
        mThreadCount = new AtomicInteger(0);
    }

    mThreadCount(mThreadCount mthreadcount)
    {
        this();
    }
}
