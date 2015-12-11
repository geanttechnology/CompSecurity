// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.amazon.mShop.net.LRUCache;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.mShop.ui:
//            WeakReferenceBitmapDrawable

public static class mParams extends android.graphics.drawable.s
{

    public int mChangingConfigurations;
    private WeakReference mDefaultImage;
    private Paint mPaint;
    private com.amazon.mShop.net.Params mParams;
    private Resources mResource;
    public int mTargetDensity;

    public int getChangingConfigurations()
    {
        return mChangingConfigurations;
    }

    public Drawable newDrawable()
    {
        Bitmap bitmap = null;
        if (mParams != null)
        {
            bitmap = (Bitmap)LRUCache.getValue(mParams.Params(), android/graphics/Bitmap);
        }
        Bitmap bitmap1 = bitmap;
        if (bitmap == null)
        {
            bitmap1 = (Bitmap)mDefaultImage.get();
        }
        return new WeakReferenceBitmapDrawable(mResource, bitmap1, (Bitmap)mDefaultImage.get(), mParams);
    }



    public (WeakReferenceBitmapDrawable weakreferencebitmapdrawable, Bitmap bitmap, Bitmap bitmap1, Resources resources, com.amazon.mShop.net. )
    {
        mPaint = new Paint();
        mDefaultImage = new WeakReference(bitmap1);
        mResource = resources;
        if ( == null)
        {
            mParams = null;
        } else
        if ( instanceof com.amazon.mShop.net.Params)
        {
            bitmap = (com.amazon.mShop.net.Params);
            if (bitmap.Params() != null)
            {
                mParams = new com.amazon.mShop.net.Params(bitmap.Params(), weakreferencebitmapdrawable, bitmap.Params(), null, bitmap.Params(), bitmap.y());
                return;
            }
            if (bitmap.y() != null)
            {
                mParams = new com.amazon.mShop.net.Params(bitmap.Params(), weakreferencebitmapdrawable);
                return;
            }
        }
    }
}
