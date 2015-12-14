// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.MemoryCache;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, PostprocessedBitmapMemoryCacheProducer, Consumer

public static class mMemoryCache extends DelegatingConsumer
{

    private final CacheKey mCacheKey;
    private final boolean mIsRepeatedProcessor;
    private final MemoryCache mMemoryCache;
    private final String mProcessorName;

    protected void onNewResultImpl(CloseableReference closeablereference, boolean flag)
    {
        CloseableReference closeablereference1;
        if (!flag && !mIsRepeatedProcessor)
        {
            return;
        }
        if (closeablereference == null)
        {
            getConsumer().onNewResult(null, flag);
            return;
        }
        Consumer consumer;
        if (mCacheKey != null)
        {
            mMemoryCache.removeAll(new Predicate() {

                final PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer this$0;

                public boolean apply(CacheKey cachekey)
                {
                    if (cachekey instanceof BitmapMemoryCacheKey)
                    {
                        return mProcessorName.equals(((BitmapMemoryCacheKey)cachekey).getPostprocessorName());
                    } else
                    {
                        return false;
                    }
                }

                public volatile boolean apply(Object obj)
                {
                    return apply((CacheKey)obj);
                }

            
            {
                this$0 = PostprocessedBitmapMemoryCacheProducer.CachedPostprocessorConsumer.this;
                super();
            }
            });
            closeablereference1 = mMemoryCache.cache(mCacheKey, closeablereference);
        } else
        {
            closeablereference1 = closeablereference;
        }
        getConsumer().onProgressUpdate(1.0F);
        consumer = getConsumer();
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
    }

    protected volatile void onNewResultImpl(Object obj, boolean flag)
    {
        onNewResultImpl((CloseableReference)obj, flag);
    }


    public _cls1.this._cls0(Consumer consumer, CacheKey cachekey, boolean flag, String s, MemoryCache memorycache)
    {
        super(consumer);
        mCacheKey = cachekey;
        mIsRepeatedProcessor = flag;
        mProcessorName = s;
        mMemoryCache = memorycache;
    }
}
