// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import com.squareup.picasso.Transformation;

public final class l
    implements Transformation
{

    private int a;

    public l(int i)
    {
        a = i;
    }

    public final String key()
    {
        return "circle_border";
    }

    public final Bitmap transform(Bitmap bitmap)
    {
        if (bitmap == null || bitmap.isRecycled())
        {
            return null;
        } else
        {
            int i = bitmap.getWidth();
            int j = bitmap.getHeight();
            int k = Math.min(j / 2, i / 2);
            Bitmap bitmap1 = Bitmap.createBitmap(i + 8, j + 8, android.graphics.Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(bitmap1);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawCircle(i / 2 + 4, j / 2 + 4, k, paint);
            paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, 4F, 4F, paint);
            paint.setXfermode(null);
            paint.setStyle(android.graphics.Paint.Style.STROKE);
            paint.setColor(a);
            paint.setStrokeWidth(5F);
            canvas.drawCircle(i / 2 + 4, j / 2 + 4, k, paint);
            bitmap.recycle();
            return bitmap1;
        }
    }
}
