// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;
import com.google.common.collect.Maps;
import com.xfinity.playerlib.bookmarks.BookmarkId;
import com.xfinity.playerlib.bookmarks.VideoBookmark;
import com.xfinity.playerlib.model.consumable.VideoFacade;
import com.xfinity.playerlib.model.consumable.Watchable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            VideoBookmarkDAO

public class CachingVideoBookmarkDAO
    implements VideoBookmarkDAO
{

    private final Map cache;
    private Object cacheVersion;
    private final VideoBookmarkDAO _flddelegate;
    private final RevalidationPolicy revalidationPolicy;

    public CachingVideoBookmarkDAO(VideoBookmarkDAO videobookmarkdao, RevalidationPolicy revalidationpolicy, int i)
    {
        _flddelegate = videobookmarkdao;
        revalidationPolicy = revalidationpolicy;
        cache = Collections.synchronizedMap(new LruLinkedHashMap(i));
    }

    private void addBookmarkToCache(VideoBookmark videobookmark)
    {
        synchronized (cache)
        {
            clearCacheIfInvalid();
            cache.put(videobookmark.getId(), videobookmark);
        }
        return;
        videobookmark;
        map;
        JVM INSTR monitorexit ;
        throw videobookmark;
    }

    private void clearCacheIfInvalid()
    {
        if (revalidationPolicy.shouldRevalidate(cacheVersion))
        {
            cache.clear();
            cacheVersion = revalidationPolicy.getCurrentVersion();
        }
    }

    public boolean deleteBookmark(VideoBookmark videobookmark)
    {
        cache.remove(videobookmark.getId());
        return _flddelegate.deleteBookmark(videobookmark);
    }

    protected VideoBookmark getCachedBookmarkIfAvailable(VideoFacade videofacade)
    {
        Map map = cache;
        map;
        JVM INSTR monitorenter ;
        if (videofacade.getNetworkInfo() == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        clearCacheIfInvalid();
        videofacade = (VideoBookmark)cache.get(new BookmarkId(videofacade));
        return videofacade;
        map;
        JVM INSTR monitorexit ;
        return null;
        videofacade;
        map;
        JVM INSTR monitorexit ;
        throw videofacade;
    }

    public Map getCachedVideoToBookmarkMapIfAvailable(Set set)
    {
        java.util.HashMap hashmap = Maps.newHashMap();
        Iterator iterator = set.iterator();
        do
        {
            VideoBookmark videobookmark;
label0:
            {
                set = hashmap;
                if (iterator.hasNext())
                {
                    set = (VideoFacade)iterator.next();
                    videobookmark = getCachedBookmarkIfAvailable(set);
                    if (videobookmark != null)
                    {
                        break label0;
                    }
                    set = null;
                }
                return set;
            }
            hashmap.put(set, videobookmark);
        } while (true);
    }

    public VideoBookmark getLastWatchedBookmark()
    {
        VideoBookmark videobookmark = _flddelegate.getLastWatchedBookmark();
        if (videobookmark != null)
        {
            addBookmarkToCache(videobookmark);
        }
        return videobookmark;
    }

    public VideoBookmark getOrCreateBookmarkWithVideo(VideoFacade videofacade, Watchable watchable)
    {
        VideoBookmark videobookmark1 = getCachedBookmarkIfAvailable(videofacade);
        VideoBookmark videobookmark = videobookmark1;
        if (videobookmark1 == null)
        {
            videobookmark = _flddelegate.getOrCreateBookmarkWithVideo(videofacade, watchable);
            addBookmarkToCache(videobookmark);
        }
        return videobookmark;
    }

    public List getRecentBookmarks()
    {
        List list = _flddelegate.getRecentBookmarks();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); addBookmarkToCache((VideoBookmark)iterator.next())) { }
        return list;
    }

    public void saveBookmark(VideoBookmark videobookmark)
    {
        addBookmarkToCache(videobookmark);
        _flddelegate.saveBookmark(videobookmark);
    }

    public void updateLastTrackedMilestones()
    {
        _flddelegate.updateLastTrackedMilestones();
    }
}
