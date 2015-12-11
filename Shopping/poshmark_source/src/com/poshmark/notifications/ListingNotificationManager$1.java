// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.notifications;

import android.os.Handler;
import android.os.Message;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;

// Referenced classes of package com.poshmark.notifications:
//            ListingNotificationManager

class this._cls0
    implements PMApiResponseHandler
{

    final ListingNotificationManager this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (!pmapiresponse.hasError())
        {
            pmapiresponse = (ListingDetails)pmapiresponse.data;
            ListingNotificationManager.access$000(ListingNotificationManager.this, pmapiresponse);
            Message message = new Message();
            message.obj = pmapiresponse;
            message.what = 1;
            listingNotificationMsgHandler.sendMessage(message);
        }
    }

    ()
    {
        this$0 = ListingNotificationManager.this;
        super();
    }
}
