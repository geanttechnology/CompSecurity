// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

// Referenced classes of package com.google.tagmanager:
//            ResourceLoaderSchedulerImpl

class this._cls0
    implements heduledExecutorServiceFactory
{

    final ResourceLoaderSchedulerImpl this$0;

    public ScheduledExecutorService createExecutorService()
    {
        return Executors.newSingleThreadScheduledExecutor();
    }

    heduledExecutorServiceFactory()
    {
        this$0 = ResourceLoaderSchedulerImpl.this;
        super();
    }
}
