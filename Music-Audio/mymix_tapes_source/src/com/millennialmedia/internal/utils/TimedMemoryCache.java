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
    private static class CacheItem
    {

        Object cachedObject;
        long itemTimeout;

        public String toString()
        {
            return (new StringBuilder()).append("cachedObject: ").append(cachedObject).append(", itemTimeout: ").append(itemTimeout).toString();
        }

        CacheItem(Object obj, Long long1)
        {
            Long long2 = long1;
            if (long1 == null)
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(TimedMemoryCache.TAG, "Cached item timeout is null, setting to default: 60000");
                }
                long2 = Long.valueOf(60000L);
            }
            cachedObject = obj;
            itemTimeout = System.currentTimeMillis() + long2.longValue();
        }
    }


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
            ThreadUtils.runOnWorkerThread(new Runnable() {

                public void run()
                {
_L3:
                    Thread.sleep(10000L);
                    long l = System.currentTimeMillis();
                    int i = 0;
                    while (i < TimedMemoryCache.cache.size()) 
                    {
                        int j = TimedMemoryCache.cache.keyAt(i);
                        Object obj = TimedMemoryCache.getCachedItem(j);
                        if (obj == null)
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(TimedMemoryCache.TAG, (new StringBuilder()).append("Attempted to remove CacheItem with ID <").append(j).append("> but item was null").toString());
                            }
                        } else
                        if (l > ((CacheItem) (obj)).itemTimeout)
                        {
                            if (MMLog.isDebugEnabled())
                            {
                                MMLog.d(TimedMemoryCache.TAG, (new StringBuilder()).append("Removed CacheItem\n\t:Checked time: ").append(l).append("\n\tID: ").append(j).append("\n\tItem: ").append(obj).toString());
                            }
                            TimedMemoryCache.cache.remove(j);
                        }
                        i++;
                    }
                      goto _L1
                    obj;
                    MMLog.e(TimedMemoryCache.TAG, "Error occurred while cleaner was sleeping", ((Throwable) (obj)));
_L2:
                    if (MMLog.isDebugEnabled())
                    {
                        MMLog.d(TimedMemoryCache.TAG, "Stopping cleaner");
                    }
                    TimedMemoryCache.cleanerRunning.set(false);
                    return;
_L1:
                    if (TimedMemoryCache.cache.size() > 0) goto _L3; else goto _L2
                }

            });
            return;
        }
    }





}
