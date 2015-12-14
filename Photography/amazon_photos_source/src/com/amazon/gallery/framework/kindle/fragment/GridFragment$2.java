// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.fragment;

import android.support.v7.widget.RecyclerView;
import com.amazon.gallery.framework.gallery.timeline.TimelineNavigator;

// Referenced classes of package com.amazon.gallery.framework.kindle.fragment:
//            GridFragment

class finished extends android.support.v7.widget.ScrollListener
{

    private float cumulativeY;
    private boolean finished;
    final GridFragment this$0;

    public void onScrolled(RecyclerView recyclerview, int i, int j)
    {
        cumulativeY = cumulativeY + (float)j;
        timelineNavigator.onScroll(cumulativeY, recyclerview);
        if (!finished)
        {
            finished = checkLoadMoreItems(GridFragment.access$000(GridFragment.this));
        }
    }

    tor()
    {
        this$0 = GridFragment.this;
        super();
        cumulativeY = 0.0F;
        finished = false;
    }
}
