// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;


// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl, TimelineListAdapter

class val.month
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;
    final int val$month;
    final int val$year;

    public void run()
    {
        if (adapter == null)
        {
            return;
        } else
        {
            adapter.expandYear(val$year);
            adapter.highlightDate(val$year, val$month);
            TimelineNavigatorListImpl.access$1100(TimelineNavigatorListImpl.this, adapter.getActiveContainerIndex(), 15);
            return;
        }
    }

    ()
    {
        this$0 = final_timelinenavigatorlistimpl;
        val$year = i;
        val$month = I.this;
        super();
    }
}
