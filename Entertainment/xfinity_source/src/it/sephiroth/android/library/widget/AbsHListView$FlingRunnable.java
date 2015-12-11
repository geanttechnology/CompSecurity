// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.VelocityTracker;
import android.view.View;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView, OverScroller, EdgeEffect

private class mScroller
    implements Runnable
{

    private final Runnable mCheckFlywheel = new Runnable() {

        final AbsHListView.FlingRunnable this$1;

        public void run()
        {
            int i = AbsHListView.access$800(this$0);
            VelocityTracker velocitytracker = AbsHListView.access$900(this$0);
            OverScroller overscroller = mScroller;
            if (velocitytracker == null || i == -1)
            {
                return;
            }
            velocitytracker.computeCurrentVelocity(1000, AbsHListView.access$1100(this$0));
            float f = -velocitytracker.getXVelocity(i);
            if (Math.abs(f) >= (float)AbsHListView.access$1200(this$0) && overscroller.isScrollingInDirection(f, 0.0F))
            {
                postDelayed(this, 40L);
                return;
            } else
            {
                endFling();
                mTouchMode = 3;
                reportScrollStateChange(1);
                return;
            }
        }

            
            {
                this$1 = AbsHListView.FlingRunnable.this;
                super();
            }
    };
    private int mLastFlingX;
    private final OverScroller mScroller;
    final AbsHListView this$0;

    void edgeReached(int i)
    {
        int j;
        mScroller.notifyHorizontalEdgeReached(getScrollX(), 0, mOverflingDistance);
        j = getOverScrollMode();
        if (j != 0 && (j != 1 || AbsHListView.access$1300(AbsHListView.this))) goto _L2; else goto _L1
_L1:
        mTouchMode = 6;
        int k = (int)mScroller.getCurrVelocity();
        if (i > 0)
        {
            AbsHListView.access$1400(AbsHListView.this).onAbsorb(k);
        } else
        {
            AbsHListView.access$1500(AbsHListView.this).onAbsorb(k);
        }
_L4:
        invalidate();
        mViewHelper.postOnAnimation(this);
        return;
_L2:
        mTouchMode = -1;
        if (mPositionScroller != null)
        {
            mPositionScroller.stop();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    void endFling()
    {
        mTouchMode = -1;
        removeCallbacks(this);
        removeCallbacks(mCheckFlywheel);
        reportScrollStateChange(0);
        AbsHListView.access$1600(AbsHListView.this);
        mScroller.abortAnimation();
        AbsHListView.access$1700(AbsHListView.this, 0, 0, 0, 0, 0, 0, 0, 0, false);
    }

    void flywheelTouch()
    {
        postDelayed(mCheckFlywheel, 40L);
    }

    public void run()
    {
        mTouchMode;
        JVM INSTR tableswitch 3 6: default 36
    //                   3 41
    //                   4 51
    //                   5 36
    //                   6 433;
           goto _L1 _L2 _L3 _L1 _L4
_L1:
        endFling();
_L5:
        return;
_L2:
        if (mScroller.isFinished())
        {
            continue; /* Loop/switch isn't completed */
        }
_L3:
        if (mDataChanged)
        {
            layoutChildren();
        }
        if (mItemCount == 0 || getChildCount() == 0)
        {
            endFling();
            return;
        }
        Object obj = mScroller;
        boolean flag2 = ((OverScroller) (obj)).computeScrollOffset();
        int l1 = ((OverScroller) (obj)).getCurrX();
        int i = mLastFlingX - l1;
        int k;
        boolean flag1;
        boolean flag3;
        if (i > 0)
        {
            mMotionPosition = mFirstPosition;
            obj = getChildAt(0);
            mMotionViewOriginalLeft = ((View) (obj)).getLeft();
            i = Math.min(getWidth() - getPaddingRight() - getPaddingLeft() - 1, i);
        } else
        {
            int l = getChildCount() - 1;
            mMotionPosition = mFirstPosition + l;
            View view = getChildAt(l);
            mMotionViewOriginalLeft = view.getLeft();
            i = Math.max(-(getWidth() - getPaddingRight() - getPaddingLeft() - 1), i);
        }
        obj = getChildAt(mMotionPosition - mFirstPosition);
        k = 0;
        if (obj != null)
        {
            k = ((View) (obj)).getLeft();
        }
        flag3 = trackMotionScroll(i, i);
        if (flag3 && i != 0)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            if (obj != null)
            {
                k = -(i - (((View) (obj)).getLeft() - k));
                AbsHListView.access$1800(AbsHListView.this, k, 0, getScrollX(), 0, 0, 0, mOverflingDistance, 0, false);
            }
            if (flag2)
            {
                edgeReached(i);
                return;
            }
        } else
        if (flag2 && !flag1)
        {
            if (flag3)
            {
                invalidate();
            }
            mLastFlingX = l1;
            mViewHelper.postOnAnimation(this);
            return;
        } else
        {
            endFling();
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
        OverScroller overscroller = mScroller;
        if (overscroller.computeScrollOffset())
        {
            int i1 = getScrollX();
            int j1 = overscroller.getCurrX();
            if (AbsHListView.access$1900(AbsHListView.this, j1 - i1, 0, i1, 0, 0, 0, mOverflingDistance, 0, false))
            {
                int j;
                boolean flag;
                if (i1 <= 0 && j1 > 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                if (i1 >= 0 && j1 < 0)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (j != 0 || flag)
                {
                    int k1 = (int)overscroller.getCurrVelocity();
                    j = k1;
                    if (flag)
                    {
                        j = -k1;
                    }
                    overscroller.abortAnimation();
                    start(j);
                    return;
                } else
                {
                    startSpringback();
                    return;
                }
            } else
            {
                invalidate();
                mViewHelper.postOnAnimation(this);
                return;
            }
        } else
        {
            endFling();
            return;
        }
    }

    void start(int i)
    {
        int j;
        if (i < 0)
        {
            j = 0x7fffffff;
        } else
        {
            j = 0;
        }
        mLastFlingX = j;
        mScroller.setInterpolator(null);
        mScroller.fling(j, 0, i, 0, 0, 0x7fffffff, 0, 0x7fffffff);
        mTouchMode = 4;
        mViewHelper.postOnAnimation(this);
    }

    void startOverfling(int i)
    {
        mScroller.setInterpolator(null);
        mScroller.fling(getScrollX(), 0, i, 0, 0x80000000, 0x7fffffff, 0, 0, getWidth(), 0);
        mTouchMode = 6;
        invalidate();
        mViewHelper.postOnAnimation(this);
    }

    void startScroll(int i, int j, boolean flag)
    {
        android.view.animation.Interpolator interpolator;
        OverScroller overscroller;
        int k;
        if (i < 0)
        {
            k = 0x7fffffff;
        } else
        {
            k = 0;
        }
        mLastFlingX = k;
        overscroller = mScroller;
        if (flag)
        {
            interpolator = AbsHListView.sLinearInterpolator;
        } else
        {
            interpolator = null;
        }
        overscroller.setInterpolator(interpolator);
        mScroller.startScroll(k, 0, i, 0, j);
        mTouchMode = 4;
        mViewHelper.postOnAnimation(this);
    }

    void startSpringback()
    {
        if (mScroller.springBack(getScrollX(), 0, 0, 0, 0, 0))
        {
            mTouchMode = 6;
            invalidate();
            mViewHelper.postOnAnimation(this);
            return;
        } else
        {
            mTouchMode = -1;
            reportScrollStateChange(0);
            return;
        }
    }


    _cls1.this._cls1()
    {
        this$0 = AbsHListView.this;
        super();
        mScroller = new OverScroller(getContext());
    }
}
