// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.IBitmapDrawable;

public class ImageViewSpotSingleTap extends ImageViewTouch
    implements com.nineoldandroids.animation.Animator.AnimatorListener
{
    public static interface OnTapListener
    {

        public abstract void onTap(float af[], float f);
    }

    class TapScaleListener extends it.sephiroth.android.library.imagezoom.ImageViewTouch.ScaleListener
    {

        final ImageViewSpotSingleTap this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            if (mTouchMode == TouchMode.DRAW)
            {
                mX = scalegesturedetector.getFocusX();
                mY = scalegesturedetector.getFocusY();
                postInvalidate();
                return true;
            } else
            {
                return super.onScale(scalegesturedetector);
            }
        }

        public boolean onScaleBegin(ScaleGestureDetector scalegesturedetector)
        {
            if (mTouchMode == TouchMode.DRAW)
            {
                mX = scalegesturedetector.getFocusX();
                mY = scalegesturedetector.getFocusY();
                mStartX = mX;
                mStartY = mY;
                mCanceled = true;
                postInvalidate();
                return true;
            } else
            {
                return super.onScaleBegin(scalegesturedetector);
            }
        }

        public void onScaleEnd(ScaleGestureDetector scalegesturedetector)
        {
            mCanceled = false;
            super.onScaleEnd(scalegesturedetector);
        }

        TapScaleListener()
        {
            this$0 = ImageViewSpotSingleTap.this;
            super(ImageViewSpotSingleTap.this);
        }
    }

    public static final class TouchMode extends Enum
    {

        private static final TouchMode $VALUES[];
        public static final TouchMode DRAW;
        public static final TouchMode IMAGE;

        public static TouchMode valueOf(String s)
        {
            return (TouchMode)Enum.valueOf(com/aviary/android/feather/sdk/widget/ImageViewSpotSingleTap$TouchMode, s);
        }

        public static TouchMode[] values()
        {
            return (TouchMode[])$VALUES.clone();
        }

        static 
        {
            IMAGE = new TouchMode("IMAGE", 0);
            DRAW = new TouchMode("DRAW", 1);
            $VALUES = (new TouchMode[] {
                IMAGE, DRAW
            });
        }

        private TouchMode(String s, int i)
        {
            super(s, i);
        }
    }


    public static final double BRUSH_SIZE_ANIMATION_SCALE = 1.3D;
    public static final float DEFAULT_TEXT_SIZE = 50F;
    AnimatorSet mAnimator;
    private float mBrushSize;
    boolean mCanceled;
    protected float mCurrentScale;
    boolean mDrawFadeCircle;
    protected Matrix mInvertedMatrix;
    private Paint mShapePaint;
    protected float mStartX;
    protected float mStartY;
    private OnTapListener mTapListener;
    Rect mTextBounds;
    private Paint mTextPaint;
    RectF mTextRect;
    private Paint mTextRectPaint;
    private float mTextSize;
    private String mToolTip;
    protected TouchMode mTouchMode;
    protected float mX;
    protected float mY;
    private float radius;
    private float textPadding;
    private float xTextOffset;
    private float yTextOffset;

    public ImageViewSpotSingleTap(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageViewSpotSingleTap(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mCurrentScale = 1.0F;
        mInvertedMatrix = new Matrix();
        mTouchMode = TouchMode.DRAW;
        mX = 0.0F;
        mY = 0.0F;
        mDrawFadeCircle = true;
        mCanceled = false;
        mTextRect = new RectF();
        mTextBounds = new Rect();
        mBrushSize = 10F;
        radius = 0.0F;
        mShapePaint = new Paint();
        mTextPaint = new Paint();
        mTextRectPaint = new Paint();
        mToolTip = "";
        mTextSize = 50F;
        xTextOffset = 150F;
        yTextOffset = 150F;
        textPadding = 20F;
        onCreate(context);
    }

    public static float[] getMatrixValues(Matrix matrix)
    {
        float af[] = new float[9];
        matrix.getValues(af);
        return af;
    }

    private void onCreate(Context context)
    {
        mToolTip = context.getString(com.aviary.android.feather.sdk.R.string.feather_blemish_tool_tip);
        mTextSize = context.getResources().getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_textSizeMedium);
        textPadding = mTextSize / 2.0F;
        yTextOffset = mTextSize * 3F;
        xTextOffset = yTextOffset;
        mAnimator = new AnimatorSet();
        mAnimator.addListener(this);
        mShapePaint.setAntiAlias(true);
        mShapePaint.setStyle(android.graphics.Paint.Style.STROKE);
        mShapePaint.setColor(-1);
        mShapePaint.setStrokeWidth(6F);
        mTextPaint.setColor(-1);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.getTextBounds(mToolTip, 0, mToolTip.length(), mTextBounds);
        mTextRectPaint.setARGB(150, 0, 0, 0);
        setLongClickable(false);
    }

    private void startAnimation()
    {
        radius = 0.0F;
        mShapePaint.setAlpha(255);
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(this, "radius", new float[] {
            0.0F, mBrushSize
        });
        objectanimator.setDuration(200L);
        AnimatorSet animatorset = new AnimatorSet();
        animatorset.setInterpolator(new DecelerateInterpolator(1.0F));
        animatorset.setDuration(200L);
        animatorset.playTogether(new Animator[] {
            ObjectAnimator.ofFloat(this, "radius", new float[] {
                mBrushSize, (float)(int)((double)mBrushSize * 1.3D)
            }), ObjectAnimator.ofInt(mShapePaint, "alpha", new int[] {
                255, 0
            })
        });
        mAnimator.playSequentially(new Animator[] {
            objectanimator, animatorset
        });
        mAnimator.setInterpolator(new AccelerateInterpolator(1.0F));
        mAnimator.start();
    }

    public TouchMode getDrawMode()
    {
        return mTouchMode;
    }

    public RectF getImageRect()
    {
        if (getDrawable() != null)
        {
            return new RectF(0.0F, 0.0F, getDrawable().getIntrinsicWidth(), getDrawable().getIntrinsicHeight());
        } else
        {
            return null;
        }
    }

    public float getRadius()
    {
        return radius;
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new TapScaleListener();
    }

    protected void init(Context context, AttributeSet attributeset, int i)
    {
        super.init(context, attributeset, i);
    }

    public void onAnimationCancel(Animator animator)
    {
    }

    public void onAnimationEnd(Animator animator)
    {
        invalidate();
    }

    public void onAnimationRepeat(Animator animator)
    {
        invalidate();
    }

    public void onAnimationStart(Animator animator)
    {
        invalidate();
    }

    public boolean onDown(MotionEvent motionevent)
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            mX = motionevent.getX();
            mStartX = mX;
            mY = motionevent.getY();
            mStartY = mY;
            mDrawFadeCircle = false;
        }
        return super.onDown(motionevent);
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (mDrawFadeCircle && radius > 0.0F)
        {
            canvas.drawCircle(mX, mY, radius, mShapePaint);
        }
        if (mCanceled)
        {
            mTextRect.set(mX - textPadding - xTextOffset, mY - (float)mTextBounds.height() * 1.25F - textPadding - yTextOffset, (mX + (float)mTextBounds.width() + textPadding) - xTextOffset, (mY + (float)mTextBounds.height() * 0.5F + textPadding) - yTextOffset);
            canvas.drawRoundRect(mTextRect, 10F, 10F, mTextRectPaint);
            canvas.drawText(mToolTip, mX - xTextOffset, mY - yTextOffset, mTextPaint);
        }
    }

    protected void onDrawModeChanged()
    {
        boolean flag1 = true;
        if (mTouchMode == TouchMode.DRAW)
        {
            Matrix matrix = new Matrix(getImageMatrix());
            mInvertedMatrix.reset();
            float af[] = getMatrixValues(matrix);
            matrix.invert(matrix);
            float af1[] = getMatrixValues(matrix);
            mInvertedMatrix.postTranslate(-af[2], -af[5]);
            mInvertedMatrix.postScale(af1[0], af1[4]);
            mCurrentScale = getScale() * getBaseScale();
        }
        boolean flag;
        if (mTouchMode == TouchMode.IMAGE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setDoubleTapEnabled(flag);
        if (mTouchMode == TouchMode.IMAGE)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        setScaleEnabled(flag);
    }

    protected void onDrawableChanged(Drawable drawable)
    {
        super.onDrawableChanged(drawable);
        if (drawable != null && (drawable instanceof IBitmapDrawable))
        {
            onDrawModeChanged();
        }
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            return false;
        } else
        {
            return super.onFling(motionevent, motionevent1, f, f1);
        }
    }

    protected void onLayoutChanged(int i, int j, int k, int l)
    {
        super.onLayoutChanged(i, j, k, l);
        if (getDrawable() != null)
        {
            onDrawModeChanged();
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            mX = motionevent1.getX();
            mY = motionevent1.getY();
            mCanceled = true;
            postInvalidate();
            return false;
        } else
        {
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
    }

    public boolean onSingleTapConfirmed(MotionEvent motionevent)
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            mDrawFadeCircle = true;
            startAnimation();
            if (mTapListener != null)
            {
                float af[] = new float[2];
                af[0] = motionevent.getX();
                af[1] = motionevent.getY();
                mInvertedMatrix.mapPoints(af);
                mTapListener.onTap(af, mBrushSize / mCurrentScale);
            }
            return true;
        } else
        {
            return super.onSingleTapConfirmed(motionevent);
        }
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        if (mTouchMode == TouchMode.DRAW)
        {
            return false;
        } else
        {
            return super.onSingleTapUp(motionevent);
        }
    }

    public boolean onUp(MotionEvent motionevent)
    {
        mCanceled = false;
        postInvalidate();
        return super.onUp(motionevent);
    }

    public void setBrushSize(float f)
    {
        mBrushSize = f;
    }

    public void setDrawMode(TouchMode touchmode)
    {
        if (touchmode != mTouchMode)
        {
            mTouchMode = touchmode;
            onDrawModeChanged();
        }
    }

    public void setOnTapListener(OnTapListener ontaplistener)
    {
        mTapListener = ontaplistener;
    }

    public void setRadius(float f)
    {
        radius = f;
        invalidate();
    }
}
