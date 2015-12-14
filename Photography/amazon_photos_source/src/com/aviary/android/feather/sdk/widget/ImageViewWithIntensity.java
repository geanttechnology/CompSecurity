// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.ValueAnimator;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import it.sephiroth.android.library.imagezoom.graphics.FastBitmapDrawable;

public class ImageViewWithIntensity extends ImageViewTouch
{
    private class MyGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
    {

        final ImageViewWithIntensity this$0;

        public boolean onDoubleTap(MotionEvent motionevent)
        {
            return false;
        }

        public boolean onDown(MotionEvent motionevent)
        {
            return ImageViewWithIntensity.this.onDown(motionevent);
        }

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return false;
        }

        public void onLongPress(MotionEvent motionevent)
        {
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return ImageViewWithIntensity.this.onScroll(motionevent, motionevent1, f, f1);
        }

        public boolean onSingleTapUp(MotionEvent motionevent)
        {
            return false;
        }

        private MyGestureListener()
        {
            this$0 = ImageViewWithIntensity.this;
            super();
        }

    }

    public class MyScaleListener extends android.view.ScaleGestureDetector.SimpleOnScaleGestureListener
    {

        final ImageViewWithIntensity this$0;

        public boolean onScale(ScaleGestureDetector scalegesturedetector)
        {
            mDownPoint = null;
            mScrollVerticalStarted = false;
            return true;
        }

        public MyScaleListener()
        {
            this$0 = ImageViewWithIntensity.this;
            super();
        }
    }

    public static interface OnIntensityChange
    {

        public abstract void onIntensityInit();

        public abstract void onIntensitySwipeChanged(float f);

        public abstract void onIntensitySwipeChanging(float f);

        public abstract void onIntensitySwipeStarted(float f);
    }


    private static final float RAD;
    private static final float RAD_COS;
    private static final float RAD_SIN;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger = LoggerFactory.getLogger(com/aviary/android/feather/sdk/widget/ImageViewWithIntensity.getSimpleName());
    private PointF mCurrentPoint;
    private PointF mDownPoint;
    private GestureDetector mGestureDetector;
    private float mIntensity;
    private boolean mIntensityInitiated;
    private OnIntensityChange mIntensityListener;
    private Path mPath1;
    private Path mPath2;
    private Path mPath3;
    private ValueAnimator mPlayDemoAnimator;
    private FastBitmapDrawable mPreviewBitmapDrawable;
    private boolean mScrollVerticalStarted;
    private boolean mSwipeGestureEnabled;
    private Paint mTextPaint;
    private Paint mTipArcPaint;
    private float mTipArcStrokeWeight;
    private int mTipBackgroundColor;
    private Paint mTipPaint;
    private int mTipRadius;
    private final RectF mTipRect;
    private int mTipSize;
    private int mTipTextColor;
    private float mTouchSlop;
    private boolean mVaryTipHue;
    private boolean mVaryTipStroke;
    private final Rect tempRect;

    public ImageViewWithIntensity(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public ImageViewWithIntensity(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mTipRect = new RectF();
        tempRect = new Rect();
        mCurrentPoint = new PointF();
        mVaryTipStroke = true;
        mVaryTipHue = true;
        mGestureDetector = new GestureDetector(context, getGestureListener());
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        context = context.getTheme().obtainStyledAttributes(attributeset, com.aviary.android.feather.sdk.R.styleable.AviaryImageViewIntensity, i, 0);
        mTipSize = context.getDimensionPixelSize(com.aviary.android.feather.sdk.R.styleable.AviaryImageViewIntensity_aviary_tooltipSize, 200);
        mTipArcStrokeWeight = context.getDimension(com.aviary.android.feather.sdk.R.styleable.AviaryImageViewIntensity_aviary_strokeWidth, 14F);
        mTipBackgroundColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryImageViewIntensity_aviary_strokeColor, 0xff000000);
        mTipTextColor = context.getColor(com.aviary.android.feather.sdk.R.styleable.AviaryImageViewIntensity_android_textColor, 0xff000000);
        mTipRadius = mTipSize / 2;
        context.recycle();
        mPath1 = new Path();
        mPath2 = new Path();
        mPath3 = new Path();
        mTipPaint = new Paint(1);
        mTipPaint.setColor(mTipBackgroundColor);
        mTipArcPaint = new Paint(1);
        mTipArcPaint.setStyle(android.graphics.Paint.Style.FILL);
        mTextPaint = new Paint(1);
        mTextPaint.setTextSize(mTipSize / 3);
        mTextPaint.setColor(mTipTextColor);
        mTextPaint.setAntiAlias(true);
        mTextPaint.setLinearText(true);
    }

    private boolean onDown(float f, float f1, boolean flag)
    {
        if (!mSwipeGestureEnabled)
        {
            return true;
        }
        if (flag && mPlayDemoAnimator != null && mPlayDemoAnimator.isStarted())
        {
            mPlayDemoAnimator.cancel();
            mPlayDemoAnimator = null;
        }
        mDownPoint = new PointF(f, f1);
        mCurrentPoint.set(mDownPoint);
        mScrollVerticalStarted = false;
        return true;
    }

    private boolean onScroll(float f, float f1, float f2, float f3, boolean flag)
    {
        if (!mSwipeGestureEnabled || mDownPoint == null)
        {
            return true;
        }
        f2 = f - mDownPoint.x;
        f3 = f1 - mDownPoint.y;
        if (!mScrollVerticalStarted)
        {
            if (Math.abs(f2) > mTouchSlop || Math.abs(f3) > mTouchSlop)
            {
                if (Math.abs(f2) > Math.abs(f3))
                {
                    mScrollVerticalStarted = false;
                    mDownPoint = null;
                    return false;
                }
                logger.warn("ok, started!!!!");
                mScrollVerticalStarted = true;
                if (mIntensityListener != null && !mIntensityInitiated)
                {
                    mIntensityListener.onIntensityInit();
                    mIntensityInitiated = true;
                }
                if (mIntensityListener != null)
                {
                    mIntensityListener.onIntensitySwipeStarted(mIntensity);
                }
            }
            return true;
        }
        f2 = mCurrentPoint.y;
        mCurrentPoint.set(f, f1);
        f = (f1 - f2) / ((float)getHeight() / 2.0F);
        setIntensity(Math.min(255F, Math.max(0.0F, mIntensity - f * 255F)));
        if (mIntensityListener != null)
        {
            mIntensityListener.onIntensitySwipeChanging(mIntensity);
        }
        return true;
    }

    public void finishIntensityChanging()
    {
        onUp(null);
    }

    public void generateBitmap(Bitmap bitmap, float f)
    {
        logger.info("generateBitmap, intensity: %f", new Object[] {
            Float.valueOf(f)
        });
        bitmap = new Canvas(bitmap);
        if (mPreviewBitmapDrawable != null)
        {
            mPreviewBitmapDrawable.setAlpha((int)f);
            mPreviewBitmapDrawable.draw(bitmap);
        }
    }

    protected android.view.GestureDetector.OnGestureListener getGestureListener()
    {
        return new MyGestureListener();
    }

    public float getIntensity()
    {
        return mIntensity;
    }

    protected android.view.ScaleGestureDetector.OnScaleGestureListener getScaleListener()
    {
        return new MyScaleListener();
    }

    public int getTooltipSize()
    {
        return mTipSize;
    }

    public boolean onDown(MotionEvent motionevent)
    {
        if (mSwipeGestureEnabled)
        {
            return onDown(motionevent.getX(), motionevent.getY(), true);
        } else
        {
            return super.onDown(motionevent);
        }
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (getDrawable() != null)
        {
            if (mPreviewBitmapDrawable != null)
            {
                mPreviewBitmapDrawable.setAlpha((int)mIntensity);
                canvas.save();
                canvas.concat(getImageMatrix());
                mPreviewBitmapDrawable.draw(canvas);
                canvas.restore();
            }
            if (mScrollVerticalStarted)
            {
                int j = canvas.save();
                int k = (int)((double)mIntensity / 2.5499999999999998D);
                Object obj = String.valueOf(k);
                float f2 = mCurrentPoint.x - (float)mTipSize * 1.2F;
                float f6 = mCurrentPoint.y;
                boolean flag = false;
                int i = 10;
                float f = f2;
                if (f2 - (float)mTipRadius - mTipArcStrokeWeight * 2.0F < 0.0F)
                {
                    f = mCurrentPoint.x + (float)mTipSize * 1.2F;
                    i = 10 + 180;
                    flag = true;
                }
                mTipRect.set(f - (float)mTipRadius, f6 - (float)mTipRadius, (float)mTipRadius + f, (float)mTipRadius + f6);
                f2 = (mTipRect.width() / 2.0F) * RAD_COS;
                float f7 = (mTipRect.height() / 2.0F) * RAD_SIN;
                mPath1.reset();
                mPath1.addArc(mTipRect, i, 340F);
                Object obj1 = mPath1;
                float f4;
                float f5;
                if (flag)
                {
                    f4 = -f2;
                } else
                {
                    f4 = f2;
                }
                if (flag)
                {
                    f5 = f6 + f7;
                } else
                {
                    f5 = f6 - f7;
                }
                ((Path) (obj1)).moveTo(f + f4, f5);
                obj1 = mPath1;
                if (flag)
                {
                    f4 = -f2 - (float)(mTipRadius / 4);
                } else
                {
                    f4 = (float)(mTipRadius / 4) + f2;
                }
                ((Path) (obj1)).lineTo(f4 + f, f6);
                obj1 = mPath1;
                f4 = f2;
                if (flag)
                {
                    f4 = -f2;
                }
                if (flag)
                {
                    f2 = f6 - f7;
                } else
                {
                    f2 = f6 + f7;
                }
                ((Path) (obj1)).lineTo(f + f4, f2);
                canvas.drawPath(mPath1, mTipPaint);
                mTextPaint.getTextBounds(((String) (obj)), 0, ((String) (obj)).length(), tempRect);
                f2 = (mTipSize - tempRect.width()) / 2;
                canvas.drawText(((String) (obj)), (f - (float)mTipRadius) + f2, (float)(tempRect.height() / 2) + f6, mTextPaint);
                mTipArcPaint.setColor(mTipBackgroundColor);
                mTipRect.inset(-2F, -2F);
                mPath2.reset();
                mPath2.moveTo(mTipRect.centerX(), mTipRect.bottom);
                obj = mPath2;
                obj1 = mTipRect;
                if (flag)
                {
                    f2 = -180F;
                } else
                {
                    f2 = 180F;
                }
                ((Path) (obj)).arcTo(((RectF) (obj1)), 90F, f2);
                if (mVaryTipStroke)
                {
                    mTipRect.inset(-mTipArcStrokeWeight, -mTipArcStrokeWeight);
                    mTipRect.offset(0.0F, -(mTipArcStrokeWeight * 0.65F));
                } else
                {
                    mTipRect.inset(-(mTipArcStrokeWeight / 2.0F) - 1.0F, -(mTipArcStrokeWeight / 2.0F) - 1.0F);
                }
                mPath2.lineTo(mTipRect.centerX(), mTipRect.top);
                obj = mPath2;
                obj1 = mTipRect;
                if (flag)
                {
                    f2 = 180F;
                } else
                {
                    f2 = -180F;
                }
                ((Path) (obj)).arcTo(((RectF) (obj1)), -90F, f2);
                mPath2.lineTo(mTipRect.centerX(), mTipRect.bottom - mTipArcStrokeWeight * 0.35F);
                canvas.drawPath(mPath2, mTipArcPaint);
                mTipRect.set(f - (float)mTipRadius, f6 - (float)mTipRadius, (float)mTipRadius + f, (float)mTipRadius + f6);
                mTipRect.inset(-2F, -2F);
                if (mVaryTipHue)
                {
                    i = Color.HSVToColor(255, new float[] {
                        (float)(k * 2), 1.0F, 1.0F
                    });
                } else
                {
                    i = Color.HSVToColor(255, new float[] {
                        200F, 1.0F, 1.0F
                    });
                }
                mTipArcPaint.setColor(i);
                if (k > 0)
                {
                    float f1 = ((float)k / 100F) * 180F;
                    mPath3.reset();
                    if (mVaryTipStroke)
                    {
                        mPath3.moveTo(mTipRect.centerX(), mTipRect.bottom);
                        Path path = mPath3;
                        RectF rectf = mTipRect;
                        if (flag)
                        {
                            f2 = -f1;
                        } else
                        {
                            f2 = f1;
                        }
                        path.arcTo(rectf, 90F, f2);
                        mTipRect.inset(-mTipArcStrokeWeight, -mTipArcStrokeWeight);
                        mTipRect.offset(0.0F, -(mTipArcStrokeWeight * 0.65F));
                        f2 = (float)Math.sin(Math.toRadians(f1));
                        f1 = (float)((double)f1 - ((double)(mTipArcStrokeWeight * 1.05F) / 3.1415926535897931D) * (double)f2);
                        path = mPath3;
                        rectf = mTipRect;
                        if (flag)
                        {
                            f2 = -f1;
                        } else
                        {
                            f2 = f1;
                        }
                        if (!flag)
                        {
                            f1 = -f1;
                        }
                        path.arcTo(rectf, f2 + 90F, f1);
                        mPath3.lineTo(mTipRect.centerX(), mTipRect.bottom - mTipArcStrokeWeight * 0.35F);
                    } else
                    {
                        Path path1 = mPath3;
                        RectF rectf1 = mTipRect;
                        float f3;
                        if (flag)
                        {
                            f3 = -f1;
                        } else
                        {
                            f3 = f1;
                        }
                        path1.arcTo(rectf1, 90F, f3);
                        mTipRect.inset(-(mTipArcStrokeWeight / 2.0F) - 1.0F, -(mTipArcStrokeWeight / 2.0F) - 1.0F);
                        path1 = mPath3;
                        rectf1 = mTipRect;
                        if (flag)
                        {
                            f3 = -f1;
                        } else
                        {
                            f3 = f1;
                        }
                        if (!flag)
                        {
                            f1 = -f1;
                        }
                        path1.arcTo(rectf1, f3 + 90F, f1);
                        mPath3.lineTo(mTipRect.centerX(), mTipRect.bottom - mTipArcStrokeWeight * 0.35F);
                    }
                    canvas.drawPath(mPath3, mTipArcPaint);
                }
                canvas.restoreToCount(j);
            }
        }
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (mDownPoint == null || getBitmapRect() == null || !mSwipeGestureEnabled || mScaleDetector.isInProgress())
        {
            return false;
        } else
        {
            return onScroll(motionevent1.getX(), motionevent1.getY(), f, f1, true);
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (getBitmapRect() == null || getBitmapRect().isEmpty())
        {
            return false;
        }
        mScaleDetector.onTouchEvent(motionevent);
        if (!mScaleDetector.isInProgress())
        {
            mGestureDetector.onTouchEvent(motionevent);
        }
        switch (motionevent.getAction() & 0xff)
        {
        default:
            return true;

        case 1: // '\001'
            return onUp(motionevent);
        }
    }

    public boolean onUp(MotionEvent motionevent)
    {
        mDownPoint = null;
        mScrollVerticalStarted = false;
        if (mIntensityListener != null && mSwipeGestureEnabled)
        {
            mIntensityListener.onIntensitySwipeChanged(mIntensity);
        }
        postInvalidate();
        return true;
    }

    public PointF playDemo()
    {
        final PointF downPoint = new PointF(getWidth() - mTipRadius / 2, getHeight() / 4);
        mPlayDemoAnimator = ValueAnimator.ofInt(new int[] {
            0, getHeight() / 4, 0
        });
        mPlayDemoAnimator.setDuration(3000L);
        mPlayDemoAnimator.setStartDelay(300L);
        mPlayDemoAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mPlayDemoAnimator.start();
        mPlayDemoAnimator.addUpdateListener(new com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener() {

            final ImageViewWithIntensity this$0;

            public void onAnimationUpdate(ValueAnimator valueanimator)
            {
                if (mDownPoint == null)
                {
                    return;
                } else
                {
                    valueanimator = (Integer)valueanimator.getAnimatedValue();
                    onScroll(mDownPoint.x, mDownPoint.y + (float)valueanimator.intValue(), 0.0F, valueanimator.intValue(), false);
                    return;
                }
            }

            
            {
                this$0 = ImageViewWithIntensity.this;
                super();
            }
        });
        mPlayDemoAnimator.addListener(new com.nineoldandroids.animation.Animator.AnimatorListener() {

            final ImageViewWithIntensity this$0;
            final PointF val$downPoint;

            public void onAnimationCancel(Animator animator)
            {
            }

            public void onAnimationEnd(Animator animator)
            {
                onUp(null);
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
                onDown(downPoint.x, downPoint.y, false);
            }

            
            {
                this$0 = ImageViewWithIntensity.this;
                downPoint = pointf;
                super();
            }
        });
        return downPoint;
    }

    public void setIntensity(float f)
    {
        mIntensity = f;
        invalidate();
    }

    public void setOnIntensityChangeListener(OnIntensityChange onintensitychange)
    {
        mIntensityListener = onintensitychange;
    }

    public void setPreviewBitmap(Bitmap bitmap, float f)
    {
        if (bitmap != null) goto _L2; else goto _L1
_L1:
        mPreviewBitmapDrawable = null;
_L4:
        mIntensity = f;
        postInvalidate();
        return;
_L2:
        if (getDrawable() != null && getDrawable().getIntrinsicWidth() == bitmap.getWidth() && getDrawable().getIntrinsicHeight() == bitmap.getHeight())
        {
            mPreviewBitmapDrawable = new FastBitmapDrawable(bitmap);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void setSwipeGestureEnabled(boolean flag)
    {
        mSwipeGestureEnabled = flag;
    }

    public void setVaryTipHue(boolean flag)
    {
        mVaryTipHue = flag;
    }

    public void setVaryTipStroke(boolean flag)
    {
        mVaryTipStroke = flag;
    }

    static 
    {
        RAD = (float)Math.toRadians(10D);
        RAD_COS = (float)Math.cos(RAD);
        RAD_SIN = (float)Math.sin(RAD);
    }



/*
    static PointF access$102(ImageViewWithIntensity imageviewwithintensity, PointF pointf)
    {
        imageviewwithintensity.mDownPoint = pointf;
        return pointf;
    }

*/




/*
    static boolean access$402(ImageViewWithIntensity imageviewwithintensity, boolean flag)
    {
        imageviewwithintensity.mScrollVerticalStarted = flag;
        return flag;
    }

*/
}
