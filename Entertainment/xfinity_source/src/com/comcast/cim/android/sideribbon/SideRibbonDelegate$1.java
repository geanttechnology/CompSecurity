// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.content.Context;
import android.content.res.Resources;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.comcast.cim.android.accessibility.AccessibilityUtil;
import com.comcast.cim.android.accessibility.PassiveGestureListener;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegate

class val.context extends RelativeLayout
{

    final SideRibbonDelegate this$0;
    final AccessibilityUtil val$accessibilityUtil;
    final Context val$context;

    public boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        if (!SideRibbonDelegate.access$000(SideRibbonDelegate.this).equals(ate.CLOSED))
        {
            SideRibbonDelegate.access$100(SideRibbonDelegate.this).onTouchEvent(motionevent);
        } else
        if (val$accessibilityUtil.isAccessibilityEnabled())
        {
            PassiveGestureListener _tmp = SideRibbonDelegate.access$200(SideRibbonDelegate.this);
            if (!PassiveGestureListener.isDownInRange(motionevent, val$context.getResources().getDisplayMetrics()))
            {
                return SideRibbonDelegate.access$300(SideRibbonDelegate.this).onTouchEvent(motionevent);
            }
        } else
        {
            return false;
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (!SideRibbonDelegate.access$000(SideRibbonDelegate.this).equals(ate.CLOSED))
        {
            SideRibbonDelegate.access$100(SideRibbonDelegate.this).onTouchEvent(motionevent);
        } else
        if (val$accessibilityUtil.isAccessibilityEnabled())
        {
            PassiveGestureListener _tmp = SideRibbonDelegate.access$200(SideRibbonDelegate.this);
            if (!PassiveGestureListener.isDownInRange(motionevent, val$context.getResources().getDisplayMetrics()))
            {
                return SideRibbonDelegate.access$300(SideRibbonDelegate.this).onTouchEvent(motionevent);
            }
        } else
        {
            return false;
        }
        return true;
    }

    ener(Context context2)
    {
        this$0 = final_sideribbondelegate;
        val$accessibilityUtil = AccessibilityUtil.this;
        val$context = context2;
        super(final_context1);
    }
}
