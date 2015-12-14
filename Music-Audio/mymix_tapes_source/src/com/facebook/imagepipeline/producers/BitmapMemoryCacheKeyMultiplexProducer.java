// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import java.io.Closeable;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            MultiplexProducer, ProducerContext, Producer

public class BitmapMemoryCacheKeyMultiplexProducer extends MultiplexProducer
{

    private final CacheKeyFactory mCacheKeyFactory;

    public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory cachekeyfactory, Producer producer)
    {
        super(producer);
        mCacheKeyFactory = cachekeyfactory;
    }

    public CloseableReference cloneOrNull(CloseableReference closeablereference)
    {
        return CloseableReference.cloneOrNull(closeablereference);
    }

    public volatile Closeable cloneOrNull(Closeable closeable)
    {
        return cloneOrNull((CloseableReference)closeable);
    }

    protected Pair getKey(ProducerContext producercontext)
    {
        return Pair.create(mCacheKeyFactory.getBitmapCacheKey(producercontext.getImageRequest()), producercontext.getLowestPermittedRequestLevel());
    }

    protected volatile Object getKey(ProducerContext producercontext)
    {
        return getKey(producercontext);
    }
}
