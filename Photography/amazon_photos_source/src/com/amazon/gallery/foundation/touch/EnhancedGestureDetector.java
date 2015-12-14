// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.touch;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class EnhancedGestureDetector extends GestureDetector
{
    public static interface EnhancedOnGestureListener
        extends android.view.GestureDetector.OnGestureListener
    {

        public abstract boolean onTwoFingerTapUp(MotionEvent motionevent);
    }

    public static class EnhancedSimpleOnGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
        implements EnhancedOnGestureListener
    {

        public boolean onTwoFingerTapUp(MotionEvent motionevent)
        {
            return false;
        }

        public EnhancedSimpleOnGestureListener()
        {
        }
    }


    private static final int TWO_FINGER_TAP_TIMEOUT = ViewConfiguration.getTapTimeout();
    private MotionEvent mCurrentDownEvent;
    private final EnhancedOnGestureListener mListener;
    private boolean mTwoFingerTapDetected;

    public EnhancedGestureDetector(Context context, EnhancedOnGestureListener enhancedongesturelistener)
    {
        super(context, enhancedongesturelistener);
        mListener = enhancedongesturelistener;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        i = motionevent.getAction();
        flag1 = false;
        flag = flag1;
        i & 0xff;
        JVM INSTR tableswitch 0 6: default 60
    //                   0 132
    //                   1 167
    //                   2 63
    //                   3 219
    //                   4 63
    //                   5 69
    //                   6 63;
           goto _L1 _L2 _L3 _L4 _L5 _L4 _L6 _L4
_L5:
        break MISSING_BLOCK_LABEL_219;
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        flag = flag1;
_L7:
        if (flag)
        {
            return true;
        } else
        {
            return super.onTouchEvent(motionevent);
        }
_L6:
        if (motionevent.getPointerCount() == 2)
        {
            flag = flag1;
            if (motionevent.getEventTime() - mCurrentDownEvent.getEventTime() < 100L)
            {
                mTwoFingerTapDetected = true;
                flag = flag1;
            }
        } else
        {
            flag = flag1;
            if (motionevent.getPointerCount() > 2)
            {
                mTwoFingerTapDetected = false;
                flag = flag1;
            }
        }
          goto _L7
_L2:
        mCurrentDownEvent = MotionEvent.obtain(motionevent);
        flag = flag2;
        if (mCurrentDownEvent.getPointerCount() == 2)
        {
            flag = true;
        }
        mTwoFingerTapDetected = flag;
        flag = flag1;
          goto _L7
_L3:
        flag = flag1;
        if (mTwoFingerTapDetected)
        {
            flag = flag1;
            if (motionevent.getEventTime() - mCurrentDownEvent.getEventTime() < (long)TWO_FINGER_TAP_TIMEOUT)
            {
                flag = mListener.onTwoFingerTapUp(motionevent);
                mTwoFingerTapDetected = false;
            }
        }
          goto _L7
        mTwoFingerTapDetected = false;
        flag = flag1;
          goto _L7
    }

}
