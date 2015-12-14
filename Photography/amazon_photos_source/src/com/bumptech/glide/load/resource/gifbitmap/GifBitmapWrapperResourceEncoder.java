// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.OutputStream;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapper

public class GifBitmapWrapperResourceEncoder
    implements ResourceEncoder
{

    private final ResourceEncoder bitmapEncoder;
    private final ResourceEncoder gifEncoder;
    private String id;

    public GifBitmapWrapperResourceEncoder(ResourceEncoder resourceencoder, ResourceEncoder resourceencoder1)
    {
        bitmapEncoder = resourceencoder;
        gifEncoder = resourceencoder1;
    }

    public boolean encode(Resource resource, OutputStream outputstream)
    {
        resource = (GifBitmapWrapper)resource.get();
        Resource resource1 = resource.getBitmapResource();
        if (resource1 != null)
        {
            return bitmapEncoder.encode(resource1, outputstream);
        } else
        {
            return gifEncoder.encode(resource.getGifResource(), outputstream);
        }
    }

    public volatile boolean encode(Object obj, OutputStream outputstream)
    {
        return encode((Resource)obj, outputstream);
    }

    public String getId()
    {
        if (id == null)
        {
            id = (new StringBuilder()).append(bitmapEncoder.getId()).append(gifEncoder.getId()).toString();
        }
        return id;
    }
}
