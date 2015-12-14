// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            Downsampler, BitmapResource

public class StreamBitmapDecoder
    implements ResourceDecoder
{

    private BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private final Downsampler downsampler;
    private String id;

    public StreamBitmapDecoder(BitmapPool bitmappool, DecodeFormat decodeformat)
    {
        this(Downsampler.AT_LEAST, bitmappool, decodeformat);
    }

    public StreamBitmapDecoder(Downsampler downsampler1, BitmapPool bitmappool, DecodeFormat decodeformat)
    {
        downsampler = downsampler1;
        bitmapPool = bitmappool;
        decodeFormat = decodeformat;
    }

    public Resource decode(InputStream inputstream, int i, int j)
    {
        return BitmapResource.obtain(downsampler.decode(inputstream, bitmapPool, i, j, decodeFormat), bitmapPool);
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((InputStream)obj, i, j);
    }

    public String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder()).append("StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap").append(downsampler.getId()).append(decodeFormat.name()).toString();
        }
        return id;
    }
}
