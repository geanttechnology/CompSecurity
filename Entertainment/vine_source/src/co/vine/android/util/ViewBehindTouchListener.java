// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.edisonwang.android.slog.SLog;
import com.jeremyfeinstein.slidingmenu.lib.CustomViewAbove;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class ViewBehindTouchListener
    implements co.vine.android.views.TouchableRelativeLayout.TouchListener
{

    private int mActivePointerId;
    private float mInitialX;
    private final View mInvalidateTarget;
    private boolean mIsScrolling;
    private boolean mSetInitials;
    private final CustomViewAbove mSlideController;
    private final int mTouchSlop;

    public ViewBehindTouchListener(Context context, SlidingMenu slidingmenu)
    {
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(context));
        mSlideController = slidingmenu.getViewAbove();
        mInvalidateTarget = slidingmenu.getViewBehind();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        int i;
        SLog.d("onInterceptTouchEvent!!!!");
        i = MotionEventCompat.getActionMasked(motionevent);
        if (i == 3 || i == 1)
        {
            mIsScrolling = false;
            return false;
        }
        i;
        JVM INSTR tableswitch 0 2: default 56
    //                   0 122
    //                   1 56
    //                   2 76;
           goto _L1 _L2 _L1 _L3
_L1:
        mSlideController.addMovement(motionevent);
        mInvalidateTarget.postInvalidateDelayed(100L);
        return false;
_L3:
        if (mIsScrolling)
        {
            SLog.d("Scrolling 2");
            return true;
        }
        if (Math.abs((int)(motionevent.getX() - mInitialX)) > mTouchSlop)
        {
            SLog.d("Scrolling");
            mIsScrolling = true;
            return true;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        mInitialX = motionevent.getX();
        mActivePointerId = MotionEventCompat.getPointerId(motionevent, MotionEventCompat.getActionIndex(motionevent));
        mSetInitials = true;
        if (true) goto _L1; else goto _L4
_L4:
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        SLog.d("onTouchEvent!!");
        if (mSetInitials)
        {
            mSlideController.setInitialTouchEvents(motionevent.getX(), mActivePointerId);
            mSlideController.determineDrag(motionevent);
            mSetInitials = false;
        }
        mSlideController.onTouchEvent(motionevent);
        motionevent.getAction();
        JVM INSTR tableswitch 1 3: default 80
    //                   1 82
    //                   2 80
    //                   3 82;
           goto _L1 _L2 _L1 _L2
_L1:
        return true;
_L2:
        mIsScrolling = false;
        if (true) goto _L1; else goto _L3
_L3:
    }
}
