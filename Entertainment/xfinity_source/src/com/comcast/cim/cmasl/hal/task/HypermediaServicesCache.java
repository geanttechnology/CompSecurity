// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.task;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.microdata.model.MicrodataItem;

// Referenced classes of package com.comcast.cim.cmasl.hal.task:
//            HypermediaService

public abstract class HypermediaServicesCache extends RevalidatingCachingTask
{

    private HalHttpClient halHttpClient;
    private String hypermediaUrl;

    public HypermediaServicesCache(RevalidationPolicy revalidationpolicy, HalHttpClient halhttpclient, String s)
    {
        super(revalidationpolicy);
        halHttpClient = halhttpclient;
        hypermediaUrl = s;
    }

    protected MicrodataItem fetchMicrodataItem()
    {
        return halHttpClient.fetchMicroData(hypermediaUrl);
    }

    protected abstract HypermediaService fetchResourceWithNoCache();

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }
}
