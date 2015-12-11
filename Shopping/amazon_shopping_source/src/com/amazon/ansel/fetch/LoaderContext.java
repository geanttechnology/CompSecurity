// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.amazon.ansel.fetch.cache.MemoryLimitedLruCache;
import com.amazon.ansel.fetch.cache.ResourceCache;
import com.amazon.ansel.fetch.cache.ResourceCacheFactory;
import com.amazon.ansel.fetch.cache.ResourceCacheListener;
import com.amazon.ansel.fetch.cache.ResourceCacheValue;
import com.amazon.ansel.fetch.tools.ref.ObjectReference;
import com.amazon.ansel.fetch.tools.ref.StrongObjectReference;
import com.amazon.ansel.fetch.tools.ref.WeakObjectReference;
import com.amazon.ansel.fetch.tools.web.WebClientFactory;
import com.amazon.ansel.fetch.tools.web.apache.apache40.DefaultApacheWebClientFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderListener, ResourceListener, UiThreadExecutor, Prioritized

public class LoaderContext
{
    public static class Builder
    {

        private Executor callbackExecutor;
        private Context envContext;
        private ThreadPoolExecutor executor;
        private int maxPrimaryCacheMemSize;
        private ResourceCacheFactory primaryCacheFactory;
        private BlockingQueue queue;
        private boolean readCache;
        private boolean readPrimaryCache;
        private boolean removalInvalidates;
        private boolean sendCallbacksToUiThread;
        private boolean trackReferences;
        private boolean useCache;
        private boolean usePrimaryCache;
        private boolean useWeakResourceListeners;
        private WebClientFactory webClientFactory;
        private boolean writeCache;
        private boolean writePrimaryCache;

        public LoaderContext build()
        {
            if (removalInvalidates)
            {
                trackReferences = true;
            }
            if (primaryCacheFactory == null)
            {
                if (maxPrimaryCacheMemSize == -1)
                {
                    maxPrimaryCacheMemSize = LoaderContext.getDefaultPrimaryCacheMemSize(envContext);
                }
                primaryCacheFactory = LoaderContext.createDefaultPrimaryCacheFactory(maxPrimaryCacheMemSize);
            }
            if (executor == null)
            {
                executor = LoaderContext.createDefaultExecutor(queue);
            }
            if (webClientFactory == null)
            {
                webClientFactory = LoaderContext.createDefaultWebClientFactory();
            }
            if (callbackExecutor == null && sendCallbacksToUiThread)
            {
                callbackExecutor = UiThreadExecutor.getInstance();
            }
            return new LoaderContext(useWeakResourceListeners, useCache, readCache, writeCache, usePrimaryCache, readPrimaryCache, writePrimaryCache, removalInvalidates, trackReferences, primaryCacheFactory, executor, webClientFactory, callbackExecutor);
        }

        public Builder setUseWeakResourceListeners(boolean flag)
        {
            useWeakResourceListeners = flag;
            return this;
        }

        public Builder(Context context)
        {
            useWeakResourceListeners = false;
            useCache = true;
            readCache = true;
            writeCache = true;
            usePrimaryCache = true;
            readPrimaryCache = true;
            writePrimaryCache = true;
            removalInvalidates = false;
            trackReferences = false;
            maxPrimaryCacheMemSize = -1;
            sendCallbacksToUiThread = true;
            envContext = context;
        }
    }


    private static final Comparator PRIORITY_COMPARATOR = new Comparator() {

        public int compare(Object obj, Object obj1)
        {
            long l;
            long l1;
            if (obj instanceof Prioritized)
            {
                l = ((Prioritized)obj).getPriority();
            } else
            {
                l = 0L;
            }
            if (obj1 instanceof Prioritized)
            {
                l1 = ((Prioritized)obj1).getPriority();
            } else
            {
                l1 = 0L;
            }
            if (l < l1)
            {
                return 1;
            }
            return l != l1 ? -1 : 0;
        }

    };
    private final Executor callbackExecutor;
    private final ThreadPoolExecutor executor;
    private final ResourceCache primaryCache;
    private final boolean readCache;
    private final boolean readPrimaryCache;
    private final Map references = Collections.synchronizedMap(new IdentityHashMap(8));
    private final boolean removalInvalidates;
    private final Map tasks = new ConcurrentHashMap(8);
    private final boolean trackReferences;
    private final boolean useCache;
    private final boolean usePrimaryCache;
    private final boolean useWeakResourceListeners;
    private final WebClientFactory webClientFactory;
    private final boolean writeCache;
    private final boolean writePrimaryCache;

    public LoaderContext(boolean flag, boolean flag1, boolean flag2, boolean flag3, boolean flag4, boolean flag5, boolean flag6, 
            boolean flag7, boolean flag8, ResourceCacheFactory resourcecachefactory, ThreadPoolExecutor threadpoolexecutor, WebClientFactory webclientfactory, Executor executor1)
    {
        useWeakResourceListeners = flag;
        useCache = flag1;
        readCache = flag2;
        writeCache = flag3;
        usePrimaryCache = flag4;
        readPrimaryCache = flag5;
        writePrimaryCache = flag6;
        removalInvalidates = flag7;
        trackReferences = flag8;
        primaryCache = resourcecachefactory.getCache(createPrimaryCacheListener());
        executor = threadpoolexecutor;
        webClientFactory = webclientfactory;
        callbackExecutor = executor1;
    }

    public static ThreadPoolExecutor createDefaultExecutor(BlockingQueue blockingqueue)
    {
        BlockingQueue blockingqueue1 = blockingqueue;
        if (blockingqueue == null)
        {
            blockingqueue1 = createDefaultQueue();
        }
        blockingqueue = new ThreadPoolExecutor(10, 10, 60000L, TimeUnit.MILLISECONDS, blockingqueue1);
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            blockingqueue.allowCoreThreadTimeOut(true);
        }
        return blockingqueue;
    }

    public static ResourceCacheFactory createDefaultPrimaryCacheFactory(int i)
    {
        return new ResourceCacheFactory(i) {

            final int val$maxBytes;

            public ResourceCache getCache(ResourceCacheListener resourcecachelistener)
            {
                return new MemoryLimitedLruCache(maxBytes, resourcecachelistener);
            }

            
            {
                maxBytes = i;
                super();
            }
        };
    }

    public static BlockingQueue createDefaultQueue()
    {
        return new PriorityBlockingQueue(10, PRIORITY_COMPARATOR);
    }

    public static WebClientFactory createDefaultWebClientFactory()
    {
        return new DefaultApacheWebClientFactory();
    }

    private ResourceCacheListener createPrimaryCacheListener()
    {
        return new ResourceCacheListener() {

            final LoaderContext this$0;

            public void evict(Object obj, ResourceCacheValue resourcecachevalue)
            {
                if (removalInvalidates)
                {
                    invalidateResource(obj);
                }
            }

            public volatile void evict(Object obj, Object obj1)
            {
                evict(obj, (ResourceCacheValue)obj1);
            }

            
            {
                this$0 = LoaderContext.this;
                super();
            }
        };
    }

    public static int getDefaultPrimaryCacheMemSize(Context context)
    {
        ActivityManager activitymanager = (ActivityManager)context.getSystemService("activity");
        int j = (activitymanager.getMemoryClass() * 1024 * 1024) / 10;
        int i = j;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            boolean flag;
            if ((context.getApplicationInfo().flags & 0x100000) != 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            i = j;
            if (flag)
            {
                i = Math.max(j, (activitymanager.getLargeMemoryClass() * 1024 * 1024) / 20);
            }
        }
        return Math.max(0x100000, Math.min(i, 0x3000000));
    }

    public void addReference(Object obj, ObjectReference objectreference)
    {
        if (!trackReferences || obj == null || objectreference == null)
        {
            return;
        }
        Map map = references;
        map;
        JVM INSTR monitorenter ;
        List list1 = (List)references.get(obj);
        List list;
        list = list1;
        if (list1 != null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        list = Collections.synchronizedList(new ArrayList(1));
        references.put(obj, list);
        list.add(objectreference);
        map;
        JVM INSTR monitorexit ;
        return;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
    }

    public void executeCallback(Runnable runnable)
    {
        if (callbackExecutor == null)
        {
            runnable.run();
            return;
        } else
        {
            callbackExecutor.execute(runnable);
            return;
        }
    }

    public ThreadPoolExecutor getExecutor()
    {
        return executor;
    }

    public ResourceCache getPrimaryCache()
    {
        return primaryCache;
    }

    public boolean getReadCache()
    {
        return readCache;
    }

    public boolean getReadPrimaryCache()
    {
        return readPrimaryCache;
    }

    public Map getTasks()
    {
        return tasks;
    }

    public boolean getUseCache()
    {
        return useCache;
    }

    public boolean getUsePrimaryCache()
    {
        return usePrimaryCache;
    }

    public WebClientFactory getWebClientFactory()
    {
        return webClientFactory;
    }

    public boolean getWriteCache()
    {
        return writeCache;
    }

    public boolean getWritePrimaryCache()
    {
        return writePrimaryCache;
    }

    public void invalidateResource(Object obj)
    {
        if (trackReferences && obj != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        ArrayList arraylist = null;
        Map map = references;
        map;
        JVM INSTR monitorenter ;
        List list = (List)references.get(obj);
        if (list == null) goto _L4; else goto _L3
_L3:
        list;
        JVM INSTR monitorenter ;
        arraylist = new ArrayList(list);
        list;
        JVM INSTR monitorexit ;
_L4:
        references.remove(obj);
        map;
        JVM INSTR monitorexit ;
        if (arraylist != null)
        {
            obj = arraylist.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                LoaderListener loaderlistener = (LoaderListener)((ObjectReference)((Iterator) (obj)).next()).get();
                if (loaderlistener != null)
                {
                    loaderlistener.invalidate();
                }
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
        obj;
_L7:
        list;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        map;
        JVM INSTR monitorexit ;
        throw obj;
        obj;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public ObjectReference newResourceListenerReference(ResourceListener resourcelistener)
    {
        if (useWeakResourceListeners)
        {
            return new WeakObjectReference(resourcelistener);
        } else
        {
            return new StrongObjectReference(resourcelistener);
        }
    }


}
