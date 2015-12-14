// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.util.UriUtil;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.CloseableProducerToDataSourceAdapter;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ProducerSequenceFactory

public class ImagePipeline
{

    private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
    private final MemoryCache mBitmapMemoryCache;
    private final CacheKeyFactory mCacheKeyFactory;
    private final MemoryCache mEncodedMemoryCache;
    private AtomicLong mIdCounter;
    private final Supplier mIsPrefetchEnabledSupplier;
    private final DiskStorageCache mMainDiskStorageCache;
    private final ProducerSequenceFactory mProducerSequenceFactory;
    private final RequestListener mRequestListener;
    private final DiskStorageCache mSmallImageDiskStorageCache;

    public ImagePipeline(ProducerSequenceFactory producersequencefactory, Set set, Supplier supplier, MemoryCache memorycache, MemoryCache memorycache1, DiskStorageCache diskstoragecache, DiskStorageCache diskstoragecache1, 
            CacheKeyFactory cachekeyfactory)
    {
        mIdCounter = new AtomicLong();
        mProducerSequenceFactory = producersequencefactory;
        mRequestListener = new ForwardingRequestListener(set);
        mIsPrefetchEnabledSupplier = supplier;
        mBitmapMemoryCache = memorycache;
        mEncodedMemoryCache = memorycache1;
        mMainDiskStorageCache = diskstoragecache;
        mSmallImageDiskStorageCache = diskstoragecache1;
        mCacheKeyFactory = cachekeyfactory;
    }

    private String generateUniqueFutureId()
    {
        return String.valueOf(mIdCounter.getAndIncrement());
    }

    private DataSource submitFetchRequest(Producer producer, ImageRequest imagerequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestlevel, Object obj)
    {
        boolean flag = false;
        String s;
        RequestListener requestlistener;
        requestlevel = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imagerequest.getLowestPermittedRequestLevel(), requestlevel);
        s = generateUniqueFutureId();
        requestlistener = mRequestListener;
        if (imagerequest.getProgressiveRenderingEnabled() || !UriUtil.isNetworkUri(imagerequest.getSourceUri()))
        {
            flag = true;
        }
        try
        {
            producer = CloseableProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imagerequest, s, requestlistener, obj, requestlevel, false, flag, imagerequest.getPriority()), mRequestListener);
        }
        // Misplaced declaration of an exception variable
        catch (Producer producer)
        {
            return DataSources.immediateFailedDataSource(producer);
        }
        return producer;
    }

    private DataSource submitPrefetchRequest(Producer producer, ImageRequest imagerequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel requestlevel, Object obj)
    {
        try
        {
            requestlevel = com.facebook.imagepipeline.request.ImageRequest.RequestLevel.getMax(imagerequest.getLowestPermittedRequestLevel(), requestlevel);
            producer = ProducerToDataSourceAdapter.create(producer, new SettableProducerContext(imagerequest, generateUniqueFutureId(), mRequestListener, obj, requestlevel, true, false, Priority.LOW), mRequestListener);
        }
        // Misplaced declaration of an exception variable
        catch (Producer producer)
        {
            return DataSources.immediateFailedDataSource(producer);
        }
        return producer;
    }

    public void clearCaches()
    {
        clearMemoryCaches();
        clearDiskCaches();
    }

    public void clearDiskCaches()
    {
        mMainDiskStorageCache.clearAll();
        mSmallImageDiskStorageCache.clearAll();
    }

    public void clearMemoryCaches()
    {
        Predicate predicate = new Predicate() {

            final ImagePipeline this$0;

            public boolean apply(CacheKey cachekey)
            {
                return true;
            }

            public volatile boolean apply(Object obj)
            {
                return apply((CacheKey)obj);
            }

            
            {
                this$0 = ImagePipeline.this;
                super();
            }
        };
        mBitmapMemoryCache.removeAll(predicate);
        mEncodedMemoryCache.removeAll(predicate);
    }

    public void evictFromCache(Uri uri)
    {
        evictFromMemoryCache(uri);
        evictFromDiskCache(uri);
    }

    public void evictFromDiskCache(Uri uri)
    {
        uri = mCacheKeyFactory.getEncodedCacheKey(ImageRequest.fromUri(uri));
        mMainDiskStorageCache.remove(uri);
        mSmallImageDiskStorageCache.remove(uri);
    }

    public void evictFromDiskCache(ImageRequest imagerequest)
    {
        imagerequest = mCacheKeyFactory.getEncodedCacheKey(imagerequest);
        mMainDiskStorageCache.remove(imagerequest);
        mSmallImageDiskStorageCache.remove(imagerequest);
    }

    public void evictFromMemoryCache(final Uri cacheKeySourceString)
    {
        cacheKeySourceString = mCacheKeyFactory.getCacheKeySourceUri(cacheKeySourceString).toString();
        Predicate predicate = new Predicate() {

            final ImagePipeline this$0;
            final String val$cacheKeySourceString;

            public boolean apply(CacheKey cachekey)
            {
                if (cachekey instanceof BitmapMemoryCacheKey)
                {
                    return ((BitmapMemoryCacheKey)cachekey).getSourceUriString().equals(cacheKeySourceString);
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
                this$0 = ImagePipeline.this;
                cacheKeySourceString = s;
                super();
            }
        };
        mBitmapMemoryCache.removeAll(predicate);
        cacheKeySourceString = new Predicate() {

            final ImagePipeline this$0;
            final String val$cacheKeySourceString;

            public boolean apply(CacheKey cachekey)
            {
                return cachekey.toString().equals(cacheKeySourceString);
            }

            public volatile boolean apply(Object obj)
            {
                return apply((CacheKey)obj);
            }

            
            {
                this$0 = ImagePipeline.this;
                cacheKeySourceString = s;
                super();
            }
        };
        mEncodedMemoryCache.removeAll(cacheKeySourceString);
    }

    public DataSource fetchDecodedImage(ImageRequest imagerequest, Object obj)
    {
        try
        {
            imagerequest = submitFetchRequest(mProducerSequenceFactory.getDecodedImageProducerSequence(imagerequest), imagerequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, obj);
        }
        // Misplaced declaration of an exception variable
        catch (ImageRequest imagerequest)
        {
            return DataSources.immediateFailedDataSource(imagerequest);
        }
        return imagerequest;
    }

    public DataSource fetchEncodedImage(ImageRequest imagerequest, Object obj)
    {
        Preconditions.checkNotNull(imagerequest.getSourceUri());
        ImageRequest imagerequest1;
        Producer producer;
        try
        {
            producer = mProducerSequenceFactory.getEncodedImageProducerSequence(imagerequest);
        }
        // Misplaced declaration of an exception variable
        catch (ImageRequest imagerequest)
        {
            return DataSources.immediateFailedDataSource(imagerequest);
        }
        imagerequest1 = imagerequest;
        if (imagerequest.getResizeOptions() != null)
        {
            imagerequest1 = ImageRequestBuilder.fromRequest(imagerequest).setResizeOptions(null).build();
        }
        imagerequest = submitFetchRequest(producer, imagerequest1, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, obj);
        return imagerequest;
    }

    public DataSource fetchImageFromBitmapCache(ImageRequest imagerequest, Object obj)
    {
        try
        {
            imagerequest = submitFetchRequest(mProducerSequenceFactory.getDecodedImageProducerSequence(imagerequest), imagerequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, obj);
        }
        // Misplaced declaration of an exception variable
        catch (ImageRequest imagerequest)
        {
            return DataSources.immediateFailedDataSource(imagerequest);
        }
        return imagerequest;
    }

    public Supplier getDataSourceSupplier(final ImageRequest imageRequest, final Object callerContext, final boolean bitmapCacheOnly)
    {
        return new Supplier() {

            final ImagePipeline this$0;
            final boolean val$bitmapCacheOnly;
            final Object val$callerContext;
            final ImageRequest val$imageRequest;

            public DataSource get()
            {
                if (bitmapCacheOnly)
                {
                    return fetchImageFromBitmapCache(imageRequest, callerContext);
                } else
                {
                    return fetchDecodedImage(imageRequest, callerContext);
                }
            }

            public volatile Object get()
            {
                return get();
            }

            public String toString()
            {
                return Objects.toStringHelper(this).add("uri", imageRequest.getSourceUri()).toString();
            }

            
            {
                this$0 = ImagePipeline.this;
                bitmapCacheOnly = flag;
                imageRequest = imagerequest;
                callerContext = obj;
                super();
            }
        };
    }

    public DataSource prefetchToBitmapCache(ImageRequest imagerequest, Object obj)
    {
        if (!((Boolean)mIsPrefetchEnabledSupplier.get()).booleanValue())
        {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try
        {
            imagerequest = submitPrefetchRequest(mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(imagerequest), imagerequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, obj);
        }
        // Misplaced declaration of an exception variable
        catch (ImageRequest imagerequest)
        {
            return DataSources.immediateFailedDataSource(imagerequest);
        }
        return imagerequest;
    }

    public DataSource prefetchToDiskCache(ImageRequest imagerequest, Object obj)
    {
        if (!((Boolean)mIsPrefetchEnabledSupplier.get()).booleanValue())
        {
            return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
        }
        try
        {
            imagerequest = submitPrefetchRequest(mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(imagerequest), imagerequest, com.facebook.imagepipeline.request.ImageRequest.RequestLevel.FULL_FETCH, obj);
        }
        // Misplaced declaration of an exception variable
        catch (ImageRequest imagerequest)
        {
            return DataSources.immediateFailedDataSource(imagerequest);
        }
        return imagerequest;
    }

}
