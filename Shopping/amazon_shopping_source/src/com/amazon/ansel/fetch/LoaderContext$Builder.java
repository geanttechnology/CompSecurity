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

    public callbackExecutor setUseWeakResourceListeners(boolean flag)
    {
        useWeakResourceListeners = flag;
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
