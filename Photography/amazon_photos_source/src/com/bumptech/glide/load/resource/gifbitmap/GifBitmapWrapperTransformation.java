// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;

// Referenced classes of package com.bumptech.glide.load.resource.gifbitmap:
//            GifBitmapWrapper, GifBitmapWrapperResource

public class GifBitmapWrapperTransformation
    implements Transformation
{

    private final Transformation bitmapTransformation;
    private final Transformation gifDataTransformation;

    GifBitmapWrapperTransformation(Transformation transformation, Transformation transformation1)
    {
        bitmapTransformation = transformation;
        gifDataTransformation = transformation1;
    }

    public GifBitmapWrapperTransformation(BitmapPool bitmappool, Transformation transformation)
    {
        this(transformation, ((Transformation) (new GifDrawableTransformation(transformation, bitmappool))));
    }

    public String getId()
    {
        return bitmapTransformation.getId();
    }

    public Resource transform(Resource resource, int i, int j)
    {
        Resource resource1 = ((GifBitmapWrapper)resource.get()).getBitmapResource();
        Resource resource3 = ((GifBitmapWrapper)resource.get()).getGifResource();
        Object obj;
        if (resource1 != null && bitmapTransformation != null)
        {
            resource3 = bitmapTransformation.transform(resource1, i, j);
            obj = resource;
            if (!resource1.equals(resource3))
            {
                obj = new GifBitmapWrapperResource(new GifBitmapWrapper(resource3, ((GifBitmapWrapper)resource.get()).getGifResource()));
            }
        } else
        {
            obj = resource;
            if (resource3 != null)
            {
                obj = resource;
                if (gifDataTransformation != null)
                {
                    Resource resource2 = gifDataTransformation.transform(resource3, i, j);
                    obj = resource;
                    if (!resource3.equals(resource2))
                    {
                        return new GifBitmapWrapperResource(new GifBitmapWrapper(((GifBitmapWrapper)resource.get()).getBitmapResource(), resource2));
                    }
                }
            }
        }
        return ((Resource) (obj));
    }
}
