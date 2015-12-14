// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.timeline;

import com.amazon.gallery.framework.kindle.metrics.customer.TimelineMetrics;
import com.amazon.gallery.framework.kindle.ui.VisibilityAnimator;

// Referenced classes of package com.amazon.gallery.framework.kindle.timeline:
//            TimelineNavigatorListImpl

class vent
    implements Runnable
{

    final TimelineNavigatorListImpl this$0;
    final com.amazon.gallery.framework.gallery.timeline.ent val$showTimelineEvent;

    public void run()
    {
        boolean flag = true;
        if (TimelineNavigatorListImpl.access$600(TimelineNavigatorListImpl.this) || TimelineNavigatorListImpl.access$700(TimelineNavigatorListImpl.this) != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
        ..SwitchMap.com.amazon.gallery.framework.gallery.timeline.TimelineNavigator.TimelineEvent[val$showTimelineEvent.ordinal()];
        JVM INSTR tableswitch 1 3: default 60
    //                   1 141
    //                   2 148
    //                   3 155;
           goto _L3 _L4 _L5 _L6
_L3:
        if (obj != null)
        {
            TimelineNavigatorListImpl.access$702(TimelineNavigatorListImpl.this, TimelineNavigatorListImpl.access$800(TimelineNavigatorListImpl.this).newTimer(((Enum) (obj))));
        }
_L2:
        TimelineNavigatorListImpl.access$000(TimelineNavigatorListImpl.this).show();
        TimelineNavigatorListImpl.access$102(TimelineNavigatorListImpl.this, true);
        obj = TimelineNavigatorListImpl.this;
        if (!TimelineNavigatorListImpl.access$900(TimelineNavigatorListImpl.this) || com.amazon.gallery.framework.gallery.timeline.ent.AUTO_OPEN != val$showTimelineEvent)
        {
            flag = false;
        }
        TimelineNavigatorListImpl.access$902(((TimelineNavigatorListImpl) (obj)), flag);
        TimelineNavigatorListImpl.access$400(TimelineNavigatorListImpl.this);
        return;
_L4:
        obj = com.amazon.gallery.framework.kindle.metrics.customer..TimelineAutoOpen;
        continue; /* Loop/switch isn't completed */
_L5:
        obj = com.amazon.gallery.framework.kindle.metrics.customer..TimelineSwipeOpen;
        continue; /* Loop/switch isn't completed */
_L6:
        obj = com.amazon.gallery.framework.kindle.metrics.customer..TimelineTapOpen;
        if (true) goto _L3; else goto _L7
_L7:
    }

    vent()
    {
        this$0 = final_timelinenavigatorlistimpl;
        val$showTimelineEvent = com.amazon.gallery.framework.gallery.timeline.ent.this;
        super();
    }
}
