// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.graphics.drawable;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class CircleDrawable extends Drawable
{

    int mBackgroundColor;
    RectF mOvalRect;
    Paint mPaint;
    int mRadius;

    public CircleDrawable(int i, boolean flag)
    {
        mRadius = i;
        mOvalRect = new RectF(0.0F, 0.0F, i, i);
        mPaint = new Paint(1);
        mPaint.setColor(0xff000000);
        if (flag)
        {
            mPaint.setMaskFilter(new BlurMaskFilter(2.0F, android.graphics.BlurMaskFilter.Blur.NORMAL));
        }
    }

    public void draw(Canvas canvas)
    {
        RectF rectf = new RectF(getBounds());
        canvas.drawColor(mBackgroundColor);
        canvas.drawCircle(rectf.centerX(), rectf.centerY(), mRadius / 2, mPaint);
    }

    public int getOpacity()
    {
        return -1;
    }

    public void setAlpha(int i)
    {
    }

    public void setBackgroundColor(int i)
    {
        mBackgroundColor = i;
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
