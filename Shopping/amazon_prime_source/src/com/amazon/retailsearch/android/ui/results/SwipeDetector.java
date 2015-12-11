// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

public class SwipeDetector
{
    public static interface Listener
    {

        public abstract boolean onDown(MotionEvent motionevent);

        public abstract boolean onMove(float f, float f1, MotionEvent motionevent, float f2, float f3);

        public abstract boolean onSwipe(float f, float f1, MotionEvent motionevent, float f2, float f3);
    }


    private static final int MAX_Y_DISTANCE = 150;
    private static final int MIN_X_DISTANCE = 20;
    private final Listener callback;
    private final float density;
    float downX;
    float downY;
    private final float maxDistanceY;
    private final int maxVelocity;
    private final float minDistanceX;
    private final int minVelocity;
    private final int slop;
    boolean swiping;
    VelocityTracker velocityTracker;

    public SwipeDetector(Context context, Listener listener)
    {
        callback = listener;
        density = context.getResources().getDisplayMetrics().density;
        minDistanceX = (int)(20F * density + 0.5F);
        maxDistanceY = (int)(150F * density + 0.5F);
        context = ViewConfiguration.get(context);
        minVelocity = context.getScaledMinimumFlingVelocity() / 4;
        maxVelocity = context.getScaledMaximumFlingVelocity();
        slop = context.getScaledTouchSlop();
    }

    public void clear()
    {
        downX = 0.0F;
        downY = 0.0F;
        if (velocityTracker != null)
        {
            velocityTracker.recycle();
            velocityTracker = null;
        }
        swiping = false;
    }

    public boolean isSwiping()
    {
        return swiping;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = false;
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 3: default 40
    //                   0 43
    //                   1 116
    //                   2 300
    //                   3 294;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        return flag;
_L2:
        downX = motionevent.getRawX();
        downY = motionevent.getRawY();
        velocityTracker = VelocityTracker.obtain();
        velocityTracker.addMovement(motionevent);
        swiping = false;
        if (callback == null)
        {
            return false;
        }
        flag1 = callback.onDown(motionevent);
        flag = flag1;
        if (!flag1)
        {
            clear();
            return flag1;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (velocityTracker != null)
        {
            float f = Math.abs(motionevent.getRawX() - downX);
            float f2 = Math.abs(motionevent.getRawY() - downY);
            velocityTracker.addMovement(motionevent);
            velocityTracker.computeCurrentVelocity(1000);
            float f4 = velocityTracker.getXVelocity();
            float f5 = Math.abs(f4);
            float f6 = velocityTracker.getYVelocity();
            if (f2 > maxDistanceY)
            {
                flag = false;
            } else
            {
                flag = flag1;
                if (f > minDistanceX)
                {
                    flag = flag1;
                    if (f5 > (float)minVelocity)
                    {
                        flag = flag1;
                        if (f5 < (float)maxVelocity)
                        {
                            if (callback == null)
                            {
                                flag = false;
                            } else
                            {
                                flag = callback.onSwipe(downX, downY, motionevent, f4, f6);
                            }
                        }
                    }
                }
            }
            clear();
            return flag;
        }
        if (true) goto _L1; else goto _L5
_L5:
        clear();
        return false;
_L4:
        if (velocityTracker != null)
        {
            velocityTracker.addMovement(motionevent);
            float f1 = Math.abs(motionevent.getRawX() - downX);
            float f3 = Math.abs(motionevent.getRawY() - downY);
            boolean flag2 = swiping;
            flag = flag2;
            if (f1 > (float)slop)
            {
                flag = flag2;
                if (f1 > f3)
                {
                    swiping = true;
                    if (callback == null)
                    {
                        return false;
                    }
                    boolean flag3 = callback.onMove(downX, downY, motionevent, velocityTracker.getXVelocity(), velocityTracker.getYVelocity());
                    flag = flag3;
                    if (!flag3)
                    {
                        clear();
                        return flag3;
                    }
                }
            }
        }
        if (true) goto _L1; else goto _L6
_L6:
    }
}
