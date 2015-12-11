// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch;

import android.content.Context;
import com.amazon.ansel.fetch.cache.ResourceCacheFactory;
import com.amazon.ansel.fetch.tools.web.WebClientFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

// Referenced classes of package com.amazon.ansel.fetch:
//            LoaderContext, UiThreadExecutor

public static class envContext
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

    public Executor getCallbackExecutor()
    {
        return callbackExecutor;
    }

    public ThreadPoolExecutor getExecutor()
    {
        return executor;
    }

    public int getMaxPrimaryCacheMemSize()
    {
        return maxPrimaryCacheMemSize;
    }

    public ResourceCacheFactory getPrimaryCacheFactory()
    {
        return primaryCacheFactory;
    }

    public BlockingQueue getQueue()
    {
        return queue;
    }

    public boolean getReadCache()
    {
        return readCache;
    }

    public boolean getReadPrimaryCache()
    {
        return readPrimaryCache;
    }

    public boolean getRemovalInvaliates()
    {
        return removalInvalidates;
    }

    public boolean getSendCallbacksToUiThread()
    {
        return sendCallbacksToUiThread;
    }

    public boolean getTrackReferences()
    {
        return trackReferences;
    }

    public boolean getUseCache()
    {
        return useCache;
    }

    public boolean getUsePrimaryCache()
    {
        return usePrimaryCache;
    }

    public boolean getUseWeakResourceListeners()
    {
        return useWeakResourceListeners;
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

    public writePrimaryCache setCallbackExecutor(Executor executor1)
    {
        callbackExecutor = executor1;
        return this;
    }

    public callbackExecutor setExecutor(ThreadPoolExecutor threadpoolexecutor)
    {
        executor = threadpoolexecutor;
        return this;
    }

    public executor setMaxPrimaryCacheMemSize(int i)
    {
        maxPrimaryCacheMemSize = i;
        return this;
    }

    public tory setPrimaryCacheFactory(ResourceCacheFactory resourcecachefactory)
    {
        primaryCacheFactory = resourcecachefactory;
        return this;
    }

    public primaryCacheFactory setQueue(BlockingQueue blockingqueue)
    {
        queue = blockingqueue;
        return this;
    }

    public queue setReadCache(boolean flag)
    {
        readCache = flag;
        return this;
    }

    public readCache setReadPrimaryCache(boolean flag)
    {
        readPrimaryCache = flag;
        return this;
    }

    public readPrimaryCache setRemovalInvalidates(boolean flag)
    {
        removalInvalidates = flag;
        return this;
    }

    public removalInvalidates setSendCallbacksToUiThread(boolean flag)
    {
        sendCallbacksToUiThread = flag;
        return this;
    }

    public sendCallbacksToUiThread setTrackReferences(boolean flag)
    {
        trackReferences = flag;
        return this;
    }

    public trackReferences setUseCache(boolean flag)
    {
        useCache = flag;
        return this;
    }

    public useCache setUsePrimaryCache(boolean flag)
    {
        usePrimaryCache = flag;
        return this;
    }

    public usePrimaryCache setUseWeakResourceListeners(boolean flag)
    {
        useWeakResourceListeners = flag;
        return this;
    }

    public tory setWebClientFactory(WebClientFactory webclientfactory)
    {
        webClientFactory = webclientfactory;
        return this;
    }

    public webClientFactory setWriteCache(boolean flag)
    {
        writeCache = flag;
        return this;
    }

    public writeCache setWritePrimaryCache(boolean flag)
    {
        writePrimaryCache = flag;
        return this;
    }

    public tory(Context context)
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
