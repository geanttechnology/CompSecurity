// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.pushnotification;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponse;

// Referenced classes of package com.amazon.mShop.control.pushnotification:
//            NotificationSettingController, NotificationSubscriber

class onse
    implements Runnable
{

    final NotificationSettingController this$0;
    final ServiceCall val$sc;
    final GetNotificationSubscriptionsResponse val$value;

    public void run()
    {
        if (NotificationSettingController.access$000(NotificationSettingController.this, val$sc))
        {
            NotificationSettingController.access$100(NotificationSettingController.this).onSubscriptionsReceived(val$value);
            NotificationSettingController.access$200(NotificationSettingController.this);
        }
    }

    onse()
    {
        this$0 = final_notificationsettingcontroller;
        val$sc = servicecall;
        val$value = GetNotificationSubscriptionsResponse.this;
        super();
    }
}
