// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DeleteFragment

class icsEvent
    implements Runnable
{

    final DeleteFragment this$0;
    final icsEvent val$completeEvent;

    public void run()
    {
        if (DeleteFragment.access$000(DeleteFragment.this))
        {
            GLogger.d(DeleteFragment.access$100(), " Delete MediaItem(s) Successful", new Object[0]);
            if (val$completeEvent != null && DeleteFragment.access$200(DeleteFragment.this) != null)
            {
                DeleteFragment.access$200(DeleteFragment.this).trackEvent(val$completeEvent);
            }
            GlobalMessagingBus.post(new ActionCompleteEvent(com.amazon.gallery.foundation.utils.messaging.nt.ActionSource.DELETE));
            return;
        } else
        {
            GLogger.d(DeleteFragment.access$100(), " Delete MediaItem(s) Failed", new Object[0]);
            return;
        }
    }

    icsEvent()
    {
        this$0 = final_deletefragment;
        val$completeEvent = icsEvent.this;
        super();
    }
}
