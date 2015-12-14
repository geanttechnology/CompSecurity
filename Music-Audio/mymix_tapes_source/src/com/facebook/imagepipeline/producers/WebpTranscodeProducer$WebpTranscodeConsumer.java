// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.util.TriState;
import com.facebook.imagepipeline.image.EncodedImage;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DelegatingConsumer, WebpTranscodeProducer, Consumer, ProducerContext

private class mShouldTranscodeWhenFinished extends DelegatingConsumer
{

    private final ProducerContext mContext;
    private TriState mShouldTranscodeWhenFinished;
    final WebpTranscodeProducer this$0;

    protected void onNewResultImpl(EncodedImage encodedimage, boolean flag)
    {
        if (mShouldTranscodeWhenFinished == TriState.UNSET && encodedimage != null)
        {
            mShouldTranscodeWhenFinished = WebpTranscodeProducer.access$000(encodedimage);
        }
        if (mShouldTranscodeWhenFinished == TriState.NO)
        {
            getConsumer().onNewResult(encodedimage, flag);
        } else
        if (flag)
        {
            if (mShouldTranscodeWhenFinished == TriState.YES && encodedimage != null)
            {
                WebpTranscodeProducer.access$100(WebpTranscodeProducer.this, encodedimage, getConsumer(), mContext);
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

    public (Consumer consumer, ProducerContext producercontext)
    {
        this$0 = WebpTranscodeProducer.this;
        super(consumer);
        mContext = producercontext;
        mShouldTranscodeWhenFinished = TriState.UNSET;
    }
}
