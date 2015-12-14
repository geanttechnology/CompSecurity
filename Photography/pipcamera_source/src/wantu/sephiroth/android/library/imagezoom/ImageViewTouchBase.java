// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package wantu.sephiroth.android.library.imagezoom;

import aiu;
import aiz;
import aja;
import ajb;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

public class ImageViewTouchBase extends ImageView
{

    public static final String LOG_TAG = "image";
    protected final float MAX_ZOOM;
    protected Matrix mBaseMatrix;
    protected RectF mBitmapRect;
    private int mBmpHeight;
    private int mBmpWidth;
    protected RectF mCenterRect;
    protected final Matrix mDisplayMatrix;
    protected aja mEasing;
    protected boolean mFitToScreen;
    protected Handler mHandler;
    private PointF mImageCenterPointF;
    private aiu mListener;
    protected final float mMatrixValues[];
    protected float mMaxZoom;
    private boolean mNeedSetCenter;
    private PointF mNewImageCenter;
    protected Runnable mOnLayoutRunnable;
    protected RectF mScrollRect;
    protected Matrix mSuppMatrix;
    protected int mThisHeight;
    protected int mThisWidth;

    public ImageViewTouchBase(Context context)
    {
        super(context);
        mEasing = new aiz();
        mBaseMatrix = new Matrix();
        mSuppMatrix = new Matrix();
        mHandler = new Handler();
        mOnLayoutRunnable = null;
        mDisplayMatrix = new Matrix();
        mMatrixValues = new float[9];
        mThisWidth = -1;
        mThisHeight = -1;
        mFitToScreen = false;
        MAX_ZOOM = 10F;
        mBitmapRect = new RectF();
        mCenterRect = new RectF();
        mScrollRect = new RectF();
        mNeedSetCenter = false;
        mNewImageCenter = new PointF();
        mBmpWidth = 0;
        mBmpHeight = 0;
        mImageCenterPointF = new PointF();
        init();
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mEasing = new aiz();
        mBaseMatrix = new Matrix();
        mSuppMatrix = new Matrix();
        mHandler = new Handler();
        mOnLayoutRunnable = null;
        mDisplayMatrix = new Matrix();
        mMatrixValues = new float[9];
        mThisWidth = -1;
        mThisHeight = -1;
        mFitToScreen = false;
        MAX_ZOOM = 10F;
        mBitmapRect = new RectF();
        mCenterRect = new RectF();
        mScrollRect = new RectF();
        mNeedSetCenter = false;
        mNewImageCenter = new PointF();
        mBmpWidth = 0;
        mBmpHeight = 0;
        mImageCenterPointF = new PointF();
        init();
    }

    private float getCurScale()
    {
        Matrix matrix = getImageViewMatrix();
        float af[] = new float[9];
        matrix.getValues(af);
        return af[0];
    }

    private void resetCenter()
    {
        Object obj = getImageViewMatrix();
        float af[] = new float[9];
        ((Matrix) (obj)).getValues(af);
        float f = af[0];
        float f1 = af[4];
        float f2 = af[2];
        float f3 = af[5];
        float f4 = mThisWidth;
        float f5 = mThisHeight;
        obj = new PointF(f4 / 2.0F, f5 / 2.0F);
        obj = new PointF(((PointF) (obj)).x - f2, ((PointF) (obj)).y - f3);
        obj = new PointF(((PointF) (obj)).x / f, ((PointF) (obj)).y / f1);
        obj = new PointF(mNewImageCenter.x - ((PointF) (obj)).x, mNewImageCenter.y - ((PointF) (obj)).y);
        obj = new PointF(f * ((PointF) (obj)).x, f1 * ((PointF) (obj)).y);
        panBy(-((PointF) (obj)).x, -((PointF) (obj)).y);
        mImageCenterPointF = mNewImageCenter;
    }

    protected void _setImageDrawable(Drawable drawable, boolean flag, Matrix matrix, float f)
    {
        if (drawable != null)
        {
            if (mFitToScreen)
            {
                getProperBaseMatrix2(drawable, mBaseMatrix);
            } else
            {
                getProperBaseMatrix(drawable, mBaseMatrix);
            }
            super.setImageDrawable(drawable);
        } else
        {
            mBaseMatrix.reset();
            super.setImageDrawable(null);
        }
        if (flag)
        {
            mSuppMatrix.reset();
            if (matrix != null)
            {
                mSuppMatrix = new Matrix(matrix);
            }
        }
        setImageMatrix(getImageViewMatrix());
        if (f < 1.0F)
        {
            mMaxZoom = maxZoom();
        } else
        {
            mMaxZoom = f;
        }
        onBitmapChanged(drawable);
    }

    protected void center(boolean flag, boolean flag1)
    {
        RectF rectf;
        if (getDrawable() != null)
        {
            if ((rectf = getCenter(flag, flag1)).left != 0.0F || rectf.top != 0.0F)
            {
                postTranslate(rectf.left, rectf.top);
                return;
            }
        }
    }

    public void clear()
    {
        setImageBitmap(null, true);
    }

    public void dispose()
    {
        clear();
    }

    protected RectF getBitmapRect()
    {
        Drawable drawable = getDrawable();
        if (drawable == null)
        {
            return null;
        } else
        {
            Matrix matrix = getImageViewMatrix();
            mBitmapRect.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(mBitmapRect);
            return mBitmapRect;
        }
    }

    protected RectF getCenter(boolean flag, boolean flag1)
    {
        float f;
        float f1;
        RectF rectf;
        if (getDrawable() == null)
        {
            return new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        }
        rectf = getBitmapRect();
        f = rectf.height();
        f1 = rectf.width();
        if (!flag1) goto _L2; else goto _L1
_L1:
        int i = getHeight();
        if (f >= (float)i) goto _L4; else goto _L3
_L3:
        f = ((float)i - f) / 2.0F - rectf.top;
_L11:
        if (!flag) goto _L6; else goto _L5
_L5:
        i = getWidth();
        if (f1 >= (float)i) goto _L8; else goto _L7
_L7:
        f1 = ((float)i - f1) / 2.0F - rectf.left;
_L9:
        mCenterRect.set(f1, f, 0.0F, 0.0F);
        return mCenterRect;
_L4:
        if (rectf.top > 0.0F)
        {
            f = -rectf.top;
        } else
        {
            if (rectf.bottom >= (float)i)
            {
                break; /* Loop/switch isn't completed */
            }
            f = (float)getHeight() - rectf.bottom;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (rectf.left > 0.0F)
        {
            f1 = -rectf.left;
            continue; /* Loop/switch isn't completed */
        }
        if (rectf.right < (float)i)
        {
            f1 = (float)i - rectf.right;
            continue; /* Loop/switch isn't completed */
        }
_L6:
        f1 = 0.0F;
        if (true) goto _L9; else goto _L2
_L2:
        f = 0.0F;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public RectF getCenterRectF()
    {
        return mCenterRect;
    }

    public Matrix getDisplayMatrix()
    {
        return new Matrix(mSuppMatrix);
    }

    public PointF getImageCenterPointF()
    {
        return mImageCenterPointF;
    }

    public Matrix getImageViewMatrix()
    {
        mDisplayMatrix.set(mBaseMatrix);
        mDisplayMatrix.postConcat(mSuppMatrix);
        return mDisplayMatrix;
    }

    public float getMaxZoom()
    {
        return mMaxZoom;
    }

    protected void getProperBaseMatrix(Drawable drawable, Matrix matrix)
    {
        float f = getWidth();
        float f1 = getHeight();
        float f2 = drawable.getIntrinsicWidth();
        float f3 = drawable.getIntrinsicHeight();
        matrix.reset();
        if (f2 > f || f3 > f1)
        {
            float f4 = Math.min(Math.min(f / f2, 2.0F), Math.min(f1 / f3, 2.0F));
            matrix.postScale(f4, f4);
            matrix.postTranslate((f - f2 * f4) / 2.0F, (f1 - f3 * f4) / 2.0F);
            return;
        } else
        {
            matrix.postTranslate((f - f2) / 2.0F, (f1 - f3) / 2.0F);
            return;
        }
    }

    protected void getProperBaseMatrix2(Drawable drawable, Matrix matrix)
    {
        float f = getWidth();
        float f1 = getHeight();
        float f2 = drawable.getIntrinsicWidth();
        float f3 = drawable.getIntrinsicHeight();
        matrix.reset();
        float f4 = Math.max(Math.min(f / f2, 10F), Math.min(f1 / f3, 10F));
        matrix.postScale(f4, f4);
        matrix.postTranslate((f - f2 * f4) / 2.0F, (f1 - f3 * f4) / 2.0F);
    }

    public float getRotation()
    {
        return 0.0F;
    }

    public float getScale()
    {
        return getScale(mSuppMatrix);
    }

    protected float getScale(Matrix matrix)
    {
        return getValue(matrix, 0);
    }

    protected float getValue(Matrix matrix, int i)
    {
        matrix.getValues(mMatrixValues);
        return mMatrixValues[i];
    }

    protected void init()
    {
        try
        {
            if (android.os.Build.VERSION.SDK_INT > 10)
            {
                setLayerType(1, null);
            }
        }
        catch (Exception exception) { }
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    protected float maxZoom()
    {
        Drawable drawable = getDrawable();
        if (drawable == null)
        {
            return 1.0F;
        } else
        {
            return Math.max((float)drawable.getIntrinsicWidth() / (float)mThisWidth, (float)drawable.getIntrinsicHeight() / (float)mThisHeight) * 10F;
        }
    }

    protected void onBitmapChanged(Drawable drawable)
    {
        if (mListener != null)
        {
            mListener.a(drawable);
        }
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mThisWidth = k - i;
        mThisHeight = l - j;
        Runnable runnable = mOnLayoutRunnable;
        if (runnable != null)
        {
            mOnLayoutRunnable = null;
            runnable.run();
        }
        if (getDrawable() != null)
        {
            if (mFitToScreen)
            {
                getProperBaseMatrix2(getDrawable(), mBaseMatrix);
            } else
            {
                getProperBaseMatrix(getDrawable(), mBaseMatrix);
            }
            setImageMatrix(getImageViewMatrix());
            if (mNeedSetCenter)
            {
                resetCenter();
                mNeedSetCenter = false;
            }
        }
    }

    protected void onZoom(float f)
    {
    }

    protected void panBy(double d, double d1)
    {
        if (!mNeedSetCenter)
        {
            float f = getCurScale();
            PointF pointf = mImageCenterPointF;
            pointf.x = (float)((double)pointf.x - d / (double)f);
            pointf = mImageCenterPointF;
            pointf.y = (float)((double)pointf.y - d1 / (double)f);
        }
        RectF rectf = getBitmapRect();
        mScrollRect.set((float)d, (float)d1, 0.0F, 0.0F);
        updateRect(rectf, mScrollRect);
        postTranslate(mScrollRect.left, mScrollRect.top);
        center(true, true);
    }

    protected void postScale(float f, float f1, float f2)
    {
        mSuppMatrix.postScale(f, f, f1, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postTranslate(float f, float f1)
    {
        mSuppMatrix.postTranslate(f, f1);
        setImageMatrix(getImageViewMatrix());
    }

    public void resetDisplayMatrix()
    {
        mSuppMatrix.reset();
    }

    public void scrollBy(float f, float f1)
    {
        panBy(f, f1);
    }

    public void scrollBy(float f, float f1, double d)
    {
        double d1 = f;
        double d2 = f1;
        long l = System.currentTimeMillis();
        mHandler.post(new Runnable(d, l, d1, d2) {

            double a;
            double b;
            final double c;
            final long d;
            final double e;
            final double f;
            final ImageViewTouchBase g;

            public void run()
            {
                long l1 = System.currentTimeMillis();
                double d3 = Math.min(c, l1 - d);
                double d4 = g.mEasing.a(d3, 0.0D, e, c);
                double d5 = g.mEasing.a(d3, 0.0D, f, c);
                g.panBy(d4 - a, d5 - b);
                a = d4;
                b = d5;
                if (d3 < c)
                {
                    g.mHandler.post(this);
                } else
                {
                    RectF rectf = g.getCenter(true, true);
                    if (rectf.left != 0.0F || rectf.top != 0.0F)
                    {
                        g.scrollBy(rectf.left, rectf.top);
                        return;
                    }
                }
            }

            
            {
                g = ImageViewTouchBase.this;
                c = d1;
                d = l;
                e = d2;
                f = d3;
                super();
                a = 0.0D;
                b = 0.0D;
            }
        });
    }

    public void setFitToScreen(boolean flag)
    {
        if (flag != mFitToScreen)
        {
            mFitToScreen = flag;
            requestLayout();
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        setImageBitmap(bitmap, true);
    }

    public void setImageBitmap(Bitmap bitmap, boolean flag)
    {
        setImageBitmap(bitmap, flag, null);
    }

    public void setImageBitmap(Bitmap bitmap, boolean flag, Matrix matrix)
    {
        setImageBitmap(bitmap, flag, matrix, -1F);
    }

    public void setImageBitmap(Bitmap bitmap, boolean flag, Matrix matrix, float f)
    {
        Log.i("image", (new StringBuilder()).append("setImageBitmap: ").append(bitmap).toString());
        if (bitmap != null)
        {
            setImageDrawable(new ajb(bitmap), flag, matrix, f);
            return;
        } else
        {
            setImageDrawable(null, flag, matrix, f);
            return;
        }
    }

    public void setImageCenterPoint(PointF pointf, int i, int j)
    {
        mNeedSetCenter = true;
        mNewImageCenter = pointf;
        mBmpHeight = j;
        mBmpWidth = i;
        requestLayout();
    }

    public void setImageDrawable(Drawable drawable)
    {
        setImageDrawable(drawable, true, null, -1F);
    }

    public void setImageDrawable(Drawable drawable, boolean flag, Matrix matrix, float f)
    {
        if (getWidth() <= 0)
        {
            mOnLayoutRunnable = new Runnable(drawable, flag, matrix, f) {

                final Drawable a;
                final boolean b;
                final Matrix c;
                final float d;
                final ImageViewTouchBase e;

                public void run()
                {
                    e.setImageDrawable(a, b, c, d);
                }

            
            {
                e = ImageViewTouchBase.this;
                a = drawable;
                b = flag;
                c = matrix;
                d = f;
                super();
            }
            };
            return;
        } else
        {
            _setImageDrawable(drawable, flag, matrix, f);
            return;
        }
    }

    public void setImageResource(int i)
    {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    public void setOnBitmapChangedListener(aiu aiu1)
    {
        mListener = aiu1;
    }

    protected void updateRect(RectF rectf, RectF rectf1)
    {
        float f = getWidth();
        float f1 = getHeight();
        if (rectf != null && rectf1 != null)
        {
            if (rectf.top >= 0.0F && rectf.bottom <= f1)
            {
                rectf1.top = 0.0F;
            }
            if (rectf.left >= 0.0F && rectf.right <= f)
            {
                rectf1.left = 0.0F;
            }
            if (rectf.top + rectf1.top >= 0.0F && rectf.bottom > f1)
            {
                rectf1.top = (int)(0.0F - rectf.top);
            }
            if (rectf.bottom + rectf1.top <= f1 - 0.0F && rectf.top < 0.0F)
            {
                rectf1.top = (int)(f1 - 0.0F - rectf.bottom);
            }
            if (rectf.left + rectf1.left >= 0.0F)
            {
                rectf1.left = (int)(0.0F - rectf.left);
            }
            if (rectf.right + rectf1.left <= f - 0.0F)
            {
                rectf1.left = (int)(f - 0.0F - rectf.right);
                return;
            }
        }
    }

    protected void zoomTo(float f)
    {
        zoomTo(f, (float)getWidth() / 2.0F, (float)getHeight() / 2.0F);
    }

    public void zoomTo(float f, float f1)
    {
        zoomTo(f, (float)getWidth() / 2.0F, (float)getHeight() / 2.0F, f1);
    }

    public void zoomTo(float f, float f1, float f2)
    {
        float f3 = f;
        if (f > mMaxZoom)
        {
            f3 = mMaxZoom;
        }
        postScale(f3 / getScale(), f1, f2);
        onZoom(getScale());
        center(true, true);
    }

    public void zoomTo(float f, float f1, float f2, float f3)
    {
        long l = System.currentTimeMillis();
        f = (f - getScale()) / f3;
        float f4 = getScale();
        mHandler.post(new Runnable(f3, l, f4, f, f1, f2) {

            final float a;
            final long b;
            final float c;
            final float d;
            final float e;
            final float f;
            final ImageViewTouchBase g;

            public void run()
            {
                long l1 = System.currentTimeMillis();
                float f5 = Math.min(a, l1 - b);
                float f6 = c;
                float f7 = d;
                g.zoomTo(f6 + f7 * f5, e, f);
                if (f5 < a)
                {
                    g.mHandler.post(this);
                }
            }

            
            {
                g = ImageViewTouchBase.this;
                a = f1;
                b = l;
                c = f2;
                d = f3;
                e = f4;
                f = f5;
                super();
            }
        });
    }
}
