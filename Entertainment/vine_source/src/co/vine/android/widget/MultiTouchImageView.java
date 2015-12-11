// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.ImageView;

public class MultiTouchImageView extends ImageView
{

    private static final int GESTURE_NONE = 0;
    private static final int GESTURE_PAN = 1;
    private static final int GESTURE_ZOOM = 2;
    private static final float MIN_SCALE_FACTOR = 1F;
    protected float mBitmapHeight;
    protected float mBitmapWidth;
    private float mCurrentMinScale;
    private int mGesture;
    private float mLastDownX;
    private float mLastDownY;
    private float mLastZoomDistance;
    protected final Matrix mMatrix;
    private final RectF mMatrixBounds;
    private final float mMatrixValues[];
    private float mMidTouchX;
    private float mMidTouchY;
    private final RectF mStartBounds;
    private float mTotalScaleFactor;
    protected RectF mTransformBounds;
    private float mViewHeight;
    private float mViewWidth;

    public MultiTouchImageView(Context context)
    {
        super(context);
        mMatrix = new Matrix();
        mLastZoomDistance = 1.0F;
        mTotalScaleFactor = 1.0F;
        mCurrentMinScale = 1.0F;
        mStartBounds = new RectF();
        mMatrixBounds = new RectF();
        mMatrixValues = new float[9];
        initMultiTouchImageView();
    }

    public MultiTouchImageView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mMatrix = new Matrix();
        mLastZoomDistance = 1.0F;
        mTotalScaleFactor = 1.0F;
        mCurrentMinScale = 1.0F;
        mStartBounds = new RectF();
        mMatrixBounds = new RectF();
        mMatrixValues = new float[9];
        initMultiTouchImageView();
    }

    public MultiTouchImageView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mMatrix = new Matrix();
        mLastZoomDistance = 1.0F;
        mTotalScaleFactor = 1.0F;
        mCurrentMinScale = 1.0F;
        mStartBounds = new RectF();
        mMatrixBounds = new RectF();
        mMatrixValues = new float[9];
        initMultiTouchImageView();
    }

    private float calculateScale(float f, float f1, float f2, float f3, android.widget.ImageView.ScaleType scaletype)
    {
        if (scaletype == android.widget.ImageView.ScaleType.CENTER_CROP)
        {
            if (f > f2)
            {
                return f3 / f2;
            } else
            {
                return f1 / f;
            }
        } else
        {
            return Math.min(f1 / f, f3 / f2);
        }
    }

    private void resetGesture()
    {
        mGesture = 0;
        mLastDownX = 1.401298E-45F;
        mLastDownY = 1.401298E-45F;
        mMidTouchX = 1.401298E-45F;
        mMidTouchY = 1.401298E-45F;
    }

    private void resetScale()
    {
        RectF rectf = updateBounds();
        RectF rectf2 = mTransformBounds;
        if (rectf.left > rectf2.left || rectf.top > rectf2.top || rectf.right < rectf2.right || rectf.bottom < rectf2.bottom)
        {
            float f7 = rectf2.left;
            float f9 = rectf2.width() / 2.0F;
            float f = rectf2.top;
            float f1 = rectf2.height() / 2.0F;
            float f10 = rectf.left;
            float f11 = rectf.width() / 2.0F;
            float f3 = rectf.top;
            float f5 = rectf.height() / 2.0F;
            f7 = (f7 + f9) - (f10 + f11);
            f = (f + f1) - (f3 + f5);
            if (f7 != 0.0F || f != 0.0F)
            {
                mMatrix.postTranslate(f7, f);
                mMatrixBounds.offset(f7, f);
            }
            f = mCurrentMinScale;
            if (mTotalScaleFactor < f)
            {
                float f2 = f / mTotalScaleFactor;
                mTotalScaleFactor = f;
                mMatrix.postScale(f2, f2, mViewWidth / 2.0F, mViewHeight / 2.0F);
                float f6 = mBitmapWidth;
                f = mBitmapHeight;
                float f8 = mTransformBounds.width();
                f2 = mTransformBounds.height();
                float f4 = calculateScale(f6, f8, f, f2, android.widget.ImageView.ScaleType.CENTER_CROP);
                RectF rectf1 = new RectF(mTransformBounds);
                if ((int)(f6 * f4) > (int)f8)
                {
                    f6 = (f6 * f4 - f8) / 2.0F;
                    rectf1.left = rectf1.left - f6;
                    rectf1.right = rectf1.right + f6;
                }
                if ((int)(f * f4) > (int)f2)
                {
                    f = (f * f4 - f2) / 2.0F;
                    rectf1.top = rectf1.top - f;
                    rectf1.bottom = rectf1.bottom + f;
                }
                mMatrixBounds.set(rectf1);
            }
            setImageMatrix(mMatrix);
        }
    }

    private float touchDistance(MotionEvent motionevent)
    {
        float f = motionevent.getX(0) - motionevent.getX(1);
        float f1 = motionevent.getY(0) - motionevent.getY(1);
        return FloatMath.sqrt(f * f + f1 * f1);
    }

    private RectF updateBounds()
    {
        float af[] = mMatrixValues;
        mMatrix.getValues(af);
        float f = af[2];
        float f1 = af[5];
        float f2 = mStartBounds.width();
        float f3 = mTotalScaleFactor;
        float f4 = mStartBounds.height();
        float f5 = mTotalScaleFactor;
        mMatrixBounds.set(f, f1, f + f2 * f3, f1 + f4 * f5);
        return mMatrixBounds;
    }

    void initMultiTouchImageView()
    {
        mGesture = 0;
        setScaleType(android.widget.ImageView.ScaleType.MATRIX);
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
    {
        super.onLayout(flag, i, j, k, l);
        mViewWidth = getMeasuredWidth();
        mViewHeight = getMeasuredHeight();
        if (flag)
        {
            setTransformDimensions(mViewWidth, mViewHeight, android.widget.ImageView.ScaleType.FIT_CENTER, true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction() & 0xff;
        JVM INSTR tableswitch 0 6: default 52
    //                   0 58
    //                   1 706
    //                   2 186
    //                   3 721
    //                   4 52
    //                   5 120
    //                   6 740;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return super.onTouchEvent(motionevent);
_L2:
        if (mTotalScaleFactor > 1.0F)
        {
            getParent().requestDisallowInterceptTouchEvent(true);
        } else
        {
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        if (mGesture == 0)
        {
            mLastDownX = motionevent.getX();
            mLastDownY = motionevent.getY();
            mGesture = 1;
        }
_L9:
        return true;
_L6:
        if (mGesture == 0 || mGesture == 1)
        {
            mMidTouchX = (motionevent.getX(0) + motionevent.getX(1)) / 2.0F;
            mMidTouchY = (motionevent.getY(0) + motionevent.getY(1)) / 2.0F;
            mLastZoomDistance = touchDistance(motionevent);
            mGesture = 2;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (mGesture == 1)
        {
            float f4 = motionevent.getX();
            float f5 = motionevent.getY();
            float f = f4 - mLastDownX;
            float f2 = f5 - mLastDownY;
            float f10 = mMatrixBounds.left;
            float f11 = mMatrixBounds.right;
            float f6 = mMatrixBounds.top;
            float f7 = mMatrixBounds.bottom;
            motionevent = mTransformBounds;
            float f12 = ((RectF) (motionevent)).left;
            float f8 = ((RectF) (motionevent)).top;
            float f13 = ((RectF) (motionevent)).right;
            float f9 = ((RectF) (motionevent)).bottom;
            boolean flag;
            boolean flag1;
            if (mLastDownY > f5)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (mLastDownX > f4)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                if (f11 > f13 && f11 + f < f13)
                {
                    f = f13 - f11;
                } else
                if (f11 <= f13)
                {
                    f = 0.0F;
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else
            if (f10 < f12 && f10 + f > f12)
            {
                f = f12 - f10;
            } else
            if (f10 >= f12)
            {
                f = 0.0F;
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (flag)
            {
                if (f7 > f9 && f7 + f2 < f9)
                {
                    f2 = f9 - f7;
                } else
                if (f7 <= f9)
                {
                    f2 = 0.0F;
                }
            } else
            if (f6 < f8 && f6 + f2 > f8)
            {
                f2 = f8 - f6;
            } else
            if (f6 >= f8)
            {
                f2 = 0.0F;
            }
            if (f != 0.0F || f2 != 0.0F)
            {
                mMatrix.postTranslate(f, f2);
                mMatrixBounds.offset(f, f2);
                setImageMatrix(mMatrix);
            }
            mLastDownX = f4;
            mLastDownY = f5;
            continue; /* Loop/switch isn't completed */
        } else
        {
            if (mGesture == 2)
            {
                float f1 = touchDistance(motionevent);
                float f3 = f1 / mLastZoomDistance;
                mTotalScaleFactor = mTotalScaleFactor * f3;
                motionevent = updateBounds();
                if (((RectF) (motionevent)).left < 0.0F && ((RectF) (motionevent)).top < 0.0F && ((RectF) (motionevent)).right > mViewWidth && ((RectF) (motionevent)).bottom > mViewHeight)
                {
                    mMatrix.postScale(f3, f3, mMidTouchX, mMidTouchY);
                } else
                {
                    mMatrix.postScale(f3, f3, mViewWidth / 2.0F, mViewHeight / 2.0F);
                }
                mLastZoomDistance = f1;
                setImageMatrix(mMatrix);
            } else
            {
                return super.onTouchEvent(motionevent);
            }
            continue; /* Loop/switch isn't completed */
        }
_L3:
        if (mGesture == 1)
        {
            resetGesture();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mGesture == 2)
        {
            resetScale();
        }
        resetGesture();
        continue; /* Loop/switch isn't completed */
_L7:
        if (mGesture == 2)
        {
            resetScale();
            resetGesture();
        }
        if (true) goto _L9; else goto _L8
_L8:
    }

    public void setImageBitmap(Bitmap bitmap)
    {
        super.setImageBitmap(bitmap);
        if (bitmap != null)
        {
            mBitmapWidth = bitmap.getWidth();
            mBitmapHeight = bitmap.getHeight();
            setTransformDimensions(mViewWidth, mViewHeight, android.widget.ImageView.ScaleType.FIT_CENTER, true);
        }
    }

    public void setTransformDimensions(float f, float f1, android.widget.ImageView.ScaleType scaletype, boolean flag)
    {
        float f6 = mViewWidth;
        float f2 = (f6 - f) / 2.0F;
        float f7 = mViewHeight;
        float f3 = (f7 - f1) / 2.0F;
        float f4 = mStartBounds.width();
        float f5 = mStartBounds.height();
        if (mTransformBounds == null)
        {
            mTransformBounds = new RectF(f2, f3, f2 + f, f3 + f1);
        } else
        {
            mTransformBounds.set(f2, f3, f2 + f, f3 + f1);
        }
        if (f4 != 0.0F && f5 != 0.0F)
        {
            mCurrentMinScale = calculateScale(f4, f, f5, f1, scaletype);
        }
        if (!flag && mMatrixBounds.contains(mTransformBounds))
        {
            return;
        }
        f4 = 0.0F;
        f5 = 0.0F;
        float f9 = mBitmapWidth;
        float f8 = mBitmapHeight;
        f3 = f4;
        f2 = f5;
        if (f9 > 0.0F)
        {
            f3 = f4;
            f2 = f5;
            if (f8 > 0.0F)
            {
                f = calculateScale(f9, f, f8, f1, scaletype);
                f3 = (f6 - f * f9) / 2.0F;
                f2 = (f7 - f * f8) / 2.0F;
                scaletype = mMatrix;
                scaletype.setScale(f, f);
                scaletype.postTranslate(f3, f2);
                setImageMatrix(scaletype);
            }
        }
        mStartBounds.set(f3, f2, f6 - f3, f7 - f2);
        mMatrixBounds.set(mStartBounds);
        mTotalScaleFactor = 1.0F;
    }
}
