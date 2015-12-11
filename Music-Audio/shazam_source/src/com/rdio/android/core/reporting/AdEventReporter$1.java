// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.reporting;

import com.rdio.android.api.models.Ad;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.events.ads.AdCompletedEvent;

// Referenced classes of package com.rdio.android.core.reporting:
//            AdEventReporter

class val.event
    implements com.rdio.android.core.sponseListener
{

    final AdEventReporter this$0;
    final AdCompletedEvent val$event;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        handleAdPlayResponse(val$event.ad.key, rdioapiresponse);
    }

    ener()
    {
        this$0 = final_adeventreporter;
        val$event = AdCompletedEvent.this;
        super();
    }
}
