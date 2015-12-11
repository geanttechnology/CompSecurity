// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.config.PlayerConfiguration;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStreamResource;
import java.net.URI;

// Referenced classes of package com.xfinity.playerlib.model:
//            TveHypermediaService

public class HalLiveStreamResourceCache extends RevalidatingCachingTask
{

    private final HalObjectFactory entityFactory;
    private final HalHttpClient halHttpClient;
    private final PlayerConfiguration playerConfiguration;
    private final Task tveHypermediaServicesCache;

    public HalLiveStreamResourceCache(Task task, HalObjectFactory halobjectfactory, HalHttpClient halhttpclient, RevalidationPolicy revalidationpolicy, PlayerConfiguration playerconfiguration)
    {
        super(revalidationpolicy);
        tveHypermediaServicesCache = task;
        entityFactory = halobjectfactory;
        halHttpClient = halhttpclient;
        playerConfiguration = playerconfiguration;
    }

    protected HalLiveStreamResource fetchResourceWithNoCache()
    {
        String s1 = ((TveHypermediaService)tveHypermediaServicesCache.execute()).getStremsUri().toString();
        String s = s1;
        if (playerConfiguration.isDarkStreamsEnabled())
        {
            s = (new StringBuilder()).append(s1).append("?dark=true").toString();
        }
        return (HalLiveStreamResource)entityFactory.createWithUrl(s, halHttpClient);
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }
}
