// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.bumptech.glide.load.engine:
//            Engine, EngineJob, EngineJobListener

static class listener
{

    private final ExecutorService diskCacheService;
    private final EngineJobListener listener;
    private final ExecutorService sourceService;

    public EngineJob build(Key key, boolean flag)
    {
        return new EngineJob(key, diskCacheService, sourceService, flag, listener);
    }

    public (ExecutorService executorservice, ExecutorService executorservice1, EngineJobListener enginejoblistener)
    {
        diskCacheService = executorservice;
        sourceService = executorservice1;
        listener = enginejoblistener;
    }
}
