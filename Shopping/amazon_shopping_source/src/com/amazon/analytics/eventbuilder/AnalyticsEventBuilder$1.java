// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import com.amazon.device.analytics.events.Event;

// Referenced classes of package com.amazon.analytics.eventbuilder:
//            AnalyticsEventBuilder

class val.event
    implements Runnable
{

    final AnalyticsEventBuilder this$0;
    final Event val$event;

    public void run()
    {
        processEvent(val$event);
    }

    ()
    {
        this$0 = final_analyticseventbuilder;
        val$event = Event.this;
        super();
    }
}
