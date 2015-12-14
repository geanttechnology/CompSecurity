// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Producer, ProducerContext, Consumer, DelegatingConsumer, 
//            StatefulProducerRunnable, ProducerListener

public class WebpTranscodeProducer
    implements Producer
{
    private class WebpTranscodeConsumer extends DelegatingConsumer
    {

        private final ProducerContext mContext;
        private TriState mShouldTranscodeWhenFinished;
        final WebpTranscodeProducer this$0;

        protected void onNewResultImpl(EncodedImage encodedimage, boolean flag)
        {
            if (mShouldTranscodeWhenFinished == TriState.UNSET && encodedimage != null)
            {
                mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(encodedimage);
            }
            if (mShouldTranscodeWhenFinished == TriState.NO)
            {
                getConsumer().onNewResult(encodedimage, flag);
            } else
            if (flag)
            {
                if (mShouldTranscodeWhenFinished == TriState.YES && encodedimage != null)
                {
                    transcodeLastResult(encodedimage, getConsumer(), mContext);
                    return;
                } else
                {
                    getConsumer().onNewResult(encodedimage, flag);
                    return;
                }
            }
        }

        protected volatile void onNewResultImpl(Object obj, boolean flag)
        {
            onNewResultImpl((EncodedImage)obj, flag);
        }

        public WebpTranscodeConsumer(Consumer consumer, ProducerContext producercontext)
        {
            this$0 = WebpTranscodeProducer.this;
            super(consumer);
            mContext = producercontext;
            mShouldTranscodeWhenFinished = TriState.UNSET;
        }
    }


    private static final int DEFAULT_JPEG_QUALITY = 80;
    private static final String PRODUCER_NAME = "WebpTranscodeProducer";
    private final Executor mExecutor;
    private final Producer mNextProducer;
    private final PooledByteBufferFactory mPooledByteBufferFactory;

    public WebpTranscodeProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory, Producer producer)
    {
        mExecutor = (Executor)Preconditions.checkNotNull(executor);
        mPooledByteBufferFactory = (PooledByteBufferFactory)Preconditions.checkNotNull(pooledbytebufferfactory);
        mNextProducer = (Producer)Preconditions.checkNotNull(producer);
    }

    private static void doTranscode(EncodedImage encodedimage, PooledByteBufferOutputStream pooledbytebufferoutputstream)
        throws Exception
    {
        encodedimage = encodedimage.getInputStream();
        ImageFormat imageformat = ImageFormatChecker.getImageFormat_WrapIOException(encodedimage);
        static class _cls2
        {

            static final int $SwitchMap$com$facebook$imageformat$ImageFormat[];

            static 
            {
                $SwitchMap$com$facebook$imageformat$ImageFormat = new int[ImageFormat.values().length];
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_SIMPLE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_LOSSLESS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.WEBP_EXTENDED_WITH_ALPHA.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$facebook$imageformat$ImageFormat[ImageFormat.UNKNOWN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.facebook.imageformat.ImageFormat[imageformat.ordinal()])
        {
        default:
            throw new IllegalArgumentException("Wrong image format");

        case 1: // '\001'
        case 3: // '\003'
            WebpTranscoder.transcodeWebpToJpeg(encodedimage, pooledbytebufferoutputstream, 80);
            return;

        case 2: // '\002'
        case 4: // '\004'
            WebpTranscoder.transcodeWebpToPng(encodedimage, pooledbytebufferoutputstream);
            break;
        }
    }

    private static TriState shouldTranscode(EncodedImage encodedimage)
    {
        Preconditions.checkNotNull(encodedimage);
        encodedimage = ImageFormatChecker.getImageFormat_WrapIOException(encodedimage.getInputStream());
        switch (_cls2..SwitchMap.com.facebook.imageformat.ImageFormat[encodedimage.ordinal()])
        {
        default:
            return TriState.NO;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
            boolean flag;
            if (!WebpTranscoder.isWebpNativelySupported(encodedimage))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            return TriState.valueOf(flag);

        case 5: // '\005'
            return TriState.UNSET;
        }
    }

    private void transcodeLastResult(EncodedImage encodedimage, final Consumer final_consumer, ProducerContext producercontext)
    {
        Preconditions.checkNotNull(encodedimage);
        encodedimage = EncodedImage.cloneOrNull(encodedimage);
        encodedimage = new StatefulProducerRunnable(producercontext.getListener(), "WebpTranscodeProducer", producercontext.getId(), encodedimage) {

            final WebpTranscodeProducer this$0;
            final EncodedImage val$encodedImageCopy;

            protected void disposeResult(EncodedImage encodedimage1)
            {
                EncodedImage.closeSafely(encodedimage1);
            }

            protected volatile void disposeResult(Object obj)
            {
                disposeResult((EncodedImage)obj);
            }

            protected EncodedImage getResult()
                throws Exception
            {
                PooledByteBufferOutputStream pooledbytebufferoutputstream = mPooledByteBufferFactory.newOutputStream();
                CloseableReference closeablereference;
                WebpTranscodeProducer.doTranscode(encodedImageCopy, pooledbytebufferoutputstream);
                closeablereference = CloseableReference.of(pooledbytebufferoutputstream.toByteBuffer());
                EncodedImage encodedimage1;
                encodedimage1 = new EncodedImage(closeablereference);
                encodedimage1.copyMetaDataFrom(encodedImageCopy);
                CloseableReference.closeSafely(closeablereference);
                pooledbytebufferoutputstream.close();
                return encodedimage1;
                Exception exception1;
                exception1;
                CloseableReference.closeSafely(closeablereference);
                throw exception1;
                Exception exception;
                exception;
                pooledbytebufferoutputstream.close();
                throw exception;
            }

            protected volatile Object getResult()
                throws Exception
            {
                return getResult();
            }

            protected void onCancellation()
            {
                EncodedImage.closeSafely(encodedImageCopy);
                super.onCancellation();
            }

            protected void onFailure(Exception exception)
            {
                EncodedImage.closeSafely(encodedImageCopy);
                super.onFailure(exception);
            }

            protected void onSuccess(EncodedImage encodedimage1)
            {
                EncodedImage.closeSafely(encodedImageCopy);
                super.onSuccess(encodedimage1);
            }

            protected volatile void onSuccess(Object obj)
            {
                onSuccess((EncodedImage)obj);
            }

            
            {
                this$0 = WebpTranscodeProducer.this;
                encodedImageCopy = encodedimage;
                super(final_consumer, producerlistener, s, s1);
            }
        };
        mExecutor.execute(encodedimage);
    }

    public void produceResults(Consumer consumer, ProducerContext producercontext)
    {
        mNextProducer.produceResults(new WebpTranscodeConsumer(consumer, producercontext), producercontext);
    }




}
