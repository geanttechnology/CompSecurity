// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.Priority;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.data.DataFetcher;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifFrameModelLoader

private static class decoder
    implements DataFetcher
{

    private final GifDecoder decoder;

    public void cancel()
    {
    }

    public void cleanup()
    {
    }

    public String getId()
    {
        return String.valueOf(decoder.getCurrentFrameIndex());
    }

    public GifDecoder loadData(Priority priority)
    {
        return decoder;
    }

    public volatile Object loadData(Priority priority)
        throws Exception
    {
        return loadData(priority);
    }

    public (GifDecoder gifdecoder)
    {
        decoder = gifdecoder;
    }
}
