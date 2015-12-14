// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

public class GestureDetector
{
    public static interface ClickListener
    {

        public abstract boolean onClick();
    }


    long mActionDownTime;
    float mActionDownX;
    float mActionDownY;
    ClickListener mClickListener;
    boolean mIsCapturingGesture;
    boolean mIsClickCandidate;
    final float mSingleTapSlopPx;

    public GestureDetector(Context context)
    {
        mSingleTapSlopPx = ViewConfiguration.get(context).getScaledTouchSlop();
        init();
    }

    public static GestureDetector newInstance(Context context)
    {
        return new GestureDetector(context);
    }

    public void init()
    {
        mClickListener = null;
        reset();
    }

    public boolean isCapturingGesture()
    {
        return mIsCapturingGesture;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 36
    //                   0 38
    //                   1 133
    //                   2 74
    //                   3 121;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return true;
_L2:
        mIsCapturingGesture = true;
        mIsClickCandidate = true;
        mActionDownTime = motionevent.getEventTime();
        mActionDownX = motionevent.getX();
        mActionDownY = motionevent.getY();
        return true;
_L4:
        if (Math.abs(motionevent.getX() - mActionDownX) > mSingleTapSlopPx || Math.abs(motionevent.getY() - mActionDownY) > mSingleTapSlopPx)
        {
            mIsClickCandidate = false;
            return true;
        }
          goto _L1
_L5:
        mIsCapturingGesture = false;
        mIsClickCandidate = false;
        return true;
_L3:
        mIsCapturingGesture = false;
        if (Math.abs(motionevent.getX() - mActionDownX) > mSingleTapSlopPx || Math.abs(motionevent.getY() - mActionDownY) > mSingleTapSlopPx)
        {
            mIsClickCandidate = false;
        }
        if (mIsClickCandidate && motionevent.getEventTime() - mActionDownTime <= (long)ViewConfiguration.getLongPressTimeout() && mClickListener != null)
        {
            mClickListener.onClick();
        }
        mIsClickCandidate = false;
        return true;
    }

    public void reset()
    {
        mIsCapturingGesture = false;
        mIsClickCandidate = false;
    }

    public void setClickListener(ClickListener clicklistener)
    {
        mClickListener = clicklistener;
    }
}
