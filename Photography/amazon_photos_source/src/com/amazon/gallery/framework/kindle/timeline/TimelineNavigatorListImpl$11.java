// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl, TimelineListAdapter

class val.topOffset
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;
    final List val$timeline;
    final int val$topOffset;
    final int val$topYear;

    public void run()
    {
        int i = adapter.getActiveContainerIndex();
        TimelineNavigatorListImpl.access$1200(TimelineNavigatorListImpl.this, val$timeline);
        TimelineNavigatorListImpl.access$1302(TimelineNavigatorListImpl.this, -1);
        TimelineNavigatorListImpl.access$1402(TimelineNavigatorListImpl.this, -1);
        TimelineNavigatorListImpl timelinenavigatorlistimpl = TimelineNavigatorListImpl.this;
        int j = val$topYear;
        int k = val$topOffset;
        boolean flag;
        if (i == -1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        TimelineNavigatorListImpl.access$1500(timelinenavigatorlistimpl, j, k, flag);
    }

    ()
    {
        this$0 = final_timelinenavigatorlistimpl;
        val$timeline = list;
        val$topYear = i;
        val$topOffset = I.this;
        super();
    }
}
