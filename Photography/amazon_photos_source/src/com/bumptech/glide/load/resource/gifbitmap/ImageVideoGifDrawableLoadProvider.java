// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapperResourceDecoder, GifBitmapWrapperStreamResourceDecoder, GifBitmapWrapperResourceEncoder

public class ImageVideoGifDrawableLoadProvider
    implements DataLoadProvider
{

    private final ResourceDecoder cacheDecoder;
    private final ResourceEncoder encoder;
    private final ResourceDecoder sourceDecoder;
    private final Encoder sourceEncoder;

    public ImageVideoGifDrawableLoadProvider(DataLoadProvider dataloadprovider, DataLoadProvider dataloadprovider1, BitmapPool bitmappool)
    {
        bitmappool = new GifBitmapWrapperResourceDecoder(dataloadprovider.getSourceDecoder(), dataloadprovider1.getSourceDecoder(), bitmappool);
        cacheDecoder = new FileToStreamDecoder(new GifBitmapWrapperStreamResourceDecoder(bitmappool));
        sourceDecoder = bitmappool;
        encoder = new GifBitmapWrapperResourceEncoder(dataloadprovider.getEncoder(), dataloadprovider1.getEncoder());
        sourceEncoder = dataloadprovider.getSourceEncoder();
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
