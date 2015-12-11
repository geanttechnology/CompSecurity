// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CounterView extends View
    implements Runnable
{
    public static class AnimationMode
    {

        public final boolean alphaAnimation;
        public final boolean continuousAnimation;
        public final boolean pedometerAnimation;

        public AnimationMode(boolean flag, boolean flag1, boolean flag2)
        {
            continuousAnimation = flag;
            pedometerAnimation = flag1;
            alphaAnimation = flag2;
        }
    }

    public class DigitAnimation
    {

        public long mAnimatingCount;
        public long mAnimationDuration;
        public long mAnimationStartTime;
        public int mCurrentAnimatingToDigit;
        private final double mDivider;
        public int mDrawingDigit;
        public final int mIndexFromRight;
        public boolean mIsAnimating;
        private final double mNextDivider;
        final CounterView this$0;

        public boolean invalidate(long l, long l1, boolean flag)
        {
label0:
            {
label1:
                {
                    int j = mDrawingDigit;
                    int i = j;
                    if (mIsAnimating)
                    {
                        i = j;
                        if (l - mAnimationStartTime > mAnimationDuration)
                        {
                            boolean flag1;
                            if (mIndexFromRight > 0)
                            {
                                i = (int)(((double)mAnimatingCount / mDivider) % 10D);
                            } else
                            {
                                i = (int)(mAnimatingCount % 10L);
                            }
                            if (mAnimationMode.pedometerAnimation)
                            {
                                mDrawingDigit = (mDrawingDigit + 1) % 10;
                            } else
                            {
                                mDrawingDigit = mCurrentAnimatingToDigit;
                            }
                            mIsAnimating = false;
                        }
                    }
                    flag1 = false;
                    if (!flag)
                    {
                        flag = flag1;
                        if (i == mDrawingDigit)
                        {
                            break label1;
                        }
                    }
                    flag = flag1;
                    if (!mIsAnimating)
                    {
                        mIsAnimating = true;
                        mAnimationStartTime = System.nanoTime();
                        if ((int)((double)mAnimatingCount / mNextDivider) != (int)((double)l1 / mNextDivider))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        mAnimatingCount = l1;
                        if (!mAnimationMode.pedometerAnimation)
                        {
                            break label0;
                        }
                        mCurrentAnimatingToDigit = (mDrawingDigit + 1) % 10;
                    }
                }
                return flag;
            }
            if (mIndexFromRight > 0)
            {
                mCurrentAnimatingToDigit = (int)(((double)mAnimatingCount / mDivider) % 10D);
                return flag;
            } else
            {
                mCurrentAnimatingToDigit = (int)(mAnimatingCount % 10L);
                return flag;
            }
        }

        public DigitAnimation(int i, double d, long l)
        {
            this$0 = CounterView.this;
            super();
            mIndexFromRight = i;
            mDivider = Math.pow(10D, mIndexFromRight);
            mNextDivider = Math.pow(10D, mIndexFromRight + 1);
            if (mIndexFromRight > 0)
            {
                mDrawingDigit = (int)(((double)l / mDivider) % 10D);
            } else
            {
                mDrawingDigit = (int)(l % 10L);
            }
            mAnimatingCount = l;
            if (d > 0.0D)
            {
                if (mAnimationMode.continuousAnimation)
                {
                    if (mIndexFromRight > 0)
                    {
                        mAnimationDuration = (long)(1.0D / (d / (double)(mIndexFromRight * 10)));
                    } else
                    {
                        mAnimationDuration = (long)(1.0D / d);
                    }
                } else
                {
                    mAnimationDuration = 0x7fffffffL;
                }
            } else
            {
                mAnimationDuration = 0x7fffffffL;
            }
            mAnimationDuration = TimeUnit.NANOSECONDS.convert(mAnimationDuration, TimeUnit.MILLISECONDS);
            mAnimationDuration = Math.min(mAnimationDuration, CounterView.ANIMATION_DURATION_MAX);
            mAnimationDuration = Math.max(mAnimationDuration, CounterView.ANIMATION_DURATION_MIN);
        }
    }


    private static final int ANIMATION_DURATION_MAX;
    private static final int ANIMATION_DURATION_MIN;
    private static final int DIGIT_SPACING_X = 3;
    private static final int DIGIT_SPACING_Y = 3;
    private static final int FRAME_DELAY = 20;
    private static final int K_INDEX = 10;
    private static final String K_SEPARATOR = ",";
    private static final boolean NO_ANIMATE_TO_NEXT_NUMBER = false;
    private static final String TAG = "CounterView";
    private AnimationMode mAnimationMode;
    private Rect mBounds[];
    private volatile boolean mCanAnimate;
    private final ArrayList mDigitAnimations;
    private long mDrawingCount;
    private long mExtraCount;
    private boolean mIsPaused;
    private long mKnownCount;
    private long mKnownCountRefreshTime;
    private final int mLOCK[];
    private long mLastAnimationTime;
    private int mLastDigitCount;
    private String mLastPrint;
    private long mMaxAnimationSeparation;
    private int mMaxTextHeight;
    private int mMaxTextWidth;
    private long mMinAnimationSeparation;
    private final Paint mPaint;
    private double mVelocityPerMS;

    public CounterView(Context context)
    {
        super(context);
        mDigitAnimations = new ArrayList();
        mAnimationMode = new AnimationMode(false, false, true);
        mLOCK = new int[0];
        mPaint = init();
        updateTextSizes();
    }

    public CounterView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mDigitAnimations = new ArrayList();
        mAnimationMode = new AnimationMode(false, false, true);
        mLOCK = new int[0];
        mPaint = init();
        updateTextSizes();
    }

    public CounterView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mDigitAnimations = new ArrayList();
        mAnimationMode = new AnimationMode(false, false, true);
        mLOCK = new int[0];
        mPaint = init();
        updateTextSizes();
    }

    private int getIntrinsicHeightForDigit(int i, int j)
    {
        return mBounds[j].height() + i >> 1;
    }

    private Paint init()
    {
        Paint paint = new Paint(65);
        mBounds = (new Rect[] {
            new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), new Rect(), 
            new Rect()
        });
        paint.setTextSize(32F);
        paint.setColor(0xff000000);
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setTextAlign(android.graphics.Paint.Align.RIGHT);
        return paint;
    }

    private void invalidateDigitSize(boolean flag)
    {
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        int j;
        long l;
        long l1;
        long l2;
        if (mDigitAnimations.size() == 0)
        {
            mDigitAnimations.add(new DigitAnimation(0, mVelocityPerMS, mDrawingCount));
        }
        l1 = getCount() + mExtraCount;
        l2 = System.nanoTime();
        j = String.valueOf(mDrawingCount).length();
        l = System.currentTimeMillis() - mLastAnimationTime;
        double d;
        double d1;
        DigitAnimation digitanimation;
        Exception exception;
        int i;
        boolean flag1;
        if (l1 > ((DigitAnimation)mDigitAnimations.get(0)).mAnimatingCount)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag) goto _L2; else goto _L1
_L1:
        if (l < mMinAnimationSeparation || !mCanAnimate && l < mMaxAnimationSeparation) goto _L3; else goto _L2
_L2:
        mLastAnimationTime = System.currentTimeMillis();
        i = 0;
        l = 0L;
          goto _L4
_L8:
        if (mDigitAnimations.size() <= i)
        {
            mDigitAnimations.add(new DigitAnimation(i, mVelocityPerMS, mDrawingCount));
        }
        digitanimation = (DigitAnimation)mDigitAnimations.get(i);
        flag1 = digitanimation.invalidate(l2, l1, flag1);
        d1 = l;
        if (i != 0) goto _L6; else goto _L5
_L5:
        d = digitanimation.mDrawingDigit;
          goto _L7
_L6:
        d = (double)digitanimation.mDrawingDigit * Math.pow(10D, i);
          goto _L7
_L9:
        setDrawingCount(l, flag);
        if (mLastDigitCount != mDigitAnimations.size())
        {
            mLastDigitCount = mDigitAnimations.size();
            requestLayout();
        }
        if (!mAnimationMode.continuousAnimation)
        {
            mCanAnimate = false;
        }
_L3:
        ai;
        JVM INSTR monitorexit ;
        return;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
_L4:
        if (i >= j && !flag1) goto _L9; else goto _L8
_L7:
        l = (long)(d + d1);
        i++;
          goto _L4
    }

    private void setDrawingCount(long l, boolean flag)
    {
        mDrawingCount = l;
    }

    private void updateTextSizes()
    {
        mMaxTextWidth = 0;
        mMaxTextHeight = 0;
        int i = 0;
        while (i < mBounds.length) 
        {
            if (i != 10)
            {
                mPaint.getTextBounds(String.valueOf(i), 0, 1, mBounds[i]);
            } else
            {
                mPaint.getTextBounds(",", 0, 1, mBounds[i]);
            }
            if (mMaxTextWidth < mBounds[i].width())
            {
                mMaxTextWidth = mBounds[i].width();
            }
            if (mMaxTextHeight < mBounds[i].height())
            {
                mMaxTextHeight = mBounds[i].height();
            }
            i++;
        }
    }

    public void adjustExtraCount(long l)
    {
        mExtraCount = l;
    }

    public long getCount()
    {
        double d1 = mKnownCount;
        double d;
        if (mKnownCountRefreshTime > 0L)
        {
            d = mVelocityPerMS * (double)(System.currentTimeMillis() - mKnownCountRefreshTime);
        } else
        {
            d = 0.0D;
        }
        return (long)(d + d1);
    }

    public void incrementExtraCount(int i)
    {
        adjustExtraCount(mExtraCount + (long)i);
    }

    public void invalidateCounterUI()
    {
        mCanAnimate = true;
    }

    public void onDraw(Canvas canvas)
    {
        int i;
        int l;
        i = getMeasuredWidth();
        l = getMeasuredHeight();
        int ai[] = mLOCK;
        ai;
        JVM INSTR monitorenter ;
        int i1 = mDigitAnimations.size();
        String s;
        int j;
        s = "";
        j = 0;
_L5:
        int k;
        if (j >= i1)
        {
            break MISSING_BLOCK_LABEL_523;
        }
        k = i;
        if (j < 3)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        k = i;
        if (j % 3 != 0)
        {
            break MISSING_BLOCK_LABEL_120;
        }
        mPaint.setAlpha(255);
        canvas.drawText(",", i, (l >> 1) + mBounds[10].height(), mPaint);
        k = i - mBounds[10].width();
        double d;
        DigitAnimation digitanimation;
        String s1;
        int j1;
        long l1;
        digitanimation = (DigitAnimation)mDigitAnimations.get(j);
        i = digitanimation.mDrawingDigit;
        s1 = String.valueOf(i);
        j1 = getIntrinsicHeightForDigit(l, i);
        if (!digitanimation.mIsAnimating)
        {
            break MISSING_BLOCK_LABEL_472;
        }
        l1 = System.nanoTime() - digitanimation.mAnimationStartTime;
        d = (double)l1 / (double)digitanimation.mAnimationDuration;
        if (l1 < digitanimation.mAnimationDuration && (digitanimation.mCurrentAnimatingToDigit != i || mAnimationMode.pedometerAnimation)) goto _L2; else goto _L1
_L1:
        s = (new StringBuilder()).append(s).append(digitanimation.mCurrentAnimatingToDigit).toString();
        mPaint.setAlpha(255);
        canvas.drawText(String.valueOf(digitanimation.mCurrentAnimatingToDigit), k, j1, mPaint);
_L3:
        i = k - (mMaxTextWidth + 3);
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        j1 = (int)((double)j1 - (double)(mBounds[i].height() + 3) * d);
        if (i == 0 && j == i1 - 1 && i1 != 1)
        {
            break MISSING_BLOCK_LABEL_379;
        }
        if (mAnimationMode.alphaAnimation)
        {
            mPaint.setAlpha((int)((1.0D - d) * 255D));
        }
        canvas.drawText(s1, k, j1, mPaint);
        s = (new StringBuilder()).append(s).append(s1).toString();
        i = mBounds[i].height();
        if (mAnimationMode.alphaAnimation)
        {
            mPaint.setAlpha((int)(255D * d));
        }
        canvas.drawText(String.valueOf(digitanimation.mCurrentAnimatingToDigit), k, i + j1 + 3, mPaint);
          goto _L3
        canvas;
        ai;
        JVM INSTR monitorexit ;
        throw canvas;
        s = (new StringBuilder()).append(s).append(s1).toString();
        mPaint.setAlpha(255);
        canvas.drawText(s1, k, j1, mPaint);
          goto _L3
        if (!s.equals(mLastPrint))
        {
            mLastPrint = s;
        }
        ai;
        JVM INSTR monitorexit ;
        removeCallbacks(this);
        if (!mIsPaused)
        {
            postDelayed(this, 20L);
        }
        return;
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void onMeasure(int i, int j)
    {
        int k = android.view.View.MeasureSpec.getMode(i);
        int j1 = android.view.View.MeasureSpec.getMode(j);
        i = android.view.View.MeasureSpec.getSize(i);
        j = android.view.View.MeasureSpec.getSize(j);
        updateTextSizes();
        if (k == 0x40000000)
        {
            Log.d("CounterView", "onMeasure width exactly");
        } else
        {
            int l = Math.max(mLastDigitCount, String.valueOf(mDrawingCount).length());
            l = (mMaxTextWidth + 3) * l + (l / 3) * mBounds[10].width() + getPaddingLeft() + getPaddingRight();
            if (j1 == 0x80000000)
            {
                Log.d("CounterView", "onMeasure width at most");
                i = Math.min(l, i);
            } else
            {
                Log.d("CounterView", "onMeasure width unspecified");
                i = l;
            }
        }
        if (j1 == 0x40000000)
        {
            Log.d("CounterView", "onMeasure height exactly");
        } else
        {
            int i1 = mMaxTextHeight + getPaddingTop() + getPaddingBottom() + 3;
            if (j1 == 0x80000000)
            {
                Log.d("CounterView", "onMeasure height at most");
                j = Math.min(i1, j);
            } else
            {
                Log.d("CounterView", "onMeasure width unspecified");
                j = i1;
            }
        }
        Log.d("CounterView", (new StringBuilder()).append("onMeasure ").append(i).append(" * ").append(j).toString());
        setMeasuredDimension(i, j);
    }

    public void pause()
    {
        mIsPaused = true;
        removeCallbacks(this);
    }

    public void reset()
    {
        mLastDigitCount = 0;
        mKnownCount = 0L;
        mKnownCountRefreshTime = -1L;
        mVelocityPerMS = 0.0D;
        mDigitAnimations.clear();
    }

    public void resume()
    {
        if (mIsPaused)
        {
            mIsPaused = false;
            postInvalidate();
        }
    }

    public void run()
    {
        invalidateDigitSize(false);
        if (!mIsPaused && isShown())
        {
            postInvalidate();
        }
    }

    public void setAnimationMode(AnimationMode animationmode)
    {
        mAnimationMode = animationmode;
    }

    public long setKnownCount(long l, double d, long l1)
    {
        if (l1 > 0L)
        {
            long l2 = System.currentTimeMillis();
            mKnownCount = (long)((double)l + (double)(l2 - l1) * d);
            mKnownCountRefreshTime = l2;
        } else
        {
            mKnownCount = l;
        }
        mVelocityPerMS = d;
        synchronized (mLOCK)
        {
            mLastDigitCount = 0;
            mDigitAnimations.clear();
            invalidateDigitSize(true);
        }
        return mKnownCount;
        exception;
        ai;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void setMaxAnimationSeparation(long l)
    {
        mMaxAnimationSeparation = l;
    }

    public void setMinAnimationSeparation(long l)
    {
        mMinAnimationSeparation = l;
    }

    public void setTextSize(float f)
    {
        mPaint.setTextSize(f);
        requestLayout();
    }

    public void setTypeFace(Typeface typeface)
    {
        mPaint.setTypeface(typeface);
        requestLayout();
    }

    static 
    {
        ANIMATION_DURATION_MAX = (int)TimeUnit.NANOSECONDS.convert(150L, TimeUnit.MILLISECONDS);
        ANIMATION_DURATION_MIN = (int)TimeUnit.NANOSECONDS.convert(20L, TimeUnit.MILLISECONDS);
    }



}
