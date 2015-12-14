// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;

// Referenced classes of package com.bumptech.glide.load.resource.transcode:
//            ResourceTranscoder

public class GifBitmapWrapperDrawableTranscoder
    implements ResourceTranscoder
{

    private final ResourceTranscoder bitmapDrawableResourceTranscoder;

    public GifBitmapWrapperDrawableTranscoder(ResourceTranscoder resourcetranscoder)
    {
        bitmapDrawableResourceTranscoder = resourcetranscoder;
    }

    public String getId()
    {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public Resource transcode(Resource resource)
    {
        resource = (GifBitmapWrapper)resource.get();
        Resource resource1 = resource.getBitmapResource();
        if (resource1 != null)
        {
            return bitmapDrawableResourceTranscoder.transcode(resource1);
        } else
        {
            return resource.getGifResource();
        }
    }
}
