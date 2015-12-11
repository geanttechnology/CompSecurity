// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

static class executorService
    implements executorService
{

    private static final int keepAliveTimeSeconds = 30;
    private static final int maxNumberThreads = 3;
    private static final int numberThreads = 1;
    private ExecutorService executorService;

    public void execute(Runnable runnable)
    {
        executorService.submit(runnable);
    }

    ()
    {
        executorService = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    }
}
