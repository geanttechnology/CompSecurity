// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import com.amazon.insights.core.log.Logger;
import com.amazon.insights.core.util.StringUtil;
import com.amazon.insights.event.InternalEvent;
import com.amazon.insights.event.adapter.EventAdapter;
import org.json.JSONObject;

// Referenced classes of package com.amazon.insights.delivery:
//            DefaultDeliveryClient, EventStoreException, EventStore

class val.startEnqueueTimeMillis
    implements Runnable
{

    final DefaultDeliveryClient this$0;
    final InternalEvent val$event;
    final long val$origEventsProcessed;
    final long val$startEnqueueTimeMillis;

    public void run()
    {
        long l = System.currentTimeMillis();
        if (!DefaultDeliveryClient.access$100(DefaultDeliveryClient.this).put(((JSONObject)DefaultDeliveryClient.access$000(DefaultDeliveryClient.this).translateFromEvent(val$event)).toString())) goto _L2; else goto _L1
_L1:
        DefaultDeliveryClient.access$200().devi(String.format("Event: '%s' recorded to local filestore", new Object[] {
            StringUtil.clipString(val$event.getEventType(), 5, true)
        }));
        DefaultDeliveryClient.access$200().v(String.format("Time of enqueueEventForDelivery: %d", new Object[] {
            Long.valueOf(System.currentTimeMillis() - l)
        }));
_L4:
        DefaultDeliveryClient.access$300(DefaultDeliveryClient.this, val$origEventsProcessed, val$startEnqueueTimeMillis);
        return;
_L2:
        DefaultDeliveryClient.access$200().devw(String.format("Event: '%s' failed to record to local filestore", new Object[] {
            StringUtil.clipString(val$event.getEventType(), 5, true)
        }));
        if (true) goto _L4; else goto _L3
_L3:
        Object obj;
        obj;
        DefaultDeliveryClient.access$200().devw(String.format("Event: '%s' failed to record to local filestore", new Object[] {
            StringUtil.clipString(val$event.getEventType(), 5, true)
        }));
        DefaultDeliveryClient.access$300(DefaultDeliveryClient.this, val$origEventsProcessed, val$startEnqueueTimeMillis);
        return;
        obj;
        DefaultDeliveryClient.access$300(DefaultDeliveryClient.this, val$origEventsProcessed, val$startEnqueueTimeMillis);
        throw obj;
    }

    ()
    {
        this$0 = final_defaultdeliveryclient;
        val$event = internalevent;
        val$origEventsProcessed = l;
        val$startEnqueueTimeMillis = J.this;
        super();
    }
}
