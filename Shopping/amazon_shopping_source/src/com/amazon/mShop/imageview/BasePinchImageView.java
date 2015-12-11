// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.imageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class BasePinchImageView extends ImageView
{

    private final Matrix mBaseMatrix = new Matrix();
    private Bitmap mBitmapDisplayed;
    private final Matrix mChangeMatrix = new Matrix();
    protected float mCurrentScaleFactor;
    private final Matrix mDisplayMatrix = new Matrix();
    private int mInitialImageHeight;
    private int mInitialImageWidth;
    private final float mMatrixValues[] = new float[9];

    public BasePinchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mInitialImageWidth = -1;
        mInitialImageHeight = -1;
        init();
    }

    private void center(boolean flag, boolean flag1)
    {
        RectF rectf;
        if (mBitmapDisplayed != null)
        {
            if ((rectf = getCenterRectF(flag, flag1)).left != 0.0F || rectf.top != 0.0F)
            {
                postTranslate(rectf.left, rectf.top);
                return;
            }
        }
    }

    private RectF getBitmapRect()
    {
        if (mBitmapDisplayed == null)
        {
            return null;
        } else
        {
            Matrix matrix = getImageViewMatrix();
            RectF rectf = new RectF(-getWidth() / 6, 0.0F, mBitmapDisplayed.getWidth() + getWidth() / 6, mBitmapDisplayed.getHeight());
            matrix.mapRect(rectf);
            return rectf;
        }
    }

    private RectF getCenterRectF(boolean flag, boolean flag1)
    {
        if (mBitmapDisplayed == null)
        {
            return new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        }
        RectF rectf = getBitmapRect();
        float f4 = rectf.height();
        float f3 = rectf.width();
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = f1;
        int i;
        if (flag1)
        {
            i = getHeight();
            if (f4 < (float)i)
            {
                f = ((float)i - f4) / 2.0F - rectf.top;
            } else
            if (rectf.top > 0.0F)
            {
                f = -rectf.top;
            } else
            {
                f = f1;
                if (rectf.bottom < (float)i)
                {
                    f = (float)getHeight() - rectf.bottom;
                }
            }
        }
        f1 = f2;
        if (flag)
        {
            i = getWidth();
            if (f3 < (float)i)
            {
                f1 = ((float)i - f3) / 2.0F - rectf.left;
            } else
            if (rectf.left > 0.0F)
            {
                f1 = -rectf.left;
            } else
            {
                f1 = f2;
                if (rectf.right < (float)i)
                {
                    f1 = (float)i - rectf.right;
                }
            }
        }
        return new RectF(f1, f, 0.0F, 0.0F);
    }

    public void clear()
    {
        setImageBitmap(null);
    }

    public Bitmap getDisplayBitmap()
    {
        return mBitmapDisplayed;
    }

    protected Matrix getImageViewMatrix()
    {
        mDisplayMatrix.set(mBaseMatrix);
        mDisplayMatrix.postConcat(mChangeMatrix);
        return mDisplayMatrix;
    }

    public float getScale()
    {
        mChangeMatrix.getValues(mMatrixValues);
        return mMatrixValues[0];
    }

    protected void init()
    {
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        if (mBitmapDisplayed != null)
        {
            prepareBaseMatrix(mBitmapDisplayed, mBaseMatrix);
            setImageMatrix(getImageViewMatrix());
        }
    }

    protected void panBy(float f, float f1)
    {
        RectF rectf = getBitmapRect();
        if (rectf == null)
        {
            return;
        } else
        {
            RectF rectf1 = new RectF(f, f1, 0.0F, 0.0F);
            updateRect(rectf, rectf1);
            postTranslate(rectf1.left, rectf1.top);
            center(true, true);
            return;
        }
    }

    protected void postScale(float f, float f1, float f2)
    {
        mChangeMatrix.postScale(f, f, f1, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postTranslate(float f, float f1)
    {
        mChangeMatrix.postTranslate(f, f1);
        setImageMatrix(getImageViewMatrix());
    }

    protected void prepareBaseMatrix(Bitmap bitmap, Matrix matrix)
    {
        float f1 = getWidth();
        float f2 = getHeight();
        float f3 = bitmap.getWidth();
        float f4 = bitmap.getHeight();
        float f;
        float f5;
        if (mInitialImageWidth == -1)
        {
            f = f1;
        } else
        {
            f = mInitialImageWidth;
        }
        f5 = f / f3;
        if (mInitialImageHeight == -1)
        {
            f = f2;
        } else
        {
            f = mInitialImageHeight;
        }
        f = Math.min(f5, f / f4);
        matrix.reset();
        matrix.postScale(f, f);
        matrix.postTranslate((f1 - f3 * f) / 2.0F, (f2 - f4 * f) / 2.0F);
    }

    public void scrollBy(float f, float f1)
    {
        panBy(f, f1);
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            drawable.setDither(true);
        }
        mBitmapDisplayed = bitmap;
        if (bitmap != null)
        {
            prepareBaseMatrix(bitmap, mBaseMatrix);
        } else
        {
            mBaseMatrix.reset();
        }
        mChangeMatrix.reset();
        setImageMatrix(getImageViewMatrix());
        mCurrentScaleFactor = 1.0F;
    }

    protected void setInitialImageDisplaySize(int i, int j)
    {
        mInitialImageWidth = i;
        mInitialImageHeight = j;
    }

    protected void updateRect(RectF rectf, RectF rectf1)
    {
        int i = getWidth();
        int j = getHeight();
        if (rectf.top >= 0.0F && rectf.bottom <= (float)j)
        {
            rectf1.top = 0.0F;
        }
        if (rectf.left >= 0.0F && rectf.right <= (float)i)
        {
            rectf1.left = 0.0F;
        }
        if (rectf.top + rectf1.top >= 0.0F && rectf.bottom > (float)j)
        {
            rectf1.top = 0.0F - rectf.top;
        }
        if (rectf.bottom + rectf1.top <= (float)j && rectf.top < 0.0F)
        {
            rectf1.top = (float)j - rectf.bottom;
        }
        if (rectf.left + rectf1.left >= 0.0F)
        {
            rectf1.left = 0.0F - rectf.left;
        }
        if (rectf.right + rectf1.left <= (float)i)
        {
            rectf1.left = (float)i - rectf.right;
        }
    }

    public void zoomTo(float f, float f1, float f2)
    {
        float f3 = f;
        if (f > 4F)
        {
            f3 = 4F;
        }
        postScale(f3 / getScale(), f1, f2);
        center(true, true);
    }
}
