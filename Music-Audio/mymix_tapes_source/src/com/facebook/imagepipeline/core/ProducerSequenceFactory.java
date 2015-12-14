// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.core;

import android.net.Uri;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.media.MediaUtils;
import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.RemoveImageTransformMetaDataProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.core:
//            ProducerFactory

public class ProducerSequenceFactory
{

    private static final int MAX_SIMULTANEOUS_FILE_FETCH_AND_RESIZE = 5;
    Producer mBackgroundNetworkFetchToEncodedMemorySequence;
    Map mCloseableImagePrefetchSequences;
    private Producer mCommonNetworkFetchToEncodedMemorySequence;
    Producer mDataFetchSequence;
    private final boolean mDownsampleEnabled;
    Producer mEncodedImageProducerSequence;
    Producer mLocalAssetFetchSequence;
    Producer mLocalContentUriFetchSequence;
    Producer mLocalImageFileFetchSequence;
    Producer mLocalResourceFetchSequence;
    Producer mLocalVideoFileFetchSequence;
    Producer mNetworkFetchSequence;
    Producer mNetworkFetchToEncodedMemoryPrefetchSequence;
    private final NetworkFetcher mNetworkFetcher;
    Map mPostprocessorSequences;
    private final ProducerFactory mProducerFactory;
    private final boolean mResizeAndRotateEnabledForNetwork;

    public ProducerSequenceFactory(ProducerFactory producerfactory, NetworkFetcher networkfetcher, boolean flag, boolean flag1)
    {
        mProducerFactory = producerfactory;
        mNetworkFetcher = networkfetcher;
        mResizeAndRotateEnabledForNetwork = flag;
        mDownsampleEnabled = flag1;
        mPostprocessorSequences = new HashMap();
        mCloseableImagePrefetchSequences = new HashMap();
    }

    private Producer getBackgroundNetworkFetchToEncodedMemorySequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mBackgroundNetworkFetchToEncodedMemorySequence == null)
        {
            mBackgroundNetworkFetchToEncodedMemorySequence = mProducerFactory.newBackgroundThreadHandoffProducer(getCommonNetworkFetchToEncodedMemorySequence());
        }
        producer = mBackgroundNetworkFetchToEncodedMemorySequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getBasicDecodedImageSequence(ImageRequest imagerequest)
    {
        Preconditions.checkNotNull(imagerequest);
        imagerequest = imagerequest.getSourceUri();
        Preconditions.checkNotNull(imagerequest, "Uri is null.");
        if (UriUtil.isNetworkUri(imagerequest))
        {
            return getNetworkFetchSequence();
        }
        if (UriUtil.isLocalFileUri(imagerequest))
        {
            if (MediaUtils.isVideo(MediaUtils.extractMime(imagerequest.getPath())))
            {
                return getLocalVideoFileFetchSequence();
            } else
            {
                return getLocalImageFileFetchSequence();
            }
        }
        if (UriUtil.isLocalContentUri(imagerequest))
        {
            return getLocalContentUriFetchSequence();
        }
        if (UriUtil.isLocalAssetUri(imagerequest))
        {
            return getLocalAssetFetchSequence();
        }
        if (UriUtil.isLocalResourceUri(imagerequest))
        {
            return getLocalResourceFetchSequence();
        }
        if (UriUtil.isDataUri(imagerequest))
        {
            return getDataFetchSequence();
        }
        String s = imagerequest.toString();
        imagerequest = s;
        if (s.length() > 30)
        {
            imagerequest = (new StringBuilder()).append(s.substring(0, 30)).append("...").toString();
        }
        throw new RuntimeException((new StringBuilder()).append("Unsupported uri scheme! Uri is: ").append(imagerequest).toString());
    }

    private Producer getCommonNetworkFetchToEncodedMemorySequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mCommonNetworkFetchToEncodedMemorySequence == null)
        {
            mCommonNetworkFetchToEncodedMemorySequence = ProducerFactory.newAddImageTransformMetaDataProducer(newEncodedCacheMultiplexToTranscodeSequence(mProducerFactory.newNetworkFetchProducer(mNetworkFetcher)));
            if (mResizeAndRotateEnabledForNetwork && !mDownsampleEnabled)
            {
                mCommonNetworkFetchToEncodedMemorySequence = mProducerFactory.newResizeAndRotateProducer(mCommonNetworkFetchToEncodedMemorySequence);
            }
        }
        producer = mCommonNetworkFetchToEncodedMemorySequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getDataFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj1;
        if (mDataFetchSequence != null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        obj1 = mProducerFactory.newDataFetchProducer();
        Object obj = obj1;
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            obj = mProducerFactory.newWebpTranscodeProducer(((Producer) (obj1)));
        }
        obj1 = mProducerFactory;
        obj1 = ProducerFactory.newAddImageTransformMetaDataProducer(((Producer) (obj)));
        obj = obj1;
        if (!mDownsampleEnabled)
        {
            obj = mProducerFactory.newResizeAndRotateProducer(((Producer) (obj1)));
        }
        mDataFetchSequence = newBitmapCacheGetToDecodeSequence(((Producer) (obj)));
        obj = mDataFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return ((Producer) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getDecodedImagePrefetchSequence(Producer producer)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mCloseableImagePrefetchSequences.containsKey(producer))
        {
            Object obj = mProducerFactory;
            obj = ProducerFactory.newSwallowResultProducer(producer);
            mCloseableImagePrefetchSequences.put(producer, obj);
        }
        producer = (Producer)mCloseableImagePrefetchSequences.get(producer);
        this;
        JVM INSTR monitorexit ;
        return producer;
        producer;
        throw producer;
    }

    private Producer getLocalAssetFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mLocalAssetFetchSequence == null)
        {
            mLocalAssetFetchSequence = newBitmapCacheGetToLocalTransformSequence(mProducerFactory.newLocalAssetFetchProducer());
        }
        producer = mLocalAssetFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getLocalContentUriFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mLocalContentUriFetchSequence == null)
        {
            mLocalContentUriFetchSequence = newBitmapCacheGetToLocalTransformSequence(mProducerFactory.newContentUriFetchProducer());
        }
        producer = mLocalContentUriFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getLocalImageFileFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mLocalImageFileFetchSequence == null)
        {
            mLocalImageFileFetchSequence = newBitmapCacheGetToLocalTransformSequence(mProducerFactory.newLocalFileFetchProducer());
        }
        producer = mLocalImageFileFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getLocalResourceFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mLocalResourceFetchSequence == null)
        {
            mLocalResourceFetchSequence = newBitmapCacheGetToLocalTransformSequence(mProducerFactory.newLocalResourceFetchProducer());
        }
        producer = mLocalResourceFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getLocalVideoFileFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mLocalVideoFileFetchSequence == null)
        {
            mLocalVideoFileFetchSequence = newBitmapCacheGetToBitmapCacheSequence(mProducerFactory.newLocalVideoThumbnailProducer());
        }
        producer = mLocalVideoFileFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getNetworkFetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mNetworkFetchSequence == null)
        {
            mNetworkFetchSequence = newBitmapCacheGetToDecodeSequence(getCommonNetworkFetchToEncodedMemorySequence());
        }
        producer = mNetworkFetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getNetworkFetchToEncodedMemoryPrefetchSequence()
    {
        this;
        JVM INSTR monitorenter ;
        Producer producer;
        if (mNetworkFetchToEncodedMemoryPrefetchSequence == null)
        {
            ProducerFactory producerfactory = mProducerFactory;
            mNetworkFetchToEncodedMemoryPrefetchSequence = ProducerFactory.newSwallowResultProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        producer = mNetworkFetchToEncodedMemoryPrefetchSequence;
        this;
        JVM INSTR monitorexit ;
        return producer;
        Exception exception;
        exception;
        throw exception;
    }

    private Producer getPostprocessorSequence(Producer producer)
    {
        this;
        JVM INSTR monitorenter ;
        if (!mPostprocessorSequences.containsKey(producer))
        {
            Object obj = mProducerFactory.newPostprocessorProducer(producer);
            obj = mProducerFactory.newPostprocessorBitmapMemoryCacheProducer(((Producer) (obj)));
            mPostprocessorSequences.put(producer, obj);
        }
        producer = (Producer)mPostprocessorSequences.get(producer);
        this;
        JVM INSTR monitorexit ;
        return producer;
        producer;
        throw producer;
    }

    private Producer newBitmapCacheGetToBitmapCacheSequence(Producer producer)
    {
        producer = mProducerFactory.newBitmapMemoryCacheProducer(producer);
        producer = mProducerFactory.newBitmapMemoryCacheKeyMultiplexProducer(producer);
        producer = mProducerFactory.newBackgroundThreadHandoffProducer(producer);
        return mProducerFactory.newBitmapMemoryCacheGetProducer(producer);
    }

    private Producer newBitmapCacheGetToDecodeSequence(Producer producer)
    {
        return newBitmapCacheGetToBitmapCacheSequence(mProducerFactory.newDecodeProducer(producer));
    }

    private Producer newBitmapCacheGetToLocalTransformSequence(Producer producer)
    {
        return newBitmapCacheGetToDecodeSequence(newLocalTransformationsSequence(newEncodedCacheMultiplexToTranscodeSequence(producer)));
    }

    private Producer newEncodedCacheMultiplexToTranscodeSequence(Producer producer)
    {
        Object obj = producer;
        if (android.os.Build.VERSION.SDK_INT < 18)
        {
            obj = mProducerFactory.newWebpTranscodeProducer(producer);
        }
        producer = mProducerFactory.newDiskCacheProducer(((Producer) (obj)));
        producer = mProducerFactory.newEncodedMemoryCacheProducer(producer);
        return mProducerFactory.newEncodedCacheKeyMultiplexProducer(producer);
    }

    private Producer newLocalTransformationsSequence(Producer producer)
    {
        Object obj = mProducerFactory;
        obj = ProducerFactory.newAddImageTransformMetaDataProducer(producer);
        producer = ((Producer) (obj));
        if (!mDownsampleEnabled)
        {
            producer = mProducerFactory.newResizeAndRotateProducer(((Producer) (obj)));
        }
        com.facebook.imagepipeline.producers.ThrottlingProducer throttlingproducer = mProducerFactory.newThrottlingProducer(5, producer);
        obj = mProducerFactory.newLocalExifThumbnailProducer();
        producer = ((Producer) (obj));
        if (!mDownsampleEnabled)
        {
            producer = mProducerFactory.newResizeAndRotateProducer(((Producer) (obj)));
        }
        obj = mProducerFactory;
        return ProducerFactory.newBranchOnSeparateImagesProducer(producer, throttlingproducer);
    }

    private static void validateEncodedImageRequest(ImageRequest imagerequest)
    {
        Preconditions.checkNotNull(imagerequest);
        Preconditions.checkArgument(UriUtil.isNetworkUri(imagerequest.getSourceUri()));
        boolean flag;
        if (imagerequest.getLowestPermittedRequestLevel().getValue() <= com.facebook.imagepipeline.request.ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag);
    }

    public Producer getDecodedImagePrefetchProducerSequence(ImageRequest imagerequest)
    {
        return getDecodedImagePrefetchSequence(getBasicDecodedImageSequence(imagerequest));
    }

    public Producer getDecodedImageProducerSequence(ImageRequest imagerequest)
    {
        Producer producer1 = getBasicDecodedImageSequence(imagerequest);
        Producer producer = producer1;
        if (imagerequest.getPostprocessor() != null)
        {
            producer = getPostprocessorSequence(producer1);
        }
        return producer;
    }

    public Producer getEncodedImagePrefetchProducerSequence(ImageRequest imagerequest)
    {
        validateEncodedImageRequest(imagerequest);
        return getNetworkFetchToEncodedMemoryPrefetchSequence();
    }

    public Producer getEncodedImageProducerSequence(ImageRequest imagerequest)
    {
        validateEncodedImageRequest(imagerequest);
        this;
        JVM INSTR monitorenter ;
        if (mEncodedImageProducerSequence == null)
        {
            mEncodedImageProducerSequence = new RemoveImageTransformMetaDataProducer(getBackgroundNetworkFetchToEncodedMemorySequence());
        }
        this;
        JVM INSTR monitorexit ;
        return mEncodedImageProducerSequence;
        imagerequest;
        this;
        JVM INSTR monitorexit ;
        throw imagerequest;
    }
}
