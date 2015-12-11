// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.BaseTask;
import com.comcast.cim.cmasl.taskexecutor.task.Task;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.hal.HalTvSeriesConsumable;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import com.xfinity.playerlib.model.dibic.DibicResource;
import com.xfinity.playerlib.model.entitlement.VideoEntitlement;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesResource, SeriesEpisodeBookmarkCache

public class SeriesResourceCache extends BaseTask
{

    private final Task dibicResourceCache;
    private final Task entitlementCache;
    private final Task seriesCache;
    private final CachingVideoBookmarkDAO seriesEpisodeBookmarkCache;

    public SeriesResourceCache(Task task, Task task1, Task task2, CachingVideoBookmarkDAO cachingvideobookmarkdao)
    {
        entitlementCache = task;
        seriesCache = task1;
        dibicResourceCache = task2;
        seriesEpisodeBookmarkCache = cachingvideobookmarkdao;
    }

    public void clearCachedResult()
    {
    }

    public SeriesResource execute()
    {
        Object obj = (HalTvSeriesConsumable)seriesCache.execute();
        VideoEntitlement videoentitlement = (VideoEntitlement)entitlementCache.execute();
        DibicResource dibicresource = (DibicResource)dibicResourceCache.execute();
        obj = new TvSeriesFacade(((HalTvSeriesConsumable) (obj)));
        return new SeriesResource(videoentitlement, ((TvSeriesFacade) (obj)), dibicresource, (new SeriesEpisodeBookmarkCache(seriesEpisodeBookmarkCache, ((TvSeriesFacade) (obj)))).execute());
    }

    public volatile Object execute()
    {
        return execute();
    }

    public SeriesResource getCachedResultIfAvailable()
    {
        Object obj = (HalTvSeriesConsumable)seriesCache.getCachedResultIfAvailable();
        VideoEntitlement videoentitlement = (VideoEntitlement)entitlementCache.getCachedResultIfAvailable();
        DibicResource dibicresource = (DibicResource)dibicResourceCache.getCachedResultIfAvailable();
        if (obj != null && videoentitlement != null && dibicresource != null)
        {
            obj = new TvSeriesFacade(((HalTvSeriesConsumable) (obj)));
            java.util.Map map = (new SeriesEpisodeBookmarkCache(seriesEpisodeBookmarkCache, ((TvSeriesFacade) (obj)))).getCachedResultIfAvailable();
            if (map != null)
            {
                return new SeriesResource(videoentitlement, ((TvSeriesFacade) (obj)), dibicresource, map);
            }
        }
        return null;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public SeriesResource getSecondLevelStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public SeriesResource getStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }
}
