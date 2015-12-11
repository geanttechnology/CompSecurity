// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.pushnotification;

import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.mShop.control.pushnotification:
//            NotificationSettingController, NotificationSubscriber

class val.sc
    implements Runnable
{

    final NotificationSettingController this$0;
    final ServiceCall val$sc;

    public void run()
    {
        if (NotificationSettingController.access$300(NotificationSettingController.this, val$sc))
        {
            NotificationSettingController.access$100(NotificationSettingController.this).onSubscriptionUpdated();
            NotificationSettingController.access$400(NotificationSettingController.this);
        }
    }

    ()
    {
        this$0 = final_notificationsettingcontroller;
        val$sc = ServiceCall.this;
        super();
    }
}
