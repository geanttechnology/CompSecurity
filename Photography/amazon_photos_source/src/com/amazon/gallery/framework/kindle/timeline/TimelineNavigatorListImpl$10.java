// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;


// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl, TimelineListAdapter

class val.scrollOffset
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;
    final boolean val$expandHighlight;
    final long val$highlightDate;
    final int val$scrollOffset;
    final int val$topLeftItemMonth;
    final int val$topLeftItemYear;
    final int val$yearFocused;

    public void run()
    {
        if (adapter == null)
        {
            return;
        }
        if (val$expandHighlight)
        {
            adapter.expandYear(val$topLeftItemYear);
        }
        Integer integer;
        if (val$highlightDate == -1L)
        {
            adapter.collapseAll();
        } else
        {
            adapter.highlightDate(val$topLeftItemYear, val$topLeftItemMonth);
        }
        integer = adapter.getYearIndex(val$yearFocused);
        if (integer == null)
        {
            TimelineNavigatorListImpl.access$1100(TimelineNavigatorListImpl.this, adapter.getActiveContainerIndex(), 15);
            return;
        } else
        {
            TimelineNavigatorListImpl.access$1100(TimelineNavigatorListImpl.this, integer.intValue(), val$scrollOffset);
            return;
        }
    }

    ()
    {
        this$0 = final_timelinenavigatorlistimpl;
        val$expandHighlight = flag;
        val$topLeftItemYear = i;
        val$highlightDate = l;
        val$topLeftItemMonth = j;
        val$yearFocused = k;
        val$scrollOffset = I.this;
        super();
    }
}
