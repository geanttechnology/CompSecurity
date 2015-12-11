// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import java.util.concurrent.TimeUnit;

// Referenced classes of package co.vine.android.widget:
//            CounterView

public class mAnimationDuration
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
                        if (CounterView.access$000(CounterView.this).edometerAnimation)
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
                    if (!CounterView.access$000(CounterView.this).edometerAnimation)
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

    public (int i, double d, long l)
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
            if (CounterView.access$000(CounterView.this).ontinuousAnimation)
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
        mAnimationDuration = Math.min(mAnimationDuration, CounterView.access$100());
        mAnimationDuration = Math.max(mAnimationDuration, CounterView.access$200());
    }
}
