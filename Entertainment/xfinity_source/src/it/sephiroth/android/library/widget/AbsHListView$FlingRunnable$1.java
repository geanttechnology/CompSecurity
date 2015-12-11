// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.view.VelocityTracker;

// Referenced classes of package it.sephiroth.android.library.widget:
//            AbsHListView, OverScroller

class this._cls1
    implements Runnable
{

    final eChange this$1;

    public void run()
    {
        int i = AbsHListView.access$800(_fld0);
        VelocityTracker velocitytracker = AbsHListView.access$900(_fld0);
        OverScroller overscroller = cess._mth1000(this._cls1.this);
        if (velocitytracker == null || i == -1)
        {
            return;
        }
        velocitytracker.computeCurrentVelocity(1000, AbsHListView.access$1100(_fld0));
        float f = -velocitytracker.getXVelocity(i);
        if (Math.abs(f) >= (float)AbsHListView.access$1200(_fld0) && overscroller.isScrollingInDirection(f, 0.0F))
        {
            postDelayed(this, 40L);
            return;
        } else
        {
            dFling();
            mTouchMode = 3;
            reportScrollStateChange(1);
            return;
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
