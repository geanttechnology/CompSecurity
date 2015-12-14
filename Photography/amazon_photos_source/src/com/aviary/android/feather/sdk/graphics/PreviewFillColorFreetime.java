// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

// Referenced classes of package com.aviary.android.feather.sdk.graphics:
//            PreviewFillColorDrawable

public class PreviewFillColorFreetime extends PreviewFillColorDrawable
{

    private float mRadiusSelected;
    private boolean selected;

    public PreviewFillColorFreetime(Context context)
    {
        super(context);
        context = context.getTheme().obtainStyledAttributes(null, com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawableFreetime, com.aviary.android.feather.sdk.R.attr.aviaryPreviewFillDrawableStyleFreetime, 0);
        mStrokeWidth = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawableFreetime_aviary_strokeWidth, 20);
        mStrokeColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawableFreetime_aviary_strokeColor, -1);
        mRadius = (float)context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawableFreetime_aviary_radius_ft, 50) / 100F;
        mRadiusSelected = (float)context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawableFreetime_aviary_radius_ft_selected, 60) / 100F;
        context.recycle();
    }

    private float getAdjustedRadius(float f)
    {
        return (float)Math.min(mDstRect.width(), mDstRect.height()) * 0.5F * f;
    }

    public void draw(Canvas canvas)
    {
        copyBounds(mDstRect);
        float f = mRadius;
        if (!mRadiusFixed)
        {
            f = getAdjustedRadius(mRadius);
        }
        mPaint.setShader(null);
        mPaint.setMaskFilter(null);
        mPaint.setXfermode(null);
        if (selected)
        {
            f = getAdjustedRadius(mRadiusSelected);
            mPaint.setMaskFilter(null);
            mPaint.setColor(mStrokeColor);
            mPaint.setStyle(android.graphics.Paint.Style.STROKE);
            mPaint.setStrokeWidth(mStrokeWidth);
            canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), (float)mStrokeWidth + f, mPaint);
        }
        canvas.saveLayer(mDstRect.left, mDstRect.top, mDstRect.right, mDstRect.bottom, mPaint, 31);
        mPaint.setColor(mColor);
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), f, mPaint);
        canvas.restore();
    }

    public void setColor(int i)
    {
        mColor = i;
        invalidateSelf();
    }

    public void setSelected(boolean flag)
    {
        selected = flag;
    }
}
