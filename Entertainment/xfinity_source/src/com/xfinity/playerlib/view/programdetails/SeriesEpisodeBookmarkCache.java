// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.BaseTask;
import com.google.common.collect.Maps;
import com.xfinity.playerlib.model.consumable.TvSeriesFacade;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SeriesEpisodeBookmarkCache extends BaseTask
{

    private final CachingVideoBookmarkDAO bookmarkDAO;
    private final TvSeriesFacade tvSeriesFacade;

    public SeriesEpisodeBookmarkCache(CachingVideoBookmarkDAO cachingvideobookmarkdao, TvSeriesFacade tvseriesfacade)
    {
        bookmarkDAO = cachingvideobookmarkdao;
        tvSeriesFacade = tvseriesfacade;
    }

    public void clearCachedResult()
    {
    }

    public volatile Object execute()
    {
        return execute();
    }

    public Map execute()
    {
        Object obj = tvSeriesFacade.getAllEpisodeFacades();
        java.util.HashMap hashmap = Maps.newHashMap();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Watchable watchable = (Watchable)((Iterator) (obj)).next();
            Iterator iterator = watchable.getVideos().iterator();
            while (iterator.hasNext()) 
            {
                VideoFacade videofacade = (VideoFacade)iterator.next();
                if (videofacade.getNetworkInfo() != null)
                {
                    hashmap.put(videofacade, bookmarkDAO.getOrCreateBookmarkWithVideo(videofacade, watchable));
                }
            }
        }

        return hashmap;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public Map getCachedResultIfAvailable()
    {
        Object obj = tvSeriesFacade.getAllEpisodeFacades();
        HashSet hashset = new HashSet();
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            Iterator iterator = ((Watchable)((Iterator) (obj)).next()).getVideos().iterator();
            while (iterator.hasNext()) 
            {
                hashset.add((VideoFacade)iterator.next());
            }
        }

        return bookmarkDAO.getCachedVideoToBookmarkMapIfAvailable(hashset);
    }

    public volatile Object getSecondLevelStaleResultIfAvailable()
    {
        return getSecondLevelStaleResultIfAvailable();
    }

    public Map getSecondLevelStaleResultIfAvailable()
    {
        return null;
    }

    public volatile Object getStaleResultIfAvailable()
    {
        return getStaleResultIfAvailable();
    }

    public Map getStaleResultIfAvailable()
    {
        return null;
    }
}
