// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.view.MotionEvent;
import android.view.View;
import com.mopub.common.AdReport;

// Referenced classes of package com.mopub.mobileads:
//            AdAlertReporter

public class AdAlertGestureListener extends android.view.GestureDetector.SimpleOnGestureListener
{

    private static final float MAXIMUM_THRESHOLD_X_IN_DIPS = 100F;
    private static final float MAXIMUM_THRESHOLD_Y_IN_DIPS = 100F;
    private static final int MINIMUM_NUMBER_OF_ZIGZAGS_TO_FLAG = 4;
    private AdAlertReporter mAdAlertReporter;
    private final AdReport mAdReport;
    private float mCurrentThresholdInDips;
    private ZigZagState mCurrentZigZagState;
    private boolean mHasCrossedLeftThreshold;
    private boolean mHasCrossedRightThreshold;
    private int mNumberOfZigZags;
    private float mPivotPositionX;
    private float mPreviousPositionX;
    private View mView;

    AdAlertGestureListener(View view, AdReport adreport)
    {
        mCurrentThresholdInDips = 100F;
        mCurrentZigZagState = ZigZagState.UNSET;
        if (view != null && view.getWidth() > 0)
        {
            mCurrentThresholdInDips = Math.min(100F, (float)view.getWidth() / 3F);
        }
        mView = view;
        mAdReport = adreport;
    }

    private void incrementNumberOfZigZags()
    {
        mNumberOfZigZags = mNumberOfZigZags + 1;
        if (mNumberOfZigZags >= 4)
        {
            mCurrentZigZagState = ZigZagState.FINISHED;
        }
    }

    private boolean isMovingLeft(float f)
    {
        return f < mPreviousPositionX;
    }

    private boolean isMovingRight(float f)
    {
        return f > mPreviousPositionX;
    }

    private boolean isTouchOutOfBoundsOnYAxis(float f, float f1)
    {
        return Math.abs(f1 - f) > 100F;
    }

    private boolean leftThresholdReached(float f)
    {
        if (mHasCrossedLeftThreshold)
        {
            return true;
        }
        if (f <= mPivotPositionX - mCurrentThresholdInDips)
        {
            mHasCrossedRightThreshold = false;
            mHasCrossedLeftThreshold = true;
            incrementNumberOfZigZags();
            return true;
        } else
        {
            return false;
        }
    }

    private boolean rightThresholdReached(float f)
    {
        if (mHasCrossedRightThreshold)
        {
            return true;
        }
        if (f >= mPivotPositionX + mCurrentThresholdInDips)
        {
            mHasCrossedLeftThreshold = false;
            mHasCrossedRightThreshold = true;
            return true;
        } else
        {
            return false;
        }
    }

    private void updateInitialState(float f)
    {
        if (f > mPivotPositionX)
        {
            mCurrentZigZagState = ZigZagState.GOING_RIGHT;
        }
    }

    private void updateZag(float f)
    {
        if (leftThresholdReached(f) && isMovingRight(f))
        {
            mCurrentZigZagState = ZigZagState.GOING_RIGHT;
            mPivotPositionX = f;
        }
    }

    private void updateZig(float f)
    {
        if (rightThresholdReached(f) && isMovingLeft(f))
        {
            mCurrentZigZagState = ZigZagState.GOING_LEFT;
            mPivotPositionX = f;
        }
    }

    void finishGestureDetection()
    {
        if (mCurrentZigZagState == ZigZagState.FINISHED)
        {
            mAdAlertReporter = new AdAlertReporter(mView.getContext(), mView, mAdReport);
            mAdAlertReporter.send();
        }
        reset();
    }

    AdAlertReporter getAdAlertReporter()
    {
        return mAdAlertReporter;
    }

    ZigZagState getCurrentZigZagState()
    {
        return mCurrentZigZagState;
    }

    float getMinimumDipsInZigZag()
    {
        return mCurrentThresholdInDips;
    }

    int getNumberOfZigzags()
    {
        return mNumberOfZigZags;
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (mCurrentZigZagState == ZigZagState.FINISHED)
        {
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
        if (isTouchOutOfBoundsOnYAxis(motionevent.getY(), motionevent1.getY()))
        {
            mCurrentZigZagState = ZigZagState.FAILED;
            return super.onScroll(motionevent, motionevent1, f, f1);
        }
        class _cls1
        {

            static final int $SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState[];

            static 
            {
                $SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState = new int[ZigZagState.values().length];
                try
                {
                    $SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState[ZigZagState.UNSET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState[ZigZagState.GOING_RIGHT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState[ZigZagState.GOING_LEFT.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$mopub$mobileads$AdAlertGestureListener$ZigZagState[ZigZagState.FAILED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.mopub.mobileads.AdAlertGestureListener.ZigZagState[mCurrentZigZagState.ordinal()];
        JVM INSTR tableswitch 1 3: default 88
    //                   1 106
    //                   2 125
    //                   3 136;
           goto _L1 _L2 _L3 _L4
_L1:
        mPreviousPositionX = motionevent1.getX();
        return super.onScroll(motionevent, motionevent1, f, f1);
_L2:
        mPivotPositionX = motionevent.getX();
        updateInitialState(motionevent1.getX());
        continue; /* Loop/switch isn't completed */
_L3:
        updateZig(motionevent1.getX());
        continue; /* Loop/switch isn't completed */
_L4:
        updateZag(motionevent1.getX());
        if (true) goto _L1; else goto _L5
_L5:
    }

    void reset()
    {
        mNumberOfZigZags = 0;
        mCurrentZigZagState = ZigZagState.UNSET;
    }

    private class ZigZagState extends Enum
    {

        private static final ZigZagState $VALUES[];
        public static final ZigZagState FAILED;
        public static final ZigZagState FINISHED;
        public static final ZigZagState GOING_LEFT;
        public static final ZigZagState GOING_RIGHT;
        public static final ZigZagState UNSET;

        public static ZigZagState valueOf(String s)
        {
            return (ZigZagState)Enum.valueOf(com/mopub/mobileads/AdAlertGestureListener$ZigZagState, s);
        }

        public static ZigZagState[] values()
        {
            return (ZigZagState[])$VALUES.clone();
        }

        static 
        {
            UNSET = new ZigZagState("UNSET", 0);
            GOING_RIGHT = new ZigZagState("GOING_RIGHT", 1);
            GOING_LEFT = new ZigZagState("GOING_LEFT", 2);
            FINISHED = new ZigZagState("FINISHED", 3);
            FAILED = new ZigZagState("FAILED", 4);
            $VALUES = (new ZigZagState[] {
                UNSET, GOING_RIGHT, GOING_LEFT, FINISHED, FAILED
            });
        }

        private ZigZagState(String s, int i)
        {
            super(s, i);
        }
    }

}
