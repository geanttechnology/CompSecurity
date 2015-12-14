// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import android.widget.ListView;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class val.timelineBar
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;
    final ListView val$timelineBar;

    public void run()
    {
        val$timelineBar.setAdapter(adapter);
    }

    ()
    {
        this$0 = final_timelinenavigatorlistimpl;
        val$timelineBar = ListView.this;
        super();
    }
}
