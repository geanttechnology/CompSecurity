// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.content.Context;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

// Referenced classes of package android.support.v4.view:
//            MotionEventCompat, VelocityTrackerCompat

class init
    implements init
{

    private static final int DOUBLE_TAP_TIMEOUT = ViewConfiguration.getDoubleTapTimeout();
    private static final int LONGPRESS_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    private static final int LONG_PRESS = 2;
    private static final int SHOW_PRESS = 1;
    private static final int TAP = 3;
    private static final int TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private boolean mAlwaysInBiggerTapRegion;
    private boolean mAlwaysInTapRegion;
    private MotionEvent mCurrentDownEvent;
    private boolean mDeferConfirmSingleTap;
    private android.view.atImplBase.mDoubleTapListener mDoubleTapListener;
    private int mDoubleTapSlopSquare;
    private float mDownFocusX;
    private float mDownFocusY;
    private final Handler mHandler;
    private boolean mInLongPress;
    private boolean mIsDoubleTapping;
    private boolean mIsLongpressEnabled;
    private float mLastFocusX;
    private float mLastFocusY;
    private final android.view.atImplBase.mDoubleTapListener mListener;
    private int mMaximumFlingVelocity;
    private int mMinimumFlingVelocity;
    private MotionEvent mPreviousUpEvent;
    private boolean mStillDown;
    private int mTouchSlopSquare;
    private VelocityTracker mVelocityTracker;

    private void cancel()
    {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mVelocityTracker.recycle();
        mVelocityTracker = null;
        mIsDoubleTapping = false;
        mStillDown = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        mDeferConfirmSingleTap = false;
        if (mInLongPress)
        {
            mInLongPress = false;
        }
    }

    private void cancelTaps()
    {
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        mHandler.removeMessages(3);
        mIsDoubleTapping = false;
        mAlwaysInTapRegion = false;
        mAlwaysInBiggerTapRegion = false;
        mDeferConfirmSingleTap = false;
        if (mInLongPress)
        {
            mInLongPress = false;
        }
    }

    private void dispatchLongPress()
    {
        mHandler.removeMessages(3);
        mDeferConfirmSingleTap = false;
        mInLongPress = true;
        mListener.mListener(mCurrentDownEvent);
    }

    private void init(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("Context must not be null");
        }
        if (mListener == null)
        {
            throw new IllegalArgumentException("OnGestureListener must not be null");
        } else
        {
            mIsLongpressEnabled = true;
            context = ViewConfiguration.get(context);
            int i = context.getScaledTouchSlop();
            int j = context.getScaledDoubleTapSlop();
            mMinimumFlingVelocity = context.getScaledMinimumFlingVelocity();
            mMaximumFlingVelocity = context.getScaledMaximumFlingVelocity();
            mTouchSlopSquare = i * i;
            mDoubleTapSlopSquare = j * j;
            return;
        }
    }

    private boolean isConsideredDoubleTap(MotionEvent motionevent, MotionEvent motionevent1, MotionEvent motionevent2)
    {
        if (mAlwaysInBiggerTapRegion && motionevent2.getEventTime() - motionevent1.getEventTime() <= (long)DOUBLE_TAP_TIMEOUT)
        {
            int i = (int)motionevent.getX() - (int)motionevent2.getX();
            int j = (int)motionevent.getY() - (int)motionevent2.getY();
            if (i * i + j * j < mDoubleTapSlopSquare)
            {
                return true;
            }
        }
        return false;
    }

    public boolean isLongpressEnabled()
    {
        return mIsLongpressEnabled;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        float f;
        float f1;
        int i2;
        int j2 = motionevent.getAction();
        if (mVelocityTracker == null)
        {
            mVelocityTracker = VelocityTracker.obtain();
        }
        mVelocityTracker.addMovement(motionevent);
        boolean flag;
        int l;
        int k1;
        if ((j2 & 0xff) == 6)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            l = MotionEventCompat.getActionIndex(motionevent);
        } else
        {
            l = -1;
        }
        i2 = MotionEventCompat.getPointerCount(motionevent);
        k1 = 0;
        f = 0.0F;
        f1 = 0.0F;
        while (k1 < i2) 
        {
            if (l != k1)
            {
                f1 += MotionEventCompat.getX(motionevent, k1);
                f += MotionEventCompat.getY(motionevent, k1);
            }
            k1++;
        }
        int i;
        if (flag)
        {
            i = i2 - 1;
        } else
        {
            i = i2;
        }
        f1 /= i;
        f /= i;
        j2 & 0xff;
        JVM INSTR tableswitch 0 6: default 192
    //                   0 371
    //                   1 850
    //                   2 631
    //                   3 1124
    //                   4 192
    //                   5 201
    //                   6 227;
           goto _L1 _L2 _L3 _L4 _L5 _L1 _L6 _L7
_L1:
        return false;
_L6:
        mLastFocusX = f1;
        mDownFocusX = f1;
        mLastFocusY = f;
        mDownFocusY = f;
        cancelTaps();
        return false;
_L7:
        int j;
        int i1;
        mLastFocusX = f1;
        mDownFocusX = f1;
        mLastFocusY = f;
        mDownFocusY = f;
        mVelocityTracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
        i1 = MotionEventCompat.getActionIndex(motionevent);
        j = MotionEventCompat.getPointerId(motionevent, i1);
        f = VelocityTrackerCompat.getXVelocity(mVelocityTracker, j);
        f1 = VelocityTrackerCompat.getYVelocity(mVelocityTracker, j);
        j = 0;
_L11:
        if (j >= i2) goto _L1; else goto _L8
_L8:
        if (j != i1) goto _L10; else goto _L9
_L9:
        j++;
          goto _L11
_L10:
        float f2;
        int l1;
        l1 = MotionEventCompat.getPointerId(motionevent, j);
        f2 = VelocityTrackerCompat.getXVelocity(mVelocityTracker, l1);
        if (VelocityTrackerCompat.getYVelocity(mVelocityTracker, l1) * f1 + f2 * f >= 0.0F) goto _L9; else goto _L12
_L12:
        mVelocityTracker.clear();
        return false;
_L2:
        if (mDoubleTapListener == null) goto _L14; else goto _L13
_L13:
        boolean flag1;
        flag1 = mHandler.hasMessages(3);
        if (flag1)
        {
            mHandler.removeMessages(3);
        }
        if (mCurrentDownEvent == null || mPreviousUpEvent == null || !flag1 || !isConsideredDoubleTap(mCurrentDownEvent, mPreviousUpEvent, motionevent)) goto _L16; else goto _L15
_L15:
        mIsDoubleTapping = true;
        j = mDoubleTapListener.mDoubleTapListener(mCurrentDownEvent) | false | mDoubleTapListener.(motionevent);
_L17:
        mLastFocusX = f1;
        mDownFocusX = f1;
        mLastFocusY = f;
        mDownFocusY = f;
        if (mCurrentDownEvent != null)
        {
            mCurrentDownEvent.recycle();
        }
        mCurrentDownEvent = MotionEvent.obtain(motionevent);
        mAlwaysInTapRegion = true;
        mAlwaysInBiggerTapRegion = true;
        mStillDown = true;
        mInLongPress = false;
        mDeferConfirmSingleTap = false;
        if (mIsLongpressEnabled)
        {
            mHandler.removeMessages(2);
            mHandler.sendEmptyMessageAtTime(2, mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT + (long)LONGPRESS_TIMEOUT);
        }
        mHandler.sendEmptyMessageAtTime(1, mCurrentDownEvent.getDownTime() + (long)TAP_TIMEOUT);
        return j | mListener.mListener(motionevent);
_L16:
        mHandler.sendEmptyMessageDelayed(3, DOUBLE_TAP_TIMEOUT);
_L14:
        j = 0;
          goto _L17
_L4:
        if (!mInLongPress)
        {
            float f3 = mLastFocusX - f1;
            float f4 = mLastFocusY - f;
            if (mIsDoubleTapping)
            {
                return false | mDoubleTapListener.(motionevent);
            }
            if (mAlwaysInTapRegion)
            {
                int k = (int)(f1 - mDownFocusX);
                int j1 = (int)(f - mDownFocusY);
                k = k * k + j1 * j1;
                MotionEvent motionevent1;
                VelocityTracker velocitytracker;
                boolean flag2;
                boolean flag3;
                if (k > mTouchSlopSquare)
                {
                    flag2 = mListener.mListener(mCurrentDownEvent, motionevent, f3, f4);
                    mLastFocusX = f1;
                    mLastFocusY = f;
                    mAlwaysInTapRegion = false;
                    mHandler.removeMessages(3);
                    mHandler.removeMessages(1);
                    mHandler.removeMessages(2);
                } else
                {
                    flag2 = false;
                }
                if (k > mTouchSlopSquare)
                {
                    mAlwaysInBiggerTapRegion = false;
                }
                return flag2;
            }
            if (Math.abs(f3) >= 1.0F || Math.abs(f4) >= 1.0F)
            {
                flag2 = mListener.mListener(mCurrentDownEvent, motionevent, f3, f4);
                mLastFocusX = f1;
                mLastFocusY = f;
                return flag2;
            }
        }
          goto _L1
_L3:
        mStillDown = false;
        motionevent1 = MotionEvent.obtain(motionevent);
        if (mIsDoubleTapping)
        {
            flag2 = mDoubleTapListener.(motionevent) | false;
        } else
        if (mInLongPress)
        {
            mHandler.removeMessages(3);
            mInLongPress = false;
            flag2 = false;
        } else
        if (mAlwaysInTapRegion)
        {
            flag3 = mListener.mListener(motionevent);
            flag2 = flag3;
            if (mDeferConfirmSingleTap)
            {
                flag2 = flag3;
                if (mDoubleTapListener != null)
                {
                    mDoubleTapListener.rmed(motionevent);
                    flag2 = flag3;
                }
            }
        } else
        {
            velocitytracker = mVelocityTracker;
            k = MotionEventCompat.getPointerId(motionevent, 0);
            velocitytracker.computeCurrentVelocity(1000, mMaximumFlingVelocity);
            f = VelocityTrackerCompat.getYVelocity(velocitytracker, k);
            f1 = VelocityTrackerCompat.getXVelocity(velocitytracker, k);
            if (Math.abs(f) > (float)mMinimumFlingVelocity || Math.abs(f1) > (float)mMinimumFlingVelocity)
            {
                flag2 = mListener.mListener(mCurrentDownEvent, motionevent, f1, f);
            } else
            {
                flag2 = false;
            }
        }
        if (mPreviousUpEvent != null)
        {
            mPreviousUpEvent.recycle();
        }
        mPreviousUpEvent = motionevent1;
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
        }
        mIsDoubleTapping = false;
        mDeferConfirmSingleTap = false;
        mHandler.removeMessages(1);
        mHandler.removeMessages(2);
        return flag2;
_L5:
        cancel();
        return false;
    }

    public void setIsLongpressEnabled(boolean flag)
    {
        mIsLongpressEnabled = flag;
    }

    public void setOnDoubleTapListener(android.view.atImplBase atimplbase)
    {
        mDoubleTapListener = atimplbase;
    }








/*
    static boolean access$502(GestureHandler gesturehandler, boolean flag)
    {
        gesturehandler.mDeferConfirmSingleTap = flag;
        return flag;
    }

*/

    public mDeferConfirmSingleTap(Context context, android.view.atImplBase atimplbase, Handler handler)
    {
    /* block-local class not found */
    class GestureHandler {}

        if (handler != null)
        {
            mHandler = new GestureHandler(handler);
        } else
        {
            mHandler = new GestureHandler();
        }
        mListener = atimplbase;
        if (atimplbase instanceof android.view.atImplBase.mListener)
        {
            setOnDoubleTapListener((android.view.atImplBase.setOnDoubleTapListener)atimplbase);
        }
        init(context);
    }
}
