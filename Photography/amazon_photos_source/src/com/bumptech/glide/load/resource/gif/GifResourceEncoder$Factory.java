// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifResourceEncoder

static class 
{

    public GifDecoder buildDecoder(com.bumptech.glide.gifdecoder.actory actory)
    {
        return new GifDecoder(actory);
    }

    public AnimatedGifEncoder buildEncoder()
    {
        return new AnimatedGifEncoder();
    }

    public Resource buildFrameResource(Bitmap bitmap, BitmapPool bitmappool)
    {
        return new BitmapResource(bitmap, bitmappool);
    }

    public GifHeaderParser buildParser()
    {
        return new GifHeaderParser();
    }

    ()
    {
    }
}
