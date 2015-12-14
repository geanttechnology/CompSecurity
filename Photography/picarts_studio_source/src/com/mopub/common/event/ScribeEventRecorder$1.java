// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import com.mopub.network.ScribeRequest;
import java.util.List;

// Referenced classes of package com.mopub.common.event:
//            ScribeEventRecorder

class val.events
    implements com.mopub.network.questFactory
{

    final ScribeEventRecorder this$0;
    final List val$events;

    public ScribeRequest createRequest(com.mopub.network. )
    {
        return new ScribeRequest("https://analytics.mopub.com/i/jot/exchange_client_event", val$events, ScribeEventRecorder.access$000(ScribeEventRecorder.this), );
    }

    Factory()
    {
        this$0 = final_scribeeventrecorder;
        val$events = List.this;
        super();
    }
}
