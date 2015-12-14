// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

// Referenced classes of package com.bumptech.glide.load.engine:
//            EngineJobListener, Resource, EngineResource, EngineRunnable

class EngineJob
    implements EngineRunnable.EngineRunnableManager
{
    static class EngineResourceFactory
    {

        public EngineResource build(Resource resource1, boolean flag)
        {
            return new EngineResource(resource1, flag);
        }

        EngineResourceFactory()
        {
        }
    }

    private static class MainThreadCallback
        implements android.os.Handler.Callback
    {

        public boolean handleMessage(Message message)
        {
            if (1 == message.what || 2 == message.what)
            {
                EngineJob enginejob = (EngineJob)message.obj;
                if (1 == message.what)
                {
                    enginejob.handleResultOnMainThread();
                    return true;
                } else
                {
                    enginejob.handleExceptionOnMainThread();
                    return true;
                }
            } else
            {
                return false;
            }
        }

        private MainThreadCallback()
        {
        }

    }


    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    private final List cbs;
    private final ExecutorService diskCacheService;
    private EngineResource engineResource;
    private final EngineResourceFactory engineResourceFactory;
    private EngineRunnable engineRunnable;
    private Exception exception;
    private volatile Future future;
    private boolean hasException;
    private boolean hasResource;
    private Set ignoredCallbacks;
    private final boolean isCacheable;
    private boolean isCancelled;
    private final Key key;
    private final EngineJobListener listener;
    private Resource resource;
    private final ExecutorService sourceService;

    public EngineJob(Key key1, ExecutorService executorservice, ExecutorService executorservice1, boolean flag, EngineJobListener enginejoblistener)
    {
        this(key1, executorservice, executorservice1, flag, enginejoblistener, DEFAULT_FACTORY);
    }

    public EngineJob(Key key1, ExecutorService executorservice, ExecutorService executorservice1, boolean flag, EngineJobListener enginejoblistener, EngineResourceFactory engineresourcefactory)
    {
        cbs = new ArrayList();
        key = key1;
        diskCacheService = executorservice;
        sourceService = executorservice1;
        isCacheable = flag;
        listener = enginejoblistener;
        engineResourceFactory = engineresourcefactory;
    }

    private void addIgnoredCallback(ResourceCallback resourcecallback)
    {
        if (ignoredCallbacks == null)
        {
            ignoredCallbacks = new HashSet();
        }
        ignoredCallbacks.add(resourcecallback);
    }

    private void handleExceptionOnMainThread()
    {
        if (!isCancelled)
        {
            if (cbs.isEmpty())
            {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            hasException = true;
            listener.onEngineJobComplete(key, null);
            Iterator iterator = cbs.iterator();
            while (iterator.hasNext()) 
            {
                ResourceCallback resourcecallback = (ResourceCallback)iterator.next();
                if (!isInIgnoredCallbacks(resourcecallback))
                {
                    resourcecallback.onException(exception);
                }
            }
        }
    }

    private void handleResultOnMainThread()
    {
        if (isCancelled)
        {
            resource.recycle();
            return;
        }
        if (cbs.isEmpty())
        {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        engineResource = engineResourceFactory.build(resource, isCacheable);
        hasResource = true;
        engineResource.acquire();
        listener.onEngineJobComplete(key, engineResource);
        Iterator iterator = cbs.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ResourceCallback resourcecallback = (ResourceCallback)iterator.next();
            if (!isInIgnoredCallbacks(resourcecallback))
            {
                engineResource.acquire();
                resourcecallback.onResourceReady(engineResource);
            }
        } while (true);
        engineResource.release();
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourcecallback)
    {
        return ignoredCallbacks != null && ignoredCallbacks.contains(resourcecallback);
    }

    public void addCallback(ResourceCallback resourcecallback)
    {
        Util.assertMainThread();
        if (hasResource)
        {
            resourcecallback.onResourceReady(engineResource);
            return;
        }
        if (hasException)
        {
            resourcecallback.onException(exception);
            return;
        } else
        {
            cbs.add(resourcecallback);
            return;
        }
    }

    void cancel()
    {
        if (hasException || hasResource || isCancelled)
        {
            return;
        }
        engineRunnable.cancel();
        Future future1 = future;
        if (future1 != null)
        {
            future1.cancel(true);
        }
        isCancelled = true;
        listener.onEngineJobCancelled(this, key);
    }

    public void onException(Exception exception1)
    {
        exception = exception1;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    public void onResourceReady(Resource resource1)
    {
        resource = resource1;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    public void removeCallback(ResourceCallback resourcecallback)
    {
        Util.assertMainThread();
        if (hasResource || hasException)
        {
            addIgnoredCallback(resourcecallback);
        } else
        {
            cbs.remove(resourcecallback);
            if (cbs.isEmpty())
            {
                cancel();
                return;
            }
        }
    }

    public void start(EngineRunnable enginerunnable)
    {
        engineRunnable = enginerunnable;
        future = diskCacheService.submit(enginerunnable);
    }

    public void submitForSource(EngineRunnable enginerunnable)
    {
        future = sourceService.submit(enginerunnable);
    }



}
