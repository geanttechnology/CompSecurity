// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            BitmapTransformation, TransformationUtils

public class FitCenter extends BitmapTransformation
{

    public FitCenter(BitmapPool bitmappool)
    {
        super(bitmappool);
    }

    public String getId()
    {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    protected Bitmap transform(BitmapPool bitmappool, Bitmap bitmap, int i, int j)
    {
        return TransformationUtils.fitCenter(bitmap, bitmappool, i, j);
    }
}
