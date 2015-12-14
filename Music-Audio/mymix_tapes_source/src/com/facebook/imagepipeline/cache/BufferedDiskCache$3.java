// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.WriterCallback;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.PooledByteStreams;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.facebook.imagepipeline.cache:
//            BufferedDiskCache

class val.encodedImage
    implements WriterCallback
{

    final BufferedDiskCache this$0;
    final EncodedImage val$encodedImage;

    public void write(OutputStream outputstream)
        throws IOException
    {
        BufferedDiskCache.access$500(BufferedDiskCache.this).copy(val$encodedImage.getInputStream(), outputstream);
    }

    ()
    {
        this$0 = final_buffereddiskcache;
        val$encodedImage = EncodedImage.this;
        super();
    }
}
