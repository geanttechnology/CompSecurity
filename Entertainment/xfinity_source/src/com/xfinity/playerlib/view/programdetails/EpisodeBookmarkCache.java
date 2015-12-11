// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.task.BaseTask;
import com.google.common.collect.Maps;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EpisodeBookmarkCache extends BaseTask
{

    private final CachingVideoBookmarkDAO bookmarkDAO;
    private final Watchable episode;

    public EpisodeBookmarkCache(CachingVideoBookmarkDAO cachingvideobookmarkdao, Watchable watchable)
    {
        bookmarkDAO = cachingvideobookmarkdao;
        episode = watchable;
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
        java.util.HashMap hashmap = Maps.newHashMap();
        Iterator iterator = episode.getVideos().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoFacade videofacade = (VideoFacade)iterator.next();
            if (videofacade.getNetworkInfo() != null)
            {
                hashmap.put(videofacade, bookmarkDAO.getOrCreateBookmarkWithVideo(videofacade, episode));
            }
        } while (true);
        return hashmap;
    }

    public volatile Object getCachedResultIfAvailable()
    {
        return getCachedResultIfAvailable();
    }

    public Map getCachedResultIfAvailable()
    {
        Set set = episode.getVideos();
        return bookmarkDAO.getCachedVideoToBookmarkMapIfAvailable(set);
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
