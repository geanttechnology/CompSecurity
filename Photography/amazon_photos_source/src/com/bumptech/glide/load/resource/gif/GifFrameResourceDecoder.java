// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.io.IOException;

class GifFrameResourceDecoder
    implements ResourceDecoder
{

    private final BitmapPool bitmapPool;

    public GifFrameResourceDecoder(BitmapPool bitmappool)
    {
        bitmapPool = bitmappool;
    }

    public Resource decode(GifDecoder gifdecoder, int i, int j)
    {
        return BitmapResource.obtain(gifdecoder.getNextFrame(), bitmapPool);
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((GifDecoder)obj, i, j);
    }

    public String getId()
    {
        return "GifFrameResourceDecoder.com.bumptech.glide.load.resource.gif";
    }
}
