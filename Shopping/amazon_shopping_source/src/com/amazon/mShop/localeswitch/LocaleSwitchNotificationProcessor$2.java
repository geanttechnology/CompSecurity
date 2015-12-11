// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import com.amazon.mShop.control.Cancellable;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitchNotificationProcessor

class oller
    implements Cancellable
{

    final LocaleSwitchNotificationProcessor this$0;
    final NotificationSettingController val$settingController;

    public void cancel()
    {
        val$settingController.cancel();
    }

    oller()
    {
        this$0 = final_localeswitchnotificationprocessor;
        val$settingController = NotificationSettingController.this;
        super();
    }
}
