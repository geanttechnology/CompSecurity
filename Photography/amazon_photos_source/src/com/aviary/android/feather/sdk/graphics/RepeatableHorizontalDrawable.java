// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.graphics;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

public class RepeatableHorizontalDrawable extends Drawable
{

    private Bitmap mBitmap;
    private Matrix mMatrix;
    private Paint mPaint;
    private Rect mRect;
    private Shader mShader;

    public RepeatableHorizontalDrawable(Resources resources, int i)
    {
        mPaint = new Paint();
        mRect = new Rect();
        mMatrix = new Matrix();
        mBitmap = null;
        try
        {
            init(((BitmapDrawable)resources.getDrawable(i)).getBitmap());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Resources resources)
        {
            return;
        }
    }

    public RepeatableHorizontalDrawable(Bitmap bitmap)
    {
        mPaint = new Paint();
        mRect = new Rect();
        mMatrix = new Matrix();
        mBitmap = null;
        init(bitmap);
    }

    public static Drawable createFromView(View view)
    {
        Drawable drawable = view.getBackground();
        view = drawable;
        if (drawable != null)
        {
            view = drawable;
            if (drawable instanceof BitmapDrawable)
            {
                view = new RepeatableHorizontalDrawable(((BitmapDrawable)drawable).getBitmap());
            }
        }
        return view;
    }

    private void init(Bitmap bitmap)
    {
        mBitmap = bitmap;
        if (mBitmap != null)
        {
            mShader = new BitmapShader(mBitmap, android.graphics.Shader.TileMode.REPEAT, android.graphics.Shader.TileMode.CLAMP);
            mPaint.setShader(mShader);
        }
    }

    public void draw(Canvas canvas)
    {
        if (mBitmap != null)
        {
            copyBounds(mRect);
            canvas.drawPaint(mPaint);
        }
    }

    public int getOpacity()
    {
        return -3;
    }

    protected void onBoundsChange(Rect rect)
    {
        super.onBoundsChange(rect);
        if (mBitmap != null)
        {
            mMatrix.setScale(1.0F, (float)rect.height() / (float)mBitmap.getHeight());
            mShader.setLocalMatrix(mMatrix);
        }
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
