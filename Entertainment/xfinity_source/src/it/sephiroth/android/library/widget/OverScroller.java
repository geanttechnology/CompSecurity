// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.FloatMath;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class OverScroller
{
    static class SplineOverScroller
    {

        private static float DECELERATION_RATE;
        private static final float SPLINE_POSITION[];
        private static final float SPLINE_TIME[];
        private float mCurrVelocity;
        private int mCurrentPosition;
        private float mDeceleration;
        private int mDuration;
        private int mFinal;
        private boolean mFinished;
        private float mFlingFriction;
        private int mOver;
        private float mPhysicalCoeff;
        private int mSplineDistance;
        private int mSplineDuration;
        private int mStart;
        private long mStartTime;
        private int mState;
        private int mVelocity;

        private void adjustDuration(int i, int j, int k)
        {
            float f2 = Math.abs((float)(k - i) / (float)(j - i));
            i = (int)(100F * f2);
            if (i < 100)
            {
                float f3 = (float)i / 100F;
                float f4 = (float)(i + 1) / 100F;
                float f = SPLINE_TIME[i];
                float f1 = SPLINE_TIME[i + 1];
                f2 = (f2 - f3) / (f4 - f3);
                mDuration = (int)((float)mDuration * (f + f2 * (f1 - f)));
            }
        }

        private void fitOnBounceCurve(int i, int j, int k)
        {
            float f = (float)(-k) / mDeceleration;
            float f1 = (float)Math.sqrt((2D * (double)((float)(k * k) / 2.0F / Math.abs(mDeceleration) + (float)Math.abs(j - i))) / (double)Math.abs(mDeceleration));
            mStartTime = mStartTime - (long)(int)(1000F * (f1 - f));
            mStart = j;
            mVelocity = (int)(-mDeceleration * f1);
        }

        private static float getDeceleration(int i)
        {
            return i <= 0 ? 2000F : -2000F;
        }

        private double getSplineDeceleration(int i)
        {
            return Math.log((0.35F * (float)Math.abs(i)) / (mFlingFriction * mPhysicalCoeff));
        }

        private double getSplineFlingDistance(int i)
        {
            double d = getSplineDeceleration(i);
            double d1 = DECELERATION_RATE;
            return (double)(mFlingFriction * mPhysicalCoeff) * Math.exp(((double)DECELERATION_RATE / (d1 - 1.0D)) * d);
        }

        private int getSplineFlingDuration(int i)
        {
            return (int)(1000D * Math.exp(getSplineDeceleration(i) / ((double)DECELERATION_RATE - 1.0D)));
        }

        private void onEdgeReached()
        {
            float f1 = (float)(mVelocity * mVelocity) / (Math.abs(mDeceleration) * 2.0F);
            float f2 = Math.signum(mVelocity);
            float f = f1;
            if (f1 > (float)mOver)
            {
                mDeceleration = (-f2 * (float)mVelocity * (float)mVelocity) / ((float)mOver * 2.0F);
                f = mOver;
            }
            mOver = (int)f;
            mState = 2;
            int i = mStart;
            if (mVelocity <= 0)
            {
                f = -f;
            }
            mFinal = i + (int)f;
            mDuration = -(int)((1000F * (float)mVelocity) / mDeceleration);
        }

        private void startAfterEdge(int i, int j, int k, int l)
        {
            if (i > j && i < k)
            {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                mFinished = true;
                return;
            }
            boolean flag;
            int i1;
            boolean flag1;
            int j1;
            if (i > k)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                i1 = k;
            } else
            {
                i1 = j;
            }
            j1 = i - i1;
            if (j1 * l >= 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                startBounceAfterEdge(i, i1, l);
                return;
            }
            if (getSplineFlingDistance(l) > (double)Math.abs(j1))
            {
                if (!flag)
                {
                    j = i;
                }
                if (flag)
                {
                    k = i;
                }
                fling(i, l, j, k, mOver);
                return;
            } else
            {
                startSpringback(i, i1, l);
                return;
            }
        }

        private void startBounceAfterEdge(int i, int j, int k)
        {
            int l;
            if (k == 0)
            {
                l = i - j;
            } else
            {
                l = k;
            }
            mDeceleration = getDeceleration(l);
            fitOnBounceCurve(i, j, k);
            onEdgeReached();
        }

        private void startSpringback(int i, int j, int k)
        {
            mFinished = false;
            mState = 1;
            mStart = i;
            mFinal = j;
            i -= j;
            mDeceleration = getDeceleration(i);
            mVelocity = -i;
            mOver = Math.abs(i);
            mDuration = (int)(1000D * Math.sqrt((-2D * (double)i) / (double)mDeceleration));
        }

        boolean continueWhenFinished()
        {
            boolean flag;
            boolean flag1;
            flag1 = false;
            flag = flag1;
            mState;
            JVM INSTR tableswitch 0 2: default 36
        //                       0 45
        //                       1 43
        //                       2 107;
               goto _L1 _L2 _L3 _L4
_L1:
            update();
            flag = true;
_L3:
            return flag;
_L2:
            flag = flag1;
            if (mDuration >= mSplineDuration) goto _L3; else goto _L5
_L5:
            mStart = mFinal;
            mVelocity = (int)mCurrVelocity;
            mDeceleration = getDeceleration(mVelocity);
            mStartTime = mStartTime + (long)mDuration;
            onEdgeReached();
            continue; /* Loop/switch isn't completed */
_L4:
            mStartTime = mStartTime + (long)mDuration;
            startSpringback(mFinal, mStart, 0);
            if (true) goto _L1; else goto _L6
_L6:
        }

        void finish()
        {
            mCurrentPosition = mFinal;
            mFinished = true;
        }

        void fling(int i, int j, int k, int l, int i1)
        {
            mOver = i1;
            mFinished = false;
            mVelocity = j;
            mCurrVelocity = j;
            mSplineDuration = 0;
            mDuration = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mStart = i;
            mCurrentPosition = i;
            if (i > l || i < k)
            {
                startAfterEdge(i, k, l, j);
            } else
            {
                mState = 0;
                double d = 0.0D;
                if (j != 0)
                {
                    i1 = getSplineFlingDuration(j);
                    mSplineDuration = i1;
                    mDuration = i1;
                    d = getSplineFlingDistance(j);
                }
                mSplineDistance = (int)((double)Math.signum(j) * d);
                mFinal = mSplineDistance + i;
                if (mFinal < k)
                {
                    adjustDuration(mStart, mFinal, k);
                    mFinal = k;
                }
                if (mFinal > l)
                {
                    adjustDuration(mStart, mFinal, l);
                    mFinal = l;
                    return;
                }
            }
        }

        void notifyEdgeReached(int i, int j, int k)
        {
            if (mState == 0)
            {
                mOver = k;
                mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, j, j, (int)mCurrVelocity);
            }
        }

        void setFriction(float f)
        {
            mFlingFriction = f;
        }

        boolean springback(int i, int j, int k)
        {
            mFinished = true;
            mFinal = i;
            mStart = i;
            mVelocity = 0;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = 0;
            if (i < j)
            {
                startSpringback(i, j, 0);
            } else
            if (i > k)
            {
                startSpringback(i, k, 0);
            }
            return !mFinished;
        }

        void startScroll(int i, int j, int k)
        {
            mFinished = false;
            mStart = i;
            mFinal = i + j;
            mStartTime = AnimationUtils.currentAnimationTimeMillis();
            mDuration = k;
            mDeceleration = 0.0F;
            mVelocity = 0;
        }

        boolean update()
        {
            double d;
            long l;
            l = AnimationUtils.currentAnimationTimeMillis() - mStartTime;
            if (l > (long)mDuration)
            {
                return false;
            }
            d = 0.0D;
            mState;
            JVM INSTR tableswitch 0 2: default 56
        //                       0 72
        //                       1 236
        //                       2 190;
               goto _L1 _L2 _L3 _L4
_L1:
            mCurrentPosition = mStart + (int)Math.round(d);
            return true;
_L2:
            float f5 = (float)l / (float)mSplineDuration;
            int i = (int)(100F * f5);
            float f = 1.0F;
            float f3 = 0.0F;
            if (i < 100)
            {
                f = (float)i / 100F;
                f3 = (float)(i + 1) / 100F;
                float f7 = SPLINE_POSITION[i];
                f3 = (SPLINE_POSITION[i + 1] - f7) / (f3 - f);
                f = f7 + (f5 - f) * f3;
            }
            d = (float)mSplineDistance * f;
            mCurrVelocity = (((float)mSplineDistance * f3) / (float)mSplineDuration) * 1000F;
            continue; /* Loop/switch isn't completed */
_L4:
            float f1 = (float)l / 1000F;
            mCurrVelocity = (float)mVelocity + mDeceleration * f1;
            d = (float)mVelocity * f1 + (mDeceleration * f1 * f1) / 2.0F;
            continue; /* Loop/switch isn't completed */
_L3:
            float f2 = (float)l / (float)mDuration;
            float f4 = f2 * f2;
            float f6 = Math.signum(mVelocity);
            d = (float)mOver * f6 * (3F * f4 - 2.0F * f2 * f4);
            mCurrVelocity = (float)mOver * f6 * 6F * (-f2 + f4);
            if (true) goto _L1; else goto _L5
_L5:
        }

        void updateScroll(float f)
        {
            mCurrentPosition = mStart + Math.round((float)(mFinal - mStart) * f);
        }

        static 
        {
            float f;
            float f1;
            int i;
            DECELERATION_RATE = (float)(Math.log(0.78000000000000003D) / Math.log(0.90000000000000002D));
            SPLINE_POSITION = new float[101];
            SPLINE_TIME = new float[101];
            f = 0.0F;
            f1 = 0.0F;
            i = 0;
_L6:
            float f2;
            float f4;
            if (i >= 100)
            {
                break MISSING_BLOCK_LABEL_260;
            }
            f4 = (float)i / 100F;
            f2 = 1.0F;
_L3:
            float f3;
            float f5;
            float f7;
            f3 = f + (f2 - f) / 2.0F;
            f5 = 3F * f3 * (1.0F - f3);
            f7 = ((1.0F - f3) * 0.175F + 0.35F * f3) * f5 + f3 * f3 * f3;
            if ((double)Math.abs(f7 - f4) >= 1.0000000000000001E-05D) goto _L2; else goto _L1
_L1:
            SPLINE_POSITION[i] = ((1.0F - f3) * 0.5F + f3) * f5 + f3 * f3 * f3;
            f2 = 1.0F;
_L4:
            f3 = f1 + (f2 - f1) / 2.0F;
            float f6 = 3F * f3 * (1.0F - f3);
            f7 = ((1.0F - f3) * 0.5F + f3) * f6 + f3 * f3 * f3;
            if ((double)Math.abs(f7 - f4) < 1.0000000000000001E-05D)
            {
                SPLINE_TIME[i] = ((1.0F - f3) * 0.175F + 0.35F * f3) * f6 + f3 * f3 * f3;
                i++;
                continue; /* Loop/switch isn't completed */
            }
            break MISSING_BLOCK_LABEL_242;
_L2:
            if (f7 > f4)
            {
                f2 = f3;
            } else
            {
                f = f3;
            }
              goto _L3
            if (f7 > f4)
            {
                f2 = f3;
            } else
            {
                f1 = f3;
            }
              goto _L4
            float af[] = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0F;
            af[100] = 1.0F;
            if (true) goto _L6; else goto _L5
_L5:
        }








        SplineOverScroller(Context context)
        {
            mFlingFriction = ViewConfiguration.getScrollFriction();
            mState = 0;
            mFinished = true;
            mPhysicalCoeff = 386.0878F * (context.getResources().getDisplayMetrics().density * 160F) * 0.84F;
        }
    }


    private static float sViscousFluidNormalize = 1.0F;
    private static float sViscousFluidScale = 8F;
    private final boolean mFlywheel;
    private Interpolator mInterpolator;
    private int mMode;
    private final SplineOverScroller mScrollerX;
    private final SplineOverScroller mScrollerY;

    public OverScroller(Context context)
    {
        this(context, null);
    }

    public OverScroller(Context context, Interpolator interpolator)
    {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean flag)
    {
        mInterpolator = interpolator;
        mFlywheel = flag;
        mScrollerX = new SplineOverScroller(context);
        mScrollerY = new SplineOverScroller(context);
    }

    public static float viscousFluid(float f)
    {
        f *= sViscousFluidScale;
        if (f < 1.0F)
        {
            f -= 1.0F - (float)Math.exp(-f);
        } else
        {
            f = 0.3678795F + (1.0F - 0.3678795F) * (1.0F - (float)Math.exp(1.0F - f));
        }
        return f * sViscousFluidNormalize;
    }

    public void abortAnimation()
    {
        mScrollerX.finish();
        mScrollerY.finish();
    }

    public boolean computeScrollOffset()
    {
        if (isFinished())
        {
            return false;
        }
        mMode;
        JVM INSTR tableswitch 0 1: default 36
    //                   0 38
    //                   1 123;
           goto _L1 _L2 _L3
_L1:
        return true;
_L2:
        long l = AnimationUtils.currentAnimationTimeMillis() - mScrollerX.mStartTime;
        int i = mScrollerX.mDuration;
        if (l < (long)i)
        {
            float f = (float)l / (float)i;
            if (mInterpolator == null)
            {
                f = viscousFluid(f);
            } else
            {
                f = mInterpolator.getInterpolation(f);
            }
            mScrollerX.updateScroll(f);
            mScrollerY.updateScroll(f);
        } else
        {
            abortAnimation();
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (!mScrollerX.mFinished && !mScrollerX.update() && !mScrollerX.continueWhenFinished())
        {
            mScrollerX.finish();
        }
        if (!mScrollerY.mFinished && !mScrollerY.update() && !mScrollerY.continueWhenFinished())
        {
            mScrollerY.finish();
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1)
    {
        fling(i, j, k, l, i1, j1, k1, l1, 0, 0);
    }

    public void fling(int i, int j, int k, int l, int i1, int j1, int k1, 
            int l1, int i2, int j2)
    {
        int l2 = k;
        int k2 = l;
        if (mFlywheel)
        {
            l2 = k;
            k2 = l;
            if (!isFinished())
            {
                float f = mScrollerX.mCurrVelocity;
                float f1 = mScrollerY.mCurrVelocity;
                l2 = k;
                k2 = l;
                if (Math.signum(k) == Math.signum(f))
                {
                    l2 = k;
                    k2 = l;
                    if (Math.signum(l) == Math.signum(f1))
                    {
                        l2 = (int)((float)k + f);
                        k2 = (int)((float)l + f1);
                    }
                }
            }
        }
        mMode = 1;
        mScrollerX.fling(i, l2, i1, j1, i2);
        mScrollerY.fling(j, k2, k1, l1, j2);
    }

    public float getCurrVelocity()
    {
        return FloatMath.sqrt(mScrollerX.mCurrVelocity * mScrollerX.mCurrVelocity + mScrollerY.mCurrVelocity * mScrollerY.mCurrVelocity);
    }

    public final int getCurrX()
    {
        return mScrollerX.mCurrentPosition;
    }

    public final boolean isFinished()
    {
        return mScrollerX.mFinished && mScrollerY.mFinished;
    }

    public boolean isScrollingInDirection(float f, float f1)
    {
        int i = mScrollerX.mFinal;
        int j = mScrollerX.mStart;
        int k = mScrollerY.mFinal;
        int l = mScrollerY.mStart;
        return !isFinished() && Math.signum(f) == Math.signum(i - j) && Math.signum(f1) == Math.signum(k - l);
    }

    public void notifyHorizontalEdgeReached(int i, int j, int k)
    {
        mScrollerX.notifyEdgeReached(i, j, k);
    }

    public final void setFriction(float f)
    {
        mScrollerX.setFriction(f);
        mScrollerY.setFriction(f);
    }

    void setInterpolator(Interpolator interpolator)
    {
        mInterpolator = interpolator;
    }

    public boolean springBack(int i, int j, int k, int l, int i1, int j1)
    {
        mMode = 1;
        boolean flag = mScrollerX.springback(i, k, l);
        boolean flag1 = mScrollerY.springback(j, i1, j1);
        return flag || flag1;
    }

    public void startScroll(int i, int j, int k, int l, int i1)
    {
        mMode = 0;
        mScrollerX.startScroll(i, k, i1);
        mScrollerY.startScroll(j, l, i1);
    }

    static 
    {
        sViscousFluidNormalize = 1.0F / viscousFluid(1.0F);
    }
}
