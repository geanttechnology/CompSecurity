// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapper

public class GifBitmapWrapperResource
    implements Resource
{

    private final GifBitmapWrapper data;

    public GifBitmapWrapperResource(GifBitmapWrapper gifbitmapwrapper)
    {
        if (gifbitmapwrapper == null)
        {
            throw new NullPointerException("Data must not be null");
        } else
        {
            data = gifbitmapwrapper;
            return;
        }
    }

    public GifBitmapWrapper get()
    {
        return data;
    }

    public volatile Object get()
    {
        return get();
    }

    public int getSize()
    {
        return data.getSize();
    }

    public void recycle()
    {
        Resource resource = data.getBitmapResource();
        if (resource != null)
        {
            resource.recycle();
        }
        resource = data.getGifResource();
        if (resource != null)
        {
            resource.recycle();
        }
    }
}
