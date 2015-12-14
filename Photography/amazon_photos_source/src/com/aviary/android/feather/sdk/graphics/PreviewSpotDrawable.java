// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class PreviewSpotDrawable extends Drawable
{

    private static final String LOG_TAG = "PreviewSpotDrawable";
    static final float RADIUS_PERC_MULTIPLIER = 0.8F;
    static final double STROKE_WIDTH_MULTIPLIER = 1.7D;
    final int mBackgroundColorSelected;
    final int mBackgroundColorUnselected;
    private boolean mChecked;
    final Rect mDstRect = new Rect();
    final BlurMaskFilter mGlowBlurMaskFilter;
    final int mGlowColor;
    LinearGradient mGradient;
    final Matrix mGradientMatrix = new Matrix();
    final LinearGradient mGradientShaderSelected;
    final LinearGradient mGradientShaderUnselected;
    final Paint mPaint = new Paint(7);
    private Xfermode mPorterDuffSrcInMode;
    private boolean mPressed;
    float mRadius;
    boolean mRadiusFixed;
    final int mStrokeColor;
    final int mStrokeWidth;
    final int mStrokeWidthOuter;

    public PreviewSpotDrawable(Context context)
    {
        mRadiusFixed = false;
        mPorterDuffSrcInMode = new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN);
        context = context.getTheme().obtainStyledAttributes(null, com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable, com.aviary.android.feather.sdk.R.attr.aviaryPreviewSpotDrawableStyle, 0);
        mStrokeWidth = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_strokeWidth, 20);
        mStrokeWidthOuter = (int)((double)mStrokeWidth * 1.7D);
        int i = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_color1, -1);
        int j = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_color2, 0xff000000);
        int k = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_color3, 0xff000000);
        int l = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_color4, -1);
        mGlowColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_highlightColorChecked, -1);
        mBackgroundColorUnselected = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_bg_color1, -1);
        mBackgroundColorSelected = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_bg_color2, 0xff000000);
        mStrokeColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_strokeColor, 0xff000000);
        int i1 = context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewSpotDrawable_aviary_glowSize, 3);
        context.recycle();
        mPaint.setStyle(android.graphics.Paint.Style.STROKE);
        context = android.graphics.Shader.TileMode.CLAMP;
        mGradientShaderUnselected = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[] {
            i, j
        }, new float[] {
            0.5F, 1.0F
        }, context);
        context = android.graphics.Shader.TileMode.CLAMP;
        mGradientShaderSelected = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[] {
            k, l
        }, new float[] {
            0.5F, 1.0F
        }, context);
        mGradient = mGradientShaderUnselected;
        mGlowBlurMaskFilter = new BlurMaskFilter(i1, android.graphics.BlurMaskFilter.Blur.NORMAL);
        mGradientShaderUnselected.setLocalMatrix(mGradientMatrix);
        mRadius = 10F;
    }

    public void draw(Canvas canvas)
    {
        copyBounds(mDstRect);
        float f = mRadius;
        if (!mRadiusFixed)
        {
            f = (float)Math.min(mDstRect.width(), mDstRect.height()) * 0.8F * mRadius;
        }
        mPaint.setShader(null);
        mPaint.setMaskFilter(null);
        mPaint.setXfermode(null);
        if (mChecked)
        {
            mPaint.setStrokeWidth(mStrokeWidth);
            mPaint.setMaskFilter(mGlowBlurMaskFilter);
            mPaint.setColor(mGlowColor);
            canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), f, mPaint);
        }
        mPaint.setStrokeWidth(mStrokeWidthOuter);
        mPaint.setMaskFilter(null);
        mPaint.setColor(mStrokeColor);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), f, mPaint);
        canvas.saveLayer(mDstRect.left, mDstRect.top, mDstRect.right, mDstRect.bottom, mPaint, 31);
        mPaint.setStrokeWidth(mStrokeWidth);
        Paint paint = mPaint;
        int i;
        if (mChecked)
        {
            i = mBackgroundColorSelected;
        } else
        {
            i = mBackgroundColorUnselected;
        }
        paint.setColor(i);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), f, mPaint);
        mGradientMatrix.reset();
        mGradientMatrix.postScale(1.0F, f * 2.0F);
        mGradientMatrix.postTranslate(0.0F, (float)(mDstRect.centerY() + 3) - f * 2.0F);
        mGradient.setLocalMatrix(mGradientMatrix);
        mPaint.setXfermode(mPorterDuffSrcInMode);
        mPaint.setColor(-1);
        mPaint.setShader(mGradient);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY() + 3, f, mPaint);
        canvas.restore();
    }

    public int getOpacity()
    {
        return -3;
    }

    public boolean isStateful()
    {
        return true;
    }

    protected boolean onStateChange(int ai[])
    {
        boolean flag = false;
        boolean flag2 = mChecked;
        boolean flag1 = mPressed;
        mChecked = false;
        mPressed = false;
        for (int i = 0; i < ai.length; i++)
        {
            if (ai[i] == 0x10100a7)
            {
                mPressed = true;
            }
            if (ai[i] == 0x10100a1)
            {
                mChecked = true;
            }
        }

        if (mChecked)
        {
            mGradient = mGradientShaderSelected;
        } else
        {
            mGradient = mGradientShaderUnselected;
        }
        if (flag2 != mChecked || flag1 != mPressed)
        {
            flag = true;
        }
        return flag;
    }

    public void setAlpha(int i)
    {
    }

    public void setColorFilter(ColorFilter colorfilter)
    {
    }

    public void setFixedRadius(float f)
    {
        mRadiusFixed = true;
        mRadius = f;
        invalidateSelf();
    }

    public void setRadius(float f)
    {
        Log.i("PreviewSpotDrawable", (new StringBuilder()).append("setRadius: ").append(f).toString());
        mRadius = f;
        invalidateSelf();
    }
}
