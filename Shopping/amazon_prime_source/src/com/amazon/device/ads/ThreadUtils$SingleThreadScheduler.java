// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

public static class executorService extends executorService
{

    private ExecutorService executorService;

    public void execute(Runnable runnable)
    {
        executorService.submit(runnable);
    }

    public ()
    {
        super(E, OUND_THREAD);
        executorService = Executors.newSingleThreadExecutor();
    }
}
