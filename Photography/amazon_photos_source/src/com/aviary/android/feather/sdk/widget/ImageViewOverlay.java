// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import com.aviary.android.feather.headless.moa.MoaAction;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaPointParameter;
import com.aviary.android.feather.headless.moa.MoaRectParameter;
import com.aviary.android.feather.library.filters.OverlayFilter;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;

public class ImageViewOverlay extends ImageViewTouch
{

    private static final int MAX_VIEWPORT_SIZE = 2048;
    protected Matrix mBaseMatrix2;
    RectF mCanvasClipRect;
    protected Matrix mDisplayMatrix2;
    protected Matrix mDrawMatrix2;
    protected Matrix mMatrix2;
    protected RectF mOverlayBitmapRect;
    private boolean mOverlayChanged;
    protected Drawable mOverlayDrawable;
    private int mOverlayDrawableHeight;
    private int mOverlayDrawableWidth;
    protected Drawable mOverlayTempDrawable;
    protected Matrix mSuppMatrix2;
    private RectF mTempViewPort;

    public ImageViewOverlay(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mBaseMatrix2 = new Matrix();
        mSuppMatrix2 = new Matrix();
        mDisplayMatrix2 = new Matrix();
        mMatrix2 = new Matrix();
        mOverlayBitmapRect = new RectF();
        mCanvasClipRect = new RectF();
        mTempViewPort = new RectF();
    }

    public ImageViewOverlay(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mBaseMatrix2 = new Matrix();
        mSuppMatrix2 = new Matrix();
        mDisplayMatrix2 = new Matrix();
        mMatrix2 = new Matrix();
        mOverlayBitmapRect = new RectF();
        mCanvasClipRect = new RectF();
        mTempViewPort = new RectF();
    }

    private void configureBounds2()
    {
        if (mOverlayDrawable == null)
        {
            return;
        }
        int i = mOverlayDrawableWidth;
        int j = mOverlayDrawableHeight;
        int k = getWidth();
        int l = getHeight();
        if (i <= 0 || j <= 0)
        {
            mOverlayDrawable.setBounds(0, 0, k, l);
            mDrawMatrix2 = null;
            return;
        }
        mOverlayDrawable.setBounds(0, 0, i, j);
        if (mMatrix2.isIdentity())
        {
            mDrawMatrix2 = null;
            return;
        } else
        {
            mDrawMatrix2 = mMatrix2;
            return;
        }
    }

    protected float computeMinZoom()
    {
        if (mOverlayDrawable == null)
        {
            return super.computeMinZoom();
        } else
        {
            return 1.0F;
        }
    }

    public Bitmap generateResultBitmap(OverlayFilter overlayfilter)
    {
        Drawable drawable;
        if (mOverlayDrawable != null)
        {
            if ((drawable = getDrawable()) != null)
            {
                RectF rectf = getOverlayBitmapRect();
                Bitmap bitmap = Bitmap.createBitmap((int)rectf.width(), (int)rectf.height(), android.graphics.Bitmap.Config.ARGB_8888);
                overlayfilter.getActions().get(0).setValue("previewsize", new MoaPointParameter(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight()));
                overlayfilter.getActions().get(0).setValue("bitmaprect", new MoaRectParameter(getBitmapRect()));
                overlayfilter.getActions().get(0).setValue("overlayrect", new MoaRectParameter(getOverlayBitmapRect()));
                overlayfilter.getActions().get(0).setValue("overlaysize", new MoaPointParameter(mOverlayDrawableWidth, mOverlayDrawableHeight));
                overlayfilter = new Canvas(bitmap);
                overlayfilter.translate(-rectf.left, -rectf.top);
                onDraw(overlayfilter);
                return bitmap;
            }
        }
        return null;
    }

    public it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType getDisplayType()
    {
        return it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN;
    }

    public Matrix getImageViewMatrix2()
    {
        return getImageViewMatrix2(mSuppMatrix2);
    }

    public Matrix getImageViewMatrix2(Matrix matrix)
    {
        mDisplayMatrix2.set(mBaseMatrix2);
        mDisplayMatrix2.postConcat(matrix);
        return mDisplayMatrix2;
    }

    public RectF getOverlayBitmapRect()
    {
        return getOverlayBitmapRect(mSuppMatrix2);
    }

    protected RectF getOverlayBitmapRect(Matrix matrix)
    {
        Drawable drawable = mOverlayDrawable;
        if (drawable == null)
        {
            return null;
        } else
        {
            matrix = getImageViewMatrix2(matrix);
            mOverlayBitmapRect.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(mOverlayBitmapRect);
            return mOverlayBitmapRect;
        }
    }

    public Drawable getOverlayDrawable()
    {
        return mOverlayDrawable;
    }

    protected void getProperBaseMatrix(Drawable drawable, Matrix matrix, RectF rectf)
    {
        if (mOverlayDrawable == null)
        {
            super.getProperBaseMatrix(drawable, matrix, rectf);
            return;
        } else
        {
            float f = drawable.getIntrinsicWidth();
            float f1 = drawable.getIntrinsicHeight();
            matrix.reset();
            float f2 = Math.max(rectf.width() / f, rectf.height() / f1);
            matrix.postScale(f2, f2);
            matrix.postTranslate(rectf.left, rectf.top);
            matrix.postTranslate((rectf.width() - f * f2) / 2.0F, (rectf.height() - f1 * f2) / 2.0F);
            printMatrix(matrix);
            return;
        }
    }

    protected void getProperBaseMatrix2(Drawable drawable, Matrix matrix, RectF rectf)
    {
        float f = drawable.getIntrinsicWidth();
        float f1 = drawable.getIntrinsicHeight();
        matrix.reset();
        float f2 = Math.min(rectf.width() / f, rectf.height() / f1);
        matrix.postScale(f2, f2);
        matrix.postTranslate(rectf.left, rectf.top);
        matrix.postTranslate((rectf.width() - f * f2) / 2.0F, (rectf.height() - f1 * f2) / 2.0F);
        printMatrix(matrix);
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
    }

    protected void onDraw(Canvas canvas)
    {
        Matrix matrix = getImageMatrix();
        Drawable drawable = getDrawable();
        if (drawable != null)
        {
            int i = canvas.getSaveCount();
            canvas.save();
            canvas.clipRect(mCanvasClipRect);
            if (matrix != null)
            {
                canvas.concat(matrix);
            }
            drawable.draw(canvas);
            canvas.restoreToCount(i);
            if (mOverlayDrawable != null && mOverlayDrawableWidth != 0 && mOverlayDrawableHeight != 0 && mDrawMatrix2 != null)
            {
                int j = canvas.getSaveCount();
                canvas.save();
                canvas.concat(mDrawMatrix2);
                mOverlayDrawable.draw(canvas);
                canvas.restoreToCount(j);
                return;
            }
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        Log.i("ImageViewTouchBase", (new StringBuilder()).append("onLayout(").append(i).append(", ").append(j).append(", ").append(k).append(", ").append(l).append(")").toString());
        mTempViewPort.set(i, j, k, l);
        if (mOverlayChanged)
        {
            mOverlayDrawable = mOverlayTempDrawable;
            mOverlayTempDrawable = null;
            float f;
            Object obj;
            int i1;
            int j1;
            if (mOverlayDrawable != null)
            {
                mOverlayDrawableWidth = mOverlayDrawable.getIntrinsicWidth();
                mOverlayDrawableHeight = mOverlayDrawable.getIntrinsicHeight();
            } else
            {
                mOverlayDrawableWidth = 0;
                mOverlayDrawableHeight = 0;
            }
            mOverlayChanged = false;
        }
        if (flag || mBitmapChanged)
        {
            obj = getDrawable();
            if (obj != null && mOverlayDrawable != null)
            {
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("bitmap size: ").append(((Drawable) (obj)).getIntrinsicWidth()).append("x").append(((Drawable) (obj)).getIntrinsicHeight()).toString());
                i1 = Math.min(k - i, Math.min(((Drawable) (obj)).getIntrinsicWidth(), 2048));
                j1 = Math.min(l - j, Math.min(((Drawable) (obj)).getIntrinsicHeight(), 2048));
                if (mTempViewPort.width() > (float)i1 || mTempViewPort.height() > (float)j1)
                {
                    obj = new Matrix();
                    f = Math.max((float)i1 / mTempViewPort.width(), (float)j1 / mTempViewPort.height());
                    ((Matrix) (obj)).postScale(f, f, mTempViewPort.centerX(), mTempViewPort.centerY());
                    ((Matrix) (obj)).mapRect(mTempViewPort);
                }
            }
            flag = true;
        }
        if (mOverlayDrawable != null && (flag || mBitmapChanged))
        {
            mBaseMatrix2.reset();
            mSuppMatrix2.reset();
            getProperBaseMatrix2(mOverlayDrawable, mBaseMatrix2, mTempViewPort);
            setImageMatrix2(getImageViewMatrix2());
            mTempViewPort.set(getOverlayBitmapRect());
        }
        super.onLayout(flag, i, j, k, l);
    }

    protected void onViewPortChanged(float f, float f1, float f2, float f3)
    {
        if (mOverlayDrawable == null)
        {
            super.onViewPortChanged(f, f1, f2, f3);
        } else
        {
            super.onViewPortChanged((int)Math.ceil(mTempViewPort.left), (int)Math.ceil(mTempViewPort.top), (int)Math.floor(mTempViewPort.right), (int)Math.floor(mTempViewPort.bottom));
        }
        mCanvasClipRect.set(mViewPort);
    }

    public void setImageBitmap(Bitmap bitmap, Bitmap bitmap1)
    {
        if (bitmap1 != null)
        {
            mOverlayTempDrawable = new FastBitmapDrawable(bitmap1);
        } else
        {
            mOverlayTempDrawable = null;
        }
        mOverlayChanged = true;
        super.setImageBitmap(bitmap, null, -1F, -1F);
    }

    public void setImageDrawable(Drawable drawable, Bitmap bitmap)
    {
        if (bitmap != null)
        {
            mOverlayTempDrawable = new FastBitmapDrawable(bitmap);
        } else
        {
            mOverlayTempDrawable = null;
        }
        mOverlayChanged = true;
        super.setImageDrawable(drawable, null, -1F, -1F);
    }

    public void setImageMatrix2(Matrix matrix)
    {
        Matrix matrix1 = matrix;
        if (matrix != null)
        {
            matrix1 = matrix;
            if (matrix.isIdentity())
            {
                matrix1 = null;
            }
        }
        if (matrix1 == null && !mMatrix2.isIdentity() || matrix1 != null && !mMatrix2.equals(matrix1))
        {
            mMatrix2.set(matrix1);
            configureBounds2();
            invalidate();
        }
    }

    public void updateImageOverlay(Bitmap bitmap)
    {
        if (mOverlayDrawable == null || bitmap == null)
        {
            return;
        }
        if (mOverlayDrawable.getIntrinsicWidth() == bitmap.getWidth() && mOverlayDrawable.getIntrinsicHeight() == bitmap.getHeight())
        {
            mOverlayDrawable = new FastBitmapDrawable(bitmap);
            invalidate();
            return;
        } else
        {
            setImageDrawable(getDrawable(), bitmap);
            return;
        }
    }
}
