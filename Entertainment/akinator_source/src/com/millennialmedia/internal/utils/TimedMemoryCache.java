// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.utils;

import android.util.SparseArray;
import com.millennialmedia.MMLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.millennialmedia.internal.utils:
//            ThreadUtils

public class TimedMemoryCache
{

    private static final long CACHE_TIMEOUT = 60000L;
    private static final long CLEANER_DELAY = 10000L;
    private static final String TAG = com/millennialmedia/internal/utils/TimedMemoryCache.getSimpleName();
    private static SparseArray cache = new SparseArray();
    private static AtomicBoolean cleanerRunning = new AtomicBoolean();
    private static AtomicInteger lastCacheId = new AtomicInteger(0);

    public TimedMemoryCache()
    {
    }

    public static int add(Object obj, Long long1)
    {
        if (obj == null)
        {
            MMLog.e(TAG, "Nothing to cache, object provided is null");
            return 0;
        }
        int i = lastCacheId.incrementAndGet();
    /* block-local class not found */
    class CacheItem {}

        obj = new CacheItem(obj, long1);
        if (MMLog.isDebugEnabled())
        {
            MMLog.d(TAG, (new StringBuilder()).append("CacheItem added.\n\t").append(obj).toString());
        }
        cache.put(i, obj);
        startCleaner();
        return i;
    }

    public static Object get(int i)
    {
        CacheItem cacheitem = getCachedItem(i);
        if (cacheitem == null)
        {
            MMLog.e(TAG, (new StringBuilder()).append("Cached item for cache ID <").append(i).append("> is null").toString());
            return null;
        } else
        {
            cache.remove(i);
            return cacheitem.cachedObject;
        }
    }

    private static CacheItem getCachedItem(int i)
    {
        CacheItem cacheitem1 = (CacheItem)cache.get(i);
        CacheItem cacheitem = cacheitem1;
        if (cacheitem1 == null)
        {
            MMLog.e(TAG, (new StringBuilder()).append("unable to get cached object for cache id <").append(i).append(">, stored object is null ").append("and will be removed from cache").toString());
            cache.remove(i);
            cacheitem = null;
        }
        return cacheitem;
    }

    private static void startCleaner()
    {
        if (!cleanerRunning.compareAndSet(false, true))
        {
            if (MMLog.isDebugEnabled())
            {
                MMLog.d(TAG, "Cleaner already running");
            }
            return;
        } else
        {
            ThreadUtils.runOnWorkerThread(new _cls1());
            return;
        }
    }






    /* member class not found */
    class _cls1 {}

}
