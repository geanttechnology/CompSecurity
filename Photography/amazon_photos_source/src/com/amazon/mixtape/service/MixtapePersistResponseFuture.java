// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.service;

import com.amazon.mixtape.account.MetadataStore;
import com.amazon.mixtape.utils.Lazy;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.amazon.mixtape.service:
//            MetadataSyncException

class MixtapePersistResponseFuture
    implements Future
{

    private final Lazy mLazyCloudMetadataStore;
    private final NodeExtractors.NodeExtractor mNodeExtractor;
    private final Future mRequest;
    private final boolean mUpdateMediaParents;

    MixtapePersistResponseFuture(Future future, NodeExtractors.NodeExtractor nodeextractor, Lazy lazy)
    {
        this(future, nodeextractor, lazy, true);
    }

    MixtapePersistResponseFuture(Future future, NodeExtractors.NodeExtractor nodeextractor, Lazy lazy, boolean flag)
    {
        mRequest = future;
        mNodeExtractor = nodeextractor;
        mLazyCloudMetadataStore = lazy;
        mUpdateMediaParents = flag;
    }

    public boolean cancel(boolean flag)
    {
        return mRequest.cancel(flag);
    }

    public Object get()
        throws InterruptedException, ExecutionException
    {
        Object obj = mRequest.get();
        try
        {
            ((MetadataStore)mLazyCloudMetadataStore.get()).saveNodes(mNodeExtractor.getNodes(obj), mUpdateMediaParents);
        }
        catch (MetadataSyncException metadatasyncexception)
        {
            throw new ExecutionException(metadatasyncexception);
        }
        return obj;
    }

    public Object get(long l, TimeUnit timeunit)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        timeunit = ((TimeUnit) (mRequest.get(l, timeunit)));
        try
        {
            ((MetadataStore)mLazyCloudMetadataStore.get()).saveNodes(mNodeExtractor.getNodes(timeunit), mUpdateMediaParents);
        }
        // Misplaced declaration of an exception variable
        catch (TimeUnit timeunit)
        {
            throw new ExecutionException(timeunit);
        }
        return timeunit;
    }

    public boolean isCancelled()
    {
        return mRequest.isCancelled();
    }

    public boolean isDone()
    {
        return mRequest.isDone();
    }
}
