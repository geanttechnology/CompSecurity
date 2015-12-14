// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

// Referenced classes of package com.bumptech.glide.load.resource.bitmap:
//            GlideBitmapDrawable

static class targetDensity extends android.graphics.drawable.e.BitmapState
{

    private static final Paint DEFAULT_PAINT = new Paint(6);
    final Bitmap bitmap;
    Paint paint;
    int targetDensity;

    public int getChangingConfigurations()
    {
        return 0;
    }

    void mutatePaint()
    {
        if (DEFAULT_PAINT == paint)
        {
            paint = new Paint(6);
        }
    }

    public Drawable newDrawable()
    {
        return new GlideBitmapDrawable(null, this);
    }

    public Drawable newDrawable(Resources resources)
    {
        return new GlideBitmapDrawable(resources, this);
    }

    void setAlpha(int i)
    {
        mutatePaint();
        paint.setAlpha(i);
    }

    void setColorFilter(ColorFilter colorfilter)
    {
        mutatePaint();
        paint.setColorFilter(colorfilter);
    }


    public (Bitmap bitmap1)
    {
        paint = DEFAULT_PAINT;
        bitmap = bitmap1;
    }

    bitmap(bitmap bitmap1)
    {
        this(bitmap1.bitmap);
        targetDensity = bitmap1.targetDensity;
    }
}
