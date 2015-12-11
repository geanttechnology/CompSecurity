// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.downloads;

import com.comcast.cim.cmasl.taskexecutor.task.BaseTask;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import com.xfinity.playerlib.model.database.CachingVideoBookmarkDAO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class DownloadedVideosBookmarkCache extends BaseTask
{

    private final CachingVideoBookmarkDAO bookmarkDAO;
    private final Map videos;

    public DownloadedVideosBookmarkCache(CachingVideoBookmarkDAO cachingvideobookmarkdao, Map map)
    {
        bookmarkDAO = cachingvideobookmarkdao;
        videos = map;
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
        HashMap hashmap = new HashMap(videos.size());
        Iterator iterator = videos.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            VideoFacade videofacade = (VideoFacade)iterator.next();
            if (videofacade.getNetworkInfo() != null)
            {
                hashmap.put(videofacade, bookmarkDAO.getOrCreateBookmarkWithVideo(videofacade, (Watchable)videos.get(videofacade)));
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
        return bookmarkDAO.getCachedVideoToBookmarkMapIfAvailable(videos.keySet());
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
