// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.comcast.cim.cmasl.taskexecutor.task.TaskFactory;
import com.xfinity.playerlib.model.consumable.hal.HalMovieConsumable;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;

// Referenced classes of package com.xfinity.playerlib.model.consumable:
//            WatchableKey, EncodedWatchable, WatchableCodec, Watchable

public class WatchableClient
{

    private final TaskFactory movieCacheMap;
    private final TaskFactory tvSeriesCacheMap;
    private final WatchableCodec watchableCodec;

    public WatchableClient(TaskFactory taskfactory, TaskFactory taskfactory1, WatchableCodec watchablecodec)
    {
        movieCacheMap = taskfactory;
        tvSeriesCacheMap = taskfactory1;
        watchableCodec = watchablecodec;
    }

    public Watchable fetchWatchable(WatchableKey watchablekey)
    {
        com.xfinity.playerlib.model.MerlinId merlinid = watchablekey.getParentMerlinId();
        if (watchablekey.isMovie())
        {
            watchablekey = new EncodedWatchable(watchablekey, (HalMovieConsumable)movieCacheMap.get(merlinid).execute());
        } else
        {
            watchablekey = new EncodedWatchable(watchablekey, (HalTvSeriesConsumable)tvSeriesCacheMap.get(merlinid).execute());
        }
        return watchableCodec.decode(watchablekey);
    }
}
