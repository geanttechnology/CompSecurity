// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class PreviewFillColorDrawable extends Drawable
{

    private boolean mChecked;
    int mColor;
    final Rect mDstRect = new Rect();
    LinearGradient mGradient;
    final Matrix mGradientMatrix = new Matrix();
    int mLightenColor;
    Paint mPaint;
    private boolean mPressed;
    float mRadius;
    boolean mRadiusFixed;
    int mStrokeColor;
    int mStrokeWidth;

    public PreviewFillColorDrawable(Context context)
    {
        mRadiusFixed = false;
        context = context.getTheme().obtainStyledAttributes(null, com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawable, com.aviary.android.feather.sdk.R.attr.aviaryPreviewFillDrawableStyle, 0);
        mStrokeWidth = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawable_aviary_strokeWidth, 20);
        mStrokeColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawable_aviary_strokeColor, 0xff000000);
        mRadius = (float)context.getInteger(com.aviary.android.feather.sdk.R.styleable.AviaryPreviewFillDrawable_aviary_radius, 50) / 100F;
        context.recycle();
        mPaint = new Paint(7);
        mPaint.setStyle(android.graphics.Paint.Style.FILL);
        context = android.graphics.Shader.TileMode.CLAMP;
        mGradient = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[] {
            -1, 0xff000000
        }, new float[] {
            0.5F, 1.0F
        }, context);
    }

    public void draw(Canvas canvas)
    {
        copyBounds(mDstRect);
        float f = mRadius;
        if (!mRadiusFixed)
        {
            f = (float)Math.min(mDstRect.width(), mDstRect.height()) * 0.5F * mRadius;
        }
        mPaint.setShader(null);
        mPaint.setMaskFilter(null);
        mPaint.setXfermode(null);
        mPaint.setMaskFilter(null);
        mPaint.setColor(mStrokeColor);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), (float)mStrokeWidth + f, mPaint);
        canvas.saveLayer(mDstRect.left, mDstRect.top, mDstRect.right, mDstRect.bottom, mPaint, 31);
        mPaint.setColor(mLightenColor);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY(), f, mPaint);
        mGradientMatrix.reset();
        mGradientMatrix.postScale(1.0F, 4F * f);
        mGradientMatrix.postTranslate(0.0F, (float)(mDstRect.centerY() + 2) - 2.0F * f);
        mGradient.setLocalMatrix(mGradientMatrix);
        mPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        mPaint.setColor(-1);
        mPaint.setShader(mGradient);
        canvas.drawCircle(mDstRect.centerX(), mDstRect.centerY() + 2, f, mPaint);
        canvas.restore();
    }

    public int getColor()
    {
        return mColor;
    }

    public int getOpacity()
    {
        return -3;
    }

    public float getRadius()
    {
        return mRadius;
    }

    public boolean isFixedRadius()
    {
        return mRadiusFixed;
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

        if (flag2 != mChecked || flag1 != mPressed)
        {
            flag = true;
        }
        return flag;
    }

    public void setAlpha(int i)
    {
    }

    public void setColor(int i)
    {
        mColor = i;
        float af[] = new float[3];
        Color.colorToHSV(i, af);
        int j = Color.red(i);
        int k = Color.green(i);
        i = Color.blue(i);
        mLightenColor = Color.argb(255, (int)((double)j * 0.5D + 127D), (int)((double)k * 0.5D + 127D), (int)((double)i * 0.5D + 127D));
        af[1] = af[1] * 1.1F;
        af[2] = af[2] * 0.3F;
        i = Color.HSVToColor(af);
        j = mColor;
        android.graphics.Shader.TileMode tilemode = android.graphics.Shader.TileMode.CLAMP;
        mGradient = new LinearGradient(0.0F, 0.0F, 0.0F, 1.0F, new int[] {
            j, i
        }, new float[] {
            0.0F, 1.0F
        }, tilemode);
        invalidateSelf();
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
        mRadius = f;
        invalidateSelf();
    }

    public void setSelected(boolean flag)
    {
    }
}
