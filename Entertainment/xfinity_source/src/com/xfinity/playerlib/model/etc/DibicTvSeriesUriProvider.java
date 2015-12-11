// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.etc;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.utils.provider.Provider;
import com.xfinity.playerlib.model.ConsumablesHypermediaService;
import java.net.URI;

public class DibicTvSeriesUriProvider
    implements Provider
{

    private final Task hypermediaServiceCache;

    public DibicTvSeriesUriProvider(Task task)
    {
        hypermediaServiceCache = task;
    }

    public volatile Object get()
    {
        return get();
    }

    public URI get()
    {
        return ((ConsumablesHypermediaService)hypermediaServiceCache.execute()).getDibicTvSeriesUri();
    }
}
