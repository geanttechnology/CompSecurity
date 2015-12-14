// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.common.util.UriUtil;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            DecodeProducer, ProducerContext, DownsampleUtil

class val.producerContext
    implements val.producerContext
{

    final this._cls1 this$1;
    final ProducerContext val$producerContext;
    final DecodeProducer val$this$0;

    public void run(EncodedImage encodedimage, boolean flag)
    {
        if (encodedimage != null)
        {
            if (DecodeProducer.access$000(_fld0))
            {
                ImageRequest imagerequest = val$producerContext.getImageRequest();
                if (DecodeProducer.access$100(_fld0) || !UriUtil.isNetworkUri(imagerequest.getSourceUri()))
                {
                    encodedimage.setSampleSize(DownsampleUtil.determineSampleSize(imagerequest, encodedimage));
                }
            }
            cess._mth200(this._cls1.this, encodedimage, flag);
        }
    }

    ()
    {
        this$1 = final_;
        val$this$0 = decodeproducer;
        val$producerContext = ProducerContext.this;
        super();
    }
}
