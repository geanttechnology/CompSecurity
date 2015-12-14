// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class GalleryTopIndicatorDrawable extends Drawable
{

    static final int DIRECTION_BOTTOM_TOP = 2;
    static final int DIRECTION_TOP_DOWN = 1;
    static final String LOG_TAG = "gallery-top-indicator";
    final Rect destRect;
    int mDirection;
    int mFillColor;
    float mIndicatorSize;
    Matrix mMatrix;
    int mMinHeight;
    int mOffsetY;
    int mShadowColor;
    int mShadowDy;
    int mStrokeColor1;
    int mStrokeColor2;
    int mStrokeWidth;
    final Paint paint;

    public GalleryTopIndicatorDrawable(Context context)
    {
        this(context, com.aviary.android.feather.sdk.R.attr.aviaryOptionPanelTopIndicatorStyle, 0);
    }

    public GalleryTopIndicatorDrawable(Context context, int i)
    {
        this(context, i, 0);
    }

    public GalleryTopIndicatorDrawable(Context context, int i, int j)
    {
        mMatrix = new Matrix();
        destRect = new Rect();
        context = context.getTheme().obtainStyledAttributes(null, com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator, i, j);
        Log.d("gallery-top-indicator", (new StringBuilder()).append("defaultStyle: ").append(i).toString());
        mShadowColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_android_shadowColor, 0);
        mShadowDy = (int)context.getFloat(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_android_shadowDy, 0.0F);
        mFillColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_color1, -1);
        mStrokeColor1 = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_strokeColor, -1);
        mStrokeColor2 = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_strokeColor2, -1);
        mIndicatorSize = context.getFloat(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_indicatorSize, 1.0F);
        mStrokeWidth = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_strokeWidth, 2);
        mDirection = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_direction, 1);
        mOffsetY = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_aviary_offsety, 0);
        mMinHeight = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryGalleryTopIndicator_android_minHeight, 0);
        Log.i("gallery-top-indicator", (new StringBuilder()).append("strokeWidth: ").append(mStrokeWidth).toString());
        Log.i("gallery-top-indicator", (new StringBuilder()).append("direction: ").append(mDirection).toString());
        Log.i("gallery-top-indicator", (new StringBuilder()).append("offset: ").append(mOffsetY).toString());
        context.recycle();
        paint = new Paint(1);
    }

    public void draw(Canvas canvas)
    {
        copyBounds(destRect);
        int i1 = destRect.height() / 2;
        int i = destRect.width() / 2;
        int j = (int)((float)i1 * mIndicatorSize);
        int j1 = destRect.top + mStrokeWidth / 2;
        int k = destRect.left - mStrokeWidth;
        int l = destRect.right + mStrokeWidth;
        Path path = new Path();
        path.moveTo(k, j1);
        path.lineTo(l, j1);
        path.lineTo(l, j1 + i1);
        path.lineTo(k + i + j, j1 + i1);
        path.lineTo(k + i, j1 + i1 + j);
        path.lineTo((k + i) - j, j1 + i1);
        path.lineTo(k, j1 + i1);
        path.lineTo(k, j1);
        if (mDirection == 2)
        {
            mMatrix.reset();
            mMatrix.setScale(1.0F, -1F, 0.0F, destRect.height() / 2);
            mMatrix.postTranslate(0.0F, mOffsetY);
            canvas.save(1);
            canvas.concat(mMatrix);
        }
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
        if (mDirection == 1)
        {
            canvas.drawLine(mStrokeWidth + k, mStrokeWidth + j1, l - mStrokeWidth, mStrokeWidth + j1, paint);
            return;
        } else
        {
            i1 = (j1 + i1) - mStrokeWidth;
            canvas.drawLine(k, i1, (k + i) - j, i1, paint);
            canvas.drawLine(k + i + j, i1, l, i1, paint);
            canvas.restore();
            return;
        }
    }

    public int getIntrinsicHeight()
    {
        return mMinHeight;
    }

    public int getMinimumHeight()
    {
        return mMinHeight;
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
