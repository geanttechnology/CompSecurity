// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.imagezoom;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ValueAnimator;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;
import it.sephiroth.android.library.imagezoom.utils.IDisposable;

public abstract class ImageViewTouchBase extends ImageView
    implements IDisposable
{
    public static final class DisplayType extends Enum
    {

        private static final DisplayType $VALUES[];
        public static final DisplayType FIT_IF_BIGGER;
        public static final DisplayType FIT_TO_SCREEN;
        public static final DisplayType NONE;

        public static DisplayType valueOf(String s)
        {
            return (DisplayType)Enum.valueOf(it/sephiroth/android/library/imagezoom/ImageViewTouchBase$DisplayType, s);
        }

        public static DisplayType[] values()
        {
            return (DisplayType[])$VALUES.clone();
        }

        static 
        {
            NONE = new DisplayType("NONE", 0);
            FIT_TO_SCREEN = new DisplayType("FIT_TO_SCREEN", 1);
            FIT_IF_BIGGER = new DisplayType("FIT_IF_BIGGER", 2);
            $VALUES = (new DisplayType[] {
                NONE, FIT_TO_SCREEN, FIT_IF_BIGGER
            });
        }

        private DisplayType(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface OnDrawableChangeListener
    {

        public abstract void onDrawableChanged(Drawable drawable);
    }

    public static interface OnLayoutChangeListener
    {

        public abstract void onLayoutChanged(boolean flag, int i, int j, int k, int l);
    }


    protected static boolean DEBUG = false;
    public static final long DEFAULT_ANIMATION_DURATION = 200L;
    public static final String TAG = "ImageViewTouchBase";
    public static final String VERSION = "1.0.5-SNAPSHOT";
    public static final float ZOOM_INVALID = -1F;
    protected Matrix mBaseMatrix;
    protected boolean mBitmapChanged;
    protected RectF mBitmapRect;
    protected RectF mBitmapRectTmp;
    protected PointF mCenter;
    protected RectF mCenterRect;
    private Animator mCurrentAnimation;
    protected int mDefaultAnimationDuration;
    protected final Matrix mDisplayMatrix;
    private OnDrawableChangeListener mDrawableChangeListener;
    protected Runnable mLayoutRunnable;
    protected final float mMatrixValues[];
    protected int mMaxFlingVelocity;
    protected float mMaxZoom;
    protected boolean mMaxZoomDefined;
    protected int mMinFlingVelocity;
    protected float mMinZoom;
    protected boolean mMinZoomDefined;
    protected Matrix mNextMatrix;
    private OnLayoutChangeListener mOnLayoutChangeListener;
    protected DisplayType mScaleType;
    protected boolean mScaleTypeChanged;
    protected PointF mScrollPoint;
    protected Matrix mSuppMatrix;
    protected boolean mUserScaled;
    protected RectF mViewPort;
    protected RectF mViewPortOld;

    public ImageViewTouchBase(Context context)
    {
        this(context, null);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageViewTouchBase(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mBaseMatrix = new Matrix();
        mSuppMatrix = new Matrix();
        mLayoutRunnable = null;
        mUserScaled = false;
        mMaxZoom = -1F;
        mMinZoom = -1F;
        mDisplayMatrix = new Matrix();
        mMatrixValues = new float[9];
        mScaleType = DisplayType.FIT_IF_BIGGER;
        mCenter = new PointF();
        mBitmapRect = new RectF();
        mBitmapRectTmp = new RectF();
        mCenterRect = new RectF();
        mScrollPoint = new PointF();
        mViewPort = new RectF();
        mViewPortOld = new RectF();
        init(context, attributeset, i);
    }

    protected void _setImageDrawable(Drawable drawable, Matrix matrix, float f, float f1)
    {
        mBaseMatrix.reset();
        super.setImageDrawable(drawable);
        if (f != -1F && f1 != -1F)
        {
            f = Math.min(f, f1);
            f1 = Math.max(f, f1);
            mMinZoom = f;
            mMaxZoom = f1;
            mMinZoomDefined = true;
            mMaxZoomDefined = true;
            if (getDisplayType() == DisplayType.FIT_TO_SCREEN || getDisplayType() == DisplayType.FIT_IF_BIGGER)
            {
                if (mMinZoom >= 1.0F)
                {
                    mMinZoomDefined = false;
                    mMinZoom = -1F;
                }
                if (mMaxZoom <= 1.0F)
                {
                    mMaxZoomDefined = true;
                    mMaxZoom = -1F;
                }
            }
        } else
        {
            mMinZoom = -1F;
            mMaxZoom = -1F;
            mMinZoomDefined = false;
            mMaxZoomDefined = false;
        }
        if (matrix != null)
        {
            mNextMatrix = new Matrix(matrix);
        }
        if (DEBUG)
        {
            Log.v("ImageViewTouchBase", (new StringBuilder()).append("mMinZoom: ").append(mMinZoom).append(", mMaxZoom: ").append(mMaxZoom).toString());
        }
        mBitmapChanged = true;
        updateDrawable(drawable);
        requestLayout();
    }

    protected void center(boolean flag, boolean flag1)
    {
        RectF rectf;
        if (getDrawable() != null)
        {
            if ((rectf = getCenter(mSuppMatrix, flag, flag1)).left != 0.0F || rectf.top != 0.0F)
            {
                postTranslate(rectf.left, rectf.top);
                return;
            }
        }
    }

    public void clear()
    {
        setImageBitmap(null);
    }

    protected float computeMaxZoom()
    {
        float f;
        if (getDrawable() == null)
        {
            f = 1.0F;
        } else
        {
            float f1 = Math.max(mBitmapRect.width() / mViewPort.width(), mBitmapRect.height() / mViewPort.height()) * 4F;
            f = f1;
            if (DEBUG)
            {
                Log.i("ImageViewTouchBase", (new StringBuilder()).append("computeMaxZoom: ").append(f1).toString());
                return f1;
            }
        }
        return f;
    }

    protected float computeMinZoom()
    {
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", "computeMinZoom");
        }
        float f;
        if (getDrawable() == null)
        {
            f = 1.0F;
        } else
        {
            float f1 = Math.min(1.0F, 1.0F / getScale(mBaseMatrix));
            f = f1;
            if (DEBUG)
            {
                Log.i("ImageViewTouchBase", (new StringBuilder()).append("computeMinZoom: ").append(f1).toString());
                return f1;
            }
        }
        return f;
    }

    public void dispose()
    {
        clear();
    }

    protected void fireOnDrawableChangeListener(Drawable drawable)
    {
        if (mDrawableChangeListener != null)
        {
            mDrawableChangeListener.onDrawableChanged(drawable);
        }
    }

    protected void fireOnLayoutChangeListener(int i, int j, int k, int l)
    {
        if (mOnLayoutChangeListener != null)
        {
            mOnLayoutChangeListener.onLayoutChanged(true, i, j, k, l);
        }
    }

    public float getBaseScale()
    {
        return getScale(mBaseMatrix);
    }

    public boolean getBitmapChanged()
    {
        return mBitmapChanged;
    }

    public RectF getBitmapRect()
    {
        return getBitmapRect(mSuppMatrix);
    }

    protected RectF getBitmapRect(Matrix matrix)
    {
        getImageViewMatrix(matrix).mapRect(mBitmapRectTmp, mBitmapRect);
        return mBitmapRectTmp;
    }

    protected PointF getCenter()
    {
        return mCenter;
    }

    protected RectF getCenter(Matrix matrix, boolean flag, boolean flag1)
    {
        if (getDrawable() == null)
        {
            return new RectF(0.0F, 0.0F, 0.0F, 0.0F);
        }
        mCenterRect.set(0.0F, 0.0F, 0.0F, 0.0F);
        matrix = getBitmapRect(matrix);
        float f4 = matrix.height();
        float f3 = matrix.width();
        float f2 = 0.0F;
        float f1 = 0.0F;
        float f = f1;
        if (flag1)
        {
            if (f4 < mViewPort.height())
            {
                f = (mViewPort.height() - f4) / 2.0F - (((RectF) (matrix)).top - mViewPort.top);
            } else
            if (((RectF) (matrix)).top > mViewPort.top)
            {
                f = -(((RectF) (matrix)).top - mViewPort.top);
            } else
            {
                f = f1;
                if (((RectF) (matrix)).bottom < mViewPort.bottom)
                {
                    f = mViewPort.bottom - ((RectF) (matrix)).bottom;
                }
            }
        }
        f1 = f2;
        if (flag)
        {
            if (f3 < mViewPort.width())
            {
                f1 = (mViewPort.width() - f3) / 2.0F - (((RectF) (matrix)).left - mViewPort.left);
            } else
            if (((RectF) (matrix)).left > mViewPort.left)
            {
                f1 = -(((RectF) (matrix)).left - mViewPort.left);
            } else
            {
                f1 = f2;
                if (((RectF) (matrix)).right < mViewPort.right)
                {
                    f1 = mViewPort.right - ((RectF) (matrix)).right;
                }
            }
        }
        mCenterRect.set(f1, f, 0.0F, 0.0F);
        return mCenterRect;
    }

    protected float getDefaultScale(DisplayType displaytype)
    {
        if (displaytype == DisplayType.FIT_TO_SCREEN)
        {
            return 1.0F;
        }
        if (displaytype == DisplayType.FIT_IF_BIGGER)
        {
            return Math.min(1.0F, 1.0F / getScale(mBaseMatrix));
        } else
        {
            return 1.0F / getScale(mBaseMatrix);
        }
    }

    public Matrix getDisplayMatrix()
    {
        return new Matrix(mSuppMatrix);
    }

    public DisplayType getDisplayType()
    {
        return mScaleType;
    }

    public Matrix getImageViewMatrix()
    {
        return getImageViewMatrix(mSuppMatrix);
    }

    public Matrix getImageViewMatrix(Matrix matrix)
    {
        mDisplayMatrix.set(mBaseMatrix);
        mDisplayMatrix.postConcat(matrix);
        return mDisplayMatrix;
    }

    public float getMaxScale()
    {
        if (mMaxZoom == -1F)
        {
            mMaxZoom = computeMaxZoom();
        }
        return mMaxZoom;
    }

    public float getMinScale()
    {
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", (new StringBuilder()).append("getMinScale, mMinZoom: ").append(mMinZoom).toString());
        }
        if (mMinZoom == -1F)
        {
            mMinZoom = computeMinZoom();
        }
        if (DEBUG)
        {
            Log.v("ImageViewTouchBase", (new StringBuilder()).append("mMinZoom: ").append(mMinZoom).toString());
        }
        return mMinZoom;
    }

    protected void getProperBaseMatrix(Drawable drawable, Matrix matrix, RectF rectf)
    {
        float f = mBitmapRect.width();
        float f1 = mBitmapRect.height();
        matrix.reset();
        float f2 = Math.min(rectf.width() / f, rectf.height() / f1);
        matrix.postScale(f2, f2);
        matrix.postTranslate(rectf.left, rectf.top);
        matrix.postTranslate((rectf.width() - f * f2) / 2.0F, (rectf.height() - f1 * f2) / 2.0F);
        printMatrix(matrix);
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

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        context = ViewConfiguration.get(context);
        mMinFlingVelocity = context.getScaledMinimumFlingVelocity();
        mMaxFlingVelocity = context.getScaledMaximumFlingVelocity();
        mDefaultAnimationDuration = getResources().getInteger(0x10e0000);
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", (new StringBuilder()).append("onConfigurationChanged. scale: ").append(getScale()).append(", minScale: ").append(getMinScale()).append(", mUserScaled: ").append(mUserScaled).toString());
        }
        if (mUserScaled)
        {
            boolean flag;
            if (Math.abs(getScale() - getMinScale()) > 0.1F)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            mUserScaled = flag;
        }
        if (DEBUG)
        {
            Log.v("ImageViewTouchBase", (new StringBuilder()).append("mUserScaled: ").append(mUserScaled).toString());
        }
    }

    protected void onDrawableChanged(Drawable drawable)
    {
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", "onDrawableChanged");
            Log.v("ImageViewTouchBase", (new StringBuilder()).append("scale: ").append(getScale()).append(", minScale: ").append(getMinScale()).toString());
        }
        fireOnDrawableChangeListener(drawable);
    }

    protected void onImageMatrixChanged()
    {
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        float f2;
        float f3;
        Object obj;
        if (DEBUG)
        {
            Log.e("ImageViewTouchBase", (new StringBuilder()).append("onLayout: ").append(flag).append(", bitmapChanged: ").append(mBitmapChanged).append(", scaleChanged: ").append(mScaleTypeChanged).toString());
        }
        f2 = 0.0F;
        f3 = 0.0F;
        if (flag)
        {
            mViewPortOld.set(mViewPort);
            onViewPortChanged(i, j, k, l);
            f2 = mViewPort.width() - mViewPortOld.width();
            f3 = mViewPort.height() - mViewPortOld.height();
        }
        super.onLayout(flag, i, j, k, l);
        obj = mLayoutRunnable;
        if (obj != null)
        {
            mLayoutRunnable = null;
            ((Runnable) (obj)).run();
        }
        obj = getDrawable();
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!flag && !mScaleTypeChanged && !mBitmapChanged) goto _L4; else goto _L3
_L3:
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        if (mBitmapChanged)
        {
            mUserScaled = false;
            mBaseMatrix.reset();
            if (!mMinZoomDefined)
            {
                mMinZoom = -1F;
            }
            if (!mMaxZoomDefined)
            {
                mMaxZoom = -1F;
            }
        }
        f4 = 1.0F;
        f5 = getDefaultScale(getDisplayType());
        f7 = getScale(mBaseMatrix);
        f6 = getScale();
        f8 = Math.min(1.0F, 1.0F / f7);
        getProperBaseMatrix(((Drawable) (obj)), mBaseMatrix, mViewPort);
        f9 = getScale(mBaseMatrix);
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("old matrix scale: ").append(f7).toString());
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("new matrix scale: ").append(f9).toString());
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("old min scale: ").append(f8).toString());
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("old scale: ").append(f6).toString());
        }
        if (!mBitmapChanged && !mScaleTypeChanged) goto _L6; else goto _L5
_L5:
        float f;
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("display type: ").append(getDisplayType()).toString());
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("newMatrix: ").append(mNextMatrix).toString());
        }
        if (mNextMatrix != null)
        {
            mSuppMatrix.set(mNextMatrix);
            mNextMatrix = null;
            f2 = getScale();
        } else
        {
            mSuppMatrix.reset();
            f2 = getDefaultScale(getDisplayType());
        }
        setImageMatrix(getImageViewMatrix());
        f = f2;
        if (f2 != getScale())
        {
            if (DEBUG)
            {
                Log.v("ImageViewTouchBase", (new StringBuilder()).append("scale != getScale: ").append(f2).append(" != ").append(getScale()).toString());
            }
            zoomTo(f2);
            f = f2;
        }
_L9:
        if (f > getMaxScale() || f < getMinScale())
        {
            zoomTo(f);
        }
        center(true, true);
        if (mBitmapChanged)
        {
            onDrawableChanged(((Drawable) (obj)));
        }
        if (flag || mBitmapChanged || mScaleTypeChanged)
        {
            onLayoutChanged(i, j, k, l);
        }
        if (mScaleTypeChanged)
        {
            mScaleTypeChanged = false;
        }
        if (mBitmapChanged)
        {
            mBitmapChanged = false;
        }
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("scale: ").append(getScale()).append(", minScale: ").append(getMinScale()).append(", maxScale: ").append(getMaxScale()).toString());
        }
_L4:
        return;
_L6:
        f = f4;
        if (flag)
        {
            if (!mMinZoomDefined)
            {
                mMinZoom = -1F;
            }
            if (!mMaxZoomDefined)
            {
                mMaxZoom = -1F;
            }
            setImageMatrix(getImageViewMatrix());
            postTranslate(-f2, -f3);
            if (!mUserScaled)
            {
                f2 = getDefaultScale(getDisplayType());
                if (DEBUG)
                {
                    Log.v("ImageViewTouchBase", (new StringBuilder()).append("!userScaled. scale=").append(f2).toString());
                }
                zoomTo(f2);
            } else
            {
                float f1 = f4;
                if ((double)Math.abs(f6 - f8) > 0.10000000000000001D)
                {
                    f1 = (f7 / f9) * f6;
                }
                if (DEBUG)
                {
                    Log.v("ImageViewTouchBase", (new StringBuilder()).append("userScaled. scale=").append(f1).toString());
                }
                zoomTo(f1);
                f2 = f1;
            }
            f = f2;
            if (DEBUG)
            {
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("old min scale: ").append(f5).toString());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("old scale: ").append(f6).toString());
                Log.d("ImageViewTouchBase", (new StringBuilder()).append("new scale: ").append(f2).toString());
                f = f2;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (mBitmapChanged)
        {
            onDrawableChanged(((Drawable) (obj)));
        }
        if (flag || mBitmapChanged || mScaleTypeChanged)
        {
            onLayoutChanged(i, j, k, l);
        }
        if (mBitmapChanged)
        {
            mBitmapChanged = false;
        }
        if (!mScaleTypeChanged) goto _L4; else goto _L7
_L7:
        mScaleTypeChanged = false;
        return;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", "onLayoutChanged");
        }
        fireOnLayoutChangeListener(i, j, k, l);
    }

    protected void onViewPortChanged(float f, float f1, float f2, float f3)
    {
        mViewPort.set(f, f1, f2, f3);
        mCenter.x = mViewPort.centerX();
        mCenter.y = mViewPort.centerY();
    }

    protected void onZoom(float f)
    {
    }

    protected void onZoomAnimationCompleted(float f)
    {
    }

    protected void panBy(double d, double d1)
    {
        RectF rectf = getBitmapRect();
        mScrollPoint.set((float)d, (float)d1);
        updateRect(rectf, mScrollPoint);
        if (mScrollPoint.x != 0.0F || mScrollPoint.y != 0.0F)
        {
            postTranslate(mScrollPoint.x, mScrollPoint.y);
            center(true, true);
        }
    }

    protected void postScale(float f, float f1, float f2)
    {
        mSuppMatrix.postScale(f, f, f1, f2);
        setImageMatrix(getImageViewMatrix());
    }

    protected void postTranslate(float f, float f1)
    {
        if (f != 0.0F || f1 != 0.0F)
        {
            mSuppMatrix.postTranslate(f, f1);
            setImageMatrix(getImageViewMatrix());
        }
    }

    public void printMatrix(Matrix matrix)
    {
        float f = getValue(matrix, 0);
        float f1 = getValue(matrix, 4);
        float f2 = getValue(matrix, 2);
        float f3 = getValue(matrix, 5);
        Log.d("ImageViewTouchBase", (new StringBuilder()).append("matrix: { x: ").append(f2).append(", y: ").append(f3).append(", scalex: ").append(f).append(", scaley: ").append(f1).append(" }").toString());
    }

    public void resetDisplay()
    {
        mBitmapChanged = true;
        requestLayout();
    }

    public void resetMatrix()
    {
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", "resetMatrix");
        }
        mSuppMatrix = new Matrix();
        float f = getDefaultScale(getDisplayType());
        setImageMatrix(getImageViewMatrix());
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("default scale: ").append(f).append(", scale: ").append(getScale()).toString());
        }
        if (f != getScale())
        {
            zoomTo(f);
        }
        postInvalidate();
    }

    public void scrollBy(float f, float f1)
    {
        panBy(f, f1);
    }

    protected void scrollBy(float f, float f1, long l)
    {
        final ValueAnimator anim1 = ValueAnimator.ofFloat(new float[] {
            0.0F, f
        }).setDuration(l);
        final ValueAnimator anim2 = ValueAnimator.ofFloat(new float[] {
            0.0F, f1
        }).setDuration(l);
        stopAllAnimations();
        mCurrentAnimation = new AnimatorSet();
        ((AnimatorSet)mCurrentAnimation).playTogether(new Animator[] {
            anim1, anim2
        });
        mCurrentAnimation.setDuration(l);
        mCurrentAnimation.setInterpolator(new DecelerateInterpolator());
        mCurrentAnimation.start();
        anim2.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            float oldValueX;
            float oldValueY;
            final ImageViewTouchBase this$0;
            final ValueAnimator val$anim1;
            final ValueAnimator val$anim2;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f2 = ((Float)anim1.getAnimatedValue()).floatValue();
                float f3 = ((Float)anim2.getAnimatedValue()).floatValue();
                panBy(f2 - oldValueX, f3 - oldValueY);
                oldValueX = f2;
                oldValueY = f3;
            }

            
            {
                this$0 = ImageViewTouchBase.this;
                anim1 = valueanimator;
                anim2 = valueanimator1;
                super();
                oldValueX = 0.0F;
                oldValueY = 0.0F;
            }
        });
        mCurrentAnimation.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final ImageViewTouchBase this$0;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                animator = getCenter(mSuppMatrix, true, true);
                if (((RectF) (animator)).left != 0.0F || ((RectF) (animator)).top != 0.0F)
                {
                    scrollBy(((RectF) (animator)).left, ((RectF) (animator)).top);
                }
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = ImageViewTouchBase.this;
                super();
            }
        });
    }

    public void setDisplayType(DisplayType displaytype)
    {
        if (displaytype != mScaleType)
        {
            if (DEBUG)
            {
                Log.i("ImageViewTouchBase", (new StringBuilder()).append("setDisplayType: ").append(displaytype).toString());
            }
            mUserScaled = false;
            mScaleType = displaytype;
            mScaleTypeChanged = true;
            requestLayout();
        }
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        setImageBitmap(bitmap, null, -1F, -1F);
    }

    public void setImageBitmap(Bitmap bitmap, Matrix matrix, float f, float f1)
    {
        if (bitmap != null)
        {
            setImageDrawable(new FastBitmapDrawable(bitmap), matrix, f, f1);
            return;
        } else
        {
            setImageDrawable(null, matrix, f, f1);
            return;
        }
    }

    public void setImageDrawable(Drawable drawable)
    {
        setImageDrawable(drawable, null, -1F, -1F);
    }

    public void setImageDrawable(final Drawable drawable, final Matrix initial_matrix, final float min_zoom, final float max_zoom)
    {
        if (getWidth() <= 0)
        {
            mLayoutRunnable = new Runnable() {

                final ImageViewTouchBase this$0;
                final Drawable val$drawable;
                final Matrix val$initial_matrix;
                final float val$max_zoom;
                final float val$min_zoom;

                public void run()
                {
                    setImageDrawable(drawable, initial_matrix, min_zoom, max_zoom);
                }

            
            {
                this$0 = ImageViewTouchBase.this;
                drawable = drawable1;
                initial_matrix = matrix;
                min_zoom = f;
                max_zoom = f1;
                super();
            }
            };
            return;
        } else
        {
            _setImageDrawable(drawable, initial_matrix, min_zoom, max_zoom);
            return;
        }
    }

    public void setImageMatrix(Matrix matrix)
    {
        boolean flag;
label0:
        {
            Matrix matrix1 = getImageMatrix();
            boolean flag1 = false;
            if (matrix != null || matrix1.isIdentity())
            {
                flag = flag1;
                if (matrix == null)
                {
                    break label0;
                }
                flag = flag1;
                if (matrix1.equals(matrix))
                {
                    break label0;
                }
            }
            flag = true;
        }
        super.setImageMatrix(matrix);
        if (flag)
        {
            onImageMatrixChanged();
        }
    }

    public void setImageResource(int i)
    {
        setImageDrawable(getContext().getResources().getDrawable(i));
    }

    protected void setMaxScale(float f)
    {
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("setMaxZoom: ").append(f).toString());
        }
        mMaxZoom = f;
    }

    protected void setMinScale(float f)
    {
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("setMinZoom: ").append(f).toString());
        }
        mMinZoom = f;
    }

    public void setOnDrawableChangedListener(OnDrawableChangeListener ondrawablechangelistener)
    {
        mDrawableChangeListener = ondrawablechangelistener;
    }

    public void setOnLayoutChangeListener(OnLayoutChangeListener onlayoutchangelistener)
    {
        mOnLayoutChangeListener = onlayoutchangelistener;
    }

    public void setScaleType(android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype == android.widget.ImageView.ScaleType.MATRIX)
        {
            super.setScaleType(scaletype);
            return;
        } else
        {
            Log.w("ImageViewTouchBase", "Unsupported scaletype. Only MATRIX can be used");
            return;
        }
    }

    protected void stopAllAnimations()
    {
        if (mCurrentAnimation != null)
        {
            mCurrentAnimation.cancel();
            mCurrentAnimation = null;
        }
    }

    protected void updateDrawable(Drawable drawable)
    {
        if (drawable != null)
        {
            mBitmapRect.set(0.0F, 0.0F, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            return;
        } else
        {
            mBitmapRect.setEmpty();
            return;
        }
    }

    protected void updateRect(RectF rectf, PointF pointf)
    {
        if (rectf != null);
    }

    protected void zoomTo(float f)
    {
        if (DEBUG)
        {
            Log.i("ImageViewTouchBase", (new StringBuilder()).append("zoomTo: ").append(f).toString());
        }
        float f1 = f;
        if (f > getMaxScale())
        {
            f1 = getMaxScale();
        }
        f = f1;
        if (f1 < getMinScale())
        {
            f = getMinScale();
        }
        if (DEBUG)
        {
            Log.d("ImageViewTouchBase", (new StringBuilder()).append("sanitized scale: ").append(f).toString());
        }
        PointF pointf = getCenter();
        zoomTo(f, pointf.x, pointf.y);
    }

    protected void zoomTo(float f, float f1, float f2)
    {
        float f3 = f;
        if (f > getMaxScale())
        {
            f3 = getMaxScale();
        }
        postScale(f3 / getScale(), f1, f2);
        onZoom(getScale());
        center(true, true);
    }

    protected void zoomTo(float f, float f1, float f2, long l)
    {
        float f3 = f;
        if (f > getMaxScale())
        {
            f3 = getMaxScale();
        }
        f = getScale();
        Object obj = new Matrix(mSuppMatrix);
        ((Matrix) (obj)).postScale(f3, f3, f1, f2);
        obj = getCenter(((Matrix) (obj)), true, true);
        float f4 = ((RectF) (obj)).left;
        float f5 = ((RectF) (obj)).top;
        stopAllAnimations();
        obj = ValueAnimator.ofFloat(new float[] {
            f, f3
        });
        ((ValueAnimator) (obj)).setDuration(l);
        ((ValueAnimator) (obj)).setInterpolator(new DecelerateInterpolator(1.0F));
        ((ValueAnimator) (obj)).addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final ImageViewTouchBase this$0;
            final float val$destX;
            final float val$destY;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                float f6 = ((Float)valueanimator.getAnimatedValue()).floatValue();
                zoomTo(f6, destX, destY);
            }

            
            {
                this$0 = ImageViewTouchBase.this;
                destX = f;
                destY = f1;
                super();
            }
        });
        ((ValueAnimator) (obj)).start();
    }

    public void zoomTo(float f, long l)
    {
        PointF pointf = getCenter();
        zoomTo(f, pointf.x, pointf.y, l);
    }

    static 
    {
        DEBUG = false;
    }
}
