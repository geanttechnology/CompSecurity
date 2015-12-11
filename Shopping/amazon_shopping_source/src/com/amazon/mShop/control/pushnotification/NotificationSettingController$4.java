// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.pushnotification;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsResponse;

// Referenced classes of package com.amazon.mShop.control.pushnotification:
//            NotificationSettingController, NotificationSubscriber

class sponse
    implements Runnable
{

    final NotificationSettingController this$0;
    final ServiceCall val$sc;
    final ToggleMarketplaceNotificationsResponse val$value;

    public void run()
    {
        if (NotificationSettingController.access$700(NotificationSettingController.this, val$sc))
        {
            NotificationSettingController.access$100(NotificationSettingController.this).onMarketplaceToggled(val$value.getMarketplaceId(), val$value.getMarketplaceSupportsNotifications().booleanValue());
            NotificationSettingController.access$800(NotificationSettingController.this);
        }
    }

    sponse()
    {
        this$0 = final_notificationsettingcontroller;
        val$sc = servicecall;
        val$value = ToggleMarketplaceNotificationsResponse.this;
        super();
    }
}
