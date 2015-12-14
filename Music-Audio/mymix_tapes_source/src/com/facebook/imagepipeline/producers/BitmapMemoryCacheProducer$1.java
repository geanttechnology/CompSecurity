// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, BitmapMemoryCacheProducer, Consumer

class val.cacheKey extends DelegatingConsumer
{

    final BitmapMemoryCacheProducer this$0;
    final CacheKey val$cacheKey;

    public void onNewResultImpl(CloseableReference closeablereference, boolean flag)
    {
        CloseableReference closeablereference1;
        if (closeablereference == null)
        {
            if (flag)
            {
                getConsumer().onNewResult(null, true);
            }
            return;
        }
        if (((CloseableImage)closeablereference.get()).isStateful())
        {
            getConsumer().onNewResult(closeablereference, flag);
            return;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        closeablereference1 = BitmapMemoryCacheProducer.access$000(BitmapMemoryCacheProducer.this).get(val$cacheKey);
        if (closeablereference1 == null)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        QualityInfo qualityinfo = ((CloseableImage)closeablereference.get()).getQualityInfo();
        QualityInfo qualityinfo1 = ((CloseableImage)closeablereference1.get()).getQualityInfo();
        if (!qualityinfo1.isOfFullQuality() && qualityinfo1.getQuality() < qualityinfo.getQuality())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        getConsumer().onNewResult(closeablereference1, false);
        CloseableReference.closeSafely(closeablereference1);
        return;
        CloseableReference.closeSafely(closeablereference1);
        closeablereference1 = BitmapMemoryCacheProducer.access$000(BitmapMemoryCacheProducer.this).cache(val$cacheKey, closeablereference);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        getConsumer().onProgressUpdate(1.0F);
        Consumer consumer = getConsumer();
        if (closeablereference1 != null)
        {
            closeablereference = closeablereference1;
        }
        consumer.onNewResult(closeablereference, flag);
        CloseableReference.closeSafely(closeablereference1);
        return;
        closeablereference;
        CloseableReference.closeSafely(closeablereference1);
        throw closeablereference;
        closeablereference;
        CloseableReference.closeSafely(closeablereference1);
        throw closeablereference;
    }

    public volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((CloseableReference)obj, flag);
    }

    (CacheKey cachekey)
    {
        this$0 = final_bitmapmemorycacheproducer;
        val$cacheKey = cachekey;
        super(Consumer.this);
    }
}
