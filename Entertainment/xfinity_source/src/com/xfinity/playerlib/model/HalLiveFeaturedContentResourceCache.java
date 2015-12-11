// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.model.consumable.hal.HalLiveFeaturedContentResource;
import java.net.URI;

// Referenced classes of package com.xfinity.playerlib.model:
//            TveHypermediaService

public class HalLiveFeaturedContentResourceCache extends RevalidatingCachingTask
{

    private final HalObjectFactory entityFactory;
    private final HalHttpClient halHttpClient;
    private final Task tveHypermediaServicesCache;

    public HalLiveFeaturedContentResourceCache(Task task, HalObjectFactory halobjectfactory, HalHttpClient halhttpclient, RevalidationPolicy revalidationpolicy)
    {
        super(revalidationpolicy);
        tveHypermediaServicesCache = task;
        entityFactory = halobjectfactory;
        halHttpClient = halhttpclient;
    }

    protected HalLiveFeaturedContentResource fetchResourceWithNoCache()
    {
        return (HalLiveFeaturedContentResource)entityFactory.createWithUrl(((TveHypermediaService)tveHypermediaServicesCache.execute()).getPromotedContentUri().toString(), halHttpClient);
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }
}
