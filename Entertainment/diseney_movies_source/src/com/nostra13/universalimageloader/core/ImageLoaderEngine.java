// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nostra13.universalimageloader.core;

import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiscCacheAware;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.nostra13.universalimageloader.core:
//            ImageLoaderConfiguration, DefaultConfigurationFactory, LoadAndDisplayImageTask, ProcessAndDisplayImageTask

class ImageLoaderEngine
{

    private final Map cacheKeysForImageViews = Collections.synchronizedMap(new HashMap());
    final ImageLoaderConfiguration configuration;
    private final AtomicBoolean networkDenied = new AtomicBoolean(false);
    private final AtomicBoolean paused = new AtomicBoolean(false);
    private final AtomicBoolean slowNetwork = new AtomicBoolean(false);
    private ExecutorService taskDistributor;
    private Executor taskExecutor;
    private Executor taskExecutorForCachedImages;
    private final Map uriLocks = new WeakHashMap();

    ImageLoaderEngine(ImageLoaderConfiguration imageloaderconfiguration)
    {
        configuration = imageloaderconfiguration;
        taskExecutor = imageloaderconfiguration.taskExecutor;
        taskExecutorForCachedImages = imageloaderconfiguration.taskExecutorForCachedImages;
        taskDistributor = Executors.newCachedThreadPool();
    }

    private Executor createTaskExecutor()
    {
        return DefaultConfigurationFactory.createExecutor(configuration.threadPoolSize, configuration.threadPriority, configuration.tasksProcessingType);
    }

    private void initExecutorsIfNeed()
    {
        if (taskExecutor == null)
        {
            taskExecutor = createTaskExecutor();
        }
        if (taskExecutorForCachedImages == null)
        {
            taskExecutorForCachedImages = createTaskExecutor();
        }
    }

    void cancelDisplayTaskFor(ImageView imageview)
    {
        cacheKeysForImageViews.remove(Integer.valueOf(imageview.hashCode()));
    }

    void denyNetworkDownloads(boolean flag)
    {
        networkDenied.set(flag);
    }

    String getLoadingUriForView(ImageView imageview)
    {
        return (String)cacheKeysForImageViews.get(Integer.valueOf(imageview.hashCode()));
    }

    ReentrantLock getLockForUri(String s)
    {
        ReentrantLock reentrantlock1 = (ReentrantLock)uriLocks.get(s);
        ReentrantLock reentrantlock = reentrantlock1;
        if (reentrantlock1 == null)
        {
            reentrantlock = new ReentrantLock();
            uriLocks.put(s, reentrantlock);
        }
        return reentrantlock;
    }

    AtomicBoolean getPause()
    {
        return paused;
    }

    void handleSlowNetwork(boolean flag)
    {
        slowNetwork.set(flag);
    }

    boolean isNetworkDenied()
    {
        return networkDenied.get();
    }

    boolean isSlowNetwork()
    {
        return slowNetwork.get();
    }

    void pause()
    {
        paused.set(true);
    }

    void prepareDisplayTaskFor(ImageView imageview, String s)
    {
        cacheKeysForImageViews.put(Integer.valueOf(imageview.hashCode()), s);
    }

    void resume()
    {
        synchronized (paused)
        {
            paused.set(false);
            paused.notifyAll();
        }
        return;
        exception;
        atomicboolean;
        JVM INSTR monitorexit ;
        throw exception;
    }

    void stop()
    {
        if (!configuration.customExecutor)
        {
            taskExecutor = null;
        }
        if (!configuration.customExecutorForCachedImages)
        {
            taskExecutorForCachedImages = null;
        }
        cacheKeysForImageViews.clear();
        uriLocks.clear();
    }

    void submit(final LoadAndDisplayImageTask task)
    {
        taskDistributor.execute(new Runnable() {

            final ImageLoaderEngine this$0;
            private final LoadAndDisplayImageTask val$task;

            public void run()
            {
                boolean flag = configuration.discCache.get(task.getLoadingUri()).exists();
                initExecutorsIfNeed();
                if (flag)
                {
                    taskExecutorForCachedImages.execute(task);
                    return;
                } else
                {
                    taskExecutor.execute(task);
                    return;
                }
            }

            
            {
                this$0 = ImageLoaderEngine.this;
                task = loadanddisplayimagetask;
                super();
            }
        });
    }

    void submit(ProcessAndDisplayImageTask processanddisplayimagetask)
    {
        initExecutorsIfNeed();
        taskExecutorForCachedImages.execute(processanddisplayimagetask);
    }



}
