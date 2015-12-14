// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import com.bumptech.glide.request.ResourceCallback;

// Referenced classes of package com.bumptech.glide.load.engine:
//            Engine, EngineJob

public static class engineJob
{

    private final ResourceCallback cb;
    private final EngineJob engineJob;

    public void cancel()
    {
        engineJob.removeCallback(cb);
    }

    public (ResourceCallback resourcecallback, EngineJob enginejob)
    {
        cb = resourcecallback;
        engineJob = enginejob;
    }
}
