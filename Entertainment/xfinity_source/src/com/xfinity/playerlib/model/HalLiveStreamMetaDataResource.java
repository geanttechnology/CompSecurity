// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.taskexecutor.task.SimpleTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import java.net.URI;

// Referenced classes of package com.xfinity.playerlib.model:
//            TveHypermediaService

public class HalLiveStreamMetaDataResource extends SimpleTask
{

    private final HalObjectFactory entityFactory;
    private final HalHttpClient halHttpClient;
    private final String streamName;
    private final Task tveHypermediaServicesCache;

    public HalLiveStreamMetaDataResource(Task task, HalObjectFactory halobjectfactory, HalHttpClient halhttpclient, String s)
    {
        tveHypermediaServicesCache = task;
        entityFactory = halobjectfactory;
        halHttpClient = halhttpclient;
        streamName = s;
    }

    public HalLiveStream execute()
    {
        return (HalLiveStream)entityFactory.createWithUrl(((TveHypermediaService)tveHypermediaServicesCache.execute()).getStreamMetadataUri(streamName).toString(), halHttpClient);
    }

    public volatile Object execute()
    {
        return execute();
    }
}
