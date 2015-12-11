// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.android.sideribbon;

import android.view.MotionEvent;

// Referenced classes of package com.comcast.cim.android.sideribbon:
//            SideRibbonDelegate

private class sideRibbonDelegate extends android.view.lideInGestureListener
{

    final int SWIPE_THRESHOLD_VELOCITY = 20;
    private SideRibbonDelegate sideRibbonDelegate;
    final SideRibbonDelegate this$0;

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        if (Math.abs(f) > Math.abs(f1) && f < 0.0F && Math.abs(f) > 20F)
        {
            sideRibbonDelegate.slideClosed(null);
            return true;
        } else
        {
            return false;
        }
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        sideRibbonDelegate.slideClosed(null);
        return true;
    }

    public (SideRibbonDelegate sideribbondelegate1)
    {
        this$0 = SideRibbonDelegate.this;
        super();
        sideRibbonDelegate = sideribbondelegate1;
    }
}
