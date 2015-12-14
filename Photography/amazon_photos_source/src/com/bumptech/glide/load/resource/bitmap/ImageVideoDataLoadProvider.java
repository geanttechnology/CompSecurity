// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.model.ImageVideoWrapperEncoder;
import com.bumptech.glide.provider.DataLoadProvider;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            ImageVideoBitmapDecoder

public class ImageVideoDataLoadProvider
    implements DataLoadProvider
{

    private final ResourceDecoder cacheDecoder;
    private final ResourceEncoder encoder;
    private final ImageVideoBitmapDecoder sourceDecoder;
    private final ImageVideoWrapperEncoder sourceEncoder;

    public ImageVideoDataLoadProvider(DataLoadProvider dataloadprovider, DataLoadProvider dataloadprovider1)
    {
        encoder = dataloadprovider.getEncoder();
        sourceEncoder = new ImageVideoWrapperEncoder(dataloadprovider.getSourceEncoder(), dataloadprovider1.getSourceEncoder());
        cacheDecoder = dataloadprovider.getCacheDecoder();
        sourceDecoder = new ImageVideoBitmapDecoder(dataloadprovider.getSourceDecoder(), dataloadprovider1.getSourceDecoder());
    }

    public ResourceDecoder getCacheDecoder()
    {
        return cacheDecoder;
    }

    public ResourceEncoder getEncoder()
    {
        return encoder;
    }

    public ResourceDecoder getSourceDecoder()
    {
        return sourceDecoder;
    }

    public Encoder getSourceEncoder()
    {
        return sourceEncoder;
    }
}
