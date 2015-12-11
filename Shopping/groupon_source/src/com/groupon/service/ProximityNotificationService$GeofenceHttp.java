// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.http.Http;
import com.groupon.models.notification.ProximityNotificationResponse;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.tracking.mobile.sdk.NoScheduledUploadLogger;
import com.groupon.util.DeviceInfoUtil;
import java.util.ArrayList;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            ProximityNotificationService

protected class this._cls0 extends Http
{

    final ProximityNotificationService this$0;

    protected void onException(Exception exception)
    {
        Ln.d((new StringBuilder()).append("Proximity_Notifications: API call unsuccessful. ").append(exception).toString(), new Object[0]);
        ProximityNotificationService.access$400(ProximityNotificationService.this).logGeneralEvent("proximity_notification", "api_call_exception", null, 0, Logger.NULL_NST_FIELD);
    }

    protected void onSuccess(ProximityNotificationResponse proximitynotificationresponse)
        throws Exception
    {
        if (proximitynotificationresponse != null)
        {
            Ln.d("Proximity_Notifications: API call successful.", new Object[0]);
            ProximityNotificationService.access$300(ProximityNotificationService.this, proximitynotificationresponse);
        }
    }

    protected volatile void onSuccess(Object obj)
        throws Exception
    {
        onSuccess((ProximityNotificationResponse)obj);
    }

    public (ArrayList arraylist)
    {
        this$0 = ProximityNotificationService.this;
        super(ProximityNotificationService.this, com/groupon/models/notification/ProximityNotificationResponse, String.format("https:/mobile/location/geofence?%s=%s", new Object[] {
            "lang", ProximityNotificationService.access$200(ProximityNotificationService.this).getLanguageFromLocale()
        }), arraylist.toArray());
    }
}
