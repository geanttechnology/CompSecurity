// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            BitmapResource

public abstract class BitmapTransformation
    implements Transformation
{

    private BitmapPool bitmapPool;

    public BitmapTransformation(BitmapPool bitmappool)
    {
        bitmapPool = bitmappool;
    }

    protected abstract Bitmap transform(BitmapPool bitmappool, Bitmap bitmap, int i, int j);

    public final Resource transform(Resource resource, int i, int j)
    {
        if (!Util.isValidDimensions(i, j))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Cannot apply transformation on width: ").append(i).append(" or height: ").append(j).append(" less than or equal to zero and not Target.SIZE_ORIGINAL").toString());
        }
        Bitmap bitmap = (Bitmap)resource.get();
        if (i == 0x80000000)
        {
            i = bitmap.getWidth();
        }
        if (j == 0x80000000)
        {
            j = bitmap.getHeight();
        }
        Bitmap bitmap1 = transform(bitmapPool, bitmap, i, j);
        if (bitmap.equals(bitmap1))
        {
            return resource;
        } else
        {
            return BitmapResource.obtain(bitmap1, bitmapPool);
        }
    }
}
