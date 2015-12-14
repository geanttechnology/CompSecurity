// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifResourceDecoder, GifResourceEncoder

public class GifDrawableLoadProvider
    implements DataLoadProvider
{

    private final FileToStreamDecoder cacheDecoder;
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder = new StreamEncoder();

    public GifDrawableLoadProvider(Context context, BitmapPool bitmappool)
    {
        decoder = new GifResourceDecoder(context, bitmappool);
        cacheDecoder = new FileToStreamDecoder(decoder);
        encoder = new GifResourceEncoder(bitmappool);
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
