// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            JobScheduler

static class 
{

    private static ScheduledExecutorService sJobStarterExecutor;

    static ScheduledExecutorService get()
    {
        if (sJobStarterExecutor == null)
        {
            sJobStarterExecutor = Executors.newSingleThreadScheduledExecutor();
        }
        return sJobStarterExecutor;
    }

    ()
    {
    }
}
