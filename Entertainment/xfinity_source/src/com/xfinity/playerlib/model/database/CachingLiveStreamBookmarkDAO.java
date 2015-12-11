// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.database;

import com.comcast.cim.cmasl.taskexecutor.policy.RevalidationPolicy;
import com.comcast.cim.cmasl.utils.collections.LruLinkedHashMap;
import com.xfinity.playerlib.bookmarks.LiveStreamBookmark;
import com.xfinity.playerlib.model.consumable.hal.HalLiveStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.xfinity.playerlib.model.database:
//            LiveStreamBookmarkDAO

public class CachingLiveStreamBookmarkDAO
    implements LiveStreamBookmarkDAO
{

    private final Map cache;
    private Object cacheVersion;
    private final LiveStreamBookmarkDAO _flddelegate;
    private final RevalidationPolicy revalidationPolicy;

    public CachingLiveStreamBookmarkDAO(LiveStreamBookmarkDAO livestreambookmarkdao, RevalidationPolicy revalidationpolicy, int i)
    {
        _flddelegate = livestreambookmarkdao;
        revalidationPolicy = revalidationpolicy;
        cache = Collections.synchronizedMap(new LruLinkedHashMap(i));
    }

    private void addBookmarkToCache(LiveStreamBookmark livestreambookmark)
    {
        synchronized (cache)
        {
            if (!validateCache())
            {
                cache.put(livestreambookmark.getStreamId(), livestreambookmark);
            }
        }
        return;
        livestreambookmark;
        map;
        JVM INSTR monitorexit ;
        throw livestreambookmark;
    }

    private void deleteCachedFavorite(String s)
    {
        Map map = cache;
        map;
        JVM INSTR monitorenter ;
        LiveStreamBookmark livestreambookmark;
        if (validateCache())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        livestreambookmark = (LiveStreamBookmark)cache.get(s);
        if (livestreambookmark == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        if (livestreambookmark.getTimestamp() != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        cache.remove(s);
_L2:
        map;
        JVM INSTR monitorexit ;
        return;
        livestreambookmark.setIsFavorite(false);
        if (true) goto _L2; else goto _L1
_L1:
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    private void deleteCachedHistoryItem(String s)
    {
        Map map = cache;
        map;
        JVM INSTR monitorenter ;
        if (!validateCache())
        {
            s = (LiveStreamBookmark)cache.get(s);
            if (!s.isFavorite())
            {
                break MISSING_BLOCK_LABEL_53;
            }
            cache.put(s.getStreamId(), s);
        }
_L2:
        return;
        cache.remove(s.getStreamId());
        if (true) goto _L2; else goto _L1
_L1:
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    private boolean validateCache()
    {
        boolean flag = false;
        if (revalidationPolicy.shouldRevalidate(cacheVersion))
        {
            cache.clear();
            cacheVersion = revalidationPolicy.getCurrentVersion();
        }
        if (cache.isEmpty())
        {
            cache.putAll(_flddelegate.getBookmarks());
            flag = true;
        }
        return flag;
    }

    public LiveStreamBookmark addFavorite(HalLiveStream hallivestream)
    {
        hallivestream = _flddelegate.addFavorite(hallivestream);
        if (hallivestream != null)
        {
            addBookmarkToCache(hallivestream);
        }
        return hallivestream;
    }

    public boolean deleteFavorite(String s)
    {
        boolean flag = _flddelegate.deleteFavorite(s);
        if (flag)
        {
            deleteCachedFavorite(s);
        }
        return flag;
    }

    public Map getBookmarks()
    {
        return _flddelegate.getBookmarks();
    }

    protected LiveStreamBookmark getCachedBookmark(String s)
    {
        synchronized (cache)
        {
            validateCache();
            s = (LiveStreamBookmark)cache.get(s);
        }
        return s;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public List getFavorites()
    {
        Object obj = new ArrayList();
        Map map = cache;
        map;
        JVM INSTR monitorenter ;
        validateCache();
        Iterator iterator = cache.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LiveStreamBookmark livestreambookmark = (LiveStreamBookmark)iterator.next();
            if (livestreambookmark.isFavorite())
            {
                ((List) (obj)).add(livestreambookmark);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_80;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        map;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public LiveStreamBookmark getLastWatchedBookmark()
    {
        LiveStreamBookmark livestreambookmark = _flddelegate.getLastWatchedBookmark();
        if (livestreambookmark != null)
        {
            addBookmarkToCache(livestreambookmark);
        }
        return livestreambookmark;
    }

    public LiveStreamBookmark getOrCreateBookmarkWithLiveStream(HalLiveStream hallivestream, boolean flag)
    {
        LiveStreamBookmark livestreambookmark = getCachedBookmark(hallivestream.getStreamId());
        if (livestreambookmark == null)
        {
            livestreambookmark = _flddelegate.getOrCreateBookmarkWithLiveStream(hallivestream, flag);
            hallivestream = livestreambookmark;
            if (livestreambookmark != null)
            {
                addBookmarkToCache(livestreambookmark);
                hallivestream = livestreambookmark;
            }
        } else
        {
            hallivestream = livestreambookmark;
            if (flag)
            {
                livestreambookmark.setTimestamp(new Date());
                return livestreambookmark;
            }
        }
        return hallivestream;
    }

    public List getRecentBookmarks()
    {
        Object obj = new ArrayList();
        Map map = cache;
        map;
        JVM INSTR monitorenter ;
        validateCache();
        Iterator iterator = cache.values().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            LiveStreamBookmark livestreambookmark = (LiveStreamBookmark)iterator.next();
            if (livestreambookmark.getTimestamp() != null)
            {
                ((List) (obj)).add(livestreambookmark);
            }
        } while (true);
        break MISSING_BLOCK_LABEL_80;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        map;
        JVM INSTR monitorexit ;
        return ((List) (obj));
    }

    public boolean removeHistoryItem(LiveStreamBookmark livestreambookmark)
    {
        boolean flag = _flddelegate.removeHistoryItem(livestreambookmark);
        if (flag)
        {
            deleteCachedHistoryItem(livestreambookmark.getStreamId());
        }
        return flag;
    }

    public boolean saveBookmark(LiveStreamBookmark livestreambookmark, boolean flag)
    {
        flag = _flddelegate.saveBookmark(livestreambookmark, flag);
        addBookmarkToCache(livestreambookmark);
        return flag;
    }
}
