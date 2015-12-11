// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;

import com.amazon.mShop.TaskCallbackFactory;
import com.amazon.mShop.control.pushnotification.NotificationSettingController;

// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView, PushNotificationManager

class this._cls0
    implements com.amazon.mShop.error.oxActionListener
{

    final NotificationsSettingView this$0;

    public void onActionButtonClick(int i)
    {
        Object obj = PushNotificationManager.getInstance();
        if (NotificationsSettingView.access$400(NotificationsSettingView.this) != null)
        {
            NotificationsSettingView.access$900(NotificationsSettingView.this, NotificationsSettingView.access$400(NotificationsSettingView.this), ((PushNotificationManager) (obj)).getCurrentMShopDeviceToken());
            return;
        } else
        {
            obj = ((PushNotificationManager) (obj)).getNewNotificationTarget(null);
            NotificationsSettingView.access$700(NotificationsSettingView.this).getNotificationSubscriptions(((com.amazon.rio.j2me.client.services.mShop.NotificationTarget) (obj)), (new TaskCallbackFactory(NotificationsSettingView.access$100(NotificationsSettingView.this))).getTaskCallback(NotificationsSettingView.this, com.amazon.mShop.android.lib.ew));
            return;
        }
    }

    Controller()
    {
        this$0 = NotificationsSettingView.this;
        super();
    }
}
