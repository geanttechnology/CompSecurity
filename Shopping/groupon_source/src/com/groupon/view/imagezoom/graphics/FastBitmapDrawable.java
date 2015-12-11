// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.imagezoom.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import java.io.InputStream;

// Referenced classes of package com.groupon.view.imagezoom.graphics:
//            IBitmapDrawable

public class FastBitmapDrawable extends Drawable
    implements IBitmapDrawable
{

    private Bitmap mBitmap;
    private Paint mPaint;

    public FastBitmapDrawable(Resources resources, InputStream inputstream)
    {
        this(BitmapFactory.decodeStream(inputstream));
    }

    public FastBitmapDrawable(Bitmap bitmap)
    {
        mBitmap = bitmap;
        mPaint = new Paint();
        mPaint.setDither(true);
        mPaint.setFilterBitmap(true);
    }

    public void draw(Canvas canvas)
    {
        canvas.drawBitmap(mBitmap, 0.0F, 0.0F, mPaint);
    }

    public Bitmap getBitmap()
    {
        return mBitmap;
    }

    public int getIntrinsicHeight()
    {
        return mBitmap.getHeight();
    }

    public int getIntrinsicWidth()
    {
        return mBitmap.getWidth();
    }

    public int getMinimumHeight()
    {
        return mBitmap.getHeight();
    }

    public int getMinimumWidth()
    {
        return mBitmap.getWidth();
    }

    public int getOpacity()
    {
        return -3;
    }

    public void setAlpha(int i)
    {
        mPaint.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
        mPaint.setColorFilter(colorfilter);
    }
}
