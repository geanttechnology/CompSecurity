// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class GalleryBottomIndicatorDrawable extends Drawable
{

    final Rect destRect = new Rect();
    int mFillColor;
    float mIndicatorSize;
    int mShadowColor;
    int mShadowDy;
    int mStrokeColor1;
    int mStrokeColor2;
    int mStrokeWidth;
    final Paint paint = new Paint(1);

    public GalleryBottomIndicatorDrawable(Context context)
    {
        context = context.getTheme().obtainStyledAttributes(null, com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator, com.aviary.android.feather.sdk.R.attr.aviaryOptionPanelTopIndicatorStyle, 0);
        mShadowColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_android_shadowColor, 0);
        mShadowDy = (int)context.getFloat(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_android_shadowDy, 0.0F);
        mFillColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_color1, -1);
        mStrokeColor1 = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_strokeColor, -1);
        mStrokeColor2 = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_strokeColor2, -1);
        mIndicatorSize = context.getFloat(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_indicatorSize, 1.0F);
        mStrokeWidth = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_strokeWidth, 2);
        context.recycle();
    }

    public void draw(Canvas canvas)
    {
        copyBounds(destRect);
        int i = destRect.height() / 2;
        int j = destRect.width() / 2;
        int k = (int)((float)i * mIndicatorSize);
        int l = destRect.top + mStrokeWidth / 2;
        int i1 = destRect.left - mStrokeWidth;
        int j1 = destRect.right + mStrokeWidth;
        Path path = new Path();
        path.moveTo(i1, l);
        path.lineTo(j1, l);
        path.lineTo(j1, l + i);
        path.lineTo(i1 + j + k, l + i);
        path.lineTo(i1 + j, l + i + k);
        path.lineTo((i1 + j) - k, l + i);
        path.lineTo(i1, l + i);
        path.lineTo(i1, l);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        if (mShadowDy > 0)
        {
            path.offset(0.0F, mShadowDy);
            paint.setColor(mShadowColor);
            canvas.drawPath(path, paint);
            path.offset(0.0F, -mShadowDy);
        }
        paint.setColor(mFillColor);
        canvas.drawPath(path, paint);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setColor(mStrokeColor1);
        paint.setStrokeWidth(mStrokeWidth);
        canvas.drawPath(path, paint);
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setColor(mStrokeColor2);
        canvas.drawLine(mStrokeWidth + i1, mStrokeWidth + l, j1 - mStrokeWidth, mStrokeWidth + l, paint);
    }

    public int getOpacity()
    {
        return -3;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }
}
