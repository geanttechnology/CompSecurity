// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DecodeProducer, Consumer, ProducerContext

private class this._cls0 extends this._cls0
{

    final DecodeProducer this$0;

    protected int getIntermediateImageEndOffset(EncodedImage encodedimage)
    {
        return encodedimage.getSize();
    }

    protected QualityInfo getQualityInfo()
    {
        return ImmutableQualityInfo.of(0, false, false);
    }

    protected boolean updateDecodeJob(EncodedImage encodedimage, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (flag) goto _L2; else goto _L1
_L1:
        flag = false;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        flag = super.eJob(encodedimage, flag);
        if (true) goto _L4; else goto _L3
_L3:
        encodedimage;
        throw encodedimage;
    }

    public (Consumer consumer, ProducerContext producercontext)
    {
        this$0 = DecodeProducer.this;
        super(DecodeProducer.this, consumer, producercontext);
    }
}
