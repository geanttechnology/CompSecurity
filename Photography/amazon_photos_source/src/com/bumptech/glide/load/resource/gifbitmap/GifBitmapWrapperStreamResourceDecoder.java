// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;
import java.io.InputStream;

public class GifBitmapWrapperStreamResourceDecoder
    implements ResourceDecoder
{

    private final ResourceDecoder gifBitmapDecoder;

    public GifBitmapWrapperStreamResourceDecoder(ResourceDecoder resourcedecoder)
    {
        gifBitmapDecoder = resourcedecoder;
    }

    public Resource decode(InputStream inputstream, int i, int j)
        throws IOException
    {
        return gifBitmapDecoder.decode(new ImageVideoWrapper(inputstream, null), i, j);
    }

    public volatile Resource decode(Object obj, int i, int j)
        throws IOException
    {
        return decode((InputStream)obj, i, j);
    }

    public String getId()
    {
        return gifBitmapDecoder.getId();
    }
}
