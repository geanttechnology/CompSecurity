// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.Transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import com.squareup.picasso.Transformation;

public class AspectScaleTransformation
    implements Transformation
{

    private final int width;

    public AspectScaleTransformation(int i)
    {
        width = i;
    }

    public String key()
    {
        return "aspect_scale_transformation";
    }

    public Bitmap transform(Bitmap bitmap)
    {
        int i = (int)Math.floor((bitmap.getHeight() * width) / bitmap.getWidth());
        Bitmap bitmap1 = Bitmap.createBitmap(width, i, android.graphics.Bitmap.Config.ARGB_8888);
        float f = (float)width / (float)bitmap.getWidth();
        float f1 = (float)i / (float)bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.setScale(f, f1, 0.0F, 0.0F);
        Canvas canvas = new Canvas(bitmap1);
        canvas.setMatrix(matrix);
        canvas.drawBitmap(bitmap, 0.0F, 0.0F, new Paint(2));
        if (bitmap1 != bitmap)
        {
            bitmap.recycle();
        }
        return bitmap1;
    }
}
