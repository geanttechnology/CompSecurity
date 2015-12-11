// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.widget.AbsListView;

// Referenced classes of package com.groupon.view:
//            FixedPositionListView

class val.selectedPosition
    implements Runnable
{

    final FixedPositionListView this$0;
    final int val$selectedPosition;
    final AbsListView val$view;
    final int val$visiblePosition;

    public void run()
    {
        val$view.smoothScrollToPositionFromTop(val$visiblePosition, 0);
        if (FixedPositionListView.access$000(FixedPositionListView.this) != null)
        {
            FixedPositionListView.access$000(FixedPositionListView.this).onStopScroll(val$selectedPosition);
        }
        FixedPositionListView.access$102(FixedPositionListView.this, val$selectedPosition);
    }

    PositionChangedListener()
    {
        this$0 = final_fixedpositionlistview;
        val$view = abslistview;
        val$visiblePosition = i;
        val$selectedPosition = I.this;
        super();
    }
}
