// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            StreamBitmapDecoder, FileDescriptorBitmapDecoder, BitmapEncoder

public class FileDescriptorBitmapDataLoadProvider
    implements DataLoadProvider
{

    private final ResourceDecoder cacheDecoder;
    private final BitmapEncoder encoder = new BitmapEncoder();
    private final FileDescriptorBitmapDecoder sourceDecoder;
    private final Encoder sourceEncoder = NullEncoder.get();

    public FileDescriptorBitmapDataLoadProvider(BitmapPool bitmappool, DecodeFormat decodeformat)
    {
        cacheDecoder = new FileToStreamDecoder(new StreamBitmapDecoder(bitmappool, decodeformat));
        sourceDecoder = new FileDescriptorBitmapDecoder(bitmappool, decodeformat);
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
