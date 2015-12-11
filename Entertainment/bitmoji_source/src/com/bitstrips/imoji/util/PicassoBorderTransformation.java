// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.squareup.picasso.Transformation;

public class PicassoBorderTransformation
    implements Transformation
{

    private int mBorderSize;
    private int mColor;
    private int mCornerRadius;

    public PicassoBorderTransformation(int i)
    {
        mCornerRadius = 0;
        mBorderSize = 0;
        mCornerRadius = i;
        mColor = 0;
    }

    public PicassoBorderTransformation(int i, int j)
    {
        mCornerRadius = 0;
        mBorderSize = i;
        mColor = j;
    }

    public PicassoBorderTransformation(int i, int j, int k)
    {
        mCornerRadius = 0;
        mBorderSize = i;
        mCornerRadius = j;
        mColor = k;
    }

    public String key()
    {
        return (new StringBuilder()).append("bitmapBorder(borderSize=").append(mBorderSize).append(", ").append("cornerRadius=").append(mCornerRadius).append(", ").append("color=").append(mColor).append(")").toString();
    }

    public Bitmap transform(Bitmap bitmap)
    {
        int j = bitmap.getWidth();
        int i = bitmap.getHeight() + 50;
        Bitmap bitmap1 = Bitmap.createBitmap(j, i, bitmap.getConfig());
        Canvas canvas = new Canvas(bitmap1);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint(1);
        Rect rect = new Rect(0, 0, j, i);
        if (mCornerRadius == 0)
        {
            canvas.drawRect(rect, paint);
        } else
        {
            canvas.drawRoundRect(new RectF(rect), mCornerRadius, mCornerRadius, paint);
        }
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        if (mBorderSize != 0)
        {
            j += mBorderSize * 2;
            i += mBorderSize * 2;
            Bitmap bitmap2 = Bitmap.createBitmap(j, i, bitmap.getConfig());
            canvas.setBitmap(bitmap2);
            canvas.drawARGB(0, 0, 0, 0);
            Rect rect1 = new Rect(0, 0, j, i);
            paint.setXfermode(null);
            paint.setColor(mColor);
            paint.setStyle(android.graphics.Paint.Style.FILL);
            canvas.drawRoundRect(new RectF(rect1), mCornerRadius, mCornerRadius, paint);
            canvas.drawBitmap(bitmap1, mBorderSize, mBorderSize, null);
            bitmap1 = bitmap2;
        }
        if (bitmap != bitmap1)
        {
            bitmap.recycle();
        }
        return Bitmap.createBitmap(bitmap1, 0, 0, j, i - 50 - mBorderSize);
    }
}
