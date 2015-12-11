// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.graphics.Point;
import android.support.v4.view.MotionEventCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.poshmark.utils:
//            PMGestureDetectorListener

public class PMGestureDetector
    implements android.view.View.OnTouchListener
{
    static final class STATE extends Enum
    {

        private static final STATE $VALUES[];
        public static final STATE MULTI_FINGER_DRAG;
        public static final STATE MULTI_TAP_START;
        public static final STATE NONE;
        public static final STATE SINGLE_FINGER_DRAG;
        public static final STATE SINGLE_TAP_START;

        public static STATE valueOf(String s)
        {
            return (STATE)Enum.valueOf(com/poshmark/utils/PMGestureDetector$STATE, s);
        }

        public static STATE[] values()
        {
            return (STATE[])$VALUES.clone();
        }

        static 
        {
            NONE = new STATE("NONE", 0);
            SINGLE_TAP_START = new STATE("SINGLE_TAP_START", 1);
            MULTI_TAP_START = new STATE("MULTI_TAP_START", 2);
            SINGLE_FINGER_DRAG = new STATE("SINGLE_FINGER_DRAG", 3);
            MULTI_FINGER_DRAG = new STATE("MULTI_FINGER_DRAG", 4);
            $VALUES = (new STATE[] {
                NONE, SINGLE_TAP_START, MULTI_TAP_START, SINGLE_FINGER_DRAG, MULTI_FINGER_DRAG
            });
        }

        private STATE(String s, int i)
        {
            super(s, i);
        }
    }


    long gestureStartTimestamp;
    long gestureStopTimestamp;
    STATE gesture_state;
    PMGestureDetectorListener listener;
    Point majorPointCurrent;
    Point majorPointPrev;
    int majorPointerId;
    Point majorStartPoint;
    Point minorPointCurrent;
    Point minorPointPrev;
    int minorPointerId;
    View view;

    public PMGestureDetector(View view1, PMGestureDetectorListener pmgesturedetectorlistener)
    {
        gesture_state = STATE.NONE;
        majorPointPrev = new Point();
        majorPointCurrent = new Point();
        minorPointPrev = new Point();
        minorPointCurrent = new Point();
        listener = pmgesturedetectorlistener;
        view = view1;
        view.setOnTouchListener(this);
    }

    public boolean onTouch(View view1, MotionEvent motionevent)
    {
        int i;
        boolean flag;
        flag = true;
        i = MotionEventCompat.getActionMasked(motionevent);
        Log.d("PMGesture", String.format("pointerCOunt = %s", new Object[] {
            Integer.toString(motionevent.getPointerCount())
        }));
        if (view1 != view)
        {
            Log.d("PMGesture", "gesture on another view!");
        }
        i;
        JVM INSTR tableswitch 0 6: default 92
    //                   0 102
    //                   1 1184
    //                   2 499
    //                   3 1292
    //                   4 1302
    //                   5 267
    //                   6 378;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        flag = view1.onTouchEvent(motionevent);
_L10:
        return flag;
_L2:
        try
        {
            gestureStartTimestamp = System.currentTimeMillis();
            gesture_state = STATE.SINGLE_TAP_START;
            majorPointerId = motionevent.getPointerId(0);
            Log.d("PMGesture", String.format("Major Index %s", new Object[] {
                Integer.valueOf(majorPointerId)
            }));
            majorPointPrev.x = (int)motionevent.getX(majorPointerId);
            majorPointPrev.y = (int)motionevent.getY(majorPointerId);
            if (majorStartPoint == null)
            {
                majorStartPoint = new Point(majorPointPrev.x, majorPointPrev.y);
            }
            Log.d("PMGesture", String.format("Primary Point Down : %s, %s", new Object[] {
                Integer.valueOf(majorPointPrev.x), Integer.valueOf(majorPointPrev.y)
            }));
        }
        // Misplaced declaration of an exception variable
        catch (View view1)
        {
            gesture_state = STATE.NONE;
            return true;
        }
        return true;
_L7:
        try
        {
            gestureStartTimestamp = System.currentTimeMillis();
            gesture_state = STATE.MULTI_TAP_START;
            minorPointerId = motionevent.getPointerId(MotionEventCompat.getActionIndex(motionevent));
            minorPointPrev.x = (int)motionevent.getX(minorPointerId);
            minorPointPrev.y = (int)motionevent.getY(minorPointerId);
            Log.d("PMGesture", String.format("Second Point Down : %s, %s", new Object[] {
                Integer.valueOf(minorPointPrev.x), Integer.valueOf(minorPointPrev.y)
            }));
        }
        // Misplaced declaration of an exception variable
        catch (View view1)
        {
            gesture_state = STATE.NONE;
            return true;
        }
        return true;
_L8:
        gestureStartTimestamp = System.currentTimeMillis();
        gesture_state = STATE.SINGLE_TAP_START;
        if (motionevent.getPointerId(MotionEventCompat.getActionIndex(motionevent)) == majorPointerId)
        {
            majorPointPrev.x = (int)motionevent.getX(minorPointerId);
            majorPointPrev.y = (int)motionevent.getY(minorPointerId);
            Log.d("PMGesture", String.format("New PREVIOUS  Point : %s, %s", new Object[] {
                Integer.valueOf(majorPointPrev.x), Integer.valueOf(majorPointPrev.y)
            }));
        }
        if (motionevent.getPointerCount() >= 2) goto _L10; else goto _L9
_L9:
        listener.onPinchZoomEnd();
        return true;
_L4:
        if (gesture_state == STATE.SINGLE_TAP_START)
        {
            gesture_state = STATE.SINGLE_FINGER_DRAG;
            majorPointCurrent.x = (int)motionevent.getX(majorPointerId);
            majorPointCurrent.y = (int)motionevent.getY(majorPointerId);
            Log.d("PMGesture", "Dragging");
            Log.d("PMGesture", String.format("New Primary Point : %s, %s", new Object[] {
                Integer.valueOf(majorPointCurrent.x), Integer.valueOf(majorPointCurrent.y)
            }));
            listener.onDragStart(majorPointPrev);
            listener.onDrag(majorPointPrev, majorPointCurrent);
            majorPointPrev.x = majorPointCurrent.x;
            majorPointPrev.y = majorPointCurrent.y;
            return true;
        }
        if (gesture_state == STATE.MULTI_TAP_START)
        {
            if (gesture_state == STATE.SINGLE_FINGER_DRAG)
            {
                listener.onDragEnd();
            }
            gesture_state = STATE.MULTI_FINGER_DRAG;
            majorPointCurrent.x = (int)motionevent.getX(majorPointerId);
            majorPointCurrent.y = (int)motionevent.getY(majorPointerId);
            minorPointCurrent.x = (int)motionevent.getX(minorPointerId);
            minorPointCurrent.y = (int)motionevent.getY(minorPointerId);
            listener.onPinchZoomStart(majorPointPrev, minorPointPrev);
            listener.onPinchZoom(majorPointPrev, majorPointCurrent, minorPointPrev, minorPointCurrent);
            majorPointPrev.x = majorPointCurrent.x;
            majorPointPrev.y = majorPointCurrent.y;
            minorPointPrev.x = minorPointCurrent.x;
            minorPointPrev.y = minorPointCurrent.y;
            Log.d("PMGesture", "Pinch-Zooming Start");
            return true;
        }
        if (gesture_state == STATE.MULTI_FINGER_DRAG)
        {
            majorPointCurrent.x = (int)motionevent.getX(majorPointerId);
            majorPointCurrent.y = (int)motionevent.getY(majorPointerId);
            minorPointCurrent.x = (int)motionevent.getX(minorPointerId);
            minorPointCurrent.y = (int)motionevent.getY(minorPointerId);
            listener.onPinchZoom(majorPointPrev, majorPointCurrent, minorPointPrev, minorPointCurrent);
            majorPointPrev.x = majorPointCurrent.x;
            majorPointPrev.y = majorPointCurrent.y;
            minorPointPrev.x = minorPointCurrent.x;
            minorPointPrev.y = minorPointCurrent.y;
            Log.d("PMGesture", "Pinch-Zooming");
            return true;
        }
        if (gesture_state != STATE.SINGLE_FINGER_DRAG) goto _L10; else goto _L11
_L11:
        majorPointCurrent.x = (int)motionevent.getX(majorPointerId);
        majorPointCurrent.y = (int)motionevent.getY(majorPointerId);
        Log.d("PMGesture", String.format("New Point offset : %s, %s", new Object[] {
            Integer.valueOf(majorPointCurrent.x - majorPointPrev.x), Integer.valueOf(majorPointCurrent.y - majorPointPrev.y)
        }));
        listener.onDrag(majorPointPrev, majorPointCurrent);
        majorPointPrev.x = majorPointCurrent.x;
        majorPointPrev.y = majorPointCurrent.y;
        Log.d("PMGesture", "Dragging");
        return true;
_L3:
        if (gesture_state == STATE.SINGLE_TAP_START)
        {
            Log.d("PMGesture", "Single Tap");
        } else
        if (gesture_state == STATE.MULTI_TAP_START)
        {
            Log.d("PMGesture", "Multi Tap");
        } else
        if (gesture_state == STATE.MULTI_FINGER_DRAG)
        {
            Log.d("PMGesture", "Pinch-Zooming DONE");
        } else
        if (gesture_state == STATE.SINGLE_FINGER_DRAG)
        {
            listener.onDragEnd();
            Log.d("PMGesture", "Dragging DOne");
        }
        gesture_state = STATE.NONE;
        listener.onActionEnd();
        return true;
_L5:
        Log.d("PMGesture", "Action was CANCEL");
        return true;
_L6:
        Log.d("PMGesture", "Movement occurred outside bounds of current screen element");
        return true;
    }
}
