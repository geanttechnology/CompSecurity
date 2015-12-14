// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, EncodedMemoryCacheProducer, Consumer

class val.cacheKey extends DelegatingConsumer
{

    final EncodedMemoryCacheProducer this$0;
    final CacheKey val$cacheKey;

    public void onNewResultImpl(EncodedImage encodedimage, boolean flag)
    {
        Object obj;
        if (!flag || encodedimage == null)
        {
            getConsumer().onNewResult(encodedimage, flag);
            return;
        }
        obj = encodedimage.getByteBufferRef();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        CloseableReference closeablereference = EncodedMemoryCacheProducer.access$000(EncodedMemoryCacheProducer.this).cache(val$cacheKey, ((CloseableReference) (obj)));
        CloseableReference.closeSafely(((CloseableReference) (obj)));
        if (closeablereference == null)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        obj = new EncodedImage(closeablereference);
        ((EncodedImage) (obj)).copyMetaDataFrom(encodedimage);
        CloseableReference.closeSafely(closeablereference);
        getConsumer().onProgressUpdate(1.0F);
        getConsumer().onNewResult(obj, true);
        EncodedImage.closeSafely(((EncodedImage) (obj)));
        return;
        encodedimage;
        CloseableReference.closeSafely(((CloseableReference) (obj)));
        throw encodedimage;
        encodedimage;
        CloseableReference.closeSafely(closeablereference);
        throw encodedimage;
        encodedimage;
        EncodedImage.closeSafely(((EncodedImage) (obj)));
        throw encodedimage;
        getConsumer().onNewResult(encodedimage, true);
        return;
    }

    public volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((EncodedImage)obj, flag);
    }

    (CacheKey cachekey)
    {
        this$0 = final_encodedmemorycacheproducer;
        val$cacheKey = cachekey;
        super(Consumer.this);
    }
}
