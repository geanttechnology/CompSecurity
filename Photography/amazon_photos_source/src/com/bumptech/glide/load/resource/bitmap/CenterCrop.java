// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            BitmapTransformation, TransformationUtils

public class CenterCrop extends BitmapTransformation
{

    public CenterCrop(BitmapPool bitmappool)
    {
        super(bitmappool);
    }

    public String getId()
    {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }

    protected Bitmap transform(BitmapPool bitmappool, Bitmap bitmap, int i, int j)
    {
        Object obj;
        if (bitmap.getConfig() != null)
        {
            obj = bitmap.getConfig();
        } else
        {
            obj = android.graphics.Bitmap.Config.ARGB_8888;
        }
        obj = bitmappool.get(i, j, ((android.graphics.Bitmap.Config) (obj)));
        bitmap = TransformationUtils.centerCrop(((Bitmap) (obj)), bitmap, i, j);
        if (obj != null && obj != bitmap && !bitmappool.put(((Bitmap) (obj))))
        {
            ((Bitmap) (obj)).recycle();
        }
        return bitmap;
    }
}
