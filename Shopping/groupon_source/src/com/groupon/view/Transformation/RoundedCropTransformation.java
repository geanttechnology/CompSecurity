// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.Transformation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import com.squareup.picasso.Transformation;

public class RoundedCropTransformation
    implements Transformation
{

    private final int backgroundColor = Color.parseColor("#FFFFFF");
    private final int strokeColor = Color.parseColor("#BBBBBB");
    private final float strokeWidth = 3F;

    public RoundedCropTransformation()
    {
    }

    private static Bitmap getRoundCroppedBitmap(Bitmap bitmap, int i, float f, int j, int k)
    {
        int l = i / 2;
        Bitmap bitmap1 = Bitmap.createBitmap(i, i, android.graphics.Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap1);
        Paint paint = new Paint();
        Paint paint1 = new Paint();
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        paint.setColor(j);
        paint1.setAntiAlias(true);
        paint1.setFilterBitmap(true);
        paint1.setDither(true);
        paint1.setColor(k);
        paint1.setStyle(android.graphics.Paint.Style.STROKE);
        paint1.setStrokeWidth(f);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(l, l, l, paint);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (i - bitmap.getWidth()) / 2, (i - bitmap.getHeight()) / 2, paint);
        canvas.drawCircle(l, l, (float)l - paint1.getStrokeWidth() / 2.0F, paint1);
        bitmap.recycle();
        return bitmap1;
    }

    public String key()
    {
        return String.format("RoundedCropTransformation()", new Object[0]);
    }

    public Bitmap transform(Bitmap bitmap)
    {
        return getRoundCroppedBitmap(bitmap, bitmap.getWidth(), 3F, backgroundColor, strokeColor);
    }
}
