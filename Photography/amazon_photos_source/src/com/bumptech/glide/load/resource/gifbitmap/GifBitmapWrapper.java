// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.engine.Resource;

public class GifBitmapWrapper
{

    private final Resource bitmapResource;
    private final Resource gifResource;

    public GifBitmapWrapper(Resource resource, Resource resource1)
    {
        if (resource != null && resource1 != null)
        {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        }
        if (resource == null && resource1 == null)
        {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else
        {
            bitmapResource = resource;
            gifResource = resource1;
            return;
        }
    }

    public Resource getBitmapResource()
    {
        return bitmapResource;
    }

    public Resource getGifResource()
    {
        return gifResource;
    }

    public int getSize()
    {
        if (bitmapResource != null)
        {
            return bitmapResource.getSize();
        } else
        {
            return gifResource.getSize();
        }
    }
}
