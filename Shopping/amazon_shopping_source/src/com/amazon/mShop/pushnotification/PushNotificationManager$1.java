// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import android.util.Log;
import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            PushNotificationManager

class 
    implements Runnable
{

    final PushNotificationManager this$0;
    final NotificationTarget val$notificationTarget;

    public void run()
    {
        if (PushNotificationManager.access$000())
        {
            Log.d(PushNotificationManager.TAG, (new StringBuilder()).append("curent registration id::").append(val$notificationTarget.getDestination()).toString());
        }
        updateDeviceToken(val$notificationTarget.getDestination());
    }

    ()
    {
        this$0 = final_pushnotificationmanager;
        val$notificationTarget = NotificationTarget.this;
        super();
    }
}
