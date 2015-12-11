// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import co.vine.android.util.SystemUtil;

public class AnimatingCircle extends View
{
    public static interface AnimatingCircleListener
    {

        public abstract void onAnimationEnd();

        public abstract void onAnimationRepeat();

        public abstract void onAnimationStart();
    }

    public class AnimationRunnable
        implements Runnable
    {

        final AnimatingCircle this$0;

        public void run()
        {
            mNewRadius = mNewRadius + mStepDistance;
            invalidate();
            startDefaultAnimation();
        }

        public AnimationRunnable()
        {
            this$0 = AnimatingCircle.this;
            super();
        }
    }


    private static final double COSINE_45_DEGREES = Math.cos(0.83775806427001953D);
    private static final int DEFAULT_DURATION = 250;
    private static final double FORTY_FIVE_DEGREES_IN_RADIANS = 0.83775806427001953D;
    private static final int STEP_LENGTH = 5;
    private int mBackgroundColor;
    private final Paint mClearPaint;
    private float mHypoteneuse;
    private boolean mIsAnimating;
    private AnimatingCircleListener mListener;
    private float mNewRadius;
    private final Paint mPaint;
    private final int mRadius;
    private Runnable mRunnable;
    private float mStepDistance;
    private int mXMargin;
    private final float mXOffset;

    public AnimatingCircle(Context context)
    {
        this(context, null);
    }

    public AnimatingCircle(Context context, AttributeSet attributeset)
    {
        this(context, attributeset, 0);
    }

    public AnimatingCircle(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        Resources resources = context.getResources();
        attributeset = context.obtainStyledAttributes(attributeset, co.vine.android.R.styleable.AnimatingCircle, i, 0);
        mBackgroundColor = attributeset.getColor(0, resources.getColor(0x7f090048));
        mRadius = attributeset.getDimensionPixelOffset(1, resources.getDimensionPixelOffset(0x7f0b006d));
        attributeset.recycle();
        mPaint = new Paint();
        mClearPaint = new Paint();
        mClearPaint.setAntiAlias(true);
        mClearPaint.setDither(true);
        mClearPaint.setFilterBitmap(true);
        mClearPaint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.CLEAR));
        context = SystemUtil.getDisplaySize(context);
        float f = (float)(Math.max(((Point) (context)).x, ((Point) (context)).y) / 2) / (float)COSINE_45_DEGREES;
        float f1 = f / (float)mRadius;
        mHypoteneuse = f;
        mXOffset = resources.getDimensionPixelOffset(0x7f0b0017);
        mXMargin = resources.getDimensionPixelOffset(0x7f0b0036);
        mRunnable = new AnimationRunnable();
        mStepDistance = ((mHypoteneuse - (float)mRadius) / 250F) * 5F;
        mIsAnimating = false;
        setLayerType(1, null);
    }

    protected void onDraw(Canvas canvas)
    {
        if (mNewRadius == 0.0F)
        {
            mNewRadius = mRadius;
        }
        mPaint.setColor(mBackgroundColor);
        canvas.drawRect(0.0F, 0.0F, getMeasuredWidth() - mXMargin, getMeasuredHeight(), mPaint);
        canvas.drawCircle((float)(getMeasuredWidth() / 2) + mXOffset, getMeasuredHeight() / 2, mNewRadius, mClearPaint);
    }

    public void resetAnimation()
    {
        mNewRadius = 0.0F;
        mIsAnimating = false;
    }

    public void setAnimationListener(AnimatingCircleListener animatingcirclelistener)
    {
        mListener = animatingcirclelistener;
    }

    public void startDefaultAnimation()
    {
        if (!mIsAnimating)
        {
            mIsAnimating = true;
            mListener.onAnimationStart();
        } else
        {
            mListener.onAnimationRepeat();
        }
        if (mNewRadius < mHypoteneuse)
        {
            Handler handler = getHandler();
            if (handler != null)
            {
                handler.removeCallbacks(mRunnable);
                handler.postDelayed(mRunnable, 5L);
            }
            return;
        } else
        {
            mIsAnimating = false;
            mListener.onAnimationEnd();
            return;
        }
    }




/*
    static float access$002(AnimatingCircle animatingcircle, float f)
    {
        animatingcircle.mNewRadius = f;
        return f;
    }

*/

}
