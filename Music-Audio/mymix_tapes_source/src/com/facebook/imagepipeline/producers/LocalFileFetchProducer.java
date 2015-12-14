// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Executor;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            LocalFetchProducer

public class LocalFileFetchProducer extends LocalFetchProducer
{

    static final String PRODUCER_NAME = "LocalFileFetchProducer";

    public LocalFileFetchProducer(Executor executor, PooledByteBufferFactory pooledbytebufferfactory)
    {
        super(executor, pooledbytebufferfactory);
    }

    protected EncodedImage getEncodedImage(ImageRequest imagerequest)
        throws IOException
    {
        return getByteBufferBackedEncodedImage(imagerequest.getSourceFile().toString(), (int)imagerequest.getSourceFile().length());
    }

    protected String getProducerName()
    {
        return "LocalFileFetchProducer";
    }
}
