// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal.adcontrollers;

import com.millennialmedia.MMLog;
import com.millennialmedia.internal.utils.HttpUtils;
import com.millennialmedia.internal.utils.Utils;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.millennialmedia.internal.adcontrollers:
//            LightboxController

class val.trackingEvents
    implements Runnable
{

    final LightboxController this$0;
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
            ackingEvent ackingevent = (ackingEvent)iterator.next();
            if (ackingevent != null && !Utils.isEmpty(ackingevent.uri))
            {
                if (MMLog.isDebugEnabled())
                {
                    MMLog.d(LightboxController.access$200(), (new StringBuilder()).append("Firing tracking url = ").append(ackingevent.uri).toString());
                }
                HttpUtils.getContentFromGetRequest(ackingevent.uri);
            }
        } while (true);
    }

    ackingEvent()
    {
        this$0 = final_lightboxcontroller;
        val$trackingEvents = List.this;
        super();
    }
}
