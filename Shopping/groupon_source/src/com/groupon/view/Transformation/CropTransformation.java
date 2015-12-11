// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.Transformation;

import android.graphics.Bitmap;
import com.squareup.picasso.Transformation;

public class CropTransformation
    implements Transformation
{

    private final int height;
    private final int width;

    public CropTransformation(int i, int j)
    {
        width = i;
        height = j;
    }

    public String key()
    {
        return (new StringBuilder()).append("cropPosterTransformation").append(width).toString();
    }

    public Bitmap transform(Bitmap bitmap)
    {
        double d = (double)bitmap.getHeight() / (double)bitmap.getWidth();
        int i = (int)((double)width * d);
        Bitmap bitmap1 = Bitmap.createScaledBitmap(bitmap, width, i, false);
        if (bitmap1 != bitmap)
        {
            bitmap.recycle();
        }
        bitmap = Bitmap.createBitmap(bitmap1, 0, (int)((double)bitmap1.getHeight() / 2D - (double)height / 2D), width, height);
        if (bitmap1 != bitmap)
        {
            bitmap1.recycle();
        }
        return bitmap;
    }
}
