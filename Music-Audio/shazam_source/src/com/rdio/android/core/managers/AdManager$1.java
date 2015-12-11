// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.managers;

import com.google.a.d.e;
import com.rdio.android.api.models.Ad;
import com.rdio.android.core.RdioApiResponse;
import com.rdio.android.core.events.ads.BeginAdBreakEvent;
import com.rdio.android.core.events.ads.HasPendingAdEvent;
import com.rdio.android.core.events.ads.ShouldGetAdEvent;
import com.rdio.android.core.util.Logging;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.rdio.android.core.managers:
//            AdManager

class dEvent
    implements com.rdio.android.core.Api.ResponseListener
{

    final AdManager this$0;
    final ShouldGetAdEvent val$event;

    public void onResponse(RdioApiResponse rdioapiresponse)
    {
        Ad ad;
        for (rdioapiresponse = AdManager.access$000(AdManager.this, rdioapiresponse).iterator(); rdioapiresponse.hasNext(); AdManager.access$200(AdManager.this).post(new HasPendingAdEvent(ad)))
        {
            ad = (Ad)rdioapiresponse.next();
            AdManager.access$100(AdManager.this).add(ad.key);
        }

        if (val$event.isStartImmediately())
        {
            AdManager.access$300(AdManager.this).log(4, "AdManager", "Received ads, was told to start them immediately.");
            AdManager.access$200(AdManager.this).post(new BeginAdBreakEvent());
        }
    }

    dEvent()
    {
        this$0 = final_admanager;
        val$event = ShouldGetAdEvent.this;
        super();
    }
}
