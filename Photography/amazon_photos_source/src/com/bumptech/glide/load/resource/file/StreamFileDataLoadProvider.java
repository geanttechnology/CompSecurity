// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.file;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.NullResourceEncoder;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.file:
//            FileDecoder

public class StreamFileDataLoadProvider
    implements DataLoadProvider
{
    private static class ErrorSourceDecoder
        implements ResourceDecoder
    {

        public Resource decode(InputStream inputstream, int i, int j)
        {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        public volatile Resource decode(Object obj, int i, int j)
            throws IOException
        {
            return decode((InputStream)obj, i, j);
        }

        public String getId()
        {
            return "";
        }

        private ErrorSourceDecoder()
        {
        }

    }


    private static final ErrorSourceDecoder ERROR_DECODER = new ErrorSourceDecoder();
    private final ResourceDecoder cacheDecoder = new FileDecoder();
    private final Encoder encoder = new StreamEncoder();

    public StreamFileDataLoadProvider()
    {
    }

    public ResourceDecoder getCacheDecoder()
    {
        return cacheDecoder;
    }

    public ResourceEncoder getEncoder()
    {
        return NullResourceEncoder.get();
    }

    public ResourceDecoder getSourceDecoder()
    {
        return ERROR_DECODER;
    }

    public Encoder getSourceEncoder()
    {
        return encoder;
    }

}
