// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.util.GrouponSafeAsyncTask;
import com.groupon.util.NotificationFactory;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            ProximityNotificationService

class tail extends GrouponSafeAsyncTask
{

    final ProximityNotificationService this$0;
    final com.groupon.util.nDetail val$details;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        ProximityNotificationService.access$100(ProximityNotificationService.this).sendLocalNotification(ProximityNotificationService.this, val$details);
        Ln.d("Proximity_Notifications: Sending notification", new Object[0]);
        return null;
    }

    tail()
    {
        this$0 = final_proximitynotificationservice;
        val$details = com.groupon.util.nDetail.this;
        super();
    }
}
