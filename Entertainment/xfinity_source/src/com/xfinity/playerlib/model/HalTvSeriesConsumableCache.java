// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;

import com.comcast.cim.cmasl.android.util.system.AndroidDevice;
import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import com.comcast.cim.cmasl.hal.model.HalObjectFactory;
import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.taskexecutor.task.RevalidatingCachingTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import java.net.URI;

// Referenced classes of package com.xfinity.playerlib.model:
//            ConsumablesHypermediaService, MerlinId

public class HalTvSeriesConsumableCache extends RevalidatingCachingTask
{

    private final AndroidDevice androidDevice;
    private final HalObjectFactory entityFactory;
    private final HalHttpClient halHttpClient;
    private final Task hypermediaServiceCache;
    private final MerlinId merlinId;

    public HalTvSeriesConsumableCache(HalObjectFactory halobjectfactory, HalHttpClient halhttpclient, RevalidationPolicy revalidationpolicy, Task task, AndroidDevice androiddevice, MerlinId merlinid)
    {
        super(revalidationpolicy);
        entityFactory = halobjectfactory;
        halHttpClient = halhttpclient;
        hypermediaServiceCache = task;
        androidDevice = androiddevice;
        merlinId = merlinid;
    }

    protected HalTvSeriesConsumable fetchResourceWithNoCache()
    {
        URI uri = ((ConsumablesHypermediaService)hypermediaServiceCache.execute()).getConsumablesUri(merlinId.getSimpleId().toString(), String.format("%d", new Object[] {
            Integer.valueOf(androidDevice.getScreenWidth())
        }));
        return (HalTvSeriesConsumable)entityFactory.createWithUrl(uri.toString(), halHttpClient);
    }

    protected volatile Object fetchResourceWithNoCache()
    {
        return fetchResourceWithNoCache();
    }
}
