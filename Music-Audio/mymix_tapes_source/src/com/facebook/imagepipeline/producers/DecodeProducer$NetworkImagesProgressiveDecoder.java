// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.QualityInfo;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DecodeProducer, Consumer, ProducerContext

private class mLastScheduledScanNumber extends mLastScheduledScanNumber
{

    private int mLastScheduledScanNumber;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final ProgressiveJpegParser mProgressiveJpegParser;
    final DecodeProducer this$0;

    protected int getIntermediateImageEndOffset(EncodedImage encodedimage)
    {
        return mProgressiveJpegParser.getBestScanEndOffset();
    }

    protected QualityInfo getQualityInfo()
    {
        return mProgressiveJpegConfig.getQualityInfo(mProgressiveJpegParser.getBestScanNumber());
    }

    protected boolean updateDecodeJob(EncodedImage encodedimage, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag2 = super.ob(encodedimage, flag);
        boolean flag1 = flag2;
        if (flag) goto _L2; else goto _L1
_L1:
        flag1 = flag2;
        if (!EncodedImage.isValid(encodedimage)) goto _L2; else goto _L3
_L3:
        flag = mProgressiveJpegParser.parseMoreData(encodedimage);
        if (flag) goto _L5; else goto _L4
_L4:
        flag1 = false;
_L2:
        this;
        JVM INSTR monitorexit ;
        return flag1;
_L5:
        int i;
        i = mProgressiveJpegParser.getBestScanNumber();
        if (i <= mLastScheduledScanNumber || i < mProgressiveJpegConfig.getNextScanNumberToDecode(mLastScheduledScanNumber))
        {
            break MISSING_BLOCK_LABEL_103;
        }
        mLastScheduledScanNumber = i;
        flag1 = flag2;
        continue; /* Loop/switch isn't completed */
        encodedimage;
        throw encodedimage;
        flag1 = false;
        if (true) goto _L2; else goto _L6
_L6:
    }

    public Y(Consumer consumer, ProducerContext producercontext, ProgressiveJpegParser progressivejpegparser, ProgressiveJpegConfig progressivejpegconfig)
    {
        this$0 = DecodeProducer.this;
        super(DecodeProducer.this, consumer, producercontext);
        mProgressiveJpegParser = (ProgressiveJpegParser)Preconditions.checkNotNull(progressivejpegparser);
        mProgressiveJpegConfig = (ProgressiveJpegConfig)Preconditions.checkNotNull(progressivejpegconfig);
        mLastScheduledScanNumber = 0;
    }
}
