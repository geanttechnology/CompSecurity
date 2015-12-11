// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package uk.co.senab.photoview.gestures;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

// Referenced classes of package uk.co.senab.photoview.gestures:
//            GestureDetector, OnGestureListener

public class CupcakeGestureDetector
    implements GestureDetector
{

    private static final String LOG_TAG = "CupcakeGestureDetector";
    private boolean mIsDragging;
    float mLastTouchX;
    float mLastTouchY;
    protected OnGestureListener mListener;
    final float mMinimumVelocity;
    final float mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public CupcakeGestureDetector(Context context)
    {
        context = ViewConfiguration.get(context);
        mMinimumVelocity = context.getScaledMinimumFlingVelocity();
        mTouchSlop = context.getScaledTouchSlop();
    }

    float getActiveX(MotionEvent motionevent)
    {
        return motionevent.getX();
    }

    float getActiveY(MotionEvent motionevent)
    {
        return motionevent.getY();
    }

    public boolean isScaling()
    {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag = false;
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 38
    //                   1 232
    //                   2 96
    //                   3 211;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        mVelocityTracker = VelocityTracker.obtain();
        if (mVelocityTracker != null)
        {
            mVelocityTracker.addMovement(motionevent);
        } else
        {
            Log.i("CupcakeGestureDetector", "Velocity tracker is null");
        }
        mLastTouchX = getActiveX(motionevent);
        mLastTouchY = getActiveY(motionevent);
        mIsDragging = false;
        return true;
_L4:
        float f = getActiveX(motionevent);
        float f2 = getActiveY(motionevent);
        float f4 = f - mLastTouchX;
        float f5 = f2 - mLastTouchY;
        if (!mIsDragging)
        {
            if (Math.sqrt(f4 * f4 + f5 * f5) >= (double)mTouchSlop)
            {
                flag = true;
            }
            mIsDragging = flag;
        }
        if (mIsDragging)
        {
            mListener.onDrag(f4, f5);
            mLastTouchX = f;
            mLastTouchY = f2;
            if (mVelocityTracker != null)
            {
                mVelocityTracker.addMovement(motionevent);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            return true;
        }
        if (true) goto _L1; else goto _L3
_L3:
        if (mIsDragging && mVelocityTracker != null)
        {
            mLastTouchX = getActiveX(motionevent);
            mLastTouchY = getActiveY(motionevent);
            mVelocityTracker.addMovement(motionevent);
            mVelocityTracker.computeCurrentVelocity(1000);
            float f1 = mVelocityTracker.getXVelocity();
            float f3 = mVelocityTracker.getYVelocity();
            if (Math.max(Math.abs(f1), Math.abs(f3)) >= mMinimumVelocity)
            {
                mListener.onFling(mLastTouchX, mLastTouchY, -f1, -f3);
            }
        }
        if (mVelocityTracker != null)
        {
            mVelocityTracker.recycle();
            mVelocityTracker = null;
            return true;
        }
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void setOnGestureListener(OnGestureListener ongesturelistener)
    {
        mListener = ongesturelistener;
    }
}
