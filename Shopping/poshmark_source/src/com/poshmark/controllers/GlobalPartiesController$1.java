// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import com.poshmark.data_model.models.EventList;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import java.util.Date;

// Referenced classes of package com.poshmark.controllers:
//            GlobalPartiesController

class this._cls0
    implements PMApiResponseHandler
{

    final GlobalPartiesController this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            eventList = (EventList)pmapiresponse.data;
            lastFetchTime = new Date();
            if (eventList != null)
            {
                eventList.filterParties();
                GlobalPartiesController.access$000(GlobalPartiesController.this);
                PMNotificationManager.fireNotification("com.poshmark.intents.EVENTS_FETCH_COMPLETE");
            }
        }
    }

    ()
    {
        this$0 = GlobalPartiesController.this;
        super();
    }
}
