// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.controllers;

import com.poshmark.data_model.models.ShowroomGroupList;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import java.util.Date;

// Referenced classes of package com.poshmark.controllers:
//            ShowroomsController

class this._cls0
    implements PMApiResponseHandler
{

    final ShowroomsController this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            showroomGroupList = (ShowroomGroupList)pmapiresponse.data;
            lastFetchTime = new Date();
            if (showroomGroupList != null)
            {
                PMNotificationManager.fireNotification("com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE");
            }
        }
    }

    r()
    {
        this$0 = ShowroomsController.this;
        super();
    }
}
