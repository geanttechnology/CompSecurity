// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.bumptech.glide.load.engine:
//            EngineJobListener, EngineKeyFactory, ResourceRecycler, EngineResource, 
//            EngineJob, EngineRunnable, DecodeJob, DiskCacheStrategy, 
//            Resource

public class Engine
    implements EngineJobListener, EngineResource.ResourceListener, com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener
{
    static class EngineJobFactory
    {

        private final ExecutorService diskCacheService;
        private final EngineJobListener listener;
        private final ExecutorService sourceService;

        public EngineJob build(Key key, boolean flag)
        {
            return new EngineJob(key, diskCacheService, sourceService, flag, listener);
        }

        public EngineJobFactory(ExecutorService executorservice, ExecutorService executorservice1, EngineJobListener enginejoblistener)
        {
            diskCacheService = executorservice;
            sourceService = executorservice1;
            listener = enginejoblistener;
        }
    }

    private static class LazyDiskCacheProvider
        implements DecodeJob.DiskCacheProvider
    {

        private volatile DiskCache diskCache;
        private final com.bumptech.glide.load.engine.cache.DiskCache.Factory factory;

        public DiskCache getDiskCache()
        {
            if (diskCache != null) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorenter ;
            if (diskCache == null)
            {
                diskCache = factory.build();
            }
            this;
            JVM INSTR monitorexit ;
_L2:
            return diskCache;
            Exception exception;
            exception;
            this;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public LazyDiskCacheProvider(com.bumptech.glide.load.engine.cache.DiskCache.Factory factory1)
        {
            factory = factory1;
        }
    }

    public static class LoadStatus
    {

        private final ResourceCallback cb;
        private final EngineJob engineJob;

        public void cancel()
        {
            engineJob.removeCallback(cb);
        }

        public LoadStatus(ResourceCallback resourcecallback, EngineJob enginejob)
        {
            cb = resourcecallback;
            engineJob = enginejob;
        }
    }

    private static class RefQueueIdleHandler
        implements android.os.MessageQueue.IdleHandler
    {

        private final Map activeResources;
        private final ReferenceQueue queue;

        public boolean queueIdle()
        {
            ResourceWeakReference resourceweakreference = (ResourceWeakReference)queue.poll();
            if (resourceweakreference != null)
            {
                activeResources.remove(resourceweakreference.key);
            }
            return true;
        }

        public RefQueueIdleHandler(Map map, ReferenceQueue referencequeue)
        {
            activeResources = map;
            queue = referencequeue;
        }
    }

    private static class ResourceWeakReference extends WeakReference
    {

        private final Key key;


        public ResourceWeakReference(Key key1, EngineResource engineresource, ReferenceQueue referencequeue)
        {
            super(engineresource, referencequeue);
            key = key1;
        }
    }


    private final Map activeResources;
    private final MemoryCache cache;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Map jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;
    private ReferenceQueue resourceReferenceQueue;

    public Engine(MemoryCache memorycache, com.bumptech.glide.load.engine.cache.DiskCache.Factory factory, ExecutorService executorservice, ExecutorService executorservice1)
    {
        this(memorycache, factory, executorservice, executorservice1, null, null, null, null, null);
    }

    Engine(MemoryCache memorycache, com.bumptech.glide.load.engine.cache.DiskCache.Factory factory, ExecutorService executorservice, ExecutorService executorservice1, Map map, EngineKeyFactory enginekeyfactory, Map map1, 
            EngineJobFactory enginejobfactory, ResourceRecycler resourcerecycler)
    {
        cache = memorycache;
        diskCacheProvider = new LazyDiskCacheProvider(factory);
        factory = map1;
        if (map1 == null)
        {
            factory = new HashMap();
        }
        activeResources = factory;
        factory = enginekeyfactory;
        if (enginekeyfactory == null)
        {
            factory = new EngineKeyFactory();
        }
        keyFactory = factory;
        factory = map;
        if (map == null)
        {
            factory = new HashMap();
        }
        jobs = factory;
        factory = enginejobfactory;
        if (enginejobfactory == null)
        {
            factory = new EngineJobFactory(executorservice, executorservice1, this);
        }
        engineJobFactory = factory;
        factory = resourcerecycler;
        if (resourcerecycler == null)
        {
            factory = new ResourceRecycler();
        }
        resourceRecycler = factory;
        memorycache.setResourceRemovedListener(this);
    }

    private EngineResource getEngineResourceFromCache(Key key)
    {
        key = cache.remove(key);
        if (key == null)
        {
            return null;
        }
        if (key instanceof EngineResource)
        {
            return (EngineResource)key;
        } else
        {
            return new EngineResource(key, true);
        }
    }

    private ReferenceQueue getReferenceQueue()
    {
        if (resourceReferenceQueue == null)
        {
            resourceReferenceQueue = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new RefQueueIdleHandler(activeResources, resourceReferenceQueue));
        }
        return resourceReferenceQueue;
    }

    private EngineResource loadFromActiveResources(Key key, boolean flag)
    {
        Object obj;
        if (flag)
        {
            if ((obj = (WeakReference)activeResources.get(key)) != null)
            {
                obj = (EngineResource)((WeakReference) (obj)).get();
                if (obj != null)
                {
                    ((EngineResource) (obj)).acquire();
                    return ((EngineResource) (obj));
                } else
                {
                    activeResources.remove(key);
                    return ((EngineResource) (obj));
                }
            }
        }
        return null;
    }

    private EngineResource loadFromCache(Key key, boolean flag)
    {
        EngineResource engineresource;
        if (!flag)
        {
            engineresource = null;
        } else
        {
            EngineResource engineresource1 = getEngineResourceFromCache(key);
            engineresource = engineresource1;
            if (engineresource1 != null)
            {
                engineresource1.acquire();
                activeResources.put(key, new ResourceWeakReference(key, engineresource1, getReferenceQueue()));
                return engineresource1;
            }
        }
        return engineresource;
    }

    private static void logWithTimeAndKey(String s, long l, Key key)
    {
        Log.v("Engine", (new StringBuilder()).append(s).append(" in ").append(LogTime.getElapsedMillis(l)).append("ms, key: ").append(key).toString());
    }

    public LoadStatus load(Key key, int i, int j, DataFetcher datafetcher, DataLoadProvider dataloadprovider, Transformation transformation, ResourceTranscoder resourcetranscoder, 
            Priority priority, boolean flag, DiskCacheStrategy diskcachestrategy, ResourceCallback resourcecallback)
    {
        Util.assertMainThread();
        long l = LogTime.getLogTime();
        Object obj = datafetcher.getId();
        key = keyFactory.buildKey(((String) (obj)), key, i, j, dataloadprovider.getCacheDecoder(), dataloadprovider.getSourceDecoder(), transformation, dataloadprovider.getEncoder(), resourcetranscoder, dataloadprovider.getSourceEncoder());
        obj = loadFromCache(key, flag);
        if (obj != null)
        {
            resourcecallback.onResourceReady(((Resource) (obj)));
            if (Log.isLoggable("Engine", 2))
            {
                logWithTimeAndKey("Loaded resource from cache", l, key);
            }
            return null;
        }
        obj = loadFromActiveResources(key, flag);
        if (obj != null)
        {
            resourcecallback.onResourceReady(((Resource) (obj)));
            if (Log.isLoggable("Engine", 2))
            {
                logWithTimeAndKey("Loaded resource from active resources", l, key);
            }
            return null;
        }
        obj = (EngineJob)jobs.get(key);
        if (obj != null)
        {
            ((EngineJob) (obj)).addCallback(resourcecallback);
            if (Log.isLoggable("Engine", 2))
            {
                logWithTimeAndKey("Added to existing load", l, key);
            }
            return new LoadStatus(resourcecallback, ((EngineJob) (obj)));
        }
        obj = engineJobFactory.build(key, flag);
        datafetcher = new EngineRunnable(((EngineRunnable.EngineRunnableManager) (obj)), new DecodeJob(key, i, j, datafetcher, dataloadprovider, transformation, resourcetranscoder, diskCacheProvider, diskcachestrategy, priority), priority);
        jobs.put(key, obj);
        ((EngineJob) (obj)).addCallback(resourcecallback);
        ((EngineJob) (obj)).start(datafetcher);
        if (Log.isLoggable("Engine", 2))
        {
            logWithTimeAndKey("Started new load", l, key);
        }
        return new LoadStatus(resourcecallback, ((EngineJob) (obj)));
    }

    public void onEngineJobCancelled(EngineJob enginejob, Key key)
    {
        Util.assertMainThread();
        if (enginejob.equals((EngineJob)jobs.get(key)))
        {
            jobs.remove(key);
        }
    }

    public void onEngineJobComplete(Key key, EngineResource engineresource)
    {
        Util.assertMainThread();
        if (engineresource != null)
        {
            engineresource.setResourceListener(key, this);
            if (engineresource.isCacheable())
            {
                activeResources.put(key, new ResourceWeakReference(key, engineresource, getReferenceQueue()));
            }
        }
        jobs.remove(key);
    }

    public void onResourceReleased(Key key, EngineResource engineresource)
    {
        Util.assertMainThread();
        activeResources.remove(key);
        if (engineresource.isCacheable())
        {
            cache.put(key, engineresource);
            return;
        } else
        {
            resourceRecycler.recycle(engineresource);
            return;
        }
    }

    public void onResourceRemoved(Resource resource)
    {
        Util.assertMainThread();
        resourceRecycler.recycle(resource);
    }

    public void release(Resource resource)
    {
        Util.assertMainThread();
        if (resource instanceof EngineResource)
        {
            ((EngineResource)resource).release();
            return;
        } else
        {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
    }
}
