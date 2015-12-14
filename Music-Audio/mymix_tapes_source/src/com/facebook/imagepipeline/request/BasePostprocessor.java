// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.request;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.nativecode.Bitmaps;

// Referenced classes of package com.facebook.imagepipeline.request:
//            Postprocessor

public abstract class BasePostprocessor
    implements Postprocessor
{

    public BasePostprocessor()
    {
    }

    public String getName()
    {
        return "Unknown postprocessor";
    }

    public CacheKey getPostprocessorCacheKey()
    {
        return null;
    }

    public CloseableReference process(Bitmap bitmap, PlatformBitmapFactory platformbitmapfactory)
    {
        platformbitmapfactory = platformbitmapfactory.createBitmap(bitmap.getWidth(), bitmap.getHeight());
        process((Bitmap)platformbitmapfactory.get(), bitmap);
        bitmap = CloseableReference.cloneOrNull(platformbitmapfactory);
        CloseableReference.closeSafely(platformbitmapfactory);
        return bitmap;
        bitmap;
        CloseableReference.closeSafely(platformbitmapfactory);
        throw bitmap;
    }

    public void process(Bitmap bitmap)
    {
    }

    public void process(Bitmap bitmap, Bitmap bitmap1)
    {
        Bitmaps.copyBitmap(bitmap, bitmap1);
        process(bitmap);
    }
}
