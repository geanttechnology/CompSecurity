// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.video;

import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.video:
//            VASTVideoView

class val.trackingEvents
    implements Runnable
{

    final VASTVideoView this$0;
    final List val$trackingEvents;

    public void run()
    {
        Iterator iterator = val$trackingEvents.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ngEvent ngevent = (ngEvent)iterator.next();
            if (ngevent != null && !Utils.isEmpty(ngevent.url) && !VASTVideoView.access$2800(VASTVideoView.this).contains(ngevent))
            {
                VASTVideoView.access$2900(VASTVideoView.this, ngevent);
            }
        } while (true);
    }

    ngEvent()
    {
        this$0 = final_vastvideoview;
        val$trackingEvents = List.this;
        super();
    }
}
