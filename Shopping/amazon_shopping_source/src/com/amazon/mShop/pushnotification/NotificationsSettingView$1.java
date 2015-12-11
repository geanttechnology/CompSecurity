// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.pushnotification;


// Referenced classes of package com.amazon.mShop.pushnotification:
//            NotificationsSettingView, PushNotificationManager

class this._cls0
    implements Runnable
{

    final NotificationsSettingView this$0;

    public void run()
    {
        String s = PushNotificationManager.getInstance().getCurrentPushNotificationErrorId();
        showErrorDialog(s);
    }

    ()
    {
        this$0 = NotificationsSettingView.this;
        super();
    }
}
