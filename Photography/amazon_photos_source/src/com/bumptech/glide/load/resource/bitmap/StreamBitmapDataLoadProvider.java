// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            StreamBitmapDecoder, BitmapEncoder

public class StreamBitmapDataLoadProvider
    implements DataLoadProvider
{

    private final FileToStreamDecoder cacheDecoder;
    private final StreamBitmapDecoder decoder;
    private final BitmapEncoder encoder = new BitmapEncoder();
    private final StreamEncoder sourceEncoder = new StreamEncoder();

    public StreamBitmapDataLoadProvider(BitmapPool bitmappool, DecodeFormat decodeformat)
    {
        decoder = new StreamBitmapDecoder(bitmappool, decodeformat);
        cacheDecoder = new FileToStreamDecoder(decoder);
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
        return decoder;
    }

    public Encoder getSourceEncoder()
    {
        return sourceEncoder;
    }
}
