// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import java.io.Closeable;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            MultiplexProducer, ProducerContext, Producer

public class EncodedCacheKeyMultiplexProducer extends MultiplexProducer
{

    private final CacheKeyFactory mCacheKeyFactory;

    public EncodedCacheKeyMultiplexProducer(CacheKeyFactory cachekeyfactory, Producer producer)
    {
        super(producer);
        mCacheKeyFactory = cachekeyfactory;
    }

    public EncodedImage cloneOrNull(EncodedImage encodedimage)
    {
        return EncodedImage.cloneOrNull(encodedimage);
    }

    public volatile Closeable cloneOrNull(Closeable closeable)
    {
        return cloneOrNull((EncodedImage)closeable);
    }

    protected Pair getKey(ProducerContext producercontext)
    {
        return Pair.create(mCacheKeyFactory.getEncodedCacheKey(producercontext.getImageRequest()), producercontext.getLowestPermittedRequestLevel());
    }

    protected volatile Object getKey(ProducerContext producercontext)
    {
        return getKey(producercontext);
    }
}
