// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.amazon.mShop.ui:
//            WeakReferenceBitmapDrawable

public class WeakReferenceBitmapDrawableFactory
    implements DrawableFactory.DrawableFactoryInterface
{

    public static Bitmap sDefaultBitmap = null;

    public WeakReferenceBitmapDrawableFactory()
    {
    }

    public Drawable createDrawable(Resources resources, Bitmap bitmap, Bitmap bitmap1, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        Bitmap bitmap2 = bitmap1;
        if (bitmap1 == null)
        {
            bitmap2 = getDefaultBitmap(resources);
        }
        return new WeakReferenceBitmapDrawable(resources, bitmap, bitmap2, params);
    }

    public Drawable createDrawable(Resources resources, Bitmap bitmap, com.amazon.mShop.net.HttpFetcher.Params params)
    {
        return createDrawable(resources, bitmap, getDefaultBitmap(resources), params);
    }

    public Bitmap getDefaultBitmap(Resources resources)
    {
        Bitmap bitmap = null;
        if (sDefaultBitmap != null)
        {
            bitmap = sDefaultBitmap;
        }
        Bitmap bitmap1 = bitmap;
        if (bitmap == null)
        {
            bitmap1 = bitmap;
            if (resources != null)
            {
                resources = resources.getDrawable(com.amazon.mShop.android.lib.R.drawable.noimage);
                bitmap1 = bitmap;
                if (resources != null)
                {
                    bitmap1 = bitmap;
                    if (resources instanceof BitmapDrawable)
                    {
                        bitmap1 = ((BitmapDrawable)resources).getBitmap();
                        sDefaultBitmap = bitmap1;
                    }
                }
            }
        }
        return bitmap1;
    }

    public Drawable getDefaultDrawable(Resources resources)
    {
        Bitmap bitmap = getDefaultBitmap(resources);
        return new WeakReferenceBitmapDrawable(resources, bitmap, bitmap, null);
    }

    public void resetDefaultImage()
    {
        sDefaultBitmap = null;
    }

}
