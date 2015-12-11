// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.task.HypermediaService;
import com.comcast.cim.cmasl.hal.task.HypermediaServicesCache;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;

// Referenced classes of package com.xfinity.playerlib.model:
//            TveHypermediaService

public class TveHypermediaServicesCache extends HypermediaServicesCache
{

    public TveHypermediaServicesCache(RevalidationPolicy revalidationpolicy, HalHttpClient halhttpclient, String s)
    {
        super(revalidationpolicy, halhttpclient, s);
    }

    protected volatile HypermediaService fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }

    protected TveHypermediaService fetchResourceWithNoCache()
    {
        return new TveHypermediaService(fetchMicrodataItem());
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }
}
