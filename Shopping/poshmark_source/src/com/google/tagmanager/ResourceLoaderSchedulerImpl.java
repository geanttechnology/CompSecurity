// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.tagmanager:
//            ResourceLoader, Log, LoadCallback, CtfeHost

class ResourceLoaderSchedulerImpl
    implements Container.ResourceLoaderScheduler
{
    static interface ResourceLoaderFactory
    {

        public abstract ResourceLoader createResourceLoader(CtfeHost ctfehost);
    }

    static interface ScheduledExecutorServiceFactory
    {

        public abstract ScheduledExecutorService createExecutorService();
    }


    private static final boolean MAY_INTERRUPT_IF_RUNNING = true;
    private LoadCallback mCallback;
    private boolean mClosed;
    private final String mContainerId;
    private final Context mContext;
    private CtfeHost mCtfeHost;
    private String mCtfeUrlPathAndQuery;
    private final ScheduledExecutorService mExecutor;
    private ScheduledFuture mFuture;
    private final ResourceLoaderFactory mResourceLoaderFactory;

    public ResourceLoaderSchedulerImpl(Context context, String s, CtfeHost ctfehost)
    {
        this(context, s, ctfehost, null, null);
    }

    ResourceLoaderSchedulerImpl(Context context, String s, CtfeHost ctfehost, ScheduledExecutorServiceFactory scheduledexecutorservicefactory, ResourceLoaderFactory resourceloaderfactory)
    {
        mCtfeHost = ctfehost;
        mContext = context;
        mContainerId = s;
        context = scheduledexecutorservicefactory;
        if (scheduledexecutorservicefactory == null)
        {
            context = new ScheduledExecutorServiceFactory() {

                final ResourceLoaderSchedulerImpl this$0;

                public ScheduledExecutorService createExecutorService()
                {
                    return Executors.newSingleThreadScheduledExecutor();
                }

            
            {
                this$0 = ResourceLoaderSchedulerImpl.this;
                super();
            }
            };
        }
        mExecutor = context.createExecutorService();
        if (resourceloaderfactory == null)
        {
            mResourceLoaderFactory = new ResourceLoaderFactory() {

                final ResourceLoaderSchedulerImpl this$0;

                public ResourceLoader createResourceLoader(CtfeHost ctfehost1)
                {
                    return new ResourceLoader(mContext, mContainerId, ctfehost1);
                }

            
            {
                this$0 = ResourceLoaderSchedulerImpl.this;
                super();
            }
            };
            return;
        } else
        {
            mResourceLoaderFactory = resourceloaderfactory;
            return;
        }
    }

    private ResourceLoader createResourceLoader(String s)
    {
        ResourceLoader resourceloader = mResourceLoaderFactory.createResourceLoader(mCtfeHost);
        resourceloader.setLoadCallback(mCallback);
        resourceloader.setCtfeURLPathAndQuery(mCtfeUrlPathAndQuery);
        resourceloader.setPreviousVersion(s);
        return resourceloader;
    }

    private void ensureNotClosed()
    {
        this;
        JVM INSTR monitorenter ;
        if (mClosed)
        {
            throw new IllegalStateException("called method after closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        this;
        JVM INSTR monitorexit ;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        ensureNotClosed();
        if (mFuture != null)
        {
            mFuture.cancel(false);
        }
        mExecutor.shutdown();
        mClosed = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void loadAfterDelay(long l, String s)
    {
        this;
        JVM INSTR monitorenter ;
        Log.v((new StringBuilder()).append("loadAfterDelay: containerId=").append(mContainerId).append(" delay=").append(l).toString());
        ensureNotClosed();
        if (mCallback == null)
        {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        break MISSING_BLOCK_LABEL_62;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
        if (mFuture != null)
        {
            mFuture.cancel(true);
        }
        mFuture = mExecutor.schedule(createResourceLoader(s), l, TimeUnit.MILLISECONDS);
        this;
        JVM INSTR monitorexit ;
    }

    public void setCtfeURLPathAndQuery(String s)
    {
        this;
        JVM INSTR monitorenter ;
        ensureNotClosed();
        mCtfeUrlPathAndQuery = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public void setLoadCallback(LoadCallback loadcallback)
    {
        this;
        JVM INSTR monitorenter ;
        ensureNotClosed();
        mCallback = loadcallback;
        this;
        JVM INSTR monitorexit ;
        return;
        loadcallback;
        throw loadcallback;
    }


}
