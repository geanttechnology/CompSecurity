// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

// Referenced classes of package com.bumptech.glide.load.resource.gif:
//            GifDrawable

public class GifDrawableTransformation
    implements Transformation
{

    private final BitmapPool bitmapPool;
    private final Transformation wrapped;

    public GifDrawableTransformation(Transformation transformation, BitmapPool bitmappool)
    {
        wrapped = transformation;
        bitmapPool = bitmappool;
    }

    public String getId()
    {
        return wrapped.getId();
    }

    public Resource transform(Resource resource, int i, int j)
    {
        GifDrawable gifdrawable = (GifDrawable)resource.get();
        Object obj = new BitmapResource(((GifDrawable)resource.get()).getFirstFrame(), bitmapPool);
        Resource resource1 = wrapped.transform(((Resource) (obj)), i, j);
        if (!obj.equals(resource1))
        {
            ((Resource) (obj)).recycle();
        }
        obj = (Bitmap)resource1.get();
        gifdrawable.setFrameTransformation(wrapped, ((Bitmap) (obj)));
        return resource;
    }
}
