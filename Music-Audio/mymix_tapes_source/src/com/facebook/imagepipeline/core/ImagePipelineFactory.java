// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Rect;
import com.facebook.cache.disk.DiskCacheFactory;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.common.executors.DefaultSerialExecutorService;
import com.facebook.common.executors.SerialExecutorService;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.MonotonicClock;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableBackend;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableOptions;
import com.facebook.imagepipeline.animated.base.AnimatedImageResult;
import com.facebook.imagepipeline.animated.factory.AnimatedDrawableFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedImageFactory;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableBackendProvider;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImpl;
import com.facebook.imagepipeline.animated.impl.AnimatedDrawableCachingBackendImplProvider;
import com.facebook.imagepipeline.animated.util.AnimatedDrawableUtil;
import com.facebook.imagepipeline.bitmaps.ArtBitmapFactory;
import com.facebook.imagepipeline.bitmaps.DalvikBitmapFactory;
import com.facebook.imagepipeline.bitmaps.EmptyJpegGenerator;
import com.facebook.imagepipeline.bitmaps.GingerbreadBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.memory.PoolFactory;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ImagePipelineConfig, ExecutorSupplier, ProducerFactory, ProducerSequenceFactory, 
//            ImagePipeline

public class ImagePipelineFactory
{

    private static ImagePipelineFactory sInstance = null;
    private AnimatedDrawableFactory mAnimatedDrawableFactory;
    private AnimatedDrawableUtil mAnimatedDrawableUtil;
    private AnimatedImageFactory mAnimatedImageFactory;
    private CountingMemoryCache mBitmapCountingMemoryCache;
    private MemoryCache mBitmapMemoryCache;
    private final ImagePipelineConfig mConfig;
    private CountingMemoryCache mEncodedCountingMemoryCache;
    private MemoryCache mEncodedMemoryCache;
    private ImageDecoder mImageDecoder;
    private ImagePipeline mImagePipeline;
    private BufferedDiskCache mMainBufferedDiskCache;
    private DiskStorageCache mMainDiskStorageCache;
    private PlatformBitmapFactory mPlatformBitmapFactory;
    private ProducerFactory mProducerFactory;
    private ProducerSequenceFactory mProducerSequenceFactory;
    private BufferedDiskCache mSmallImageBufferedDiskCache;
    private DiskStorageCache mSmallImageDiskStorageCache;

    public ImagePipelineFactory(ImagePipelineConfig imagepipelineconfig)
    {
        mConfig = (ImagePipelineConfig)Preconditions.checkNotNull(imagepipelineconfig);
    }

    public static AnimatedImageFactory buildAnimatedImageFactory(AnimatedDrawableUtil animateddrawableutil, PlatformBitmapFactory platformbitmapfactory)
    {
        return new AnimatedImageFactory(new AnimatedDrawableBackendProvider(animateddrawableutil) {

            final AnimatedDrawableUtil val$animatedDrawableUtil;

            public AnimatedDrawableBackend get(AnimatedImageResult animatedimageresult, Rect rect)
            {
                return new AnimatedDrawableBackendImpl(animatedDrawableUtil, animatedimageresult, rect);
            }

            
            {
                animatedDrawableUtil = animateddrawableutil;
                super();
            }
        }, platformbitmapfactory);
    }

    public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory poolfactory)
    {
        GingerbreadBitmapFactory gingerbreadbitmapfactory;
        DalvikBitmapFactory dalvikbitmapfactory;
        if (android.os.Build.VERSION.SDK_INT < 11)
        {
            gingerbreadbitmapfactory = new GingerbreadBitmapFactory();
        } else
        {
            gingerbreadbitmapfactory = null;
        }
        dalvikbitmapfactory = new DalvikBitmapFactory(new EmptyJpegGenerator(poolfactory.getPooledByteBufferFactory()), poolfactory.getFlexByteArrayPool());
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            poolfactory = new ArtBitmapFactory(poolfactory.getBitmapPool(), poolfactory.getFlexByteArrayPoolMaxNumThreads());
        } else
        {
            poolfactory = null;
        }
        return new PlatformBitmapFactory(gingerbreadbitmapfactory, dalvikbitmapfactory, poolfactory);
    }

    private AnimatedDrawableUtil getAnimatedDrawableUtil()
    {
        if (mAnimatedDrawableUtil == null)
        {
            mAnimatedDrawableUtil = new AnimatedDrawableUtil();
        }
        return mAnimatedDrawableUtil;
    }

    private AnimatedImageFactory getAnimatedImageFactory()
    {
        if (mAnimatedImageFactory == null)
        {
            if (mConfig.getAnimatedImageFactory() != null)
            {
                mAnimatedImageFactory = mConfig.getAnimatedImageFactory();
            } else
            {
                mAnimatedImageFactory = buildAnimatedImageFactory(getAnimatedDrawableUtil(), getPlatformBitmapFactory());
            }
        }
        return mAnimatedImageFactory;
    }

    private ImageDecoder getImageDecoder()
    {
        if (mImageDecoder == null)
        {
            if (mConfig.getImageDecoder() != null)
            {
                mImageDecoder = mConfig.getImageDecoder();
            } else
            {
                mImageDecoder = new ImageDecoder(getAnimatedImageFactory(), getPlatformBitmapFactory());
            }
        }
        return mImageDecoder;
    }

    public static ImagePipelineFactory getInstance()
    {
        return (ImagePipelineFactory)Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    private BufferedDiskCache getMainBufferedDiskCache()
    {
        if (mMainBufferedDiskCache == null)
        {
            mMainBufferedDiskCache = new BufferedDiskCache(getMainDiskStorageCache(), mConfig.getPoolFactory().getPooledByteBufferFactory(), mConfig.getPoolFactory().getPooledByteStreams(), mConfig.getExecutorSupplier().forLocalStorageRead(), mConfig.getExecutorSupplier().forLocalStorageWrite(), mConfig.getImageCacheStatsTracker());
        }
        return mMainBufferedDiskCache;
    }

    private PlatformBitmapFactory getPlatformBitmapFactory()
    {
        if (mPlatformBitmapFactory == null)
        {
            mPlatformBitmapFactory = buildPlatformBitmapFactory(mConfig.getPoolFactory());
        }
        return mPlatformBitmapFactory;
    }

    private ProducerFactory getProducerFactory()
    {
        if (mProducerFactory == null)
        {
            mProducerFactory = new ProducerFactory(mConfig.getContext(), mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), mConfig.getProgressiveJpegConfig(), mConfig.isDownsampleEnabled(), mConfig.isResizeAndRotateEnabledForNetwork(), mConfig.getExecutorSupplier(), mConfig.getPoolFactory().getPooledByteBufferFactory(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), mConfig.getCacheKeyFactory(), getPlatformBitmapFactory());
        }
        return mProducerFactory;
    }

    private ProducerSequenceFactory getProducerSequenceFactory()
    {
        if (mProducerSequenceFactory == null)
        {
            mProducerSequenceFactory = new ProducerSequenceFactory(getProducerFactory(), mConfig.getNetworkFetcher(), mConfig.isResizeAndRotateEnabledForNetwork(), mConfig.isDownsampleEnabled());
        }
        return mProducerSequenceFactory;
    }

    private BufferedDiskCache getSmallImageBufferedDiskCache()
    {
        if (mSmallImageBufferedDiskCache == null)
        {
            mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageDiskStorageCache(), mConfig.getPoolFactory().getPooledByteBufferFactory(), mConfig.getPoolFactory().getPooledByteStreams(), mConfig.getExecutorSupplier().forLocalStorageRead(), mConfig.getExecutorSupplier().forLocalStorageWrite(), mConfig.getImageCacheStatsTracker());
        }
        return mSmallImageBufferedDiskCache;
    }

    public static void initialize(Context context)
    {
        initialize(ImagePipelineConfig.newBuilder(context).build());
    }

    public static void initialize(ImagePipelineConfig imagepipelineconfig)
    {
        sInstance = new ImagePipelineFactory(imagepipelineconfig);
    }

    public static void shutDown()
    {
        if (sInstance != null)
        {
            sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
            sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
            sInstance = null;
        }
    }

    public AnimatedDrawableFactory getAnimatedDrawableFactory()
    {
        if (mAnimatedDrawableFactory == null)
        {
            final AnimatedDrawableUtil animatedDrawableUtil = getAnimatedDrawableUtil();
            Object obj = RealtimeSinceBootClock.get();
            obj = new AnimatedDrawableCachingBackendImplProvider() {

                final ImagePipelineFactory this$0;
                final ActivityManager val$activityManager;
                final AnimatedDrawableUtil val$animatedDrawableUtil;
                final MonotonicClock val$monotonicClock;
                final SerialExecutorService val$serialExecutorService;

                public AnimatedDrawableCachingBackendImpl get(AnimatedDrawableBackend animateddrawablebackend, AnimatedDrawableOptions animateddrawableoptions)
                {
                    return new AnimatedDrawableCachingBackendImpl(serialExecutorService, activityManager, animatedDrawableUtil, monotonicClock, animateddrawablebackend, animateddrawableoptions);
                }

            
            {
                this$0 = ImagePipelineFactory.this;
                serialExecutorService = serialexecutorservice;
                activityManager = activitymanager;
                animatedDrawableUtil = animateddrawableutil;
                monotonicClock = monotonicclock;
                super();
            }
            };
            mAnimatedDrawableFactory = new AnimatedDrawableFactory(new AnimatedDrawableBackendProvider() {

                final ImagePipelineFactory this$0;
                final AnimatedDrawableUtil val$animatedDrawableUtil;

                public AnimatedDrawableBackend get(AnimatedImageResult animatedimageresult, Rect rect)
                {
                    return new AnimatedDrawableBackendImpl(animatedDrawableUtil, animatedimageresult, rect);
                }

            
            {
                this$0 = ImagePipelineFactory.this;
                animatedDrawableUtil = animateddrawableutil;
                super();
            }
            }, ((AnimatedDrawableCachingBackendImplProvider) (obj)), animatedDrawableUtil, UiThreadImmediateExecutorService.getInstance(), mConfig.getContext().getResources());
        }
        return mAnimatedDrawableFactory;
    }

    public CountingMemoryCache getBitmapCountingMemoryCache()
    {
        if (mBitmapCountingMemoryCache == null)
        {
            mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(mConfig.getBitmapMemoryCacheParamsSupplier(), mConfig.getMemoryTrimmableRegistry());
        }
        return mBitmapCountingMemoryCache;
    }

    public MemoryCache getBitmapMemoryCache()
    {
        if (mBitmapMemoryCache == null)
        {
            mBitmapMemoryCache = BitmapMemoryCacheFactory.get(getBitmapCountingMemoryCache(), mConfig.getImageCacheStatsTracker());
        }
        return mBitmapMemoryCache;
    }

    public CountingMemoryCache getEncodedCountingMemoryCache()
    {
        if (mEncodedCountingMemoryCache == null)
        {
            mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(mConfig.getEncodedMemoryCacheParamsSupplier(), mConfig.getMemoryTrimmableRegistry());
        }
        return mEncodedCountingMemoryCache;
    }

    public MemoryCache getEncodedMemoryCache()
    {
        if (mEncodedMemoryCache == null)
        {
            mEncodedMemoryCache = EncodedMemoryCacheFactory.get(getEncodedCountingMemoryCache(), mConfig.getImageCacheStatsTracker());
        }
        return mEncodedMemoryCache;
    }

    public ImagePipeline getImagePipeline()
    {
        if (mImagePipeline == null)
        {
            mImagePipeline = new ImagePipeline(getProducerSequenceFactory(), mConfig.getRequestListeners(), mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainDiskStorageCache(), getSmallImageDiskStorageCache(), mConfig.getCacheKeyFactory());
        }
        return mImagePipeline;
    }

    public DiskStorageCache getMainDiskStorageCache()
    {
        if (mMainDiskStorageCache == null)
        {
            mMainDiskStorageCache = DiskCacheFactory.newDiskStorageCache(mConfig.getMainDiskCacheConfig());
        }
        return mMainDiskStorageCache;
    }

    public DiskStorageCache getSmallImageDiskStorageCache()
    {
        if (mSmallImageDiskStorageCache == null)
        {
            mSmallImageDiskStorageCache = DiskCacheFactory.newDiskStorageCache(mConfig.getSmallImageDiskCacheConfig());
        }
        return mSmallImageDiskStorageCache;
    }

}
